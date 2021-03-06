package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.AcGateway;
import com.megaeyes.persistence.ibatis.model.AcGatewayExample;
import java.util.List;

public interface AcGatewayDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table DL25.AC_GATEWAY
     *
     * @abatorgenerated Mon Jan 21 16:30:30 CST 2013
     */
    void insert(AcGateway record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table DL25.AC_GATEWAY
     *
     * @abatorgenerated Mon Jan 21 16:30:30 CST 2013
     */
    int updateByPrimaryKey(AcGateway record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table DL25.AC_GATEWAY
     *
     * @abatorgenerated Mon Jan 21 16:30:30 CST 2013
     */
    int updateByPrimaryKeySelective(AcGateway record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table DL25.AC_GATEWAY
     *
     * @abatorgenerated Mon Jan 21 16:30:30 CST 2013
     */
    List selectByExample(AcGatewayExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table DL25.AC_GATEWAY
     *
     * @abatorgenerated Mon Jan 21 16:30:30 CST 2013
     */
    AcGateway selectByPrimaryKey(String id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table DL25.AC_GATEWAY
     *
     * @abatorgenerated Mon Jan 21 16:30:30 CST 2013
     */
    int deleteByExample(AcGatewayExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table DL25.AC_GATEWAY
     *
     * @abatorgenerated Mon Jan 21 16:30:30 CST 2013
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table DL25.AC_GATEWAY
     *
     * @abatorgenerated Mon Jan 21 16:30:30 CST 2013
     */
    int countByExample(AcGatewayExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table DL25.AC_GATEWAY
     *
     * @abatorgenerated Mon Jan 21 16:30:30 CST 2013
     */
    int updateByExampleSelective(AcGateway record, AcGatewayExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table DL25.AC_GATEWAY
     *
     * @abatorgenerated Mon Jan 21 16:30:30 CST 2013
     */
    int updateByExample(AcGateway record, AcGatewayExample example);
}