package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannelExample;
import java.util.List;

public interface VideoOutputChannelDAO {
    void insert(VideoOutputChannel record);

    int updateByPrimaryKey(VideoOutputChannel record);

    int updateByPrimaryKeySelective(VideoOutputChannel record);

    List selectByExample(VideoOutputChannelExample example);

    VideoOutputChannel selectByPrimaryKey(String id);

    int deleteByExample(VideoOutputChannelExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(VideoOutputChannelExample example);

    int updateByExampleSelective(VideoOutputChannel record, VideoOutputChannelExample example);

    int updateByExample(VideoOutputChannel record, VideoOutputChannelExample example);
}