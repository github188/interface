package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpIntelligentDetection;
import com.megaeyes.persistence.ibatis.model.EpIntelligentDetectionExample;
import java.util.List;

public interface EpIntelligentDetectionDAO {
    void insert(EpIntelligentDetection record);

    int updateByPrimaryKey(EpIntelligentDetection record);

    int updateByPrimaryKeySelective(EpIntelligentDetection record);

    List selectByExample(EpIntelligentDetectionExample example);

    EpIntelligentDetection selectByPrimaryKey(String deviceId);

    int deleteByExample(EpIntelligentDetectionExample example);

    int deleteByPrimaryKey(String deviceId);

    int countByExample(EpIntelligentDetectionExample example);

    int updateByExampleSelective(EpIntelligentDetection record, EpIntelligentDetectionExample example);

    int updateByExample(EpIntelligentDetection record, EpIntelligentDetectionExample example);
}