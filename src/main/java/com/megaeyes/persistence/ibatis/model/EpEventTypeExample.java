package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpEventTypeExample {
    protected String orderByClause;

    protected List oredCriteria;

    public EpEventTypeExample() {
        oredCriteria = new ArrayList();
    }

    protected EpEventTypeExample(EpEventTypeExample example) {
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

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return this;
        }

        public Criteria andCodeEqualTo(BigDecimal value) {
            addCriterion("CODE =", value, "code");
            return this;
        }

        public Criteria andCodeNotEqualTo(BigDecimal value) {
            addCriterion("CODE <>", value, "code");
            return this;
        }

        public Criteria andCodeGreaterThan(BigDecimal value) {
            addCriterion("CODE >", value, "code");
            return this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CODE >=", value, "code");
            return this;
        }

        public Criteria andCodeLessThan(BigDecimal value) {
            addCriterion("CODE <", value, "code");
            return this;
        }

        public Criteria andCodeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CODE <=", value, "code");
            return this;
        }

        public Criteria andCodeIn(List values) {
            addCriterion("CODE in", values, "code");
            return this;
        }

        public Criteria andCodeNotIn(List values) {
            addCriterion("CODE not in", values, "code");
            return this;
        }

        public Criteria andCodeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CODE between", value1, value2, "code");
            return this;
        }

        public Criteria andCodeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return this;
        }

        public Criteria andNameIn(List values) {
            addCriterion("NAME in", values, "name");
            return this;
        }

        public Criteria andNameNotIn(List values) {
            addCriterion("NAME not in", values, "name");
            return this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return this;
        }

        public Criteria andStandardTypeIsNull() {
            addCriterion("STANDARD_TYPE is null");
            return this;
        }

        public Criteria andStandardTypeIsNotNull() {
            addCriterion("STANDARD_TYPE is not null");
            return this;
        }

        public Criteria andStandardTypeEqualTo(String value) {
            addCriterion("STANDARD_TYPE =", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeNotEqualTo(String value) {
            addCriterion("STANDARD_TYPE <>", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeGreaterThan(String value) {
            addCriterion("STANDARD_TYPE >", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("STANDARD_TYPE >=", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeLessThan(String value) {
            addCriterion("STANDARD_TYPE <", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeLessThanOrEqualTo(String value) {
            addCriterion("STANDARD_TYPE <=", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeLike(String value) {
            addCriterion("STANDARD_TYPE like", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeNotLike(String value) {
            addCriterion("STANDARD_TYPE not like", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeIn(List values) {
            addCriterion("STANDARD_TYPE in", values, "standardType");
            return this;
        }

        public Criteria andStandardTypeNotIn(List values) {
            addCriterion("STANDARD_TYPE not in", values, "standardType");
            return this;
        }

        public Criteria andStandardTypeBetween(String value1, String value2) {
            addCriterion("STANDARD_TYPE between", value1, value2, "standardType");
            return this;
        }

        public Criteria andStandardTypeNotBetween(String value1, String value2) {
            addCriterion("STANDARD_TYPE not between", value1, value2, "standardType");
            return this;
        }
    }
}