package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRRoleOperation;
import com.megaeyes.persistence.ibatis.model.EpRRoleOperationExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpRRoleOperationDAOImpl extends SqlMapClientDaoSupport implements EpRRoleOperationDAO {

    public EpRRoleOperationDAOImpl() {
        super();
    }

    public void insert(EpRRoleOperation record) {
        getSqlMapClientTemplate().insert("EP_R_ROLE_OPERATION._insert", record);
    }

    public int updateByPrimaryKey(EpRRoleOperation record) {
        int rows = getSqlMapClientTemplate().update("EP_R_ROLE_OPERATION._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpRRoleOperation record) {
        int rows = getSqlMapClientTemplate().update("EP_R_ROLE_OPERATION._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpRRoleOperationExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_R_ROLE_OPERATION._selectByExample", example);
        return list;
    }

    public EpRRoleOperation selectByPrimaryKey(String id) {
        EpRRoleOperation key = new EpRRoleOperation();
        key.setId(id);
        EpRRoleOperation record = (EpRRoleOperation) getSqlMapClientTemplate().queryForObject("EP_R_ROLE_OPERATION._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpRRoleOperationExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_R_ROLE_OPERATION._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpRRoleOperation key = new EpRRoleOperation();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_R_ROLE_OPERATION._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpRRoleOperationExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_R_ROLE_OPERATION._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpRRoleOperation record, EpRRoleOperationExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_ROLE_OPERATION._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpRRoleOperation record, EpRRoleOperationExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_ROLE_OPERATION._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpRRoleOperationExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpRRoleOperationExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}