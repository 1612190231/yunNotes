package com.fcc.notebook.dao;

import com.fcc.notebook.bean.shareInfo;
import com.fcc.notebook.bean.shareInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface shareInfoMapper {
    long countByExample(shareInfoExample example);

    int deleteByExample(shareInfoExample example);

    int deleteByPrimaryKey(Integer shareid);

    int insert(shareInfo record);

    int insertSelective(shareInfo record);

    List<shareInfo> selectByExample(shareInfoExample example);

    shareInfo selectByPrimaryKey(Integer shareid);

    int updateByExampleSelective(@Param("record") shareInfo record, @Param("example") shareInfoExample example);

    int updateByExample(@Param("record") shareInfo record, @Param("example") shareInfoExample example);

    int updateByPrimaryKeySelective(shareInfo record);

    int updateByPrimaryKey(shareInfo record);
}