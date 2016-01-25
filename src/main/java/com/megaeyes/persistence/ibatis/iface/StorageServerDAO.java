package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.model.StorageServerExample;
import java.util.List;

public interface StorageServerDAO {
    void insert(StorageServer record);

    int updateByPrimaryKey(StorageServer record);

    int updateByPrimaryKeySelective(StorageServer record);

    List selectByExample(StorageServerExample example);

    StorageServer selectByPrimaryKey(String id);

    int deleteByExample(StorageServerExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(StorageServerExample example);

    int updateByExampleSelective(StorageServer record, StorageServerExample example);

    int updateByExample(StorageServer record, StorageServerExample example);
}