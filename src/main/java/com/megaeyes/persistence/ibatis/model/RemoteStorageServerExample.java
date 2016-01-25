package com.megaeyes.persistence.ibatis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteStorageServerExample {
    protected String orderByClause;

    protected List oredCriteria;

    public RemoteStorageServerExample() {
        oredCriteria = new ArrayList();
    }

    protected RemoteStorageServerExample(RemoteStorageServerExample example) {
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

        public Criteria andStorageServerIdIsNull() {
            addCriterion("STORAGE_SERVER_ID is null");
            return this;
        }

        public Criteria andStorageServerIdIsNotNull() {
            addCriterion("STORAGE_SERVER_ID is not null");
            return this;
        }

        public Criteria andStorageServerIdEqualTo(String value) {
            addCriterion("STORAGE_SERVER_ID =", value, "storageServerId");
            return this;
        }

        public Criteria andStorageServerIdNotEqualTo(String value) {
            addCriterion("STORAGE_SERVER_ID <>", value, "storageServerId");
            return this;
        }

        public Criteria andStorageServerIdGreaterThan(String value) {
            addCriterion("STORAGE_SERVER_ID >", value, "storageServerId");
            return this;
        }

        public Criteria andStorageServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("STORAGE_SERVER_ID >=", value, "storageServerId");
            return this;
        }

        public Criteria andStorageServerIdLessThan(String value) {
            addCriterion("STORAGE_SERVER_ID <", value, "storageServerId");
            return this;
        }

        public Criteria andStorageServerIdLessThanOrEqualTo(String value) {
            addCriterion("STORAGE_SERVER_ID <=", value, "storageServerId");
            return this;
        }

        public Criteria andStorageServerIdLike(String value) {
            addCriterion("STORAGE_SERVER_ID like", value, "storageServerId");
            return this;
        }

        public Criteria andStorageServerIdNotLike(String value) {
            addCriterion("STORAGE_SERVER_ID not like", value, "storageServerId");
            return this;
        }

        public Criteria andStorageServerIdIn(List values) {
            addCriterion("STORAGE_SERVER_ID in", values, "storageServerId");
            return this;
        }

        public Criteria andStorageServerIdNotIn(List values) {
            addCriterion("STORAGE_SERVER_ID not in", values, "storageServerId");
            return this;
        }

        public Criteria andStorageServerIdBetween(String value1, String value2) {
            addCriterion("STORAGE_SERVER_ID between", value1, value2, "storageServerId");
            return this;
        }

        public Criteria andStorageServerIdNotBetween(String value1, String value2) {
            addCriterion("STORAGE_SERVER_ID not between", value1, value2, "storageServerId");
            return this;
        }

        public Criteria andOOrganIdIsNull() {
            addCriterion("O_ORGAN_ID is null");
            return this;
        }

        public Criteria andOOrganIdIsNotNull() {
            addCriterion("O_ORGAN_ID is not null");
            return this;
        }

        public Criteria andOOrganIdEqualTo(String value) {
            addCriterion("O_ORGAN_ID =", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdNotEqualTo(String value) {
            addCriterion("O_ORGAN_ID <>", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdGreaterThan(String value) {
            addCriterion("O_ORGAN_ID >", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdGreaterThanOrEqualTo(String value) {
            addCriterion("O_ORGAN_ID >=", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdLessThan(String value) {
            addCriterion("O_ORGAN_ID <", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdLessThanOrEqualTo(String value) {
            addCriterion("O_ORGAN_ID <=", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdLike(String value) {
            addCriterion("O_ORGAN_ID like", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdNotLike(String value) {
            addCriterion("O_ORGAN_ID not like", value, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdIn(List values) {
            addCriterion("O_ORGAN_ID in", values, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdNotIn(List values) {
            addCriterion("O_ORGAN_ID not in", values, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdBetween(String value1, String value2) {
            addCriterion("O_ORGAN_ID between", value1, value2, "oOrganId");
            return this;
        }

        public Criteria andOOrganIdNotBetween(String value1, String value2) {
            addCriterion("O_ORGAN_ID not between", value1, value2, "oOrganId");
            return this;
        }

        public Criteria andHasVodIsNull() {
            addCriterion("HAS_VOD is null");
            return this;
        }

        public Criteria andHasVodIsNotNull() {
            addCriterion("HAS_VOD is not null");
            return this;
        }

        public Criteria andHasVodEqualTo(Short value) {
            addCriterion("HAS_VOD =", value, "hasVod");
            return this;
        }

        public Criteria andHasVodNotEqualTo(Short value) {
            addCriterion("HAS_VOD <>", value, "hasVod");
            return this;
        }

        public Criteria andHasVodGreaterThan(Short value) {
            addCriterion("HAS_VOD >", value, "hasVod");
            return this;
        }

        public Criteria andHasVodGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_VOD >=", value, "hasVod");
            return this;
        }

        public Criteria andHasVodLessThan(Short value) {
            addCriterion("HAS_VOD <", value, "hasVod");
            return this;
        }

        public Criteria andHasVodLessThanOrEqualTo(Short value) {
            addCriterion("HAS_VOD <=", value, "hasVod");
            return this;
        }

        public Criteria andHasVodIn(List values) {
            addCriterion("HAS_VOD in", values, "hasVod");
            return this;
        }

        public Criteria andHasVodNotIn(List values) {
            addCriterion("HAS_VOD not in", values, "hasVod");
            return this;
        }

        public Criteria andHasVodBetween(Short value1, Short value2) {
            addCriterion("HAS_VOD between", value1, value2, "hasVod");
            return this;
        }

        public Criteria andHasVodNotBetween(Short value1, Short value2) {
            addCriterion("HAS_VOD not between", value1, value2, "hasVod");
            return this;
        }
    }
}