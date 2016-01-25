package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserOperationLogExample {
    protected String orderByClause;

    protected List oredCriteria;

    public UserOperationLogExample() {
        oredCriteria = new ArrayList();
    }

    protected UserOperationLogExample(UserOperationLogExample example) {
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

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return this;
        }

        public Criteria andUserNameIn(List values) {
            addCriterion("USER_NAME in", values, "userName");
            return this;
        }

        public Criteria andUserNameNotIn(List values) {
            addCriterion("USER_NAME not in", values, "userName");
            return this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return this;
        }

        public Criteria andUserSessionIdIsNull() {
            addCriterion("USER_SESSION_ID is null");
            return this;
        }

        public Criteria andUserSessionIdIsNotNull() {
            addCriterion("USER_SESSION_ID is not null");
            return this;
        }

        public Criteria andUserSessionIdEqualTo(String value) {
            addCriterion("USER_SESSION_ID =", value, "userSessionId");
            return this;
        }

        public Criteria andUserSessionIdNotEqualTo(String value) {
            addCriterion("USER_SESSION_ID <>", value, "userSessionId");
            return this;
        }

        public Criteria andUserSessionIdGreaterThan(String value) {
            addCriterion("USER_SESSION_ID >", value, "userSessionId");
            return this;
        }

        public Criteria andUserSessionIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SESSION_ID >=", value, "userSessionId");
            return this;
        }

        public Criteria andUserSessionIdLessThan(String value) {
            addCriterion("USER_SESSION_ID <", value, "userSessionId");
            return this;
        }

        public Criteria andUserSessionIdLessThanOrEqualTo(String value) {
            addCriterion("USER_SESSION_ID <=", value, "userSessionId");
            return this;
        }

        public Criteria andUserSessionIdLike(String value) {
            addCriterion("USER_SESSION_ID like", value, "userSessionId");
            return this;
        }

        public Criteria andUserSessionIdNotLike(String value) {
            addCriterion("USER_SESSION_ID not like", value, "userSessionId");
            return this;
        }

        public Criteria andUserSessionIdIn(List values) {
            addCriterion("USER_SESSION_ID in", values, "userSessionId");
            return this;
        }

        public Criteria andUserSessionIdNotIn(List values) {
            addCriterion("USER_SESSION_ID not in", values, "userSessionId");
            return this;
        }

        public Criteria andUserSessionIdBetween(String value1, String value2) {
            addCriterion("USER_SESSION_ID between", value1, value2, "userSessionId");
            return this;
        }

        public Criteria andUserSessionIdNotBetween(String value1, String value2) {
            addCriterion("USER_SESSION_ID not between", value1, value2, "userSessionId");
            return this;
        }

        public Criteria andFTimeIsNull() {
            addCriterion("F_TIME is null");
            return this;
        }

        public Criteria andFTimeIsNotNull() {
            addCriterion("F_TIME is not null");
            return this;
        }

        public Criteria andFTimeEqualTo(BigDecimal value) {
            addCriterion("F_TIME =", value, "fTime");
            return this;
        }

        public Criteria andFTimeNotEqualTo(BigDecimal value) {
            addCriterion("F_TIME <>", value, "fTime");
            return this;
        }

        public Criteria andFTimeGreaterThan(BigDecimal value) {
            addCriterion("F_TIME >", value, "fTime");
            return this;
        }

        public Criteria andFTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("F_TIME >=", value, "fTime");
            return this;
        }

        public Criteria andFTimeLessThan(BigDecimal value) {
            addCriterion("F_TIME <", value, "fTime");
            return this;
        }

        public Criteria andFTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("F_TIME <=", value, "fTime");
            return this;
        }

        public Criteria andFTimeIn(List values) {
            addCriterion("F_TIME in", values, "fTime");
            return this;
        }

        public Criteria andFTimeNotIn(List values) {
            addCriterion("F_TIME not in", values, "fTime");
            return this;
        }

        public Criteria andFTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("F_TIME between", value1, value2, "fTime");
            return this;
        }

        public Criteria andFTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("F_TIME not between", value1, value2, "fTime");
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

        public Criteria andTargetNameIsNull() {
            addCriterion("TARGET_NAME is null");
            return this;
        }

        public Criteria andTargetNameIsNotNull() {
            addCriterion("TARGET_NAME is not null");
            return this;
        }

        public Criteria andTargetNameEqualTo(String value) {
            addCriterion("TARGET_NAME =", value, "targetName");
            return this;
        }

        public Criteria andTargetNameNotEqualTo(String value) {
            addCriterion("TARGET_NAME <>", value, "targetName");
            return this;
        }

        public Criteria andTargetNameGreaterThan(String value) {
            addCriterion("TARGET_NAME >", value, "targetName");
            return this;
        }

        public Criteria andTargetNameGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_NAME >=", value, "targetName");
            return this;
        }

        public Criteria andTargetNameLessThan(String value) {
            addCriterion("TARGET_NAME <", value, "targetName");
            return this;
        }

        public Criteria andTargetNameLessThanOrEqualTo(String value) {
            addCriterion("TARGET_NAME <=", value, "targetName");
            return this;
        }

        public Criteria andTargetNameLike(String value) {
            addCriterion("TARGET_NAME like", value, "targetName");
            return this;
        }

        public Criteria andTargetNameNotLike(String value) {
            addCriterion("TARGET_NAME not like", value, "targetName");
            return this;
        }

        public Criteria andTargetNameIn(List values) {
            addCriterion("TARGET_NAME in", values, "targetName");
            return this;
        }

        public Criteria andTargetNameNotIn(List values) {
            addCriterion("TARGET_NAME not in", values, "targetName");
            return this;
        }

        public Criteria andTargetNameBetween(String value1, String value2) {
            addCriterion("TARGET_NAME between", value1, value2, "targetName");
            return this;
        }

        public Criteria andTargetNameNotBetween(String value1, String value2) {
            addCriterion("TARGET_NAME not between", value1, value2, "targetName");
            return this;
        }

        public Criteria andOperationIdIsNull() {
            addCriterion("OPERATION_ID is null");
            return this;
        }

        public Criteria andOperationIdIsNotNull() {
            addCriterion("OPERATION_ID is not null");
            return this;
        }

        public Criteria andOperationIdEqualTo(String value) {
            addCriterion("OPERATION_ID =", value, "operationId");
            return this;
        }

        public Criteria andOperationIdNotEqualTo(String value) {
            addCriterion("OPERATION_ID <>", value, "operationId");
            return this;
        }

        public Criteria andOperationIdGreaterThan(String value) {
            addCriterion("OPERATION_ID >", value, "operationId");
            return this;
        }

        public Criteria andOperationIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATION_ID >=", value, "operationId");
            return this;
        }

        public Criteria andOperationIdLessThan(String value) {
            addCriterion("OPERATION_ID <", value, "operationId");
            return this;
        }

        public Criteria andOperationIdLessThanOrEqualTo(String value) {
            addCriterion("OPERATION_ID <=", value, "operationId");
            return this;
        }

        public Criteria andOperationIdLike(String value) {
            addCriterion("OPERATION_ID like", value, "operationId");
            return this;
        }

        public Criteria andOperationIdNotLike(String value) {
            addCriterion("OPERATION_ID not like", value, "operationId");
            return this;
        }

        public Criteria andOperationIdIn(List values) {
            addCriterion("OPERATION_ID in", values, "operationId");
            return this;
        }

        public Criteria andOperationIdNotIn(List values) {
            addCriterion("OPERATION_ID not in", values, "operationId");
            return this;
        }

        public Criteria andOperationIdBetween(String value1, String value2) {
            addCriterion("OPERATION_ID between", value1, value2, "operationId");
            return this;
        }

        public Criteria andOperationIdNotBetween(String value1, String value2) {
            addCriterion("OPERATION_ID not between", value1, value2, "operationId");
            return this;
        }

        public Criteria andOperationNameIsNull() {
            addCriterion("OPERATION_NAME is null");
            return this;
        }

        public Criteria andOperationNameIsNotNull() {
            addCriterion("OPERATION_NAME is not null");
            return this;
        }

        public Criteria andOperationNameEqualTo(String value) {
            addCriterion("OPERATION_NAME =", value, "operationName");
            return this;
        }

        public Criteria andOperationNameNotEqualTo(String value) {
            addCriterion("OPERATION_NAME <>", value, "operationName");
            return this;
        }

        public Criteria andOperationNameGreaterThan(String value) {
            addCriterion("OPERATION_NAME >", value, "operationName");
            return this;
        }

        public Criteria andOperationNameGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATION_NAME >=", value, "operationName");
            return this;
        }

        public Criteria andOperationNameLessThan(String value) {
            addCriterion("OPERATION_NAME <", value, "operationName");
            return this;
        }

        public Criteria andOperationNameLessThanOrEqualTo(String value) {
            addCriterion("OPERATION_NAME <=", value, "operationName");
            return this;
        }

        public Criteria andOperationNameLike(String value) {
            addCriterion("OPERATION_NAME like", value, "operationName");
            return this;
        }

        public Criteria andOperationNameNotLike(String value) {
            addCriterion("OPERATION_NAME not like", value, "operationName");
            return this;
        }

        public Criteria andOperationNameIn(List values) {
            addCriterion("OPERATION_NAME in", values, "operationName");
            return this;
        }

        public Criteria andOperationNameNotIn(List values) {
            addCriterion("OPERATION_NAME not in", values, "operationName");
            return this;
        }

        public Criteria andOperationNameBetween(String value1, String value2) {
            addCriterion("OPERATION_NAME between", value1, value2, "operationName");
            return this;
        }

        public Criteria andOperationNameNotBetween(String value1, String value2) {
            addCriterion("OPERATION_NAME not between", value1, value2, "operationName");
            return this;
        }

        public Criteria andEffectIdIsNull() {
            addCriterion("EFFECT_ID is null");
            return this;
        }

        public Criteria andEffectIdIsNotNull() {
            addCriterion("EFFECT_ID is not null");
            return this;
        }

        public Criteria andEffectIdEqualTo(String value) {
            addCriterion("EFFECT_ID =", value, "effectId");
            return this;
        }

        public Criteria andEffectIdNotEqualTo(String value) {
            addCriterion("EFFECT_ID <>", value, "effectId");
            return this;
        }

        public Criteria andEffectIdGreaterThan(String value) {
            addCriterion("EFFECT_ID >", value, "effectId");
            return this;
        }

        public Criteria andEffectIdGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECT_ID >=", value, "effectId");
            return this;
        }

        public Criteria andEffectIdLessThan(String value) {
            addCriterion("EFFECT_ID <", value, "effectId");
            return this;
        }

        public Criteria andEffectIdLessThanOrEqualTo(String value) {
            addCriterion("EFFECT_ID <=", value, "effectId");
            return this;
        }

        public Criteria andEffectIdLike(String value) {
            addCriterion("EFFECT_ID like", value, "effectId");
            return this;
        }

        public Criteria andEffectIdNotLike(String value) {
            addCriterion("EFFECT_ID not like", value, "effectId");
            return this;
        }

        public Criteria andEffectIdIn(List values) {
            addCriterion("EFFECT_ID in", values, "effectId");
            return this;
        }

        public Criteria andEffectIdNotIn(List values) {
            addCriterion("EFFECT_ID not in", values, "effectId");
            return this;
        }

        public Criteria andEffectIdBetween(String value1, String value2) {
            addCriterion("EFFECT_ID between", value1, value2, "effectId");
            return this;
        }

        public Criteria andEffectIdNotBetween(String value1, String value2) {
            addCriterion("EFFECT_ID not between", value1, value2, "effectId");
            return this;
        }

        public Criteria andEffectNameIsNull() {
            addCriterion("EFFECT_NAME is null");
            return this;
        }

        public Criteria andEffectNameIsNotNull() {
            addCriterion("EFFECT_NAME is not null");
            return this;
        }

        public Criteria andEffectNameEqualTo(String value) {
            addCriterion("EFFECT_NAME =", value, "effectName");
            return this;
        }

        public Criteria andEffectNameNotEqualTo(String value) {
            addCriterion("EFFECT_NAME <>", value, "effectName");
            return this;
        }

        public Criteria andEffectNameGreaterThan(String value) {
            addCriterion("EFFECT_NAME >", value, "effectName");
            return this;
        }

        public Criteria andEffectNameGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECT_NAME >=", value, "effectName");
            return this;
        }

        public Criteria andEffectNameLessThan(String value) {
            addCriterion("EFFECT_NAME <", value, "effectName");
            return this;
        }

        public Criteria andEffectNameLessThanOrEqualTo(String value) {
            addCriterion("EFFECT_NAME <=", value, "effectName");
            return this;
        }

        public Criteria andEffectNameLike(String value) {
            addCriterion("EFFECT_NAME like", value, "effectName");
            return this;
        }

        public Criteria andEffectNameNotLike(String value) {
            addCriterion("EFFECT_NAME not like", value, "effectName");
            return this;
        }

        public Criteria andEffectNameIn(List values) {
            addCriterion("EFFECT_NAME in", values, "effectName");
            return this;
        }

        public Criteria andEffectNameNotIn(List values) {
            addCriterion("EFFECT_NAME not in", values, "effectName");
            return this;
        }

        public Criteria andEffectNameBetween(String value1, String value2) {
            addCriterion("EFFECT_NAME between", value1, value2, "effectName");
            return this;
        }

        public Criteria andEffectNameNotBetween(String value1, String value2) {
            addCriterion("EFFECT_NAME not between", value1, value2, "effectName");
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
    }
}