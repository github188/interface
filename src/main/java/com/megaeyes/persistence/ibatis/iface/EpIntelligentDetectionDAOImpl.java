package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpIntelligentDetection;
import com.megaeyes.persistence.ibatis.model.EpIntelligentDetectionExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpIntelligentDetectionDAOImpl extends SqlMapClientDaoSupport implements EpIntelligentDetectionDAO {

    public EpIntelligentDetectionDAOImpl() {
        super();
    }

    public void insert(EpIntelligentDetection record) {
        getSqlMapClientTemplate().insert("EP_INTELLIGENT_DETECTION._insert", record);
    }

    public int updateByPrimaryKey(EpIntelligentDetection record) {
        int rows = getSqlMapClientTemplate().update("EP_INTELLIGENT_DETECTION._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpIntelligentDetection record) {
        int rows = getSqlMapClientTemplate().update("EP_INTELLIGENT_DETECTION._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpIntelligentDetectionExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_INTELLIGENT_DETECTION._selectByExample", example);
        return list;
    }

    public EpIntelligentDetection selectByPrimaryKey(String deviceId) {
        EpIntelligentDetection key = new EpIntelligentDetection();
        key.setDeviceId(deviceId);
        EpIntelligentDetection record = (EpIntelligentDetection) getSqlMapClientTemplate().queryForObject("EP_INTELLIGENT_DETECTION._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpIntelligentDetectionExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_INTELLIGENT_DETECTION._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String deviceId) {
        EpIntelligentDetection key = new EpIntelligentDetection();
        key.setDeviceId(deviceId);
        int rows = getSqlMapClientTemplate().delete("EP_INTELLIGENT_DETECTION._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpIntelligentDetectionExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_INTELLIGENT_DETECTION._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpIntelligentDetection record, EpIntelligentDetectionExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_INTELLIGENT_DETECTION._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpIntelligentDetection record, EpIntelligentDetectionExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_INTELLIGENT_DETECTION._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpIntelligentDetectionExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpIntelligentDetectionExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}