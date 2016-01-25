package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.VideoInputServerModel;
import com.megaeyes.persistence.ibatis.model.VideoInputServerModelExample;
import java.util.List;

public interface VideoInputServerModelDAO {
    void insert(VideoInputServerModel record);

    int updateByPrimaryKey(VideoInputServerModel record);

    int updateByPrimaryKeySelective(VideoInputServerModel record);

    List selectByExample(VideoInputServerModelExample example);

    VideoInputServerModel selectByPrimaryKey(String id);

    int deleteByExample(VideoInputServerModelExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(VideoInputServerModelExample example);

    int updateByExampleSelective(VideoInputServerModel record, VideoInputServerModelExample example);

    int updateByExample(VideoInputServerModel record, VideoInputServerModelExample example);
}