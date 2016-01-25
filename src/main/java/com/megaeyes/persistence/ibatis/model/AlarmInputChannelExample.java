package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlarmInputChannelExample {
    protected String orderByClause;

    protected List oredCriteria;

    public AlarmInputChannelExample() {
        oredCriteria = new ArrayList();
    }

    protected AlarmInputChannelExample(AlarmInputChannelExample example) {
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

        public Criteria andAlarmBoxIdIsNull() {
            addCriterion("ALARM_BOX_ID is null");
            return this;
        }

        public Criteria andAlarmBoxIdIsNotNull() {
            addCriterion("ALARM_BOX_ID is not null");
            return this;
        }

        public Criteria andAlarmBoxIdEqualTo(String value) {
            addCriterion("ALARM_BOX_ID =", value, "alarmBoxId");
            return this;
        }

        public Criteria andAlarmBoxIdNotEqualTo(String value) {
            addCriterion("ALARM_BOX_ID <>", value, "alarmBoxId");
            return this;
        }

        public Criteria andAlarmBoxIdGreaterThan(String value) {
            addCriterion("ALARM_BOX_ID >", value, "alarmBoxId");
            return this;
        }

        public Criteria andAlarmBoxIdGreaterThanOrEqualTo(String value) {
            addCriterion("ALARM_BOX_ID >=", value, "alarmBoxId");
            return this;
        }

        public Criteria andAlarmBoxIdLessThan(String value) {
            addCriterion("ALARM_BOX_ID <", value, "alarmBoxId");
            return this;
        }

        public Criteria andAlarmBoxIdLessThanOrEqualTo(String value) {
            addCriterion("ALARM_BOX_ID <=", value, "alarmBoxId");
            return this;
        }

        public Criteria andAlarmBoxIdLike(String value) {
            addCriterion("ALARM_BOX_ID like", value, "alarmBoxId");
            return this;
        }

        public Criteria andAlarmBoxIdNotLike(String value) {
            addCriterion("ALARM_BOX_ID not like", value, "alarmBoxId");
            return this;
        }

        public Criteria andAlarmBoxIdIn(List values) {
            addCriterion("ALARM_BOX_ID in", values, "alarmBoxId");
            return this;
        }

        public Criteria andAlarmBoxIdNotIn(List values) {
            addCriterion("ALARM_BOX_ID not in", values, "alarmBoxId");
            return this;
        }

        public Criteria andAlarmBoxIdBetween(String value1, String value2) {
            addCriterion("ALARM_BOX_ID between", value1, value2, "alarmBoxId");
            return this;
        }

        public Criteria andAlarmBoxIdNotBetween(String value1, String value2) {
            addCriterion("ALARM_BOX_ID not between", value1, value2, "alarmBoxId");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxIsNull() {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX is null");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxIsNotNull() {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX is not null");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxEqualTo(String value) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX =", value, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxNotEqualTo(String value) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX <>", value, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxGreaterThan(String value) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX >", value, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX >=", value, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxLessThan(String value) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX <", value, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX <=", value, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxLike(String value) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX like", value, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxNotLike(String value) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX not like", value, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxIn(List values) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX in", values, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxNotIn(List values) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX not in", values, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxBetween(String value1, String value2) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX between", value1, value2, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAddressNumberOnAlarmBoxNotBetween(String value1, String value2) {
            addCriterion("ADDRESS_NUMBER_ON_ALARM_BOX not between", value1, value2, "addressNumberOnAlarmBox");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdIsNull() {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID is null");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdIsNotNull() {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID is not null");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdEqualTo(String value) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID =", value, "alarmInputChannelTypeId");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdNotEqualTo(String value) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID <>", value, "alarmInputChannelTypeId");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdGreaterThan(String value) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID >", value, "alarmInputChannelTypeId");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID >=", value, "alarmInputChannelTypeId");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdLessThan(String value) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID <", value, "alarmInputChannelTypeId");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdLessThanOrEqualTo(String value) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID <=", value, "alarmInputChannelTypeId");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdLike(String value) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID like", value, "alarmInputChannelTypeId");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdNotLike(String value) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID not like", value, "alarmInputChannelTypeId");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdIn(List values) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID in", values, "alarmInputChannelTypeId");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdNotIn(List values) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID not in", values, "alarmInputChannelTypeId");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdBetween(String value1, String value2) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID between", value1, value2, "alarmInputChannelTypeId");
            return this;
        }

        public Criteria andAlarmInputChannelTypeIdNotBetween(String value1, String value2) {
            addCriterion("ALARM_INPUT_CHANNEL_TYPE_ID not between", value1, value2, "alarmInputChannelTypeId");
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