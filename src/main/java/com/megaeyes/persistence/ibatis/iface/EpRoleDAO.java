package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRole;
import com.megaeyes.persistence.ibatis.model.EpRoleExample;
import java.util.List;

public interface EpRoleDAO {
    void insert(EpRole record);

    int updateByPrimaryKey(EpRole record);

    int updateByPrimaryKeySelective(EpRole record);

    List selectByExample(EpRoleExample example);

    EpRole selectByPrimaryKey(String id);

    int deleteByExample(EpRoleExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpRoleExample example);

    int updateByExampleSelective(EpRole record, EpRoleExample example);

    int updateByExample(EpRole record, EpRoleExample example);
}