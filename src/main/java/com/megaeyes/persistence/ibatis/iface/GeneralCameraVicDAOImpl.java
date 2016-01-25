package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.GeneralCameraVic;
import com.megaeyes.persistence.ibatis.model.GeneralCameraVicExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class GeneralCameraVicDAOImpl extends SqlMapClientDaoSupport implements GeneralCameraVicDAO {

    public GeneralCameraVicDAOImpl() {
        super();
    }

    public void insert(GeneralCameraVic record) {
        getSqlMapClientTemplate().insert("GENERAL_CAMERA_VIC._insert", record);
    }

    public int updateByPrimaryKey(GeneralCameraVic record) {
        int rows = getSqlMapClientTemplate().update("GENERAL_CAMERA_VIC._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(GeneralCameraVic record) {
        int rows = getSqlMapClientTemplate().update("GENERAL_CAMERA_VIC._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(GeneralCameraVicExample example) {
        List list = getSqlMapClientTemplate().queryForList("GENERAL_CAMERA_VIC._selectByExample", example);
        return list;
    }

    public GeneralCameraVic selectByPrimaryKey(String videoInputChannelId) {
        GeneralCameraVic key = new GeneralCameraVic();
        key.setVideoInputChannelId(videoInputChannelId);
        GeneralCameraVic record = (GeneralCameraVic) getSqlMapClientTemplate().queryForObject("GENERAL_CAMERA_VIC._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(GeneralCameraVicExample example) {
        int rows = getSqlMapClientTemplate().delete("GENERAL_CAMERA_VIC._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String videoInputChannelId) {
        GeneralCameraVic key = new GeneralCameraVic();
        key.setVideoInputChannelId(videoInputChannelId);
        int rows = getSqlMapClientTemplate().delete("GENERAL_CAMERA_VIC._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(GeneralCameraVicExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("GENERAL_CAMERA_VIC._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(GeneralCameraVic record, GeneralCameraVicExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("GENERAL_CAMERA_VIC._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(GeneralCameraVic record, GeneralCameraVicExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("GENERAL_CAMERA_VIC._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends GeneralCameraVicExample {
        private Object record;

        public UpdateByExampleParms(Object record, GeneralCameraVicExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}