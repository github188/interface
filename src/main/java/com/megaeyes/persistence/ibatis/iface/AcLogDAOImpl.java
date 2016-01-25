package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AcLog;
import com.megaeyes.persistence.ibatis.model.AcLogExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AcLogDAOImpl extends SqlMapClientDaoSupport implements AcLogDAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    public AcLogDAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    public void insert(AcLog record) {
        getSqlMapClientTemplate().insert("AC_LOG.abatorgenerated_insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    public int updateByPrimaryKey(AcLog record) {
        int rows = getSqlMapClientTemplate().update("AC_LOG.abatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    public int updateByPrimaryKeySelective(AcLog record) {
        int rows = getSqlMapClientTemplate().update("AC_LOG.abatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    public List selectByExample(AcLogExample example) {
        List list = getSqlMapClientTemplate().queryForList("AC_LOG.abatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    public AcLog selectByPrimaryKey(String id) {
        AcLog key = new AcLog();
        key.setId(id);
        AcLog record = (AcLog) getSqlMapClientTemplate().queryForObject("AC_LOG.abatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    public int deleteByExample(AcLogExample example) {
        int rows = getSqlMapClientTemplate().delete("AC_LOG.abatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    public int deleteByPrimaryKey(String id) {
        AcLog key = new AcLog();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("AC_LOG.abatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    public int countByExample(AcLogExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("AC_LOG.abatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    public int updateByExampleSelective(AcLog record, AcLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("AC_LOG.abatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    public int updateByExample(AcLog record, AcLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("AC_LOG.abatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table HBDW1.AC_LOG
     *
     * @abatorgenerated Fri May 25 16:52:11 CST 2012
     */
    private static class UpdateByExampleParms extends AcLogExample {
        private Object record;

        public UpdateByExampleParms(Object record, AcLogExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}