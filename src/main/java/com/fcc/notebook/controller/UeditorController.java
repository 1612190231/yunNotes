package com.fcc.notebook.controller;

import com.fcc.notebook.constant.FileConstant;
import com.fcc.notebook.utils.JWTUtil;
import com.fcc.notebook.utils.Message;
import com.fcc.notebook.utils.ResultData;
import com.fcc.notebook.service.FileService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UeditorController {

    @Autowired
    FileService fileService;

    @RequestMapping("/upload/FileCommon")
    @ResponseBody
    public Message uploadFileCommon(
    		@RequestParam(value="type", required = false) Integer type, 
    		@RequestParam(value="noteId", required = false) int noteId,
    		@RequestParam(value="file", required = false)MultipartFile file){
        String url = fileService.saveFile(FileConstant.FileTypeEnum.getFileType(type), file, noteId);
        return Message.createSuc(url);
    }

    @RequestMapping(value = "/upload/yImgForCkeditor")
    @ResponseBody
    public ResultData uploadImgForCkeditor(
    		@RequestParam(value="upload", required = false) MultipartFile upload,
    		HttpSession session) throws IOException{
    	if (upload == null) return ResultData.createErr();
    	String weburl = session.getServletContext().getRealPath("/");
    	System.out.println("weburl:  " + weburl);
        //String url = fileService.saveFile(FileConstant.FileTypeEnum.getFileType(1), upload, 1);
        String fileName = fileService.uploadFile(upload, weburl);
        String url = null;
        System.out.println("url:  " + url);
        url = "http:\\\\23861cw743.wicp.vip:53364\\image\\" + fileName;
        System.out.println("url:  " + url);
        return ResultData.createSuc(url);
    }
}
