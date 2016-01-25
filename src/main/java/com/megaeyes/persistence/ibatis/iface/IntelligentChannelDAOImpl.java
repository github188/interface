package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.IntelligentChannel;
import com.megaeyes.persistence.ibatis.model.IntelligentChannelExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IntelligentChannelDAOImpl extends SqlMapClientDaoSupport implements IntelligentChannelDAO {

    public IntelligentChannelDAOImpl() {
        super();
    }

    public void insert(IntelligentChannel record) {
        getSqlMapClientTemplate().insert("INTELLIGENT_CHANNEL._insert", record);
    }

    public int updateByPrimaryKey(IntelligentChannel record) {
        int rows = getSqlMapClientTemplate().update("INTELLIGENT_CHANNEL._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(IntelligentChannel record) {
        int rows = getSqlMapClientTemplate().update("INTELLIGENT_CHANNEL._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(IntelligentChannelExample example) {
        List list = getSqlMapClientTemplate().queryForList("INTELLIGENT_CHANNEL._selectByExample", example);
        return list;
    }

    public IntelligentChannel selectByPrimaryKey(String id) {
        IntelligentChannel key = new IntelligentChannel();
        key.setId(id);
        IntelligentChannel record = (IntelligentChannel) getSqlMapClientTemplate().queryForObject("INTELLIGENT_CHANNEL._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(IntelligentChannelExample example) {
        int rows = getSqlMapClientTemplate().delete("INTELLIGENT_CHANNEL._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        IntelligentChannel key = new IntelligentChannel();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("INTELLIGENT_CHANNEL._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(IntelligentChannelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("INTELLIGENT_CHANNEL._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(IntelligentChannel record, IntelligentChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("INTELLIGENT_CHANNEL._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(IntelligentChannel record, IntelligentChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("INTELLIGENT_CHANNEL._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends IntelligentChannelExample {
        private Object record;

        public UpdateByExampleParms(Object record, IntelligentChannelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}