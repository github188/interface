package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRDeviceVic;
import com.megaeyes.persistence.ibatis.model.EpRDeviceVicExample;
import java.util.List;

public interface EpRDeviceVicDAO {
    void insert(EpRDeviceVic record);

    List selectByExample(EpRDeviceVicExample example);

    int deleteByExample(EpRDeviceVicExample example);

    int countByExample(EpRDeviceVicExample example);

    int updateByExampleSelective(EpRDeviceVic record, EpRDeviceVicExample example);

    int updateByExample(EpRDeviceVic record, EpRDeviceVicExample example);
}