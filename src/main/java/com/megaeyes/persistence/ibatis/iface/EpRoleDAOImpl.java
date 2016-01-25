package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRole;
import com.megaeyes.persistence.ibatis.model.EpRoleExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpRoleDAOImpl extends SqlMapClientDaoSupport implements EpRoleDAO {

    public EpRoleDAOImpl() {
        super();
    }

    public void insert(EpRole record) {
        getSqlMapClientTemplate().insert("EP_ROLE._insert", record);
    }

    public int updateByPrimaryKey(EpRole record) {
        int rows = getSqlMapClientTemplate().update("EP_ROLE._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpRole record) {
        int rows = getSqlMapClientTemplate().update("EP_ROLE._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpRoleExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_ROLE._selectByExample", example);
        return list;
    }

    public EpRole selectByPrimaryKey(String id) {
        EpRole key = new EpRole();
        key.setId(id);
        EpRole record = (EpRole) getSqlMapClientTemplate().queryForObject("EP_ROLE._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpRoleExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_ROLE._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpRole key = new EpRole();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_ROLE._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpRoleExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_ROLE._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpRole record, EpRoleExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_ROLE._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpRole record, EpRoleExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_ROLE._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpRoleExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpRoleExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}