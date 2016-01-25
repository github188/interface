package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpRTaskstepMonitorExample {
    protected String orderByClause;

    protected List oredCriteria;

    public EpRTaskstepMonitorExample() {
        oredCriteria = new ArrayList();
    }

    protected EpRTaskstepMonitorExample(EpRTaskstepMonitorExample example) {
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

        public Criteria andMonitorIdIsNull() {
            addCriterion("MONITOR_ID is null");
            return this;
        }

        public Criteria andMonitorIdIsNotNull() {
            addCriterion("MONITOR_ID is not null");
            return this;
        }

        public Criteria andMonitorIdEqualTo(String value) {
            addCriterion("MONITOR_ID =", value, "monitorId");
            return this;
        }

        public Criteria andMonitorIdNotEqualTo(String value) {
            addCriterion("MONITOR_ID <>", value, "monitorId");
            return this;
        }

        public Criteria andMonitorIdGreaterThan(String value) {
            addCriterion("MONITOR_ID >", value, "monitorId");
            return this;
        }

        public Criteria andMonitorIdGreaterThanOrEqualTo(String value) {
            addCriterion("MONITOR_ID >=", value, "monitorId");
            return this;
        }

        public Criteria andMonitorIdLessThan(String value) {
            addCriterion("MONITOR_ID <", value, "monitorId");
            return this;
        }

        public Criteria andMonitorIdLessThanOrEqualTo(String value) {
            addCriterion("MONITOR_ID <=", value, "monitorId");
            return this;
        }

        public Criteria andMonitorIdLike(String value) {
            addCriterion("MONITOR_ID like", value, "monitorId");
            return this;
        }

        public Criteria andMonitorIdNotLike(String value) {
            addCriterion("MONITOR_ID not like", value, "monitorId");
            return this;
        }

        public Criteria andMonitorIdIn(List values) {
            addCriterion("MONITOR_ID in", values, "monitorId");
            return this;
        }

        public Criteria andMonitorIdNotIn(List values) {
            addCriterion("MONITOR_ID not in", values, "monitorId");
            return this;
        }

        public Criteria andMonitorIdBetween(String value1, String value2) {
            addCriterion("MONITOR_ID between", value1, value2, "monitorId");
            return this;
        }

        public Criteria andMonitorIdNotBetween(String value1, String value2) {
            addCriterion("MONITOR_ID not between", value1, value2, "monitorId");
            return this;
        }

        public Criteria andMonitorTypeIsNull() {
            addCriterion("MONITOR_TYPE is null");
            return this;
        }

        public Criteria andMonitorTypeIsNotNull() {
            addCriterion("MONITOR_TYPE is not null");
            return this;
        }

        public Criteria andMonitorTypeEqualTo(BigDecimal value) {
            addCriterion("MONITOR_TYPE =", value, "monitorType");
            return this;
        }

        public Criteria andMonitorTypeNotEqualTo(BigDecimal value) {
            addCriterion("MONITOR_TYPE <>", value, "monitorType");
            return this;
        }

        public Criteria andMonitorTypeGreaterThan(BigDecimal value) {
            addCriterion("MONITOR_TYPE >", value, "monitorType");
            return this;
        }

        public Criteria andMonitorTypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONITOR_TYPE >=", value, "monitorType");
            return this;
        }

        public Criteria andMonitorTypeLessThan(BigDecimal value) {
            addCriterion("MONITOR_TYPE <", value, "monitorType");
            return this;
        }

        public Criteria andMonitorTypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONITOR_TYPE <=", value, "monitorType");
            return this;
        }

        public Criteria andMonitorTypeIn(List values) {
            addCriterion("MONITOR_TYPE in", values, "monitorType");
            return this;
        }

        public Criteria andMonitorTypeNotIn(List values) {
            addCriterion("MONITOR_TYPE not in", values, "monitorType");
            return this;
        }

        public Criteria andMonitorTypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONITOR_TYPE between", value1, value2, "monitorType");
            return this;
        }

        public Criteria andMonitorTypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONITOR_TYPE not between", value1, value2, "monitorType");
            return this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("TASK_ID is null");
            return this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("TASK_ID is not null");
            return this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("TASK_ID =", value, "taskId");
            return this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("TASK_ID <>", value, "taskId");
            return this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("TASK_ID >", value, "taskId");
            return this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_ID >=", value, "taskId");
            return this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("TASK_ID <", value, "taskId");
            return this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("TASK_ID <=", value, "taskId");
            return this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("TASK_ID like", value, "taskId");
            return this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("TASK_ID not like", value, "taskId");
            return this;
        }

        public Criteria andTaskIdIn(List values) {
            addCriterion("TASK_ID in", values, "taskId");
            return this;
        }

        public Criteria andTaskIdNotIn(List values) {
            addCriterion("TASK_ID not in", values, "taskId");
            return this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("TASK_ID between", value1, value2, "taskId");
            return this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("TASK_ID not between", value1, value2, "taskId");
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
    }
}