package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.RemoteStorageServer;
import com.megaeyes.persistence.ibatis.model.RemoteStorageServerExample;
import java.util.List;

public interface RemoteStorageServerDAO {
    void insert(RemoteStorageServer record);

    int updateByPrimaryKey(RemoteStorageServer record);

    int updateByPrimaryKeySelective(RemoteStorageServer record);

    List selectByExample(RemoteStorageServerExample example);

    RemoteStorageServer selectByPrimaryKey(String storageServerId);

    int deleteByExample(RemoteStorageServerExample example);

    int deleteByPrimaryKey(String storageServerId);

    int countByExample(RemoteStorageServerExample example);

    int updateByExampleSelective(RemoteStorageServer record, RemoteStorageServerExample example);

    int updateByExample(RemoteStorageServer record, RemoteStorageServerExample example);
}