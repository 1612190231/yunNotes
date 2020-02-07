package com.fcc.notebook.service;

import com.fcc.notebook.bean.fileInfo;
import com.fcc.notebook.bean.fileInfoExample;
import com.fcc.notebook.bean.noteInfo;
import com.fcc.notebook.constant.FileConstant;
import com.fcc.notebook.dao.noteInfoMapper;
import com.fcc.notebook.dao.fileInfoMapper;
import com.fcc.notebook.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {
	@Autowired
	noteInfoMapper noteInfoMapper;
	@Autowired
	fileInfoMapper fileInfoMapper;

	//新建文件夹
	public int insert(fileInfo fileInfo) {
		// TODO Auto-generated method stub
		return fileInfoMapper.insert(fileInfo);
	}
	
	//查询指定用户文件夹
	public List<fileInfo> selectByUser(int userId) {
		// TODO Auto-generated method stub
	    fileInfoExample example = new fileInfoExample();
		example.setDistinct(false); //去除重复,true是选择不重复记录,false反之
		fileInfoExample.Criteria criteria = example.createCriteria();
	    criteria.andUseridEqualTo(userId); 
		return fileInfoMapper.selectByExample(example);
	}
	
	//查询指定路径文件夹
	public List<fileInfo> selectByUrl(String fileUrl) {
		// TODO Auto-generated method stub
	    fileInfoExample example = new fileInfoExample();
		example.setDistinct(false); //去除重复,true是选择不重复记录,false反之
		fileInfoExample.Criteria criteria = example.createCriteria();
	    criteria.andFileurlEqualTo(fileUrl);
		return fileInfoMapper.selectByExample(example);
	}
	
	//查询文件夹
	public fileInfo select(int fileId) {
		// TODO Auto-generated method stub
		return fileInfoMapper.selectByPrimaryKey(fileId);
	}
	
	//更新文件夹
	public int update(fileInfo fileinfo) {
		// TODO Auto-generated method stub
		return fileInfoMapper.updateByPrimaryKey(fileinfo);
	}
	
	public String saveFile(String type, MultipartFile file, int noteId) {
		if (null == file) 
			return null;
		if (StringUtils.isBlank(type)) {
			type = FileConstant.COMMON_UPLOAD_PATH;
		}
		try {
			String oldName = file.getOriginalFilename();
			String prefix = oldName.substring(oldName.lastIndexOf(".") + 1);
			prefix = "." + prefix;
			String newName = UUID.randomUUID().toString() + prefix;
			// 文件保存路径
			String filePath = FileConstant.getUploadPath() + File.separator + type;
			File desFile = new File(filePath);
			if (!desFile.exists()) {
				desFile.mkdirs();
			}
			filePath = filePath + File.separator + newName;

			noteInfo note = noteInfoMapper.selectByPrimaryKey(noteId);
			note.setPhotourl(filePath);

			// 转存文件
			file.transferTo(new File(filePath));
			return FileConstant.VIEW_PATH + type + "/" + newName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//删除笔记
	public int delete(int fileId) {
		// TODO Auto-generated method stub
		return fileInfoMapper.deleteByPrimaryKey(fileId);
	}
	
	public String uploadFile(MultipartFile file, String weburl) throws IOException {
		// Logger logger = Logger.getLogger(UploadImg.class);

		if (file == null)
			return null;

		// 获取上传文件的原始名称
		String originalFilename = file.getOriginalFilename();
		String newFileName = "";
		String pic_path;
		String url = null;

		// 上传图片
		if (originalFilename != null && originalFilename.length() > 0) {
			
			// 获取Tomcat服务器所在的路径
			//String tomcat_path = System.getProperty("user.dir");
			//System.out.println(tomcat_path);

			// 获取Tomcat服务器所在路径的最后一个文件目录
			//String bin_path = tomcat_path.substring(tomcat_path.lastIndexOf("\\") + 1, tomcat_path.length());
			//System.out.println(bin_path);

			// 若最后一个文件目录为bin目录，则服务器为手动启动
			/*if (("bin").equals(bin_path)) {// 手动启动Tomcat时获取路径为：D:\Software\Tomcat-8.5\bin
				// 获取保存上传图片的文件路径
				pic_path = tomcat_path.substring(0, System.getProperty("user.dir").lastIndexOf("\\")) + "\\webapps"
						+ "\\image\\";
			} else {// 服务中自启动Tomcat时获取路径为：D:\Software\Tomcat-8.5
				pic_path = tomcat_path + "\\webapps" + "\\image\\" + noteId + "\\";
			}*/

			// 新的图片名称
			newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// logger.info("上传图片的路径：" + pic_path + newFileName);

			// 新图片
			url = weburl + "image\\" + newFileName;
			System.out.println("url:  " + url);

			// 将内存中的数据写入磁盘
			file.transferTo(new File(url));
		}
		return newFileName;
	}
}
