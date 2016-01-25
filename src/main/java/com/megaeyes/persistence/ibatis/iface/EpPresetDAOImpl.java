package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpPreset;
import com.megaeyes.persistence.ibatis.model.EpPresetExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpPresetDAOImpl extends SqlMapClientDaoSupport implements EpPresetDAO {

    public EpPresetDAOImpl() {
        super();
    }

    public void insert(EpPreset record) {
        getSqlMapClientTemplate().insert("EP_PRESET._insert", record);
    }

    public int updateByPrimaryKey(EpPreset record) {
        int rows = getSqlMapClientTemplate().update("EP_PRESET._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpPreset record) {
        int rows = getSqlMapClientTemplate().update("EP_PRESET._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpPresetExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_PRESET._selectByExample", example);
        return list;
    }

    public EpPreset selectByPrimaryKey(String id) {
        EpPreset key = new EpPreset();
        key.setId(id);
        EpPreset record = (EpPreset) getSqlMapClientTemplate().queryForObject("EP_PRESET._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpPresetExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_PRESET._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpPreset key = new EpPreset();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_PRESET._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpPresetExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_PRESET._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpPreset record, EpPresetExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_PRESET._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpPreset record, EpPresetExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_PRESET._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpPresetExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpPresetExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}