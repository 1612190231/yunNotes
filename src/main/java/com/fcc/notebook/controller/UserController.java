package com.fcc.notebook.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fcc.notebook.bean.fileInfo;
import com.fcc.notebook.bean.userInfo;
import com.fcc.notebook.service.FileService;
import com.fcc.notebook.service.NoteService;
import com.fcc.notebook.service.UserService;
import com.fcc.notebook.utils.JWTUtil;
import com.fcc.notebook.utils.Message;
import com.fcc.notebook.utils.Node;

@Controller
public class UserController {
	@Autowired
	UserService userInfoService;
	@Autowired
	NoteService noteInfoService;
	@Autowired
	FileService fileInfoService;
	
	// 登录
	@RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message isTrue(
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "password", required = false) String password) {
		System.out.println(userName);
		System.out.println(password);

		if (userName == null || password == null) {
			return Message.createErr("用户名或密码为空");
		}

		List<userInfo> user = userInfoService.getAll();
		int i, j;
		int count = user.size();
		for (i = 0; i < count; i++) {
			userInfo userInfo = user.get(i);
			String a = userInfo.getUsername();
			String b = userInfo.getPassword();
			if (userName.equals(a) && password.equals(b)) {
				Map<String, Object> data = new HashMap<String, Object>();
				int userId = userInfo.getUserid();
				String token = JWTUtil.sign(userName, userId);

				// 查询用户目录路径
				Node root = null;
				List<Node> nodes = new ArrayList<>();
				List<fileInfo> user_file = fileInfoService.selectByUser(userId);

				if (user_file.isEmpty()) { // 新增根目录
					fileInfo fileInfo = new fileInfo();
					fileInfo.setFilename("我的资源");
					fileInfo.setFilenum("1-1");
					fileInfo.setFileparent(-1);
					fileInfo.setFileurl("1-1");
					fileInfo.setUserid(userId);
					fileInfo.setChildnum(0);
					fileInfoService.insert(fileInfo);
					root = new Node(1, "我的资源", -1, "1-1");
					nodes.add(root);
					System.out.println("新增根目录");
				} 
				else {
					System.out.println("存在目录");
					for (j = 0; j < user_file.size(); j++) {
						fileInfo file = user_file.get(j);
						if (file.getFileparent() == -1) {
							root = new Node(file.getFileid(), file.getFilename(), -1, file.getFilenum());
							nodes.add(root);
						}
						else nodes.add(new Node(file.getFileid(), file.getFilename(), file.getFileparent(), file.getFilenum()));
					}
				}
				
				HashMap<Integer, Node> nodeMap = new HashMap<>();
				// 初始化HashMap
				for (Node node : nodes) {
					nodeMap.put(node.getId(), node);
				}
				// 遍历添加
				for (Node node : nodes) {
					// 如果确定parentId一定存在去除此条件
					if (nodeMap.containsKey(node.getParentId())) {
						nodeMap.get(node.getParentId()).addChild(node);
					}
				}
				if (root == null) return Message.createErr("目录加载出错");
				
				data.put("token", token);
				data.put("root", root);
				return Message.createSuc(data);
			}
		}
		return Message.createErr("用户名或密码错误");
	}

	// 注册
	@RequestMapping(value = "/register", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message register(@RequestParam(value = "userName", required = false) String name,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "mailAddress", required = false) String mailAddress) {

		System.out.println(name);
		System.out.println(password);
		System.out.println(mailAddress);

		if (name == null || password == null || mailAddress == null) {
			return Message.createErr("用户名、密码或邮箱为空");
		}

		List<userInfo> user = userInfoService.getAll();
		int count = user.size();
		for (int i = 0; i < count; i++) {
			userInfo userInfo1 = user.get(i);
			String a = userInfo1.getMailaddress();
			if (mailAddress.equals(a)) {
				return Message.createErr("邮箱重复注册");
			}
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间

		userInfo userinfo = new userInfo();
		userinfo.setUsername(name);
		userinfo.setPassword(password);
		userinfo.setMailaddress(mailAddress);
		userinfo.setRegistertime(time);
		userinfo.setStorespace((float)0);
		userinfo.setSignature("未填写");
		userinfo.setCity("未填写");
		userinfo.setProvince("未填写");
		userinfo.setTelephone("未填写");
		userinfo.setSex("未填写");
		userinfo.setNickname("未填写");

		return Message.createSuc(userInfoService.insert(userinfo));
	}

	// 找回密码
	@RequestMapping(value = "/backpwd", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message backPwd(@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "mailAddress", required = false) String mailAddress) {

		System.out.println(userName);
		System.out.println(mailAddress);

		if (userName == null || mailAddress == null) {
			return Message.createErr("用户名或密码为空");
		}

		List<userInfo> user = userInfoService.getAll();
		int count = user.size();
		for (int i = 0; i < count; i++) {
			userInfo userInfo1 = user.get(i);
			String a = userInfo1.getUsername();
			String b = userInfo1.getMailaddress();
			if (userName.equals(a) && mailAddress.equals(b)) {
				System.out.println(a + 1);
				System.out.println(b + 2);
				return Message.createSuc(1);
			}
		}
		return Message.createErr("用户名或邮箱错误");
	}

	// 更改密码
	@RequestMapping(value = "/updatepwd", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message updatepwd(@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "mailAddress", required = false) String mailAddress,
			@RequestParam(value = "password", required = false) String password) {

		System.out.println(userName);
		System.out.println(mailAddress);

		if (userName == null || mailAddress == null) {
			return Message.createErr("用户名或密码为空");
		}

		List<userInfo> user = userInfoService.getAll();
		System.out.println(user);
		int count = user.size();
		for (int i = 0; i < count; i++) {
			userInfo userInfo1 = user.get(i);
			String a = userInfo1.getUsername();
			String b = userInfo1.getMailaddress();
			if (userName.equals(a) && mailAddress.equals(b)) {
				userInfo User = new userInfo();
				userInfo userinfo = new userInfo();
				User = user.get(i);

				userinfo.setUserid(User.getUserid());
				if (User.getMailaddress() != null)
					userinfo.setMailaddress(User.getMailaddress());
				if (User.getRegistertime() != null)
					userinfo.setRegistertime(User.getRegistertime());
				if (User.getSex() != null)
					userinfo.setSex(User.getSex());
				if (User.getUsername() != null)
					userinfo.setUsername(User.getUsername());
				if (User.getTelephone() != null)
					userinfo.setTelephone(User.getTelephone());
				userinfo.setPassword(password);

				return Message.createSuc(userInfoService.update(userinfo));
			}
		}
		return Message.createErr("更改失败");
	}

	// 注销
	@RequestMapping(value = "/logout", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message logout() {

		return Message.createErr("退出成功");
	}

	// 修改阅读密码
	@RequestMapping(value = "/readPassword", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message updateInfo(HttpServletRequest request,

			@RequestParam(value = "readPassword", required = false) String readPsd,
			@RequestParam(value = "password", required = false) String psd) {

		String token = request.getHeader("accessToken");
		String id = JWTUtil.getUserId(token);
		int userId = Integer.valueOf(id);
		System.out.println(userId);
		System.out.println(readPsd);
		System.out.println(psd);

		userInfo user = userInfoService.select(userId);
		String readpsd = user.getReadpassword();
		System.out.println(readpsd);
		if (readpsd.equals(readPsd)) {
			user.setReadpassword(psd);
			return Message.createSuc(userInfoService.update(user));
		}

		return Message.createErr("原密码错误或两次密码不符");

	}

	// 修改个人信息
	@RequestMapping(value = "/information", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message updateReadPsd(HttpServletRequest request,
			@RequestParam(value = "nickName", required = false) String name,
			@RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "signature", required = false) String signature) {
		List<userInfo> user = userInfoService.getAll();
		String token = request.getHeader("accessToken");
		String id = JWTUtil.getUserId(token);
		int userId = Integer.valueOf(id);
		int count = user.size();
		for (int i = 0; i < count; i++) {
			userInfo userInfo1 = user.get(i);
			int a = userInfo1.getUserid();
			System.out.println(a);
			System.out.println(id);
			if (a == userId) {
				userInfo User = new userInfo();
				userInfo userinfo = new userInfo();
				User = user.get(i);
				userinfo.setUserid(User.getUserid());
				if (User.getUsername() != null)
					userinfo.setUsername(User.getUsername());
				userinfo.setNickname(name);
				userinfo.setImageurl("未填写");
				if (User.getPassword() != null)
					userinfo.setPassword(User.getPassword());
				if (User.getReadpassword() != null)
					userinfo.setReadpassword(User.getReadpassword());
				userinfo.setSex(sex);
				if (User.getRegistertime() != null)
					userinfo.setRegistertime(User.getRegistertime());
				if (User.getTelephone() != null)
					userinfo.setTelephone(User.getTelephone());
				if (User.getMailaddress() != null)
					userinfo.setMailaddress(User.getMailaddress());
				userinfo.setProvince("无省份");
				userinfo.setCity(city);
				userinfo.setSignature(signature);
				if (User.getStorespace() != null)
					userinfo.setStorespace(User.getStorespace());
				System.out.println(name);
				return Message.createSuc(userInfoService.update(userinfo));
			}

		}
		return Message.createErr("0");

	}

	// 查看我的资料
	@RequestMapping(value = "/user/info", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message selectUser(HttpServletRequest request) {
		String token = request.getHeader("accessToken");
		String id = JWTUtil.getUserId(token);
		int userId = Integer.valueOf(id);

		System.out.println(userId);

		userInfo user = userInfoService.select(userId);
		if (user == null) {
			return Message.createErr("无对应用户信息");
		}
		return Message.createSuc(user);

	}

	// 绑定手机
	@RequestMapping(value = "/telephone", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message updateTel(HttpServletRequest request, @RequestParam(value = "telephone", required = false) String tel

	) {
		System.out.println(tel);
		String token = request.getHeader("accessToken");
		String id = JWTUtil.getUserId(token);
		int userId = Integer.valueOf(id);

		List<userInfo> user = userInfoService.getAll();
		int count = user.size();
		for (int i = 0; i < count; i++) {
			userInfo userInfo1 = user.get(i);
			int a = userInfo1.getUserid();
			if (a == userId) {
				System.out.println(tel);
				userInfo User = new userInfo();
				userInfo userinfo = new userInfo();
				User = user.get(i);
				userinfo.setUserid(User.getUserid());
				if (User.getUsername() != null)
					userinfo.setUsername(User.getUsername());
				if (User.getNickname() != null)
					userinfo.setNickname(User.getNickname());
				if (User.getImageurl() != null)
					userinfo.setImageurl(User.getImageurl());
				if (User.getPassword() != null)
					userinfo.setPassword(User.getPassword());
				userinfo.setTelephone(tel);
				if (User.getSex() != null)
					userinfo.setSex(User.getSex());
				if (User.getRegistertime() != null)
					userinfo.setRegistertime(User.getRegistertime());
				if (User.getReadpassword() != null)
					userinfo.setReadpassword(User.getReadpassword());
				if (User.getMailaddress() != null)
					userinfo.setMailaddress(User.getMailaddress());
				if (User.getProvince() != null)
					userinfo.setProvince(User.getProvince());
				if (User.getCity() != null)
					userinfo.setCity(User.getCity());
				if (User.getSignature() != null)
					userinfo.setSignature(User.getSignature());
				if (User.getStorespace() != null)
					userinfo.setStorespace(User.getStorespace());
				return Message.createSuc(userInfoService.update(userinfo));
			}

		}
		return Message.createErr("0");

	}

}