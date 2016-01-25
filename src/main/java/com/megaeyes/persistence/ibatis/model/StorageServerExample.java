package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageServerExample {
    protected String orderByClause;

    protected List oredCriteria;

    public StorageServerExample() {
        oredCriteria = new ArrayList();
    }

    protected StorageServerExample(StorageServerExample example) {
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

        public Criteria andMaxOutputAmountIsNull() {
            addCriterion("MAX_OUTPUT_AMOUNT is null");
            return this;
        }

        public Criteria andMaxOutputAmountIsNotNull() {
            addCriterion("MAX_OUTPUT_AMOUNT is not null");
            return this;
        }

        public Criteria andMaxOutputAmountEqualTo(Long value) {
            addCriterion("MAX_OUTPUT_AMOUNT =", value, "maxOutputAmount");
            return this;
        }

        public Criteria andMaxOutputAmountNotEqualTo(Long value) {
            addCriterion("MAX_OUTPUT_AMOUNT <>", value, "maxOutputAmount");
            return this;
        }

        public Criteria andMaxOutputAmountGreaterThan(Long value) {
            addCriterion("MAX_OUTPUT_AMOUNT >", value, "maxOutputAmount");
            return this;
        }

        public Criteria andMaxOutputAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("MAX_OUTPUT_AMOUNT >=", value, "maxOutputAmount");
            return this;
        }

        public Criteria andMaxOutputAmountLessThan(Long value) {
            addCriterion("MAX_OUTPUT_AMOUNT <", value, "maxOutputAmount");
            return this;
        }

        public Criteria andMaxOutputAmountLessThanOrEqualTo(Long value) {
            addCriterion("MAX_OUTPUT_AMOUNT <=", value, "maxOutputAmount");
            return this;
        }

        public Criteria andMaxOutputAmountIn(List values) {
            addCriterion("MAX_OUTPUT_AMOUNT in", values, "maxOutputAmount");
            return this;
        }

        public Criteria andMaxOutputAmountNotIn(List values) {
            addCriterion("MAX_OUTPUT_AMOUNT not in", values, "maxOutputAmount");
            return this;
        }

        public Criteria andMaxOutputAmountBetween(Long value1, Long value2) {
            addCriterion("MAX_OUTPUT_AMOUNT between", value1, value2, "maxOutputAmount");
            return this;
        }

        public Criteria andMaxOutputAmountNotBetween(Long value1, Long value2) {
            addCriterion("MAX_OUTPUT_AMOUNT not between", value1, value2, "maxOutputAmount");
            return this;
        }

        public Criteria andMaxInputAmountIsNull() {
            addCriterion("MAX_INPUT_AMOUNT is null");
            return this;
        }

        public Criteria andMaxInputAmountIsNotNull() {
            addCriterion("MAX_INPUT_AMOUNT is not null");
            return this;
        }

        public Criteria andMaxInputAmountEqualTo(Long value) {
            addCriterion("MAX_INPUT_AMOUNT =", value, "maxInputAmount");
            return this;
        }

        public Criteria andMaxInputAmountNotEqualTo(Long value) {
            addCriterion("MAX_INPUT_AMOUNT <>", value, "maxInputAmount");
            return this;
        }

        public Criteria andMaxInputAmountGreaterThan(Long value) {
            addCriterion("MAX_INPUT_AMOUNT >", value, "maxInputAmount");
            return this;
        }

        public Criteria andMaxInputAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("MAX_INPUT_AMOUNT >=", value, "maxInputAmount");
            return this;
        }

        public Criteria andMaxInputAmountLessThan(Long value) {
            addCriterion("MAX_INPUT_AMOUNT <", value, "maxInputAmount");
            return this;
        }

        public Criteria andMaxInputAmountLessThanOrEqualTo(Long value) {
            addCriterion("MAX_INPUT_AMOUNT <=", value, "maxInputAmount");
            return this;
        }

        public Criteria andMaxInputAmountIn(List values) {
            addCriterion("MAX_INPUT_AMOUNT in", values, "maxInputAmount");
            return this;
        }

        public Criteria andMaxInputAmountNotIn(List values) {
            addCriterion("MAX_INPUT_AMOUNT not in", values, "maxInputAmount");
            return this;
        }

        public Criteria andMaxInputAmountBetween(Long value1, Long value2) {
            addCriterion("MAX_INPUT_AMOUNT between", value1, value2, "maxInputAmount");
            return this;
        }

        public Criteria andMaxInputAmountNotBetween(Long value1, Long value2) {
            addCriterion("MAX_INPUT_AMOUNT not between", value1, value2, "maxInputAmount");
            return this;
        }

        public Criteria andFtpPortIsNull() {
            addCriterion("FTP_PORT is null");
            return this;
        }

        public Criteria andFtpPortIsNotNull() {
            addCriterion("FTP_PORT is not null");
            return this;
        }

        public Criteria andFtpPortEqualTo(Long value) {
            addCriterion("FTP_PORT =", value, "ftpPort");
            return this;
        }

        public Criteria andFtpPortNotEqualTo(Long value) {
            addCriterion("FTP_PORT <>", value, "ftpPort");
            return this;
        }

        public Criteria andFtpPortGreaterThan(Long value) {
            addCriterion("FTP_PORT >", value, "ftpPort");
            return this;
        }

        public Criteria andFtpPortGreaterThanOrEqualTo(Long value) {
            addCriterion("FTP_PORT >=", value, "ftpPort");
            return this;
        }

        public Criteria andFtpPortLessThan(Long value) {
            addCriterion("FTP_PORT <", value, "ftpPort");
            return this;
        }

        public Criteria andFtpPortLessThanOrEqualTo(Long value) {
            addCriterion("FTP_PORT <=", value, "ftpPort");
            return this;
        }

        public Criteria andFtpPortIn(List values) {
            addCriterion("FTP_PORT in", values, "ftpPort");
            return this;
        }

        public Criteria andFtpPortNotIn(List values) {
            addCriterion("FTP_PORT not in", values, "ftpPort");
            return this;
        }

        public Criteria andFtpPortBetween(Long value1, Long value2) {
            addCriterion("FTP_PORT between", value1, value2, "ftpPort");
            return this;
        }

        public Criteria andFtpPortNotBetween(Long value1, Long value2) {
            addCriterion("FTP_PORT not between", value1, value2, "ftpPort");
            return this;
        }

        public Criteria andFtpUserNameIsNull() {
            addCriterion("FTP_USER_NAME is null");
            return this;
        }

        public Criteria andFtpUserNameIsNotNull() {
            addCriterion("FTP_USER_NAME is not null");
            return this;
        }

        public Criteria andFtpUserNameEqualTo(String value) {
            addCriterion("FTP_USER_NAME =", value, "ftpUserName");
            return this;
        }

        public Criteria andFtpUserNameNotEqualTo(String value) {
            addCriterion("FTP_USER_NAME <>", value, "ftpUserName");
            return this;
        }

        public Criteria andFtpUserNameGreaterThan(String value) {
            addCriterion("FTP_USER_NAME >", value, "ftpUserName");
            return this;
        }

        public Criteria andFtpUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("FTP_USER_NAME >=", value, "ftpUserName");
            return this;
        }

        public Criteria andFtpUserNameLessThan(String value) {
            addCriterion("FTP_USER_NAME <", value, "ftpUserName");
            return this;
        }

        public Criteria andFtpUserNameLessThanOrEqualTo(String value) {
            addCriterion("FTP_USER_NAME <=", value, "ftpUserName");
            return this;
        }

        public Criteria andFtpUserNameLike(String value) {
            addCriterion("FTP_USER_NAME like", value, "ftpUserName");
            return this;
        }

        public Criteria andFtpUserNameNotLike(String value) {
            addCriterion("FTP_USER_NAME not like", value, "ftpUserName");
            return this;
        }

        public Criteria andFtpUserNameIn(List values) {
            addCriterion("FTP_USER_NAME in", values, "ftpUserName");
            return this;
        }

        public Criteria andFtpUserNameNotIn(List values) {
            addCriterion("FTP_USER_NAME not in", values, "ftpUserName");
            return this;
        }

        public Criteria andFtpUserNameBetween(String value1, String value2) {
            addCriterion("FTP_USER_NAME between", value1, value2, "ftpUserName");
            return this;
        }

        public Criteria andFtpUserNameNotBetween(String value1, String value2) {
            addCriterion("FTP_USER_NAME not between", value1, value2, "ftpUserName");
            return this;
        }

        public Criteria andFtpPasswordIsNull() {
            addCriterion("FTP_PASSWORD is null");
            return this;
        }

        public Criteria andFtpPasswordIsNotNull() {
            addCriterion("FTP_PASSWORD is not null");
            return this;
        }

        public Criteria andFtpPasswordEqualTo(String value) {
            addCriterion("FTP_PASSWORD =", value, "ftpPassword");
            return this;
        }

        public Criteria andFtpPasswordNotEqualTo(String value) {
            addCriterion("FTP_PASSWORD <>", value, "ftpPassword");
            return this;
        }

        public Criteria andFtpPasswordGreaterThan(String value) {
            addCriterion("FTP_PASSWORD >", value, "ftpPassword");
            return this;
        }

        public Criteria andFtpPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("FTP_PASSWORD >=", value, "ftpPassword");
            return this;
        }

        public Criteria andFtpPasswordLessThan(String value) {
            addCriterion("FTP_PASSWORD <", value, "ftpPassword");
            return this;
        }

        public Criteria andFtpPasswordLessThanOrEqualTo(String value) {
            addCriterion("FTP_PASSWORD <=", value, "ftpPassword");
            return this;
        }

        public Criteria andFtpPasswordLike(String value) {
            addCriterion("FTP_PASSWORD like", value, "ftpPassword");
            return this;
        }

        public Criteria andFtpPasswordNotLike(String value) {
            addCriterion("FTP_PASSWORD not like", value, "ftpPassword");
            return this;
        }

        public Criteria andFtpPasswordIn(List values) {
            addCriterion("FTP_PASSWORD in", values, "ftpPassword");
            return this;
        }

        public Criteria andFtpPasswordNotIn(List values) {
            addCriterion("FTP_PASSWORD not in", values, "ftpPassword");
            return this;
        }

        public Criteria andFtpPasswordBetween(String value1, String value2) {
            addCriterion("FTP_PASSWORD between", value1, value2, "ftpPassword");
            return this;
        }

        public Criteria andFtpPasswordNotBetween(String value1, String value2) {
            addCriterion("FTP_PASSWORD not between", value1, value2, "ftpPassword");
            return this;
        }

        public Criteria andIp2IsNull() {
            addCriterion("IP2 is null");
            return this;
        }

        public Criteria andIp2IsNotNull() {
            addCriterion("IP2 is not null");
            return this;
        }

        public Criteria andIp2EqualTo(String value) {
            addCriterion("IP2 =", value, "ip2");
            return this;
        }

        public Criteria andIp2NotEqualTo(String value) {
            addCriterion("IP2 <>", value, "ip2");
            return this;
        }

        public Criteria andIp2GreaterThan(String value) {
            addCriterion("IP2 >", value, "ip2");
            return this;
        }

        public Criteria andIp2GreaterThanOrEqualTo(String value) {
            addCriterion("IP2 >=", value, "ip2");
            return this;
        }

        public Criteria andIp2LessThan(String value) {
            addCriterion("IP2 <", value, "ip2");
            return this;
        }

        public Criteria andIp2LessThanOrEqualTo(String value) {
            addCriterion("IP2 <=", value, "ip2");
            return this;
        }

        public Criteria andIp2Like(String value) {
            addCriterion("IP2 like", value, "ip2");
            return this;
        }

        public Criteria andIp2NotLike(String value) {
            addCriterion("IP2 not like", value, "ip2");
            return this;
        }

        public Criteria andIp2In(List values) {
            addCriterion("IP2 in", values, "ip2");
            return this;
        }

        public Criteria andIp2NotIn(List values) {
            addCriterion("IP2 not in", values, "ip2");
            return this;
        }

        public Criteria andIp2Between(String value1, String value2) {
            addCriterion("IP2 between", value1, value2, "ip2");
            return this;
        }

        public Criteria andIp2NotBetween(String value1, String value2) {
            addCriterion("IP2 not between", value1, value2, "ip2");
            return this;
        }

        public Criteria andMessagePortIsNull() {
            addCriterion("MESSAGE_PORT is null");
            return this;
        }

        public Criteria andMessagePortIsNotNull() {
            addCriterion("MESSAGE_PORT is not null");
            return this;
        }

        public Criteria andMessagePortEqualTo(Long value) {
            addCriterion("MESSAGE_PORT =", value, "messagePort");
            return this;
        }

        public Criteria andMessagePortNotEqualTo(Long value) {
            addCriterion("MESSAGE_PORT <>", value, "messagePort");
            return this;
        }

        public Criteria andMessagePortGreaterThan(Long value) {
            addCriterion("MESSAGE_PORT >", value, "messagePort");
            return this;
        }

        public Criteria andMessagePortGreaterThanOrEqualTo(Long value) {
            addCriterion("MESSAGE_PORT >=", value, "messagePort");
            return this;
        }

        public Criteria andMessagePortLessThan(Long value) {
            addCriterion("MESSAGE_PORT <", value, "messagePort");
            return this;
        }

        public Criteria andMessagePortLessThanOrEqualTo(Long value) {
            addCriterion("MESSAGE_PORT <=", value, "messagePort");
            return this;
        }

        public Criteria andMessagePortIn(List values) {
            addCriterion("MESSAGE_PORT in", values, "messagePort");
            return this;
        }

        public Criteria andMessagePortNotIn(List values) {
            addCriterion("MESSAGE_PORT not in", values, "messagePort");
            return this;
        }

        public Criteria andMessagePortBetween(Long value1, Long value2) {
            addCriterion("MESSAGE_PORT between", value1, value2, "messagePort");
            return this;
        }

        public Criteria andMessagePortNotBetween(Long value1, Long value2) {
            addCriterion("MESSAGE_PORT not between", value1, value2, "messagePort");
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

        public Criteria andIsVirtualIpIsNull() {
            addCriterion("IS_VIRTUAL_IP is null");
            return this;
        }

        public Criteria andIsVirtualIpIsNotNull() {
            addCriterion("IS_VIRTUAL_IP is not null");
            return this;
        }

        public Criteria andIsVirtualIpEqualTo(BigDecimal value) {
            addCriterion("IS_VIRTUAL_IP =", value, "isVirtualIp");
            return this;
        }

        public Criteria andIsVirtualIpNotEqualTo(BigDecimal value) {
            addCriterion("IS_VIRTUAL_IP <>", value, "isVirtualIp");
            return this;
        }

        public Criteria andIsVirtualIpGreaterThan(BigDecimal value) {
            addCriterion("IS_VIRTUAL_IP >", value, "isVirtualIp");
            return this;
        }

        public Criteria andIsVirtualIpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_VIRTUAL_IP >=", value, "isVirtualIp");
            return this;
        }

        public Criteria andIsVirtualIpLessThan(BigDecimal value) {
            addCriterion("IS_VIRTUAL_IP <", value, "isVirtualIp");
            return this;
        }

        public Criteria andIsVirtualIpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_VIRTUAL_IP <=", value, "isVirtualIp");
            return this;
        }

        public Criteria andIsVirtualIpIn(List values) {
            addCriterion("IS_VIRTUAL_IP in", values, "isVirtualIp");
            return this;
        }

        public Criteria andIsVirtualIpNotIn(List values) {
            addCriterion("IS_VIRTUAL_IP not in", values, "isVirtualIp");
            return this;
        }

        public Criteria andIsVirtualIpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_VIRTUAL_IP between", value1, value2, "isVirtualIp");
            return this;
        }

        public Criteria andIsVirtualIpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_VIRTUAL_IP not between", value1, value2, "isVirtualIp");
            return this;
        }
    }
}