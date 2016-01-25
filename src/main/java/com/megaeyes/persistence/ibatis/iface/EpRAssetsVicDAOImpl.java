package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRAssetsVic;
import com.megaeyes.persistence.ibatis.model.EpRAssetsVicExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpRAssetsVicDAOImpl extends SqlMapClientDaoSupport implements EpRAssetsVicDAO {

    public EpRAssetsVicDAOImpl() {
        super();
    }

    public void insert(EpRAssetsVic record) {
        getSqlMapClientTemplate().insert("EP_R_ASSETS_VIC._insert", record);
    }

    public int updateByPrimaryKey(EpRAssetsVic record) {
        int rows = getSqlMapClientTemplate().update("EP_R_ASSETS_VIC._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpRAssetsVic record) {
        int rows = getSqlMapClientTemplate().update("EP_R_ASSETS_VIC._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpRAssetsVicExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_R_ASSETS_VIC._selectByExample", example);
        return list;
    }

    public EpRAssetsVic selectByPrimaryKey(String id) {
        EpRAssetsVic key = new EpRAssetsVic();
        key.setId(id);
        EpRAssetsVic record = (EpRAssetsVic) getSqlMapClientTemplate().queryForObject("EP_R_ASSETS_VIC._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpRAssetsVicExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_R_ASSETS_VIC._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpRAssetsVic key = new EpRAssetsVic();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_R_ASSETS_VIC._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpRAssetsVicExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_R_ASSETS_VIC._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpRAssetsVic record, EpRAssetsVicExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_ASSETS_VIC._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpRAssetsVic record, EpRAssetsVicExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_ASSETS_VIC._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpRAssetsVicExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpRAssetsVicExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}