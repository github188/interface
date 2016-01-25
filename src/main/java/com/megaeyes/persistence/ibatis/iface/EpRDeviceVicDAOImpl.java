package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRDeviceVic;
import com.megaeyes.persistence.ibatis.model.EpRDeviceVicExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpRDeviceVicDAOImpl extends SqlMapClientDaoSupport implements EpRDeviceVicDAO {

    public EpRDeviceVicDAOImpl() {
        super();
    }

    public void insert(EpRDeviceVic record) {
        getSqlMapClientTemplate().insert("EP_R_DEVICE_VIC._insert", record);
    }

    public List selectByExample(EpRDeviceVicExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_R_DEVICE_VIC._selectByExample", example);
        return list;
    }

    public int deleteByExample(EpRDeviceVicExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_R_DEVICE_VIC._deleteByExample", example);
        return rows;
    }

    public int countByExample(EpRDeviceVicExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_R_DEVICE_VIC._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpRDeviceVic record, EpRDeviceVicExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_DEVICE_VIC._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpRDeviceVic record, EpRDeviceVicExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_DEVICE_VIC._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpRDeviceVicExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpRDeviceVicExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}