package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpPreset;
import com.megaeyes.persistence.ibatis.model.EpPresetExample;
import java.util.List;

public interface EpPresetDAO {
    void insert(EpPreset record);

    int updateByPrimaryKey(EpPreset record);

    int updateByPrimaryKeySelective(EpPreset record);

    List selectByExample(EpPresetExample example);

    EpPreset selectByPrimaryKey(String id);

    int deleteByExample(EpPresetExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(EpPresetExample example);

    int updateByExampleSelective(EpPreset record, EpPresetExample example);

    int updateByExample(EpPreset record, EpPresetExample example);
}