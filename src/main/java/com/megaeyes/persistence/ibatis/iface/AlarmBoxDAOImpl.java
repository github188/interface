package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AlarmBox;
import com.megaeyes.persistence.ibatis.model.AlarmBoxExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AlarmBoxDAOImpl extends SqlMapClientDaoSupport implements AlarmBoxDAO {

    public AlarmBoxDAOImpl() {
        super();
    }

    public void insert(AlarmBox record) {
        getSqlMapClientTemplate().insert("ALARM_BOX._insert", record);
    }

    public int updateByPrimaryKey(AlarmBox record) {
        int rows = getSqlMapClientTemplate().update("ALARM_BOX._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(AlarmBox record) {
        int rows = getSqlMapClientTemplate().update("ALARM_BOX._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(AlarmBoxExample example) {
        List list = getSqlMapClientTemplate().queryForList("ALARM_BOX._selectByExample", example);
        return list;
    }

    public AlarmBox selectByPrimaryKey(String id) {
        AlarmBox key = new AlarmBox();
        key.setId(id);
        AlarmBox record = (AlarmBox) getSqlMapClientTemplate().queryForObject("ALARM_BOX._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(AlarmBoxExample example) {
        int rows = getSqlMapClientTemplate().delete("ALARM_BOX._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        AlarmBox key = new AlarmBox();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ALARM_BOX._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(AlarmBoxExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ALARM_BOX._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(AlarmBox record, AlarmBoxExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ALARM_BOX._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(AlarmBox record, AlarmBoxExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ALARM_BOX._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends AlarmBoxExample {
        private Object record;

        public UpdateByExampleParms(Object record, AlarmBoxExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}