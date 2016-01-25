package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpSchemeCommand;
import com.megaeyes.persistence.ibatis.model.EpSchemeCommandExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpSchemeCommandDAOImpl extends SqlMapClientDaoSupport implements EpSchemeCommandDAO {

    public EpSchemeCommandDAOImpl() {
        super();
    }

    public void insert(EpSchemeCommand record) {
        getSqlMapClientTemplate().insert("EP_SCHEME_COMMAND._insert", record);
    }

    public int updateByPrimaryKey(EpSchemeCommand record) {
        int rows = getSqlMapClientTemplate().update("EP_SCHEME_COMMAND._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpSchemeCommand record) {
        int rows = getSqlMapClientTemplate().update("EP_SCHEME_COMMAND._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpSchemeCommandExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_SCHEME_COMMAND._selectByExample", example);
        return list;
    }

    public EpSchemeCommand selectByPrimaryKey(String id) {
        EpSchemeCommand key = new EpSchemeCommand();
        key.setId(id);
        EpSchemeCommand record = (EpSchemeCommand) getSqlMapClientTemplate().queryForObject("EP_SCHEME_COMMAND._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpSchemeCommandExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_SCHEME_COMMAND._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpSchemeCommand key = new EpSchemeCommand();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_SCHEME_COMMAND._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpSchemeCommandExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_SCHEME_COMMAND._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpSchemeCommand record, EpSchemeCommandExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_SCHEME_COMMAND._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpSchemeCommand record, EpSchemeCommandExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_SCHEME_COMMAND._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpSchemeCommandExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpSchemeCommandExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}