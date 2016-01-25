package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.PlatformResourcesExample;
import java.util.List;

public interface PlatformResourcesDAO {
    void insert(PlatformResources record);

    int updateByPrimaryKey(PlatformResources record);

    int updateByPrimaryKeySelective(PlatformResources record);

    List selectByExample(PlatformResourcesExample example);

    PlatformResources selectByPrimaryKey(String id);

    int deleteByExample(PlatformResourcesExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(PlatformResourcesExample example);

    int updateByExampleSelective(PlatformResources record, PlatformResourcesExample example);

    int updateByExample(PlatformResources record, PlatformResourcesExample example);
}