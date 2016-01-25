package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.IntelligentChannel;
import com.megaeyes.persistence.ibatis.model.IntelligentChannelExample;
import java.util.List;

public interface IntelligentChannelDAO {
    void insert(IntelligentChannel record);

    int updateByPrimaryKey(IntelligentChannel record);

    int updateByPrimaryKeySelective(IntelligentChannel record);

    List selectByExample(IntelligentChannelExample example);

    IntelligentChannel selectByPrimaryKey(String id);

    int deleteByExample(IntelligentChannelExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(IntelligentChannelExample example);

    int updateByExampleSelective(IntelligentChannel record, IntelligentChannelExample example);

    int updateByExample(IntelligentChannel record, IntelligentChannelExample example);
}