package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRMonitorDevice;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDeviceExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpRMonitorDeviceDAOImpl extends SqlMapClientDaoSupport implements EpRMonitorDeviceDAO {

    public EpRMonitorDeviceDAOImpl() {
        super();
    }

    public void insert(EpRMonitorDevice record) {
        getSqlMapClientTemplate().insert("EP_R_MONITOR_DEVICE._insert", record);
    }

    public int updateByPrimaryKey(EpRMonitorDevice record) {
        int rows = getSqlMapClientTemplate().update("EP_R_MONITOR_DEVICE._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpRMonitorDevice record) {
        int rows = getSqlMapClientTemplate().update("EP_R_MONITOR_DEVICE._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpRMonitorDeviceExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_R_MONITOR_DEVICE._selectByExample", example);
        return list;
    }

    public EpRMonitorDevice selectByPrimaryKey(String id) {
        EpRMonitorDevice key = new EpRMonitorDevice();
        key.setId(id);
        EpRMonitorDevice record = (EpRMonitorDevice) getSqlMapClientTemplate().queryForObject("EP_R_MONITOR_DEVICE._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpRMonitorDeviceExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_R_MONITOR_DEVICE._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpRMonitorDevice key = new EpRMonitorDevice();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_R_MONITOR_DEVICE._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpRMonitorDeviceExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_R_MONITOR_DEVICE._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpRMonitorDevice record, EpRMonitorDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_MONITOR_DEVICE._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpRMonitorDevice record, EpRMonitorDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_MONITOR_DEVICE._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpRMonitorDeviceExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpRMonitorDeviceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}