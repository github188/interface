package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRMapDevice;
import com.megaeyes.persistence.ibatis.model.EpRMapDeviceExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpRMapDeviceDAOImpl extends SqlMapClientDaoSupport implements EpRMapDeviceDAO {

    public EpRMapDeviceDAOImpl() {
        super();
    }

    public void insert(EpRMapDevice record) {
        getSqlMapClientTemplate().insert("EP_R_MAP_DEVICE._insert", record);
    }

    public int updateByPrimaryKey(EpRMapDevice record) {
        int rows = getSqlMapClientTemplate().update("EP_R_MAP_DEVICE._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpRMapDevice record) {
        int rows = getSqlMapClientTemplate().update("EP_R_MAP_DEVICE._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpRMapDeviceExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_R_MAP_DEVICE._selectByExample", example);
        return list;
    }

    public EpRMapDevice selectByPrimaryKey(String id) {
        EpRMapDevice key = new EpRMapDevice();
        key.setId(id);
        EpRMapDevice record = (EpRMapDevice) getSqlMapClientTemplate().queryForObject("EP_R_MAP_DEVICE._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpRMapDeviceExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_R_MAP_DEVICE._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpRMapDevice key = new EpRMapDevice();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_R_MAP_DEVICE._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpRMapDeviceExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_R_MAP_DEVICE._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpRMapDevice record, EpRMapDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_MAP_DEVICE._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpRMapDevice record, EpRMapDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_MAP_DEVICE._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpRMapDeviceExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpRMapDeviceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}