package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AlarmOutputChannelType;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannelTypeExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AlarmOutputChannelTypeDAOImpl extends SqlMapClientDaoSupport implements AlarmOutputChannelTypeDAO {

    public AlarmOutputChannelTypeDAOImpl() {
        super();
    }

    public void insert(AlarmOutputChannelType record) {
        getSqlMapClientTemplate().insert("ALARM_OUTPUT_CHANNEL_TYPE._insert", record);
    }

    public int updateByPrimaryKey(AlarmOutputChannelType record) {
        int rows = getSqlMapClientTemplate().update("ALARM_OUTPUT_CHANNEL_TYPE._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(AlarmOutputChannelType record) {
        int rows = getSqlMapClientTemplate().update("ALARM_OUTPUT_CHANNEL_TYPE._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(AlarmOutputChannelTypeExample example) {
        List list = getSqlMapClientTemplate().queryForList("ALARM_OUTPUT_CHANNEL_TYPE._selectByExample", example);
        return list;
    }

    public AlarmOutputChannelType selectByPrimaryKey(String id) {
        AlarmOutputChannelType key = new AlarmOutputChannelType();
        key.setId(id);
        AlarmOutputChannelType record = (AlarmOutputChannelType) getSqlMapClientTemplate().queryForObject("ALARM_OUTPUT_CHANNEL_TYPE._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(AlarmOutputChannelTypeExample example) {
        int rows = getSqlMapClientTemplate().delete("ALARM_OUTPUT_CHANNEL_TYPE._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        AlarmOutputChannelType key = new AlarmOutputChannelType();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ALARM_OUTPUT_CHANNEL_TYPE._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(AlarmOutputChannelTypeExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ALARM_OUTPUT_CHANNEL_TYPE._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(AlarmOutputChannelType record, AlarmOutputChannelTypeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ALARM_OUTPUT_CHANNEL_TYPE._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(AlarmOutputChannelType record, AlarmOutputChannelTypeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ALARM_OUTPUT_CHANNEL_TYPE._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends AlarmOutputChannelTypeExample {
        private Object record;

        public UpdateByExampleParms(Object record, AlarmOutputChannelTypeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}