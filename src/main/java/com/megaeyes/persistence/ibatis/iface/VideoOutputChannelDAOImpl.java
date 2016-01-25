package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannelExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class VideoOutputChannelDAOImpl extends SqlMapClientDaoSupport implements VideoOutputChannelDAO {

    public VideoOutputChannelDAOImpl() {
        super();
    }

    public void insert(VideoOutputChannel record) {
        getSqlMapClientTemplate().insert("VIDEO_OUTPUT_CHANNEL._insert", record);
    }

    public int updateByPrimaryKey(VideoOutputChannel record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_OUTPUT_CHANNEL._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(VideoOutputChannel record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_OUTPUT_CHANNEL._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(VideoOutputChannelExample example) {
        List list = getSqlMapClientTemplate().queryForList("VIDEO_OUTPUT_CHANNEL._selectByExample", example);
        return list;
    }

    public VideoOutputChannel selectByPrimaryKey(String id) {
        VideoOutputChannel key = new VideoOutputChannel();
        key.setId(id);
        VideoOutputChannel record = (VideoOutputChannel) getSqlMapClientTemplate().queryForObject("VIDEO_OUTPUT_CHANNEL._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(VideoOutputChannelExample example) {
        int rows = getSqlMapClientTemplate().delete("VIDEO_OUTPUT_CHANNEL._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        VideoOutputChannel key = new VideoOutputChannel();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("VIDEO_OUTPUT_CHANNEL._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(VideoOutputChannelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("VIDEO_OUTPUT_CHANNEL._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(VideoOutputChannel record, VideoOutputChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_OUTPUT_CHANNEL._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(VideoOutputChannel record, VideoOutputChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_OUTPUT_CHANNEL._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends VideoOutputChannelExample {
        private Object record;

        public UpdateByExampleParms(Object record, VideoOutputChannelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}