package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.IpCameraVic;
import com.megaeyes.persistence.ibatis.model.IpCameraVicExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IpCameraVicDAOImpl extends SqlMapClientDaoSupport implements IpCameraVicDAO {

    public IpCameraVicDAOImpl() {
        super();
    }

    public void insert(IpCameraVic record) {
        getSqlMapClientTemplate().insert("IP_CAMERA_VIC._insert", record);
    }

    public int updateByPrimaryKey(IpCameraVic record) {
        int rows = getSqlMapClientTemplate().update("IP_CAMERA_VIC._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(IpCameraVic record) {
        int rows = getSqlMapClientTemplate().update("IP_CAMERA_VIC._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(IpCameraVicExample example) {
        List list = getSqlMapClientTemplate().queryForList("IP_CAMERA_VIC._selectByExample", example);
        return list;
    }

    public IpCameraVic selectByPrimaryKey(String videoInputChannelId) {
        IpCameraVic key = new IpCameraVic();
        key.setVideoInputChannelId(videoInputChannelId);
        IpCameraVic record = (IpCameraVic) getSqlMapClientTemplate().queryForObject("IP_CAMERA_VIC._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(IpCameraVicExample example) {
        int rows = getSqlMapClientTemplate().delete("IP_CAMERA_VIC._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String videoInputChannelId) {
        IpCameraVic key = new IpCameraVic();
        key.setVideoInputChannelId(videoInputChannelId);
        int rows = getSqlMapClientTemplate().delete("IP_CAMERA_VIC._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(IpCameraVicExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("IP_CAMERA_VIC._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(IpCameraVic record, IpCameraVicExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("IP_CAMERA_VIC._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(IpCameraVic record, IpCameraVicExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("IP_CAMERA_VIC._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends IpCameraVicExample {
        private Object record;

        public UpdateByExampleParms(Object record, IpCameraVicExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}