package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoOutputChannelModel;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannelModelExample;
import java.util.List;

public interface VideoOutputChannelModelDAO {
    void insert(VideoOutputChannelModel record);

    int updateByPrimaryKey(VideoOutputChannelModel record);

    int updateByPrimaryKeySelective(VideoOutputChannelModel record);

    List selectByExample(VideoOutputChannelModelExample example);

    VideoOutputChannelModel selectByPrimaryKey(String id);

    int deleteByExample(VideoOutputChannelModelExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(VideoOutputChannelModelExample example);

    int updateByExampleSelective(VideoOutputChannelModel record, VideoOutputChannelModelExample example);

    int updateByExample(VideoOutputChannelModel record, VideoOutputChannelModelExample example);
}