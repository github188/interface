package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AcAccessCards;
import com.megaeyes.persistence.ibatis.model.AcAccessCardsExample;
import java.util.List;

public interface AcAccessCardsDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    void insert(AcAccessCards record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    int updateByPrimaryKey(AcAccessCards record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    int updateByPrimaryKeySelective(AcAccessCards record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    List selectByExample(AcAccessCardsExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    AcAccessCards selectByPrimaryKey(String id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    int deleteByExample(AcAccessCardsExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    int countByExample(AcAccessCardsExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    int updateByExampleSelective(AcAccessCards record, AcAccessCardsExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.AC_ACCESS_CARDS
     *
     * @abatorgenerated Wed May 16 01:37:47 GMT 2012
     */
    int updateByExample(AcAccessCards record, AcAccessCardsExample example);
}