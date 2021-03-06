package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpScheme;
import com.megaeyes.persistence.ibatis.model.EpSchemeExample;
import java.util.List;

public interface EpSchemeDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_SCHEME
     *
     * @abatorgenerated Thu Jun 14 08:50:12 GMT 2012
     */
    void insert(EpScheme record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_SCHEME
     *
     * @abatorgenerated Thu Jun 14 08:50:12 GMT 2012
     */
    int updateByPrimaryKey(EpScheme record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_SCHEME
     *
     * @abatorgenerated Thu Jun 14 08:50:12 GMT 2012
     */
    int updateByPrimaryKeySelective(EpScheme record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_SCHEME
     *
     * @abatorgenerated Thu Jun 14 08:50:12 GMT 2012
     */
    List selectByExample(EpSchemeExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_SCHEME
     *
     * @abatorgenerated Thu Jun 14 08:50:12 GMT 2012
     */
    EpScheme selectByPrimaryKey(String id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_SCHEME
     *
     * @abatorgenerated Thu Jun 14 08:50:12 GMT 2012
     */
    int deleteByExample(EpSchemeExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_SCHEME
     *
     * @abatorgenerated Thu Jun 14 08:50:12 GMT 2012
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_SCHEME
     *
     * @abatorgenerated Thu Jun 14 08:50:12 GMT 2012
     */
    int countByExample(EpSchemeExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_SCHEME
     *
     * @abatorgenerated Thu Jun 14 08:50:12 GMT 2012
     */
    int updateByExampleSelective(EpScheme record, EpSchemeExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_SCHEME
     *
     * @abatorgenerated Thu Jun 14 08:50:12 GMT 2012
     */
    int updateByExample(EpScheme record, EpSchemeExample example);
}