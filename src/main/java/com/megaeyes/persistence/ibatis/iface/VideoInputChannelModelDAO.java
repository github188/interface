package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoInputChannelModel;
import com.megaeyes.persistence.ibatis.model.VideoInputChannelModelExample;
import java.util.List;

public interface VideoInputChannelModelDAO {
    void insert(VideoInputChannelModel record);

    int updateByPrimaryKey(VideoInputChannelModel record);

    int updateByPrimaryKeySelective(VideoInputChannelModel record);

    List selectByExample(VideoInputChannelModelExample example);

    VideoInputChannelModel selectByPrimaryKey(String id);

    int deleteByExample(VideoInputChannelModelExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(VideoInputChannelModelExample example);

    int updateByExampleSelective(VideoInputChannelModel record, VideoInputChannelModelExample example);

    int updateByExample(VideoInputChannelModel record, VideoInputChannelModelExample example);
}