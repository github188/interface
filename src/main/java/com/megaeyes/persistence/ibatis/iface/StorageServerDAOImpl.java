package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.StorageServer;
import com.megaeyes.persistence.ibatis.model.StorageServerExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class StorageServerDAOImpl extends SqlMapClientDaoSupport implements StorageServerDAO {

    public StorageServerDAOImpl() {
        super();
    }

    public void insert(StorageServer record) {
        getSqlMapClientTemplate().insert("STORAGE_SERVER._insert", record);
    }

    public int updateByPrimaryKey(StorageServer record) {
        int rows = getSqlMapClientTemplate().update("STORAGE_SERVER._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(StorageServer record) {
        int rows = getSqlMapClientTemplate().update("STORAGE_SERVER._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(StorageServerExample example) {
        List list = getSqlMapClientTemplate().queryForList("STORAGE_SERVER._selectByExample", example);
        return list;
    }

    public StorageServer selectByPrimaryKey(String id) {
        StorageServer key = new StorageServer();
        key.setId(id);
        StorageServer record = (StorageServer) getSqlMapClientTemplate().queryForObject("STORAGE_SERVER._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(StorageServerExample example) {
        int rows = getSqlMapClientTemplate().delete("STORAGE_SERVER._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        StorageServer key = new StorageServer();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("STORAGE_SERVER._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(StorageServerExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("STORAGE_SERVER._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(StorageServer record, StorageServerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("STORAGE_SERVER._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(StorageServer record, StorageServerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("STORAGE_SERVER._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends StorageServerExample {
        private Object record;

        public UpdateByExampleParms(Object record, StorageServerExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}