package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoDisplayDevice;
import com.megaeyes.persistence.ibatis.model.VideoDisplayDeviceExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class VideoDisplayDeviceDAOImpl extends SqlMapClientDaoSupport implements VideoDisplayDeviceDAO {

    public VideoDisplayDeviceDAOImpl() {
        super();
    }

    public void insert(VideoDisplayDevice record) {
        getSqlMapClientTemplate().insert("VIDEO_DISPLAY_DEVICE._insert", record);
    }

    public int updateByPrimaryKey(VideoDisplayDevice record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_DISPLAY_DEVICE._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(VideoDisplayDevice record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_DISPLAY_DEVICE._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(VideoDisplayDeviceExample example) {
        List list = getSqlMapClientTemplate().queryForList("VIDEO_DISPLAY_DEVICE._selectByExample", example);
        return list;
    }

    public VideoDisplayDevice selectByPrimaryKey(String id) {
        VideoDisplayDevice key = new VideoDisplayDevice();
        key.setId(id);
        VideoDisplayDevice record = (VideoDisplayDevice) getSqlMapClientTemplate().queryForObject("VIDEO_DISPLAY_DEVICE._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(VideoDisplayDeviceExample example) {
        int rows = getSqlMapClientTemplate().delete("VIDEO_DISPLAY_DEVICE._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        VideoDisplayDevice key = new VideoDisplayDevice();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("VIDEO_DISPLAY_DEVICE._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(VideoDisplayDeviceExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("VIDEO_DISPLAY_DEVICE._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(VideoDisplayDevice record, VideoDisplayDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_DISPLAY_DEVICE._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(VideoDisplayDevice record, VideoDisplayDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_DISPLAY_DEVICE._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends VideoDisplayDeviceExample {
        private Object record;

        public UpdateByExampleParms(Object record, VideoDisplayDeviceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}