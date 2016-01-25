package com.megaeyes.persistence.ibatis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpGatherServerExample {
    protected String orderByClause;

    protected List oredCriteria;

    public EpGatherServerExample() {
        oredCriteria = new ArrayList();
    }

    protected EpGatherServerExample(EpGatherServerExample example) {
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

        public Criteria andOrganIdIsNull() {
            addCriterion("ORGAN_ID is null");
            return this;
        }

        public Criteria andOrganIdIsNotNull() {
            addCriterion("ORGAN_ID is not null");
            return this;
        }

        public Criteria andOrganIdEqualTo(String value) {
            addCriterion("ORGAN_ID =", value, "organId");
            return this;
        }

        public Criteria andOrganIdNotEqualTo(String value) {
            addCriterion("ORGAN_ID <>", value, "organId");
            return this;
        }

        public Criteria andOrganIdGreaterThan(String value) {
            addCriterion("ORGAN_ID >", value, "organId");
            return this;
        }

        public Criteria andOrganIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORGAN_ID >=", value, "organId");
            return this;
        }

        public Criteria andOrganIdLessThan(String value) {
            addCriterion("ORGAN_ID <", value, "organId");
            return this;
        }

        public Criteria andOrganIdLessThanOrEqualTo(String value) {
            addCriterion("ORGAN_ID <=", value, "organId");
            return this;
        }

        public Criteria andOrganIdLike(String value) {
            addCriterion("ORGAN_ID like", value, "organId");
            return this;
        }

        public Criteria andOrganIdNotLike(String value) {
            addCriterion("ORGAN_ID not like", value, "organId");
            return this;
        }

        public Criteria andOrganIdIn(List values) {
            addCriterion("ORGAN_ID in", values, "organId");
            return this;
        }

        public Criteria andOrganIdNotIn(List values) {
            addCriterion("ORGAN_ID not in", values, "organId");
            return this;
        }

        public Criteria andOrganIdBetween(String value1, String value2) {
            addCriterion("ORGAN_ID between", value1, value2, "organId");
            return this;
        }

        public Criteria andOrganIdNotBetween(String value1, String value2) {
            addCriterion("ORGAN_ID not between", value1, value2, "organId");
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

        public Criteria andHeartCycleIsNull() {
            addCriterion("HEART_CYCLE is null");
            return this;
        }

        public Criteria andHeartCycleIsNotNull() {
            addCriterion("HEART_CYCLE is not null");
            return this;
        }

        public Criteria andHeartCycleEqualTo(Long value) {
            addCriterion("HEART_CYCLE =", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleNotEqualTo(Long value) {
            addCriterion("HEART_CYCLE <>", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleGreaterThan(Long value) {
            addCriterion("HEART_CYCLE >", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleGreaterThanOrEqualTo(Long value) {
            addCriterion("HEART_CYCLE >=", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleLessThan(Long value) {
            addCriterion("HEART_CYCLE <", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleLessThanOrEqualTo(Long value) {
            addCriterion("HEART_CYCLE <=", value, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleIn(List values) {
            addCriterion("HEART_CYCLE in", values, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleNotIn(List values) {
            addCriterion("HEART_CYCLE not in", values, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleBetween(Long value1, Long value2) {
            addCriterion("HEART_CYCLE between", value1, value2, "heartCycle");
            return this;
        }

        public Criteria andHeartCycleNotBetween(Long value1, Long value2) {
            addCriterion("HEART_CYCLE not between", value1, value2, "heartCycle");
            return this;
        }

        public Criteria andEventServerIdIsNull() {
            addCriterion("EVENT_SERVER_ID is null");
            return this;
        }

        public Criteria andEventServerIdIsNotNull() {
            addCriterion("EVENT_SERVER_ID is not null");
            return this;
        }

        public Criteria andEventServerIdEqualTo(String value) {
            addCriterion("EVENT_SERVER_ID =", value, "eventServerId");
            return this;
        }

        public Criteria andEventServerIdNotEqualTo(String value) {
            addCriterion("EVENT_SERVER_ID <>", value, "eventServerId");
            return this;
        }

        public Criteria andEventServerIdGreaterThan(String value) {
            addCriterion("EVENT_SERVER_ID >", value, "eventServerId");
            return this;
        }

        public Criteria andEventServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("EVENT_SERVER_ID >=", value, "eventServerId");
            return this;
        }

        public Criteria andEventServerIdLessThan(String value) {
            addCriterion("EVENT_SERVER_ID <", value, "eventServerId");
            return this;
        }

        public Criteria andEventServerIdLessThanOrEqualTo(String value) {
            addCriterion("EVENT_SERVER_ID <=", value, "eventServerId");
            return this;
        }

        public Criteria andEventServerIdLike(String value) {
            addCriterion("EVENT_SERVER_ID like", value, "eventServerId");
            return this;
        }

        public Criteria andEventServerIdNotLike(String value) {
            addCriterion("EVENT_SERVER_ID not like", value, "eventServerId");
            return this;
        }

        public Criteria andEventServerIdIn(List values) {
            addCriterion("EVENT_SERVER_ID in", values, "eventServerId");
            return this;
        }

        public Criteria andEventServerIdNotIn(List values) {
            addCriterion("EVENT_SERVER_ID not in", values, "eventServerId");
            return this;
        }

        public Criteria andEventServerIdBetween(String value1, String value2) {
            addCriterion("EVENT_SERVER_ID between", value1, value2, "eventServerId");
            return this;
        }

        public Criteria andEventServerIdNotBetween(String value1, String value2) {
            addCriterion("EVENT_SERVER_ID not between", value1, value2, "eventServerId");
            return this;
        }

        public Criteria andEventPortIsNull() {
            addCriterion("EVENT_PORT is null");
            return this;
        }

        public Criteria andEventPortIsNotNull() {
            addCriterion("EVENT_PORT is not null");
            return this;
        }

        public Criteria andEventPortEqualTo(String value) {
            addCriterion("EVENT_PORT =", value, "eventPort");
            return this;
        }

        public Criteria andEventPortNotEqualTo(String value) {
            addCriterion("EVENT_PORT <>", value, "eventPort");
            return this;
        }

        public Criteria andEventPortGreaterThan(String value) {
            addCriterion("EVENT_PORT >", value, "eventPort");
            return this;
        }

        public Criteria andEventPortGreaterThanOrEqualTo(String value) {
            addCriterion("EVENT_PORT >=", value, "eventPort");
            return this;
        }

        public Criteria andEventPortLessThan(String value) {
            addCriterion("EVENT_PORT <", value, "eventPort");
            return this;
        }

        public Criteria andEventPortLessThanOrEqualTo(String value) {
            addCriterion("EVENT_PORT <=", value, "eventPort");
            return this;
        }

        public Criteria andEventPortLike(String value) {
            addCriterion("EVENT_PORT like", value, "eventPort");
            return this;
        }

        public Criteria andEventPortNotLike(String value) {
            addCriterion("EVENT_PORT not like", value, "eventPort");
            return this;
        }

        public Criteria andEventPortIn(List values) {
            addCriterion("EVENT_PORT in", values, "eventPort");
            return this;
        }

        public Criteria andEventPortNotIn(List values) {
            addCriterion("EVENT_PORT not in", values, "eventPort");
            return this;
        }

        public Criteria andEventPortBetween(String value1, String value2) {
            addCriterion("EVENT_PORT between", value1, value2, "eventPort");
            return this;
        }

        public Criteria andEventPortNotBetween(String value1, String value2) {
            addCriterion("EVENT_PORT not between", value1, value2, "eventPort");
            return this;
        }

        public Criteria andClientPortIsNull() {
            addCriterion("CLIENT_PORT is null");
            return this;
        }

        public Criteria andClientPortIsNotNull() {
            addCriterion("CLIENT_PORT is not null");
            return this;
        }

        public Criteria andClientPortEqualTo(String value) {
            addCriterion("CLIENT_PORT =", value, "clientPort");
            return this;
        }

        public Criteria andClientPortNotEqualTo(String value) {
            addCriterion("CLIENT_PORT <>", value, "clientPort");
            return this;
        }

        public Criteria andClientPortGreaterThan(String value) {
            addCriterion("CLIENT_PORT >", value, "clientPort");
            return this;
        }

        public Criteria andClientPortGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_PORT >=", value, "clientPort");
            return this;
        }

        public Criteria andClientPortLessThan(String value) {
            addCriterion("CLIENT_PORT <", value, "clientPort");
            return this;
        }

        public Criteria andClientPortLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_PORT <=", value, "clientPort");
            return this;
        }

        public Criteria andClientPortLike(String value) {
            addCriterion("CLIENT_PORT like", value, "clientPort");
            return this;
        }

        public Criteria andClientPortNotLike(String value) {
            addCriterion("CLIENT_PORT not like", value, "clientPort");
            return this;
        }

        public Criteria andClientPortIn(List values) {
            addCriterion("CLIENT_PORT in", values, "clientPort");
            return this;
        }

        public Criteria andClientPortNotIn(List values) {
            addCriterion("CLIENT_PORT not in", values, "clientPort");
            return this;
        }

        public Criteria andClientPortBetween(String value1, String value2) {
            addCriterion("CLIENT_PORT between", value1, value2, "clientPort");
            return this;
        }

        public Criteria andClientPortNotBetween(String value1, String value2) {
            addCriterion("CLIENT_PORT not between", value1, value2, "clientPort");
            return this;
        }

        public Criteria andConsoleListenerIpIsNull() {
            addCriterion("CONSOLE_LISTENER_IP is null");
            return this;
        }

        public Criteria andConsoleListenerIpIsNotNull() {
            addCriterion("CONSOLE_LISTENER_IP is not null");
            return this;
        }

        public Criteria andConsoleListenerIpEqualTo(String value) {
            addCriterion("CONSOLE_LISTENER_IP =", value, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerIpNotEqualTo(String value) {
            addCriterion("CONSOLE_LISTENER_IP <>", value, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerIpGreaterThan(String value) {
            addCriterion("CONSOLE_LISTENER_IP >", value, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerIpGreaterThanOrEqualTo(String value) {
            addCriterion("CONSOLE_LISTENER_IP >=", value, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerIpLessThan(String value) {
            addCriterion("CONSOLE_LISTENER_IP <", value, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerIpLessThanOrEqualTo(String value) {
            addCriterion("CONSOLE_LISTENER_IP <=", value, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerIpLike(String value) {
            addCriterion("CONSOLE_LISTENER_IP like", value, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerIpNotLike(String value) {
            addCriterion("CONSOLE_LISTENER_IP not like", value, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerIpIn(List values) {
            addCriterion("CONSOLE_LISTENER_IP in", values, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerIpNotIn(List values) {
            addCriterion("CONSOLE_LISTENER_IP not in", values, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerIpBetween(String value1, String value2) {
            addCriterion("CONSOLE_LISTENER_IP between", value1, value2, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerIpNotBetween(String value1, String value2) {
            addCriterion("CONSOLE_LISTENER_IP not between", value1, value2, "consoleListenerIp");
            return this;
        }

        public Criteria andConsoleListenerPortIsNull() {
            addCriterion("CONSOLE_LISTENER_PORT is null");
            return this;
        }

        public Criteria andConsoleListenerPortIsNotNull() {
            addCriterion("CONSOLE_LISTENER_PORT is not null");
            return this;
        }

        public Criteria andConsoleListenerPortEqualTo(String value) {
            addCriterion("CONSOLE_LISTENER_PORT =", value, "consoleListenerPort");
            return this;
        }

        public Criteria andConsoleListenerPortNotEqualTo(String value) {
            addCriterion("CONSOLE_LISTENER_PORT <>", value, "consoleListenerPort");
            return this;
        }

        public Criteria andConsoleListenerPortGreaterThan(String value) {
            addCriterion("CONSOLE_LISTENER_PORT >", value, "consoleListenerPort");
            return this;
        }

        public Criteria andConsoleListenerPortGreaterThanOrEqualTo(String value) {
            addCriterion("CONSOLE_LISTENER_PORT >=", value, "consoleListenerPort");
            return this;
        }

        public Criteria andConsoleListenerPortLessThan(String value) {
            addCriterion("CONSOLE_LISTENER_PORT <", value, "consoleListenerPort");
            return this;
        }

        public Criteria andConsoleListenerPortLessThanOrEqualTo(String value) {
            addCriterion("CONSOLE_LISTENER_PORT <=", value, "consoleListenerPort");
            return this;
        }

        public Criteria andConsoleListenerPortLike(String value) {
            addCriterion("CONSOLE_LISTENER_PORT like", value, "consoleListenerPort");
            return this;
        }

        public Criteria andConsoleListenerPortNotLike(String value) {
            addCriterion("CONSOLE_LISTENER_PORT not like", value, "consoleListenerPort");
            return this;
        }

        public Criteria andConsoleListenerPortIn(List values) {
            addCriterion("CONSOLE_LISTENER_PORT in", values, "consoleListenerPort");
            return this;
        }

        public Criteria andConsoleListenerPortNotIn(List values) {
            addCriterion("CONSOLE_LISTENER_PORT not in", values, "consoleListenerPort");
            return this;
        }

        public Criteria andConsoleListenerPortBetween(String value1, String value2) {
            addCriterion("CONSOLE_LISTENER_PORT between", value1, value2, "consoleListenerPort");
            return this;
        }

        public Criteria andConsoleListenerPortNotBetween(String value1, String value2) {
            addCriterion("CONSOLE_LISTENER_PORT not between", value1, value2, "consoleListenerPort");
            return this;
        }

        public Criteria andConsolePasswordIsNull() {
            addCriterion("CONSOLE_PASSWORD is null");
            return this;
        }

        public Criteria andConsolePasswordIsNotNull() {
            addCriterion("CONSOLE_PASSWORD is not null");
            return this;
        }

        public Criteria andConsolePasswordEqualTo(String value) {
            addCriterion("CONSOLE_PASSWORD =", value, "consolePassword");
            return this;
        }

        public Criteria andConsolePasswordNotEqualTo(String value) {
            addCriterion("CONSOLE_PASSWORD <>", value, "consolePassword");
            return this;
        }

        public Criteria andConsolePasswordGreaterThan(String value) {
            addCriterion("CONSOLE_PASSWORD >", value, "consolePassword");
            return this;
        }

        public Criteria andConsolePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("CONSOLE_PASSWORD >=", value, "consolePassword");
            return this;
        }

        public Criteria andConsolePasswordLessThan(String value) {
            addCriterion("CONSOLE_PASSWORD <", value, "consolePassword");
            return this;
        }

        public Criteria andConsolePasswordLessThanOrEqualTo(String value) {
            addCriterion("CONSOLE_PASSWORD <=", value, "consolePassword");
            return this;
        }

        public Criteria andConsolePasswordLike(String value) {
            addCriterion("CONSOLE_PASSWORD like", value, "consolePassword");
            return this;
        }

        public Criteria andConsolePasswordNotLike(String value) {
            addCriterion("CONSOLE_PASSWORD not like", value, "consolePassword");
            return this;
        }

        public Criteria andConsolePasswordIn(List values) {
            addCriterion("CONSOLE_PASSWORD in", values, "consolePassword");
            return this;
        }

        public Criteria andConsolePasswordNotIn(List values) {
            addCriterion("CONSOLE_PASSWORD not in", values, "consolePassword");
            return this;
        }

        public Criteria andConsolePasswordBetween(String value1, String value2) {
            addCriterion("CONSOLE_PASSWORD between", value1, value2, "consolePassword");
            return this;
        }

        public Criteria andConsolePasswordNotBetween(String value1, String value2) {
            addCriterion("CONSOLE_PASSWORD not between", value1, value2, "consolePassword");
            return this;
        }

        public Criteria andClientIpIsNull() {
            addCriterion("CLIENT_IP is null");
            return this;
        }

        public Criteria andClientIpIsNotNull() {
            addCriterion("CLIENT_IP is not null");
            return this;
        }

        public Criteria andClientIpEqualTo(String value) {
            addCriterion("CLIENT_IP =", value, "clientIp");
            return this;
        }

        public Criteria andClientIpNotEqualTo(String value) {
            addCriterion("CLIENT_IP <>", value, "clientIp");
            return this;
        }

        public Criteria andClientIpGreaterThan(String value) {
            addCriterion("CLIENT_IP >", value, "clientIp");
            return this;
        }

        public Criteria andClientIpGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_IP >=", value, "clientIp");
            return this;
        }

        public Criteria andClientIpLessThan(String value) {
            addCriterion("CLIENT_IP <", value, "clientIp");
            return this;
        }

        public Criteria andClientIpLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_IP <=", value, "clientIp");
            return this;
        }

        public Criteria andClientIpLike(String value) {
            addCriterion("CLIENT_IP like", value, "clientIp");
            return this;
        }

        public Criteria andClientIpNotLike(String value) {
            addCriterion("CLIENT_IP not like", value, "clientIp");
            return this;
        }

        public Criteria andClientIpIn(List values) {
            addCriterion("CLIENT_IP in", values, "clientIp");
            return this;
        }

        public Criteria andClientIpNotIn(List values) {
            addCriterion("CLIENT_IP not in", values, "clientIp");
            return this;
        }

        public Criteria andClientIpBetween(String value1, String value2) {
            addCriterion("CLIENT_IP between", value1, value2, "clientIp");
            return this;
        }

        public Criteria andClientIpNotBetween(String value1, String value2) {
            addCriterion("CLIENT_IP not between", value1, value2, "clientIp");
            return this;
        }

        public Criteria andEventIpIsNull() {
            addCriterion("EVENT_IP is null");
            return this;
        }

        public Criteria andEventIpIsNotNull() {
            addCriterion("EVENT_IP is not null");
            return this;
        }

        public Criteria andEventIpEqualTo(String value) {
            addCriterion("EVENT_IP =", value, "eventIp");
            return this;
        }

        public Criteria andEventIpNotEqualTo(String value) {
            addCriterion("EVENT_IP <>", value, "eventIp");
            return this;
        }

        public Criteria andEventIpGreaterThan(String value) {
            addCriterion("EVENT_IP >", value, "eventIp");
            return this;
        }

        public Criteria andEventIpGreaterThanOrEqualTo(String value) {
            addCriterion("EVENT_IP >=", value, "eventIp");
            return this;
        }

        public Criteria andEventIpLessThan(String value) {
            addCriterion("EVENT_IP <", value, "eventIp");
            return this;
        }

        public Criteria andEventIpLessThanOrEqualTo(String value) {
            addCriterion("EVENT_IP <=", value, "eventIp");
            return this;
        }

        public Criteria andEventIpLike(String value) {
            addCriterion("EVENT_IP like", value, "eventIp");
            return this;
        }

        public Criteria andEventIpNotLike(String value) {
            addCriterion("EVENT_IP not like", value, "eventIp");
            return this;
        }

        public Criteria andEventIpIn(List values) {
            addCriterion("EVENT_IP in", values, "eventIp");
            return this;
        }

        public Criteria andEventIpNotIn(List values) {
            addCriterion("EVENT_IP not in", values, "eventIp");
            return this;
        }

        public Criteria andEventIpBetween(String value1, String value2) {
            addCriterion("EVENT_IP between", value1, value2, "eventIp");
            return this;
        }

        public Criteria andEventIpNotBetween(String value1, String value2) {
            addCriterion("EVENT_IP not between", value1, value2, "eventIp");
            return this;
        }

        public Criteria andDeviceNumberIsNull() {
            addCriterion("DEVICE_NUMBER is null");
            return this;
        }

        public Criteria andDeviceNumberIsNotNull() {
            addCriterion("DEVICE_NUMBER is not null");
            return this;
        }

        public Criteria andDeviceNumberEqualTo(String value) {
            addCriterion("DEVICE_NUMBER =", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberNotEqualTo(String value) {
            addCriterion("DEVICE_NUMBER <>", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberGreaterThan(String value) {
            addCriterion("DEVICE_NUMBER >", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_NUMBER >=", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberLessThan(String value) {
            addCriterion("DEVICE_NUMBER <", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_NUMBER <=", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberLike(String value) {
            addCriterion("DEVICE_NUMBER like", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberNotLike(String value) {
            addCriterion("DEVICE_NUMBER not like", value, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberIn(List values) {
            addCriterion("DEVICE_NUMBER in", values, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberNotIn(List values) {
            addCriterion("DEVICE_NUMBER not in", values, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberBetween(String value1, String value2) {
            addCriterion("DEVICE_NUMBER between", value1, value2, "deviceNumber");
            return this;
        }

        public Criteria andDeviceNumberNotBetween(String value1, String value2) {
            addCriterion("DEVICE_NUMBER not between", value1, value2, "deviceNumber");
            return this;
        }
    }
}