package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpSchemeCommand;
import com.megaeyes.persistence.ibatis.model.EpSchemeCommandExample;
import java.util.List;

public interface EpSchemeCommandDAO {
    void insert(EpSchemeCommand record);

    int updateByPrimaryKey(EpSchemeCommand record);

    int updateByPrimaryKeySelective(EpSchemeCommand record);

    List selectByExample(EpSchemeCommandExample example);

    EpSchemeCommand selectByPrimaryKey(String id);

    int deleteByExample(EpSchemeCommandExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpSchemeCommandExample example);

    int updateByExampleSelective(EpSchemeCommand record, EpSchemeCommandExample example);

    int updateByExample(EpSchemeCommand record, EpSchemeCommandExample example);
}