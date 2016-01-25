package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.Organ;
import com.megaeyes.persistence.ibatis.model.OrganExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class OrganDAOImpl extends SqlMapClientDaoSupport implements OrganDAO {

    public OrganDAOImpl() {
        super();
    }

    public void insert(Organ record) {
        getSqlMapClientTemplate().insert("ORGAN._insert", record);
    }

    public int updateByPrimaryKey(Organ record) {
        int rows = getSqlMapClientTemplate().update("ORGAN._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(Organ record) {
        int rows = getSqlMapClientTemplate().update("ORGAN._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(OrganExample example) {
        List list = getSqlMapClientTemplate().queryForList("ORGAN._selectByExample", example);
        return list;
    }

    public Organ selectByPrimaryKey(String id) {
        Organ key = new Organ();
        key.setId(id);
        Organ record = (Organ) getSqlMapClientTemplate().queryForObject("ORGAN._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(OrganExample example) {
        int rows = getSqlMapClientTemplate().delete("ORGAN._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        Organ key = new Organ();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("ORGAN._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(OrganExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ORGAN._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(Organ record, OrganExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ORGAN._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(Organ record, OrganExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ORGAN._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends OrganExample {
        private Object record;

        public UpdateByExampleParms(Object record, OrganExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}