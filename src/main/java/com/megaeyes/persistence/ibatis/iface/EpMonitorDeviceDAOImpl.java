package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpMonitorDevice;
import com.megaeyes.persistence.ibatis.model.EpMonitorDeviceExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpMonitorDeviceDAOImpl extends SqlMapClientDaoSupport implements EpMonitorDeviceDAO {

    public EpMonitorDeviceDAOImpl() {
        super();
    }

    public void insert(EpMonitorDevice record) {
        getSqlMapClientTemplate().insert("EP_MONITOR_DEVICE._insert", record);
    }

    public int updateByPrimaryKey(EpMonitorDevice record) {
        int rows = getSqlMapClientTemplate().update("EP_MONITOR_DEVICE._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpMonitorDevice record) {
        int rows = getSqlMapClientTemplate().update("EP_MONITOR_DEVICE._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpMonitorDeviceExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_MONITOR_DEVICE._selectByExample", example);
        return list;
    }

    public EpMonitorDevice selectByPrimaryKey(String id) {
        EpMonitorDevice key = new EpMonitorDevice();
        key.setId(id);
        EpMonitorDevice record = (EpMonitorDevice) getSqlMapClientTemplate().queryForObject("EP_MONITOR_DEVICE._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpMonitorDeviceExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_MONITOR_DEVICE._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpMonitorDevice key = new EpMonitorDevice();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_MONITOR_DEVICE._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpMonitorDeviceExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_MONITOR_DEVICE._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpMonitorDevice record, EpMonitorDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_MONITOR_DEVICE._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpMonitorDevice record, EpMonitorDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_MONITOR_DEVICE._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpMonitorDeviceExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpMonitorDeviceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}