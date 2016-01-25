package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoInputChannelExample {
    protected String orderByClause;

    protected List oredCriteria;

    public VideoInputChannelExample() {
        oredCriteria = new ArrayList();
    }

    protected VideoInputChannelExample(VideoInputChannelExample example) {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return this;
        }

        public Criteria andIdIn(List values) {
            addCriterion("ID in", values, "id");
            return this;
        }

        public Criteria andIdNotIn(List values) {
            addCriterion("ID not in", values, "id");
            return this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return this;
        }

        public Criteria andOptimisticLockIsNull() {
            addCriterion("OPTIMISTIC_LOCK is null");
            return this;
        }

        public Criteria andOptimisticLockIsNotNull() {
            addCriterion("OPTIMISTIC_LOCK is not null");
            return this;
        }

        public Criteria andOptimisticLockEqualTo(BigDecimal value) {
            addCriterion("OPTIMISTIC_LOCK =", value, "optimisticLock");
            return this;
        }

        public Criteria andOptimisticLockNotEqualTo(BigDecimal value) {
            addCriterion("OPTIMISTIC_LOCK <>", value, "optimisticLock");
            return this;
        }

        public Criteria andOptimisticLockGreaterThan(BigDecimal value) {
            addCriterion("OPTIMISTIC_LOCK >", value, "optimisticLock");
            return this;
        }

        public Criteria andOptimisticLockGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OPTIMISTIC_LOCK >=", value, "optimisticLock");
            return this;
        }

        public Criteria andOptimisticLockLessThan(BigDecimal value) {
            addCriterion("OPTIMISTIC_LOCK <", value, "optimisticLock");
            return this;
        }

        public Criteria andOptimisticLockLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OPTIMISTIC_LOCK <=", value, "optimisticLock");
            return this;
        }

        public Criteria andOptimisticLockIn(List values) {
            addCriterion("OPTIMISTIC_LOCK in", values, "optimisticLock");
            return this;
        }

        public Criteria andOptimisticLockNotIn(List values) {
            addCriterion("OPTIMISTIC_LOCK not in", values, "optimisticLock");
            return this;
        }

        public Criteria andOptimisticLockBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPTIMISTIC_LOCK between", value1, value2, "optimisticLock");
            return this;
        }

        public Criteria andOptimisticLockNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPTIMISTIC_LOCK not between", value1, value2, "optimisticLock");
            return this;
        }

        public Criteria andNameIsNull() {
            addCriterion("F_NAME is null");
            return this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("F_NAME is not null");
            return this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("F_NAME =", value, "name");
            return this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("F_NAME <>", value, "name");
            return this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("F_NAME >", value, "name");
            return this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("F_NAME >=", value, "name");
            return this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("F_NAME <", value, "name");
            return this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("F_NAME <=", value, "name");
            return this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("F_NAME like", value, "name");
            return this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("F_NAME not like", value, "name");
            return this;
        }

        public Criteria andNameIn(List values) {
            addCriterion("F_NAME in", values, "name");
            return this;
        }

        public Criteria andNameNotIn(List values) {
            addCriterion("F_NAME not in", values, "name");
            return this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("F_NAME between", value1, value2, "name");
            return this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("F_NAME not between", value1, value2, "name");
            return this;
        }

        public Criteria andNamingIsNull() {
            addCriterion("NAMING is null");
            return this;
        }

        public Criteria andNamingIsNotNull() {
            addCriterion("NAMING is not null");
            return this;
        }

        public Criteria andNamingEqualTo(String value) {
            addCriterion("NAMING =", value, "naming");
            return this;
        }

        public Criteria andNamingNotEqualTo(String value) {
            addCriterion("NAMING <>", value, "naming");
            return this;
        }

        public Criteria andNamingGreaterThan(String value) {
            addCriterion("NAMING >", value, "naming");
            return this;
        }

        public Criteria andNamingGreaterThanOrEqualTo(String value) {
            addCriterion("NAMING >=", value, "naming");
            return this;
        }

        public Criteria andNamingLessThan(String value) {
            addCriterion("NAMING <", value, "naming");
            return this;
        }

        public Criteria andNamingLessThanOrEqualTo(String value) {
            addCriterion("NAMING <=", value, "naming");
            return this;
        }

        public Criteria andNamingLike(String value) {
            addCriterion("NAMING like", value, "naming");
            return this;
        }

        public Criteria andNamingNotLike(String value) {
            addCriterion("NAMING not like", value, "naming");
            return this;
        }

        public Criteria andNamingIn(List values) {
            addCriterion("NAMING in", values, "naming");
            return this;
        }

        public Criteria andNamingNotIn(List values) {
            addCriterion("NAMING not in", values, "naming");
            return this;
        }

        public Criteria andNamingBetween(String value1, String value2) {
            addCriterion("NAMING between", value1, value2, "naming");
            return this;
        }

        public Criteria andNamingNotBetween(String value1, String value2) {
            addCriterion("NAMING not between", value1, value2, "naming");
            return this;
        }

        public Criteria andInstallLocationIsNull() {
            addCriterion("INSTALL_LOCATION is null");
            return this;
        }

        public Criteria andInstallLocationIsNotNull() {
            addCriterion("INSTALL_LOCATION is not null");
            return this;
        }

        public Criteria andInstallLocationEqualTo(String value) {
            addCriterion("INSTALL_LOCATION =", value, "installLocation");
            return this;
        }

        public Criteria andInstallLocationNotEqualTo(String value) {
            addCriterion("INSTALL_LOCATION <>", value, "installLocation");
            return this;
        }

        public Criteria andInstallLocationGreaterThan(String value) {
            addCriterion("INSTALL_LOCATION >", value, "installLocation");
            return this;
        }

        public Criteria andInstallLocationGreaterThanOrEqualTo(String value) {
            addCriterion("INSTALL_LOCATION >=", value, "installLocation");
            return this;
        }

        public Criteria andInstallLocationLessThan(String value) {
            addCriterion("INSTALL_LOCATION <", value, "installLocation");
            return this;
        }

        public Criteria andInstallLocationLessThanOrEqualTo(String value) {
            addCriterion("INSTALL_LOCATION <=", value, "installLocation");
            return this;
        }

        public Criteria andInstallLocationLike(String value) {
            addCriterion("INSTALL_LOCATION like", value, "installLocation");
            return this;
        }

        public Criteria andInstallLocationNotLike(String value) {
            addCriterion("INSTALL_LOCATION not like", value, "installLocation");
            return this;
        }

        public Criteria andInstallLocationIn(List values) {
            addCriterion("INSTALL_LOCATION in", values, "installLocation");
            return this;
        }

        public Criteria andInstallLocationNotIn(List values) {
            addCriterion("INSTALL_LOCATION not in", values, "installLocation");
            return this;
        }

        public Criteria andInstallLocationBetween(String value1, String value2) {
            addCriterion("INSTALL_LOCATION between", value1, value2, "installLocation");
            return this;
        }

        public Criteria andInstallLocationNotBetween(String value1, String value2) {
            addCriterion("INSTALL_LOCATION not between", value1, value2, "installLocation");
            return this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("NOTE is null");
            return this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("NOTE is not null");
            return this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("NOTE =", value, "note");
            return this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("NOTE <>", value, "note");
            return this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("NOTE >", value, "note");
            return this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("NOTE >=", value, "note");
            return this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("NOTE <", value, "note");
            return this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("NOTE <=", value, "note");
            return this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("NOTE like", value, "note");
            return this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("NOTE not like", value, "note");
            return this;
        }

        public Criteria andNoteIn(List values) {
            addCriterion("NOTE in", values, "note");
            return this;
        }

        public Criteria andNoteNotIn(List values) {
            addCriterion("NOTE not in", values, "note");
            return this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("NOTE between", value1, value2, "note");
            return this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("NOTE not between", value1, value2, "note");
            return this;
        }

        public Criteria andHasPanIsNull() {
            addCriterion("HAS_PAN is null");
            return this;
        }

        public Criteria andHasPanIsNotNull() {
            addCriterion("HAS_PAN is not null");
            return this;
        }

        public Criteria andHasPanEqualTo(Short value) {
            addCriterion("HAS_PAN =", value, "hasPan");
            return this;
        }

        public Criteria andHasPanNotEqualTo(Short value) {
            addCriterion("HAS_PAN <>", value, "hasPan");
            return this;
        }

        public Criteria andHasPanGreaterThan(Short value) {
            addCriterion("HAS_PAN >", value, "hasPan");
            return this;
        }

        public Criteria andHasPanGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_PAN >=", value, "hasPan");
            return this;
        }

        public Criteria andHasPanLessThan(Short value) {
            addCriterion("HAS_PAN <", value, "hasPan");
            return this;
        }

        public Criteria andHasPanLessThanOrEqualTo(Short value) {
            addCriterion("HAS_PAN <=", value, "hasPan");
            return this;
        }

        public Criteria andHasPanIn(List values) {
            addCriterion("HAS_PAN in", values, "hasPan");
            return this;
        }

        public Criteria andHasPanNotIn(List values) {
            addCriterion("HAS_PAN not in", values, "hasPan");
            return this;
        }

        public Criteria andHasPanBetween(Short value1, Short value2) {
            addCriterion("HAS_PAN between", value1, value2, "hasPan");
            return this;
        }

        public Criteria andHasPanNotBetween(Short value1, Short value2) {
            addCriterion("HAS_PAN not between", value1, value2, "hasPan");
            return this;
        }

        public Criteria andPtzDecodeTypeIsNull() {
            addCriterion("PTZ_DECODE_TYPE is null");
            return this;
        }

        public Criteria andPtzDecodeTypeIsNotNull() {
            addCriterion("PTZ_DECODE_TYPE is not null");
            return this;
        }

        public Criteria andPtzDecodeTypeEqualTo(String value) {
            addCriterion("PTZ_DECODE_TYPE =", value, "ptzDecodeType");
            return this;
        }

        public Criteria andPtzDecodeTypeNotEqualTo(String value) {
            addCriterion("PTZ_DECODE_TYPE <>", value, "ptzDecodeType");
            return this;
        }

        public Criteria andPtzDecodeTypeGreaterThan(String value) {
            addCriterion("PTZ_DECODE_TYPE >", value, "ptzDecodeType");
            return this;
        }

        public Criteria andPtzDecodeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PTZ_DECODE_TYPE >=", value, "ptzDecodeType");
            return this;
        }

        public Criteria andPtzDecodeTypeLessThan(String value) {
            addCriterion("PTZ_DECODE_TYPE <", value, "ptzDecodeType");
            return this;
        }

        public Criteria andPtzDecodeTypeLessThanOrEqualTo(String value) {
            addCriterion("PTZ_DECODE_TYPE <=", value, "ptzDecodeType");
            return this;
        }

        public Criteria andPtzDecodeTypeLike(String value) {
            addCriterion("PTZ_DECODE_TYPE like", value, "ptzDecodeType");
            return this;
        }

        public Criteria andPtzDecodeTypeNotLike(String value) {
            addCriterion("PTZ_DECODE_TYPE not like", value, "ptzDecodeType");
            return this;
        }

        public Criteria andPtzDecodeTypeIn(List values) {
            addCriterion("PTZ_DECODE_TYPE in", values, "ptzDecodeType");
            return this;
        }

        public Criteria andPtzDecodeTypeNotIn(List values) {
            addCriterion("PTZ_DECODE_TYPE not in", values, "ptzDecodeType");
            return this;
        }

        public Criteria andPtzDecodeTypeBetween(String value1, String value2) {
            addCriterion("PTZ_DECODE_TYPE between", value1, value2, "ptzDecodeType");
            return this;
        }

        public Criteria andPtzDecodeTypeNotBetween(String value1, String value2) {
            addCriterion("PTZ_DECODE_TYPE not between", value1, value2, "ptzDecodeType");
            return this;
        }

        public Criteria andVideoFormatIsNull() {
            addCriterion("VIDEO_FORMAT is null");
            return this;
        }

        public Criteria andVideoFormatIsNotNull() {
            addCriterion("VIDEO_FORMAT is not null");
            return this;
        }

        public Criteria andVideoFormatEqualTo(String value) {
            addCriterion("VIDEO_FORMAT =", value, "videoFormat");
            return this;
        }

        public Criteria andVideoFormatNotEqualTo(String value) {
            addCriterion("VIDEO_FORMAT <>", value, "videoFormat");
            return this;
        }

        public Criteria andVideoFormatGreaterThan(String value) {
            addCriterion("VIDEO_FORMAT >", value, "videoFormat");
            return this;
        }

        public Criteria andVideoFormatGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_FORMAT >=", value, "videoFormat");
            return this;
        }

        public Criteria andVideoFormatLessThan(String value) {
            addCriterion("VIDEO_FORMAT <", value, "videoFormat");
            return this;
        }

        public Criteria andVideoFormatLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_FORMAT <=", value, "videoFormat");
            return this;
        }

        public Criteria andVideoFormatLike(String value) {
            addCriterion("VIDEO_FORMAT like", value, "videoFormat");
            return this;
        }

        public Criteria andVideoFormatNotLike(String value) {
            addCriterion("VIDEO_FORMAT not like", value, "videoFormat");
            return this;
        }

        public Criteria andVideoFormatIn(List values) {
            addCriterion("VIDEO_FORMAT in", values, "videoFormat");
            return this;
        }

        public Criteria andVideoFormatNotIn(List values) {
            addCriterion("VIDEO_FORMAT not in", values, "videoFormat");
            return this;
        }

        public Criteria andVideoFormatBetween(String value1, String value2) {
            addCriterion("VIDEO_FORMAT between", value1, value2, "videoFormat");
            return this;
        }

        public Criteria andVideoFormatNotBetween(String value1, String value2) {
            addCriterion("VIDEO_FORMAT not between", value1, value2, "videoFormat");
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

        public Criteria andStorePlanHourFlagIsNull() {
            addCriterion("STORE_PLAN_HOUR_FLAG is null");
            return this;
        }

        public Criteria andStorePlanHourFlagIsNotNull() {
            addCriterion("STORE_PLAN_HOUR_FLAG is not null");
            return this;
        }

        public Criteria andStorePlanHourFlagEqualTo(String value) {
            addCriterion("STORE_PLAN_HOUR_FLAG =", value, "storePlanHourFlag");
            return this;
        }

        public Criteria andStorePlanHourFlagNotEqualTo(String value) {
            addCriterion("STORE_PLAN_HOUR_FLAG <>", value, "storePlanHourFlag");
            return this;
        }

        public Criteria andStorePlanHourFlagGreaterThan(String value) {
            addCriterion("STORE_PLAN_HOUR_FLAG >", value, "storePlanHourFlag");
            return this;
        }

        public Criteria andStorePlanHourFlagGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_PLAN_HOUR_FLAG >=", value, "storePlanHourFlag");
            return this;
        }

        public Criteria andStorePlanHourFlagLessThan(String value) {
            addCriterion("STORE_PLAN_HOUR_FLAG <", value, "storePlanHourFlag");
            return this;
        }

        public Criteria andStorePlanHourFlagLessThanOrEqualTo(String value) {
            addCriterion("STORE_PLAN_HOUR_FLAG <=", value, "storePlanHourFlag");
            return this;
        }

        public Criteria andStorePlanHourFlagLike(String value) {
            addCriterion("STORE_PLAN_HOUR_FLAG like", value, "storePlanHourFlag");
            return this;
        }

        public Criteria andStorePlanHourFlagNotLike(String value) {
            addCriterion("STORE_PLAN_HOUR_FLAG not like", value, "storePlanHourFlag");
            return this;
        }

        public Criteria andStorePlanHourFlagIn(List values) {
            addCriterion("STORE_PLAN_HOUR_FLAG in", values, "storePlanHourFlag");
            return this;
        }

        public Criteria andStorePlanHourFlagNotIn(List values) {
            addCriterion("STORE_PLAN_HOUR_FLAG not in", values, "storePlanHourFlag");
            return this;
        }

        public Criteria andStorePlanHourFlagBetween(String value1, String value2) {
            addCriterion("STORE_PLAN_HOUR_FLAG between", value1, value2, "storePlanHourFlag");
            return this;
        }

        public Criteria andStorePlanHourFlagNotBetween(String value1, String value2) {
            addCriterion("STORE_PLAN_HOUR_FLAG not between", value1, value2, "storePlanHourFlag");
            return this;
        }

        public Criteria andFrameRateIsNull() {
            addCriterion("FRAME_RATE is null");
            return this;
        }

        public Criteria andFrameRateIsNotNull() {
            addCriterion("FRAME_RATE is not null");
            return this;
        }

        public Criteria andFrameRateEqualTo(Long value) {
            addCriterion("FRAME_RATE =", value, "frameRate");
            return this;
        }

        public Criteria andFrameRateNotEqualTo(Long value) {
            addCriterion("FRAME_RATE <>", value, "frameRate");
            return this;
        }

        public Criteria andFrameRateGreaterThan(Long value) {
            addCriterion("FRAME_RATE >", value, "frameRate");
            return this;
        }

        public Criteria andFrameRateGreaterThanOrEqualTo(Long value) {
            addCriterion("FRAME_RATE >=", value, "frameRate");
            return this;
        }

        public Criteria andFrameRateLessThan(Long value) {
            addCriterion("FRAME_RATE <", value, "frameRate");
            return this;
        }

        public Criteria andFrameRateLessThanOrEqualTo(Long value) {
            addCriterion("FRAME_RATE <=", value, "frameRate");
            return this;
        }

        public Criteria andFrameRateIn(List values) {
            addCriterion("FRAME_RATE in", values, "frameRate");
            return this;
        }

        public Criteria andFrameRateNotIn(List values) {
            addCriterion("FRAME_RATE not in", values, "frameRate");
            return this;
        }

        public Criteria andFrameRateBetween(Long value1, Long value2) {
            addCriterion("FRAME_RATE between", value1, value2, "frameRate");
            return this;
        }

        public Criteria andFrameRateNotBetween(Long value1, Long value2) {
            addCriterion("FRAME_RATE not between", value1, value2, "frameRate");
            return this;
        }

        public Criteria andMaxBpsIsNull() {
            addCriterion("MAX_BPS is null");
            return this;
        }

        public Criteria andMaxBpsIsNotNull() {
            addCriterion("MAX_BPS is not null");
            return this;
        }

        public Criteria andMaxBpsEqualTo(Long value) {
            addCriterion("MAX_BPS =", value, "maxBps");
            return this;
        }

        public Criteria andMaxBpsNotEqualTo(Long value) {
            addCriterion("MAX_BPS <>", value, "maxBps");
            return this;
        }

        public Criteria andMaxBpsGreaterThan(Long value) {
            addCriterion("MAX_BPS >", value, "maxBps");
            return this;
        }

        public Criteria andMaxBpsGreaterThanOrEqualTo(Long value) {
            addCriterion("MAX_BPS >=", value, "maxBps");
            return this;
        }

        public Criteria andMaxBpsLessThan(Long value) {
            addCriterion("MAX_BPS <", value, "maxBps");
            return this;
        }

        public Criteria andMaxBpsLessThanOrEqualTo(Long value) {
            addCriterion("MAX_BPS <=", value, "maxBps");
            return this;
        }

        public Criteria andMaxBpsIn(List values) {
            addCriterion("MAX_BPS in", values, "maxBps");
            return this;
        }

        public Criteria andMaxBpsNotIn(List values) {
            addCriterion("MAX_BPS not in", values, "maxBps");
            return this;
        }

        public Criteria andMaxBpsBetween(Long value1, Long value2) {
            addCriterion("MAX_BPS between", value1, value2, "maxBps");
            return this;
        }

        public Criteria andMaxBpsNotBetween(Long value1, Long value2) {
            addCriterion("MAX_BPS not between", value1, value2, "maxBps");
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

        public Criteria andVideoInputChannelModelIdIsNull() {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID is null");
            return this;
        }

        public Criteria andVideoInputChannelModelIdIsNotNull() {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID is not null");
            return this;
        }

        public Criteria andVideoInputChannelModelIdEqualTo(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID =", value, "videoInputChannelModelId");
            return this;
        }

        public Criteria andVideoInputChannelModelIdNotEqualTo(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID <>", value, "videoInputChannelModelId");
            return this;
        }

        public Criteria andVideoInputChannelModelIdGreaterThan(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID >", value, "videoInputChannelModelId");
            return this;
        }

        public Criteria andVideoInputChannelModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID >=", value, "videoInputChannelModelId");
            return this;
        }

        public Criteria andVideoInputChannelModelIdLessThan(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID <", value, "videoInputChannelModelId");
            return this;
        }

        public Criteria andVideoInputChannelModelIdLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID <=", value, "videoInputChannelModelId");
            return this;
        }

        public Criteria andVideoInputChannelModelIdLike(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID like", value, "videoInputChannelModelId");
            return this;
        }

        public Criteria andVideoInputChannelModelIdNotLike(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID not like", value, "videoInputChannelModelId");
            return this;
        }

        public Criteria andVideoInputChannelModelIdIn(List values) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID in", values, "videoInputChannelModelId");
            return this;
        }

        public Criteria andVideoInputChannelModelIdNotIn(List values) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID not in", values, "videoInputChannelModelId");
            return this;
        }

        public Criteria andVideoInputChannelModelIdBetween(String value1, String value2) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID between", value1, value2, "videoInputChannelModelId");
            return this;
        }

        public Criteria andVideoInputChannelModelIdNotBetween(String value1, String value2) {
            addCriterion("VIDEO_INPUT_CHANNEL_MODEL_ID not between", value1, value2, "videoInputChannelModelId");
            return this;
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

        public Criteria andImageQualityLevelIdIsNull() {
            addCriterion("IMAGE_QUALITY_LEVEL_ID is null");
            return this;
        }

        public Criteria andImageQualityLevelIdIsNotNull() {
            addCriterion("IMAGE_QUALITY_LEVEL_ID is not null");
            return this;
        }

        public Criteria andImageQualityLevelIdEqualTo(String value) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID =", value, "imageQualityLevelId");
            return this;
        }

        public Criteria andImageQualityLevelIdNotEqualTo(String value) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID <>", value, "imageQualityLevelId");
            return this;
        }

        public Criteria andImageQualityLevelIdGreaterThan(String value) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID >", value, "imageQualityLevelId");
            return this;
        }

        public Criteria andImageQualityLevelIdGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID >=", value, "imageQualityLevelId");
            return this;
        }

        public Criteria andImageQualityLevelIdLessThan(String value) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID <", value, "imageQualityLevelId");
            return this;
        }

        public Criteria andImageQualityLevelIdLessThanOrEqualTo(String value) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID <=", value, "imageQualityLevelId");
            return this;
        }

        public Criteria andImageQualityLevelIdLike(String value) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID like", value, "imageQualityLevelId");
            return this;
        }

        public Criteria andImageQualityLevelIdNotLike(String value) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID not like", value, "imageQualityLevelId");
            return this;
        }

        public Criteria andImageQualityLevelIdIn(List values) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID in", values, "imageQualityLevelId");
            return this;
        }

        public Criteria andImageQualityLevelIdNotIn(List values) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID not in", values, "imageQualityLevelId");
            return this;
        }

        public Criteria andImageQualityLevelIdBetween(String value1, String value2) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID between", value1, value2, "imageQualityLevelId");
            return this;
        }

        public Criteria andImageQualityLevelIdNotBetween(String value1, String value2) {
            addCriterion("IMAGE_QUALITY_LEVEL_ID not between", value1, value2, "imageQualityLevelId");
            return this;
        }

        public Criteria andDispatchServerIdIsNull() {
            addCriterion("DISPATCH_SERVER_ID is null");
            return this;
        }

        public Criteria andDispatchServerIdIsNotNull() {
            addCriterion("DISPATCH_SERVER_ID is not null");
            return this;
        }

        public Criteria andDispatchServerIdEqualTo(String value) {
            addCriterion("DISPATCH_SERVER_ID =", value, "dispatchServerId");
            return this;
        }

        public Criteria andDispatchServerIdNotEqualTo(String value) {
            addCriterion("DISPATCH_SERVER_ID <>", value, "dispatchServerId");
            return this;
        }

        public Criteria andDispatchServerIdGreaterThan(String value) {
            addCriterion("DISPATCH_SERVER_ID >", value, "dispatchServerId");
            return this;
        }

        public Criteria andDispatchServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("DISPATCH_SERVER_ID >=", value, "dispatchServerId");
            return this;
        }

        public Criteria andDispatchServerIdLessThan(String value) {
            addCriterion("DISPATCH_SERVER_ID <", value, "dispatchServerId");
            return this;
        }

        public Criteria andDispatchServerIdLessThanOrEqualTo(String value) {
            addCriterion("DISPATCH_SERVER_ID <=", value, "dispatchServerId");
            return this;
        }

        public Criteria andDispatchServerIdLike(String value) {
            addCriterion("DISPATCH_SERVER_ID like", value, "dispatchServerId");
            return this;
        }

        public Criteria andDispatchServerIdNotLike(String value) {
            addCriterion("DISPATCH_SERVER_ID not like", value, "dispatchServerId");
            return this;
        }

        public Criteria andDispatchServerIdIn(List values) {
            addCriterion("DISPATCH_SERVER_ID in", values, "dispatchServerId");
            return this;
        }

        public Criteria andDispatchServerIdNotIn(List values) {
            addCriterion("DISPATCH_SERVER_ID not in", values, "dispatchServerId");
            return this;
        }

        public Criteria andDispatchServerIdBetween(String value1, String value2) {
            addCriterion("DISPATCH_SERVER_ID between", value1, value2, "dispatchServerId");
            return this;
        }

        public Criteria andDispatchServerIdNotBetween(String value1, String value2) {
            addCriterion("DISPATCH_SERVER_ID not between", value1, value2, "dispatchServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdIsNull() {
            addCriterion("REMOTE_STORAGE_SERVER_ID is null");
            return this;
        }

        public Criteria andRemoteStorageServerIdIsNotNull() {
            addCriterion("REMOTE_STORAGE_SERVER_ID is not null");
            return this;
        }

        public Criteria andRemoteStorageServerIdEqualTo(String value) {
            addCriterion("REMOTE_STORAGE_SERVER_ID =", value, "remoteStorageServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdNotEqualTo(String value) {
            addCriterion("REMOTE_STORAGE_SERVER_ID <>", value, "remoteStorageServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdGreaterThan(String value) {
            addCriterion("REMOTE_STORAGE_SERVER_ID >", value, "remoteStorageServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("REMOTE_STORAGE_SERVER_ID >=", value, "remoteStorageServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdLessThan(String value) {
            addCriterion("REMOTE_STORAGE_SERVER_ID <", value, "remoteStorageServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdLessThanOrEqualTo(String value) {
            addCriterion("REMOTE_STORAGE_SERVER_ID <=", value, "remoteStorageServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdLike(String value) {
            addCriterion("REMOTE_STORAGE_SERVER_ID like", value, "remoteStorageServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdNotLike(String value) {
            addCriterion("REMOTE_STORAGE_SERVER_ID not like", value, "remoteStorageServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdIn(List values) {
            addCriterion("REMOTE_STORAGE_SERVER_ID in", values, "remoteStorageServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdNotIn(List values) {
            addCriterion("REMOTE_STORAGE_SERVER_ID not in", values, "remoteStorageServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdBetween(String value1, String value2) {
            addCriterion("REMOTE_STORAGE_SERVER_ID between", value1, value2, "remoteStorageServerId");
            return this;
        }

        public Criteria andRemoteStorageServerIdNotBetween(String value1, String value2) {
            addCriterion("REMOTE_STORAGE_SERVER_ID not between", value1, value2, "remoteStorageServerId");
            return this;
        }

        public Criteria andOrganIdIsNull() {
            addCriterion("ORGAN_ID is null");
            return this;
        }

        public Criteria andOrganIdIsNotNull() {
            addCriterion("ORGAN_ID is not null");
            return this;
        }

        public Criteria andOrganIdEqualTo(String value) {
            addCriterion("ORGAN_ID =", value, "organId");
            return this;
        }

        public Criteria andOrganIdNotEqualTo(String value) {
            addCriterion("ORGAN_ID <>", value, "organId");
            return this;
        }

        public Criteria andOrganIdGreaterThan(String value) {
            addCriterion("ORGAN_ID >", value, "organId");
            return this;
        }

        public Criteria andOrganIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORGAN_ID >=", value, "organId");
            return this;
        }

        public Criteria andOrganIdLessThan(String value) {
            addCriterion("ORGAN_ID <", value, "organId");
            return this;
        }

        public Criteria andOrganIdLessThanOrEqualTo(String value) {
            addCriterion("ORGAN_ID <=", value, "organId");
            return this;
        }

        public Criteria andOrganIdLike(String value) {
            addCriterion("ORGAN_ID like", value, "organId");
            return this;
        }

        public Criteria andOrganIdNotLike(String value) {
            addCriterion("ORGAN_ID not like", value, "organId");
            return this;
        }

        public Criteria andOrganIdIn(List values) {
            addCriterion("ORGAN_ID in", values, "organId");
            return this;
        }

        public Criteria andOrganIdNotIn(List values) {
            addCriterion("ORGAN_ID not in", values, "organId");
            return this;
        }

        public Criteria andOrganIdBetween(String value1, String value2) {
            addCriterion("ORGAN_ID between", value1, value2, "organId");
            return this;
        }

        public Criteria andOrganIdNotBetween(String value1, String value2) {
            addCriterion("ORGAN_ID not between", value1, value2, "organId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdIsNull() {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID is null");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdIsNotNull() {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID is not null");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdEqualTo(String value) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID =", value, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdNotEqualTo(String value) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID <>", value, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdGreaterThan(String value) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID >", value, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID >=", value, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdLessThan(String value) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID <", value, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID <=", value, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdLike(String value) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID like", value, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdNotLike(String value) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID not like", value, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdIn(List values) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID in", values, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdNotIn(List values) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID not in", values, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdBetween(String value1, String value2) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID between", value1, value2, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andDevicePhysicalRelationIdNotBetween(String value1, String value2) {
            addCriterion("DEVICE_PHYSICAL_RELATION_ID not between", value1, value2, "devicePhysicalRelationId");
            return this;
        }

        public Criteria andIsSuspendedIsNull() {
            addCriterion("IS_SUSPENDED is null");
            return this;
        }

        public Criteria andIsSuspendedIsNotNull() {
            addCriterion("IS_SUSPENDED is not null");
            return this;
        }

        public Criteria andIsSuspendedEqualTo(Short value) {
            addCriterion("IS_SUSPENDED =", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedNotEqualTo(Short value) {
            addCriterion("IS_SUSPENDED <>", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedGreaterThan(Short value) {
            addCriterion("IS_SUSPENDED >", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_SUSPENDED >=", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedLessThan(Short value) {
            addCriterion("IS_SUSPENDED <", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedLessThanOrEqualTo(Short value) {
            addCriterion("IS_SUSPENDED <=", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedIn(List values) {
            addCriterion("IS_SUSPENDED in", values, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedNotIn(List values) {
            addCriterion("IS_SUSPENDED not in", values, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedBetween(Short value1, Short value2) {
            addCriterion("IS_SUSPENDED between", value1, value2, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedNotBetween(Short value1, Short value2) {
            addCriterion("IS_SUSPENDED not between", value1, value2, "isSuspended");
            return this;
        }

        public Criteria andStdIdIsNull() {
            addCriterion("STD_ID is null");
            return this;
        }

        public Criteria andStdIdIsNotNull() {
            addCriterion("STD_ID is not null");
            return this;
        }

        public Criteria andStdIdEqualTo(String value) {
            addCriterion("STD_ID =", value, "stdId");
            return this;
        }

        public Criteria andStdIdNotEqualTo(String value) {
            addCriterion("STD_ID <>", value, "stdId");
            return this;
        }

        public Criteria andStdIdGreaterThan(String value) {
            addCriterion("STD_ID >", value, "stdId");
            return this;
        }

        public Criteria andStdIdGreaterThanOrEqualTo(String value) {
            addCriterion("STD_ID >=", value, "stdId");
            return this;
        }

        public Criteria andStdIdLessThan(String value) {
            addCriterion("STD_ID <", value, "stdId");
            return this;
        }

        public Criteria andStdIdLessThanOrEqualTo(String value) {
            addCriterion("STD_ID <=", value, "stdId");
            return this;
        }

        public Criteria andStdIdLike(String value) {
            addCriterion("STD_ID like", value, "stdId");
            return this;
        }

        public Criteria andStdIdNotLike(String value) {
            addCriterion("STD_ID not like", value, "stdId");
            return this;
        }

        public Criteria andStdIdIn(List values) {
            addCriterion("STD_ID in", values, "stdId");
            return this;
        }

        public Criteria andStdIdNotIn(List values) {
            addCriterion("STD_ID not in", values, "stdId");
            return this;
        }

        public Criteria andStdIdBetween(String value1, String value2) {
            addCriterion("STD_ID between", value1, value2, "stdId");
            return this;
        }

        public Criteria andStdIdNotBetween(String value1, String value2) {
            addCriterion("STD_ID not between", value1, value2, "stdId");
            return this;
        }

        public Criteria andIsSupportSchemeIsNull() {
            addCriterion("IS_SUPPORT_SCHEME is null");
            return this;
        }

        public Criteria andIsSupportSchemeIsNotNull() {
            addCriterion("IS_SUPPORT_SCHEME is not null");
            return this;
        }

        public Criteria andIsSupportSchemeEqualTo(Short value) {
            addCriterion("IS_SUPPORT_SCHEME =", value, "isSupportScheme");
            return this;
        }

        public Criteria andIsSupportSchemeNotEqualTo(Short value) {
            addCriterion("IS_SUPPORT_SCHEME <>", value, "isSupportScheme");
            return this;
        }

        public Criteria andIsSupportSchemeGreaterThan(Short value) {
            addCriterion("IS_SUPPORT_SCHEME >", value, "isSupportScheme");
            return this;
        }

        public Criteria andIsSupportSchemeGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_SUPPORT_SCHEME >=", value, "isSupportScheme");
            return this;
        }

        public Criteria andIsSupportSchemeLessThan(Short value) {
            addCriterion("IS_SUPPORT_SCHEME <", value, "isSupportScheme");
            return this;
        }

        public Criteria andIsSupportSchemeLessThanOrEqualTo(Short value) {
            addCriterion("IS_SUPPORT_SCHEME <=", value, "isSupportScheme");
            return this;
        }

        public Criteria andIsSupportSchemeIn(List values) {
            addCriterion("IS_SUPPORT_SCHEME in", values, "isSupportScheme");
            return this;
        }

        public Criteria andIsSupportSchemeNotIn(List values) {
            addCriterion("IS_SUPPORT_SCHEME not in", values, "isSupportScheme");
            return this;
        }

        public Criteria andIsSupportSchemeBetween(Short value1, Short value2) {
            addCriterion("IS_SUPPORT_SCHEME between", value1, value2, "isSupportScheme");
            return this;
        }

        public Criteria andIsSupportSchemeNotBetween(Short value1, Short value2) {
            addCriterion("IS_SUPPORT_SCHEME not between", value1, value2, "isSupportScheme");
            return this;
        }

        public Criteria andPreRecordTimeIsNull() {
            addCriterion("PRE_RECORD_TIME is null");
            return this;
        }

        public Criteria andPreRecordTimeIsNotNull() {
            addCriterion("PRE_RECORD_TIME is not null");
            return this;
        }

        public Criteria andPreRecordTimeEqualTo(Short value) {
            addCriterion("PRE_RECORD_TIME =", value, "preRecordTime");
            return this;
        }

        public Criteria andPreRecordTimeNotEqualTo(Short value) {
            addCriterion("PRE_RECORD_TIME <>", value, "preRecordTime");
            return this;
        }

        public Criteria andPreRecordTimeGreaterThan(Short value) {
            addCriterion("PRE_RECORD_TIME >", value, "preRecordTime");
            return this;
        }

        public Criteria andPreRecordTimeGreaterThanOrEqualTo(Short value) {
            addCriterion("PRE_RECORD_TIME >=", value, "preRecordTime");
            return this;
        }

        public Criteria andPreRecordTimeLessThan(Short value) {
            addCriterion("PRE_RECORD_TIME <", value, "preRecordTime");
            return this;
        }

        public Criteria andPreRecordTimeLessThanOrEqualTo(Short value) {
            addCriterion("PRE_RECORD_TIME <=", value, "preRecordTime");
            return this;
        }

        public Criteria andPreRecordTimeIn(List values) {
            addCriterion("PRE_RECORD_TIME in", values, "preRecordTime");
            return this;
        }

        public Criteria andPreRecordTimeNotIn(List values) {
            addCriterion("PRE_RECORD_TIME not in", values, "preRecordTime");
            return this;
        }

        public Criteria andPreRecordTimeBetween(Short value1, Short value2) {
            addCriterion("PRE_RECORD_TIME between", value1, value2, "preRecordTime");
            return this;
        }

        public Criteria andPreRecordTimeNotBetween(Short value1, Short value2) {
            addCriterion("PRE_RECORD_TIME not between", value1, value2, "preRecordTime");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagIsNull() {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG is null");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagIsNotNull() {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG is not null");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagEqualTo(String value) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG =", value, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagNotEqualTo(String value) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG <>", value, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagGreaterThan(String value) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG >", value, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagGreaterThanOrEqualTo(String value) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG >=", value, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagLessThan(String value) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG <", value, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagLessThanOrEqualTo(String value) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG <=", value, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagLike(String value) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG like", value, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagNotLike(String value) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG not like", value, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagIn(List values) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG in", values, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagNotIn(List values) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG not in", values, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagBetween(String value1, String value2) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG between", value1, value2, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andRemoteStorePlanHourFlagNotBetween(String value1, String value2) {
            addCriterion("REMOTE_STORE_PLAN_HOUR_FLAG not between", value1, value2, "remoteStorePlanHourFlag");
            return this;
        }

        public Criteria andStoreTypeIsNull() {
            addCriterion("STORE_TYPE is null");
            return this;
        }

        public Criteria andStoreTypeIsNotNull() {
            addCriterion("STORE_TYPE is not null");
            return this;
        }

        public Criteria andStoreTypeEqualTo(Short value) {
            addCriterion("STORE_TYPE =", value, "storeType");
            return this;
        }

        public Criteria andStoreTypeNotEqualTo(Short value) {
            addCriterion("STORE_TYPE <>", value, "storeType");
            return this;
        }

        public Criteria andStoreTypeGreaterThan(Short value) {
            addCriterion("STORE_TYPE >", value, "storeType");
            return this;
        }

        public Criteria andStoreTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("STORE_TYPE >=", value, "storeType");
            return this;
        }

        public Criteria andStoreTypeLessThan(Short value) {
            addCriterion("STORE_TYPE <", value, "storeType");
            return this;
        }

        public Criteria andStoreTypeLessThanOrEqualTo(Short value) {
            addCriterion("STORE_TYPE <=", value, "storeType");
            return this;
        }

        public Criteria andStoreTypeIn(List values) {
            addCriterion("STORE_TYPE in", values, "storeType");
            return this;
        }

        public Criteria andStoreTypeNotIn(List values) {
            addCriterion("STORE_TYPE not in", values, "storeType");
            return this;
        }

        public Criteria andStoreTypeBetween(Short value1, Short value2) {
            addCriterion("STORE_TYPE between", value1, value2, "storeType");
            return this;
        }

        public Criteria andStoreTypeNotBetween(Short value1, Short value2) {
            addCriterion("STORE_TYPE not between", value1, value2, "storeType");
            return this;
        }

        public Criteria andPathIsNull() {
            addCriterion("PATH is null");
            return this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("PATH is not null");
            return this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("PATH =", value, "path");
            return this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("PATH <>", value, "path");
            return this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("PATH >", value, "path");
            return this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("PATH >=", value, "path");
            return this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("PATH <", value, "path");
            return this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("PATH <=", value, "path");
            return this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("PATH like", value, "path");
            return this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("PATH not like", value, "path");
            return this;
        }

        public Criteria andPathIn(List values) {
            addCriterion("PATH in", values, "path");
            return this;
        }

        public Criteria andPathNotIn(List values) {
            addCriterion("PATH not in", values, "path");
            return this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("PATH between", value1, value2, "path");
            return this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("PATH not between", value1, value2, "path");
            return this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("LONGITUDE like", value, "longitude");
            return this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("LONGITUDE not like", value, "longitude");
            return this;
        }

        public Criteria andLongitudeIn(List values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return this;
        }

        public Criteria andLongitudeNotIn(List values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("LATITUDE =", value, "latitude");
            return this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("LATITUDE >", value, "latitude");
            return this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("LATITUDE <", value, "latitude");
            return this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("LATITUDE like", value, "latitude");
            return this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("LATITUDE not like", value, "latitude");
            return this;
        }

        public Criteria andLatitudeIn(List values) {
            addCriterion("LATITUDE in", values, "latitude");
            return this;
        }

        public Criteria andLatitudeNotIn(List values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return this;
        }

        public Criteria andPullModeIsNull() {
            addCriterion("PULL_MODE is null");
            return this;
        }

        public Criteria andPullModeIsNotNull() {
            addCriterion("PULL_MODE is not null");
            return this;
        }

        public Criteria andPullModeEqualTo(BigDecimal value) {
            addCriterion("PULL_MODE =", value, "pullMode");
            return this;
        }

        public Criteria andPullModeNotEqualTo(BigDecimal value) {
            addCriterion("PULL_MODE <>", value, "pullMode");
            return this;
        }

        public Criteria andPullModeGreaterThan(BigDecimal value) {
            addCriterion("PULL_MODE >", value, "pullMode");
            return this;
        }

        public Criteria andPullModeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PULL_MODE >=", value, "pullMode");
            return this;
        }

        public Criteria andPullModeLessThan(BigDecimal value) {
            addCriterion("PULL_MODE <", value, "pullMode");
            return this;
        }

        public Criteria andPullModeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PULL_MODE <=", value, "pullMode");
            return this;
        }

        public Criteria andPullModeIn(List values) {
            addCriterion("PULL_MODE in", values, "pullMode");
            return this;
        }

        public Criteria andPullModeNotIn(List values) {
            addCriterion("PULL_MODE not in", values, "pullMode");
            return this;
        }

        public Criteria andPullModeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PULL_MODE between", value1, value2, "pullMode");
            return this;
        }

        public Criteria andPullModeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PULL_MODE not between", value1, value2, "pullMode");
            return this;
        }

        public Criteria andIsShareIsNull() {
            addCriterion("IS_SHARE is null");
            return this;
        }

        public Criteria andIsShareIsNotNull() {
            addCriterion("IS_SHARE is not null");
            return this;
        }

        public Criteria andIsShareEqualTo(Integer value) {
            addCriterion("IS_SHARE =", value, "isShare");
            return this;
        }

        public Criteria andIsShareNotEqualTo(Integer value) {
            addCriterion("IS_SHARE <>", value, "isShare");
            return this;
        }

        public Criteria andIsShareGreaterThan(Integer value) {
            addCriterion("IS_SHARE >", value, "isShare");
            return this;
        }

        public Criteria andIsShareGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_SHARE >=", value, "isShare");
            return this;
        }

        public Criteria andIsShareLessThan(Integer value) {
            addCriterion("IS_SHARE <", value, "isShare");
            return this;
        }

        public Criteria andIsShareLessThanOrEqualTo(Integer value) {
            addCriterion("IS_SHARE <=", value, "isShare");
            return this;
        }

        public Criteria andIsShareIn(List values) {
            addCriterion("IS_SHARE in", values, "isShare");
            return this;
        }

        public Criteria andIsShareNotIn(List values) {
            addCriterion("IS_SHARE not in", values, "isShare");
            return this;
        }

        public Criteria andIsShareBetween(Integer value1, Integer value2) {
            addCriterion("IS_SHARE between", value1, value2, "isShare");
            return this;
        }

        public Criteria andIsShareNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_SHARE not between", value1, value2, "isShare");
            return this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("CHANNEL_ID is null");
            return this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("CHANNEL_ID is not null");
            return this;
        }

        public Criteria andChannelIdEqualTo(Short value) {
            addCriterion("CHANNEL_ID =", value, "channelId");
            return this;
        }

        public Criteria andChannelIdNotEqualTo(Short value) {
            addCriterion("CHANNEL_ID <>", value, "channelId");
            return this;
        }

        public Criteria andChannelIdGreaterThan(Short value) {
            addCriterion("CHANNEL_ID >", value, "channelId");
            return this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Short value) {
            addCriterion("CHANNEL_ID >=", value, "channelId");
            return this;
        }

        public Criteria andChannelIdLessThan(Short value) {
            addCriterion("CHANNEL_ID <", value, "channelId");
            return this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Short value) {
            addCriterion("CHANNEL_ID <=", value, "channelId");
            return this;
        }

        public Criteria andChannelIdIn(List values) {
            addCriterion("CHANNEL_ID in", values, "channelId");
            return this;
        }

        public Criteria andChannelIdNotIn(List values) {
            addCriterion("CHANNEL_ID not in", values, "channelId");
            return this;
        }

        public Criteria andChannelIdBetween(Short value1, Short value2) {
            addCriterion("CHANNEL_ID between", value1, value2, "channelId");
            return this;
        }

        public Criteria andChannelIdNotBetween(Short value1, Short value2) {
            addCriterion("CHANNEL_ID not between", value1, value2, "channelId");
            return this;
        }

        public Criteria andOverWriteFlagIsNull() {
            addCriterion("OVER_WRITE_FLAG is null");
            return this;
        }

        public Criteria andOverWriteFlagIsNotNull() {
            addCriterion("OVER_WRITE_FLAG is not null");
            return this;
        }

        public Criteria andOverWriteFlagEqualTo(BigDecimal value) {
            addCriterion("OVER_WRITE_FLAG =", value, "overWriteFlag");
            return this;
        }

        public Criteria andOverWriteFlagNotEqualTo(BigDecimal value) {
            addCriterion("OVER_WRITE_FLAG <>", value, "overWriteFlag");
            return this;
        }

        public Criteria andOverWriteFlagGreaterThan(BigDecimal value) {
            addCriterion("OVER_WRITE_FLAG >", value, "overWriteFlag");
            return this;
        }

        public Criteria andOverWriteFlagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OVER_WRITE_FLAG >=", value, "overWriteFlag");
            return this;
        }

        public Criteria andOverWriteFlagLessThan(BigDecimal value) {
            addCriterion("OVER_WRITE_FLAG <", value, "overWriteFlag");
            return this;
        }

        public Criteria andOverWriteFlagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OVER_WRITE_FLAG <=", value, "overWriteFlag");
            return this;
        }

        public Criteria andOverWriteFlagIn(List values) {
            addCriterion("OVER_WRITE_FLAG in", values, "overWriteFlag");
            return this;
        }

        public Criteria andOverWriteFlagNotIn(List values) {
            addCriterion("OVER_WRITE_FLAG not in", values, "overWriteFlag");
            return this;
        }

        public Criteria andOverWriteFlagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVER_WRITE_FLAG between", value1, value2, "overWriteFlag");
            return this;
        }

        public Criteria andOverWriteFlagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVER_WRITE_FLAG not between", value1, value2, "overWriteFlag");
            return this;
        }

        public Criteria andLocalStoreCycleIsNull() {
            addCriterion("LOCAL_STORE_CYCLE is null");
            return this;
        }

        public Criteria andLocalStoreCycleIsNotNull() {
            addCriterion("LOCAL_STORE_CYCLE is not null");
            return this;
        }

        public Criteria andLocalStoreCycleEqualTo(Integer value) {
            addCriterion("LOCAL_STORE_CYCLE =", value, "localStoreCycle");
            return this;
        }

        public Criteria andLocalStoreCycleNotEqualTo(Integer value) {
            addCriterion("LOCAL_STORE_CYCLE <>", value, "localStoreCycle");
            return this;
        }

        public Criteria andLocalStoreCycleGreaterThan(Integer value) {
            addCriterion("LOCAL_STORE_CYCLE >", value, "localStoreCycle");
            return this;
        }

        public Criteria andLocalStoreCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOCAL_STORE_CYCLE >=", value, "localStoreCycle");
            return this;
        }

        public Criteria andLocalStoreCycleLessThan(Integer value) {
            addCriterion("LOCAL_STORE_CYCLE <", value, "localStoreCycle");
            return this;
        }

        public Criteria andLocalStoreCycleLessThanOrEqualTo(Integer value) {
            addCriterion("LOCAL_STORE_CYCLE <=", value, "localStoreCycle");
            return this;
        }

        public Criteria andLocalStoreCycleIn(List values) {
            addCriterion("LOCAL_STORE_CYCLE in", values, "localStoreCycle");
            return this;
        }

        public Criteria andLocalStoreCycleNotIn(List values) {
            addCriterion("LOCAL_STORE_CYCLE not in", values, "localStoreCycle");
            return this;
        }

        public Criteria andLocalStoreCycleBetween(Integer value1, Integer value2) {
            addCriterion("LOCAL_STORE_CYCLE between", value1, value2, "localStoreCycle");
            return this;
        }

        public Criteria andLocalStoreCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("LOCAL_STORE_CYCLE not between", value1, value2, "localStoreCycle");
            return this;
        }

        public Criteria andSchemeTypeIsNull() {
            addCriterion("SCHEME_TYPE is null");
            return this;
        }

        public Criteria andSchemeTypeIsNotNull() {
            addCriterion("SCHEME_TYPE is not null");
            return this;
        }

        public Criteria andSchemeTypeEqualTo(Short value) {
            addCriterion("SCHEME_TYPE =", value, "schemeType");
            return this;
        }

        public Criteria andSchemeTypeNotEqualTo(Short value) {
            addCriterion("SCHEME_TYPE <>", value, "schemeType");
            return this;
        }

        public Criteria andSchemeTypeGreaterThan(Short value) {
            addCriterion("SCHEME_TYPE >", value, "schemeType");
            return this;
        }

        public Criteria andSchemeTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("SCHEME_TYPE >=", value, "schemeType");
            return this;
        }

        public Criteria andSchemeTypeLessThan(Short value) {
            addCriterion("SCHEME_TYPE <", value, "schemeType");
            return this;
        }

        public Criteria andSchemeTypeLessThanOrEqualTo(Short value) {
            addCriterion("SCHEME_TYPE <=", value, "schemeType");
            return this;
        }

        public Criteria andSchemeTypeIn(List values) {
            addCriterion("SCHEME_TYPE in", values, "schemeType");
            return this;
        }

        public Criteria andSchemeTypeNotIn(List values) {
            addCriterion("SCHEME_TYPE not in", values, "schemeType");
            return this;
        }

        public Criteria andSchemeTypeBetween(Short value1, Short value2) {
            addCriterion("SCHEME_TYPE between", value1, value2, "schemeType");
            return this;
        }

        public Criteria andSchemeTypeNotBetween(Short value1, Short value2) {
            addCriterion("SCHEME_TYPE not between", value1, value2, "schemeType");
            return this;
        }

        public Criteria andLocalSchemeTypeIsNull() {
            addCriterion("LOCAL_SCHEME_TYPE is null");
            return this;
        }

        public Criteria andLocalSchemeTypeIsNotNull() {
            addCriterion("LOCAL_SCHEME_TYPE is not null");
            return this;
        }

        public Criteria andLocalSchemeTypeEqualTo(Short value) {
            addCriterion("LOCAL_SCHEME_TYPE =", value, "localSchemeType");
            return this;
        }

        public Criteria andLocalSchemeTypeNotEqualTo(Short value) {
            addCriterion("LOCAL_SCHEME_TYPE <>", value, "localSchemeType");
            return this;
        }

        public Criteria andLocalSchemeTypeGreaterThan(Short value) {
            addCriterion("LOCAL_SCHEME_TYPE >", value, "localSchemeType");
            return this;
        }

        public Criteria andLocalSchemeTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("LOCAL_SCHEME_TYPE >=", value, "localSchemeType");
            return this;
        }

        public Criteria andLocalSchemeTypeLessThan(Short value) {
            addCriterion("LOCAL_SCHEME_TYPE <", value, "localSchemeType");
            return this;
        }

        public Criteria andLocalSchemeTypeLessThanOrEqualTo(Short value) {
            addCriterion("LOCAL_SCHEME_TYPE <=", value, "localSchemeType");
            return this;
        }

        public Criteria andLocalSchemeTypeIn(List values) {
            addCriterion("LOCAL_SCHEME_TYPE in", values, "localSchemeType");
            return this;
        }

        public Criteria andLocalSchemeTypeNotIn(List values) {
            addCriterion("LOCAL_SCHEME_TYPE not in", values, "localSchemeType");
            return this;
        }

        public Criteria andLocalSchemeTypeBetween(Short value1, Short value2) {
            addCriterion("LOCAL_SCHEME_TYPE between", value1, value2, "localSchemeType");
            return this;
        }

        public Criteria andLocalSchemeTypeNotBetween(Short value1, Short value2) {
            addCriterion("LOCAL_SCHEME_TYPE not between", value1, value2, "localSchemeType");
            return this;
        }

        public Criteria andStreamTypeIsNull() {
            addCriterion("STREAM_TYPE is null");
            return this;
        }

        public Criteria andStreamTypeIsNotNull() {
            addCriterion("STREAM_TYPE is not null");
            return this;
        }

        public Criteria andStreamTypeEqualTo(Short value) {
            addCriterion("STREAM_TYPE =", value, "streamType");
            return this;
        }

        public Criteria andStreamTypeNotEqualTo(Short value) {
            addCriterion("STREAM_TYPE <>", value, "streamType");
            return this;
        }

        public Criteria andStreamTypeGreaterThan(Short value) {
            addCriterion("STREAM_TYPE >", value, "streamType");
            return this;
        }

        public Criteria andStreamTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("STREAM_TYPE >=", value, "streamType");
            return this;
        }

        public Criteria andStreamTypeLessThan(Short value) {
            addCriterion("STREAM_TYPE <", value, "streamType");
            return this;
        }

        public Criteria andStreamTypeLessThanOrEqualTo(Short value) {
            addCriterion("STREAM_TYPE <=", value, "streamType");
            return this;
        }

        public Criteria andStreamTypeIn(List values) {
            addCriterion("STREAM_TYPE in", values, "streamType");
            return this;
        }

        public Criteria andStreamTypeNotIn(List values) {
            addCriterion("STREAM_TYPE not in", values, "streamType");
            return this;
        }

        public Criteria andStreamTypeBetween(Short value1, Short value2) {
            addCriterion("STREAM_TYPE between", value1, value2, "streamType");
            return this;
        }

        public Criteria andStreamTypeNotBetween(Short value1, Short value2) {
            addCriterion("STREAM_TYPE not between", value1, value2, "streamType");
            return this;
        }

        public Criteria andAlarmStorageServerIdIsNull() {
            addCriterion("ALARM_STORAGE_SERVER_ID is null");
            return this;
        }

        public Criteria andAlarmStorageServerIdIsNotNull() {
            addCriterion("ALARM_STORAGE_SERVER_ID is not null");
            return this;
        }

        public Criteria andAlarmStorageServerIdEqualTo(String value) {
            addCriterion("ALARM_STORAGE_SERVER_ID =", value, "alarmStorageServerId");
            return this;
        }

        public Criteria andAlarmStorageServerIdNotEqualTo(String value) {
            addCriterion("ALARM_STORAGE_SERVER_ID <>", value, "alarmStorageServerId");
            return this;
        }

        public Criteria andAlarmStorageServerIdGreaterThan(String value) {
            addCriterion("ALARM_STORAGE_SERVER_ID >", value, "alarmStorageServerId");
            return this;
        }

        public Criteria andAlarmStorageServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("ALARM_STORAGE_SERVER_ID >=", value, "alarmStorageServerId");
            return this;
        }

        public Criteria andAlarmStorageServerIdLessThan(String value) {
            addCriterion("ALARM_STORAGE_SERVER_ID <", value, "alarmStorageServerId");
            return this;
        }

        public Criteria andAlarmStorageServerIdLessThanOrEqualTo(String value) {
            addCriterion("ALARM_STORAGE_SERVER_ID <=", value, "alarmStorageServerId");
            return this;
        }

        public Criteria andAlarmStorageServerIdLike(String value) {
            addCriterion("ALARM_STORAGE_SERVER_ID like", value, "alarmStorageServerId");
            return this;
        }

        public Criteria andAlarmStorageServerIdNotLike(String value) {
            addCriterion("ALARM_STORAGE_SERVER_ID not like", value, "alarmStorageServerId");
            return this;
        }

        public Criteria andAlarmStorageServerIdIn(List values) {
            addCriterion("ALARM_STORAGE_SERVER_ID in", values, "alarmStorageServerId");
            return this;
        }

        public Criteria andAlarmStorageServerIdNotIn(List values) {
            addCriterion("ALARM_STORAGE_SERVER_ID not in", values, "alarmStorageServerId");
            return this;
        }

        public Criteria andAlarmStorageServerIdBetween(String value1, String value2) {
            addCriterion("ALARM_STORAGE_SERVER_ID between", value1, value2, "alarmStorageServerId");
            return this;
        }

        public Criteria andAlarmStorageServerIdNotBetween(String value1, String value2) {
            addCriterion("ALARM_STORAGE_SERVER_ID not between", value1, value2, "alarmStorageServerId");
            return this;
        }
    }
}