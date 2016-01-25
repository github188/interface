package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpRDeviceVicExample {
    protected String orderByClause;

    protected List oredCriteria;

    public EpRDeviceVicExample() {
        oredCriteria = new ArrayList();
    }

    protected EpRDeviceVicExample(EpRDeviceVicExample example) {
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("DEVICE_ID is null");
            return this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("DEVICE_ID is not null");
            return this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("DEVICE_ID =", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("DEVICE_ID <>", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("DEVICE_ID >", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_ID >=", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("DEVICE_ID <", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_ID <=", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("DEVICE_ID like", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("DEVICE_ID not like", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdIn(List values) {
            addCriterion("DEVICE_ID in", values, "deviceId");
            return this;
        }

        public Criteria andDeviceIdNotIn(List values) {
            addCriterion("DEVICE_ID not in", values, "deviceId");
            return this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("DEVICE_ID between", value1, value2, "deviceId");
            return this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("DEVICE_ID not between", value1, value2, "deviceId");
            return this;
        }

        public Criteria andVicIdIsNull() {
            addCriterion("VIC_ID is null");
            return this;
        }

        public Criteria andVicIdIsNotNull() {
            addCriterion("VIC_ID is not null");
            return this;
        }

        public Criteria andVicIdEqualTo(String value) {
            addCriterion("VIC_ID =", value, "vicId");
            return this;
        }

        public Criteria andVicIdNotEqualTo(String value) {
            addCriterion("VIC_ID <>", value, "vicId");
            return this;
        }

        public Criteria andVicIdGreaterThan(String value) {
            addCriterion("VIC_ID >", value, "vicId");
            return this;
        }

        public Criteria andVicIdGreaterThanOrEqualTo(String value) {
            addCriterion("VIC_ID >=", value, "vicId");
            return this;
        }

        public Criteria andVicIdLessThan(String value) {
            addCriterion("VIC_ID <", value, "vicId");
            return this;
        }

        public Criteria andVicIdLessThanOrEqualTo(String value) {
            addCriterion("VIC_ID <=", value, "vicId");
            return this;
        }

        public Criteria andVicIdLike(String value) {
            addCriterion("VIC_ID like", value, "vicId");
            return this;
        }

        public Criteria andVicIdNotLike(String value) {
            addCriterion("VIC_ID not like", value, "vicId");
            return this;
        }

        public Criteria andVicIdIn(List values) {
            addCriterion("VIC_ID in", values, "vicId");
            return this;
        }

        public Criteria andVicIdNotIn(List values) {
            addCriterion("VIC_ID not in", values, "vicId");
            return this;
        }

        public Criteria andVicIdBetween(String value1, String value2) {
            addCriterion("VIC_ID between", value1, value2, "vicId");
            return this;
        }

        public Criteria andVicIdNotBetween(String value1, String value2) {
            addCriterion("VIC_ID not between", value1, value2, "vicId");
            return this;
        }

        public Criteria andPresetIdIsNull() {
            addCriterion("PRESET_ID is null");
            return this;
        }

        public Criteria andPresetIdIsNotNull() {
            addCriterion("PRESET_ID is not null");
            return this;
        }

        public Criteria andPresetIdEqualTo(String value) {
            addCriterion("PRESET_ID =", value, "presetId");
            return this;
        }

        public Criteria andPresetIdNotEqualTo(String value) {
            addCriterion("PRESET_ID <>", value, "presetId");
            return this;
        }

        public Criteria andPresetIdGreaterThan(String value) {
            addCriterion("PRESET_ID >", value, "presetId");
            return this;
        }

        public Criteria andPresetIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRESET_ID >=", value, "presetId");
            return this;
        }

        public Criteria andPresetIdLessThan(String value) {
            addCriterion("PRESET_ID <", value, "presetId");
            return this;
        }

        public Criteria andPresetIdLessThanOrEqualTo(String value) {
            addCriterion("PRESET_ID <=", value, "presetId");
            return this;
        }

        public Criteria andPresetIdLike(String value) {
            addCriterion("PRESET_ID like", value, "presetId");
            return this;
        }

        public Criteria andPresetIdNotLike(String value) {
            addCriterion("PRESET_ID not like", value, "presetId");
            return this;
        }

        public Criteria andPresetIdIn(List values) {
            addCriterion("PRESET_ID in", values, "presetId");
            return this;
        }

        public Criteria andPresetIdNotIn(List values) {
            addCriterion("PRESET_ID not in", values, "presetId");
            return this;
        }

        public Criteria andPresetIdBetween(String value1, String value2) {
            addCriterion("PRESET_ID between", value1, value2, "presetId");
            return this;
        }

        public Criteria andPresetIdNotBetween(String value1, String value2) {
            addCriterion("PRESET_ID not between", value1, value2, "presetId");
            return this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("TASK_TYPE is null");
            return this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("TASK_TYPE is not null");
            return this;
        }

        public Criteria andTaskTypeEqualTo(BigDecimal value) {
            addCriterion("TASK_TYPE =", value, "taskType");
            return this;
        }

        public Criteria andTaskTypeNotEqualTo(BigDecimal value) {
            addCriterion("TASK_TYPE <>", value, "taskType");
            return this;
        }

        public Criteria andTaskTypeGreaterThan(BigDecimal value) {
            addCriterion("TASK_TYPE >", value, "taskType");
            return this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TASK_TYPE >=", value, "taskType");
            return this;
        }

        public Criteria andTaskTypeLessThan(BigDecimal value) {
            addCriterion("TASK_TYPE <", value, "taskType");
            return this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TASK_TYPE <=", value, "taskType");
            return this;
        }

        public Criteria andTaskTypeIn(List values) {
            addCriterion("TASK_TYPE in", values, "taskType");
            return this;
        }

        public Criteria andTaskTypeNotIn(List values) {
            addCriterion("TASK_TYPE not in", values, "taskType");
            return this;
        }

        public Criteria andTaskTypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TASK_TYPE between", value1, value2, "taskType");
            return this;
        }

        public Criteria andTaskTypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TASK_TYPE not between", value1, value2, "taskType");
            return this;
        }

        public Criteria andStepIdIsNull() {
            addCriterion("STEP_ID is null");
            return this;
        }

        public Criteria andStepIdIsNotNull() {
            addCriterion("STEP_ID is not null");
            return this;
        }

        public Criteria andStepIdEqualTo(String value) {
            addCriterion("STEP_ID =", value, "stepId");
            return this;
        }

        public Criteria andStepIdNotEqualTo(String value) {
            addCriterion("STEP_ID <>", value, "stepId");
            return this;
        }

        public Criteria andStepIdGreaterThan(String value) {
            addCriterion("STEP_ID >", value, "stepId");
            return this;
        }

        public Criteria andStepIdGreaterThanOrEqualTo(String value) {
            addCriterion("STEP_ID >=", value, "stepId");
            return this;
        }

        public Criteria andStepIdLessThan(String value) {
            addCriterion("STEP_ID <", value, "stepId");
            return this;
        }

        public Criteria andStepIdLessThanOrEqualTo(String value) {
            addCriterion("STEP_ID <=", value, "stepId");
            return this;
        }

        public Criteria andStepIdLike(String value) {
            addCriterion("STEP_ID like", value, "stepId");
            return this;
        }

        public Criteria andStepIdNotLike(String value) {
            addCriterion("STEP_ID not like", value, "stepId");
            return this;
        }

        public Criteria andStepIdIn(List values) {
            addCriterion("STEP_ID in", values, "stepId");
            return this;
        }

        public Criteria andStepIdNotIn(List values) {
            addCriterion("STEP_ID not in", values, "stepId");
            return this;
        }

        public Criteria andStepIdBetween(String value1, String value2) {
            addCriterion("STEP_ID between", value1, value2, "stepId");
            return this;
        }

        public Criteria andStepIdNotBetween(String value1, String value2) {
            addCriterion("STEP_ID not between", value1, value2, "stepId");
            return this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("IS_DEFAULT is null");
            return this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("IS_DEFAULT is not null");
            return this;
        }

        public Criteria andIsDefaultEqualTo(Short value) {
            addCriterion("IS_DEFAULT =", value, "isDefault");
            return this;
        }

        public Criteria andIsDefaultNotEqualTo(Short value) {
            addCriterion("IS_DEFAULT <>", value, "isDefault");
            return this;
        }

        public Criteria andIsDefaultGreaterThan(Short value) {
            addCriterion("IS_DEFAULT >", value, "isDefault");
            return this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_DEFAULT >=", value, "isDefault");
            return this;
        }

        public Criteria andIsDefaultLessThan(Short value) {
            addCriterion("IS_DEFAULT <", value, "isDefault");
            return this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Short value) {
            addCriterion("IS_DEFAULT <=", value, "isDefault");
            return this;
        }

        public Criteria andIsDefaultIn(List values) {
            addCriterion("IS_DEFAULT in", values, "isDefault");
            return this;
        }

        public Criteria andIsDefaultNotIn(List values) {
            addCriterion("IS_DEFAULT not in", values, "isDefault");
            return this;
        }

        public Criteria andIsDefaultBetween(Short value1, Short value2) {
            addCriterion("IS_DEFAULT between", value1, value2, "isDefault");
            return this;
        }

        public Criteria andIsDefaultNotBetween(Short value1, Short value2) {
            addCriterion("IS_DEFAULT not between", value1, value2, "isDefault");
            return this;
        }
    }
}