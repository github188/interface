package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannelExample;
import java.util.List;

public interface AlarmOutputChannelDAO {
    void insert(AlarmOutputChannel record);

    int updateByPrimaryKey(AlarmOutputChannel record);

    int updateByPrimaryKeySelective(AlarmOutputChannel record);

    List selectByExample(AlarmOutputChannelExample example);

    AlarmOutputChannel selectByPrimaryKey(String id);

    int deleteByExample(AlarmOutputChannelExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(AlarmOutputChannelExample example);

    int updateByExampleSelective(AlarmOutputChannel record, AlarmOutputChannelExample example);

    int updateByExample(AlarmOutputChannel record, AlarmOutputChannelExample example);
}