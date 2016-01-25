package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRRoleResource;
import com.megaeyes.persistence.ibatis.model.EpRRoleResourceExample;
import java.util.List;

public interface EpRRoleResourceDAO {
    void insert(EpRRoleResource record);

    int updateByPrimaryKey(EpRRoleResource record);

    int updateByPrimaryKeySelective(EpRRoleResource record);

    List selectByExample(EpRRoleResourceExample example);

    EpRRoleResource selectByPrimaryKey(String id);

    int deleteByExample(EpRRoleResourceExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpRRoleResourceExample example);

    int updateByExampleSelective(EpRRoleResource record, EpRRoleResourceExample example);

    int updateByExample(EpRRoleResource record, EpRRoleResourceExample example);
}