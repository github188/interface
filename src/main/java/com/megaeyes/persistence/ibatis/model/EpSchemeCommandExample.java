package com.megaeyes.persistence.ibatis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpSchemeCommandExample {
    protected String orderByClause;

    protected List oredCriteria;

    public EpSchemeCommandExample() {
        oredCriteria = new ArrayList();
    }

    protected EpSchemeCommandExample(EpSchemeCommandExample example) {
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

        public Criteria andEpSchemeIdIsNull() {
            addCriterion("EP_SCHEME_ID is null");
            return this;
        }

        public Criteria andEpSchemeIdIsNotNull() {
            addCriterion("EP_SCHEME_ID is not null");
            return this;
        }

        public Criteria andEpSchemeIdEqualTo(String value) {
            addCriterion("EP_SCHEME_ID =", value, "epSchemeId");
            return this;
        }

        public Criteria andEpSchemeIdNotEqualTo(String value) {
            addCriterion("EP_SCHEME_ID <>", value, "epSchemeId");
            return this;
        }

        public Criteria andEpSchemeIdGreaterThan(String value) {
            addCriterion("EP_SCHEME_ID >", value, "epSchemeId");
            return this;
        }

        public Criteria andEpSchemeIdGreaterThanOrEqualTo(String value) {
            addCriterion("EP_SCHEME_ID >=", value, "epSchemeId");
            return this;
        }

        public Criteria andEpSchemeIdLessThan(String value) {
            addCriterion("EP_SCHEME_ID <", value, "epSchemeId");
            return this;
        }

        public Criteria andEpSchemeIdLessThanOrEqualTo(String value) {
            addCriterion("EP_SCHEME_ID <=", value, "epSchemeId");
            return this;
        }

        public Criteria andEpSchemeIdLike(String value) {
            addCriterion("EP_SCHEME_ID like", value, "epSchemeId");
            return this;
        }

        public Criteria andEpSchemeIdNotLike(String value) {
            addCriterion("EP_SCHEME_ID not like", value, "epSchemeId");
            return this;
        }

        public Criteria andEpSchemeIdIn(List values) {
            addCriterion("EP_SCHEME_ID in", values, "epSchemeId");
            return this;
        }

        public Criteria andEpSchemeIdNotIn(List values) {
            addCriterion("EP_SCHEME_ID not in", values, "epSchemeId");
            return this;
        }

        public Criteria andEpSchemeIdBetween(String value1, String value2) {
            addCriterion("EP_SCHEME_ID between", value1, value2, "epSchemeId");
            return this;
        }

        public Criteria andEpSchemeIdNotBetween(String value1, String value2) {
            addCriterion("EP_SCHEME_ID not between", value1, value2, "epSchemeId");
            return this;
        }

        public Criteria andTargetIdIsNull() {
            addCriterion("TARGET_ID is null");
            return this;
        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("TARGET_ID is not null");
            return this;
        }

        public Criteria andTargetIdEqualTo(String value) {
            addCriterion("TARGET_ID =", value, "targetId");
            return this;
        }

        public Criteria andTargetIdNotEqualTo(String value) {
            addCriterion("TARGET_ID <>", value, "targetId");
            return this;
        }

        public Criteria andTargetIdGreaterThan(String value) {
            addCriterion("TARGET_ID >", value, "targetId");
            return this;
        }

        public Criteria andTargetIdGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_ID >=", value, "targetId");
            return this;
        }

        public Criteria andTargetIdLessThan(String value) {
            addCriterion("TARGET_ID <", value, "targetId");
            return this;
        }

        public Criteria andTargetIdLessThanOrEqualTo(String value) {
            addCriterion("TARGET_ID <=", value, "targetId");
            return this;
        }

        public Criteria andTargetIdLike(String value) {
            addCriterion("TARGET_ID like", value, "targetId");
            return this;
        }

        public Criteria andTargetIdNotLike(String value) {
            addCriterion("TARGET_ID not like", value, "targetId");
            return this;
        }

        public Criteria andTargetIdIn(List values) {
            addCriterion("TARGET_ID in", values, "targetId");
            return this;
        }

        public Criteria andTargetIdNotIn(List values) {
            addCriterion("TARGET_ID not in", values, "targetId");
            return this;
        }

        public Criteria andTargetIdBetween(String value1, String value2) {
            addCriterion("TARGET_ID between", value1, value2, "targetId");
            return this;
        }

        public Criteria andTargetIdNotBetween(String value1, String value2) {
            addCriterion("TARGET_ID not between", value1, value2, "targetId");
            return this;
        }

        public Criteria andTargetTypeIsNull() {
            addCriterion("TARGET_TYPE is null");
            return this;
        }

        public Criteria andTargetTypeIsNotNull() {
            addCriterion("TARGET_TYPE is not null");
            return this;
        }

        public Criteria andTargetTypeEqualTo(String value) {
            addCriterion("TARGET_TYPE =", value, "targetType");
            return this;
        }

        public Criteria andTargetTypeNotEqualTo(String value) {
            addCriterion("TARGET_TYPE <>", value, "targetType");
            return this;
        }

        public Criteria andTargetTypeGreaterThan(String value) {
            addCriterion("TARGET_TYPE >", value, "targetType");
            return this;
        }

        public Criteria andTargetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_TYPE >=", value, "targetType");
            return this;
        }

        public Criteria andTargetTypeLessThan(String value) {
            addCriterion("TARGET_TYPE <", value, "targetType");
            return this;
        }

        public Criteria andTargetTypeLessThanOrEqualTo(String value) {
            addCriterion("TARGET_TYPE <=", value, "targetType");
            return this;
        }

        public Criteria andTargetTypeLike(String value) {
            addCriterion("TARGET_TYPE like", value, "targetType");
            return this;
        }

        public Criteria andTargetTypeNotLike(String value) {
            addCriterion("TARGET_TYPE not like", value, "targetType");
            return this;
        }

        public Criteria andTargetTypeIn(List values) {
            addCriterion("TARGET_TYPE in", values, "targetType");
            return this;
        }

        public Criteria andTargetTypeNotIn(List values) {
            addCriterion("TARGET_TYPE not in", values, "targetType");
            return this;
        }

        public Criteria andTargetTypeBetween(String value1, String value2) {
            addCriterion("TARGET_TYPE between", value1, value2, "targetType");
            return this;
        }

        public Criteria andTargetTypeNotBetween(String value1, String value2) {
            addCriterion("TARGET_TYPE not between", value1, value2, "targetType");
            return this;
        }

        public Criteria andValueIsNull() {
            addCriterion("VALUE is null");
            return this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("VALUE is not null");
            return this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("VALUE =", value, "value");
            return this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("VALUE <>", value, "value");
            return this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("VALUE >", value, "value");
            return this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("VALUE >=", value, "value");
            return this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("VALUE <", value, "value");
            return this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("VALUE <=", value, "value");
            return this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("VALUE like", value, "value");
            return this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("VALUE not like", value, "value");
            return this;
        }

        public Criteria andValueIn(List values) {
            addCriterion("VALUE in", values, "value");
            return this;
        }

        public Criteria andValueNotIn(List values) {
            addCriterion("VALUE not in", values, "value");
            return this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("VALUE between", value1, value2, "value");
            return this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("VALUE not between", value1, value2, "value");
            return this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("DURATION is null");
            return this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("DURATION is not null");
            return this;
        }

        public Criteria andDurationEqualTo(String value) {
            addCriterion("DURATION =", value, "duration");
            return this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("DURATION <>", value, "duration");
            return this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("DURATION >", value, "duration");
            return this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("DURATION >=", value, "duration");
            return this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("DURATION <", value, "duration");
            return this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("DURATION <=", value, "duration");
            return this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("DURATION like", value, "duration");
            return this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("DURATION not like", value, "duration");
            return this;
        }

        public Criteria andDurationIn(List values) {
            addCriterion("DURATION in", values, "duration");
            return this;
        }

        public Criteria andDurationNotIn(List values) {
            addCriterion("DURATION not in", values, "duration");
            return this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("DURATION between", value1, value2, "duration");
            return this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("DURATION not between", value1, value2, "duration");
            return this;
        }

        public Criteria andSeqIsNull() {
            addCriterion("SEQ is null");
            return this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("SEQ is not null");
            return this;
        }

        public Criteria andSeqEqualTo(Integer value) {
            addCriterion("SEQ =", value, "seq");
            return this;
        }

        public Criteria andSeqNotEqualTo(Integer value) {
            addCriterion("SEQ <>", value, "seq");
            return this;
        }

        public Criteria andSeqGreaterThan(Integer value) {
            addCriterion("SEQ >", value, "seq");
            return this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEQ >=", value, "seq");
            return this;
        }

        public Criteria andSeqLessThan(Integer value) {
            addCriterion("SEQ <", value, "seq");
            return this;
        }

        public Criteria andSeqLessThanOrEqualTo(Integer value) {
            addCriterion("SEQ <=", value, "seq");
            return this;
        }

        public Criteria andSeqIn(List values) {
            addCriterion("SEQ in", values, "seq");
            return this;
        }

        public Criteria andSeqNotIn(List values) {
            addCriterion("SEQ not in", values, "seq");
            return this;
        }

        public Criteria andSeqBetween(Integer value1, Integer value2) {
            addCriterion("SEQ between", value1, value2, "seq");
            return this;
        }

        public Criteria andSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("SEQ not between", value1, value2, "seq");
            return this;
        }
    }
}