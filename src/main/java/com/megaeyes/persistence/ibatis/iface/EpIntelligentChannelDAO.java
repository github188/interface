package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpIntelligentChannel;
import com.megaeyes.persistence.ibatis.model.EpIntelligentChannelExample;
import java.util.List;

public interface EpIntelligentChannelDAO {
    void insert(EpIntelligentChannel record);

    int updateByPrimaryKey(EpIntelligentChannel record);

    int updateByPrimaryKeySelective(EpIntelligentChannel record);

    List selectByExample(EpIntelligentChannelExample example);

    EpIntelligentChannel selectByPrimaryKey(String id);

    int deleteByExample(EpIntelligentChannelExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpIntelligentChannelExample example);

    int updateByExampleSelective(EpIntelligentChannel record, EpIntelligentChannelExample example);

    int updateByExample(EpIntelligentChannel record, EpIntelligentChannelExample example);
}