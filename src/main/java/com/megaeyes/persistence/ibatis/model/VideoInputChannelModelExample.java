package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoInputChannelModelExample {
    protected String orderByClause;

    protected List oredCriteria;

    public VideoInputChannelModelExample() {
        oredCriteria = new ArrayList();
    }

    protected VideoInputChannelModelExample(VideoInputChannelModelExample example) {
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

        public Criteria andManufacturerIdIsNull() {
            addCriterion("MANUFACTURER_ID is null");
            return this;
        }

        public Criteria andManufacturerIdIsNotNull() {
            addCriterion("MANUFACTURER_ID is not null");
            return this;
        }

        public Criteria andManufacturerIdEqualTo(String value) {
            addCriterion("MANUFACTURER_ID =", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdNotEqualTo(String value) {
            addCriterion("MANUFACTURER_ID <>", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdGreaterThan(String value) {
            addCriterion("MANUFACTURER_ID >", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdGreaterThanOrEqualTo(String value) {
            addCriterion("MANUFACTURER_ID >=", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdLessThan(String value) {
            addCriterion("MANUFACTURER_ID <", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdLessThanOrEqualTo(String value) {
            addCriterion("MANUFACTURER_ID <=", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdLike(String value) {
            addCriterion("MANUFACTURER_ID like", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdNotLike(String value) {
            addCriterion("MANUFACTURER_ID not like", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdIn(List values) {
            addCriterion("MANUFACTURER_ID in", values, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdNotIn(List values) {
            addCriterion("MANUFACTURER_ID not in", values, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdBetween(String value1, String value2) {
            addCriterion("MANUFACTURER_ID between", value1, value2, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdNotBetween(String value1, String value2) {
            addCriterion("MANUFACTURER_ID not between", value1, value2, "manufacturerId");
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

        public Criteria andHasPtzIsNull() {
            addCriterion("HAS_PTZ is null");
            return this;
        }

        public Criteria andHasPtzIsNotNull() {
            addCriterion("HAS_PTZ is not null");
            return this;
        }

        public Criteria andHasPtzEqualTo(Short value) {
            addCriterion("HAS_PTZ =", value, "hasPtz");
            return this;
        }

        public Criteria andHasPtzNotEqualTo(Short value) {
            addCriterion("HAS_PTZ <>", value, "hasPtz");
            return this;
        }

        public Criteria andHasPtzGreaterThan(Short value) {
            addCriterion("HAS_PTZ >", value, "hasPtz");
            return this;
        }

        public Criteria andHasPtzGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ >=", value, "hasPtz");
            return this;
        }

        public Criteria andHasPtzLessThan(Short value) {
            addCriterion("HAS_PTZ <", value, "hasPtz");
            return this;
        }

        public Criteria andHasPtzLessThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ <=", value, "hasPtz");
            return this;
        }

        public Criteria andHasPtzIn(List values) {
            addCriterion("HAS_PTZ in", values, "hasPtz");
            return this;
        }

        public Criteria andHasPtzNotIn(List values) {
            addCriterion("HAS_PTZ not in", values, "hasPtz");
            return this;
        }

        public Criteria andHasPtzBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ between", value1, value2, "hasPtz");
            return this;
        }

        public Criteria andHasPtzNotBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ not between", value1, value2, "hasPtz");
            return this;
        }

        public Criteria andHasPtzApertureIsNull() {
            addCriterion("HAS_PTZ_APERTURE is null");
            return this;
        }

        public Criteria andHasPtzApertureIsNotNull() {
            addCriterion("HAS_PTZ_APERTURE is not null");
            return this;
        }

        public Criteria andHasPtzApertureEqualTo(Short value) {
            addCriterion("HAS_PTZ_APERTURE =", value, "hasPtzAperture");
            return this;
        }

        public Criteria andHasPtzApertureNotEqualTo(Short value) {
            addCriterion("HAS_PTZ_APERTURE <>", value, "hasPtzAperture");
            return this;
        }

        public Criteria andHasPtzApertureGreaterThan(Short value) {
            addCriterion("HAS_PTZ_APERTURE >", value, "hasPtzAperture");
            return this;
        }

        public Criteria andHasPtzApertureGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_APERTURE >=", value, "hasPtzAperture");
            return this;
        }

        public Criteria andHasPtzApertureLessThan(Short value) {
            addCriterion("HAS_PTZ_APERTURE <", value, "hasPtzAperture");
            return this;
        }

        public Criteria andHasPtzApertureLessThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_APERTURE <=", value, "hasPtzAperture");
            return this;
        }

        public Criteria andHasPtzApertureIn(List values) {
            addCriterion("HAS_PTZ_APERTURE in", values, "hasPtzAperture");
            return this;
        }

        public Criteria andHasPtzApertureNotIn(List values) {
            addCriterion("HAS_PTZ_APERTURE not in", values, "hasPtzAperture");
            return this;
        }

        public Criteria andHasPtzApertureBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_APERTURE between", value1, value2, "hasPtzAperture");
            return this;
        }

        public Criteria andHasPtzApertureNotBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_APERTURE not between", value1, value2, "hasPtzAperture");
            return this;
        }

        public Criteria andHasPtzFociIsNull() {
            addCriterion("HAS_PTZ_FOCI is null");
            return this;
        }

        public Criteria andHasPtzFociIsNotNull() {
            addCriterion("HAS_PTZ_FOCI is not null");
            return this;
        }

        public Criteria andHasPtzFociEqualTo(Short value) {
            addCriterion("HAS_PTZ_FOCI =", value, "hasPtzFoci");
            return this;
        }

        public Criteria andHasPtzFociNotEqualTo(Short value) {
            addCriterion("HAS_PTZ_FOCI <>", value, "hasPtzFoci");
            return this;
        }

        public Criteria andHasPtzFociGreaterThan(Short value) {
            addCriterion("HAS_PTZ_FOCI >", value, "hasPtzFoci");
            return this;
        }

        public Criteria andHasPtzFociGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_FOCI >=", value, "hasPtzFoci");
            return this;
        }

        public Criteria andHasPtzFociLessThan(Short value) {
            addCriterion("HAS_PTZ_FOCI <", value, "hasPtzFoci");
            return this;
        }

        public Criteria andHasPtzFociLessThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_FOCI <=", value, "hasPtzFoci");
            return this;
        }

        public Criteria andHasPtzFociIn(List values) {
            addCriterion("HAS_PTZ_FOCI in", values, "hasPtzFoci");
            return this;
        }

        public Criteria andHasPtzFociNotIn(List values) {
            addCriterion("HAS_PTZ_FOCI not in", values, "hasPtzFoci");
            return this;
        }

        public Criteria andHasPtzFociBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_FOCI between", value1, value2, "hasPtzFoci");
            return this;
        }

        public Criteria andHasPtzFociNotBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_FOCI not between", value1, value2, "hasPtzFoci");
            return this;
        }

        public Criteria andHasPtzZoomIsNull() {
            addCriterion("HAS_PTZ_ZOOM is null");
            return this;
        }

        public Criteria andHasPtzZoomIsNotNull() {
            addCriterion("HAS_PTZ_ZOOM is not null");
            return this;
        }

        public Criteria andHasPtzZoomEqualTo(Short value) {
            addCriterion("HAS_PTZ_ZOOM =", value, "hasPtzZoom");
            return this;
        }

        public Criteria andHasPtzZoomNotEqualTo(Short value) {
            addCriterion("HAS_PTZ_ZOOM <>", value, "hasPtzZoom");
            return this;
        }

        public Criteria andHasPtzZoomGreaterThan(Short value) {
            addCriterion("HAS_PTZ_ZOOM >", value, "hasPtzZoom");
            return this;
        }

        public Criteria andHasPtzZoomGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_ZOOM >=", value, "hasPtzZoom");
            return this;
        }

        public Criteria andHasPtzZoomLessThan(Short value) {
            addCriterion("HAS_PTZ_ZOOM <", value, "hasPtzZoom");
            return this;
        }

        public Criteria andHasPtzZoomLessThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_ZOOM <=", value, "hasPtzZoom");
            return this;
        }

        public Criteria andHasPtzZoomIn(List values) {
            addCriterion("HAS_PTZ_ZOOM in", values, "hasPtzZoom");
            return this;
        }

        public Criteria andHasPtzZoomNotIn(List values) {
            addCriterion("HAS_PTZ_ZOOM not in", values, "hasPtzZoom");
            return this;
        }

        public Criteria andHasPtzZoomBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_ZOOM between", value1, value2, "hasPtzZoom");
            return this;
        }

        public Criteria andHasPtzZoomNotBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_ZOOM not between", value1, value2, "hasPtzZoom");
            return this;
        }

        public Criteria andHasPtzAsw1IsNull() {
            addCriterion("HAS_PTZ_ASW_1 is null");
            return this;
        }

        public Criteria andHasPtzAsw1IsNotNull() {
            addCriterion("HAS_PTZ_ASW_1 is not null");
            return this;
        }

        public Criteria andHasPtzAsw1EqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_1 =", value, "hasPtzAsw1");
            return this;
        }

        public Criteria andHasPtzAsw1NotEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_1 <>", value, "hasPtzAsw1");
            return this;
        }

        public Criteria andHasPtzAsw1GreaterThan(Short value) {
            addCriterion("HAS_PTZ_ASW_1 >", value, "hasPtzAsw1");
            return this;
        }

        public Criteria andHasPtzAsw1GreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_1 >=", value, "hasPtzAsw1");
            return this;
        }

        public Criteria andHasPtzAsw1LessThan(Short value) {
            addCriterion("HAS_PTZ_ASW_1 <", value, "hasPtzAsw1");
            return this;
        }

        public Criteria andHasPtzAsw1LessThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_1 <=", value, "hasPtzAsw1");
            return this;
        }

        public Criteria andHasPtzAsw1In(List values) {
            addCriterion("HAS_PTZ_ASW_1 in", values, "hasPtzAsw1");
            return this;
        }

        public Criteria andHasPtzAsw1NotIn(List values) {
            addCriterion("HAS_PTZ_ASW_1 not in", values, "hasPtzAsw1");
            return this;
        }

        public Criteria andHasPtzAsw1Between(Short value1, Short value2) {
            addCriterion("HAS_PTZ_ASW_1 between", value1, value2, "hasPtzAsw1");
            return this;
        }

        public Criteria andHasPtzAsw1NotBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_ASW_1 not between", value1, value2, "hasPtzAsw1");
            return this;
        }

        public Criteria andHasPtzAsw2IsNull() {
            addCriterion("HAS_PTZ_ASW_2 is null");
            return this;
        }

        public Criteria andHasPtzAsw2IsNotNull() {
            addCriterion("HAS_PTZ_ASW_2 is not null");
            return this;
        }

        public Criteria andHasPtzAsw2EqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_2 =", value, "hasPtzAsw2");
            return this;
        }

        public Criteria andHasPtzAsw2NotEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_2 <>", value, "hasPtzAsw2");
            return this;
        }

        public Criteria andHasPtzAsw2GreaterThan(Short value) {
            addCriterion("HAS_PTZ_ASW_2 >", value, "hasPtzAsw2");
            return this;
        }

        public Criteria andHasPtzAsw2GreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_2 >=", value, "hasPtzAsw2");
            return this;
        }

        public Criteria andHasPtzAsw2LessThan(Short value) {
            addCriterion("HAS_PTZ_ASW_2 <", value, "hasPtzAsw2");
            return this;
        }

        public Criteria andHasPtzAsw2LessThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_2 <=", value, "hasPtzAsw2");
            return this;
        }

        public Criteria andHasPtzAsw2In(List values) {
            addCriterion("HAS_PTZ_ASW_2 in", values, "hasPtzAsw2");
            return this;
        }

        public Criteria andHasPtzAsw2NotIn(List values) {
            addCriterion("HAS_PTZ_ASW_2 not in", values, "hasPtzAsw2");
            return this;
        }

        public Criteria andHasPtzAsw2Between(Short value1, Short value2) {
            addCriterion("HAS_PTZ_ASW_2 between", value1, value2, "hasPtzAsw2");
            return this;
        }

        public Criteria andHasPtzAsw2NotBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_ASW_2 not between", value1, value2, "hasPtzAsw2");
            return this;
        }

        public Criteria andHasPtzAsw3IsNull() {
            addCriterion("HAS_PTZ_ASW_3 is null");
            return this;
        }

        public Criteria andHasPtzAsw3IsNotNull() {
            addCriterion("HAS_PTZ_ASW_3 is not null");
            return this;
        }

        public Criteria andHasPtzAsw3EqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_3 =", value, "hasPtzAsw3");
            return this;
        }

        public Criteria andHasPtzAsw3NotEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_3 <>", value, "hasPtzAsw3");
            return this;
        }

        public Criteria andHasPtzAsw3GreaterThan(Short value) {
            addCriterion("HAS_PTZ_ASW_3 >", value, "hasPtzAsw3");
            return this;
        }

        public Criteria andHasPtzAsw3GreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_3 >=", value, "hasPtzAsw3");
            return this;
        }

        public Criteria andHasPtzAsw3LessThan(Short value) {
            addCriterion("HAS_PTZ_ASW_3 <", value, "hasPtzAsw3");
            return this;
        }

        public Criteria andHasPtzAsw3LessThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_3 <=", value, "hasPtzAsw3");
            return this;
        }

        public Criteria andHasPtzAsw3In(List values) {
            addCriterion("HAS_PTZ_ASW_3 in", values, "hasPtzAsw3");
            return this;
        }

        public Criteria andHasPtzAsw3NotIn(List values) {
            addCriterion("HAS_PTZ_ASW_3 not in", values, "hasPtzAsw3");
            return this;
        }

        public Criteria andHasPtzAsw3Between(Short value1, Short value2) {
            addCriterion("HAS_PTZ_ASW_3 between", value1, value2, "hasPtzAsw3");
            return this;
        }

        public Criteria andHasPtzAsw3NotBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_ASW_3 not between", value1, value2, "hasPtzAsw3");
            return this;
        }

        public Criteria andHasPtzAsw4IsNull() {
            addCriterion("HAS_PTZ_ASW_4 is null");
            return this;
        }

        public Criteria andHasPtzAsw4IsNotNull() {
            addCriterion("HAS_PTZ_ASW_4 is not null");
            return this;
        }

        public Criteria andHasPtzAsw4EqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_4 =", value, "hasPtzAsw4");
            return this;
        }

        public Criteria andHasPtzAsw4NotEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_4 <>", value, "hasPtzAsw4");
            return this;
        }

        public Criteria andHasPtzAsw4GreaterThan(Short value) {
            addCriterion("HAS_PTZ_ASW_4 >", value, "hasPtzAsw4");
            return this;
        }

        public Criteria andHasPtzAsw4GreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_4 >=", value, "hasPtzAsw4");
            return this;
        }

        public Criteria andHasPtzAsw4LessThan(Short value) {
            addCriterion("HAS_PTZ_ASW_4 <", value, "hasPtzAsw4");
            return this;
        }

        public Criteria andHasPtzAsw4LessThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_ASW_4 <=", value, "hasPtzAsw4");
            return this;
        }

        public Criteria andHasPtzAsw4In(List values) {
            addCriterion("HAS_PTZ_ASW_4 in", values, "hasPtzAsw4");
            return this;
        }

        public Criteria andHasPtzAsw4NotIn(List values) {
            addCriterion("HAS_PTZ_ASW_4 not in", values, "hasPtzAsw4");
            return this;
        }

        public Criteria andHasPtzAsw4Between(Short value1, Short value2) {
            addCriterion("HAS_PTZ_ASW_4 between", value1, value2, "hasPtzAsw4");
            return this;
        }

        public Criteria andHasPtzAsw4NotBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_ASW_4 not between", value1, value2, "hasPtzAsw4");
            return this;
        }

        public Criteria andHasPtzAutoIsNull() {
            addCriterion("HAS_PTZ_AUTO is null");
            return this;
        }

        public Criteria andHasPtzAutoIsNotNull() {
            addCriterion("HAS_PTZ_AUTO is not null");
            return this;
        }

        public Criteria andHasPtzAutoEqualTo(Short value) {
            addCriterion("HAS_PTZ_AUTO =", value, "hasPtzAuto");
            return this;
        }

        public Criteria andHasPtzAutoNotEqualTo(Short value) {
            addCriterion("HAS_PTZ_AUTO <>", value, "hasPtzAuto");
            return this;
        }

        public Criteria andHasPtzAutoGreaterThan(Short value) {
            addCriterion("HAS_PTZ_AUTO >", value, "hasPtzAuto");
            return this;
        }

        public Criteria andHasPtzAutoGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_AUTO >=", value, "hasPtzAuto");
            return this;
        }

        public Criteria andHasPtzAutoLessThan(Short value) {
            addCriterion("HAS_PTZ_AUTO <", value, "hasPtzAuto");
            return this;
        }

        public Criteria andHasPtzAutoLessThanOrEqualTo(Short value) {
            addCriterion("HAS_PTZ_AUTO <=", value, "hasPtzAuto");
            return this;
        }

        public Criteria andHasPtzAutoIn(List values) {
            addCriterion("HAS_PTZ_AUTO in", values, "hasPtzAuto");
            return this;
        }

        public Criteria andHasPtzAutoNotIn(List values) {
            addCriterion("HAS_PTZ_AUTO not in", values, "hasPtzAuto");
            return this;
        }

        public Criteria andHasPtzAutoBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_AUTO between", value1, value2, "hasPtzAuto");
            return this;
        }

        public Criteria andHasPtzAutoNotBetween(Short value1, Short value2) {
            addCriterion("HAS_PTZ_AUTO not between", value1, value2, "hasPtzAuto");
            return this;
        }

        public Criteria andHasSenseIsNull() {
            addCriterion("HAS_SENSE is null");
            return this;
        }

        public Criteria andHasSenseIsNotNull() {
            addCriterion("HAS_SENSE is not null");
            return this;
        }

        public Criteria andHasSenseEqualTo(Short value) {
            addCriterion("HAS_SENSE =", value, "hasSense");
            return this;
        }

        public Criteria andHasSenseNotEqualTo(Short value) {
            addCriterion("HAS_SENSE <>", value, "hasSense");
            return this;
        }

        public Criteria andHasSenseGreaterThan(Short value) {
            addCriterion("HAS_SENSE >", value, "hasSense");
            return this;
        }

        public Criteria andHasSenseGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_SENSE >=", value, "hasSense");
            return this;
        }

        public Criteria andHasSenseLessThan(Short value) {
            addCriterion("HAS_SENSE <", value, "hasSense");
            return this;
        }

        public Criteria andHasSenseLessThanOrEqualTo(Short value) {
            addCriterion("HAS_SENSE <=", value, "hasSense");
            return this;
        }

        public Criteria andHasSenseIn(List values) {
            addCriterion("HAS_SENSE in", values, "hasSense");
            return this;
        }

        public Criteria andHasSenseNotIn(List values) {
            addCriterion("HAS_SENSE not in", values, "hasSense");
            return this;
        }

        public Criteria andHasSenseBetween(Short value1, Short value2) {
            addCriterion("HAS_SENSE between", value1, value2, "hasSense");
            return this;
        }

        public Criteria andHasSenseNotBetween(Short value1, Short value2) {
            addCriterion("HAS_SENSE not between", value1, value2, "hasSense");
            return this;
        }

        public Criteria andHasShelterIsNull() {
            addCriterion("HAS_SHELTER is null");
            return this;
        }

        public Criteria andHasShelterIsNotNull() {
            addCriterion("HAS_SHELTER is not null");
            return this;
        }

        public Criteria andHasShelterEqualTo(Short value) {
            addCriterion("HAS_SHELTER =", value, "hasShelter");
            return this;
        }

        public Criteria andHasShelterNotEqualTo(Short value) {
            addCriterion("HAS_SHELTER <>", value, "hasShelter");
            return this;
        }

        public Criteria andHasShelterGreaterThan(Short value) {
            addCriterion("HAS_SHELTER >", value, "hasShelter");
            return this;
        }

        public Criteria andHasShelterGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_SHELTER >=", value, "hasShelter");
            return this;
        }

        public Criteria andHasShelterLessThan(Short value) {
            addCriterion("HAS_SHELTER <", value, "hasShelter");
            return this;
        }

        public Criteria andHasShelterLessThanOrEqualTo(Short value) {
            addCriterion("HAS_SHELTER <=", value, "hasShelter");
            return this;
        }

        public Criteria andHasShelterIn(List values) {
            addCriterion("HAS_SHELTER in", values, "hasShelter");
            return this;
        }

        public Criteria andHasShelterNotIn(List values) {
            addCriterion("HAS_SHELTER not in", values, "hasShelter");
            return this;
        }

        public Criteria andHasShelterBetween(Short value1, Short value2) {
            addCriterion("HAS_SHELTER between", value1, value2, "hasShelter");
            return this;
        }

        public Criteria andHasShelterNotBetween(Short value1, Short value2) {
            addCriterion("HAS_SHELTER not between", value1, value2, "hasShelter");
            return this;
        }

        public Criteria andHasTimeLabelIsNull() {
            addCriterion("HAS_TIME_LABEL is null");
            return this;
        }

        public Criteria andHasTimeLabelIsNotNull() {
            addCriterion("HAS_TIME_LABEL is not null");
            return this;
        }

        public Criteria andHasTimeLabelEqualTo(Short value) {
            addCriterion("HAS_TIME_LABEL =", value, "hasTimeLabel");
            return this;
        }

        public Criteria andHasTimeLabelNotEqualTo(Short value) {
            addCriterion("HAS_TIME_LABEL <>", value, "hasTimeLabel");
            return this;
        }

        public Criteria andHasTimeLabelGreaterThan(Short value) {
            addCriterion("HAS_TIME_LABEL >", value, "hasTimeLabel");
            return this;
        }

        public Criteria andHasTimeLabelGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_TIME_LABEL >=", value, "hasTimeLabel");
            return this;
        }

        public Criteria andHasTimeLabelLessThan(Short value) {
            addCriterion("HAS_TIME_LABEL <", value, "hasTimeLabel");
            return this;
        }

        public Criteria andHasTimeLabelLessThanOrEqualTo(Short value) {
            addCriterion("HAS_TIME_LABEL <=", value, "hasTimeLabel");
            return this;
        }

        public Criteria andHasTimeLabelIn(List values) {
            addCriterion("HAS_TIME_LABEL in", values, "hasTimeLabel");
            return this;
        }

        public Criteria andHasTimeLabelNotIn(List values) {
            addCriterion("HAS_TIME_LABEL not in", values, "hasTimeLabel");
            return this;
        }

        public Criteria andHasTimeLabelBetween(Short value1, Short value2) {
            addCriterion("HAS_TIME_LABEL between", value1, value2, "hasTimeLabel");
            return this;
        }

        public Criteria andHasTimeLabelNotBetween(Short value1, Short value2) {
            addCriterion("HAS_TIME_LABEL not between", value1, value2, "hasTimeLabel");
            return this;
        }

        public Criteria andHasTextLabelIsNull() {
            addCriterion("HAS_TEXT_LABEL is null");
            return this;
        }

        public Criteria andHasTextLabelIsNotNull() {
            addCriterion("HAS_TEXT_LABEL is not null");
            return this;
        }

        public Criteria andHasTextLabelEqualTo(Short value) {
            addCriterion("HAS_TEXT_LABEL =", value, "hasTextLabel");
            return this;
        }

        public Criteria andHasTextLabelNotEqualTo(Short value) {
            addCriterion("HAS_TEXT_LABEL <>", value, "hasTextLabel");
            return this;
        }

        public Criteria andHasTextLabelGreaterThan(Short value) {
            addCriterion("HAS_TEXT_LABEL >", value, "hasTextLabel");
            return this;
        }

        public Criteria andHasTextLabelGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_TEXT_LABEL >=", value, "hasTextLabel");
            return this;
        }

        public Criteria andHasTextLabelLessThan(Short value) {
            addCriterion("HAS_TEXT_LABEL <", value, "hasTextLabel");
            return this;
        }

        public Criteria andHasTextLabelLessThanOrEqualTo(Short value) {
            addCriterion("HAS_TEXT_LABEL <=", value, "hasTextLabel");
            return this;
        }

        public Criteria andHasTextLabelIn(List values) {
            addCriterion("HAS_TEXT_LABEL in", values, "hasTextLabel");
            return this;
        }

        public Criteria andHasTextLabelNotIn(List values) {
            addCriterion("HAS_TEXT_LABEL not in", values, "hasTextLabel");
            return this;
        }

        public Criteria andHasTextLabelBetween(Short value1, Short value2) {
            addCriterion("HAS_TEXT_LABEL between", value1, value2, "hasTextLabel");
            return this;
        }

        public Criteria andHasTextLabelNotBetween(Short value1, Short value2) {
            addCriterion("HAS_TEXT_LABEL not between", value1, value2, "hasTextLabel");
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
    }
}