package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoOutputChannelExample {
    protected String orderByClause;

    protected List oredCriteria;

    public VideoOutputChannelExample() {
        oredCriteria = new ArrayList();
    }

    protected VideoOutputChannelExample(VideoOutputChannelExample example) {
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

        public Criteria andVideoDisplayDeviceIdIsNull() {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID is null");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdIsNotNull() {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID is not null");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdEqualTo(String value) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID =", value, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdNotEqualTo(String value) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID <>", value, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdGreaterThan(String value) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID >", value, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID >=", value, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdLessThan(String value) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID <", value, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID <=", value, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdLike(String value) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID like", value, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdNotLike(String value) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID not like", value, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdIn(List values) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID in", values, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdNotIn(List values) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID not in", values, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdBetween(String value1, String value2) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID between", value1, value2, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andVideoDisplayDeviceIdNotBetween(String value1, String value2) {
            addCriterion("VIDEO_DISPLAY_DEVICE_ID not between", value1, value2, "videoDisplayDeviceId");
            return this;
        }

        public Criteria andAddressNumberIsNull() {
            addCriterion("ADDRESS_NUMBER is null");
            return this;
        }

        public Criteria andAddressNumberIsNotNull() {
            addCriterion("ADDRESS_NUMBER is not null");
            return this;
        }

        public Criteria andAddressNumberEqualTo(String value) {
            addCriterion("ADDRESS_NUMBER =", value, "addressNumber");
            return this;
        }

        public Criteria andAddressNumberNotEqualTo(String value) {
            addCriterion("ADDRESS_NUMBER <>", value, "addressNumber");
            return this;
        }

        public Criteria andAddressNumberGreaterThan(String value) {
            addCriterion("ADDRESS_NUMBER >", value, "addressNumber");
            return this;
        }

        public Criteria andAddressNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS_NUMBER >=", value, "addressNumber");
            return this;
        }

        public Criteria andAddressNumberLessThan(String value) {
            addCriterion("ADDRESS_NUMBER <", value, "addressNumber");
            return this;
        }

        public Criteria andAddressNumberLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS_NUMBER <=", value, "addressNumber");
            return this;
        }

        public Criteria andAddressNumberLike(String value) {
            addCriterion("ADDRESS_NUMBER like", value, "addressNumber");
            return this;
        }

        public Criteria andAddressNumberNotLike(String value) {
            addCriterion("ADDRESS_NUMBER not like", value, "addressNumber");
            return this;
        }

        public Criteria andAddressNumberIn(List values) {
            addCriterion("ADDRESS_NUMBER in", values, "addressNumber");
            return this;
        }

        public Criteria andAddressNumberNotIn(List values) {
            addCriterion("ADDRESS_NUMBER not in", values, "addressNumber");
            return this;
        }

        public Criteria andAddressNumberBetween(String value1, String value2) {
            addCriterion("ADDRESS_NUMBER between", value1, value2, "addressNumber");
            return this;
        }

        public Criteria andAddressNumberNotBetween(String value1, String value2) {
            addCriterion("ADDRESS_NUMBER not between", value1, value2, "addressNumber");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdIsNull() {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID is null");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdIsNotNull() {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID is not null");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdEqualTo(String value) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID =", value, "videoOutputChannelModelId");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdNotEqualTo(String value) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID <>", value, "videoOutputChannelModelId");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdGreaterThan(String value) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID >", value, "videoOutputChannelModelId");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID >=", value, "videoOutputChannelModelId");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdLessThan(String value) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID <", value, "videoOutputChannelModelId");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID <=", value, "videoOutputChannelModelId");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdLike(String value) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID like", value, "videoOutputChannelModelId");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdNotLike(String value) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID not like", value, "videoOutputChannelModelId");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdIn(List values) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID in", values, "videoOutputChannelModelId");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdNotIn(List values) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID not in", values, "videoOutputChannelModelId");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdBetween(String value1, String value2) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID between", value1, value2, "videoOutputChannelModelId");
            return this;
        }

        public Criteria andVideoOutputChannelModelIdNotBetween(String value1, String value2) {
            addCriterion("VIDEO_OUTPUT_CHANNEL_MODEL_ID not between", value1, value2, "videoOutputChannelModelId");
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
    }
}