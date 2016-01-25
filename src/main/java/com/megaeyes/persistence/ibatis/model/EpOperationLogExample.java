package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpOperationLogExample {
    protected String orderByClause;

    protected List oredCriteria;

    public EpOperationLogExample() {
        oredCriteria = new ArrayList();
    }

    protected EpOperationLogExample(EpOperationLogExample example) {
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

        public Criteria andUserLoginNameIsNull() {
            addCriterion("USER_LOGIN_NAME is null");
            return this;
        }

        public Criteria andUserLoginNameIsNotNull() {
            addCriterion("USER_LOGIN_NAME is not null");
            return this;
        }

        public Criteria andUserLoginNameEqualTo(String value) {
            addCriterion("USER_LOGIN_NAME =", value, "userLoginName");
            return this;
        }

        public Criteria andUserLoginNameNotEqualTo(String value) {
            addCriterion("USER_LOGIN_NAME <>", value, "userLoginName");
            return this;
        }

        public Criteria andUserLoginNameGreaterThan(String value) {
            addCriterion("USER_LOGIN_NAME >", value, "userLoginName");
            return this;
        }

        public Criteria andUserLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_LOGIN_NAME >=", value, "userLoginName");
            return this;
        }

        public Criteria andUserLoginNameLessThan(String value) {
            addCriterion("USER_LOGIN_NAME <", value, "userLoginName");
            return this;
        }

        public Criteria andUserLoginNameLessThanOrEqualTo(String value) {
            addCriterion("USER_LOGIN_NAME <=", value, "userLoginName");
            return this;
        }

        public Criteria andUserLoginNameLike(String value) {
            addCriterion("USER_LOGIN_NAME like", value, "userLoginName");
            return this;
        }

        public Criteria andUserLoginNameNotLike(String value) {
            addCriterion("USER_LOGIN_NAME not like", value, "userLoginName");
            return this;
        }

        public Criteria andUserLoginNameIn(List values) {
            addCriterion("USER_LOGIN_NAME in", values, "userLoginName");
            return this;
        }

        public Criteria andUserLoginNameNotIn(List values) {
            addCriterion("USER_LOGIN_NAME not in", values, "userLoginName");
            return this;
        }

        public Criteria andUserLoginNameBetween(String value1, String value2) {
            addCriterion("USER_LOGIN_NAME between", value1, value2, "userLoginName");
            return this;
        }

        public Criteria andUserLoginNameNotBetween(String value1, String value2) {
            addCriterion("USER_LOGIN_NAME not between", value1, value2, "userLoginName");
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

        public Criteria andOperateTimeIsNull() {
            addCriterion("OPERATE_TIME is null");
            return this;
        }

        public Criteria andOperateTimeIsNotNull() {
            addCriterion("OPERATE_TIME is not null");
            return this;
        }

        public Criteria andOperateTimeEqualTo(BigDecimal value) {
            addCriterion("OPERATE_TIME =", value, "operateTime");
            return this;
        }

        public Criteria andOperateTimeNotEqualTo(BigDecimal value) {
            addCriterion("OPERATE_TIME <>", value, "operateTime");
            return this;
        }

        public Criteria andOperateTimeGreaterThan(BigDecimal value) {
            addCriterion("OPERATE_TIME >", value, "operateTime");
            return this;
        }

        public Criteria andOperateTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OPERATE_TIME >=", value, "operateTime");
            return this;
        }

        public Criteria andOperateTimeLessThan(BigDecimal value) {
            addCriterion("OPERATE_TIME <", value, "operateTime");
            return this;
        }

        public Criteria andOperateTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OPERATE_TIME <=", value, "operateTime");
            return this;
        }

        public Criteria andOperateTimeIn(List values) {
            addCriterion("OPERATE_TIME in", values, "operateTime");
            return this;
        }

        public Criteria andOperateTimeNotIn(List values) {
            addCriterion("OPERATE_TIME not in", values, "operateTime");
            return this;
        }

        public Criteria andOperateTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPERATE_TIME between", value1, value2, "operateTime");
            return this;
        }

        public Criteria andOperateTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPERATE_TIME not between", value1, value2, "operateTime");
            return this;
        }

        public Criteria andOperateDescriptionIsNull() {
            addCriterion("OPERATE_DESCRIPTION is null");
            return this;
        }

        public Criteria andOperateDescriptionIsNotNull() {
            addCriterion("OPERATE_DESCRIPTION is not null");
            return this;
        }

        public Criteria andOperateDescriptionEqualTo(String value) {
            addCriterion("OPERATE_DESCRIPTION =", value, "operateDescription");
            return this;
        }

        public Criteria andOperateDescriptionNotEqualTo(String value) {
            addCriterion("OPERATE_DESCRIPTION <>", value, "operateDescription");
            return this;
        }

        public Criteria andOperateDescriptionGreaterThan(String value) {
            addCriterion("OPERATE_DESCRIPTION >", value, "operateDescription");
            return this;
        }

        public Criteria andOperateDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE_DESCRIPTION >=", value, "operateDescription");
            return this;
        }

        public Criteria andOperateDescriptionLessThan(String value) {
            addCriterion("OPERATE_DESCRIPTION <", value, "operateDescription");
            return this;
        }

        public Criteria andOperateDescriptionLessThanOrEqualTo(String value) {
            addCriterion("OPERATE_DESCRIPTION <=", value, "operateDescription");
            return this;
        }

        public Criteria andOperateDescriptionLike(String value) {
            addCriterion("OPERATE_DESCRIPTION like", value, "operateDescription");
            return this;
        }

        public Criteria andOperateDescriptionNotLike(String value) {
            addCriterion("OPERATE_DESCRIPTION not like", value, "operateDescription");
            return this;
        }

        public Criteria andOperateDescriptionIn(List values) {
            addCriterion("OPERATE_DESCRIPTION in", values, "operateDescription");
            return this;
        }

        public Criteria andOperateDescriptionNotIn(List values) {
            addCriterion("OPERATE_DESCRIPTION not in", values, "operateDescription");
            return this;
        }

        public Criteria andOperateDescriptionBetween(String value1, String value2) {
            addCriterion("OPERATE_DESCRIPTION between", value1, value2, "operateDescription");
            return this;
        }

        public Criteria andOperateDescriptionNotBetween(String value1, String value2) {
            addCriterion("OPERATE_DESCRIPTION not between", value1, value2, "operateDescription");
            return this;
        }

        public Criteria andOperateorIpIsNull() {
            addCriterion("OPERATEOR_IP is null");
            return this;
        }

        public Criteria andOperateorIpIsNotNull() {
            addCriterion("OPERATEOR_IP is not null");
            return this;
        }

        public Criteria andOperateorIpEqualTo(String value) {
            addCriterion("OPERATEOR_IP =", value, "operateorIp");
            return this;
        }

        public Criteria andOperateorIpNotEqualTo(String value) {
            addCriterion("OPERATEOR_IP <>", value, "operateorIp");
            return this;
        }

        public Criteria andOperateorIpGreaterThan(String value) {
            addCriterion("OPERATEOR_IP >", value, "operateorIp");
            return this;
        }

        public Criteria andOperateorIpGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATEOR_IP >=", value, "operateorIp");
            return this;
        }

        public Criteria andOperateorIpLessThan(String value) {
            addCriterion("OPERATEOR_IP <", value, "operateorIp");
            return this;
        }

        public Criteria andOperateorIpLessThanOrEqualTo(String value) {
            addCriterion("OPERATEOR_IP <=", value, "operateorIp");
            return this;
        }

        public Criteria andOperateorIpLike(String value) {
            addCriterion("OPERATEOR_IP like", value, "operateorIp");
            return this;
        }

        public Criteria andOperateorIpNotLike(String value) {
            addCriterion("OPERATEOR_IP not like", value, "operateorIp");
            return this;
        }

        public Criteria andOperateorIpIn(List values) {
            addCriterion("OPERATEOR_IP in", values, "operateorIp");
            return this;
        }

        public Criteria andOperateorIpNotIn(List values) {
            addCriterion("OPERATEOR_IP not in", values, "operateorIp");
            return this;
        }

        public Criteria andOperateorIpBetween(String value1, String value2) {
            addCriterion("OPERATEOR_IP between", value1, value2, "operateorIp");
            return this;
        }

        public Criteria andOperateorIpNotBetween(String value1, String value2) {
            addCriterion("OPERATEOR_IP not between", value1, value2, "operateorIp");
            return this;
        }

        public Criteria andInterfaceNameIsNull() {
            addCriterion("INTERFACE_NAME is null");
            return this;
        }

        public Criteria andInterfaceNameIsNotNull() {
            addCriterion("INTERFACE_NAME is not null");
            return this;
        }

        public Criteria andInterfaceNameEqualTo(String value) {
            addCriterion("INTERFACE_NAME =", value, "interfaceName");
            return this;
        }

        public Criteria andInterfaceNameNotEqualTo(String value) {
            addCriterion("INTERFACE_NAME <>", value, "interfaceName");
            return this;
        }

        public Criteria andInterfaceNameGreaterThan(String value) {
            addCriterion("INTERFACE_NAME >", value, "interfaceName");
            return this;
        }

        public Criteria andInterfaceNameGreaterThanOrEqualTo(String value) {
            addCriterion("INTERFACE_NAME >=", value, "interfaceName");
            return this;
        }

        public Criteria andInterfaceNameLessThan(String value) {
            addCriterion("INTERFACE_NAME <", value, "interfaceName");
            return this;
        }

        public Criteria andInterfaceNameLessThanOrEqualTo(String value) {
            addCriterion("INTERFACE_NAME <=", value, "interfaceName");
            return this;
        }

        public Criteria andInterfaceNameLike(String value) {
            addCriterion("INTERFACE_NAME like", value, "interfaceName");
            return this;
        }

        public Criteria andInterfaceNameNotLike(String value) {
            addCriterion("INTERFACE_NAME not like", value, "interfaceName");
            return this;
        }

        public Criteria andInterfaceNameIn(List values) {
            addCriterion("INTERFACE_NAME in", values, "interfaceName");
            return this;
        }

        public Criteria andInterfaceNameNotIn(List values) {
            addCriterion("INTERFACE_NAME not in", values, "interfaceName");
            return this;
        }

        public Criteria andInterfaceNameBetween(String value1, String value2) {
            addCriterion("INTERFACE_NAME between", value1, value2, "interfaceName");
            return this;
        }

        public Criteria andInterfaceNameNotBetween(String value1, String value2) {
            addCriterion("INTERFACE_NAME not between", value1, value2, "interfaceName");
            return this;
        }
    }
}