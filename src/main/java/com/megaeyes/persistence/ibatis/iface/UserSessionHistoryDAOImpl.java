package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.UserSessionHistory;
import com.megaeyes.persistence.ibatis.model.UserSessionHistoryExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class UserSessionHistoryDAOImpl extends SqlMapClientDaoSupport implements UserSessionHistoryDAO {

    public UserSessionHistoryDAOImpl() {
        super();
    }

    public void insert(UserSessionHistory record) {
        getSqlMapClientTemplate().insert("USER_SESSION_HISTORY._insert", record);
    }

    public int updateByPrimaryKey(UserSessionHistory record) {
        int rows = getSqlMapClientTemplate().update("USER_SESSION_HISTORY._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(UserSessionHistory record) {
        int rows = getSqlMapClientTemplate().update("USER_SESSION_HISTORY._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(UserSessionHistoryExample example) {
        List list = getSqlMapClientTemplate().queryForList("USER_SESSION_HISTORY._selectByExample", example);
        return list;
    }

    public UserSessionHistory selectByPrimaryKey(String id) {
        UserSessionHistory key = new UserSessionHistory();
        key.setId(id);
        UserSessionHistory record = (UserSessionHistory) getSqlMapClientTemplate().queryForObject("USER_SESSION_HISTORY._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(UserSessionHistoryExample example) {
        int rows = getSqlMapClientTemplate().delete("USER_SESSION_HISTORY._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        UserSessionHistory key = new UserSessionHistory();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("USER_SESSION_HISTORY._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(UserSessionHistoryExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("USER_SESSION_HISTORY._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(UserSessionHistory record, UserSessionHistoryExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("USER_SESSION_HISTORY._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(UserSessionHistory record, UserSessionHistoryExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("USER_SESSION_HISTORY._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends UserSessionHistoryExample {
        private Object record;

        public UpdateByExampleParms(Object record, UserSessionHistoryExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}