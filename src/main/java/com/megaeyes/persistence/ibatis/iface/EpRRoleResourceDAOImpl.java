package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRRoleResource;
import com.megaeyes.persistence.ibatis.model.EpRRoleResourceExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpRRoleResourceDAOImpl extends SqlMapClientDaoSupport implements EpRRoleResourceDAO {

    public EpRRoleResourceDAOImpl() {
        super();
    }

    public void insert(EpRRoleResource record) {
        getSqlMapClientTemplate().insert("EP_R_ROLE_RESOURCE._insert", record);
    }

    public int updateByPrimaryKey(EpRRoleResource record) {
        int rows = getSqlMapClientTemplate().update("EP_R_ROLE_RESOURCE._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpRRoleResource record) {
        int rows = getSqlMapClientTemplate().update("EP_R_ROLE_RESOURCE._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpRRoleResourceExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_R_ROLE_RESOURCE._selectByExample", example);
        return list;
    }

    public EpRRoleResource selectByPrimaryKey(String id) {
        EpRRoleResource key = new EpRRoleResource();
        key.setId(id);
        EpRRoleResource record = (EpRRoleResource) getSqlMapClientTemplate().queryForObject("EP_R_ROLE_RESOURCE._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpRRoleResourceExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_R_ROLE_RESOURCE._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpRRoleResource key = new EpRRoleResource();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_R_ROLE_RESOURCE._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpRRoleResourceExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_R_ROLE_RESOURCE._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpRRoleResource record, EpRRoleResourceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_ROLE_RESOURCE._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpRRoleResource record, EpRRoleResourceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_ROLE_RESOURCE._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpRRoleResourceExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpRRoleResourceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}