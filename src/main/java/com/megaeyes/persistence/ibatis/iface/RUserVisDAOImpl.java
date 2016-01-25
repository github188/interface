package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.RUserVis;
import com.megaeyes.persistence.ibatis.model.RUserVisExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RUserVisDAOImpl extends SqlMapClientDaoSupport implements RUserVisDAO {

    public RUserVisDAOImpl() {
        super();
    }

    public void insert(RUserVis record) {
        getSqlMapClientTemplate().insert("R_USER_VIS._insert", record);
    }

    public int updateByPrimaryKey(RUserVis record) {
        int rows = getSqlMapClientTemplate().update("R_USER_VIS._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(RUserVis record) {
        int rows = getSqlMapClientTemplate().update("R_USER_VIS._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(RUserVisExample example) {
        List list = getSqlMapClientTemplate().queryForList("R_USER_VIS._selectByExample", example);
        return list;
    }

    public RUserVis selectByPrimaryKey(String id) {
        RUserVis key = new RUserVis();
        key.setId(id);
        RUserVis record = (RUserVis) getSqlMapClientTemplate().queryForObject("R_USER_VIS._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(RUserVisExample example) {
        int rows = getSqlMapClientTemplate().delete("R_USER_VIS._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        RUserVis key = new RUserVis();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("R_USER_VIS._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(RUserVisExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("R_USER_VIS._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(RUserVis record, RUserVisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_USER_VIS._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RUserVis record, RUserVisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("R_USER_VIS._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends RUserVisExample {
        private Object record;

        public UpdateByExampleParms(Object record, RUserVisExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}