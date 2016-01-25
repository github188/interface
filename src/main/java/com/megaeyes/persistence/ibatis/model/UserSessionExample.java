package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSessionExample {
    protected String orderByClause;

    protected List oredCriteria;

    public UserSessionExample() {
        oredCriteria = new ArrayList();
    }

    protected UserSessionExample(UserSessionExample example) {
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

        public Criteria andLogonTimeIsNull() {
            addCriterion("LOGON_TIME is null");
            return this;
        }

        public Criteria andLogonTimeIsNotNull() {
            addCriterion("LOGON_TIME is not null");
            return this;
        }

        public Criteria andLogonTimeEqualTo(BigDecimal value) {
            addCriterion("LOGON_TIME =", value, "logonTime");
            return this;
        }

        public Criteria andLogonTimeNotEqualTo(BigDecimal value) {
            addCriterion("LOGON_TIME <>", value, "logonTime");
            return this;
        }

        public Criteria andLogonTimeGreaterThan(BigDecimal value) {
            addCriterion("LOGON_TIME >", value, "logonTime");
            return this;
        }

        public Criteria andLogonTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOGON_TIME >=", value, "logonTime");
            return this;
        }

        public Criteria andLogonTimeLessThan(BigDecimal value) {
            addCriterion("LOGON_TIME <", value, "logonTime");
            return this;
        }

        public Criteria andLogonTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOGON_TIME <=", value, "logonTime");
            return this;
        }

        public Criteria andLogonTimeIn(List values) {
            addCriterion("LOGON_TIME in", values, "logonTime");
            return this;
        }

        public Criteria andLogonTimeNotIn(List values) {
            addCriterion("LOGON_TIME not in", values, "logonTime");
            return this;
        }

        public Criteria andLogonTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOGON_TIME between", value1, value2, "logonTime");
            return this;
        }

        public Criteria andLogonTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOGON_TIME not between", value1, value2, "logonTime");
            return this;
        }

        public Criteria andHeartbeatTimeIsNull() {
            addCriterion("HEARTBEAT_TIME is null");
            return this;
        }

        public Criteria andHeartbeatTimeIsNotNull() {
            addCriterion("HEARTBEAT_TIME is not null");
            return this;
        }

        public Criteria andHeartbeatTimeEqualTo(BigDecimal value) {
            addCriterion("HEARTBEAT_TIME =", value, "heartbeatTime");
            return this;
        }

        public Criteria andHeartbeatTimeNotEqualTo(BigDecimal value) {
            addCriterion("HEARTBEAT_TIME <>", value, "heartbeatTime");
            return this;
        }

        public Criteria andHeartbeatTimeGreaterThan(BigDecimal value) {
            addCriterion("HEARTBEAT_TIME >", value, "heartbeatTime");
            return this;
        }

        public Criteria andHeartbeatTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HEARTBEAT_TIME >=", value, "heartbeatTime");
            return this;
        }

        public Criteria andHeartbeatTimeLessThan(BigDecimal value) {
            addCriterion("HEARTBEAT_TIME <", value, "heartbeatTime");
            return this;
        }

        public Criteria andHeartbeatTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HEARTBEAT_TIME <=", value, "heartbeatTime");
            return this;
        }

        public Criteria andHeartbeatTimeIn(List values) {
            addCriterion("HEARTBEAT_TIME in", values, "heartbeatTime");
            return this;
        }

        public Criteria andHeartbeatTimeNotIn(List values) {
            addCriterion("HEARTBEAT_TIME not in", values, "heartbeatTime");
            return this;
        }

        public Criteria andHeartbeatTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HEARTBEAT_TIME between", value1, value2, "heartbeatTime");
            return this;
        }

        public Criteria andHeartbeatTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HEARTBEAT_TIME not between", value1, value2, "heartbeatTime");
            return this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return this;
        }

        public Criteria andUserIdIn(List values) {
            addCriterion("USER_ID in", values, "userId");
            return this;
        }

        public Criteria andUserIdNotIn(List values) {
            addCriterion("USER_ID not in", values, "userId");
            return this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return this;
        }

        public Criteria andIpIn(List values) {
            addCriterion("IP in", values, "ip");
            return this;
        }

        public Criteria andIpNotIn(List values) {
            addCriterion("IP not in", values, "ip");
            return this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return this;
        }

        public Criteria andClientTypeIsNull() {
            addCriterion("CLIENT_TYPE is null");
            return this;
        }

        public Criteria andClientTypeIsNotNull() {
            addCriterion("CLIENT_TYPE is not null");
            return this;
        }

        public Criteria andClientTypeEqualTo(String value) {
            addCriterion("CLIENT_TYPE =", value, "clientType");
            return this;
        }

        public Criteria andClientTypeNotEqualTo(String value) {
            addCriterion("CLIENT_TYPE <>", value, "clientType");
            return this;
        }

        public Criteria andClientTypeGreaterThan(String value) {
            addCriterion("CLIENT_TYPE >", value, "clientType");
            return this;
        }

        public Criteria andClientTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_TYPE >=", value, "clientType");
            return this;
        }

        public Criteria andClientTypeLessThan(String value) {
            addCriterion("CLIENT_TYPE <", value, "clientType");
            return this;
        }

        public Criteria andClientTypeLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_TYPE <=", value, "clientType");
            return this;
        }

        public Criteria andClientTypeLike(String value) {
            addCriterion("CLIENT_TYPE like", value, "clientType");
            return this;
        }

        public Criteria andClientTypeNotLike(String value) {
            addCriterion("CLIENT_TYPE not like", value, "clientType");
            return this;
        }

        public Criteria andClientTypeIn(List values) {
            addCriterion("CLIENT_TYPE in", values, "clientType");
            return this;
        }

        public Criteria andClientTypeNotIn(List values) {
            addCriterion("CLIENT_TYPE not in", values, "clientType");
            return this;
        }

        public Criteria andClientTypeBetween(String value1, String value2) {
            addCriterion("CLIENT_TYPE between", value1, value2, "clientType");
            return this;
        }

        public Criteria andClientTypeNotBetween(String value1, String value2) {
            addCriterion("CLIENT_TYPE not between", value1, value2, "clientType");
            return this;
        }
    }
}