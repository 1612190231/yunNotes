package com.fcc.notebook.dao;

import com.fcc.notebook.bean.userInfo;
import com.fcc.notebook.bean.userInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userInfoMapper {
    long countByExample(userInfoExample example);

    int deleteByExample(userInfoExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(userInfo record);

    int insertSelective(userInfo record);

    List<userInfo> selectByExample(userInfoExample example);

    userInfo selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") userInfo record, @Param("example") userInfoExample example);

    int updateByExample(@Param("record") userInfo record, @Param("example") userInfoExample example);

    int updateByPrimaryKeySelective(userInfo record);

    int updateByPrimaryKey(userInfo record);
}