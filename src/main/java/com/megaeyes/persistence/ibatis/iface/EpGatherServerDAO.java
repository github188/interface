package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpGatherServer;
import com.megaeyes.persistence.ibatis.model.EpGatherServerExample;
import java.util.List;

public interface EpGatherServerDAO {
    void insert(EpGatherServer record);

    int updateByPrimaryKey(EpGatherServer record);

    int updateByPrimaryKeySelective(EpGatherServer record);

    List selectByExample(EpGatherServerExample example);

    EpGatherServer selectByPrimaryKey(String id);

    int deleteByExample(EpGatherServerExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpGatherServerExample example);

    int updateByExampleSelective(EpGatherServer record, EpGatherServerExample example);

    int updateByExample(EpGatherServer record, EpGatherServerExample example);
}