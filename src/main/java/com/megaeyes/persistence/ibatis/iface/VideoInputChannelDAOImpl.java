package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.model.VideoInputChannelExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class VideoInputChannelDAOImpl extends SqlMapClientDaoSupport implements VideoInputChannelDAO {

    public VideoInputChannelDAOImpl() {
        super();
    }

    public void insert(VideoInputChannel record) {
        getSqlMapClientTemplate().insert("VIDEO_INPUT_CHANNEL._insert", record);
    }

    public int updateByPrimaryKey(VideoInputChannel record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_CHANNEL._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(VideoInputChannel record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_CHANNEL._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(VideoInputChannelExample example) {
        List list = getSqlMapClientTemplate().queryForList("VIDEO_INPUT_CHANNEL._selectByExample", example);
        return list;
    }

    public VideoInputChannel selectByPrimaryKey(String id) {
        VideoInputChannel key = new VideoInputChannel();
        key.setId(id);
        VideoInputChannel record = (VideoInputChannel) getSqlMapClientTemplate().queryForObject("VIDEO_INPUT_CHANNEL._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(VideoInputChannelExample example) {
        int rows = getSqlMapClientTemplate().delete("VIDEO_INPUT_CHANNEL._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        VideoInputChannel key = new VideoInputChannel();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("VIDEO_INPUT_CHANNEL._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(VideoInputChannelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("VIDEO_INPUT_CHANNEL._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(VideoInputChannel record, VideoInputChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_CHANNEL._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(VideoInputChannel record, VideoInputChannelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_CHANNEL._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends VideoInputChannelExample {
        private Object record;

        public UpdateByExampleParms(Object record, VideoInputChannelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}