package com.fcc.notebook.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fcc.notebook.bean.noteInfo;
import com.fcc.notebook.bean.shareInfo;
import com.fcc.notebook.service.NoteService;
import com.fcc.notebook.service.ShareService;
import com.fcc.notebook.utils.Message;

@Controller
public class ShareController {
	@Autowired
	ShareService shareService;
	@Autowired
	NoteService noteService;
	
	//分享笔记
	@RequestMapping(value = "/note/share", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message share(@RequestParam(value = "noteId", required = false) int noteId,
			@RequestParam(value = "userId", required = false) int userId,
			@RequestParam(value = "isEdit", required = false) Boolean isEdit,
			@RequestParam(value = "isComment", required = false) Boolean isComment
		) {
		
		noteInfo note = noteService.select(noteId);
		String storeUrl = note.getStoreurl();
		shareInfo shareinfo = new shareInfo();
	    shareinfo.setNoteid(noteId);
	    shareinfo.setUserid(userId);
	    shareinfo.setIscomment(isComment);
	    shareinfo.setIsedit(isEdit);
	    shareinfo.setStoreurl(storeUrl);
		Date time = new Date();
	    shareinfo.setSharetime(time);
		shareService.insert(shareinfo);
		return Message.createSuc("笔记分享成功");
	}
}
