package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoOutputChannelModel;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannelModelExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class VideoOutputChannelModelDAOImpl extends SqlMapClientDaoSupport implements VideoOutputChannelModelDAO {

    public VideoOutputChannelModelDAOImpl() {
        super();
    }

    public void insert(VideoOutputChannelModel record) {
        getSqlMapClientTemplate().insert("VIDEO_OUTPUT_CHANNEL_MODEL._insert", record);
    }

    public int updateByPrimaryKey(VideoOutputChannelModel record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_OUTPUT_CHANNEL_MODEL._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(VideoOutputChannelModel record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_OUTPUT_CHANNEL_MODEL._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(VideoOutputChannelModelExample example) {
        List list = getSqlMapClientTemplate().queryForList("VIDEO_OUTPUT_CHANNEL_MODEL._selectByExample", example);
        return list;
    }

    public VideoOutputChannelModel selectByPrimaryKey(String id) {
        VideoOutputChannelModel key = new VideoOutputChannelModel();
        key.setId(id);
        VideoOutputChannelModel record = (VideoOutputChannelModel) getSqlMapClientTemplate().queryForObject("VIDEO_OUTPUT_CHANNEL_MODEL._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(VideoOutputChannelModelExample example) {
        int rows = getSqlMapClientTemplate().delete("VIDEO_OUTPUT_CHANNEL_MODEL._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        VideoOutputChannelModel key = new VideoOutputChannelModel();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("VIDEO_OUTPUT_CHANNEL_MODEL._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(VideoOutputChannelModelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("VIDEO_OUTPUT_CHANNEL_MODEL._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(VideoOutputChannelModel record, VideoOutputChannelModelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_OUTPUT_CHANNEL_MODEL._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(VideoOutputChannelModel record, VideoOutputChannelModelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_OUTPUT_CHANNEL_MODEL._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends VideoOutputChannelModelExample {
        private Object record;

        public UpdateByExampleParms(Object record, VideoOutputChannelModelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}