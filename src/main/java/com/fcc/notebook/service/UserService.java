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
	
	//��ȡ�����û���Ϣ
	public List<userInfo> getAll() {
		// TODO Auto-generated method stub
		return userInfoMapper.selectByExample(null);
	}
	
	//ע��
	public int insert(userInfo userinfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.insert(userinfo);
	}
	
	//��������
	public int update(userInfo userinfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.updateByPrimaryKey(userinfo);
	}
	
	//��ȡ�����û���Ϣ
	public userInfo select(int userid) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectByPrimaryKey(userid);
	}
}
