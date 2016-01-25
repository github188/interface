package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.GeneralCameraVic;
import com.megaeyes.persistence.ibatis.model.GeneralCameraVicExample;
import java.util.List;

public interface GeneralCameraVicDAO {
    void insert(GeneralCameraVic record);

    int updateByPrimaryKey(GeneralCameraVic record);

    int updateByPrimaryKeySelective(GeneralCameraVic record);

    List selectByExample(GeneralCameraVicExample example);

    GeneralCameraVic selectByPrimaryKey(String videoInputChannelId);

    int deleteByExample(GeneralCameraVicExample example);

    int deleteByPrimaryKey(String videoInputChannelId);

    int countByExample(GeneralCameraVicExample example);

    int updateByExampleSelective(GeneralCameraVic record, GeneralCameraVicExample example);

    int updateByExample(GeneralCameraVic record, GeneralCameraVicExample example);
}