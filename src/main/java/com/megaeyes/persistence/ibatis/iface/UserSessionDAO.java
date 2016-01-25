package com.megaeyes.persistence.ibatis.iface;

import com.megaeyes.persistence.ibatis.model.UserSession;
import com.megaeyes.persistence.ibatis.model.UserSessionExample;
import java.util.List;

public interface UserSessionDAO {
    void insert(UserSession record);

    int updateByPrimaryKey(UserSession record);

    int updateByPrimaryKeySelective(UserSession record);

    List selectByExample(UserSessionExample example);

    UserSession selectByPrimaryKey(String id);

    int deleteByExample(UserSessionExample example);

    int deleteByPrimaryKey(String id);

    int countByExample(UserSessionExample example);

    int updateByExampleSelective(UserSession record, UserSessionExample example);

    int updateByExample(UserSession record, UserSessionExample example);
}