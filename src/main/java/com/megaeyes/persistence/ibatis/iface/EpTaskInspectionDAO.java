package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpTaskInspection;
import com.megaeyes.persistence.ibatis.model.EpTaskInspectionExample;
import java.util.List;

public interface EpTaskInspectionDAO {
    void insert(EpTaskInspection record);

    List selectByExample(EpTaskInspectionExample example);

    int deleteByExample(EpTaskInspectionExample example);

    int countByExample(EpTaskInspectionExample example);

    int updateByExampleSelective(EpTaskInspection record, EpTaskInspectionExample example);

    int updateByExample(EpTaskInspection record, EpTaskInspectionExample example);
}