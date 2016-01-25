package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.IpCameraVic;
import com.megaeyes.persistence.ibatis.model.IpCameraVicExample;
import java.util.List;

public interface IpCameraVicDAO {
    void insert(IpCameraVic record);

    int updateByPrimaryKey(IpCameraVic record);

    int updateByPrimaryKeySelective(IpCameraVic record);

    List selectByExample(IpCameraVicExample example);

    IpCameraVic selectByPrimaryKey(String videoInputChannelId);

    int deleteByExample(IpCameraVicExample example);

    int deleteByPrimaryKey(String videoInputChannelId);

    int countByExample(IpCameraVicExample example);

    int updateByExampleSelective(IpCameraVic record, IpCameraVicExample example);

    int updateByExample(IpCameraVic record, IpCameraVicExample example);
}