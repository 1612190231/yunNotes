package com.fcc.notebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcc.notebook.bean.noteInfo;
import com.fcc.notebook.bean.noteInfoExample;
import com.fcc.notebook.dao.noteInfoMapper;

@Service
public class NoteService {
	@Autowired
	noteInfoMapper noteInfoMapper;
	
	//�½��ʼ�
	public int insert(noteInfo noteinfo) {
		// TODO Auto-generated method stub
		return noteInfoMapper.insert(noteinfo);
	}
	
	//�½��ʼ�ʱɾ�����ļ��м�¼
	public int deleteNull(String store) {
		noteInfoExample example = new noteInfoExample();
		example.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
	    noteInfoExample.Criteria criteria = example.createCriteria();
	    criteria.andStoreurlEqualTo(store);
		return noteInfoMapper.deleteByExample(example);
	}
	
	//��ѯ�ʼ�
	public noteInfo select(int noteId) {
		// TODO Auto-generated method stub
		return noteInfoMapper.selectByPrimaryKey(noteId);
	}
	
	//��ѯ�ʼ�
	public List<noteInfo> selectByUser(int userId) {
		// TODO Auto-generated method stub
	    noteInfoExample example = new noteInfoExample();
		example.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
	    noteInfoExample.Criteria criteria = example.createCriteria();
	    criteria.andUseridEqualTo(userId); 
		return noteInfoMapper.selectByExample(example);
	}
	
	//��ѯ����վ�ʼ�
	public List<noteInfo> selectByRecycle(String Recycle) {
		// TODO Auto-generated method stub
	    noteInfoExample example = new noteInfoExample();
		example.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
	    noteInfoExample.Criteria criteria = example.createCriteria();
	    criteria.andUserrecycleEqualTo(Recycle);
		return noteInfoMapper.selectByExample(example);
	}
	
	//���±ʼ�
	public int update(noteInfo noteinfo) {
		// TODO Auto-generated method stub
		return noteInfoMapper.updateByPrimaryKey(noteinfo);
	}
	
	//ɾ���ʼ�
	public int delete(int noteId) {
		// TODO Auto-generated method stub
		return noteInfoMapper.deleteByPrimaryKey(noteId);
	}
	
}
