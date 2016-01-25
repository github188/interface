package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.DispatchServer;
import com.megaeyes.persistence.ibatis.model.DispatchServerExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DispatchServerDAOImpl extends SqlMapClientDaoSupport implements DispatchServerDAO {

    public DispatchServerDAOImpl() {
        super();
    }

    public void insert(DispatchServer record) {
        getSqlMapClientTemplate().insert("DISPATCH_SERVER._insert", record);
    }

    public int updateByPrimaryKey(DispatchServer record) {
        int rows = getSqlMapClientTemplate().update("DISPATCH_SERVER._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(DispatchServer record) {
        int rows = getSqlMapClientTemplate().update("DISPATCH_SERVER._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(DispatchServerExample example) {
        List list = getSqlMapClientTemplate().queryForList("DISPATCH_SERVER._selectByExample", example);
        return list;
    }

    public DispatchServer selectByPrimaryKey(String id) {
        DispatchServer key = new DispatchServer();
        key.setId(id);
        DispatchServer record = (DispatchServer) getSqlMapClientTemplate().queryForObject("DISPATCH_SERVER._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(DispatchServerExample example) {
        int rows = getSqlMapClientTemplate().delete("DISPATCH_SERVER._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        DispatchServer key = new DispatchServer();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DISPATCH_SERVER._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(DispatchServerExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DISPATCH_SERVER._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(DispatchServer record, DispatchServerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DISPATCH_SERVER._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DispatchServer record, DispatchServerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DISPATCH_SERVER._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends DispatchServerExample {
        private Object record;

        public UpdateByExampleParms(Object record, DispatchServerExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}