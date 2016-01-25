package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.RtpPayload;
import com.megaeyes.persistence.ibatis.model.RtpPayloadExample;
import java.util.List;

public interface RtpPayloadDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table RTP_PAYLOAD
     *
     * @abatorgenerated Mon May 07 14:46:18 CST 2012
     */
    void insert(RtpPayload record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table RTP_PAYLOAD
     *
     * @abatorgenerated Mon May 07 14:46:18 CST 2012
     */
    int updateByPrimaryKey(RtpPayload record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table RTP_PAYLOAD
     *
     * @abatorgenerated Mon May 07 14:46:18 CST 2012
     */
    int updateByPrimaryKeySelective(RtpPayload record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table RTP_PAYLOAD
     *
     * @abatorgenerated Mon May 07 14:46:18 CST 2012
     */
    List selectByExample(RtpPayloadExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table RTP_PAYLOAD
     *
     * @abatorgenerated Mon May 07 14:46:18 CST 2012
     */
    RtpPayload selectByPrimaryKey(String id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table RTP_PAYLOAD
     *
     * @abatorgenerated Mon May 07 14:46:18 CST 2012
     */
    int deleteByExample(RtpPayloadExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table RTP_PAYLOAD
     *
     * @abatorgenerated Mon May 07 14:46:18 CST 2012
     */
    int deleteByPrimaryKey(String id);
}