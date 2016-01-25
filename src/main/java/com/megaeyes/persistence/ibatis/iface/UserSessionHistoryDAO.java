package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.UserSessionHistory;
import com.megaeyes.persistence.ibatis.model.UserSessionHistoryExample;
import java.util.List;

public interface UserSessionHistoryDAO {
    void insert(UserSessionHistory record);

    int updateByPrimaryKey(UserSessionHistory record);

    int updateByPrimaryKeySelective(UserSessionHistory record);

    List selectByExample(UserSessionHistoryExample example);

    UserSessionHistory selectByPrimaryKey(String id);

    int deleteByExample(UserSessionHistoryExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(UserSessionHistoryExample example);

    int updateByExampleSelective(UserSessionHistory record, UserSessionHistoryExample example);

    int updateByExample(UserSessionHistory record, UserSessionHistoryExample example);
}