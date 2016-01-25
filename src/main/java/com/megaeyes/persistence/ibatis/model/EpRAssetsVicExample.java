package com.megaeyes.persistence.ibatis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpRAssetsVicExample {
    protected String orderByClause;

    protected List oredCriteria;

    public EpRAssetsVicExample() {
        oredCriteria = new ArrayList();
    }

    protected EpRAssetsVicExample(EpRAssetsVicExample example) {
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

        public Criteria andAssetsIdIsNull() {
            addCriterion("ASSETS_ID is null");
            return this;
        }

        public Criteria andAssetsIdIsNotNull() {
            addCriterion("ASSETS_ID is not null");
            return this;
        }

        public Criteria andAssetsIdEqualTo(String value) {
            addCriterion("ASSETS_ID =", value, "assetsId");
            return this;
        }

        public Criteria andAssetsIdNotEqualTo(String value) {
            addCriterion("ASSETS_ID <>", value, "assetsId");
            return this;
        }

        public Criteria andAssetsIdGreaterThan(String value) {
            addCriterion("ASSETS_ID >", value, "assetsId");
            return this;
        }

        public Criteria andAssetsIdGreaterThanOrEqualTo(String value) {
            addCriterion("ASSETS_ID >=", value, "assetsId");
            return this;
        }

        public Criteria andAssetsIdLessThan(String value) {
            addCriterion("ASSETS_ID <", value, "assetsId");
            return this;
        }

        public Criteria andAssetsIdLessThanOrEqualTo(String value) {
            addCriterion("ASSETS_ID <=", value, "assetsId");
            return this;
        }

        public Criteria andAssetsIdLike(String value) {
            addCriterion("ASSETS_ID like", value, "assetsId");
            return this;
        }

        public Criteria andAssetsIdNotLike(String value) {
            addCriterion("ASSETS_ID not like", value, "assetsId");
            return this;
        }

        public Criteria andAssetsIdIn(List values) {
            addCriterion("ASSETS_ID in", values, "assetsId");
            return this;
        }

        public Criteria andAssetsIdNotIn(List values) {
            addCriterion("ASSETS_ID not in", values, "assetsId");
            return this;
        }

        public Criteria andAssetsIdBetween(String value1, String value2) {
            addCriterion("ASSETS_ID between", value1, value2, "assetsId");
            return this;
        }

        public Criteria andAssetsIdNotBetween(String value1, String value2) {
            addCriterion("ASSETS_ID not between", value1, value2, "assetsId");
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
    }
}