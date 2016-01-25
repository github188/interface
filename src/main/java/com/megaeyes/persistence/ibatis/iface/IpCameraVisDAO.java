package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.IpCameraVis;
import com.megaeyes.persistence.ibatis.model.IpCameraVisExample;
import java.util.List;

public interface IpCameraVisDAO {
    void insert(IpCameraVis record);

    int updateByPrimaryKey(IpCameraVis record);

    int updateByPrimaryKeySelective(IpCameraVis record);

    List selectByExample(IpCameraVisExample example);

    IpCameraVis selectByPrimaryKey(String videoInputServerId);

    int deleteByExample(IpCameraVisExample example);

    int deleteByPrimaryKey(String videoInputServerId);

    int countByExample(IpCameraVisExample example);

    int updateByExampleSelective(IpCameraVis record, IpCameraVisExample example);

    int updateByExample(IpCameraVis record, IpCameraVisExample example);
}