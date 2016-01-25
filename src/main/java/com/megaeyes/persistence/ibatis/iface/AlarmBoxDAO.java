package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AlarmBox;
import com.megaeyes.persistence.ibatis.model.AlarmBoxExample;
import java.util.List;

public interface AlarmBoxDAO {
    void insert(AlarmBox record);

    int updateByPrimaryKey(AlarmBox record);

    int updateByPrimaryKeySelective(AlarmBox record);

    List selectByExample(AlarmBoxExample example);

    AlarmBox selectByPrimaryKey(String id);

    int deleteByExample(AlarmBoxExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(AlarmBoxExample example);

    int updateByExampleSelective(AlarmBox record, AlarmBoxExample example);

    int updateByExample(AlarmBox record, AlarmBoxExample example);
}