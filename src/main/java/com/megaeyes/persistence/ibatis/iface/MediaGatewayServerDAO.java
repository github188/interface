package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.MediaGatewayServer;
import com.megaeyes.persistence.ibatis.model.MediaGatewayServerExample;
import java.util.List;

public interface MediaGatewayServerDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.MEDIA_GATEWAY_SERVER
     *
     * @abatorgenerated Wed May 16 16:06:10 CST 2012
     */
    void insert(MediaGatewayServer record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.MEDIA_GATEWAY_SERVER
     *
     * @abatorgenerated Wed May 16 16:06:10 CST 2012
     */
    int updateByPrimaryKey(MediaGatewayServer record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.MEDIA_GATEWAY_SERVER
     *
     * @abatorgenerated Wed May 16 16:06:10 CST 2012
     */
    int updateByPrimaryKeySelective(MediaGatewayServer record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.MEDIA_GATEWAY_SERVER
     *
     * @abatorgenerated Wed May 16 16:06:10 CST 2012
     */
    List selectByExample(MediaGatewayServerExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.MEDIA_GATEWAY_SERVER
     *
     * @abatorgenerated Wed May 16 16:06:10 CST 2012
     */
    MediaGatewayServer selectByPrimaryKey(String id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.MEDIA_GATEWAY_SERVER
     *
     * @abatorgenerated Wed May 16 16:06:10 CST 2012
     */
    int deleteByExample(MediaGatewayServerExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.MEDIA_GATEWAY_SERVER
     *
     * @abatorgenerated Wed May 16 16:06:10 CST 2012
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.MEDIA_GATEWAY_SERVER
     *
     * @abatorgenerated Wed May 16 16:06:10 CST 2012
     */
    int countByExample(MediaGatewayServerExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.MEDIA_GATEWAY_SERVER
     *
     * @abatorgenerated Wed May 16 16:06:10 CST 2012
     */
    int updateByExampleSelective(MediaGatewayServer record, MediaGatewayServerExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table HBDW1.MEDIA_GATEWAY_SERVER
     *
     * @abatorgenerated Wed May 16 16:06:10 CST 2012
     */
    int updateByExample(MediaGatewayServer record, MediaGatewayServerExample example);
}