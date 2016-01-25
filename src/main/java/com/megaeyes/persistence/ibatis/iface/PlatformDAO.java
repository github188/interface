package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.Platform;
import com.megaeyes.persistence.ibatis.model.PlatformExample;
import java.util.List;

public interface PlatformDAO {
    void insert(Platform record);

    int updateByPrimaryKey(Platform record);

    int updateByPrimaryKeySelective(Platform record);

    List selectByExample(PlatformExample example);

    Platform selectByPrimaryKey(String id);

    int deleteByExample(PlatformExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(PlatformExample example);

    int updateByExampleSelective(Platform record, PlatformExample example);

    int updateByExample(Platform record, PlatformExample example);
}