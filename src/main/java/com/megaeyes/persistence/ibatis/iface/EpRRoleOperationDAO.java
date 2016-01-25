package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRRoleOperation;
import com.megaeyes.persistence.ibatis.model.EpRRoleOperationExample;
import java.util.List;

public interface EpRRoleOperationDAO {
    void insert(EpRRoleOperation record);

    int updateByPrimaryKey(EpRRoleOperation record);

    int updateByPrimaryKeySelective(EpRRoleOperation record);

    List selectByExample(EpRRoleOperationExample example);

    EpRRoleOperation selectByPrimaryKey(String id);

    int deleteByExample(EpRRoleOperationExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpRRoleOperationExample example);

    int updateByExampleSelective(EpRRoleOperation record, EpRRoleOperationExample example);

    int updateByExample(EpRRoleOperation record, EpRRoleOperationExample example);
}