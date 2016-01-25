package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.Manufacturer;
import com.megaeyes.persistence.ibatis.model.ManufacturerExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ManufacturerDAOImpl extends SqlMapClientDaoSupport implements ManufacturerDAO {

    public ManufacturerDAOImpl() {
        super();
    }

    public void insert(Manufacturer record) {
        getSqlMapClientTemplate().insert("MANUFACTURER._insert", record);
    }

    public int updateByPrimaryKey(Manufacturer record) {
        int rows = getSqlMapClientTemplate().update("MANUFACTURER._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(Manufacturer record) {
        int rows = getSqlMapClientTemplate().update("MANUFACTURER._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(ManufacturerExample example) {
        List list = getSqlMapClientTemplate().queryForList("MANUFACTURER._selectByExample", example);
        return list;
    }

    public Manufacturer selectByPrimaryKey(String id) {
        Manufacturer key = new Manufacturer();
        key.setId(id);
        Manufacturer record = (Manufacturer) getSqlMapClientTemplate().queryForObject("MANUFACTURER._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(ManufacturerExample example) {
        int rows = getSqlMapClientTemplate().delete("MANUFACTURER._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        Manufacturer key = new Manufacturer();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("MANUFACTURER._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(ManufacturerExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("MANUFACTURER._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(Manufacturer record, ManufacturerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("MANUFACTURER._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(Manufacturer record, ManufacturerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("MANUFACTURER._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends ManufacturerExample {
        private Object record;

        public UpdateByExampleParms(Object record, ManufacturerExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}