package com.megaeyes.persistence.ibatis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IpCameraVicExample {
    protected String orderByClause;

    protected List oredCriteria;

    public IpCameraVicExample() {
        oredCriteria = new ArrayList();
    }

    protected IpCameraVicExample(IpCameraVicExample example) {
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

        public Criteria andHostIsNull() {
            addCriterion("HOST is null");
            return this;
        }

        public Criteria andHostIsNotNull() {
            addCriterion("HOST is not null");
            return this;
        }

        public Criteria andHostEqualTo(String value) {
            addCriterion("HOST =", value, "host");
            return this;
        }

        public Criteria andHostNotEqualTo(String value) {
            addCriterion("HOST <>", value, "host");
            return this;
        }

        public Criteria andHostGreaterThan(String value) {
            addCriterion("HOST >", value, "host");
            return this;
        }

        public Criteria andHostGreaterThanOrEqualTo(String value) {
            addCriterion("HOST >=", value, "host");
            return this;
        }

        public Criteria andHostLessThan(String value) {
            addCriterion("HOST <", value, "host");
            return this;
        }

        public Criteria andHostLessThanOrEqualTo(String value) {
            addCriterion("HOST <=", value, "host");
            return this;
        }

        public Criteria andHostLike(String value) {
            addCriterion("HOST like", value, "host");
            return this;
        }

        public Criteria andHostNotLike(String value) {
            addCriterion("HOST not like", value, "host");
            return this;
        }

        public Criteria andHostIn(List values) {
            addCriterion("HOST in", values, "host");
            return this;
        }

        public Criteria andHostNotIn(List values) {
            addCriterion("HOST not in", values, "host");
            return this;
        }

        public Criteria andHostBetween(String value1, String value2) {
            addCriterion("HOST between", value1, value2, "host");
            return this;
        }

        public Criteria andHostNotBetween(String value1, String value2) {
            addCriterion("HOST not between", value1, value2, "host");
            return this;
        }

        public Criteria andPortIsNull() {
            addCriterion("PORT is null");
            return this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("PORT is not null");
            return this;
        }

        public Criteria andPortEqualTo(Long value) {
            addCriterion("PORT =", value, "port");
            return this;
        }

        public Criteria andPortNotEqualTo(Long value) {
            addCriterion("PORT <>", value, "port");
            return this;
        }

        public Criteria andPortGreaterThan(Long value) {
            addCriterion("PORT >", value, "port");
            return this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Long value) {
            addCriterion("PORT >=", value, "port");
            return this;
        }

        public Criteria andPortLessThan(Long value) {
            addCriterion("PORT <", value, "port");
            return this;
        }

        public Criteria andPortLessThanOrEqualTo(Long value) {
            addCriterion("PORT <=", value, "port");
            return this;
        }

        public Criteria andPortIn(List values) {
            addCriterion("PORT in", values, "port");
            return this;
        }

        public Criteria andPortNotIn(List values) {
            addCriterion("PORT not in", values, "port");
            return this;
        }

        public Criteria andPortBetween(Long value1, Long value2) {
            addCriterion("PORT between", value1, value2, "port");
            return this;
        }

        public Criteria andPortNotBetween(Long value1, Long value2) {
            addCriterion("PORT not between", value1, value2, "port");
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

        public Criteria andMobilephone1IsNull() {
            addCriterion("MOBILEPHONE1 is null");
            return this;
        }

        public Criteria andMobilephone1IsNotNull() {
            addCriterion("MOBILEPHONE1 is not null");
            return this;
        }

        public Criteria andMobilephone1EqualTo(String value) {
            addCriterion("MOBILEPHONE1 =", value, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone1NotEqualTo(String value) {
            addCriterion("MOBILEPHONE1 <>", value, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone1GreaterThan(String value) {
            addCriterion("MOBILEPHONE1 >", value, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone1GreaterThanOrEqualTo(String value) {
            addCriterion("MOBILEPHONE1 >=", value, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone1LessThan(String value) {
            addCriterion("MOBILEPHONE1 <", value, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone1LessThanOrEqualTo(String value) {
            addCriterion("MOBILEPHONE1 <=", value, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone1Like(String value) {
            addCriterion("MOBILEPHONE1 like", value, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone1NotLike(String value) {
            addCriterion("MOBILEPHONE1 not like", value, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone1In(List values) {
            addCriterion("MOBILEPHONE1 in", values, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone1NotIn(List values) {
            addCriterion("MOBILEPHONE1 not in", values, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone1Between(String value1, String value2) {
            addCriterion("MOBILEPHONE1 between", value1, value2, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone1NotBetween(String value1, String value2) {
            addCriterion("MOBILEPHONE1 not between", value1, value2, "mobilephone1");
            return this;
        }

        public Criteria andMobilephone2IsNull() {
            addCriterion("MOBILEPHONE2 is null");
            return this;
        }

        public Criteria andMobilephone2IsNotNull() {
            addCriterion("MOBILEPHONE2 is not null");
            return this;
        }

        public Criteria andMobilephone2EqualTo(String value) {
            addCriterion("MOBILEPHONE2 =", value, "mobilephone2");
            return this;
        }

        public Criteria andMobilephone2NotEqualTo(String value) {
            addCriterion("MOBILEPHONE2 <>", value, "mobilephone2");
            return this;
        }

        public Criteria andMobilephone2GreaterThan(String value) {
            addCriterion("MOBILEPHONE2 >", value, "mobilephone2");
            return this;
        }

        public Criteria andMobilephone2GreaterThanOrEqualTo(String value) {
            addCriterion("MOBILEPHONE2 >=", value, "mobilephone2");
            return this;
        }

        public Criteria andMobilephone2LessThan(String value) {
            addCriterion("MOBILEPHONE2 <", value, "mobilephone2");
            return this;
        }

        public Criteria andMobilephone2LessThanOrEqualTo(String value) {
            addCriterion("MOBILEPHONE2 <=", value, "mobilephone2");
            return this;
        }

        public Criteria andMobilephone2Like(String value) {
            addCriterion("MOBILEPHONE2 like", value, "mobilephone2");
            return this;
        }

        public Criteria andMobilephone2NotLike(String value) {
            addCriterion("MOBILEPHONE2 not like", value, "mobilephone2");
            return this;
        }

        public Criteria andMobilephone2In(List values) {
            addCriterion("MOBILEPHONE2 in", values, "mobilephone2");
            return this;
        }

        public Criteria andMobilephone2NotIn(List values) {
            addCriterion("MOBILEPHONE2 not in", values, "mobilephone2");
            return this;
        }

        public Criteria andMobilephone2Between(String value1, String value2) {
            addCriterion("MOBILEPHONE2 between", value1, value2, "mobilephone2");
            return this;
        }

        public Criteria andMobilephone2NotBetween(String value1, String value2) {
            addCriterion("MOBILEPHONE2 not between", value1, value2, "mobilephone2");
            return this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return this;
        }

        public Criteria andEmailIn(List values) {
            addCriterion("EMAIL in", values, "email");
            return this;
        }

        public Criteria andEmailNotIn(List values) {
            addCriterion("EMAIL not in", values, "email");
            return this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("DEVICE_TYPE is null");
            return this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("DEVICE_TYPE is not null");
            return this;
        }

        public Criteria andDeviceTypeEqualTo(String value) {
            addCriterion("DEVICE_TYPE =", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("DEVICE_TYPE <>", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeGreaterThan(String value) {
            addCriterion("DEVICE_TYPE >", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_TYPE >=", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeLessThan(String value) {
            addCriterion("DEVICE_TYPE <", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_TYPE <=", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeLike(String value) {
            addCriterion("DEVICE_TYPE like", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotLike(String value) {
            addCriterion("DEVICE_TYPE not like", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeIn(List values) {
            addCriterion("DEVICE_TYPE in", values, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotIn(List values) {
            addCriterion("DEVICE_TYPE not in", values, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("DEVICE_TYPE between", value1, value2, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("DEVICE_TYPE not between", value1, value2, "deviceType");
            return this;
        }

        public Criteria andSdSupportIsNull() {
            addCriterion("SD_SUPPORT is null");
            return this;
        }

        public Criteria andSdSupportIsNotNull() {
            addCriterion("SD_SUPPORT is not null");
            return this;
        }

        public Criteria andSdSupportEqualTo(Short value) {
            addCriterion("SD_SUPPORT =", value, "sdSupport");
            return this;
        }

        public Criteria andSdSupportNotEqualTo(Short value) {
            addCriterion("SD_SUPPORT <>", value, "sdSupport");
            return this;
        }

        public Criteria andSdSupportGreaterThan(Short value) {
            addCriterion("SD_SUPPORT >", value, "sdSupport");
            return this;
        }

        public Criteria andSdSupportGreaterThanOrEqualTo(Short value) {
            addCriterion("SD_SUPPORT >=", value, "sdSupport");
            return this;
        }

        public Criteria andSdSupportLessThan(Short value) {
            addCriterion("SD_SUPPORT <", value, "sdSupport");
            return this;
        }

        public Criteria andSdSupportLessThanOrEqualTo(Short value) {
            addCriterion("SD_SUPPORT <=", value, "sdSupport");
            return this;
        }

        public Criteria andSdSupportIn(List values) {
            addCriterion("SD_SUPPORT in", values, "sdSupport");
            return this;
        }

        public Criteria andSdSupportNotIn(List values) {
            addCriterion("SD_SUPPORT not in", values, "sdSupport");
            return this;
        }

        public Criteria andSdSupportBetween(Short value1, Short value2) {
            addCriterion("SD_SUPPORT between", value1, value2, "sdSupport");
            return this;
        }

        public Criteria andSdSupportNotBetween(Short value1, Short value2) {
            addCriterion("SD_SUPPORT not between", value1, value2, "sdSupport");
            return this;
        }
    }
}