package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.GeneralCameraVis;
import com.megaeyes.persistence.ibatis.model.GeneralCameraVisExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class GeneralCameraVisDAOImpl extends SqlMapClientDaoSupport implements GeneralCameraVisDAO {

    public GeneralCameraVisDAOImpl() {
        super();
    }

    public void insert(GeneralCameraVis record) {
        getSqlMapClientTemplate().insert("GENERAL_CAMERA_VIS._insert", record);
    }

    public List selectByExample(GeneralCameraVisExample example) {
        List list = getSqlMapClientTemplate().queryForList("GENERAL_CAMERA_VIS._selectByExample", example);
        return list;
    }

    public int deleteByExample(GeneralCameraVisExample example) {
        int rows = getSqlMapClientTemplate().delete("GENERAL_CAMERA_VIS._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String videoInputServerId) {
        GeneralCameraVis key = new GeneralCameraVis();
        key.setVideoInputServerId(videoInputServerId);
        int rows = getSqlMapClientTemplate().delete("GENERAL_CAMERA_VIS._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(GeneralCameraVisExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("GENERAL_CAMERA_VIS._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(GeneralCameraVis record, GeneralCameraVisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("GENERAL_CAMERA_VIS._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(GeneralCameraVis record, GeneralCameraVisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("GENERAL_CAMERA_VIS._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends GeneralCameraVisExample {
        private Object record;

        public UpdateByExampleParms(Object record, GeneralCameraVisExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}