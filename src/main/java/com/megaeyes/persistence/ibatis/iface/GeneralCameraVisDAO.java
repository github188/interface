package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.GeneralCameraVis;
import com.megaeyes.persistence.ibatis.model.GeneralCameraVisExample;
import java.util.List;

public interface GeneralCameraVisDAO {
    void insert(GeneralCameraVis record);

    List selectByExample(GeneralCameraVisExample example);

    int deleteByExample(GeneralCameraVisExample example);

    int deleteByPrimaryKey(String videoInputServerId);

    int countByExample(GeneralCameraVisExample example);

    int updateByExampleSelective(GeneralCameraVis record, GeneralCameraVisExample example);

    int updateByExample(GeneralCameraVis record, GeneralCameraVisExample example);
}