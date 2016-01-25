package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.DispatchServer;
import com.megaeyes.persistence.ibatis.model.DispatchServerExample;
import java.util.List;

public interface DispatchServerDAO {
    void insert(DispatchServer record);

    int updateByPrimaryKey(DispatchServer record);

    int updateByPrimaryKeySelective(DispatchServer record);

    List selectByExample(DispatchServerExample example);

    DispatchServer selectByPrimaryKey(String id);

    int deleteByExample(DispatchServerExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(DispatchServerExample example);

    int updateByExampleSelective(DispatchServer record, DispatchServerExample example);

    int updateByExample(DispatchServer record, DispatchServerExample example);
}