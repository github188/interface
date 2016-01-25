package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpEventType;
import com.megaeyes.persistence.ibatis.model.EpEventTypeExample;
import java.util.List;

public interface EpEventTypeDAO {
    void insert(EpEventType record);

    int updateByPrimaryKey(EpEventType record);

    int updateByPrimaryKeySelective(EpEventType record);

    List selectByExample(EpEventTypeExample example);

    EpEventType selectByPrimaryKey(String id);

    int deleteByExample(EpEventTypeExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpEventTypeExample example);

    int updateByExampleSelective(EpEventType record, EpEventTypeExample example);

    int updateByExample(EpEventType record, EpEventTypeExample example);
}