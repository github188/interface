package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AlarmInputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmInputChannelExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AlarmInputChannelDAOImpl extends SqlMapClientDaoSupport implements AlarmInputChannelDAO {

    public AlarmInputChannelDAOImpl() {
        super();
    }

    public void insert(AlarmInputChannel record) {
        getSqlMapClientTemplate().insert("ALARM_INPUT_CHANNEL._insert", record);
    }

    public int updateByPrimaryKey(AlarmInputChannel record) {
        int rows = getSqlMapClientTemplate().update("ALARM_INPUT_CHANNEL._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(AlarmInputChannel record) {
        int rows = getSqlMapClientTemplate().update("ALARM_INPUT_CHANNEL._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(AlarmInputChannelExample example) {
        List list = getSqlMapClientTemplate().queryForList("ALARM_INPUT_CHANNEL._selectByExample", example);
        return list;
    }

    public AlarmInputChannel selectByPrimaryKey(String id) {
        AlarmInputChannel key = new AlarmInputChannel();
        key.setId(id);
        AlarmInputChannel record = (AlarmInputChannel) getSqlMapClientTemplate().queryForObject("ALARM_INPUT_CHANNEL._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(AlarmInputChannelExample example) {
        int rows = getSqlMapClientTemplate().delete("ALARM_INPUT_CHANNEL._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        AlarmInputChannel key = new AlarmInputChannel();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ALARM_INPUT_CHANNEL._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(AlarmInputChannelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ALARM_INPUT_CHANNEL._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(AlarmInputChannel record, AlarmInputChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ALARM_INPUT_CHANNEL._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(AlarmInputChannel record, AlarmInputChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ALARM_INPUT_CHANNEL._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends AlarmInputChannelExample {
        private Object record;

        public UpdateByExampleParms(Object record, AlarmInputChannelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}