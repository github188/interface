package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpMonitorDevice;
import com.megaeyes.persistence.ibatis.model.EpMonitorDeviceExample;
import java.util.List;

public interface EpMonitorDeviceDAO {
    void insert(EpMonitorDevice record);

    int updateByPrimaryKey(EpMonitorDevice record);

    int updateByPrimaryKeySelective(EpMonitorDevice record);

    List selectByExample(EpMonitorDeviceExample example);

    EpMonitorDevice selectByPrimaryKey(String id);

    int deleteByExample(EpMonitorDeviceExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpMonitorDeviceExample example);

    int updateByExampleSelective(EpMonitorDevice record, EpMonitorDeviceExample example);

    int updateByExample(EpMonitorDevice record, EpMonitorDeviceExample example);
}