package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpRTaskstepMonitor;
import com.megaeyes.persistence.ibatis.model.EpRTaskstepMonitorExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpRTaskstepMonitorDAOImpl extends SqlMapClientDaoSupport implements EpRTaskstepMonitorDAO {

    public EpRTaskstepMonitorDAOImpl() {
        super();
    }

    public void insert(EpRTaskstepMonitor record) {
        getSqlMapClientTemplate().insert("EP_R_TASKSTEP_MONITOR._insert", record);
    }

    public List selectByExample(EpRTaskstepMonitorExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_R_TASKSTEP_MONITOR._selectByExample", example);
        return list;
    }

    public int deleteByExample(EpRTaskstepMonitorExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_R_TASKSTEP_MONITOR._deleteByExample", example);
        return rows;
    }

    public int countByExample(EpRTaskstepMonitorExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_R_TASKSTEP_MONITOR._countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(EpRTaskstepMonitor record, EpRTaskstepMonitorExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_TASKSTEP_MONITOR._updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(EpRTaskstepMonitor record, EpRTaskstepMonitorExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_R_TASKSTEP_MONITOR._updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends EpRTaskstepMonitorExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpRTaskstepMonitorExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}