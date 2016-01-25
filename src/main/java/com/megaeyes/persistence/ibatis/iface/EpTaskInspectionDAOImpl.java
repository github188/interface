package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpTaskInspection;
import com.megaeyes.persistence.ibatis.model.EpTaskInspectionExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpTaskInspectionDAOImpl extends SqlMapClientDaoSupport implements EpTaskInspectionDAO {

    public EpTaskInspectionDAOImpl() {
        super();
    }

    public void insert(EpTaskInspection record) {
        getSqlMapClientTemplate().insert("EP_TASK_INSPECTION._insert", record);
    }

    public List selectByExample(EpTaskInspectionExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_TASK_INSPECTION._selectByExample", example);
        return list;
    }

    public int deleteByExample(EpTaskInspectionExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_TASK_INSPECTION._deleteByExample", example);
        return rows;
    }

    public int countByExample(EpTaskInspectionExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_TASK_INSPECTION._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpTaskInspection record, EpTaskInspectionExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_TASK_INSPECTION._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpTaskInspection record, EpTaskInspectionExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_TASK_INSPECTION._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpTaskInspectionExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpTaskInspectionExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}