package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AlarmInputChannelType;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannelTypeExample;
import java.util.List;

public interface AlarmInputChannelTypeDAO {
    void insert(AlarmInputChannelType record);

    int updateByPrimaryKey(AlarmInputChannelType record);

    int updateByPrimaryKeySelective(AlarmInputChannelType record);

    List selectByExample(AlarmInputChannelTypeExample example);

    AlarmInputChannelType selectByPrimaryKey(String id);

    int deleteByExample(AlarmInputChannelTypeExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(AlarmInputChannelTypeExample example);

    int updateByExampleSelective(AlarmInputChannelType record, AlarmInputChannelTypeExample example);

    int updateByExample(AlarmInputChannelType record, AlarmInputChannelTypeExample example);
}