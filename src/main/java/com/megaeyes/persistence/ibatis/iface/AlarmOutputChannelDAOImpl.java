package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AlarmOutputChannel;
import com.megaeyes.persistence.ibatis.model.AlarmOutputChannelExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AlarmOutputChannelDAOImpl extends SqlMapClientDaoSupport implements AlarmOutputChannelDAO {

    public AlarmOutputChannelDAOImpl() {
        super();
    }

    public void insert(AlarmOutputChannel record) {
        getSqlMapClientTemplate().insert("alarm_output_channel._insert", record);
    }

    public int updateByPrimaryKey(AlarmOutputChannel record) {
        int rows = getSqlMapClientTemplate().update("alarm_output_channel._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(AlarmOutputChannel record) {
        int rows = getSqlMapClientTemplate().update("alarm_output_channel._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(AlarmOutputChannelExample example) {
        List list = getSqlMapClientTemplate().queryForList("alarm_output_channel._selectByExample", example);
        return list;
    }

    public AlarmOutputChannel selectByPrimaryKey(String id) {
        AlarmOutputChannel key = new AlarmOutputChannel();
        key.setId(id);
        AlarmOutputChannel record = (AlarmOutputChannel) getSqlMapClientTemplate().queryForObject("alarm_output_channel._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(AlarmOutputChannelExample example) {
        int rows = getSqlMapClientTemplate().delete("alarm_output_channel._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        AlarmOutputChannel key = new AlarmOutputChannel();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("alarm_output_channel._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(AlarmOutputChannelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("alarm_output_channel._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(AlarmOutputChannel record, AlarmOutputChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("alarm_output_channel._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(AlarmOutputChannel record, AlarmOutputChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("alarm_output_channel._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends AlarmOutputChannelExample {
        private Object record;

        public UpdateByExampleParms(Object record, AlarmOutputChannelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}