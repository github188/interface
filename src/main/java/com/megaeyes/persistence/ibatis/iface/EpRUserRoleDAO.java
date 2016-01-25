package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRUserRole;
import com.megaeyes.persistence.ibatis.model.EpRUserRoleExample;
import java.util.List;

public interface EpRUserRoleDAO {
    void insert(EpRUserRole record);

    int updateByPrimaryKey(EpRUserRole record);

    int updateByPrimaryKeySelective(EpRUserRole record);

    List selectByExample(EpRUserRoleExample example);

    EpRUserRole selectByPrimaryKey(String id);

    int deleteByExample(EpRUserRoleExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpRUserRoleExample example);

    int updateByExampleSelective(EpRUserRole record, EpRUserRoleExample example);

    int updateByExample(EpRUserRole record, EpRUserRoleExample example);
}