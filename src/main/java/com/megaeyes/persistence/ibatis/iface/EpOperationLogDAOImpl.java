package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpOperationLog;
import com.megaeyes.persistence.ibatis.model.EpOperationLogExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpOperationLogDAOImpl extends SqlMapClientDaoSupport implements EpOperationLogDAO {

    public EpOperationLogDAOImpl() {
        super();
    }

    public void insert(EpOperationLog record) {
        getSqlMapClientTemplate().insert("EP_OPERATION_LOG._insert", record);
    }

    public int updateByPrimaryKey(EpOperationLog record) {
        int rows = getSqlMapClientTemplate().update("EP_OPERATION_LOG._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpOperationLog record) {
        int rows = getSqlMapClientTemplate().update("EP_OPERATION_LOG._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpOperationLogExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_OPERATION_LOG._selectByExample", example);
        return list;
    }

    public EpOperationLog selectByPrimaryKey(String id) {
        EpOperationLog key = new EpOperationLog();
        key.setId(id);
        EpOperationLog record = (EpOperationLog) getSqlMapClientTemplate().queryForObject("EP_OPERATION_LOG._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpOperationLogExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_OPERATION_LOG._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpOperationLog key = new EpOperationLog();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_OPERATION_LOG._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpOperationLogExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_OPERATION_LOG._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpOperationLog record, EpOperationLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_OPERATION_LOG._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpOperationLog record, EpOperationLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_OPERATION_LOG._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpOperationLogExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpOperationLogExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}