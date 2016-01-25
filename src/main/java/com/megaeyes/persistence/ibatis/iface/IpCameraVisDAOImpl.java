package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.IpCameraVis;
import com.megaeyes.persistence.ibatis.model.IpCameraVisExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IpCameraVisDAOImpl extends SqlMapClientDaoSupport implements IpCameraVisDAO {

    public IpCameraVisDAOImpl() {
        super();
    }

    public void insert(IpCameraVis record) {
        getSqlMapClientTemplate().insert("IP_CAMERA_VIS._insert", record);
    }

    public int updateByPrimaryKey(IpCameraVis record) {
        int rows = getSqlMapClientTemplate().update("IP_CAMERA_VIS._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(IpCameraVis record) {
        int rows = getSqlMapClientTemplate().update("IP_CAMERA_VIS._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(IpCameraVisExample example) {
        List list = getSqlMapClientTemplate().queryForList("IP_CAMERA_VIS._selectByExample", example);
        return list;
    }

    public IpCameraVis selectByPrimaryKey(String videoInputServerId) {
        IpCameraVis key = new IpCameraVis();
        key.setVideoInputServerId(videoInputServerId);
        IpCameraVis record = (IpCameraVis) getSqlMapClientTemplate().queryForObject("IP_CAMERA_VIS._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(IpCameraVisExample example) {
        int rows = getSqlMapClientTemplate().delete("IP_CAMERA_VIS._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String videoInputServerId) {
        IpCameraVis key = new IpCameraVis();
        key.setVideoInputServerId(videoInputServerId);
        int rows = getSqlMapClientTemplate().delete("IP_CAMERA_VIS._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(IpCameraVisExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("IP_CAMERA_VIS._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(IpCameraVis record, IpCameraVisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("IP_CAMERA_VIS._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(IpCameraVis record, IpCameraVisExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("IP_CAMERA_VIS._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends IpCameraVisExample {
        private Object record;

        public UpdateByExampleParms(Object record, IpCameraVisExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}