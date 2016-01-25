package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannelExample;
import java.util.List;

public interface AlarmInputChannelDAO {
    void insert(AlarmInputChannel record);

    int updateByPrimaryKey(AlarmInputChannel record);

    int updateByPrimaryKeySelective(AlarmInputChannel record);

    List selectByExample(AlarmInputChannelExample example);

    AlarmInputChannel selectByPrimaryKey(String id);

    int deleteByExample(AlarmInputChannelExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(AlarmInputChannelExample example);

    int updateByExampleSelective(AlarmInputChannel record, AlarmInputChannelExample example);

    int updateByExample(AlarmInputChannel record, AlarmInputChannelExample example);
}