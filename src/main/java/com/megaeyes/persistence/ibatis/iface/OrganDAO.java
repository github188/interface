package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.Organ;
import com.megaeyes.persistence.ibatis.model.OrganExample;
import java.util.List;

public interface OrganDAO {
    void insert(Organ record);

    int updateByPrimaryKey(Organ record);

    int updateByPrimaryKeySelective(Organ record);

    List selectByExample(OrganExample example);

    Organ selectByPrimaryKey(String id);

    int deleteByExample(OrganExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(OrganExample example);

    int updateByExampleSelective(Organ record, OrganExample example);

    int updateByExample(Organ record, OrganExample example);
}