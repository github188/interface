package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoInputServerModel;
import com.megaeyes.persistence.ibatis.model.VideoInputServerModelExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class VideoInputServerModelDAOImpl extends SqlMapClientDaoSupport implements VideoInputServerModelDAO {

    public VideoInputServerModelDAOImpl() {
        super();
    }

    public void insert(VideoInputServerModel record) {
        getSqlMapClientTemplate().insert("VIDEO_INPUT_SERVER_MODEL._insert", record);
    }

    public int updateByPrimaryKey(VideoInputServerModel record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_SERVER_MODEL._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(VideoInputServerModel record) {
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_SERVER_MODEL._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(VideoInputServerModelExample example) {
        List list = getSqlMapClientTemplate().queryForList("VIDEO_INPUT_SERVER_MODEL._selectByExample", example);
        return list;
    }

    public VideoInputServerModel selectByPrimaryKey(String id) {
        VideoInputServerModel key = new VideoInputServerModel();
        key.setId(id);
        VideoInputServerModel record = (VideoInputServerModel) getSqlMapClientTemplate().queryForObject("VIDEO_INPUT_SERVER_MODEL._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(VideoInputServerModelExample example) {
        int rows = getSqlMapClientTemplate().delete("VIDEO_INPUT_SERVER_MODEL._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String id) {
        VideoInputServerModel key = new VideoInputServerModel();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("VIDEO_INPUT_SERVER_MODEL._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(VideoInputServerModelExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("VIDEO_INPUT_SERVER_MODEL._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(VideoInputServerModel record, VideoInputServerModelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_SERVER_MODEL._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(VideoInputServerModel record, VideoInputServerModelExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("VIDEO_INPUT_SERVER_MODEL._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends VideoInputServerModelExample {
        private Object record;

        public UpdateByExampleParms(Object record, VideoInputServerModelExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}