package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AcAccessCards;
import com.megaeyes.persistence.ibatis.model.AcAccessCardsExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AcAccessCardsDAOImpl extends SqlMapClientDaoSupport implements AcAccessCardsDAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    public AcAccessCardsDAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    public void insert(AcAccessCards record) {
        getSqlMapClientTemplate().insert("AC_ACCESS_CARDS.abatorgenerated_insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    public int updateByPrimaryKey(AcAccessCards record) {
        int rows = getSqlMapClientTemplate().update("AC_ACCESS_CARDS.abatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    public int updateByPrimaryKeySelective(AcAccessCards record) {
        int rows = getSqlMapClientTemplate().update("AC_ACCESS_CARDS.abatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    public List selectByExample(AcAccessCardsExample example) {
        List list = getSqlMapClientTemplate().queryForList("AC_ACCESS_CARDS.abatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    public AcAccessCards selectByPrimaryKey(String id) {
        AcAccessCards key = new AcAccessCards();
        key.setId(id);
        AcAccessCards record = (AcAccessCards) getSqlMapClientTemplate().queryForObject("AC_ACCESS_CARDS.abatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    public int deleteByExample(AcAccessCardsExample example) {
        int rows = getSqlMapClientTemplate().delete("AC_ACCESS_CARDS.abatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    public int deleteByPrimaryKey(String id) {
        AcAccessCards key = new AcAccessCards();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("AC_ACCESS_CARDS.abatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    public int countByExample(AcAccessCardsExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("AC_ACCESS_CARDS.abatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    public int updateByExampleSelective(AcAccessCards record, AcAccessCardsExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("AC_ACCESS_CARDS.abatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    public int updateByExample(AcAccessCards record, AcAccessCardsExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("AC_ACCESS_CARDS.abatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    private static class UpdateByExampleParms extends AcAccessCardsExample {
        private Object record;

        public UpdateByExampleParms(Object record, AcAccessCardsExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}