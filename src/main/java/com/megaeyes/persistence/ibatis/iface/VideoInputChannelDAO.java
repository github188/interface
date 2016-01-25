package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.persistence.ibatis.model.VideoInputChannelExample;
import java.util.List;

public interface VideoInputChannelDAO {
    void insert(VideoInputChannel record);

    int updateByPrimaryKey(VideoInputChannel record);

    int updateByPrimaryKeySelective(VideoInputChannel record);

    List selectByExample(VideoInputChannelExample example);

    VideoInputChannel selectByPrimaryKey(String id);

    int deleteByExample(VideoInputChannelExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(VideoInputChannelExample example);

    int updateByExampleSelective(VideoInputChannel record, VideoInputChannelExample example);

    int updateByExample(VideoInputChannel record, VideoInputChannelExample example);
}