package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpIntelligentChannel;
import com.megaeyes.persistence.ibatis.model.EpIntelligentChannelExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpIntelligentChannelDAOImpl extends SqlMapClientDaoSupport implements EpIntelligentChannelDAO {

    public EpIntelligentChannelDAOImpl() {
        super();
    }

    public void insert(EpIntelligentChannel record) {
        getSqlMapClientTemplate().insert("EP_INTELLIGENT_CHANNEL._insert", record);
    }

    public int updateByPrimaryKey(EpIntelligentChannel record) {
        int rows = getSqlMapClientTemplate().update("EP_INTELLIGENT_CHANNEL._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(EpIntelligentChannel record) {
        int rows = getSqlMapClientTemplate().update("EP_INTELLIGENT_CHANNEL._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(EpIntelligentChannelExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_INTELLIGENT_CHANNEL._selectByExample", example);
        return list;
    }

    public EpIntelligentChannel selectByPrimaryKey(String id) {
        EpIntelligentChannel key = new EpIntelligentChannel();
        key.setId(id);
        EpIntelligentChannel record = (EpIntelligentChannel) getSqlMapClientTemplate().queryForObject("EP_INTELLIGENT_CHANNEL._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(EpIntelligentChannelExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_INTELLIGENT_CHANNEL._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        EpIntelligentChannel key = new EpIntelligentChannel();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("EP_INTELLIGENT_CHANNEL._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(EpIntelligentChannelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_INTELLIGENT_CHANNEL._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpIntelligentChannel record, EpIntelligentChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_INTELLIGENT_CHANNEL._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpIntelligentChannel record, EpIntelligentChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_INTELLIGENT_CHANNEL._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpIntelligentChannelExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpIntelligentChannelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}