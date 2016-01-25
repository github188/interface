package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlatformExample {
    protected String orderByClause;

    protected List oredCriteria;

    public PlatformExample() {
        oredCriteria = new ArrayList();
    }

    protected PlatformExample(PlatformExample example) {
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

        public Criteria andNameIsNull() {
            addCriterion("F_NAME is null");
            return this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("F_NAME is not null");
            return this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("F_NAME =", value, "name");
            return this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("F_NAME <>", value, "name");
            return this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("F_NAME >", value, "name");
            return this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("F_NAME >=", value, "name");
            return this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("F_NAME <", value, "name");
            return this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("F_NAME <=", value, "name");
            return this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("F_NAME like", value, "name");
            return this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("F_NAME not like", value, "name");
            return this;
        }

        public Criteria andNameIn(List values) {
            addCriterion("F_NAME in", values, "name");
            return this;
        }

        public Criteria andNameNotIn(List values) {
            addCriterion("F_NAME not in", values, "name");
            return this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("F_NAME between", value1, value2, "name");
            return this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("F_NAME not between", value1, value2, "name");
            return this;
        }

        public Criteria andCmsIdIsNull() {
            addCriterion("CMS_ID is null");
            return this;
        }

        public Criteria andCmsIdIsNotNull() {
            addCriterion("CMS_ID is not null");
            return this;
        }

        public Criteria andCmsIdEqualTo(String value) {
            addCriterion("CMS_ID =", value, "cmsId");
            return this;
        }

        public Criteria andCmsIdNotEqualTo(String value) {
            addCriterion("CMS_ID <>", value, "cmsId");
            return this;
        }

        public Criteria andCmsIdGreaterThan(String value) {
            addCriterion("CMS_ID >", value, "cmsId");
            return this;
        }

        public Criteria andCmsIdGreaterThanOrEqualTo(String value) {
            addCriterion("CMS_ID >=", value, "cmsId");
            return this;
        }

        public Criteria andCmsIdLessThan(String value) {
            addCriterion("CMS_ID <", value, "cmsId");
            return this;
        }

        public Criteria andCmsIdLessThanOrEqualTo(String value) {
            addCriterion("CMS_ID <=", value, "cmsId");
            return this;
        }

        public Criteria andCmsIdLike(String value) {
            addCriterion("CMS_ID like", value, "cmsId");
            return this;
        }

        public Criteria andCmsIdNotLike(String value) {
            addCriterion("CMS_ID not like", value, "cmsId");
            return this;
        }

        public Criteria andCmsIdIn(List values) {
            addCriterion("CMS_ID in", values, "cmsId");
            return this;
        }

        public Criteria andCmsIdNotIn(List values) {
            addCriterion("CMS_ID not in", values, "cmsId");
            return this;
        }

        public Criteria andCmsIdBetween(String value1, String value2) {
            addCriterion("CMS_ID between", value1, value2, "cmsId");
            return this;
        }

        public Criteria andCmsIdNotBetween(String value1, String value2) {
            addCriterion("CMS_ID not between", value1, value2, "cmsId");
            return this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("LOCATION is null");
            return this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("LOCATION is not null");
            return this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("LOCATION =", value, "location");
            return this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("LOCATION <>", value, "location");
            return this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("LOCATION >", value, "location");
            return this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION >=", value, "location");
            return this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("LOCATION <", value, "location");
            return this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("LOCATION <=", value, "location");
            return this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("LOCATION like", value, "location");
            return this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("LOCATION not like", value, "location");
            return this;
        }

        public Criteria andLocationIn(List values) {
            addCriterion("LOCATION in", values, "location");
            return this;
        }

        public Criteria andLocationNotIn(List values) {
            addCriterion("LOCATION not in", values, "location");
            return this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("LOCATION between", value1, value2, "location");
            return this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("LOCATION not between", value1, value2, "location");
            return this;
        }

        public Criteria andVerifyIsNull() {
            addCriterion("VERIFY is null");
            return this;
        }

        public Criteria andVerifyIsNotNull() {
            addCriterion("VERIFY is not null");
            return this;
        }

        public Criteria andVerifyEqualTo(String value) {
            addCriterion("VERIFY =", value, "verify");
            return this;
        }

        public Criteria andVerifyNotEqualTo(String value) {
            addCriterion("VERIFY <>", value, "verify");
            return this;
        }

        public Criteria andVerifyGreaterThan(String value) {
            addCriterion("VERIFY >", value, "verify");
            return this;
        }

        public Criteria andVerifyGreaterThanOrEqualTo(String value) {
            addCriterion("VERIFY >=", value, "verify");
            return this;
        }

        public Criteria andVerifyLessThan(String value) {
            addCriterion("VERIFY <", value, "verify");
            return this;
        }

        public Criteria andVerifyLessThanOrEqualTo(String value) {
            addCriterion("VERIFY <=", value, "verify");
            return this;
        }

        public Criteria andVerifyLike(String value) {
            addCriterion("VERIFY like", value, "verify");
            return this;
        }

        public Criteria andVerifyNotLike(String value) {
            addCriterion("VERIFY not like", value, "verify");
            return this;
        }

        public Criteria andVerifyIn(List values) {
            addCriterion("VERIFY in", values, "verify");
            return this;
        }

        public Criteria andVerifyNotIn(List values) {
            addCriterion("VERIFY not in", values, "verify");
            return this;
        }

        public Criteria andVerifyBetween(String value1, String value2) {
            addCriterion("VERIFY between", value1, value2, "verify");
            return this;
        }

        public Criteria andVerifyNotBetween(String value1, String value2) {
            addCriterion("VERIFY not between", value1, value2, "verify");
            return this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("NOTE is null");
            return this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("NOTE is not null");
            return this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("NOTE =", value, "note");
            return this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("NOTE <>", value, "note");
            return this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("NOTE >", value, "note");
            return this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("NOTE >=", value, "note");
            return this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("NOTE <", value, "note");
            return this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("NOTE <=", value, "note");
            return this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("NOTE like", value, "note");
            return this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("NOTE not like", value, "note");
            return this;
        }

        public Criteria andNoteIn(List values) {
            addCriterion("NOTE in", values, "note");
            return this;
        }

        public Criteria andNoteNotIn(List values) {
            addCriterion("NOTE not in", values, "note");
            return this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("NOTE between", value1, value2, "note");
            return this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("NOTE not between", value1, value2, "note");
            return this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return this;
        }

        public Criteria andPasswordIn(List values) {
            addCriterion("PASSWORD in", values, "password");
            return this;
        }

        public Criteria andPasswordNotIn(List values) {
            addCriterion("PASSWORD not in", values, "password");
            return this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return this;
        }

        public Criteria andUserNotifyServerIpIsNull() {
            addCriterion("USER_NOTIFY_SERVER_IP is null");
            return this;
        }

        public Criteria andUserNotifyServerIpIsNotNull() {
            addCriterion("USER_NOTIFY_SERVER_IP is not null");
            return this;
        }

        public Criteria andUserNotifyServerIpEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_IP =", value, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerIpNotEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_IP <>", value, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerIpGreaterThan(String value) {
            addCriterion("USER_NOTIFY_SERVER_IP >", value, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerIpGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_IP >=", value, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerIpLessThan(String value) {
            addCriterion("USER_NOTIFY_SERVER_IP <", value, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerIpLessThanOrEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_IP <=", value, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerIpLike(String value) {
            addCriterion("USER_NOTIFY_SERVER_IP like", value, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerIpNotLike(String value) {
            addCriterion("USER_NOTIFY_SERVER_IP not like", value, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerIpIn(List values) {
            addCriterion("USER_NOTIFY_SERVER_IP in", values, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerIpNotIn(List values) {
            addCriterion("USER_NOTIFY_SERVER_IP not in", values, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerIpBetween(String value1, String value2) {
            addCriterion("USER_NOTIFY_SERVER_IP between", value1, value2, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerIpNotBetween(String value1, String value2) {
            addCriterion("USER_NOTIFY_SERVER_IP not between", value1, value2, "userNotifyServerIp");
            return this;
        }

        public Criteria andUserNotifyServerPortIsNull() {
            addCriterion("USER_NOTIFY_SERVER_PORT is null");
            return this;
        }

        public Criteria andUserNotifyServerPortIsNotNull() {
            addCriterion("USER_NOTIFY_SERVER_PORT is not null");
            return this;
        }

        public Criteria andUserNotifyServerPortEqualTo(BigDecimal value) {
            addCriterion("USER_NOTIFY_SERVER_PORT =", value, "userNotifyServerPort");
            return this;
        }

        public Criteria andUserNotifyServerPortNotEqualTo(BigDecimal value) {
            addCriterion("USER_NOTIFY_SERVER_PORT <>", value, "userNotifyServerPort");
            return this;
        }

        public Criteria andUserNotifyServerPortGreaterThan(BigDecimal value) {
            addCriterion("USER_NOTIFY_SERVER_PORT >", value, "userNotifyServerPort");
            return this;
        }

        public Criteria andUserNotifyServerPortGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USER_NOTIFY_SERVER_PORT >=", value, "userNotifyServerPort");
            return this;
        }

        public Criteria andUserNotifyServerPortLessThan(BigDecimal value) {
            addCriterion("USER_NOTIFY_SERVER_PORT <", value, "userNotifyServerPort");
            return this;
        }

        public Criteria andUserNotifyServerPortLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USER_NOTIFY_SERVER_PORT <=", value, "userNotifyServerPort");
            return this;
        }

        public Criteria andUserNotifyServerPortIn(List values) {
            addCriterion("USER_NOTIFY_SERVER_PORT in", values, "userNotifyServerPort");
            return this;
        }

        public Criteria andUserNotifyServerPortNotIn(List values) {
            addCriterion("USER_NOTIFY_SERVER_PORT not in", values, "userNotifyServerPort");
            return this;
        }

        public Criteria andUserNotifyServerPortBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USER_NOTIFY_SERVER_PORT between", value1, value2, "userNotifyServerPort");
            return this;
        }

        public Criteria andUserNotifyServerPortNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USER_NOTIFY_SERVER_PORT not between", value1, value2, "userNotifyServerPort");
            return this;
        }

        public Criteria andUserNotifyServerUrlIsNull() {
            addCriterion("USER_NOTIFY_SERVER_URL is null");
            return this;
        }

        public Criteria andUserNotifyServerUrlIsNotNull() {
            addCriterion("USER_NOTIFY_SERVER_URL is not null");
            return this;
        }

        public Criteria andUserNotifyServerUrlEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_URL =", value, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerUrlNotEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_URL <>", value, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerUrlGreaterThan(String value) {
            addCriterion("USER_NOTIFY_SERVER_URL >", value, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_URL >=", value, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerUrlLessThan(String value) {
            addCriterion("USER_NOTIFY_SERVER_URL <", value, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerUrlLessThanOrEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_URL <=", value, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerUrlLike(String value) {
            addCriterion("USER_NOTIFY_SERVER_URL like", value, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerUrlNotLike(String value) {
            addCriterion("USER_NOTIFY_SERVER_URL not like", value, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerUrlIn(List values) {
            addCriterion("USER_NOTIFY_SERVER_URL in", values, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerUrlNotIn(List values) {
            addCriterion("USER_NOTIFY_SERVER_URL not in", values, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerUrlBetween(String value1, String value2) {
            addCriterion("USER_NOTIFY_SERVER_URL between", value1, value2, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerUrlNotBetween(String value1, String value2) {
            addCriterion("USER_NOTIFY_SERVER_URL not between", value1, value2, "userNotifyServerUrl");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameIsNull() {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME is null");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameIsNotNull() {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME is not null");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME =", value, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameNotEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME <>", value, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameGreaterThan(String value) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME >", value, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME >=", value, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameLessThan(String value) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME <", value, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameLessThanOrEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME <=", value, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameLike(String value) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME like", value, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameNotLike(String value) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME not like", value, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameIn(List values) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME in", values, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameNotIn(List values) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME not in", values, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameBetween(String value1, String value2) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME between", value1, value2, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerLoginnameNotBetween(String value1, String value2) {
            addCriterion("USER_NOTIFY_SERVER_LOGINNAME not between", value1, value2, "userNotifyServerLoginname");
            return this;
        }

        public Criteria andUserNotifyServerPasswordIsNull() {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD is null");
            return this;
        }

        public Criteria andUserNotifyServerPasswordIsNotNull() {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD is not null");
            return this;
        }

        public Criteria andUserNotifyServerPasswordEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD =", value, "userNotifyServerPassword");
            return this;
        }

        public Criteria andUserNotifyServerPasswordNotEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD <>", value, "userNotifyServerPassword");
            return this;
        }

        public Criteria andUserNotifyServerPasswordGreaterThan(String value) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD >", value, "userNotifyServerPassword");
            return this;
        }

        public Criteria andUserNotifyServerPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD >=", value, "userNotifyServerPassword");
            return this;
        }

        public Criteria andUserNotifyServerPasswordLessThan(String value) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD <", value, "userNotifyServerPassword");
            return this;
        }

        public Criteria andUserNotifyServerPasswordLessThanOrEqualTo(String value) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD <=", value, "userNotifyServerPassword");
            return this;
        }

        public Criteria andUserNotifyServerPasswordLike(String value) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD like", value, "userNotifyServerPassword");
            return this;
        }

        public Criteria andUserNotifyServerPasswordNotLike(String value) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD not like", value, "userNotifyServerPassword");
            return this;
        }

        public Criteria andUserNotifyServerPasswordIn(List values) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD in", values, "userNotifyServerPassword");
            return this;
        }

        public Criteria andUserNotifyServerPasswordNotIn(List values) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD not in", values, "userNotifyServerPassword");
            return this;
        }

        public Criteria andUserNotifyServerPasswordBetween(String value1, String value2) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD between", value1, value2, "userNotifyServerPassword");
            return this;
        }

        public Criteria andUserNotifyServerPasswordNotBetween(String value1, String value2) {
            addCriterion("USER_NOTIFY_SERVER_PASSWORD not between", value1, value2, "userNotifyServerPassword");
            return this;
        }

        public Criteria andSmsNotifyTypeIsNull() {
            addCriterion("SMS_NOTIFY_TYPE is null");
            return this;
        }

        public Criteria andSmsNotifyTypeIsNotNull() {
            addCriterion("SMS_NOTIFY_TYPE is not null");
            return this;
        }

        public Criteria andSmsNotifyTypeEqualTo(Short value) {
            addCriterion("SMS_NOTIFY_TYPE =", value, "smsNotifyType");
            return this;
        }

        public Criteria andSmsNotifyTypeNotEqualTo(Short value) {
            addCriterion("SMS_NOTIFY_TYPE <>", value, "smsNotifyType");
            return this;
        }

        public Criteria andSmsNotifyTypeGreaterThan(Short value) {
            addCriterion("SMS_NOTIFY_TYPE >", value, "smsNotifyType");
            return this;
        }

        public Criteria andSmsNotifyTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("SMS_NOTIFY_TYPE >=", value, "smsNotifyType");
            return this;
        }

        public Criteria andSmsNotifyTypeLessThan(Short value) {
            addCriterion("SMS_NOTIFY_TYPE <", value, "smsNotifyType");
            return this;
        }

        public Criteria andSmsNotifyTypeLessThanOrEqualTo(Short value) {
            addCriterion("SMS_NOTIFY_TYPE <=", value, "smsNotifyType");
            return this;
        }

        public Criteria andSmsNotifyTypeIn(List values) {
            addCriterion("SMS_NOTIFY_TYPE in", values, "smsNotifyType");
            return this;
        }

        public Criteria andSmsNotifyTypeNotIn(List values) {
            addCriterion("SMS_NOTIFY_TYPE not in", values, "smsNotifyType");
            return this;
        }

        public Criteria andSmsNotifyTypeBetween(Short value1, Short value2) {
            addCriterion("SMS_NOTIFY_TYPE between", value1, value2, "smsNotifyType");
            return this;
        }

        public Criteria andSmsNotifyTypeNotBetween(Short value1, Short value2) {
            addCriterion("SMS_NOTIFY_TYPE not between", value1, value2, "smsNotifyType");
            return this;
        }

        public Criteria andSpCodeIsNull() {
            addCriterion("SP_CODE is null");
            return this;
        }

        public Criteria andSpCodeIsNotNull() {
            addCriterion("SP_CODE is not null");
            return this;
        }

        public Criteria andSpCodeEqualTo(String value) {
            addCriterion("SP_CODE =", value, "spCode");
            return this;
        }

        public Criteria andSpCodeNotEqualTo(String value) {
            addCriterion("SP_CODE <>", value, "spCode");
            return this;
        }

        public Criteria andSpCodeGreaterThan(String value) {
            addCriterion("SP_CODE >", value, "spCode");
            return this;
        }

        public Criteria andSpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SP_CODE >=", value, "spCode");
            return this;
        }

        public Criteria andSpCodeLessThan(String value) {
            addCriterion("SP_CODE <", value, "spCode");
            return this;
        }

        public Criteria andSpCodeLessThanOrEqualTo(String value) {
            addCriterion("SP_CODE <=", value, "spCode");
            return this;
        }

        public Criteria andSpCodeLike(String value) {
            addCriterion("SP_CODE like", value, "spCode");
            return this;
        }

        public Criteria andSpCodeNotLike(String value) {
            addCriterion("SP_CODE not like", value, "spCode");
            return this;
        }

        public Criteria andSpCodeIn(List values) {
            addCriterion("SP_CODE in", values, "spCode");
            return this;
        }

        public Criteria andSpCodeNotIn(List values) {
            addCriterion("SP_CODE not in", values, "spCode");
            return this;
        }

        public Criteria andSpCodeBetween(String value1, String value2) {
            addCriterion("SP_CODE between", value1, value2, "spCode");
            return this;
        }

        public Criteria andSpCodeNotBetween(String value1, String value2) {
            addCriterion("SP_CODE not between", value1, value2, "spCode");
            return this;
        }

        public Criteria andCdrServerIpIsNull() {
            addCriterion("CDR_SERVER_IP is null");
            return this;
        }

        public Criteria andCdrServerIpIsNotNull() {
            addCriterion("CDR_SERVER_IP is not null");
            return this;
        }

        public Criteria andCdrServerIpEqualTo(String value) {
            addCriterion("CDR_SERVER_IP =", value, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerIpNotEqualTo(String value) {
            addCriterion("CDR_SERVER_IP <>", value, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerIpGreaterThan(String value) {
            addCriterion("CDR_SERVER_IP >", value, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerIpGreaterThanOrEqualTo(String value) {
            addCriterion("CDR_SERVER_IP >=", value, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerIpLessThan(String value) {
            addCriterion("CDR_SERVER_IP <", value, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerIpLessThanOrEqualTo(String value) {
            addCriterion("CDR_SERVER_IP <=", value, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerIpLike(String value) {
            addCriterion("CDR_SERVER_IP like", value, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerIpNotLike(String value) {
            addCriterion("CDR_SERVER_IP not like", value, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerIpIn(List values) {
            addCriterion("CDR_SERVER_IP in", values, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerIpNotIn(List values) {
            addCriterion("CDR_SERVER_IP not in", values, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerIpBetween(String value1, String value2) {
            addCriterion("CDR_SERVER_IP between", value1, value2, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerIpNotBetween(String value1, String value2) {
            addCriterion("CDR_SERVER_IP not between", value1, value2, "cdrServerIp");
            return this;
        }

        public Criteria andCdrServerPortIsNull() {
            addCriterion("CDR_SERVER_PORT is null");
            return this;
        }

        public Criteria andCdrServerPortIsNotNull() {
            addCriterion("CDR_SERVER_PORT is not null");
            return this;
        }

        public Criteria andCdrServerPortEqualTo(BigDecimal value) {
            addCriterion("CDR_SERVER_PORT =", value, "cdrServerPort");
            return this;
        }

        public Criteria andCdrServerPortNotEqualTo(BigDecimal value) {
            addCriterion("CDR_SERVER_PORT <>", value, "cdrServerPort");
            return this;
        }

        public Criteria andCdrServerPortGreaterThan(BigDecimal value) {
            addCriterion("CDR_SERVER_PORT >", value, "cdrServerPort");
            return this;
        }

        public Criteria andCdrServerPortGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CDR_SERVER_PORT >=", value, "cdrServerPort");
            return this;
        }

        public Criteria andCdrServerPortLessThan(BigDecimal value) {
            addCriterion("CDR_SERVER_PORT <", value, "cdrServerPort");
            return this;
        }

        public Criteria andCdrServerPortLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CDR_SERVER_PORT <=", value, "cdrServerPort");
            return this;
        }

        public Criteria andCdrServerPortIn(List values) {
            addCriterion("CDR_SERVER_PORT in", values, "cdrServerPort");
            return this;
        }

        public Criteria andCdrServerPortNotIn(List values) {
            addCriterion("CDR_SERVER_PORT not in", values, "cdrServerPort");
            return this;
        }

        public Criteria andCdrServerPortBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CDR_SERVER_PORT between", value1, value2, "cdrServerPort");
            return this;
        }

        public Criteria andCdrServerPortNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CDR_SERVER_PORT not between", value1, value2, "cdrServerPort");
            return this;
        }

        public Criteria andHttpsFlagIsNull() {
            addCriterion("HTTPS_FLAG is null");
            return this;
        }

        public Criteria andHttpsFlagIsNotNull() {
            addCriterion("HTTPS_FLAG is not null");
            return this;
        }

        public Criteria andHttpsFlagEqualTo(BigDecimal value) {
            addCriterion("HTTPS_FLAG =", value, "httpsFlag");
            return this;
        }

        public Criteria andHttpsFlagNotEqualTo(BigDecimal value) {
            addCriterion("HTTPS_FLAG <>", value, "httpsFlag");
            return this;
        }

        public Criteria andHttpsFlagGreaterThan(BigDecimal value) {
            addCriterion("HTTPS_FLAG >", value, "httpsFlag");
            return this;
        }

        public Criteria andHttpsFlagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HTTPS_FLAG >=", value, "httpsFlag");
            return this;
        }

        public Criteria andHttpsFlagLessThan(BigDecimal value) {
            addCriterion("HTTPS_FLAG <", value, "httpsFlag");
            return this;
        }

        public Criteria andHttpsFlagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HTTPS_FLAG <=", value, "httpsFlag");
            return this;
        }

        public Criteria andHttpsFlagIn(List values) {
            addCriterion("HTTPS_FLAG in", values, "httpsFlag");
            return this;
        }

        public Criteria andHttpsFlagNotIn(List values) {
            addCriterion("HTTPS_FLAG not in", values, "httpsFlag");
            return this;
        }

        public Criteria andHttpsFlagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HTTPS_FLAG between", value1, value2, "httpsFlag");
            return this;
        }

        public Criteria andHttpsFlagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HTTPS_FLAG not between", value1, value2, "httpsFlag");
            return this;
        }

        public Criteria andIsConnAuthCenterIsNull() {
            addCriterion("IS_CONN_AUTH_CENTER is null");
            return this;
        }

        public Criteria andIsConnAuthCenterIsNotNull() {
            addCriterion("IS_CONN_AUTH_CENTER is not null");
            return this;
        }

        public Criteria andIsConnAuthCenterEqualTo(Short value) {
            addCriterion("IS_CONN_AUTH_CENTER =", value, "isConnAuthCenter");
            return this;
        }

        public Criteria andIsConnAuthCenterNotEqualTo(Short value) {
            addCriterion("IS_CONN_AUTH_CENTER <>", value, "isConnAuthCenter");
            return this;
        }

        public Criteria andIsConnAuthCenterGreaterThan(Short value) {
            addCriterion("IS_CONN_AUTH_CENTER >", value, "isConnAuthCenter");
            return this;
        }

        public Criteria andIsConnAuthCenterGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_CONN_AUTH_CENTER >=", value, "isConnAuthCenter");
            return this;
        }

        public Criteria andIsConnAuthCenterLessThan(Short value) {
            addCriterion("IS_CONN_AUTH_CENTER <", value, "isConnAuthCenter");
            return this;
        }

        public Criteria andIsConnAuthCenterLessThanOrEqualTo(Short value) {
            addCriterion("IS_CONN_AUTH_CENTER <=", value, "isConnAuthCenter");
            return this;
        }

        public Criteria andIsConnAuthCenterIn(List values) {
            addCriterion("IS_CONN_AUTH_CENTER in", values, "isConnAuthCenter");
            return this;
        }

        public Criteria andIsConnAuthCenterNotIn(List values) {
            addCriterion("IS_CONN_AUTH_CENTER not in", values, "isConnAuthCenter");
            return this;
        }

        public Criteria andIsConnAuthCenterBetween(Short value1, Short value2) {
            addCriterion("IS_CONN_AUTH_CENTER between", value1, value2, "isConnAuthCenter");
            return this;
        }

        public Criteria andIsConnAuthCenterNotBetween(Short value1, Short value2) {
            addCriterion("IS_CONN_AUTH_CENTER not between", value1, value2, "isConnAuthCenter");
            return this;
        }
    }
}