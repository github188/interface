package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.LocalStorageServer;
import com.megaeyes.persistence.ibatis.model.LocalStorageServerExample;
import java.util.List;

public interface LocalStorageServerDAO {
    void insert(LocalStorageServer record);

    int updateByPrimaryKey(LocalStorageServer record);

    int updateByPrimaryKeySelective(LocalStorageServer record);

    List selectByExample(LocalStorageServerExample example);

    LocalStorageServer selectByPrimaryKey(String storageServerId);

    int deleteByExample(LocalStorageServerExample example);

    int deleteByPrimaryKey(String storageServerId);

    int countByExample(LocalStorageServerExample example);

    int updateByExampleSelective(LocalStorageServer record, LocalStorageServerExample example);

    int updateByExample(LocalStorageServer record, LocalStorageServerExample example);
}