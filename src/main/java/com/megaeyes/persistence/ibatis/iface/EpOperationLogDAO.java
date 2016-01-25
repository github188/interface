package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpOperationLog;
import com.megaeyes.persistence.ibatis.model.EpOperationLogExample;
import java.util.List;

public interface EpOperationLogDAO {
    void insert(EpOperationLog record);

    int updateByPrimaryKey(EpOperationLog record);

    int updateByPrimaryKeySelective(EpOperationLog record);

    List selectByExample(EpOperationLogExample example);

    EpOperationLog selectByPrimaryKey(String id);

    int deleteByExample(EpOperationLogExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpOperationLogExample example);

    int updateByExampleSelective(EpOperationLog record, EpOperationLogExample example);

    int updateByExample(EpOperationLog record, EpOperationLogExample example);
}