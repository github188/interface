package com.megaeyes.persistence.ibatis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlatformResourcesExample {
    protected String orderByClause;

    protected List oredCriteria;

    public PlatformResourcesExample() {
        oredCriteria = new ArrayList();
    }

    protected PlatformResourcesExample(PlatformResourcesExample example) {
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

        public Criteria andResourceIdIsNull() {
            addCriterion("RESOURCE_ID is null");
            return this;
        }

        public Criteria andResourceIdIsNotNull() {
            addCriterion("RESOURCE_ID is not null");
            return this;
        }

        public Criteria andResourceIdEqualTo(String value) {
            addCriterion("RESOURCE_ID =", value, "resourceId");
            return this;
        }

        public Criteria andResourceIdNotEqualTo(String value) {
            addCriterion("RESOURCE_ID <>", value, "resourceId");
            return this;
        }

        public Criteria andResourceIdGreaterThan(String value) {
            addCriterion("RESOURCE_ID >", value, "resourceId");
            return this;
        }

        public Criteria andResourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_ID >=", value, "resourceId");
            return this;
        }

        public Criteria andResourceIdLessThan(String value) {
            addCriterion("RESOURCE_ID <", value, "resourceId");
            return this;
        }

        public Criteria andResourceIdLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_ID <=", value, "resourceId");
            return this;
        }

        public Criteria andResourceIdLike(String value) {
            addCriterion("RESOURCE_ID like", value, "resourceId");
            return this;
        }

        public Criteria andResourceIdNotLike(String value) {
            addCriterion("RESOURCE_ID not like", value, "resourceId");
            return this;
        }

        public Criteria andResourceIdIn(List values) {
            addCriterion("RESOURCE_ID in", values, "resourceId");
            return this;
        }

        public Criteria andResourceIdNotIn(List values) {
            addCriterion("RESOURCE_ID not in", values, "resourceId");
            return this;
        }

        public Criteria andResourceIdBetween(String value1, String value2) {
            addCriterion("RESOURCE_ID between", value1, value2, "resourceId");
            return this;
        }

        public Criteria andResourceIdNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_ID not between", value1, value2, "resourceId");
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

        public Criteria andNamingIsNull() {
            addCriterion("NAMING is null");
            return this;
        }

        public Criteria andNamingIsNotNull() {
            addCriterion("NAMING is not null");
            return this;
        }

        public Criteria andNamingEqualTo(String value) {
            addCriterion("NAMING =", value, "naming");
            return this;
        }

        public Criteria andNamingNotEqualTo(String value) {
            addCriterion("NAMING <>", value, "naming");
            return this;
        }

        public Criteria andNamingGreaterThan(String value) {
            addCriterion("NAMING >", value, "naming");
            return this;
        }

        public Criteria andNamingGreaterThanOrEqualTo(String value) {
            addCriterion("NAMING >=", value, "naming");
            return this;
        }

        public Criteria andNamingLessThan(String value) {
            addCriterion("NAMING <", value, "naming");
            return this;
        }

        public Criteria andNamingLessThanOrEqualTo(String value) {
            addCriterion("NAMING <=", value, "naming");
            return this;
        }

        public Criteria andNamingLike(String value) {
            addCriterion("NAMING like", value, "naming");
            return this;
        }

        public Criteria andNamingNotLike(String value) {
            addCriterion("NAMING not like", value, "naming");
            return this;
        }

        public Criteria andNamingIn(List values) {
            addCriterion("NAMING in", values, "naming");
            return this;
        }

        public Criteria andNamingNotIn(List values) {
            addCriterion("NAMING not in", values, "naming");
            return this;
        }

        public Criteria andNamingBetween(String value1, String value2) {
            addCriterion("NAMING between", value1, value2, "naming");
            return this;
        }

        public Criteria andNamingNotBetween(String value1, String value2) {
            addCriterion("NAMING not between", value1, value2, "naming");
            return this;
        }

        public Criteria andSipCodeIsNull() {
            addCriterion("SIP_CODE is null");
            return this;
        }

        public Criteria andSipCodeIsNotNull() {
            addCriterion("SIP_CODE is not null");
            return this;
        }

        public Criteria andSipCodeEqualTo(String value) {
            addCriterion("SIP_CODE =", value, "sipCode");
            return this;
        }

        public Criteria andSipCodeNotEqualTo(String value) {
            addCriterion("SIP_CODE <>", value, "sipCode");
            return this;
        }

        public Criteria andSipCodeGreaterThan(String value) {
            addCriterion("SIP_CODE >", value, "sipCode");
            return this;
        }

        public Criteria andSipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SIP_CODE >=", value, "sipCode");
            return this;
        }

        public Criteria andSipCodeLessThan(String value) {
            addCriterion("SIP_CODE <", value, "sipCode");
            return this;
        }

        public Criteria andSipCodeLessThanOrEqualTo(String value) {
            addCriterion("SIP_CODE <=", value, "sipCode");
            return this;
        }

        public Criteria andSipCodeLike(String value) {
            addCriterion("SIP_CODE like", value, "sipCode");
            return this;
        }

        public Criteria andSipCodeNotLike(String value) {
            addCriterion("SIP_CODE not like", value, "sipCode");
            return this;
        }

        public Criteria andSipCodeIn(List values) {
            addCriterion("SIP_CODE in", values, "sipCode");
            return this;
        }

        public Criteria andSipCodeNotIn(List values) {
            addCriterion("SIP_CODE not in", values, "sipCode");
            return this;
        }

        public Criteria andSipCodeBetween(String value1, String value2) {
            addCriterion("SIP_CODE between", value1, value2, "sipCode");
            return this;
        }

        public Criteria andSipCodeNotBetween(String value1, String value2) {
            addCriterion("SIP_CODE not between", value1, value2, "sipCode");
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

        public Criteria andIsShareIsNull() {
            addCriterion("IS_SHARE is null");
            return this;
        }

        public Criteria andIsShareIsNotNull() {
            addCriterion("IS_SHARE is not null");
            return this;
        }

        public Criteria andIsShareEqualTo(Short value) {
            addCriterion("IS_SHARE =", value, "isShare");
            return this;
        }

        public Criteria andIsShareNotEqualTo(Short value) {
            addCriterion("IS_SHARE <>", value, "isShare");
            return this;
        }

        public Criteria andIsShareGreaterThan(Short value) {
            addCriterion("IS_SHARE >", value, "isShare");
            return this;
        }

        public Criteria andIsShareGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_SHARE >=", value, "isShare");
            return this;
        }

        public Criteria andIsShareLessThan(Short value) {
            addCriterion("IS_SHARE <", value, "isShare");
            return this;
        }

        public Criteria andIsShareLessThanOrEqualTo(Short value) {
            addCriterion("IS_SHARE <=", value, "isShare");
            return this;
        }

        public Criteria andIsShareIn(List values) {
            addCriterion("IS_SHARE in", values, "isShare");
            return this;
        }

        public Criteria andIsShareNotIn(List values) {
            addCriterion("IS_SHARE not in", values, "isShare");
            return this;
        }

        public Criteria andIsShareBetween(Short value1, Short value2) {
            addCriterion("IS_SHARE between", value1, value2, "isShare");
            return this;
        }

        public Criteria andIsShareNotBetween(Short value1, Short value2) {
            addCriterion("IS_SHARE not between", value1, value2, "isShare");
            return this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return this;
        }

        public Criteria andStatusIn(List values) {
            addCriterion("STATUS in", values, "status");
            return this;
        }

        public Criteria andStatusNotIn(List values) {
            addCriterion("STATUS not in", values, "status");
            return this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("LONGITUDE like", value, "longitude");
            return this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("LONGITUDE not like", value, "longitude");
            return this;
        }

        public Criteria andLongitudeIn(List values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return this;
        }

        public Criteria andLongitudeNotIn(List values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("LATITUDE =", value, "latitude");
            return this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("LATITUDE >", value, "latitude");
            return this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("LATITUDE <", value, "latitude");
            return this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("LATITUDE like", value, "latitude");
            return this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("LATITUDE not like", value, "latitude");
            return this;
        }

        public Criteria andLatitudeIn(List values) {
            addCriterion("LATITUDE in", values, "latitude");
            return this;
        }

        public Criteria andLatitudeNotIn(List values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return this;
        }

        public Criteria andTypeIn(List values) {
            addCriterion("TYPE in", values, "type");
            return this;
        }

        public Criteria andTypeNotIn(List values) {
            addCriterion("TYPE not in", values, "type");
            return this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return this;
        }

        public Criteria andStandardTypeIsNull() {
            addCriterion("STANDARD_TYPE is null");
            return this;
        }

        public Criteria andStandardTypeIsNotNull() {
            addCriterion("STANDARD_TYPE is not null");
            return this;
        }

        public Criteria andStandardTypeEqualTo(String value) {
            addCriterion("STANDARD_TYPE =", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeNotEqualTo(String value) {
            addCriterion("STANDARD_TYPE <>", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeGreaterThan(String value) {
            addCriterion("STANDARD_TYPE >", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("STANDARD_TYPE >=", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeLessThan(String value) {
            addCriterion("STANDARD_TYPE <", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeLessThanOrEqualTo(String value) {
            addCriterion("STANDARD_TYPE <=", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeLike(String value) {
            addCriterion("STANDARD_TYPE like", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeNotLike(String value) {
            addCriterion("STANDARD_TYPE not like", value, "standardType");
            return this;
        }

        public Criteria andStandardTypeIn(List values) {
            addCriterion("STANDARD_TYPE in", values, "standardType");
            return this;
        }

        public Criteria andStandardTypeNotIn(List values) {
            addCriterion("STANDARD_TYPE not in", values, "standardType");
            return this;
        }

        public Criteria andStandardTypeBetween(String value1, String value2) {
            addCriterion("STANDARD_TYPE between", value1, value2, "standardType");
            return this;
        }

        public Criteria andStandardTypeNotBetween(String value1, String value2) {
            addCriterion("STANDARD_TYPE not between", value1, value2, "standardType");
            return this;
        }
    }
}