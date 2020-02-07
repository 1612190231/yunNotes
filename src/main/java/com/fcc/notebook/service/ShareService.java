package com.fcc.notebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcc.notebook.bean.shareInfo;
import com.fcc.notebook.dao.shareInfoMapper;


@Service
public class ShareService {
	@Autowired
	shareInfoMapper shareInfoMapper;
	
	//�½��ʼ�
	public int insert(shareInfo shareinfo) {
		// TODO Auto-generated method stub
		return shareInfoMapper.insert(shareinfo);
	}
	
	
	//��ѯ�ʼ�
	public shareInfo select(int shareId) {
		// TODO Auto-generated method stub
		return shareInfoMapper.selectByPrimaryKey(shareId);
	}
	
	
	//���±ʼ�
	public int update(shareInfo shareInfo) {
		// TODO Auto-generated method stub
		return shareInfoMapper.updateByPrimaryKey(shareInfo);
	}
	
	//ɾ���ʼ�
	public int delete(int noteId) {
		// TODO Auto-generated method stub
		return shareInfoMapper.deleteByPrimaryKey(noteId);
	}
	
}

