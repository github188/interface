package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.RemoteStorageServer;
import com.megaeyes.persistence.ibatis.model.RemoteStorageServerExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RemoteStorageServerDAOImpl extends SqlMapClientDaoSupport implements RemoteStorageServerDAO {

    public RemoteStorageServerDAOImpl() {
        super();
    }

    public void insert(RemoteStorageServer record) {
        getSqlMapClientTemplate().insert("REMOTE_STORAGE_SERVER._insert", record);
    }

    public int updateByPrimaryKey(RemoteStorageServer record) {
        int rows = getSqlMapClientTemplate().update("REMOTE_STORAGE_SERVER._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(RemoteStorageServer record) {
        int rows = getSqlMapClientTemplate().update("REMOTE_STORAGE_SERVER._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(RemoteStorageServerExample example) {
        List list = getSqlMapClientTemplate().queryForList("REMOTE_STORAGE_SERVER._selectByExample", example);
        return list;
    }

    public RemoteStorageServer selectByPrimaryKey(String storageServerId) {
        RemoteStorageServer key = new RemoteStorageServer();
        key.setStorageServerId(storageServerId);
        RemoteStorageServer record = (RemoteStorageServer) getSqlMapClientTemplate().queryForObject("REMOTE_STORAGE_SERVER._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(RemoteStorageServerExample example) {
        int rows = getSqlMapClientTemplate().delete("REMOTE_STORAGE_SERVER._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String storageServerId) {
        RemoteStorageServer key = new RemoteStorageServer();
        key.setStorageServerId(storageServerId);
        int rows = getSqlMapClientTemplate().delete("REMOTE_STORAGE_SERVER._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(RemoteStorageServerExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("REMOTE_STORAGE_SERVER._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(RemoteStorageServer record, RemoteStorageServerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("REMOTE_STORAGE_SERVER._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RemoteStorageServer record, RemoteStorageServerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("REMOTE_STORAGE_SERVER._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends RemoteStorageServerExample {
        private Object record;

        public UpdateByExampleParms(Object record, RemoteStorageServerExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}