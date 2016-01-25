package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRMonitorDevice;
import com.megaeyes.persistence.ibatis.model.EpRMonitorDeviceExample;
import java.util.List;

public interface EpRMonitorDeviceDAO {
    void insert(EpRMonitorDevice record);

    int updateByPrimaryKey(EpRMonitorDevice record);

    int updateByPrimaryKeySelective(EpRMonitorDevice record);

    List selectByExample(EpRMonitorDeviceExample example);

    EpRMonitorDevice selectByPrimaryKey(String id);

    int deleteByExample(EpRMonitorDeviceExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpRMonitorDeviceExample example);

    int updateByExampleSelective(EpRMonitorDevice record, EpRMonitorDeviceExample example);

    int updateByExample(EpRMonitorDevice record, EpRMonitorDeviceExample example);
}