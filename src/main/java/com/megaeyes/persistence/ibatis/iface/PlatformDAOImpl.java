package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.Platform;
import com.megaeyes.persistence.ibatis.model.PlatformExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PlatformDAOImpl extends SqlMapClientDaoSupport implements PlatformDAO {

    public PlatformDAOImpl() {
        super();
    }

    public void insert(Platform record) {
        getSqlMapClientTemplate().insert("PLATFORM._insert", record);
    }

    public int updateByPrimaryKey(Platform record) {
        int rows = getSqlMapClientTemplate().update("PLATFORM._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(Platform record) {
        int rows = getSqlMapClientTemplate().update("PLATFORM._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(PlatformExample example) {
        List list = getSqlMapClientTemplate().queryForList("PLATFORM._selectByExample", example);
        return list;
    }

    public Platform selectByPrimaryKey(String id) {
        Platform key = new Platform();
        key.setId(id);
        Platform record = (Platform) getSqlMapClientTemplate().queryForObject("PLATFORM._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(PlatformExample example) {
        int rows = getSqlMapClientTemplate().delete("PLATFORM._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        Platform key = new Platform();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("PLATFORM._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(PlatformExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("PLATFORM._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(Platform record, PlatformExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("PLATFORM._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(Platform record, PlatformExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("PLATFORM._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends PlatformExample {
        private Object record;

        public UpdateByExampleParms(Object record, PlatformExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}