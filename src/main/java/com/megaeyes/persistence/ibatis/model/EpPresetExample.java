package com.megaeyes.persistence.ibatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpPresetExample {
    protected String orderByClause;

    protected List oredCriteria;

    public EpPresetExample() {
        oredCriteria = new ArrayList();
    }

    protected EpPresetExample(EpPresetExample example) {
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

        public Criteria andPresetNumberIsNull() {
            addCriterion("PRESET_NUMBER is null");
            return this;
        }

        public Criteria andPresetNumberIsNotNull() {
            addCriterion("PRESET_NUMBER is not null");
            return this;
        }

        public Criteria andPresetNumberEqualTo(Short value) {
            addCriterion("PRESET_NUMBER =", value, "presetNumber");
            return this;
        }

        public Criteria andPresetNumberNotEqualTo(Short value) {
            addCriterion("PRESET_NUMBER <>", value, "presetNumber");
            return this;
        }

        public Criteria andPresetNumberGreaterThan(Short value) {
            addCriterion("PRESET_NUMBER >", value, "presetNumber");
            return this;
        }

        public Criteria andPresetNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("PRESET_NUMBER >=", value, "presetNumber");
            return this;
        }

        public Criteria andPresetNumberLessThan(Short value) {
            addCriterion("PRESET_NUMBER <", value, "presetNumber");
            return this;
        }

        public Criteria andPresetNumberLessThanOrEqualTo(Short value) {
            addCriterion("PRESET_NUMBER <=", value, "presetNumber");
            return this;
        }

        public Criteria andPresetNumberIn(List values) {
            addCriterion("PRESET_NUMBER in", values, "presetNumber");
            return this;
        }

        public Criteria andPresetNumberNotIn(List values) {
            addCriterion("PRESET_NUMBER not in", values, "presetNumber");
            return this;
        }

        public Criteria andPresetNumberBetween(Short value1, Short value2) {
            addCriterion("PRESET_NUMBER between", value1, value2, "presetNumber");
            return this;
        }

        public Criteria andPresetNumberNotBetween(Short value1, Short value2) {
            addCriterion("PRESET_NUMBER not between", value1, value2, "presetNumber");
            return this;
        }

        public Criteria andVicIdIsNull() {
            addCriterion("VIC_ID is null");
            return this;
        }

        public Criteria andVicIdIsNotNull() {
            addCriterion("VIC_ID is not null");
            return this;
        }

        public Criteria andVicIdEqualTo(String value) {
            addCriterion("VIC_ID =", value, "vicId");
            return this;
        }

        public Criteria andVicIdNotEqualTo(String value) {
            addCriterion("VIC_ID <>", value, "vicId");
            return this;
        }

        public Criteria andVicIdGreaterThan(String value) {
            addCriterion("VIC_ID >", value, "vicId");
            return this;
        }

        public Criteria andVicIdGreaterThanOrEqualTo(String value) {
            addCriterion("VIC_ID >=", value, "vicId");
            return this;
        }

        public Criteria andVicIdLessThan(String value) {
            addCriterion("VIC_ID <", value, "vicId");
            return this;
        }

        public Criteria andVicIdLessThanOrEqualTo(String value) {
            addCriterion("VIC_ID <=", value, "vicId");
            return this;
        }

        public Criteria andVicIdLike(String value) {
            addCriterion("VIC_ID like", value, "vicId");
            return this;
        }

        public Criteria andVicIdNotLike(String value) {
            addCriterion("VIC_ID not like", value, "vicId");
            return this;
        }

        public Criteria andVicIdIn(List values) {
            addCriterion("VIC_ID in", values, "vicId");
            return this;
        }

        public Criteria andVicIdNotIn(List values) {
            addCriterion("VIC_ID not in", values, "vicId");
            return this;
        }

        public Criteria andVicIdBetween(String value1, String value2) {
            addCriterion("VIC_ID between", value1, value2, "vicId");
            return this;
        }

        public Criteria andVicIdNotBetween(String value1, String value2) {
            addCriterion("VIC_ID not between", value1, value2, "vicId");
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return this;
        }

        public Criteria andTypeEqualTo(Long value) {
            addCriterion("TYPE =", value, "type");
            return this;
        }

        public Criteria andTypeNotEqualTo(Long value) {
            addCriterion("TYPE <>", value, "type");
            return this;
        }

        public Criteria andTypeGreaterThan(Long value) {
            addCriterion("TYPE >", value, "type");
            return this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("TYPE >=", value, "type");
            return this;
        }

        public Criteria andTypeLessThan(Long value) {
            addCriterion("TYPE <", value, "type");
            return this;
        }

        public Criteria andTypeLessThanOrEqualTo(Long value) {
            addCriterion("TYPE <=", value, "type");
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

        public Criteria andTypeBetween(Long value1, Long value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return this;
        }

        public Criteria andTypeNotBetween(Long value1, Long value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return this;
        }

        public Criteria andSetFlagIsNull() {
            addCriterion("SET_FLAG is null");
            return this;
        }

        public Criteria andSetFlagIsNotNull() {
            addCriterion("SET_FLAG is not null");
            return this;
        }

        public Criteria andSetFlagEqualTo(BigDecimal value) {
            addCriterion("SET_FLAG =", value, "setFlag");
            return this;
        }

        public Criteria andSetFlagNotEqualTo(BigDecimal value) {
            addCriterion("SET_FLAG <>", value, "setFlag");
            return this;
        }

        public Criteria andSetFlagGreaterThan(BigDecimal value) {
            addCriterion("SET_FLAG >", value, "setFlag");
            return this;
        }

        public Criteria andSetFlagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SET_FLAG >=", value, "setFlag");
            return this;
        }

        public Criteria andSetFlagLessThan(BigDecimal value) {
            addCriterion("SET_FLAG <", value, "setFlag");
            return this;
        }

        public Criteria andSetFlagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SET_FLAG <=", value, "setFlag");
            return this;
        }

        public Criteria andSetFlagIn(List values) {
            addCriterion("SET_FLAG in", values, "setFlag");
            return this;
        }

        public Criteria andSetFlagNotIn(List values) {
            addCriterion("SET_FLAG not in", values, "setFlag");
            return this;
        }

        public Criteria andSetFlagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SET_FLAG between", value1, value2, "setFlag");
            return this;
        }

        public Criteria andSetFlagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SET_FLAG not between", value1, value2, "setFlag");
            return this;
        }
    }
}