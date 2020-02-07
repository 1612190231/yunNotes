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

	//�½��ļ���
	public int insert(fileInfo fileInfo) {
		// TODO Auto-generated method stub
		return fileInfoMapper.insert(fileInfo);
	}
	
	//��ѯָ���û��ļ���
	public List<fileInfo> selectByUser(int userId) {
		// TODO Auto-generated method stub
	    fileInfoExample example = new fileInfoExample();
		example.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		fileInfoExample.Criteria criteria = example.createCriteria();
	    criteria.andUseridEqualTo(userId); 
		return fileInfoMapper.selectByExample(example);
	}
	
	//��ѯָ��·���ļ���
	public List<fileInfo> selectByUrl(String fileUrl) {
		// TODO Auto-generated method stub
	    fileInfoExample example = new fileInfoExample();
		example.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		fileInfoExample.Criteria criteria = example.createCriteria();
	    criteria.andFileurlEqualTo(fileUrl);
		return fileInfoMapper.selectByExample(example);
	}
	
	//��ѯ�ļ���
	public fileInfo select(int fileId) {
		// TODO Auto-generated method stub
		return fileInfoMapper.selectByPrimaryKey(fileId);
	}
	
	//�����ļ���
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
			// �ļ�����·��
			String filePath = FileConstant.getUploadPath() + File.separator + type;
			File desFile = new File(filePath);
			if (!desFile.exists()) {
				desFile.mkdirs();
			}
			filePath = filePath + File.separator + newName;

			noteInfo note = noteInfoMapper.selectByPrimaryKey(noteId);
			note.setPhotourl(filePath);

			// ת���ļ�
			file.transferTo(new File(filePath));
			return FileConstant.VIEW_PATH + type + "/" + newName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//ɾ���ʼ�
	public int delete(int fileId) {
		// TODO Auto-generated method stub
		return fileInfoMapper.deleteByPrimaryKey(fileId);
	}
	
	public String uploadFile(MultipartFile file, String weburl) throws IOException {
		// Logger logger = Logger.getLogger(UploadImg.class);

		if (file == null)
			return null;

		// ��ȡ�ϴ��ļ���ԭʼ����
		String originalFilename = file.getOriginalFilename();
		String newFileName = "";
		String pic_path;
		String url = null;

		// �ϴ�ͼƬ
		if (originalFilename != null && originalFilename.length() > 0) {
			
			// ��ȡTomcat���������ڵ�·��
			//String tomcat_path = System.getProperty("user.dir");
			//System.out.println(tomcat_path);

			// ��ȡTomcat����������·�������һ���ļ�Ŀ¼
			//String bin_path = tomcat_path.substring(tomcat_path.lastIndexOf("\\") + 1, tomcat_path.length());
			//System.out.println(bin_path);

			// �����һ���ļ�Ŀ¼ΪbinĿ¼���������Ϊ�ֶ�����
			/*if (("bin").equals(bin_path)) {// �ֶ�����Tomcatʱ��ȡ·��Ϊ��D:\Software\Tomcat-8.5\bin
				// ��ȡ�����ϴ�ͼƬ���ļ�·��
				pic_path = tomcat_path.substring(0, System.getProperty("user.dir").lastIndexOf("\\")) + "\\webapps"
						+ "\\image\\";
			} else {// ������������Tomcatʱ��ȡ·��Ϊ��D:\Software\Tomcat-8.5
				pic_path = tomcat_path + "\\webapps" + "\\image\\" + noteId + "\\";
			}*/

			// �µ�ͼƬ����
			newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// logger.info("�ϴ�ͼƬ��·����" + pic_path + newFileName);

			// ��ͼƬ
			url = weburl + "image\\" + newFileName;
			System.out.println("url:  " + url);

			// ���ڴ��е�����д�����
			file.transferTo(new File(url));
		}
		return newFileName;
	}
}
