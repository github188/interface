package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.RUserVis;
import com.megaeyes.persistence.ibatis.model.RUserVisExample;
import java.util.List;

public interface RUserVisDAO {
    void insert(RUserVis record);

    int updateByPrimaryKey(RUserVis record);

    int updateByPrimaryKeySelective(RUserVis record);

    List selectByExample(RUserVisExample example);

    RUserVis selectByPrimaryKey(String id);

    int deleteByExample(RUserVisExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(RUserVisExample example);

    int updateByExampleSelective(RUserVis record, RUserVisExample example);

    int updateByExample(RUserVis record, RUserVisExample example);
}