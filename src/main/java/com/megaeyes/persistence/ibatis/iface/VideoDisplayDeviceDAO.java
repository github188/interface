package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoDisplayDevice;
import com.megaeyes.persistence.ibatis.model.VideoDisplayDeviceExample;
import java.util.List;

public interface VideoDisplayDeviceDAO {
    void insert(VideoDisplayDevice record);

    int updateByPrimaryKey(VideoDisplayDevice record);

    int updateByPrimaryKeySelective(VideoDisplayDevice record);

    List selectByExample(VideoDisplayDeviceExample example);

    VideoDisplayDevice selectByPrimaryKey(String id);

    int deleteByExample(VideoDisplayDeviceExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(VideoDisplayDeviceExample example);

    int updateByExampleSelective(VideoDisplayDevice record, VideoDisplayDeviceExample example);

    int updateByExample(VideoDisplayDevice record, VideoDisplayDeviceExample example);
}