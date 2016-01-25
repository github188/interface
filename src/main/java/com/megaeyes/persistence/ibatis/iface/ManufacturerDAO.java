package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.Manufacturer;
import com.megaeyes.persistence.ibatis.model.ManufacturerExample;
import java.util.List;

public interface ManufacturerDAO {
    void insert(Manufacturer record);

    int updateByPrimaryKey(Manufacturer record);

    int updateByPrimaryKeySelective(Manufacturer record);

    List selectByExample(ManufacturerExample example);

    Manufacturer selectByPrimaryKey(String id);

    int deleteByExample(ManufacturerExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(ManufacturerExample example);

    int updateByExampleSelective(Manufacturer record, ManufacturerExample example);

    int updateByExample(Manufacturer record, ManufacturerExample example);
}