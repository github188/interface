package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoInputChannelModel;
import com.megaeyes.persistence.ibatis.model.VideoInputChannelModelExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class VideoInputChannelModelDAOImpl extends SqlMapClientDaoSupport implements VideoInputChannelModelDAO {

    public VideoInputChannelModelDAOImpl() {
        super();
    }

    public void insert(VideoInputChannelModel record) {
        getSqlMapClientTemplate().insert("VIDEO_INPUT_CHANNEL_MODEL._insert", record);
    }

    public int updateByPrimaryKey(VideoInputChannelModel record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_CHANNEL_MODEL._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(VideoInputChannelModel record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_CHANNEL_MODEL._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(VideoInputChannelModelExample example) {
        List list = getSqlMapClientTemplate().queryForList("VIDEO_INPUT_CHANNEL_MODEL._selectByExample", example);
        return list;
    }

    public VideoInputChannelModel selectByPrimaryKey(String id) {
        VideoInputChannelModel key = new VideoInputChannelModel();
        key.setId(id);
        VideoInputChannelModel record = (VideoInputChannelModel) getSqlMapClientTemplate().queryForObject("VIDEO_INPUT_CHANNEL_MODEL._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(VideoInputChannelModelExample example) {
        int rows = getSqlMapClientTemplate().delete("VIDEO_INPUT_CHANNEL_MODEL._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        VideoInputChannelModel key = new VideoInputChannelModel();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("VIDEO_INPUT_CHANNEL_MODEL._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(VideoInputChannelModelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("VIDEO_INPUT_CHANNEL_MODEL._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(VideoInputChannelModel record, VideoInputChannelModelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_CHANNEL_MODEL._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(VideoInputChannelModel record, VideoInputChannelModelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_CHANNEL_MODEL._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends VideoInputChannelModelExample {
        private Object record;

        public UpdateByExampleParms(Object record, VideoInputChannelModelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}