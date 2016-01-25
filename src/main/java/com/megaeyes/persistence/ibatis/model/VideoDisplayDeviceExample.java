package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoDisplayDeviceExample {
    protected String orderByClause;

    protected List oredCriteria;

    public VideoDisplayDeviceExample() {
        oredCriteria = new ArrayList();
    }

    protected VideoDisplayDeviceExample(VideoDisplayDeviceExample example) {
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

        public Criteria andDeviceNumberIsNull() {
            addCriterion("DEVICE_NUMBER is null");
            return this;
        }

        public Criteria andDeviceNumberIsNotNull() {
            addCriterion("DEVICE_NUMBER is not null");
            return this;
        }

        public Criteria andDeviceNumberEqualTo(String value) {
            addCriterion("DEVICE_NUMBER =", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberNotEqualTo(String value) {
            addCriterion("DEVICE_NUMBER <>", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberGreaterThan(String value) {
            addCriterion("DEVICE_NUMBER >", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_NUMBER >=", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberLessThan(String value) {
            addCriterion("DEVICE_NUMBER <", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_NUMBER <=", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberLike(String value) {
            addCriterion("DEVICE_NUMBER like", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberNotLike(String value) {
            addCriterion("DEVICE_NUMBER not like", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberIn(List values) {
            addCriterion("DEVICE_NUMBER in", values, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberNotIn(List values) {
            addCriterion("DEVICE_NUMBER not in", values, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberBetween(String value1, String value2) {
            addCriterion("DEVICE_NUMBER between", value1, value2, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberNotBetween(String value1, String value2) {
            addCriterion("DEVICE_NUMBER not between", value1, value2, "deviceNumber");
            return this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return this;
        }

        public Criteria andIpIn(List values) {
            addCriterion("IP in", values, "ip");
            return this;
        }

        public Criteria andIpNotIn(List values) {
            addCriterion("IP not in", values, "ip");
            return this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return this;
        }

        public Criteria andLinkTypeIsNull() {
            addCriterion("LINK_TYPE is null");
            return this;
        }

        public Criteria andLinkTypeIsNotNull() {
            addCriterion("LINK_TYPE is not null");
            return this;
        }

        public Criteria andLinkTypeEqualTo(String value) {
            addCriterion("LINK_TYPE =", value, "linkType");
            return this;
        }

        public Criteria andLinkTypeNotEqualTo(String value) {
            addCriterion("LINK_TYPE <>", value, "linkType");
            return this;
        }

        public Criteria andLinkTypeGreaterThan(String value) {
            addCriterion("LINK_TYPE >", value, "linkType");
            return this;
        }

        public Criteria andLinkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_TYPE >=", value, "linkType");
            return this;
        }

        public Criteria andLinkTypeLessThan(String value) {
            addCriterion("LINK_TYPE <", value, "linkType");
            return this;
        }

        public Criteria andLinkTypeLessThanOrEqualTo(String value) {
            addCriterion("LINK_TYPE <=", value, "linkType");
            return this;
        }

        public Criteria andLinkTypeLike(String value) {
            addCriterion("LINK_TYPE like", value, "linkType");
            return this;
        }

        public Criteria andLinkTypeNotLike(String value) {
            addCriterion("LINK_TYPE not like", value, "linkType");
            return this;
        }

        public Criteria andLinkTypeIn(List values) {
            addCriterion("LINK_TYPE in", values, "linkType");
            return this;
        }

        public Criteria andLinkTypeNotIn(List values) {
            addCriterion("LINK_TYPE not in", values, "linkType");
            return this;
        }

        public Criteria andLinkTypeBetween(String value1, String value2) {
            addCriterion("LINK_TYPE between", value1, value2, "linkType");
            return this;
        }

        public Criteria andLinkTypeNotBetween(String value1, String value2) {
            addCriterion("LINK_TYPE not between", value1, value2, "linkType");
            return this;
        }

        public Criteria andHeartCycleIsNull() {
            addCriterion("HEART_CYCLE is null");
            return this;
        }

        public Criteria andHeartCycleIsNotNull() {
            addCriterion("HEART_CYCLE is not null");
            return this;
        }

        public Criteria andHeartCycleEqualTo(Long value) {
            addCriterion("HEART_CYCLE =", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleNotEqualTo(Long value) {
            addCriterion("HEART_CYCLE <>", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleGreaterThan(Long value) {
            addCriterion("HEART_CYCLE >", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleGreaterThanOrEqualTo(Long value) {
            addCriterion("HEART_CYCLE >=", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleLessThan(Long value) {
            addCriterion("HEART_CYCLE <", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleLessThanOrEqualTo(Long value) {
            addCriterion("HEART_CYCLE <=", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleIn(List values) {
            addCriterion("HEART_CYCLE in", values, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleNotIn(List values) {
            addCriterion("HEART_CYCLE not in", values, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleBetween(Long value1, Long value2) {
            addCriterion("HEART_CYCLE between", value1, value2, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleNotBetween(Long value1, Long value2) {
            addCriterion("HEART_CYCLE not between", value1, value2, "heartCycle");
            return this;
        }

        public Criteria andRebootTimeIsNull() {
            addCriterion("REBOOT_TIME is null");
            return this;
        }

        public Criteria andRebootTimeIsNotNull() {
            addCriterion("REBOOT_TIME is not null");
            return this;
        }

        public Criteria andRebootTimeEqualTo(String value) {
            addCriterion("REBOOT_TIME =", value, "rebootTime");
            return this;
        }

        public Criteria andRebootTimeNotEqualTo(String value) {
            addCriterion("REBOOT_TIME <>", value, "rebootTime");
            return this;
        }

        public Criteria andRebootTimeGreaterThan(String value) {
            addCriterion("REBOOT_TIME >", value, "rebootTime");
            return this;
        }

        public Criteria andRebootTimeGreaterThanOrEqualTo(String value) {
            addCriterion("REBOOT_TIME >=", value, "rebootTime");
            return this;
        }

        public Criteria andRebootTimeLessThan(String value) {
            addCriterion("REBOOT_TIME <", value, "rebootTime");
            return this;
        }

        public Criteria andRebootTimeLessThanOrEqualTo(String value) {
            addCriterion("REBOOT_TIME <=", value, "rebootTime");
            return this;
        }

        public Criteria andRebootTimeLike(String value) {
            addCriterion("REBOOT_TIME like", value, "rebootTime");
            return this;
        }

        public Criteria andRebootTimeNotLike(String value) {
            addCriterion("REBOOT_TIME not like", value, "rebootTime");
            return this;
        }

        public Criteria andRebootTimeIn(List values) {
            addCriterion("REBOOT_TIME in", values, "rebootTime");
            return this;
        }

        public Criteria andRebootTimeNotIn(List values) {
            addCriterion("REBOOT_TIME not in", values, "rebootTime");
            return this;
        }

        public Criteria andRebootTimeBetween(String value1, String value2) {
            addCriterion("REBOOT_TIME between", value1, value2, "rebootTime");
            return this;
        }

        public Criteria andRebootTimeNotBetween(String value1, String value2) {
            addCriterion("REBOOT_TIME not between", value1, value2, "rebootTime");
            return this;
        }

        public Criteria andRebootCycleIsNull() {
            addCriterion("REBOOT_CYCLE is null");
            return this;
        }

        public Criteria andRebootCycleIsNotNull() {
            addCriterion("REBOOT_CYCLE is not null");
            return this;
        }

        public Criteria andRebootCycleEqualTo(Long value) {
            addCriterion("REBOOT_CYCLE =", value, "rebootCycle");
            return this;
        }

        public Criteria andRebootCycleNotEqualTo(Long value) {
            addCriterion("REBOOT_CYCLE <>", value, "rebootCycle");
            return this;
        }

        public Criteria andRebootCycleGreaterThan(Long value) {
            addCriterion("REBOOT_CYCLE >", value, "rebootCycle");
            return this;
        }

        public Criteria andRebootCycleGreaterThanOrEqualTo(Long value) {
            addCriterion("REBOOT_CYCLE >=", value, "rebootCycle");
            return this;
        }

        public Criteria andRebootCycleLessThan(Long value) {
            addCriterion("REBOOT_CYCLE <", value, "rebootCycle");
            return this;
        }

        public Criteria andRebootCycleLessThanOrEqualTo(Long value) {
            addCriterion("REBOOT_CYCLE <=", value, "rebootCycle");
            return this;
        }

        public Criteria andRebootCycleIn(List values) {
            addCriterion("REBOOT_CYCLE in", values, "rebootCycle");
            return this;
        }

        public Criteria andRebootCycleNotIn(List values) {
            addCriterion("REBOOT_CYCLE not in", values, "rebootCycle");
            return this;
        }

        public Criteria andRebootCycleBetween(Long value1, Long value2) {
            addCriterion("REBOOT_CYCLE between", value1, value2, "rebootCycle");
            return this;
        }

        public Criteria andRebootCycleNotBetween(Long value1, Long value2) {
            addCriterion("REBOOT_CYCLE not between", value1, value2, "rebootCycle");
            return this;
        }

        public Criteria andVideoIntputAmountIsNull() {
            addCriterion("VIDEO_INTPUT_AMOUNT is null");
            return this;
        }

        public Criteria andVideoIntputAmountIsNotNull() {
            addCriterion("VIDEO_INTPUT_AMOUNT is not null");
            return this;
        }

        public Criteria andVideoIntputAmountEqualTo(Long value) {
            addCriterion("VIDEO_INTPUT_AMOUNT =", value, "videoIntputAmount");
            return this;
        }

        public Criteria andVideoIntputAmountNotEqualTo(Long value) {
            addCriterion("VIDEO_INTPUT_AMOUNT <>", value, "videoIntputAmount");
            return this;
        }

        public Criteria andVideoIntputAmountGreaterThan(Long value) {
            addCriterion("VIDEO_INTPUT_AMOUNT >", value, "videoIntputAmount");
            return this;
        }

        public Criteria andVideoIntputAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("VIDEO_INTPUT_AMOUNT >=", value, "videoIntputAmount");
            return this;
        }

        public Criteria andVideoIntputAmountLessThan(Long value) {
            addCriterion("VIDEO_INTPUT_AMOUNT <", value, "videoIntputAmount");
            return this;
        }

        public Criteria andVideoIntputAmountLessThanOrEqualTo(Long value) {
            addCriterion("VIDEO_INTPUT_AMOUNT <=", value, "videoIntputAmount");
            return this;
        }

        public Criteria andVideoIntputAmountIn(List values) {
            addCriterion("VIDEO_INTPUT_AMOUNT in", values, "videoIntputAmount");
            return this;
        }

        public Criteria andVideoIntputAmountNotIn(List values) {
            addCriterion("VIDEO_INTPUT_AMOUNT not in", values, "videoIntputAmount");
            return this;
        }

        public Criteria andVideoIntputAmountBetween(Long value1, Long value2) {
            addCriterion("VIDEO_INTPUT_AMOUNT between", value1, value2, "videoIntputAmount");
            return this;
        }

        public Criteria andVideoIntputAmountNotBetween(Long value1, Long value2) {
            addCriterion("VIDEO_INTPUT_AMOUNT not between", value1, value2, "videoIntputAmount");
            return this;
        }

        public Criteria andVideoOutputAmountIsNull() {
            addCriterion("VIDEO_OUTPUT_AMOUNT is null");
            return this;
        }

        public Criteria andVideoOutputAmountIsNotNull() {
            addCriterion("VIDEO_OUTPUT_AMOUNT is not null");
            return this;
        }

        public Criteria andVideoOutputAmountEqualTo(Long value) {
            addCriterion("VIDEO_OUTPUT_AMOUNT =", value, "videoOutputAmount");
            return this;
        }

        public Criteria andVideoOutputAmountNotEqualTo(Long value) {
            addCriterion("VIDEO_OUTPUT_AMOUNT <>", value, "videoOutputAmount");
            return this;
        }

        public Criteria andVideoOutputAmountGreaterThan(Long value) {
            addCriterion("VIDEO_OUTPUT_AMOUNT >", value, "videoOutputAmount");
            return this;
        }

        public Criteria andVideoOutputAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("VIDEO_OUTPUT_AMOUNT >=", value, "videoOutputAmount");
            return this;
        }

        public Criteria andVideoOutputAmountLessThan(Long value) {
            addCriterion("VIDEO_OUTPUT_AMOUNT <", value, "videoOutputAmount");
            return this;
        }

        public Criteria andVideoOutputAmountLessThanOrEqualTo(Long value) {
            addCriterion("VIDEO_OUTPUT_AMOUNT <=", value, "videoOutputAmount");
            return this;
        }

        public Criteria andVideoOutputAmountIn(List values) {
            addCriterion("VIDEO_OUTPUT_AMOUNT in", values, "videoOutputAmount");
            return this;
        }

        public Criteria andVideoOutputAmountNotIn(List values) {
            addCriterion("VIDEO_OUTPUT_AMOUNT not in", values, "videoOutputAmount");
            return this;
        }

        public Criteria andVideoOutputAmountBetween(Long value1, Long value2) {
            addCriterion("VIDEO_OUTPUT_AMOUNT between", value1, value2, "videoOutputAmount");
            return this;
        }

        public Criteria andVideoOutputAmountNotBetween(Long value1, Long value2) {
            addCriterion("VIDEO_OUTPUT_AMOUNT not between", value1, value2, "videoOutputAmount");
            return this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("COMPANY_ID is null");
            return this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("COMPANY_ID is not null");
            return this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("COMPANY_ID =", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("COMPANY_ID <>", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("COMPANY_ID >", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_ID >=", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("COMPANY_ID <", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_ID <=", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("COMPANY_ID like", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("COMPANY_ID not like", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdIn(List values) {
            addCriterion("COMPANY_ID in", values, "companyId");
            return this;
        }

        public Criteria andCompanyIdNotIn(List values) {
            addCriterion("COMPANY_ID not in", values, "companyId");
            return this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("COMPANY_ID between", value1, value2, "companyId");
            return this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("COMPANY_ID not between", value1, value2, "companyId");
            return this;
        }

        public Criteria andOOrganIdIsNull() {
            addCriterion("O_ORGAN_ID is null");
            return this;
        }

        public Criteria andOOrganIdIsNotNull() {
            addCriterion("O_ORGAN_ID is not null");
            return this;
        }

        public Criteria andOOrganIdEqualTo(String value) {
            addCriterion("O_ORGAN_ID =", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdNotEqualTo(String value) {
            addCriterion("O_ORGAN_ID <>", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdGreaterThan(String value) {
            addCriterion("O_ORGAN_ID >", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdGreaterThanOrEqualTo(String value) {
            addCriterion("O_ORGAN_ID >=", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdLessThan(String value) {
            addCriterion("O_ORGAN_ID <", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdLessThanOrEqualTo(String value) {
            addCriterion("O_ORGAN_ID <=", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdLike(String value) {
            addCriterion("O_ORGAN_ID like", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdNotLike(String value) {
            addCriterion("O_ORGAN_ID not like", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdIn(List values) {
            addCriterion("O_ORGAN_ID in", values, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdNotIn(List values) {
            addCriterion("O_ORGAN_ID not in", values, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdBetween(String value1, String value2) {
            addCriterion("O_ORGAN_ID between", value1, value2, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdNotBetween(String value1, String value2) {
            addCriterion("O_ORGAN_ID not between", value1, value2, "oOrganId");
            return this;
        }
    }
}