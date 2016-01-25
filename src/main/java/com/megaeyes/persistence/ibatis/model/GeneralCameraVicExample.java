package com.megaeyes.persistence.ibatis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralCameraVicExample {
    protected String orderByClause;

    protected List oredCriteria;

    public GeneralCameraVicExample() {
        oredCriteria = new ArrayList();
    }

    protected GeneralCameraVicExample(GeneralCameraVicExample example) {
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

        public Criteria andVideoInputChannelIdIsNull() {
            addCriterion("VIDEO_INPUT_CHANNEL_ID is null");
            return this;
        }

        public Criteria andVideoInputChannelIdIsNotNull() {
            addCriterion("VIDEO_INPUT_CHANNEL_ID is not null");
            return this;
        }

        public Criteria andVideoInputChannelIdEqualTo(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID =", value, "videoInputChannelId");
            return this;
        }

        public Criteria andVideoInputChannelIdNotEqualTo(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID <>", value, "videoInputChannelId");
            return this;
        }

        public Criteria andVideoInputChannelIdGreaterThan(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID >", value, "videoInputChannelId");
            return this;
        }

        public Criteria andVideoInputChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID >=", value, "videoInputChannelId");
            return this;
        }

        public Criteria andVideoInputChannelIdLessThan(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID <", value, "videoInputChannelId");
            return this;
        }

        public Criteria andVideoInputChannelIdLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID <=", value, "videoInputChannelId");
            return this;
        }

        public Criteria andVideoInputChannelIdLike(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID like", value, "videoInputChannelId");
            return this;
        }

        public Criteria andVideoInputChannelIdNotLike(String value) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID not like", value, "videoInputChannelId");
            return this;
        }

        public Criteria andVideoInputChannelIdIn(List values) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID in", values, "videoInputChannelId");
            return this;
        }

        public Criteria andVideoInputChannelIdNotIn(List values) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID not in", values, "videoInputChannelId");
            return this;
        }

        public Criteria andVideoInputChannelIdBetween(String value1, String value2) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID between", value1, value2, "videoInputChannelId");
            return this;
        }

        public Criteria andVideoInputChannelIdNotBetween(String value1, String value2) {
            addCriterion("VIDEO_INPUT_CHANNEL_ID not between", value1, value2, "videoInputChannelId");
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
    }
}