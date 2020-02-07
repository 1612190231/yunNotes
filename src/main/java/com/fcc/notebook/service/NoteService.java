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
	
	//新建笔记
	public int insert(noteInfo noteinfo) {
		// TODO Auto-generated method stub
		return noteInfoMapper.insert(noteinfo);
	}
	
	//新建笔记时删除空文件夹记录
	public int deleteNull(String store) {
		noteInfoExample example = new noteInfoExample();
		example.setDistinct(false); //去除重复,true是选择不重复记录,false反之
	    noteInfoExample.Criteria criteria = example.createCriteria();
	    criteria.andStoreurlEqualTo(store);
		return noteInfoMapper.deleteByExample(example);
	}
	
	//查询笔记
	public noteInfo select(int noteId) {
		// TODO Auto-generated method stub
		return noteInfoMapper.selectByPrimaryKey(noteId);
	}
	
	//查询笔记
	public List<noteInfo> selectByUser(int userId) {
		// TODO Auto-generated method stub
	    noteInfoExample example = new noteInfoExample();
		example.setDistinct(false); //去除重复,true是选择不重复记录,false反之
	    noteInfoExample.Criteria criteria = example.createCriteria();
	    criteria.andUseridEqualTo(userId); 
		return noteInfoMapper.selectByExample(example);
	}
	
	//查询回收站笔记
	public List<noteInfo> selectByRecycle(String Recycle) {
		// TODO Auto-generated method stub
	    noteInfoExample example = new noteInfoExample();
		example.setDistinct(false); //去除重复,true是选择不重复记录,false反之
	    noteInfoExample.Criteria criteria = example.createCriteria();
	    criteria.andUserrecycleEqualTo(Recycle);
		return noteInfoMapper.selectByExample(example);
	}
	
	//更新笔记
	public int update(noteInfo noteinfo) {
		// TODO Auto-generated method stub
		return noteInfoMapper.updateByPrimaryKey(noteinfo);
	}
	
	//删除笔记
	public int delete(int noteId) {
		// TODO Auto-generated method stub
		return noteInfoMapper.deleteByPrimaryKey(noteId);
	}
	
}
