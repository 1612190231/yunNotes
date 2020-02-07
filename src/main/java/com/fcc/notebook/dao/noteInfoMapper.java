package com.fcc.notebook.dao;

import com.fcc.notebook.bean.noteInfo;
import com.fcc.notebook.bean.noteInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface noteInfoMapper {
    long countByExample(noteInfoExample example);

    int deleteByExample(noteInfoExample example);

    int deleteByPrimaryKey(Integer noteid);

    int insert(noteInfo record);

    int insertSelective(noteInfo record);

    List<noteInfo> selectByExample(noteInfoExample example);

    noteInfo selectByPrimaryKey(Integer noteid);

    int updateByExampleSelective(@Param("record") noteInfo record, @Param("example") noteInfoExample example);

    int updateByExample(@Param("record") noteInfo record, @Param("example") noteInfoExample example);

    int updateByPrimaryKeySelective(noteInfo record);

    int updateByPrimaryKey(noteInfo record);
}