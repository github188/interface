package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.EpTaskStep;
import com.megaeyes.persistence.ibatis.model.EpTaskStepExample;
import java.util.List;

public interface EpTaskStepDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_TASK_STEP
     *
     * @abatorgenerated Fri May 11 15:43:23 CST 2012
     */
    void insert(EpTaskStep record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_TASK_STEP
     *
     * @abatorgenerated Fri May 11 15:43:23 CST 2012
     */
    int updateByPrimaryKey(EpTaskStep record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_TASK_STEP
     *
     * @abatorgenerated Fri May 11 15:43:23 CST 2012
     */
    int updateByPrimaryKeySelective(EpTaskStep record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_TASK_STEP
     *
     * @abatorgenerated Fri May 11 15:43:23 CST 2012
     */
    List selectByExample(EpTaskStepExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_TASK_STEP
     *
     * @abatorgenerated Fri May 11 15:43:23 CST 2012
     */
    EpTaskStep selectByPrimaryKey(String id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_TASK_STEP
     *
     * @abatorgenerated Fri May 11 15:43:23 CST 2012
     */
    int deleteByExample(EpTaskStepExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_TASK_STEP
     *
     * @abatorgenerated Fri May 11 15:43:23 CST 2012
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_TASK_STEP
     *
     * @abatorgenerated Fri May 11 15:43:23 CST 2012
     */
    int countByExample(EpTaskStepExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_TASK_STEP
     *
     * @abatorgenerated Fri May 11 15:43:23 CST 2012
     */
    int updateByExampleSelective(EpTaskStep record, EpTaskStepExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.EP_TASK_STEP
     *
     * @abatorgenerated Fri May 11 15:43:23 CST 2012
     */
    int updateByExample(EpTaskStep record, EpTaskStepExample example);
}