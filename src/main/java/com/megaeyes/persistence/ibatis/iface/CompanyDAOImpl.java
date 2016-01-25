package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.Company;
import com.megaeyes.persistence.ibatis.model.CompanyExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class CompanyDAOImpl extends SqlMapClientDaoSupport implements CompanyDAO {

    public CompanyDAOImpl() {
        super();
    }

    public void insert(Company record) {
        getSqlMapClientTemplate().insert("COMPANY._insert", record);
    }

    public int updateByPrimaryKey(Company record) {
        int rows = getSqlMapClientTemplate().update("COMPANY._updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(Company record) {
        int rows = getSqlMapClientTemplate().update("COMPANY._updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(CompanyExample example) {
        List list = getSqlMapClientTemplate().queryForList("COMPANY._selectByExample", example);
        return list;
    }

    public Company selectByPrimaryKey(String organId) {
        Company key = new Company();
        key.setOrganId(organId);
        Company record = (Company) getSqlMapClientTemplate().queryForObject("COMPANY._selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(CompanyExample example) {
        int rows = getSqlMapClientTemplate().delete("COMPANY._deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(String organId) {
        Company key = new Company();
        key.setOrganId(organId);
        int rows = getSqlMapClientTemplate().delete("COMPANY._deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(CompanyExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("COMPANY._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(Company record, CompanyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("COMPANY._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(Company record, CompanyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("COMPANY._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends CompanyExample {
        private Object record;

        public UpdateByExampleParms(Object record, CompanyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}