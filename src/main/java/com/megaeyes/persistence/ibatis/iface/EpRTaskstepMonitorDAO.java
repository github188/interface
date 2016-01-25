package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRTaskstepMonitor;
import com.megaeyes.persistence.ibatis.model.EpRTaskstepMonitorExample;
import java.util.List;

public interface EpRTaskstepMonitorDAO {
    void insert(EpRTaskstepMonitor record);

    List selectByExample(EpRTaskstepMonitorExample example);

    int deleteByExample(EpRTaskstepMonitorExample example);

    int countByExample(EpRTaskstepMonitorExample example);

    int updateByExampleSelective(EpRTaskstepMonitor record, EpRTaskstepMonitorExample example);

    int updateByExample(EpRTaskstepMonitor record, EpRTaskstepMonitorExample example);
}