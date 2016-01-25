package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.LocalStorageServer;
import com.megaeyes.persistence.ibatis.model.LocalStorageServerExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class LocalStorageServerDAOImpl extends SqlMapClientDaoSupport implements LocalStorageServerDAO {

    public LocalStorageServerDAOImpl() {
        super();
    }

    public void insert(LocalStorageServer record) {
        getSqlMapClientTemplate().insert("LOCAL_STORAGE_SERVER._insert", record);
    }

    public int updateByPrimaryKey(LocalStorageServer record) {
        int rows = getSqlMapClientTemplate().update("LOCAL_STORAGE_SERVER._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(LocalStorageServer record) {
        int rows = getSqlMapClientTemplate().update("LOCAL_STORAGE_SERVER._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(LocalStorageServerExample example) {
        List list = getSqlMapClientTemplate().queryForList("LOCAL_STORAGE_SERVER._selectByExample", example);
        return list;
    }

    public LocalStorageServer selectByPrimaryKey(String storageServerId) {
        LocalStorageServer key = new LocalStorageServer();
        key.setStorageServerId(storageServerId);
        LocalStorageServer record = (LocalStorageServer) getSqlMapClientTemplate().queryForObject("LOCAL_STORAGE_SERVER._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(LocalStorageServerExample example) {
        int rows = getSqlMapClientTemplate().delete("LOCAL_STORAGE_SERVER._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String storageServerId) {
        LocalStorageServer key = new LocalStorageServer();
        key.setStorageServerId(storageServerId);
        int rows = getSqlMapClientTemplate().delete("LOCAL_STORAGE_SERVER._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(LocalStorageServerExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("LOCAL_STORAGE_SERVER._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(LocalStorageServer record, LocalStorageServerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("LOCAL_STORAGE_SERVER._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(LocalStorageServer record, LocalStorageServerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("LOCAL_STORAGE_SERVER._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends LocalStorageServerExample {
        private Object record;

        public UpdateByExampleParms(Object record, LocalStorageServerExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}