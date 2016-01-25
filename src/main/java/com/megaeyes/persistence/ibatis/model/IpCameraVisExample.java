package com.megaeyes.persistence.ibatis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IpCameraVisExample {
    protected String orderByClause;

    protected List oredCriteria;

    public IpCameraVisExample() {
        oredCriteria = new ArrayList();
    }

    protected IpCameraVisExample(IpCameraVisExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public List getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
    }

    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andVideoInputServerIdIsNull() {
            addCriterion("VIDEO_INPUT_SERVER_ID is null");
            return this;
        }

        public Criteria andVideoInputServerIdIsNotNull() {
            addCriterion("VIDEO_INPUT_SERVER_ID is not null");
            return this;
        }

        public Criteria andVideoInputServerIdEqualTo(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID =", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdNotEqualTo(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID <>", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdGreaterThan(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID >", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID >=", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdLessThan(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID <", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID <=", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdLike(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID like", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdNotLike(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID not like", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdIn(List values) {
            addCriterion("VIDEO_INPUT_SERVER_ID in", values, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdNotIn(List values) {
            addCriterion("VIDEO_INPUT_SERVER_ID not in", values, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdBetween(String value1, String value2) {
            addCriterion("VIDEO_INPUT_SERVER_ID between", value1, value2, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdNotBetween(String value1, String value2) {
            addCriterion("VIDEO_INPUT_SERVER_ID not between", value1, value2, "videoInputServerId");
            return this;
        }

        public Criteria andLocalAlarm1FlagIsNull() {
            addCriterion("LOCAL_ALARM1_FLAG is null");
            return this;
        }

        public Criteria andLocalAlarm1FlagIsNotNull() {
            addCriterion("LOCAL_ALARM1_FLAG is not null");
            return this;
        }

        public Criteria andLocalAlarm1FlagEqualTo(Short value) {
            addCriterion("LOCAL_ALARM1_FLAG =", value, "localAlarm1Flag");
            return this;
        }

        public Criteria andLocalAlarm1FlagNotEqualTo(Short value) {
            addCriterion("LOCAL_ALARM1_FLAG <>", value, "localAlarm1Flag");
            return this;
        }

        public Criteria andLocalAlarm1FlagGreaterThan(Short value) {
            addCriterion("LOCAL_ALARM1_FLAG >", value, "localAlarm1Flag");
            return this;
        }

        public Criteria andLocalAlarm1FlagGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCAL_ALARM1_FLAG >=", value, "localAlarm1Flag");
            return this;
        }

        public Criteria andLocalAlarm1FlagLessThan(Short value) {
            addCriterion("LOCAL_ALARM1_FLAG <", value, "localAlarm1Flag");
            return this;
        }

        public Criteria andLocalAlarm1FlagLessThanOrEqualTo(Short value) {
            addCriterion("LOCAL_ALARM1_FLAG <=", value, "localAlarm1Flag");
            return this;
        }

        public Criteria andLocalAlarm1FlagIn(List values) {
            addCriterion("LOCAL_ALARM1_FLAG in", values, "localAlarm1Flag");
            return this;
        }

        public Criteria andLocalAlarm1FlagNotIn(List values) {
            addCriterion("LOCAL_ALARM1_FLAG not in", values, "localAlarm1Flag");
            return this;
        }

        public Criteria andLocalAlarm1FlagBetween(Short value1, Short value2) {
            addCriterion("LOCAL_ALARM1_FLAG between", value1, value2, "localAlarm1Flag");
            return this;
        }

        public Criteria andLocalAlarm1FlagNotBetween(Short value1, Short value2) {
            addCriterion("LOCAL_ALARM1_FLAG not between", value1, value2, "localAlarm1Flag");
            return this;
        }

        public Criteria andLocalAlarm2FlagIsNull() {
            addCriterion("LOCAL_ALARM2_FLAG is null");
            return this;
        }

        public Criteria andLocalAlarm2FlagIsNotNull() {
            addCriterion("LOCAL_ALARM2_FLAG is not null");
            return this;
        }

        public Criteria andLocalAlarm2FlagEqualTo(Short value) {
            addCriterion("LOCAL_ALARM2_FLAG =", value, "localAlarm2Flag");
            return this;
        }

        public Criteria andLocalAlarm2FlagNotEqualTo(Short value) {
            addCriterion("LOCAL_ALARM2_FLAG <>", value, "localAlarm2Flag");
            return this;
        }

        public Criteria andLocalAlarm2FlagGreaterThan(Short value) {
            addCriterion("LOCAL_ALARM2_FLAG >", value, "localAlarm2Flag");
            return this;
        }

        public Criteria andLocalAlarm2FlagGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCAL_ALARM2_FLAG >=", value, "localAlarm2Flag");
            return this;
        }

        public Criteria andLocalAlarm2FlagLessThan(Short value) {
            addCriterion("LOCAL_ALARM2_FLAG <", value, "localAlarm2Flag");
            return this;
        }

        public Criteria andLocalAlarm2FlagLessThanOrEqualTo(Short value) {
            addCriterion("LOCAL_ALARM2_FLAG <=", value, "localAlarm2Flag");
            return this;
        }

        public Criteria andLocalAlarm2FlagIn(List values) {
            addCriterion("LOCAL_ALARM2_FLAG in", values, "localAlarm2Flag");
            return this;
        }

        public Criteria andLocalAlarm2FlagNotIn(List values) {
            addCriterion("LOCAL_ALARM2_FLAG not in", values, "localAlarm2Flag");
            return this;
        }

        public Criteria andLocalAlarm2FlagBetween(Short value1, Short value2) {
            addCriterion("LOCAL_ALARM2_FLAG between", value1, value2, "localAlarm2Flag");
            return this;
        }

        public Criteria andLocalAlarm2FlagNotBetween(Short value1, Short value2) {
            addCriterion("LOCAL_ALARM2_FLAG not between", value1, value2, "localAlarm2Flag");
            return this;
        }

        public Criteria andLocalAlarm3FlagIsNull() {
            addCriterion("LOCAL_ALARM3_FLAG is null");
            return this;
        }

        public Criteria andLocalAlarm3FlagIsNotNull() {
            addCriterion("LOCAL_ALARM3_FLAG is not null");
            return this;
        }

        public Criteria andLocalAlarm3FlagEqualTo(Short value) {
            addCriterion("LOCAL_ALARM3_FLAG =", value, "localAlarm3Flag");
            return this;
        }

        public Criteria andLocalAlarm3FlagNotEqualTo(Short value) {
            addCriterion("LOCAL_ALARM3_FLAG <>", value, "localAlarm3Flag");
            return this;
        }

        public Criteria andLocalAlarm3FlagGreaterThan(Short value) {
            addCriterion("LOCAL_ALARM3_FLAG >", value, "localAlarm3Flag");
            return this;
        }

        public Criteria andLocalAlarm3FlagGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCAL_ALARM3_FLAG >=", value, "localAlarm3Flag");
            return this;
        }

        public Criteria andLocalAlarm3FlagLessThan(Short value) {
            addCriterion("LOCAL_ALARM3_FLAG <", value, "localAlarm3Flag");
            return this;
        }

        public Criteria andLocalAlarm3FlagLessThanOrEqualTo(Short value) {
            addCriterion("LOCAL_ALARM3_FLAG <=", value, "localAlarm3Flag");
            return this;
        }

        public Criteria andLocalAlarm3FlagIn(List values) {
            addCriterion("LOCAL_ALARM3_FLAG in", values, "localAlarm3Flag");
            return this;
        }

        public Criteria andLocalAlarm3FlagNotIn(List values) {
            addCriterion("LOCAL_ALARM3_FLAG not in", values, "localAlarm3Flag");
            return this;
        }

        public Criteria andLocalAlarm3FlagBetween(Short value1, Short value2) {
            addCriterion("LOCAL_ALARM3_FLAG between", value1, value2, "localAlarm3Flag");
            return this;
        }

        public Criteria andLocalAlarm3FlagNotBetween(Short value1, Short value2) {
            addCriterion("LOCAL_ALARM3_FLAG not between", value1, value2, "localAlarm3Flag");
            return this;
        }

        public Criteria andLocalTimingFlagIsNull() {
            addCriterion("LOCAL_TIMING_FLAG is null");
            return this;
        }

        public Criteria andLocalTimingFlagIsNotNull() {
            addCriterion("LOCAL_TIMING_FLAG is not null");
            return this;
        }

        public Criteria andLocalTimingFlagEqualTo(Short value) {
            addCriterion("LOCAL_TIMING_FLAG =", value, "localTimingFlag");
            return this;
        }

        public Criteria andLocalTimingFlagNotEqualTo(Short value) {
            addCriterion("LOCAL_TIMING_FLAG <>", value, "localTimingFlag");
            return this;
        }

        public Criteria andLocalTimingFlagGreaterThan(Short value) {
            addCriterion("LOCAL_TIMING_FLAG >", value, "localTimingFlag");
            return this;
        }

        public Criteria andLocalTimingFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCAL_TIMING_FLAG >=", value, "localTimingFlag");
            return this;
        }

        public Criteria andLocalTimingFlagLessThan(Short value) {
            addCriterion("LOCAL_TIMING_FLAG <", value, "localTimingFlag");
            return this;
        }

        public Criteria andLocalTimingFlagLessThanOrEqualTo(Short value) {
            addCriterion("LOCAL_TIMING_FLAG <=", value, "localTimingFlag");
            return this;
        }

        public Criteria andLocalTimingFlagIn(List values) {
            addCriterion("LOCAL_TIMING_FLAG in", values, "localTimingFlag");
            return this;
        }

        public Criteria andLocalTimingFlagNotIn(List values) {
            addCriterion("LOCAL_TIMING_FLAG not in", values, "localTimingFlag");
            return this;
        }

        public Criteria andLocalTimingFlagBetween(Short value1, Short value2) {
            addCriterion("LOCAL_TIMING_FLAG between", value1, value2, "localTimingFlag");
            return this;
        }

        public Criteria andLocalTimingFlagNotBetween(Short value1, Short value2) {
            addCriterion("LOCAL_TIMING_FLAG not between", value1, value2, "localTimingFlag");
            return this;
        }

        public Criteria andLocalTimingIntervalIsNull() {
            addCriterion("LOCAL_TIMING_INTERVAL is null");
            return this;
        }

        public Criteria andLocalTimingIntervalIsNotNull() {
            addCriterion("LOCAL_TIMING_INTERVAL is not null");
            return this;
        }

        public Criteria andLocalTimingIntervalEqualTo(Long value) {
            addCriterion("LOCAL_TIMING_INTERVAL =", value, "localTimingInterval");
            return this;
        }

        public Criteria andLocalTimingIntervalNotEqualTo(Long value) {
            addCriterion("LOCAL_TIMING_INTERVAL <>", value, "localTimingInterval");
            return this;
        }

        public Criteria andLocalTimingIntervalGreaterThan(Long value) {
            addCriterion("LOCAL_TIMING_INTERVAL >", value, "localTimingInterval");
            return this;
        }

        public Criteria andLocalTimingIntervalGreaterThanOrEqualTo(Long value) {
            addCriterion("LOCAL_TIMING_INTERVAL >=", value, "localTimingInterval");
            return this;
        }

        public Criteria andLocalTimingIntervalLessThan(Long value) {
            addCriterion("LOCAL_TIMING_INTERVAL <", value, "localTimingInterval");
            return this;
        }

        public Criteria andLocalTimingIntervalLessThanOrEqualTo(Long value) {
            addCriterion("LOCAL_TIMING_INTERVAL <=", value, "localTimingInterval");
            return this;
        }

        public Criteria andLocalTimingIntervalIn(List values) {
            addCriterion("LOCAL_TIMING_INTERVAL in", values, "localTimingInterval");
            return this;
        }

        public Criteria andLocalTimingIntervalNotIn(List values) {
            addCriterion("LOCAL_TIMING_INTERVAL not in", values, "localTimingInterval");
            return this;
        }

        public Criteria andLocalTimingIntervalBetween(Long value1, Long value2) {
            addCriterion("LOCAL_TIMING_INTERVAL between", value1, value2, "localTimingInterval");
            return this;
        }

        public Criteria andLocalTimingIntervalNotBetween(Long value1, Long value2) {
            addCriterion("LOCAL_TIMING_INTERVAL not between", value1, value2, "localTimingInterval");
            return this;
        }

        public Criteria andLocalShootingFlagIsNull() {
            addCriterion("LOCAL_SHOOTING_FLAG is null");
            return this;
        }

        public Criteria andLocalShootingFlagIsNotNull() {
            addCriterion("LOCAL_SHOOTING_FLAG is not null");
            return this;
        }

        public Criteria andLocalShootingFlagEqualTo(Short value) {
            addCriterion("LOCAL_SHOOTING_FLAG =", value, "localShootingFlag");
            return this;
        }

        public Criteria andLocalShootingFlagNotEqualTo(Short value) {
            addCriterion("LOCAL_SHOOTING_FLAG <>", value, "localShootingFlag");
            return this;
        }

        public Criteria andLocalShootingFlagGreaterThan(Short value) {
            addCriterion("LOCAL_SHOOTING_FLAG >", value, "localShootingFlag");
            return this;
        }

        public Criteria andLocalShootingFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCAL_SHOOTING_FLAG >=", value, "localShootingFlag");
            return this;
        }

        public Criteria andLocalShootingFlagLessThan(Short value) {
            addCriterion("LOCAL_SHOOTING_FLAG <", value, "localShootingFlag");
            return this;
        }

        public Criteria andLocalShootingFlagLessThanOrEqualTo(Short value) {
            addCriterion("LOCAL_SHOOTING_FLAG <=", value, "localShootingFlag");
            return this;
        }

        public Criteria andLocalShootingFlagIn(List values) {
            addCriterion("LOCAL_SHOOTING_FLAG in", values, "localShootingFlag");
            return this;
        }

        public Criteria andLocalShootingFlagNotIn(List values) {
            addCriterion("LOCAL_SHOOTING_FLAG not in", values, "localShootingFlag");
            return this;
        }

        public Criteria andLocalShootingFlagBetween(Short value1, Short value2) {
            addCriterion("LOCAL_SHOOTING_FLAG between", value1, value2, "localShootingFlag");
            return this;
        }

        public Criteria andLocalShootingFlagNotBetween(Short value1, Short value2) {
            addCriterion("LOCAL_SHOOTING_FLAG not between", value1, value2, "localShootingFlag");
            return this;
        }

        public Criteria andSdCacheFlagIsNull() {
            addCriterion("SD_CACHE_FLAG is null");
            return this;
        }

        public Criteria andSdCacheFlagIsNotNull() {
            addCriterion("SD_CACHE_FLAG is not null");
            return this;
        }

        public Criteria andSdCacheFlagEqualTo(Short value) {
            addCriterion("SD_CACHE_FLAG =", value, "sdCacheFlag");
            return this;
        }

        public Criteria andSdCacheFlagNotEqualTo(Short value) {
            addCriterion("SD_CACHE_FLAG <>", value, "sdCacheFlag");
            return this;
        }

        public Criteria andSdCacheFlagGreaterThan(Short value) {
            addCriterion("SD_CACHE_FLAG >", value, "sdCacheFlag");
            return this;
        }

        public Criteria andSdCacheFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("SD_CACHE_FLAG >=", value, "sdCacheFlag");
            return this;
        }

        public Criteria andSdCacheFlagLessThan(Short value) {
            addCriterion("SD_CACHE_FLAG <", value, "sdCacheFlag");
            return this;
        }

        public Criteria andSdCacheFlagLessThanOrEqualTo(Short value) {
            addCriterion("SD_CACHE_FLAG <=", value, "sdCacheFlag");
            return this;
        }

        public Criteria andSdCacheFlagIn(List values) {
            addCriterion("SD_CACHE_FLAG in", values, "sdCacheFlag");
            return this;
        }

        public Criteria andSdCacheFlagNotIn(List values) {
            addCriterion("SD_CACHE_FLAG not in", values, "sdCacheFlag");
            return this;
        }

        public Criteria andSdCacheFlagBetween(Short value1, Short value2) {
            addCriterion("SD_CACHE_FLAG between", value1, value2, "sdCacheFlag");
            return this;
        }

        public Criteria andSdCacheFlagNotBetween(Short value1, Short value2) {
            addCriterion("SD_CACHE_FLAG not between", value1, value2, "sdCacheFlag");
            return this;
        }

        public Criteria andSdRedSaveFlagIsNull() {
            addCriterion("SD_RED_SAVE_FLAG is null");
            return this;
        }

        public Criteria andSdRedSaveFlagIsNotNull() {
            addCriterion("SD_RED_SAVE_FLAG is not null");
            return this;
        }

        public Criteria andSdRedSaveFlagEqualTo(Short value) {
            addCriterion("SD_RED_SAVE_FLAG =", value, "sdRedSaveFlag");
            return this;
        }

        public Criteria andSdRedSaveFlagNotEqualTo(Short value) {
            addCriterion("SD_RED_SAVE_FLAG <>", value, "sdRedSaveFlag");
            return this;
        }

        public Criteria andSdRedSaveFlagGreaterThan(Short value) {
            addCriterion("SD_RED_SAVE_FLAG >", value, "sdRedSaveFlag");
            return this;
        }

        public Criteria andSdRedSaveFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("SD_RED_SAVE_FLAG >=", value, "sdRedSaveFlag");
            return this;
        }

        public Criteria andSdRedSaveFlagLessThan(Short value) {
            addCriterion("SD_RED_SAVE_FLAG <", value, "sdRedSaveFlag");
            return this;
        }

        public Criteria andSdRedSaveFlagLessThanOrEqualTo(Short value) {
            addCriterion("SD_RED_SAVE_FLAG <=", value, "sdRedSaveFlag");
            return this;
        }

        public Criteria andSdRedSaveFlagIn(List values) {
            addCriterion("SD_RED_SAVE_FLAG in", values, "sdRedSaveFlag");
            return this;
        }

        public Criteria andSdRedSaveFlagNotIn(List values) {
            addCriterion("SD_RED_SAVE_FLAG not in", values, "sdRedSaveFlag");
            return this;
        }

        public Criteria andSdRedSaveFlagBetween(Short value1, Short value2) {
            addCriterion("SD_RED_SAVE_FLAG between", value1, value2, "sdRedSaveFlag");
            return this;
        }

        public Criteria andSdRedSaveFlagNotBetween(Short value1, Short value2) {
            addCriterion("SD_RED_SAVE_FLAG not between", value1, value2, "sdRedSaveFlag");
            return this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("IS_DELETED is null");
            return this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("IS_DELETED is not null");
            return this;
        }

        public Criteria andIsDeletedEqualTo(Short value) {
            addCriterion("IS_DELETED =", value, "isDeleted");
            return this;
        }

        public Criteria andIsDeletedNotEqualTo(Short value) {
            addCriterion("IS_DELETED <>", value, "isDeleted");
            return this;
        }

        public Criteria andIsDeletedGreaterThan(Short value) {
            addCriterion("IS_DELETED >", value, "isDeleted");
            return this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_DELETED >=", value, "isDeleted");
            return this;
        }

        public Criteria andIsDeletedLessThan(Short value) {
            addCriterion("IS_DELETED <", value, "isDeleted");
            return this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Short value) {
            addCriterion("IS_DELETED <=", value, "isDeleted");
            return this;
        }

        public Criteria andIsDeletedIn(List values) {
            addCriterion("IS_DELETED in", values, "isDeleted");
            return this;
        }

        public Criteria andIsDeletedNotIn(List values) {
            addCriterion("IS_DELETED not in", values, "isDeleted");
            return this;
        }

        public Criteria andIsDeletedBetween(Short value1, Short value2) {
            addCriterion("IS_DELETED between", value1, value2, "isDeleted");
            return this;
        }

        public Criteria andIsDeletedNotBetween(Short value1, Short value2) {
            addCriterion("IS_DELETED not between", value1, value2, "isDeleted");
            return this;
        }

        public Criteria andRemoteAlarm1FlagIsNull() {
            addCriterion("REMOTE_ALARM1_FLAG is null");
            return this;
        }

        public Criteria andRemoteAlarm1FlagIsNotNull() {
            addCriterion("REMOTE_ALARM1_FLAG is not null");
            return this;
        }

        public Criteria andRemoteAlarm1FlagEqualTo(Short value) {
            addCriterion("REMOTE_ALARM1_FLAG =", value, "remoteAlarm1Flag");
            return this;
        }

        public Criteria andRemoteAlarm1FlagNotEqualTo(Short value) {
            addCriterion("REMOTE_ALARM1_FLAG <>", value, "remoteAlarm1Flag");
            return this;
        }

        public Criteria andRemoteAlarm1FlagGreaterThan(Short value) {
            addCriterion("REMOTE_ALARM1_FLAG >", value, "remoteAlarm1Flag");
            return this;
        }

        public Criteria andRemoteAlarm1FlagGreaterThanOrEqualTo(Short value) {
            addCriterion("REMOTE_ALARM1_FLAG >=", value, "remoteAlarm1Flag");
            return this;
        }

        public Criteria andRemoteAlarm1FlagLessThan(Short value) {
            addCriterion("REMOTE_ALARM1_FLAG <", value, "remoteAlarm1Flag");
            return this;
        }

        public Criteria andRemoteAlarm1FlagLessThanOrEqualTo(Short value) {
            addCriterion("REMOTE_ALARM1_FLAG <=", value, "remoteAlarm1Flag");
            return this;
        }

        public Criteria andRemoteAlarm1FlagIn(List values) {
            addCriterion("REMOTE_ALARM1_FLAG in", values, "remoteAlarm1Flag");
            return this;
        }

        public Criteria andRemoteAlarm1FlagNotIn(List values) {
            addCriterion("REMOTE_ALARM1_FLAG not in", values, "remoteAlarm1Flag");
            return this;
        }

        public Criteria andRemoteAlarm1FlagBetween(Short value1, Short value2) {
            addCriterion("REMOTE_ALARM1_FLAG between", value1, value2, "remoteAlarm1Flag");
            return this;
        }

        public Criteria andRemoteAlarm1FlagNotBetween(Short value1, Short value2) {
            addCriterion("REMOTE_ALARM1_FLAG not between", value1, value2, "remoteAlarm1Flag");
            return this;
        }

        public Criteria andRemoteAlarm2FlagIsNull() {
            addCriterion("REMOTE_ALARM2_FLAG is null");
            return this;
        }

        public Criteria andRemoteAlarm2FlagIsNotNull() {
            addCriterion("REMOTE_ALARM2_FLAG is not null");
            return this;
        }

        public Criteria andRemoteAlarm2FlagEqualTo(Short value) {
            addCriterion("REMOTE_ALARM2_FLAG =", value, "remoteAlarm2Flag");
            return this;
        }

        public Criteria andRemoteAlarm2FlagNotEqualTo(Short value) {
            addCriterion("REMOTE_ALARM2_FLAG <>", value, "remoteAlarm2Flag");
            return this;
        }

        public Criteria andRemoteAlarm2FlagGreaterThan(Short value) {
            addCriterion("REMOTE_ALARM2_FLAG >", value, "remoteAlarm2Flag");
            return this;
        }

        public Criteria andRemoteAlarm2FlagGreaterThanOrEqualTo(Short value) {
            addCriterion("REMOTE_ALARM2_FLAG >=", value, "remoteAlarm2Flag");
            return this;
        }

        public Criteria andRemoteAlarm2FlagLessThan(Short value) {
            addCriterion("REMOTE_ALARM2_FLAG <", value, "remoteAlarm2Flag");
            return this;
        }

        public Criteria andRemoteAlarm2FlagLessThanOrEqualTo(Short value) {
            addCriterion("REMOTE_ALARM2_FLAG <=", value, "remoteAlarm2Flag");
            return this;
        }

        public Criteria andRemoteAlarm2FlagIn(List values) {
            addCriterion("REMOTE_ALARM2_FLAG in", values, "remoteAlarm2Flag");
            return this;
        }

        public Criteria andRemoteAlarm2FlagNotIn(List values) {
            addCriterion("REMOTE_ALARM2_FLAG not in", values, "remoteAlarm2Flag");
            return this;
        }

        public Criteria andRemoteAlarm2FlagBetween(Short value1, Short value2) {
            addCriterion("REMOTE_ALARM2_FLAG between", value1, value2, "remoteAlarm2Flag");
            return this;
        }

        public Criteria andRemoteAlarm2FlagNotBetween(Short value1, Short value2) {
            addCriterion("REMOTE_ALARM2_FLAG not between", value1, value2, "remoteAlarm2Flag");
            return this;
        }

        public Criteria andRemoteAlarm3FlagIsNull() {
            addCriterion("REMOTE_ALARM3_FLAG is null");
            return this;
        }

        public Criteria andRemoteAlarm3FlagIsNotNull() {
            addCriterion("REMOTE_ALARM3_FLAG is not null");
            return this;
        }

        public Criteria andRemoteAlarm3FlagEqualTo(Short value) {
            addCriterion("REMOTE_ALARM3_FLAG =", value, "remoteAlarm3Flag");
            return this;
        }

        public Criteria andRemoteAlarm3FlagNotEqualTo(Short value) {
            addCriterion("REMOTE_ALARM3_FLAG <>", value, "remoteAlarm3Flag");
            return this;
        }

        public Criteria andRemoteAlarm3FlagGreaterThan(Short value) {
            addCriterion("REMOTE_ALARM3_FLAG >", value, "remoteAlarm3Flag");
            return this;
        }

        public Criteria andRemoteAlarm3FlagGreaterThanOrEqualTo(Short value) {
            addCriterion("REMOTE_ALARM3_FLAG >=", value, "remoteAlarm3Flag");
            return this;
        }

        public Criteria andRemoteAlarm3FlagLessThan(Short value) {
            addCriterion("REMOTE_ALARM3_FLAG <", value, "remoteAlarm3Flag");
            return this;
        }

        public Criteria andRemoteAlarm3FlagLessThanOrEqualTo(Short value) {
            addCriterion("REMOTE_ALARM3_FLAG <=", value, "remoteAlarm3Flag");
            return this;
        }

        public Criteria andRemoteAlarm3FlagIn(List values) {
            addCriterion("REMOTE_ALARM3_FLAG in", values, "remoteAlarm3Flag");
            return this;
        }

        public Criteria andRemoteAlarm3FlagNotIn(List values) {
            addCriterion("REMOTE_ALARM3_FLAG not in", values, "remoteAlarm3Flag");
            return this;
        }

        public Criteria andRemoteAlarm3FlagBetween(Short value1, Short value2) {
            addCriterion("REMOTE_ALARM3_FLAG between", value1, value2, "remoteAlarm3Flag");
            return this;
        }

        public Criteria andRemoteAlarm3FlagNotBetween(Short value1, Short value2) {
            addCriterion("REMOTE_ALARM3_FLAG not between", value1, value2, "remoteAlarm3Flag");
            return this;
        }

        public Criteria andRemoteTimingFlagIsNull() {
            addCriterion("REMOTE_TIMING_FLAG is null");
            return this;
        }

        public Criteria andRemoteTimingFlagIsNotNull() {
            addCriterion("REMOTE_TIMING_FLAG is not null");
            return this;
        }

        public Criteria andRemoteTimingFlagEqualTo(Short value) {
            addCriterion("REMOTE_TIMING_FLAG =", value, "remoteTimingFlag");
            return this;
        }

        public Criteria andRemoteTimingFlagNotEqualTo(Short value) {
            addCriterion("REMOTE_TIMING_FLAG <>", value, "remoteTimingFlag");
            return this;
        }

        public Criteria andRemoteTimingFlagGreaterThan(Short value) {
            addCriterion("REMOTE_TIMING_FLAG >", value, "remoteTimingFlag");
            return this;
        }

        public Criteria andRemoteTimingFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("REMOTE_TIMING_FLAG >=", value, "remoteTimingFlag");
            return this;
        }

        public Criteria andRemoteTimingFlagLessThan(Short value) {
            addCriterion("REMOTE_TIMING_FLAG <", value, "remoteTimingFlag");
            return this;
        }

        public Criteria andRemoteTimingFlagLessThanOrEqualTo(Short value) {
            addCriterion("REMOTE_TIMING_FLAG <=", value, "remoteTimingFlag");
            return this;
        }

        public Criteria andRemoteTimingFlagIn(List values) {
            addCriterion("REMOTE_TIMING_FLAG in", values, "remoteTimingFlag");
            return this;
        }

        public Criteria andRemoteTimingFlagNotIn(List values) {
            addCriterion("REMOTE_TIMING_FLAG not in", values, "remoteTimingFlag");
            return this;
        }

        public Criteria andRemoteTimingFlagBetween(Short value1, Short value2) {
            addCriterion("REMOTE_TIMING_FLAG between", value1, value2, "remoteTimingFlag");
            return this;
        }

        public Criteria andRemoteTimingFlagNotBetween(Short value1, Short value2) {
            addCriterion("REMOTE_TIMING_FLAG not between", value1, value2, "remoteTimingFlag");
            return this;
        }

        public Criteria andRemoteTimingIntervalIsNull() {
            addCriterion("REMOTE_TIMING_INTERVAL is null");
            return this;
        }

        public Criteria andRemoteTimingIntervalIsNotNull() {
            addCriterion("REMOTE_TIMING_INTERVAL is not null");
            return this;
        }

        public Criteria andRemoteTimingIntervalEqualTo(Long value) {
            addCriterion("REMOTE_TIMING_INTERVAL =", value, "remoteTimingInterval");
            return this;
        }

        public Criteria andRemoteTimingIntervalNotEqualTo(Long value) {
            addCriterion("REMOTE_TIMING_INTERVAL <>", value, "remoteTimingInterval");
            return this;
        }

        public Criteria andRemoteTimingIntervalGreaterThan(Long value) {
            addCriterion("REMOTE_TIMING_INTERVAL >", value, "remoteTimingInterval");
            return this;
        }

        public Criteria andRemoteTimingIntervalGreaterThanOrEqualTo(Long value) {
            addCriterion("REMOTE_TIMING_INTERVAL >=", value, "remoteTimingInterval");
            return this;
        }

        public Criteria andRemoteTimingIntervalLessThan(Long value) {
            addCriterion("REMOTE_TIMING_INTERVAL <", value, "remoteTimingInterval");
            return this;
        }

        public Criteria andRemoteTimingIntervalLessThanOrEqualTo(Long value) {
            addCriterion("REMOTE_TIMING_INTERVAL <=", value, "remoteTimingInterval");
            return this;
        }

        public Criteria andRemoteTimingIntervalIn(List values) {
            addCriterion("REMOTE_TIMING_INTERVAL in", values, "remoteTimingInterval");
            return this;
        }

        public Criteria andRemoteTimingIntervalNotIn(List values) {
            addCriterion("REMOTE_TIMING_INTERVAL not in", values, "remoteTimingInterval");
            return this;
        }

        public Criteria andRemoteTimingIntervalBetween(Long value1, Long value2) {
            addCriterion("REMOTE_TIMING_INTERVAL between", value1, value2, "remoteTimingInterval");
            return this;
        }

        public Criteria andRemoteTimingIntervalNotBetween(Long value1, Long value2) {
            addCriterion("REMOTE_TIMING_INTERVAL not between", value1, value2, "remoteTimingInterval");
            return this;
        }

        public Criteria andRemoteShootingFlagIsNull() {
            addCriterion("REMOTE_SHOOTING_FLAG is null");
            return this;
        }

        public Criteria andRemoteShootingFlagIsNotNull() {
            addCriterion("REMOTE_SHOOTING_FLAG is not null");
            return this;
        }

        public Criteria andRemoteShootingFlagEqualTo(Short value) {
            addCriterion("REMOTE_SHOOTING_FLAG =", value, "remoteShootingFlag");
            return this;
        }

        public Criteria andRemoteShootingFlagNotEqualTo(Short value) {
            addCriterion("REMOTE_SHOOTING_FLAG <>", value, "remoteShootingFlag");
            return this;
        }

        public Criteria andRemoteShootingFlagGreaterThan(Short value) {
            addCriterion("REMOTE_SHOOTING_FLAG >", value, "remoteShootingFlag");
            return this;
        }

        public Criteria andRemoteShootingFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("REMOTE_SHOOTING_FLAG >=", value, "remoteShootingFlag");
            return this;
        }

        public Criteria andRemoteShootingFlagLessThan(Short value) {
            addCriterion("REMOTE_SHOOTING_FLAG <", value, "remoteShootingFlag");
            return this;
        }

        public Criteria andRemoteShootingFlagLessThanOrEqualTo(Short value) {
            addCriterion("REMOTE_SHOOTING_FLAG <=", value, "remoteShootingFlag");
            return this;
        }

        public Criteria andRemoteShootingFlagIn(List values) {
            addCriterion("REMOTE_SHOOTING_FLAG in", values, "remoteShootingFlag");
            return this;
        }

        public Criteria andRemoteShootingFlagNotIn(List values) {
            addCriterion("REMOTE_SHOOTING_FLAG not in", values, "remoteShootingFlag");
            return this;
        }

        public Criteria andRemoteShootingFlagBetween(Short value1, Short value2) {
            addCriterion("REMOTE_SHOOTING_FLAG between", value1, value2, "remoteShootingFlag");
            return this;
        }

        public Criteria andRemoteShootingFlagNotBetween(Short value1, Short value2) {
            addCriterion("REMOTE_SHOOTING_FLAG not between", value1, value2, "remoteShootingFlag");
            return this;
        }

        public Criteria andTotalCapacityIsNull() {
            addCriterion("TOTAL_CAPACITY is null");
            return this;
        }

        public Criteria andTotalCapacityIsNotNull() {
            addCriterion("TOTAL_CAPACITY is not null");
            return this;
        }

        public Criteria andTotalCapacityEqualTo(Long value) {
            addCriterion("TOTAL_CAPACITY =", value, "totalCapacity");
            return this;
        }

        public Criteria andTotalCapacityNotEqualTo(Long value) {
            addCriterion("TOTAL_CAPACITY <>", value, "totalCapacity");
            return this;
        }

        public Criteria andTotalCapacityGreaterThan(Long value) {
            addCriterion("TOTAL_CAPACITY >", value, "totalCapacity");
            return this;
        }

        public Criteria andTotalCapacityGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_CAPACITY >=", value, "totalCapacity");
            return this;
        }

        public Criteria andTotalCapacityLessThan(Long value) {
            addCriterion("TOTAL_CAPACITY <", value, "totalCapacity");
            return this;
        }

        public Criteria andTotalCapacityLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_CAPACITY <=", value, "totalCapacity");
            return this;
        }

        public Criteria andTotalCapacityIn(List values) {
            addCriterion("TOTAL_CAPACITY in", values, "totalCapacity");
            return this;
        }

        public Criteria andTotalCapacityNotIn(List values) {
            addCriterion("TOTAL_CAPACITY not in", values, "totalCapacity");
            return this;
        }

        public Criteria andTotalCapacityBetween(Long value1, Long value2) {
            addCriterion("TOTAL_CAPACITY between", value1, value2, "totalCapacity");
            return this;
        }

        public Criteria andTotalCapacityNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_CAPACITY not between", value1, value2, "totalCapacity");
            return this;
        }

        public Criteria andUsedCapacityIsNull() {
            addCriterion("USED_CAPACITY is null");
            return this;
        }

        public Criteria andUsedCapacityIsNotNull() {
            addCriterion("USED_CAPACITY is not null");
            return this;
        }

        public Criteria andUsedCapacityEqualTo(Long value) {
            addCriterion("USED_CAPACITY =", value, "usedCapacity");
            return this;
        }

        public Criteria andUsedCapacityNotEqualTo(Long value) {
            addCriterion("USED_CAPACITY <>", value, "usedCapacity");
            return this;
        }

        public Criteria andUsedCapacityGreaterThan(Long value) {
            addCriterion("USED_CAPACITY >", value, "usedCapacity");
            return this;
        }

        public Criteria andUsedCapacityGreaterThanOrEqualTo(Long value) {
            addCriterion("USED_CAPACITY >=", value, "usedCapacity");
            return this;
        }

        public Criteria andUsedCapacityLessThan(Long value) {
            addCriterion("USED_CAPACITY <", value, "usedCapacity");
            return this;
        }

        public Criteria andUsedCapacityLessThanOrEqualTo(Long value) {
            addCriterion("USED_CAPACITY <=", value, "usedCapacity");
            return this;
        }

        public Criteria andUsedCapacityIn(List values) {
            addCriterion("USED_CAPACITY in", values, "usedCapacity");
            return this;
        }

        public Criteria andUsedCapacityNotIn(List values) {
            addCriterion("USED_CAPACITY not in", values, "usedCapacity");
            return this;
        }

        public Criteria andUsedCapacityBetween(Long value1, Long value2) {
            addCriterion("USED_CAPACITY between", value1, value2, "usedCapacity");
            return this;
        }

        public Criteria andUsedCapacityNotBetween(Long value1, Long value2) {
            addCriterion("USED_CAPACITY not between", value1, value2, "usedCapacity");
            return this;
        }

        public Criteria andRemainCapacityIsNull() {
            addCriterion("REMAIN_CAPACITY is null");
            return this;
        }

        public Criteria andRemainCapacityIsNotNull() {
            addCriterion("REMAIN_CAPACITY is not null");
            return this;
        }

        public Criteria andRemainCapacityEqualTo(Long value) {
            addCriterion("REMAIN_CAPACITY =", value, "remainCapacity");
            return this;
        }

        public Criteria andRemainCapacityNotEqualTo(Long value) {
            addCriterion("REMAIN_CAPACITY <>", value, "remainCapacity");
            return this;
        }

        public Criteria andRemainCapacityGreaterThan(Long value) {
            addCriterion("REMAIN_CAPACITY >", value, "remainCapacity");
            return this;
        }

        public Criteria andRemainCapacityGreaterThanOrEqualTo(Long value) {
            addCriterion("REMAIN_CAPACITY >=", value, "remainCapacity");
            return this;
        }

        public Criteria andRemainCapacityLessThan(Long value) {
            addCriterion("REMAIN_CAPACITY <", value, "remainCapacity");
            return this;
        }

        public Criteria andRemainCapacityLessThanOrEqualTo(Long value) {
            addCriterion("REMAIN_CAPACITY <=", value, "remainCapacity");
            return this;
        }

        public Criteria andRemainCapacityIn(List values) {
            addCriterion("REMAIN_CAPACITY in", values, "remainCapacity");
            return this;
        }

        public Criteria andRemainCapacityNotIn(List values) {
            addCriterion("REMAIN_CAPACITY not in", values, "remainCapacity");
            return this;
        }

        public Criteria andRemainCapacityBetween(Long value1, Long value2) {
            addCriterion("REMAIN_CAPACITY between", value1, value2, "remainCapacity");
            return this;
        }

        public Criteria andRemainCapacityNotBetween(Long value1, Long value2) {
            addCriterion("REMAIN_CAPACITY not between", value1, value2, "remainCapacity");
            return this;
        }

        public Criteria andSdCardExistFlagIsNull() {
            addCriterion("SD_CARD_EXIST_FLAG is null");
            return this;
        }

        public Criteria andSdCardExistFlagIsNotNull() {
            addCriterion("SD_CARD_EXIST_FLAG is not null");
            return this;
        }

        public Criteria andSdCardExistFlagEqualTo(Short value) {
            addCriterion("SD_CARD_EXIST_FLAG =", value, "sdCardExistFlag");
            return this;
        }

        public Criteria andSdCardExistFlagNotEqualTo(Short value) {
            addCriterion("SD_CARD_EXIST_FLAG <>", value, "sdCardExistFlag");
            return this;
        }

        public Criteria andSdCardExistFlagGreaterThan(Short value) {
            addCriterion("SD_CARD_EXIST_FLAG >", value, "sdCardExistFlag");
            return this;
        }

        public Criteria andSdCardExistFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("SD_CARD_EXIST_FLAG >=", value, "sdCardExistFlag");
            return this;
        }

        public Criteria andSdCardExistFlagLessThan(Short value) {
            addCriterion("SD_CARD_EXIST_FLAG <", value, "sdCardExistFlag");
            return this;
        }

        public Criteria andSdCardExistFlagLessThanOrEqualTo(Short value) {
            addCriterion("SD_CARD_EXIST_FLAG <=", value, "sdCardExistFlag");
            return this;
        }

        public Criteria andSdCardExistFlagIn(List values) {
            addCriterion("SD_CARD_EXIST_FLAG in", values, "sdCardExistFlag");
            return this;
        }

        public Criteria andSdCardExistFlagNotIn(List values) {
            addCriterion("SD_CARD_EXIST_FLAG not in", values, "sdCardExistFlag");
            return this;
        }

        public Criteria andSdCardExistFlagBetween(Short value1, Short value2) {
            addCriterion("SD_CARD_EXIST_FLAG between", value1, value2, "sdCardExistFlag");
            return this;
        }

        public Criteria andSdCardExistFlagNotBetween(Short value1, Short value2) {
            addCriterion("SD_CARD_EXIST_FLAG not between", value1, value2, "sdCardExistFlag");
            return this;
        }

        public Criteria andLowCapacityFlagIsNull() {
            addCriterion("LOW_CAPACITY_FLAG is null");
            return this;
        }

        public Criteria andLowCapacityFlagIsNotNull() {
            addCriterion("LOW_CAPACITY_FLAG is not null");
            return this;
        }

        public Criteria andLowCapacityFlagEqualTo(Short value) {
            addCriterion("LOW_CAPACITY_FLAG =", value, "lowCapacityFlag");
            return this;
        }

        public Criteria andLowCapacityFlagNotEqualTo(Short value) {
            addCriterion("LOW_CAPACITY_FLAG <>", value, "lowCapacityFlag");
            return this;
        }

        public Criteria andLowCapacityFlagGreaterThan(Short value) {
            addCriterion("LOW_CAPACITY_FLAG >", value, "lowCapacityFlag");
            return this;
        }

        public Criteria andLowCapacityFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("LOW_CAPACITY_FLAG >=", value, "lowCapacityFlag");
            return this;
        }

        public Criteria andLowCapacityFlagLessThan(Short value) {
            addCriterion("LOW_CAPACITY_FLAG <", value, "lowCapacityFlag");
            return this;
        }

        public Criteria andLowCapacityFlagLessThanOrEqualTo(Short value) {
            addCriterion("LOW_CAPACITY_FLAG <=", value, "lowCapacityFlag");
            return this;
        }

        public Criteria andLowCapacityFlagIn(List values) {
            addCriterion("LOW_CAPACITY_FLAG in", values, "lowCapacityFlag");
            return this;
        }

        public Criteria andLowCapacityFlagNotIn(List values) {
            addCriterion("LOW_CAPACITY_FLAG not in", values, "lowCapacityFlag");
            return this;
        }

        public Criteria andLowCapacityFlagBetween(Short value1, Short value2) {
            addCriterion("LOW_CAPACITY_FLAG between", value1, value2, "lowCapacityFlag");
            return this;
        }

        public Criteria andLowCapacityFlagNotBetween(Short value1, Short value2) {
            addCriterion("LOW_CAPACITY_FLAG not between", value1, value2, "lowCapacityFlag");
            return this;
        }

        public Criteria andStoreCycleIsNull() {
            addCriterion("STORE_CYCLE is null");
            return this;
        }

        public Criteria andStoreCycleIsNotNull() {
            addCriterion("STORE_CYCLE is not null");
            return this;
        }

        public Criteria andStoreCycleEqualTo(Long value) {
            addCriterion("STORE_CYCLE =", value, "storeCycle");
            return this;
        }

        public Criteria andStoreCycleNotEqualTo(Long value) {
            addCriterion("STORE_CYCLE <>", value, "storeCycle");
            return this;
        }

        public Criteria andStoreCycleGreaterThan(Long value) {
            addCriterion("STORE_CYCLE >", value, "storeCycle");
            return this;
        }

        public Criteria andStoreCycleGreaterThanOrEqualTo(Long value) {
            addCriterion("STORE_CYCLE >=", value, "storeCycle");
            return this;
        }

        public Criteria andStoreCycleLessThan(Long value) {
            addCriterion("STORE_CYCLE <", value, "storeCycle");
            return this;
        }

        public Criteria andStoreCycleLessThanOrEqualTo(Long value) {
            addCriterion("STORE_CYCLE <=", value, "storeCycle");
            return this;
        }

        public Criteria andStoreCycleIn(List values) {
            addCriterion("STORE_CYCLE in", values, "storeCycle");
            return this;
        }

        public Criteria andStoreCycleNotIn(List values) {
            addCriterion("STORE_CYCLE not in", values, "storeCycle");
            return this;
        }

        public Criteria andStoreCycleBetween(Long value1, Long value2) {
            addCriterion("STORE_CYCLE between", value1, value2, "storeCycle");
            return this;
        }

        public Criteria andStoreCycleNotBetween(Long value1, Long value2) {
            addCriterion("STORE_CYCLE not between", value1, value2, "storeCycle");
            return this;
        }

        public Criteria andOverwriteFlagIsNull() {
            addCriterion("OVERWRITE_FLAG is null");
            return this;
        }

        public Criteria andOverwriteFlagIsNotNull() {
            addCriterion("OVERWRITE_FLAG is not null");
            return this;
        }

        public Criteria andOverwriteFlagEqualTo(Short value) {
            addCriterion("OVERWRITE_FLAG =", value, "overwriteFlag");
            return this;
        }

        public Criteria andOverwriteFlagNotEqualTo(Short value) {
            addCriterion("OVERWRITE_FLAG <>", value, "overwriteFlag");
            return this;
        }

        public Criteria andOverwriteFlagGreaterThan(Short value) {
            addCriterion("OVERWRITE_FLAG >", value, "overwriteFlag");
            return this;
        }

        public Criteria andOverwriteFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("OVERWRITE_FLAG >=", value, "overwriteFlag");
            return this;
        }

        public Criteria andOverwriteFlagLessThan(Short value) {
            addCriterion("OVERWRITE_FLAG <", value, "overwriteFlag");
            return this;
        }

        public Criteria andOverwriteFlagLessThanOrEqualTo(Short value) {
            addCriterion("OVERWRITE_FLAG <=", value, "overwriteFlag");
            return this;
        }

        public Criteria andOverwriteFlagIn(List values) {
            addCriterion("OVERWRITE_FLAG in", values, "overwriteFlag");
            return this;
        }

        public Criteria andOverwriteFlagNotIn(List values) {
            addCriterion("OVERWRITE_FLAG not in", values, "overwriteFlag");
            return this;
        }

        public Criteria andOverwriteFlagBetween(Short value1, Short value2) {
            addCriterion("OVERWRITE_FLAG between", value1, value2, "overwriteFlag");
            return this;
        }

        public Criteria andOverwriteFlagNotBetween(Short value1, Short value2) {
            addCriterion("OVERWRITE_FLAG not between", value1, value2, "overwriteFlag");
            return this;
        }

        public Criteria andBackupFlagIsNull() {
            addCriterion("BACKUP_FLAG is null");
            return this;
        }

        public Criteria andBackupFlagIsNotNull() {
            addCriterion("BACKUP_FLAG is not null");
            return this;
        }

        public Criteria andBackupFlagEqualTo(Short value) {
            addCriterion("BACKUP_FLAG =", value, "backupFlag");
            return this;
        }

        public Criteria andBackupFlagNotEqualTo(Short value) {
            addCriterion("BACKUP_FLAG <>", value, "backupFlag");
            return this;
        }

        public Criteria andBackupFlagGreaterThan(Short value) {
            addCriterion("BACKUP_FLAG >", value, "backupFlag");
            return this;
        }

        public Criteria andBackupFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("BACKUP_FLAG >=", value, "backupFlag");
            return this;
        }

        public Criteria andBackupFlagLessThan(Short value) {
            addCriterion("BACKUP_FLAG <", value, "backupFlag");
            return this;
        }

        public Criteria andBackupFlagLessThanOrEqualTo(Short value) {
            addCriterion("BACKUP_FLAG <=", value, "backupFlag");
            return this;
        }

        public Criteria andBackupFlagIn(List values) {
            addCriterion("BACKUP_FLAG in", values, "backupFlag");
            return this;
        }

        public Criteria andBackupFlagNotIn(List values) {
            addCriterion("BACKUP_FLAG not in", values, "backupFlag");
            return this;
        }

        public Criteria andBackupFlagBetween(Short value1, Short value2) {
            addCriterion("BACKUP_FLAG between", value1, value2, "backupFlag");
            return this;
        }

        public Criteria andBackupFlagNotBetween(Short value1, Short value2) {
            addCriterion("BACKUP_FLAG not between", value1, value2, "backupFlag");
            return this;
        }

        public Criteria andCleanFlagIsNull() {
            addCriterion("CLEAN_FLAG is null");
            return this;
        }

        public Criteria andCleanFlagIsNotNull() {
            addCriterion("CLEAN_FLAG is not null");
            return this;
        }

        public Criteria andCleanFlagEqualTo(Short value) {
            addCriterion("CLEAN_FLAG =", value, "cleanFlag");
            return this;
        }

        public Criteria andCleanFlagNotEqualTo(Short value) {
            addCriterion("CLEAN_FLAG <>", value, "cleanFlag");
            return this;
        }

        public Criteria andCleanFlagGreaterThan(Short value) {
            addCriterion("CLEAN_FLAG >", value, "cleanFlag");
            return this;
        }

        public Criteria andCleanFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("CLEAN_FLAG >=", value, "cleanFlag");
            return this;
        }

        public Criteria andCleanFlagLessThan(Short value) {
            addCriterion("CLEAN_FLAG <", value, "cleanFlag");
            return this;
        }

        public Criteria andCleanFlagLessThanOrEqualTo(Short value) {
            addCriterion("CLEAN_FLAG <=", value, "cleanFlag");
            return this;
        }

        public Criteria andCleanFlagIn(List values) {
            addCriterion("CLEAN_FLAG in", values, "cleanFlag");
            return this;
        }

        public Criteria andCleanFlagNotIn(List values) {
            addCriterion("CLEAN_FLAG not in", values, "cleanFlag");
            return this;
        }

        public Criteria andCleanFlagBetween(Short value1, Short value2) {
            addCriterion("CLEAN_FLAG between", value1, value2, "cleanFlag");
            return this;
        }

        public Criteria andCleanFlagNotBetween(Short value1, Short value2) {
            addCriterion("CLEAN_FLAG not between", value1, value2, "cleanFlag");
            return this;
        }

        public Criteria andStoreSizeIsNull() {
            addCriterion("STORE_SIZE is null");
            return this;
        }

        public Criteria andStoreSizeIsNotNull() {
            addCriterion("STORE_SIZE is not null");
            return this;
        }

        public Criteria andStoreSizeEqualTo(String value) {
            addCriterion("STORE_SIZE =", value, "storeSize");
            return this;
        }

        public Criteria andStoreSizeNotEqualTo(String value) {
            addCriterion("STORE_SIZE <>", value, "storeSize");
            return this;
        }

        public Criteria andStoreSizeGreaterThan(String value) {
            addCriterion("STORE_SIZE >", value, "storeSize");
            return this;
        }

        public Criteria andStoreSizeGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_SIZE >=", value, "storeSize");
            return this;
        }

        public Criteria andStoreSizeLessThan(String value) {
            addCriterion("STORE_SIZE <", value, "storeSize");
            return this;
        }

        public Criteria andStoreSizeLessThanOrEqualTo(String value) {
            addCriterion("STORE_SIZE <=", value, "storeSize");
            return this;
        }

        public Criteria andStoreSizeLike(String value) {
            addCriterion("STORE_SIZE like", value, "storeSize");
            return this;
        }

        public Criteria andStoreSizeNotLike(String value) {
            addCriterion("STORE_SIZE not like", value, "storeSize");
            return this;
        }

        public Criteria andStoreSizeIn(List values) {
            addCriterion("STORE_SIZE in", values, "storeSize");
            return this;
        }

        public Criteria andStoreSizeNotIn(List values) {
            addCriterion("STORE_SIZE not in", values, "storeSize");
            return this;
        }

        public Criteria andStoreSizeBetween(String value1, String value2) {
            addCriterion("STORE_SIZE between", value1, value2, "storeSize");
            return this;
        }

        public Criteria andStoreSizeNotBetween(String value1, String value2) {
            addCriterion("STORE_SIZE not between", value1, value2, "storeSize");
            return this;
        }

        public Criteria andBackupPathIsNull() {
            addCriterion("BACKUP_PATH is null");
            return this;
        }

        public Criteria andBackupPathIsNotNull() {
            addCriterion("BACKUP_PATH is not null");
            return this;
        }

        public Criteria andBackupPathEqualTo(String value) {
            addCriterion("BACKUP_PATH =", value, "backupPath");
            return this;
        }

        public Criteria andBackupPathNotEqualTo(String value) {
            addCriterion("BACKUP_PATH <>", value, "backupPath");
            return this;
        }

        public Criteria andBackupPathGreaterThan(String value) {
            addCriterion("BACKUP_PATH >", value, "backupPath");
            return this;
        }

        public Criteria andBackupPathGreaterThanOrEqualTo(String value) {
            addCriterion("BACKUP_PATH >=", value, "backupPath");
            return this;
        }

        public Criteria andBackupPathLessThan(String value) {
            addCriterion("BACKUP_PATH <", value, "backupPath");
            return this;
        }

        public Criteria andBackupPathLessThanOrEqualTo(String value) {
            addCriterion("BACKUP_PATH <=", value, "backupPath");
            return this;
        }

        public Criteria andBackupPathLike(String value) {
            addCriterion("BACKUP_PATH like", value, "backupPath");
            return this;
        }

        public Criteria andBackupPathNotLike(String value) {
            addCriterion("BACKUP_PATH not like", value, "backupPath");
            return this;
        }

        public Criteria andBackupPathIn(List values) {
            addCriterion("BACKUP_PATH in", values, "backupPath");
            return this;
        }

        public Criteria andBackupPathNotIn(List values) {
            addCriterion("BACKUP_PATH not in", values, "backupPath");
            return this;
        }

        public Criteria andBackupPathBetween(String value1, String value2) {
            addCriterion("BACKUP_PATH between", value1, value2, "backupPath");
            return this;
        }

        public Criteria andBackupPathNotBetween(String value1, String value2) {
            addCriterion("BACKUP_PATH not between", value1, value2, "backupPath");
            return this;
        }

        public Criteria andBackupTimeIsNull() {
            addCriterion("BACKUP_TIME is null");
            return this;
        }

        public Criteria andBackupTimeIsNotNull() {
            addCriterion("BACKUP_TIME is not null");
            return this;
        }

        public Criteria andBackupTimeEqualTo(String value) {
            addCriterion("BACKUP_TIME =", value, "backupTime");
            return this;
        }

        public Criteria andBackupTimeNotEqualTo(String value) {
            addCriterion("BACKUP_TIME <>", value, "backupTime");
            return this;
        }

        public Criteria andBackupTimeGreaterThan(String value) {
            addCriterion("BACKUP_TIME >", value, "backupTime");
            return this;
        }

        public Criteria andBackupTimeGreaterThanOrEqualTo(String value) {
            addCriterion("BACKUP_TIME >=", value, "backupTime");
            return this;
        }

        public Criteria andBackupTimeLessThan(String value) {
            addCriterion("BACKUP_TIME <", value, "backupTime");
            return this;
        }

        public Criteria andBackupTimeLessThanOrEqualTo(String value) {
            addCriterion("BACKUP_TIME <=", value, "backupTime");
            return this;
        }

        public Criteria andBackupTimeLike(String value) {
            addCriterion("BACKUP_TIME like", value, "backupTime");
            return this;
        }

        public Criteria andBackupTimeNotLike(String value) {
            addCriterion("BACKUP_TIME not like", value, "backupTime");
            return this;
        }

        public Criteria andBackupTimeIn(List values) {
            addCriterion("BACKUP_TIME in", values, "backupTime");
            return this;
        }

        public Criteria andBackupTimeNotIn(List values) {
            addCriterion("BACKUP_TIME not in", values, "backupTime");
            return this;
        }

        public Criteria andBackupTimeBetween(String value1, String value2) {
            addCriterion("BACKUP_TIME between", value1, value2, "backupTime");
            return this;
        }

        public Criteria andBackupTimeNotBetween(String value1, String value2) {
            addCriterion("BACKUP_TIME not between", value1, value2, "backupTime");
            return this;
        }

        public Criteria andBrightnessIsNull() {
            addCriterion("BRIGHTNESS is null");
            return this;
        }

        public Criteria andBrightnessIsNotNull() {
            addCriterion("BRIGHTNESS is not null");
            return this;
        }

        public Criteria andBrightnessEqualTo(Long value) {
            addCriterion("BRIGHTNESS =", value, "brightness");
            return this;
        }

        public Criteria andBrightnessNotEqualTo(Long value) {
            addCriterion("BRIGHTNESS <>", value, "brightness");
            return this;
        }

        public Criteria andBrightnessGreaterThan(Long value) {
            addCriterion("BRIGHTNESS >", value, "brightness");
            return this;
        }

        public Criteria andBrightnessGreaterThanOrEqualTo(Long value) {
            addCriterion("BRIGHTNESS >=", value, "brightness");
            return this;
        }

        public Criteria andBrightnessLessThan(Long value) {
            addCriterion("BRIGHTNESS <", value, "brightness");
            return this;
        }

        public Criteria andBrightnessLessThanOrEqualTo(Long value) {
            addCriterion("BRIGHTNESS <=", value, "brightness");
            return this;
        }

        public Criteria andBrightnessIn(List values) {
            addCriterion("BRIGHTNESS in", values, "brightness");
            return this;
        }

        public Criteria andBrightnessNotIn(List values) {
            addCriterion("BRIGHTNESS not in", values, "brightness");
            return this;
        }

        public Criteria andBrightnessBetween(Long value1, Long value2) {
            addCriterion("BRIGHTNESS between", value1, value2, "brightness");
            return this;
        }

        public Criteria andBrightnessNotBetween(Long value1, Long value2) {
            addCriterion("BRIGHTNESS not between", value1, value2, "brightness");
            return this;
        }

        public Criteria andContrastIsNull() {
            addCriterion("CONTRAST is null");
            return this;
        }

        public Criteria andContrastIsNotNull() {
            addCriterion("CONTRAST is not null");
            return this;
        }

        public Criteria andContrastEqualTo(Long value) {
            addCriterion("CONTRAST =", value, "contrast");
            return this;
        }

        public Criteria andContrastNotEqualTo(Long value) {
            addCriterion("CONTRAST <>", value, "contrast");
            return this;
        }

        public Criteria andContrastGreaterThan(Long value) {
            addCriterion("CONTRAST >", value, "contrast");
            return this;
        }

        public Criteria andContrastGreaterThanOrEqualTo(Long value) {
            addCriterion("CONTRAST >=", value, "contrast");
            return this;
        }

        public Criteria andContrastLessThan(Long value) {
            addCriterion("CONTRAST <", value, "contrast");
            return this;
        }

        public Criteria andContrastLessThanOrEqualTo(Long value) {
            addCriterion("CONTRAST <=", value, "contrast");
            return this;
        }

        public Criteria andContrastIn(List values) {
            addCriterion("CONTRAST in", values, "contrast");
            return this;
        }

        public Criteria andContrastNotIn(List values) {
            addCriterion("CONTRAST not in", values, "contrast");
            return this;
        }

        public Criteria andContrastBetween(Long value1, Long value2) {
            addCriterion("CONTRAST between", value1, value2, "contrast");
            return this;
        }

        public Criteria andContrastNotBetween(Long value1, Long value2) {
            addCriterion("CONTRAST not between", value1, value2, "contrast");
            return this;
        }

        public Criteria andSaturationIsNull() {
            addCriterion("SATURATION is null");
            return this;
        }

        public Criteria andSaturationIsNotNull() {
            addCriterion("SATURATION is not null");
            return this;
        }

        public Criteria andSaturationEqualTo(Long value) {
            addCriterion("SATURATION =", value, "saturation");
            return this;
        }

        public Criteria andSaturationNotEqualTo(Long value) {
            addCriterion("SATURATION <>", value, "saturation");
            return this;
        }

        public Criteria andSaturationGreaterThan(Long value) {
            addCriterion("SATURATION >", value, "saturation");
            return this;
        }

        public Criteria andSaturationGreaterThanOrEqualTo(Long value) {
            addCriterion("SATURATION >=", value, "saturation");
            return this;
        }

        public Criteria andSaturationLessThan(Long value) {
            addCriterion("SATURATION <", value, "saturation");
            return this;
        }

        public Criteria andSaturationLessThanOrEqualTo(Long value) {
            addCriterion("SATURATION <=", value, "saturation");
            return this;
        }

        public Criteria andSaturationIn(List values) {
            addCriterion("SATURATION in", values, "saturation");
            return this;
        }

        public Criteria andSaturationNotIn(List values) {
            addCriterion("SATURATION not in", values, "saturation");
            return this;
        }

        public Criteria andSaturationBetween(Long value1, Long value2) {
            addCriterion("SATURATION between", value1, value2, "saturation");
            return this;
        }

        public Criteria andSaturationNotBetween(Long value1, Long value2) {
            addCriterion("SATURATION not between", value1, value2, "saturation");
            return this;
        }

        public Criteria andHueIsNull() {
            addCriterion("HUE is null");
            return this;
        }

        public Criteria andHueIsNotNull() {
            addCriterion("HUE is not null");
            return this;
        }

        public Criteria andHueEqualTo(Long value) {
            addCriterion("HUE =", value, "hue");
            return this;
        }

        public Criteria andHueNotEqualTo(Long value) {
            addCriterion("HUE <>", value, "hue");
            return this;
        }

        public Criteria andHueGreaterThan(Long value) {
            addCriterion("HUE >", value, "hue");
            return this;
        }

        public Criteria andHueGreaterThanOrEqualTo(Long value) {
            addCriterion("HUE >=", value, "hue");
            return this;
        }

        public Criteria andHueLessThan(Long value) {
            addCriterion("HUE <", value, "hue");
            return this;
        }

        public Criteria andHueLessThanOrEqualTo(Long value) {
            addCriterion("HUE <=", value, "hue");
            return this;
        }

        public Criteria andHueIn(List values) {
            addCriterion("HUE in", values, "hue");
            return this;
        }

        public Criteria andHueNotIn(List values) {
            addCriterion("HUE not in", values, "hue");
            return this;
        }

        public Criteria andHueBetween(Long value1, Long value2) {
            addCriterion("HUE between", value1, value2, "hue");
            return this;
        }

        public Criteria andHueNotBetween(Long value1, Long value2) {
            addCriterion("HUE not between", value1, value2, "hue");
            return this;
        }

        public Criteria andFrameNumIsNull() {
            addCriterion("FRAME_NUM is null");
            return this;
        }

        public Criteria andFrameNumIsNotNull() {
            addCriterion("FRAME_NUM is not null");
            return this;
        }

        public Criteria andFrameNumEqualTo(Long value) {
            addCriterion("FRAME_NUM =", value, "frameNum");
            return this;
        }

        public Criteria andFrameNumNotEqualTo(Long value) {
            addCriterion("FRAME_NUM <>", value, "frameNum");
            return this;
        }

        public Criteria andFrameNumGreaterThan(Long value) {
            addCriterion("FRAME_NUM >", value, "frameNum");
            return this;
        }

        public Criteria andFrameNumGreaterThanOrEqualTo(Long value) {
            addCriterion("FRAME_NUM >=", value, "frameNum");
            return this;
        }

        public Criteria andFrameNumLessThan(Long value) {
            addCriterion("FRAME_NUM <", value, "frameNum");
            return this;
        }

        public Criteria andFrameNumLessThanOrEqualTo(Long value) {
            addCriterion("FRAME_NUM <=", value, "frameNum");
            return this;
        }

        public Criteria andFrameNumIn(List values) {
            addCriterion("FRAME_NUM in", values, "frameNum");
            return this;
        }

        public Criteria andFrameNumNotIn(List values) {
            addCriterion("FRAME_NUM not in", values, "frameNum");
            return this;
        }

        public Criteria andFrameNumBetween(Long value1, Long value2) {
            addCriterion("FRAME_NUM between", value1, value2, "frameNum");
            return this;
        }

        public Criteria andFrameNumNotBetween(Long value1, Long value2) {
            addCriterion("FRAME_NUM not between", value1, value2, "frameNum");
            return this;
        }

        public Criteria andFrameIntervalIsNull() {
            addCriterion("FRAME_INTERVAL is null");
            return this;
        }

        public Criteria andFrameIntervalIsNotNull() {
            addCriterion("FRAME_INTERVAL is not null");
            return this;
        }

        public Criteria andFrameIntervalEqualTo(Long value) {
            addCriterion("FRAME_INTERVAL =", value, "frameInterval");
            return this;
        }

        public Criteria andFrameIntervalNotEqualTo(Long value) {
            addCriterion("FRAME_INTERVAL <>", value, "frameInterval");
            return this;
        }

        public Criteria andFrameIntervalGreaterThan(Long value) {
            addCriterion("FRAME_INTERVAL >", value, "frameInterval");
            return this;
        }

        public Criteria andFrameIntervalGreaterThanOrEqualTo(Long value) {
            addCriterion("FRAME_INTERVAL >=", value, "frameInterval");
            return this;
        }

        public Criteria andFrameIntervalLessThan(Long value) {
            addCriterion("FRAME_INTERVAL <", value, "frameInterval");
            return this;
        }

        public Criteria andFrameIntervalLessThanOrEqualTo(Long value) {
            addCriterion("FRAME_INTERVAL <=", value, "frameInterval");
            return this;
        }

        public Criteria andFrameIntervalIn(List values) {
            addCriterion("FRAME_INTERVAL in", values, "frameInterval");
            return this;
        }

        public Criteria andFrameIntervalNotIn(List values) {
            addCriterion("FRAME_INTERVAL not in", values, "frameInterval");
            return this;
        }

        public Criteria andFrameIntervalBetween(Long value1, Long value2) {
            addCriterion("FRAME_INTERVAL between", value1, value2, "frameInterval");
            return this;
        }

        public Criteria andFrameIntervalNotBetween(Long value1, Long value2) {
            addCriterion("FRAME_INTERVAL not between", value1, value2, "frameInterval");
            return this;
        }

        public Criteria andTransmissionSpeedIsNull() {
            addCriterion("TRANSMISSION_SPEED is null");
            return this;
        }

        public Criteria andTransmissionSpeedIsNotNull() {
            addCriterion("TRANSMISSION_SPEED is not null");
            return this;
        }

        public Criteria andTransmissionSpeedEqualTo(Long value) {
            addCriterion("TRANSMISSION_SPEED =", value, "transmissionSpeed");
            return this;
        }

        public Criteria andTransmissionSpeedNotEqualTo(Long value) {
            addCriterion("TRANSMISSION_SPEED <>", value, "transmissionSpeed");
            return this;
        }

        public Criteria andTransmissionSpeedGreaterThan(Long value) {
            addCriterion("TRANSMISSION_SPEED >", value, "transmissionSpeed");
            return this;
        }

        public Criteria andTransmissionSpeedGreaterThanOrEqualTo(Long value) {
            addCriterion("TRANSMISSION_SPEED >=", value, "transmissionSpeed");
            return this;
        }

        public Criteria andTransmissionSpeedLessThan(Long value) {
            addCriterion("TRANSMISSION_SPEED <", value, "transmissionSpeed");
            return this;
        }

        public Criteria andTransmissionSpeedLessThanOrEqualTo(Long value) {
            addCriterion("TRANSMISSION_SPEED <=", value, "transmissionSpeed");
            return this;
        }

        public Criteria andTransmissionSpeedIn(List values) {
            addCriterion("TRANSMISSION_SPEED in", values, "transmissionSpeed");
            return this;
        }

        public Criteria andTransmissionSpeedNotIn(List values) {
            addCriterion("TRANSMISSION_SPEED not in", values, "transmissionSpeed");
            return this;
        }

        public Criteria andTransmissionSpeedBetween(Long value1, Long value2) {
            addCriterion("TRANSMISSION_SPEED between", value1, value2, "transmissionSpeed");
            return this;
        }

        public Criteria andTransmissionSpeedNotBetween(Long value1, Long value2) {
            addCriterion("TRANSMISSION_SPEED not between", value1, value2, "transmissionSpeed");
            return this;
        }

        public Criteria andCaptionIsNull() {
            addCriterion("CAPTION is null");
            return this;
        }

        public Criteria andCaptionIsNotNull() {
            addCriterion("CAPTION is not null");
            return this;
        }

        public Criteria andCaptionEqualTo(String value) {
            addCriterion("CAPTION =", value, "caption");
            return this;
        }

        public Criteria andCaptionNotEqualTo(String value) {
            addCriterion("CAPTION <>", value, "caption");
            return this;
        }

        public Criteria andCaptionGreaterThan(String value) {
            addCriterion("CAPTION >", value, "caption");
            return this;
        }

        public Criteria andCaptionGreaterThanOrEqualTo(String value) {
            addCriterion("CAPTION >=", value, "caption");
            return this;
        }

        public Criteria andCaptionLessThan(String value) {
            addCriterion("CAPTION <", value, "caption");
            return this;
        }

        public Criteria andCaptionLessThanOrEqualTo(String value) {
            addCriterion("CAPTION <=", value, "caption");
            return this;
        }

        public Criteria andCaptionLike(String value) {
            addCriterion("CAPTION like", value, "caption");
            return this;
        }

        public Criteria andCaptionNotLike(String value) {
            addCriterion("CAPTION not like", value, "caption");
            return this;
        }

        public Criteria andCaptionIn(List values) {
            addCriterion("CAPTION in", values, "caption");
            return this;
        }

        public Criteria andCaptionNotIn(List values) {
            addCriterion("CAPTION not in", values, "caption");
            return this;
        }

        public Criteria andCaptionBetween(String value1, String value2) {
            addCriterion("CAPTION between", value1, value2, "caption");
            return this;
        }

        public Criteria andCaptionNotBetween(String value1, String value2) {
            addCriterion("CAPTION not between", value1, value2, "caption");
            return this;
        }

        public Criteria andCaptionLocationIsNull() {
            addCriterion("CAPTION_LOCATION is null");
            return this;
        }

        public Criteria andCaptionLocationIsNotNull() {
            addCriterion("CAPTION_LOCATION is not null");
            return this;
        }

        public Criteria andCaptionLocationEqualTo(Short value) {
            addCriterion("CAPTION_LOCATION =", value, "captionLocation");
            return this;
        }

        public Criteria andCaptionLocationNotEqualTo(Short value) {
            addCriterion("CAPTION_LOCATION <>", value, "captionLocation");
            return this;
        }

        public Criteria andCaptionLocationGreaterThan(Short value) {
            addCriterion("CAPTION_LOCATION >", value, "captionLocation");
            return this;
        }

        public Criteria andCaptionLocationGreaterThanOrEqualTo(Short value) {
            addCriterion("CAPTION_LOCATION >=", value, "captionLocation");
            return this;
        }

        public Criteria andCaptionLocationLessThan(Short value) {
            addCriterion("CAPTION_LOCATION <", value, "captionLocation");
            return this;
        }

        public Criteria andCaptionLocationLessThanOrEqualTo(Short value) {
            addCriterion("CAPTION_LOCATION <=", value, "captionLocation");
            return this;
        }

        public Criteria andCaptionLocationIn(List values) {
            addCriterion("CAPTION_LOCATION in", values, "captionLocation");
            return this;
        }

        public Criteria andCaptionLocationNotIn(List values) {
            addCriterion("CAPTION_LOCATION not in", values, "captionLocation");
            return this;
        }

        public Criteria andCaptionLocationBetween(Short value1, Short value2) {
            addCriterion("CAPTION_LOCATION between", value1, value2, "captionLocation");
            return this;
        }

        public Criteria andCaptionLocationNotBetween(Short value1, Short value2) {
            addCriterion("CAPTION_LOCATION not between", value1, value2, "captionLocation");
            return this;
        }

        public Criteria andTimeLocationIsNull() {
            addCriterion("TIME_LOCATION is null");
            return this;
        }

        public Criteria andTimeLocationIsNotNull() {
            addCriterion("TIME_LOCATION is not null");
            return this;
        }

        public Criteria andTimeLocationEqualTo(Short value) {
            addCriterion("TIME_LOCATION =", value, "timeLocation");
            return this;
        }

        public Criteria andTimeLocationNotEqualTo(Short value) {
            addCriterion("TIME_LOCATION <>", value, "timeLocation");
            return this;
        }

        public Criteria andTimeLocationGreaterThan(Short value) {
            addCriterion("TIME_LOCATION >", value, "timeLocation");
            return this;
        }

        public Criteria andTimeLocationGreaterThanOrEqualTo(Short value) {
            addCriterion("TIME_LOCATION >=", value, "timeLocation");
            return this;
        }

        public Criteria andTimeLocationLessThan(Short value) {
            addCriterion("TIME_LOCATION <", value, "timeLocation");
            return this;
        }

        public Criteria andTimeLocationLessThanOrEqualTo(Short value) {
            addCriterion("TIME_LOCATION <=", value, "timeLocation");
            return this;
        }

        public Criteria andTimeLocationIn(List values) {
            addCriterion("TIME_LOCATION in", values, "timeLocation");
            return this;
        }

        public Criteria andTimeLocationNotIn(List values) {
            addCriterion("TIME_LOCATION not in", values, "timeLocation");
            return this;
        }

        public Criteria andTimeLocationBetween(Short value1, Short value2) {
            addCriterion("TIME_LOCATION between", value1, value2, "timeLocation");
            return this;
        }

        public Criteria andTimeLocationNotBetween(Short value1, Short value2) {
            addCriterion("TIME_LOCATION not between", value1, value2, "timeLocation");
            return this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("DEVICE_TYPE is null");
            return this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("DEVICE_TYPE is not null");
            return this;
        }

        public Criteria andDeviceTypeEqualTo(String value) {
            addCriterion("DEVICE_TYPE =", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("DEVICE_TYPE <>", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeGreaterThan(String value) {
            addCriterion("DEVICE_TYPE >", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_TYPE >=", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeLessThan(String value) {
            addCriterion("DEVICE_TYPE <", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_TYPE <=", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeLike(String value) {
            addCriterion("DEVICE_TYPE like", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotLike(String value) {
            addCriterion("DEVICE_TYPE not like", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeIn(List values) {
            addCriterion("DEVICE_TYPE in", values, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotIn(List values) {
            addCriterion("DEVICE_TYPE not in", values, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("DEVICE_TYPE between", value1, value2, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("DEVICE_TYPE not between", value1, value2, "deviceType");
            return this;
        }
    }
}