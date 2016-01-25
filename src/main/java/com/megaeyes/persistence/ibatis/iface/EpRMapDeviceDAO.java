package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRMapDevice;
import com.megaeyes.persistence.ibatis.model.EpRMapDeviceExample;
import java.util.List;

public interface EpRMapDeviceDAO {
    void insert(EpRMapDevice record);

    int updateByPrimaryKey(EpRMapDevice record);

    int updateByPrimaryKeySelective(EpRMapDevice record);

    List selectByExample(EpRMapDeviceExample example);

    EpRMapDevice selectByPrimaryKey(String id);

    int deleteByExample(EpRMapDeviceExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpRMapDeviceExample example);

    int updateByExampleSelective(EpRMapDevice record, EpRMapDeviceExample example);

    int updateByExample(EpRMapDevice record, EpRMapDeviceExample example);
}