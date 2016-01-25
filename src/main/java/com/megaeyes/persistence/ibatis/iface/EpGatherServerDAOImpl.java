package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpGatherServer;
import com.megaeyes.persistence.ibatis.model.EpGatherServerExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpGatherServerDAOImpl extends SqlMapClientDaoSupport implements EpGatherServerDAO {

    public EpGatherServerDAOImpl() {
        super();
    }

    public void insert(EpGatherServer record) {
        getSqlMapClientTemplate().insert("EP_GATHER_SERVER._insert", record);
    }

    public int updateByPrimaryKey(EpGatherServer record) {
        int rows = getSqlMapClientTemplate().update("EP_GATHER_SERVER._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpGatherServer record) {
        int rows = getSqlMapClientTemplate().update("EP_GATHER_SERVER._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpGatherServerExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_GATHER_SERVER._selectByExample", example);
        return list;
    }

    public EpGatherServer selectByPrimaryKey(String id) {
        EpGatherServer key = new EpGatherServer();
        key.setId(id);
        EpGatherServer record = (EpGatherServer) getSqlMapClientTemplate().queryForObject("EP_GATHER_SERVER._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpGatherServerExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_GATHER_SERVER._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpGatherServer key = new EpGatherServer();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_GATHER_SERVER._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpGatherServerExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_GATHER_SERVER._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpGatherServer record, EpGatherServerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_GATHER_SERVER._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpGatherServer record, EpGatherServerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_GATHER_SERVER._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpGatherServerExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpGatherServerExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}