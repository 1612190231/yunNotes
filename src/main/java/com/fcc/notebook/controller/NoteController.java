package com.fcc.notebook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fcc.notebook.bean.noteInfo;
import com.fcc.notebook.service.NoteService;
import com.fcc.notebook.utils.JWTUtil;
import com.fcc.notebook.utils.Message;

@Controller
public class NoteController {
	@Autowired
	NoteService noteService;

	// 新建笔记
	@RequestMapping(value = "/note/add", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message addNote(
			HttpServletRequest request,
			@RequestParam(value = "noteName", required = false) String noteName,
			@RequestParam(value = "userUrl", required = false) String userUrl) throws IOException {
		String token = request.getHeader("accessToken");
		String id = JWTUtil.getUserId(token);
		int userId = Integer.valueOf(id);
		
		System.out.println(token);
		System.out.println(id);
		System.out.println(userId);
		System.out.println(noteName);
		System.out.println(userUrl);
		
		String storeUrl = "D:\\Users\\lu\\Desktop\\Note\\store\\" + userId + "\\" + noteName + ".txt";
		File distFile = new File(storeUrl);
		if (!distFile.exists())
			distFile.createNewFile();

		userUrl=userUrl.substring(0,userUrl.length()-1);
		
		noteInfo noteinfo = new noteInfo();
		noteinfo.setUserurl(userUrl);
		noteinfo.setStoreurl(storeUrl);
		noteinfo.setUserid(userId);
		noteinfo.setNotename(noteName);
		noteinfo.setRecycleurl("");
		noteinfo.setPhotourl("");
		noteinfo.setIsdelete(0);
		noteinfo.setLength(0.0);
		Date time = new Date();
		noteinfo.setUpdatetime(time);
		noteService.insert(noteinfo);
		
		return Message.createSuc("新建笔记成功");
	}

	// 修改笔记
	@RequestMapping(value = "/note/update", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message updateNote(HttpServletRequest request,
			@RequestParam(value = "noteId", required = false) int noteId,
			@RequestParam(value = "content", required = false) String content) {

		System.out.println(noteId);
		if (noteId == 0) {
			return Message.createErr("ID为空");
		}

		noteInfo note = noteService.select(noteId);
		String storeUrl = note.getStoreurl();

		File file = new File(storeUrl);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("");
			fileWriter.write(content);
			fileWriter.flush();
			fileWriter.close();
			System.out.println("文件已更改");
		} catch (IOException e) {
			e.printStackTrace();
		}

		noteInfo noteinfo = noteService.select(noteId);
		noteinfo.setStoreurl(storeUrl);
		Date time = new Date();
		noteinfo.setUpdatetime(time);

		return Message.createSuc(noteService.update(noteinfo));
	}
	
	//文件重命名
	@RequestMapping(value = "/note/Rename", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message renameNote(
			HttpServletRequest request,
			@RequestParam(value = "noteId", required = false) int noteId,
			@RequestParam(value = "noteName", required = false) String noteName) {

		System.out.println(noteId);
		if (noteId == 0) {
			return Message.createErr("ID为空");
		}
		
		noteInfo noteinfo = noteService.select(noteId);
		noteinfo.setNotename(noteName);
		Date time = new Date();
		noteinfo.setUpdatetime(time);

		return Message.createSuc(noteService.update(noteinfo));
	}

	// 查询指定路径笔记
	@RequestMapping(value = "/note/select", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message selectNote(
			HttpServletRequest request,
			@RequestParam(value = "noteId", required = false) int noteId) {
		System.out.println(noteId);
		noteInfo noteinfo = noteService.select(noteId);
		if (noteinfo == null)
			return Message.createErr("访问出错");
		String url = noteinfo.getStoreurl();
		String str = "";
		File file = new File(url);
		try {
			FileInputStream in = new FileInputStream(file);
			// size 为字串的长度 ，这里一次性读完
			int size = in.available();
			byte[] buffer = new byte[size];
			in.read(buffer);
			in.close();
			str = new String(buffer, "GB2312");
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return Message.createSuc(str);
	}

	//移动文件
	@RequestMapping(value = "/note/move", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message moveNote(
			HttpServletRequest request,
			@RequestParam(value = "noteId", required = false) int noteId,
			@RequestParam(value = "userUrl", required = false) String userUrl) {

		userUrl=userUrl.substring(0,userUrl.length()-1);
		
		System.out.println(noteId);
		if (noteId == 0) {
			return Message.createErr("ID为空");
		}
		
		noteInfo noteinfo = noteService.select(noteId);
		noteinfo.setUserurl(userUrl);
		Date time = new Date();
		noteinfo.setUpdatetime(time);

		return Message.createSuc(noteService.update(noteinfo));
	}
	
	// 删除笔记（到回收站）
	@RequestMapping(value = "/note/delete", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message deleteNote(
			HttpServletRequest request,
			@RequestParam(value = "noteId", required = false) int noteId,
			@RequestParam(value = "noteName", required = false) String noteName) throws IOException {
		
		String token = request.getHeader("accessToken");
		String id = JWTUtil.getUserId(token);
		int userId = Integer.valueOf(id);

		String recycleUrl = "D:\\Users\\lu\\Desktop\\Note\\recycle\\" + userId + "\\" + noteName + ".txt";
		File distFile = new File(recycleUrl);
		noteInfo note = noteService.select(noteId);
		File distFile2 = new File(note.getStoreurl());
		try {
			if (!distFile.exists())
				distFile.createNewFile();
			if (distFile2.exists())
				distFile2.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		note.setRecycleurl(recycleUrl);
		note.setUserrecycle("recycle\\" + userId);
		note.setNotename(noteName);
		note.setIsdelete(1);
		Date time = new Date();
		note.setUpdatetime(time);
		noteService.update(note);
		System.out.println(recycleUrl);
		System.out.println("笔记删除成功");
		return Message.createSuc("已将笔记删除至回收站");
	}

	// 恢复笔记
	@RequestMapping(value = "/note/recover", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message recoverNote(
			HttpServletRequest request,
			@RequestParam(value = "noteId", required = false) int noteId) throws IOException {

		if (noteId == 0) {
			return Message.createErr("ID为空");
		}

		noteInfo note = noteService.select(noteId);
		String storeUrl = note.getStoreurl();
		String recycleUrl = note.getRecycleurl();
		File distFile = new File(storeUrl);
		File distFile2 = new File(recycleUrl);
		System.out.println(recycleUrl);
		try {
			if (!distFile.exists())
				distFile.createNewFile();
			else return Message.createErr("笔记恢复失败");
			if (distFile2.exists())
				distFile2.delete();
			else return Message.createErr("笔记删除失败");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Date time = new Date();
		note.setUpdatetime(time);
		note.setRecycleurl("");
		note.setUserrecycle("");
		note.setIsdelete(0);
		noteService.update(note);
		System.out.println("笔记恢复成功");
		return Message.createSuc("已将笔记恢复");
	}

	// 删除笔记（永久）
	@RequestMapping(value = "/note/deleteforevermore", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message deleteNoteForevermore(
			HttpServletRequest request,
			@RequestParam(value = "noteId", required = false) int noteId)
			throws IOException {

		if (noteId == 0) {
			return Message.createErr("ID为空");
		}

		noteInfo note = noteService.select(noteId);
		String recycleUrl = note.getRecycleurl();
		File file = new File(recycleUrl);
		try {
			if (file.exists()) {
				file.delete();
			}
			else return Message.createErr("笔记永久删除失败");
			System.out.println("笔记已永久删除");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Message.createSuc(noteService.delete(noteId));
	}

}
