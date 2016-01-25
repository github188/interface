package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyExample {
    protected String orderByClause;

    protected List oredCriteria;

    public CompanyExample() {
        oredCriteria = new ArrayList();
    }

    protected CompanyExample(CompanyExample example) {
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

        public Criteria andLinkmanIsNull() {
            addCriterion("LINKMAN is null");
            return this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("LINKMAN is not null");
            return this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("LINKMAN =", value, "linkman");
            return this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("LINKMAN <>", value, "linkman");
            return this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("LINKMAN >", value, "linkman");
            return this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("LINKMAN >=", value, "linkman");
            return this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("LINKMAN <", value, "linkman");
            return this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("LINKMAN <=", value, "linkman");
            return this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("LINKMAN like", value, "linkman");
            return this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("LINKMAN not like", value, "linkman");
            return this;
        }

        public Criteria andLinkmanIn(List values) {
            addCriterion("LINKMAN in", values, "linkman");
            return this;
        }

        public Criteria andLinkmanNotIn(List values) {
            addCriterion("LINKMAN not in", values, "linkman");
            return this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("LINKMAN between", value1, value2, "linkman");
            return this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("LINKMAN not between", value1, value2, "linkman");
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

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return this;
        }

        public Criteria andPhoneIn(List values) {
            addCriterion("PHONE in", values, "phone");
            return this;
        }

        public Criteria andPhoneNotIn(List values) {
            addCriterion("PHONE not in", values, "phone");
            return this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("FAX is null");
            return this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("FAX is not null");
            return this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("FAX =", value, "fax");
            return this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("FAX <>", value, "fax");
            return this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("FAX >", value, "fax");
            return this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("FAX >=", value, "fax");
            return this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("FAX <", value, "fax");
            return this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("FAX <=", value, "fax");
            return this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("FAX like", value, "fax");
            return this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("FAX not like", value, "fax");
            return this;
        }

        public Criteria andFaxIn(List values) {
            addCriterion("FAX in", values, "fax");
            return this;
        }

        public Criteria andFaxNotIn(List values) {
            addCriterion("FAX not in", values, "fax");
            return this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("FAX between", value1, value2, "fax");
            return this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("FAX not between", value1, value2, "fax");
            return this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return this;
        }

        public Criteria andAddressIn(List values) {
            addCriterion("ADDRESS in", values, "address");
            return this;
        }

        public Criteria andAddressNotIn(List values) {
            addCriterion("ADDRESS not in", values, "address");
            return this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return this;
        }

        public Criteria andPostalcodeIsNull() {
            addCriterion("POSTALCODE is null");
            return this;
        }

        public Criteria andPostalcodeIsNotNull() {
            addCriterion("POSTALCODE is not null");
            return this;
        }

        public Criteria andPostalcodeEqualTo(String value) {
            addCriterion("POSTALCODE =", value, "postalcode");
            return this;
        }

        public Criteria andPostalcodeNotEqualTo(String value) {
            addCriterion("POSTALCODE <>", value, "postalcode");
            return this;
        }

        public Criteria andPostalcodeGreaterThan(String value) {
            addCriterion("POSTALCODE >", value, "postalcode");
            return this;
        }

        public Criteria andPostalcodeGreaterThanOrEqualTo(String value) {
            addCriterion("POSTALCODE >=", value, "postalcode");
            return this;
        }

        public Criteria andPostalcodeLessThan(String value) {
            addCriterion("POSTALCODE <", value, "postalcode");
            return this;
        }

        public Criteria andPostalcodeLessThanOrEqualTo(String value) {
            addCriterion("POSTALCODE <=", value, "postalcode");
            return this;
        }

        public Criteria andPostalcodeLike(String value) {
            addCriterion("POSTALCODE like", value, "postalcode");
            return this;
        }

        public Criteria andPostalcodeNotLike(String value) {
            addCriterion("POSTALCODE not like", value, "postalcode");
            return this;
        }

        public Criteria andPostalcodeIn(List values) {
            addCriterion("POSTALCODE in", values, "postalcode");
            return this;
        }

        public Criteria andPostalcodeNotIn(List values) {
            addCriterion("POSTALCODE not in", values, "postalcode");
            return this;
        }

        public Criteria andPostalcodeBetween(String value1, String value2) {
            addCriterion("POSTALCODE between", value1, value2, "postalcode");
            return this;
        }

        public Criteria andPostalcodeNotBetween(String value1, String value2) {
            addCriterion("POSTALCODE not between", value1, value2, "postalcode");
            return this;
        }

        public Criteria andIsSuspendedIsNull() {
            addCriterion("IS_SUSPENDED is null");
            return this;
        }

        public Criteria andIsSuspendedIsNotNull() {
            addCriterion("IS_SUSPENDED is not null");
            return this;
        }

        public Criteria andIsSuspendedEqualTo(Short value) {
            addCriterion("IS_SUSPENDED =", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedNotEqualTo(Short value) {
            addCriterion("IS_SUSPENDED <>", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedGreaterThan(Short value) {
            addCriterion("IS_SUSPENDED >", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_SUSPENDED >=", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedLessThan(Short value) {
            addCriterion("IS_SUSPENDED <", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedLessThanOrEqualTo(Short value) {
            addCriterion("IS_SUSPENDED <=", value, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedIn(List values) {
            addCriterion("IS_SUSPENDED in", values, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedNotIn(List values) {
            addCriterion("IS_SUSPENDED not in", values, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedBetween(Short value1, Short value2) {
            addCriterion("IS_SUSPENDED between", value1, value2, "isSuspended");
            return this;
        }

        public Criteria andIsSuspendedNotBetween(Short value1, Short value2) {
            addCriterion("IS_SUSPENDED not between", value1, value2, "isSuspended");
            return this;
        }

        public Criteria andFNumberIsNull() {
            addCriterion("F_NUMBER is null");
            return this;
        }

        public Criteria andFNumberIsNotNull() {
            addCriterion("F_NUMBER is not null");
            return this;
        }

        public Criteria andFNumberEqualTo(String value) {
            addCriterion("F_NUMBER =", value, "fNumber");
            return this;
        }

        public Criteria andFNumberNotEqualTo(String value) {
            addCriterion("F_NUMBER <>", value, "fNumber");
            return this;
        }

        public Criteria andFNumberGreaterThan(String value) {
            addCriterion("F_NUMBER >", value, "fNumber");
            return this;
        }

        public Criteria andFNumberGreaterThanOrEqualTo(String value) {
            addCriterion("F_NUMBER >=", value, "fNumber");
            return this;
        }

        public Criteria andFNumberLessThan(String value) {
            addCriterion("F_NUMBER <", value, "fNumber");
            return this;
        }

        public Criteria andFNumberLessThanOrEqualTo(String value) {
            addCriterion("F_NUMBER <=", value, "fNumber");
            return this;
        }

        public Criteria andFNumberLike(String value) {
            addCriterion("F_NUMBER like", value, "fNumber");
            return this;
        }

        public Criteria andFNumberNotLike(String value) {
            addCriterion("F_NUMBER not like", value, "fNumber");
            return this;
        }

        public Criteria andFNumberIn(List values) {
            addCriterion("F_NUMBER in", values, "fNumber");
            return this;
        }

        public Criteria andFNumberNotIn(List values) {
            addCriterion("F_NUMBER not in", values, "fNumber");
            return this;
        }

        public Criteria andFNumberBetween(String value1, String value2) {
            addCriterion("F_NUMBER between", value1, value2, "fNumber");
            return this;
        }

        public Criteria andFNumberNotBetween(String value1, String value2) {
            addCriterion("F_NUMBER not between", value1, value2, "fNumber");
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return this;
        }

        public Criteria andCreatetimeEqualTo(BigDecimal value) {
            addCriterion("CREATETIME =", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeNotEqualTo(BigDecimal value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeGreaterThan(BigDecimal value) {
            addCriterion("CREATETIME >", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeLessThan(BigDecimal value) {
            addCriterion("CREATETIME <", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return this;
        }

        public Criteria andCreatetimeIn(List values) {
            addCriterion("CREATETIME in", values, "createtime");
            return this;
        }

        public Criteria andCreatetimeNotIn(List values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return this;
        }

        public Criteria andCreatetimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return this;
        }

        public Criteria andCreatetimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return this;
        }

        public Criteria andIsMspIsNull() {
            addCriterion("IS_MSP is null");
            return this;
        }

        public Criteria andIsMspIsNotNull() {
            addCriterion("IS_MSP is not null");
            return this;
        }

        public Criteria andIsMspEqualTo(Short value) {
            addCriterion("IS_MSP =", value, "isMsp");
            return this;
        }

        public Criteria andIsMspNotEqualTo(Short value) {
            addCriterion("IS_MSP <>", value, "isMsp");
            return this;
        }

        public Criteria andIsMspGreaterThan(Short value) {
            addCriterion("IS_MSP >", value, "isMsp");
            return this;
        }

        public Criteria andIsMspGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_MSP >=", value, "isMsp");
            return this;
        }

        public Criteria andIsMspLessThan(Short value) {
            addCriterion("IS_MSP <", value, "isMsp");
            return this;
        }

        public Criteria andIsMspLessThanOrEqualTo(Short value) {
            addCriterion("IS_MSP <=", value, "isMsp");
            return this;
        }

        public Criteria andIsMspIn(List values) {
            addCriterion("IS_MSP in", values, "isMsp");
            return this;
        }

        public Criteria andIsMspNotIn(List values) {
            addCriterion("IS_MSP not in", values, "isMsp");
            return this;
        }

        public Criteria andIsMspBetween(Short value1, Short value2) {
            addCriterion("IS_MSP between", value1, value2, "isMsp");
            return this;
        }

        public Criteria andIsMspNotBetween(Short value1, Short value2) {
            addCriterion("IS_MSP not between", value1, value2, "isMsp");
            return this;
        }
    }
}