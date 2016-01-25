package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpRMonitorDeviceExample {
    protected String orderByClause;

    protected List oredCriteria;

    public EpRMonitorDeviceExample() {
        oredCriteria = new ArrayList();
    }

    protected EpRMonitorDeviceExample(EpRMonitorDeviceExample example) {
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

        public Criteria andDeviceTypeIsNull() {
            addCriterion("DEVICE_TYPE is null");
            return this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("DEVICE_TYPE is not null");
            return this;
        }

        public Criteria andDeviceTypeEqualTo(BigDecimal value) {
            addCriterion("DEVICE_TYPE =", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotEqualTo(BigDecimal value) {
            addCriterion("DEVICE_TYPE <>", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeGreaterThan(BigDecimal value) {
            addCriterion("DEVICE_TYPE >", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEVICE_TYPE >=", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeLessThan(BigDecimal value) {
            addCriterion("DEVICE_TYPE <", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEVICE_TYPE <=", value, "deviceType");
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

        public Criteria andDeviceTypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEVICE_TYPE between", value1, value2, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEVICE_TYPE not between", value1, value2, "deviceType");
            return this;
        }
    }
}