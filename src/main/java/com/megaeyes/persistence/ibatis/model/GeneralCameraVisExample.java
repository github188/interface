package com.megaeyes.persistence.ibatis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralCameraVisExample {
    protected String orderByClause;

    protected List oredCriteria;

    public GeneralCameraVisExample() {
        oredCriteria = new ArrayList();
    }

    protected GeneralCameraVisExample(GeneralCameraVisExample example) {
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

        public Criteria andVideoInputServerIdIsNull() {
            addCriterion("VIDEO_INPUT_SERVER_ID is null");
            return this;
        }

        public Criteria andVideoInputServerIdIsNotNull() {
            addCriterion("VIDEO_INPUT_SERVER_ID is not null");
            return this;
        }

        public Criteria andVideoInputServerIdEqualTo(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID =", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdNotEqualTo(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID <>", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdGreaterThan(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID >", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID >=", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdLessThan(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID <", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID <=", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdLike(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID like", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdNotLike(String value) {
            addCriterion("VIDEO_INPUT_SERVER_ID not like", value, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdIn(List values) {
            addCriterion("VIDEO_INPUT_SERVER_ID in", values, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdNotIn(List values) {
            addCriterion("VIDEO_INPUT_SERVER_ID not in", values, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdBetween(String value1, String value2) {
            addCriterion("VIDEO_INPUT_SERVER_ID between", value1, value2, "videoInputServerId");
            return this;
        }

        public Criteria andVideoInputServerIdNotBetween(String value1, String value2) {
            addCriterion("VIDEO_INPUT_SERVER_ID not between", value1, value2, "videoInputServerId");
            return this;
        }
    }
}