package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRAssetsVic;
import com.megaeyes.persistence.ibatis.model.EpRAssetsVicExample;
import java.util.List;

public interface EpRAssetsVicDAO {
    void insert(EpRAssetsVic record);

    int updateByPrimaryKey(EpRAssetsVic record);

    int updateByPrimaryKeySelective(EpRAssetsVic record);

    List selectByExample(EpRAssetsVicExample example);

    EpRAssetsVic selectByPrimaryKey(String id);

    int deleteByExample(EpRAssetsVicExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpRAssetsVicExample example);

    int updateByExampleSelective(EpRAssetsVic record, EpRAssetsVicExample example);

    int updateByExample(EpRAssetsVic record, EpRAssetsVicExample example);
}