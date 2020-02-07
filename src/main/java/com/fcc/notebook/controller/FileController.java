package com.fcc.notebook.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fcc.notebook.bean.fileInfo;
import com.fcc.notebook.bean.noteInfo;
import com.fcc.notebook.service.FileService;
import com.fcc.notebook.service.NoteService;
import com.fcc.notebook.utils.JWTUtil;
import com.fcc.notebook.utils.Message;
import com.fcc.notebook.utils.Node;

@Controller
public class FileController {
	@Autowired
	FileService fileService;
	@Autowired
	NoteService noteService;
	
	
	//�½��ļ���
	@RequestMapping(value="/file/add",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public  Message addFile(
			HttpServletRequest request,
			@RequestParam(value = "fileName", required = false) String fileName,
			@RequestParam(value="fileUrl",required=false)String fileUrl
			) {
		String token = request.getHeader("accessToken");
		String id = JWTUtil.getUserId(token);
		int userId = Integer.valueOf(id);
		
		System.out.println(fileName);
		System.out.println(token);
		System.out.println(id);
		
		if (fileName == null || fileUrl == null) {
			return Message.createErr("�½�ʧ��");
		}
		
		//�½��ļ���
		int i, j;
		String fileNum = "";
		fileInfo fileInfo = new fileInfo();
		
		fileUrl=fileUrl.substring(0,fileUrl.length()-1);
		String str[] = fileUrl.split("\\\\");
		String fileNum_init = str[str.length - 1];
		System.out.println(fileNum_init);
		
		List<fileInfo> file = fileService.selectByUser(userId);
		for (i=0; i<file.size(); i++) {
			int pre = str.length - 1;
			System.out.println(pre);
			String filenum = file.get(i).getFilenum();
			System.out.println(filenum);
			
			if (filenum.equals(str[pre])) {
				int num = file.get(i).getChildnum() + 1;
				fileNum = fileNum_init + '-' + num;
				file.get(i).setChildnum(num);
				fileService.update(file.get(i));
				
				fileInfo.setFileparent(file.get(i).getFileid());
				fileInfo.setFilenum(fileNum);
				fileInfo.setChildnum(0);
				break;
			}
			
		}
		if (i == file.size()) {
			return Message.createErr("�½�Ŀ¼����");
		}
		
		fileInfo.setFileurl(fileUrl + "\\" + fileNum);
		fileInfo.setFilename(fileName);
		fileInfo.setUserid(userId);
		fileService.insert(fileInfo);
		
		//��ѯ���º�Ŀ¼
		Node root = null;
		List<Node> nodes = new ArrayList<>();
		List<fileInfo> user_file = fileService.selectByUser(userId);

		System.out.println("Ŀ¼�Ѹ���");
		for (j = 0; j < user_file.size(); j++) {
			fileInfo File = user_file.get(j);
			if (File.getFileparent() == -1) {
				root = new Node(File.getFileid(), File.getFilename(), -1, File.getFilenum());
				nodes.add(root);
			}
			else nodes.add(new Node(File.getFileid(), File.getFilename(), File.getFileparent(), File.getFilenum()));
		}
		
		HashMap<Integer, Node> nodeMap = new HashMap<>();
		// ��ʼ��HashMap
		for (Node node : nodes) {
			nodeMap.put(node.getId(), node);
		}
		// �������
		for (Node node : nodes) {
			// ���ȷ��parentIdһ������ȥ��������
			if (nodeMap.containsKey(node.getParentId())) {
				nodeMap.get(node.getParentId()).addChild(node);
			}
		}
		return Message.createSuc(root);
		
	}
	
	//��ѯָ��·���ļ���
	@RequestMapping(value="/file/select",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public  Message selectNote(
			HttpServletRequest request,
			@RequestParam(value="selectUrl",required=false)String selectUrl
			) {
		String token = request.getHeader("accessToken");
		String id = JWTUtil.getUserId(token);
		int userId = Integer.valueOf(id);
		System.out.println(userId);
		
		List<noteInfo> noteinfo = noteService.selectByUser(userId);
		if (noteinfo == null) return Message.createErr("���ʳ���");
		String[] select = selectUrl.split("\\\\"); //����Ĳ�ѯ·��
		List<noteInfo> notes = new ArrayList<noteInfo> ();
		
		int i,j;
		System.out.println("---------start-----------");
		for (i=0;i<noteinfo.size();i++) {
			String storeUrl = noteinfo.get(i).getUserurl(); //����֤�Ĵ���·��
			if (storeUrl == null) continue;
			if (noteinfo.get(i).getIsdelete()==1) continue;
			String[] store = storeUrl.split("\\\\");
			for (j=0;j<select.length;j++) {
				if (j >= store.length) continue;
				if (select[j].equals(store[j])==false) break;
			}
			if (j == (store.length)) {
				notes.add(noteinfo.get(i));
				System.out.println("noteName:" + noteinfo.get(i).getNotename());
			}
		}
		System.out.println("----------end------------");
		if (notes.isEmpty()) return Message.createErr("������");
		return Message.createSuc(notes);
	}
	
	//��ѯ����վ�ļ�
	@RequestMapping(value="/recycle/select",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public  Message selectRecycle(
			HttpServletRequest request
			) {
		String token = request.getHeader("accessToken");
		String id = JWTUtil.getUserId(token);
		System.out.println(id);
		
		List<noteInfo> noteinfo = noteService.selectByRecycle("recycle\\" + id);
		if (noteinfo == null) return Message.createErr("���ʳ���");
		
		
		return Message.createSuc(noteinfo);
	}

	//�������ļ���
	@RequestMapping(value = "/file/Rename", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message renameFile(
			HttpServletRequest request,
			@RequestParam(value = "fileUrl", required = false) String fileUrl,
			@RequestParam(value = "fileName", required = false) String fileName) {

		fileUrl=fileUrl.substring(0,fileUrl.length()-1);
		
		System.out.println(fileUrl);
		System.out.println(fileName);
		if (fileUrl == null || fileUrl == "" || fileName == null) {
			return Message.createErr("�ļ���·��Ϊ��");
		}

		List<fileInfo> file = fileService.selectByUrl(fileUrl);
		int i, j;
		int id = -1;
		int userId = -1;
		for (i=0; i<file.size(); i++) {
			id = file.get(i).getFileid();
			userId = file.get(i).getUserid();
		}
		
		fileInfo fileinfo = fileService.select(id);
		fileinfo.setFilename(fileName);
		fileService.update(fileinfo);

		//����Ŀ¼
		Node root = null;
		List<Node> nodes = new ArrayList<>();
		List<fileInfo> user_file = fileService.selectByUser(userId);

		System.out.println("Ŀ¼�Ѹ���");
		for (j = 0; j < user_file.size(); j++) {
			fileInfo File = user_file.get(j);
			if (File.getFileparent() == -1) {
				root = new Node(File.getFileid(), File.getFilename(), -1, File.getFilenum());
				nodes.add(root);
			}
			else nodes.add(new Node(File.getFileid(), File.getFilename(), File.getFileparent(), File.getFilenum()));
		}
		
		HashMap<Integer, Node> nodeMap = new HashMap<>();
		// ��ʼ��HashMap
		for (Node node : nodes) {
			nodeMap.put(node.getId(), node);
		}
		// �������
		for (Node node : nodes) {
			// ���ȷ��parentIdһ������ȥ��������
			if (nodeMap.containsKey(node.getParentId())) {
				nodeMap.get(node.getParentId()).addChild(node);
			}
		}
		return Message.createSuc(root);
	}
	
	//ɾ���ļ���
	@RequestMapping(value = "/file/delete", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message deleteNoteForevermore(
			HttpServletRequest request,
			@RequestParam(value = "fileUrl", required = false) String fileUrl){

		fileUrl=fileUrl.substring(0,fileUrl.length()-1);
		System.out.println(fileUrl);
		
		if (fileUrl == null || fileUrl == "") {
			return Message.createErr("�ļ���·��Ϊ��");
		}

		List<fileInfo> file = fileService.selectByUrl(fileUrl);
		int i, j;
		int id;
		int userId = -1;
		for (i=0; i<file.size(); i++) {
			id = file.get(i).getFileid();
			userId = file.get(i).getUserid();
			if (fileService.delete(id) == 0) {
				return Message.createErr("ɾ���ļ��г���");
			}
		}
		System.out.println(userId);
		
		//��ѯ���º�Ŀ¼
		Node root = null;
		List<Node> nodes = new ArrayList<>();
		List<fileInfo> user_file = fileService.selectByUser(userId);

		System.out.println("Ŀ¼�Ѹ���");
		for (j = 0; j < user_file.size(); j++) {
			fileInfo File = user_file.get(j);
			if (File.getFileparent() == -1) {
				root = new Node(File.getFileid(), File.getFilename(), -1, File.getFilenum());
				nodes.add(root);
			}
			else nodes.add(new Node(File.getFileid(), File.getFilename(), File.getFileparent(), File.getFilenum()));
		}
		
		HashMap<Integer, Node> nodeMap = new HashMap<>();
		// ��ʼ��HashMap
		for (Node node : nodes) {
			nodeMap.put(node.getId(), node);
		}
		// �������
		for (Node node : nodes) {
			// ���ȷ��parentIdһ������ȥ��������
			if (nodeMap.containsKey(node.getParentId())) {
				nodeMap.get(node.getParentId()).addChild(node);
			}
		}
		return Message.createSuc(root);
	}
}
