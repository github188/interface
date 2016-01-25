package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.Company;
import com.megaeyes.persistence.ibatis.model.CompanyExample;
import java.util.List;

public interface CompanyDAO {
    void insert(Company record);

    int updateByPrimaryKey(Company record);

    int updateByPrimaryKeySelective(Company record);

    List selectByExample(CompanyExample example);

    Company selectByPrimaryKey(String organId);

    int deleteByExample(CompanyExample example);

    int deleteByPrimaryKey(String organId);

    int countByExample(CompanyExample example);

    int updateByExampleSelective(Company record, CompanyExample example);

    int updateByExample(Company record, CompanyExample example);
}