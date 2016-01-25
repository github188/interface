package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.PlatformResourcesExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PlatformResourcesDAOImpl extends SqlMapClientDaoSupport implements PlatformResourcesDAO {

    public PlatformResourcesDAOImpl() {
        super();
    }

    public void insert(PlatformResources record) {
        getSqlMapClientTemplate().insert("PLATFORM_RESOURCES._insert", record);
    }

    public int updateByPrimaryKey(PlatformResources record) {
        int rows = getSqlMapClientTemplate().update("PLATFORM_RESOURCES._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(PlatformResources record) {
        int rows = getSqlMapClientTemplate().update("PLATFORM_RESOURCES._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(PlatformResourcesExample example) {
        List list = getSqlMapClientTemplate().queryForList("PLATFORM_RESOURCES._selectByExample", example);
        return list;
    }

    public PlatformResources selectByPrimaryKey(String id) {
        PlatformResources key = new PlatformResources();
        key.setId(id);
        PlatformResources record = (PlatformResources) getSqlMapClientTemplate().queryForObject("PLATFORM_RESOURCES._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(PlatformResourcesExample example) {
        int rows = getSqlMapClientTemplate().delete("PLATFORM_RESOURCES._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        PlatformResources key = new PlatformResources();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("PLATFORM_RESOURCES._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(PlatformResourcesExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("PLATFORM_RESOURCES._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(PlatformResources record, PlatformResourcesExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("PLATFORM_RESOURCES._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(PlatformResources record, PlatformResourcesExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("PLATFORM_RESOURCES._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends PlatformResourcesExample {
        private Object record;

        public UpdateByExampleParms(Object record, PlatformResourcesExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}