package com.fcc.notebook.dao;

import com.fcc.notebook.bean.fileInfo;
import com.fcc.notebook.bean.fileInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface fileInfoMapper {
    long countByExample(fileInfoExample example);

    int deleteByExample(fileInfoExample example);

    int deleteByPrimaryKey(Integer fileid);

    int insert(fileInfo record);

    int insertSelective(fileInfo record);

    List<fileInfo> selectByExample(fileInfoExample example);

    fileInfo selectByPrimaryKey(Integer fileid);

    int updateByExampleSelective(@Param("record") fileInfo record, @Param("example") fileInfoExample example);

    int updateByExample(@Param("record") fileInfo record, @Param("example") fileInfoExample example);

    int updateByPrimaryKeySelective(fileInfo record);

    int updateByPrimaryKey(fileInfo record);
}