package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AlarmOutputChannelType;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannelTypeExample;
import java.util.List;

public interface AlarmOutputChannelTypeDAO {
    void insert(AlarmOutputChannelType record);

    int updateByPrimaryKey(AlarmOutputChannelType record);

    int updateByPrimaryKeySelective(AlarmOutputChannelType record);

    List selectByExample(AlarmOutputChannelTypeExample example);

    AlarmOutputChannelType selectByPrimaryKey(String id);

    int deleteByExample(AlarmOutputChannelTypeExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(AlarmOutputChannelTypeExample example);

    int updateByExampleSelective(AlarmOutputChannelType record, AlarmOutputChannelTypeExample example);

    int updateByExample(AlarmOutputChannelType record, AlarmOutputChannelTypeExample example);
}