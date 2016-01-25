package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AlarmInputChannelType;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannelTypeExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AlarmInputChannelTypeDAOImpl extends SqlMapClientDaoSupport implements AlarmInputChannelTypeDAO {

    public AlarmInputChannelTypeDAOImpl() {
        super();
    }

    public void insert(AlarmInputChannelType record) {
        getSqlMapClientTemplate().insert("ALARM_INPUT_CHANNEL_TYPE._insert", record);
    }

    public int updateByPrimaryKey(AlarmInputChannelType record) {
        int rows = getSqlMapClientTemplate().update("ALARM_INPUT_CHANNEL_TYPE._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(AlarmInputChannelType record) {
        int rows = getSqlMapClientTemplate().update("ALARM_INPUT_CHANNEL_TYPE._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(AlarmInputChannelTypeExample example) {
        List list = getSqlMapClientTemplate().queryForList("ALARM_INPUT_CHANNEL_TYPE._selectByExample", example);
        return list;
    }

    public AlarmInputChannelType selectByPrimaryKey(String id) {
        AlarmInputChannelType key = new AlarmInputChannelType();
        key.setId(id);
        AlarmInputChannelType record = (AlarmInputChannelType) getSqlMapClientTemplate().queryForObject("ALARM_INPUT_CHANNEL_TYPE._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(AlarmInputChannelTypeExample example) {
        int rows = getSqlMapClientTemplate().delete("ALARM_INPUT_CHANNEL_TYPE._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        AlarmInputChannelType key = new AlarmInputChannelType();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ALARM_INPUT_CHANNEL_TYPE._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(AlarmInputChannelTypeExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ALARM_INPUT_CHANNEL_TYPE._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(AlarmInputChannelType record, AlarmInputChannelTypeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ALARM_INPUT_CHANNEL_TYPE._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(AlarmInputChannelType record, AlarmInputChannelTypeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ALARM_INPUT_CHANNEL_TYPE._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends AlarmInputChannelTypeExample {
        private Object record;

        public UpdateByExampleParms(Object record, AlarmInputChannelTypeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}