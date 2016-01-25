package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpEventType;
import com.megaeyes.persistence.ibatis.model.EpEventTypeExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpEventTypeDAOImpl extends SqlMapClientDaoSupport implements EpEventTypeDAO {

    public EpEventTypeDAOImpl() {
        super();
    }

    public void insert(EpEventType record) {
        getSqlMapClientTemplate().insert("EP_EVENT_TYPE._insert", record);
    }

    public int updateByPrimaryKey(EpEventType record) {
        int rows = getSqlMapClientTemplate().update("EP_EVENT_TYPE._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpEventType record) {
        int rows = getSqlMapClientTemplate().update("EP_EVENT_TYPE._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpEventTypeExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_EVENT_TYPE._selectByExample", example);
        return list;
    }

    public EpEventType selectByPrimaryKey(String id) {
        EpEventType key = new EpEventType();
        key.setId(id);
        EpEventType record = (EpEventType) getSqlMapClientTemplate().queryForObject("EP_EVENT_TYPE._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpEventTypeExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_EVENT_TYPE._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpEventType key = new EpEventType();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_EVENT_TYPE._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpEventTypeExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_EVENT_TYPE._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpEventType record, EpEventTypeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_EVENT_TYPE._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpEventType record, EpEventTypeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_EVENT_TYPE._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpEventTypeExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpEventTypeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}