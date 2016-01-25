package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRUserRole;
import com.megaeyes.persistence.ibatis.model.EpRUserRoleExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpRUserRoleDAOImpl extends SqlMapClientDaoSupport implements EpRUserRoleDAO {

    public EpRUserRoleDAOImpl() {
        super();
    }

    public void insert(EpRUserRole record) {
        getSqlMapClientTemplate().insert("EP_R_USER_ROLE._insert", record);
    }

    public int updateByPrimaryKey(EpRUserRole record) {
        int rows = getSqlMapClientTemplate().update("EP_R_USER_ROLE._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpRUserRole record) {
        int rows = getSqlMapClientTemplate().update("EP_R_USER_ROLE._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpRUserRoleExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_R_USER_ROLE._selectByExample", example);
        return list;
    }

    public EpRUserRole selectByPrimaryKey(String id) {
        EpRUserRole key = new EpRUserRole();
        key.setId(id);
        EpRUserRole record = (EpRUserRole) getSqlMapClientTemplate().queryForObject("EP_R_USER_ROLE._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpRUserRoleExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_R_USER_ROLE._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpRUserRole key = new EpRUserRole();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_R_USER_ROLE._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpRUserRoleExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_R_USER_ROLE._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpRUserRole record, EpRUserRoleExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_USER_ROLE._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpRUserRole record, EpRUserRoleExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_USER_ROLE._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpRUserRoleExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpRUserRoleExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}