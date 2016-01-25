package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoInputServerModelExample {
    protected String orderByClause;

    protected List oredCriteria;

    public VideoInputServerModelExample() {
        oredCriteria = new ArrayList();
    }

    protected VideoInputServerModelExample(VideoInputServerModelExample example) {
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

        public Criteria andFTypeIsNull() {
            addCriterion("F_TYPE is null");
            return this;
        }

        public Criteria andFTypeIsNotNull() {
            addCriterion("F_TYPE is not null");
            return this;
        }

        public Criteria andFTypeEqualTo(String value) {
            addCriterion("F_TYPE =", value, "fType");
            return this;
        }

        public Criteria andFTypeNotEqualTo(String value) {
            addCriterion("F_TYPE <>", value, "fType");
            return this;
        }

        public Criteria andFTypeGreaterThan(String value) {
            addCriterion("F_TYPE >", value, "fType");
            return this;
        }

        public Criteria andFTypeGreaterThanOrEqualTo(String value) {
            addCriterion("F_TYPE >=", value, "fType");
            return this;
        }

        public Criteria andFTypeLessThan(String value) {
            addCriterion("F_TYPE <", value, "fType");
            return this;
        }

        public Criteria andFTypeLessThanOrEqualTo(String value) {
            addCriterion("F_TYPE <=", value, "fType");
            return this;
        }

        public Criteria andFTypeLike(String value) {
            addCriterion("F_TYPE like", value, "fType");
            return this;
        }

        public Criteria andFTypeNotLike(String value) {
            addCriterion("F_TYPE not like", value, "fType");
            return this;
        }

        public Criteria andFTypeIn(List values) {
            addCriterion("F_TYPE in", values, "fType");
            return this;
        }

        public Criteria andFTypeNotIn(List values) {
            addCriterion("F_TYPE not in", values, "fType");
            return this;
        }

        public Criteria andFTypeBetween(String value1, String value2) {
            addCriterion("F_TYPE between", value1, value2, "fType");
            return this;
        }

        public Criteria andFTypeNotBetween(String value1, String value2) {
            addCriterion("F_TYPE not between", value1, value2, "fType");
            return this;
        }

        public Criteria andEncodeIsNull() {
            addCriterion("ENCODE is null");
            return this;
        }

        public Criteria andEncodeIsNotNull() {
            addCriterion("ENCODE is not null");
            return this;
        }

        public Criteria andEncodeEqualTo(String value) {
            addCriterion("ENCODE =", value, "encode");
            return this;
        }

        public Criteria andEncodeNotEqualTo(String value) {
            addCriterion("ENCODE <>", value, "encode");
            return this;
        }

        public Criteria andEncodeGreaterThan(String value) {
            addCriterion("ENCODE >", value, "encode");
            return this;
        }

        public Criteria andEncodeGreaterThanOrEqualTo(String value) {
            addCriterion("ENCODE >=", value, "encode");
            return this;
        }

        public Criteria andEncodeLessThan(String value) {
            addCriterion("ENCODE <", value, "encode");
            return this;
        }

        public Criteria andEncodeLessThanOrEqualTo(String value) {
            addCriterion("ENCODE <=", value, "encode");
            return this;
        }

        public Criteria andEncodeLike(String value) {
            addCriterion("ENCODE like", value, "encode");
            return this;
        }

        public Criteria andEncodeNotLike(String value) {
            addCriterion("ENCODE not like", value, "encode");
            return this;
        }

        public Criteria andEncodeIn(List values) {
            addCriterion("ENCODE in", values, "encode");
            return this;
        }

        public Criteria andEncodeNotIn(List values) {
            addCriterion("ENCODE not in", values, "encode");
            return this;
        }

        public Criteria andEncodeBetween(String value1, String value2) {
            addCriterion("ENCODE between", value1, value2, "encode");
            return this;
        }

        public Criteria andEncodeNotBetween(String value1, String value2) {
            addCriterion("ENCODE not between", value1, value2, "encode");
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

        public Criteria andManufacturerIdIsNull() {
            addCriterion("MANUFACTURER_ID is null");
            return this;
        }

        public Criteria andManufacturerIdIsNotNull() {
            addCriterion("MANUFACTURER_ID is not null");
            return this;
        }

        public Criteria andManufacturerIdEqualTo(String value) {
            addCriterion("MANUFACTURER_ID =", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdNotEqualTo(String value) {
            addCriterion("MANUFACTURER_ID <>", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdGreaterThan(String value) {
            addCriterion("MANUFACTURER_ID >", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdGreaterThanOrEqualTo(String value) {
            addCriterion("MANUFACTURER_ID >=", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdLessThan(String value) {
            addCriterion("MANUFACTURER_ID <", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdLessThanOrEqualTo(String value) {
            addCriterion("MANUFACTURER_ID <=", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdLike(String value) {
            addCriterion("MANUFACTURER_ID like", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdNotLike(String value) {
            addCriterion("MANUFACTURER_ID not like", value, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdIn(List values) {
            addCriterion("MANUFACTURER_ID in", values, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdNotIn(List values) {
            addCriterion("MANUFACTURER_ID not in", values, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdBetween(String value1, String value2) {
            addCriterion("MANUFACTURER_ID between", value1, value2, "manufacturerId");
            return this;
        }

        public Criteria andManufacturerIdNotBetween(String value1, String value2) {
            addCriterion("MANUFACTURER_ID not between", value1, value2, "manufacturerId");
            return this;
        }

        public Criteria andDecodeIsNull() {
            addCriterion("DECODE is null");
            return this;
        }

        public Criteria andDecodeIsNotNull() {
            addCriterion("DECODE is not null");
            return this;
        }

        public Criteria andDecodeEqualTo(String value) {
            addCriterion("DECODE =", value, "decode");
            return this;
        }

        public Criteria andDecodeNotEqualTo(String value) {
            addCriterion("DECODE <>", value, "decode");
            return this;
        }

        public Criteria andDecodeGreaterThan(String value) {
            addCriterion("DECODE >", value, "decode");
            return this;
        }

        public Criteria andDecodeGreaterThanOrEqualTo(String value) {
            addCriterion("DECODE >=", value, "decode");
            return this;
        }

        public Criteria andDecodeLessThan(String value) {
            addCriterion("DECODE <", value, "decode");
            return this;
        }

        public Criteria andDecodeLessThanOrEqualTo(String value) {
            addCriterion("DECODE <=", value, "decode");
            return this;
        }

        public Criteria andDecodeLike(String value) {
            addCriterion("DECODE like", value, "decode");
            return this;
        }

        public Criteria andDecodeNotLike(String value) {
            addCriterion("DECODE not like", value, "decode");
            return this;
        }

        public Criteria andDecodeIn(List values) {
            addCriterion("DECODE in", values, "decode");
            return this;
        }

        public Criteria andDecodeNotIn(List values) {
            addCriterion("DECODE not in", values, "decode");
            return this;
        }

        public Criteria andDecodeBetween(String value1, String value2) {
            addCriterion("DECODE between", value1, value2, "decode");
            return this;
        }

        public Criteria andDecodeNotBetween(String value1, String value2) {
            addCriterion("DECODE not between", value1, value2, "decode");
            return this;
        }

        public Criteria andRtpPayloadIsNull() {
            addCriterion("RTP_PAYLOAD is null");
            return this;
        }

        public Criteria andRtpPayloadIsNotNull() {
            addCriterion("RTP_PAYLOAD is not null");
            return this;
        }

        public Criteria andRtpPayloadEqualTo(String value) {
            addCriterion("RTP_PAYLOAD =", value, "rtpPayload");
            return this;
        }

        public Criteria andRtpPayloadNotEqualTo(String value) {
            addCriterion("RTP_PAYLOAD <>", value, "rtpPayload");
            return this;
        }

        public Criteria andRtpPayloadGreaterThan(String value) {
            addCriterion("RTP_PAYLOAD >", value, "rtpPayload");
            return this;
        }

        public Criteria andRtpPayloadGreaterThanOrEqualTo(String value) {
            addCriterion("RTP_PAYLOAD >=", value, "rtpPayload");
            return this;
        }

        public Criteria andRtpPayloadLessThan(String value) {
            addCriterion("RTP_PAYLOAD <", value, "rtpPayload");
            return this;
        }

        public Criteria andRtpPayloadLessThanOrEqualTo(String value) {
            addCriterion("RTP_PAYLOAD <=", value, "rtpPayload");
            return this;
        }

        public Criteria andRtpPayloadLike(String value) {
            addCriterion("RTP_PAYLOAD like", value, "rtpPayload");
            return this;
        }

        public Criteria andRtpPayloadNotLike(String value) {
            addCriterion("RTP_PAYLOAD not like", value, "rtpPayload");
            return this;
        }

        public Criteria andRtpPayloadIn(List values) {
            addCriterion("RTP_PAYLOAD in", values, "rtpPayload");
            return this;
        }

        public Criteria andRtpPayloadNotIn(List values) {
            addCriterion("RTP_PAYLOAD not in", values, "rtpPayload");
            return this;
        }

        public Criteria andRtpPayloadBetween(String value1, String value2) {
            addCriterion("RTP_PAYLOAD between", value1, value2, "rtpPayload");
            return this;
        }

        public Criteria andRtpPayloadNotBetween(String value1, String value2) {
            addCriterion("RTP_PAYLOAD not between", value1, value2, "rtpPayload");
            return this;
        }
    }
}