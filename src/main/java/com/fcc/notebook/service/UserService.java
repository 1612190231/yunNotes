package com.fcc.notebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcc.notebook.bean.userInfo;
import com.fcc.notebook.dao.userInfoMapper;

@Service
public class UserService {
	@Autowired
	userInfoMapper userInfoMapper;
	
	//获取所有用户信息
	public List<userInfo> getAll() {
		// TODO Auto-generated method stub
		return userInfoMapper.selectByExample(null);
	}
	
	//注册
	public int insert(userInfo userinfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.insert(userinfo);
	}
	
	//更改密码
	public int update(userInfo userinfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.updateByPrimaryKey(userinfo);
	}
	
	//获取单个用户信息
	public userInfo select(int userid) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectByPrimaryKey(userid);
	}
}
