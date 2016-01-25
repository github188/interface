package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.UserSession;
import com.megaeyes.persistence.ibatis.model.UserSessionExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class UserSessionDAOImpl extends SqlMapClientDaoSupport implements UserSessionDAO {

    public UserSessionDAOImpl() {
        super();
    }

    public void insert(UserSession record) {
        getSqlMapClientTemplate().insert("USER_SESSION._insert", record);
    }

    public int updateByPrimaryKey(UserSession record) {
        int rows = getSqlMapClientTemplate().update("USER_SESSION._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(UserSession record) {
        int rows = getSqlMapClientTemplate().update("USER_SESSION._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(UserSessionExample example) {
        List list = getSqlMapClientTemplate().queryForList("USER_SESSION._selectByExample", example);
        return list;
    }

    public UserSession selectByPrimaryKey(String id) {
        UserSession key = new UserSession();
        key.setId(id);
        UserSession record = (UserSession) getSqlMapClientTemplate().queryForObject("USER_SESSION._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(UserSessionExample example) {
        int rows = getSqlMapClientTemplate().delete("USER_SESSION._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        UserSession key = new UserSession();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("USER_SESSION._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(UserSessionExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("USER_SESSION._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(UserSession record, UserSessionExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("USER_SESSION._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(UserSession record, UserSessionExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("USER_SESSION._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends UserSessionExample {
        private Object record;

        public UpdateByExampleParms(Object record, UserSessionExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}