package com.megaeyes.persistence.ibatis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpRMapDeviceExample {
    protected String orderByClause;

    protected List oredCriteria;

    public EpRMapDeviceExample() {
        oredCriteria = new ArrayList();
    }

    protected EpRMapDeviceExample(EpRMapDeviceExample example) {
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

        public Criteria andEpMapIdIsNull() {
            addCriterion("EP_MAP_ID is null");
            return this;
        }

        public Criteria andEpMapIdIsNotNull() {
            addCriterion("EP_MAP_ID is not null");
            return this;
        }

        public Criteria andEpMapIdEqualTo(String value) {
            addCriterion("EP_MAP_ID =", value, "epMapId");
            return this;
        }

        public Criteria andEpMapIdNotEqualTo(String value) {
            addCriterion("EP_MAP_ID <>", value, "epMapId");
            return this;
        }

        public Criteria andEpMapIdGreaterThan(String value) {
            addCriterion("EP_MAP_ID >", value, "epMapId");
            return this;
        }

        public Criteria andEpMapIdGreaterThanOrEqualTo(String value) {
            addCriterion("EP_MAP_ID >=", value, "epMapId");
            return this;
        }

        public Criteria andEpMapIdLessThan(String value) {
            addCriterion("EP_MAP_ID <", value, "epMapId");
            return this;
        }

        public Criteria andEpMapIdLessThanOrEqualTo(String value) {
            addCriterion("EP_MAP_ID <=", value, "epMapId");
            return this;
        }

        public Criteria andEpMapIdLike(String value) {
            addCriterion("EP_MAP_ID like", value, "epMapId");
            return this;
        }

        public Criteria andEpMapIdNotLike(String value) {
            addCriterion("EP_MAP_ID not like", value, "epMapId");
            return this;
        }

        public Criteria andEpMapIdIn(List values) {
            addCriterion("EP_MAP_ID in", values, "epMapId");
            return this;
        }

        public Criteria andEpMapIdNotIn(List values) {
            addCriterion("EP_MAP_ID not in", values, "epMapId");
            return this;
        }

        public Criteria andEpMapIdBetween(String value1, String value2) {
            addCriterion("EP_MAP_ID between", value1, value2, "epMapId");
            return this;
        }

        public Criteria andEpMapIdNotBetween(String value1, String value2) {
            addCriterion("EP_MAP_ID not between", value1, value2, "epMapId");
            return this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("DEVICE_ID is null");
            return this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("DEVICE_ID is not null");
            return this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("DEVICE_ID =", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("DEVICE_ID <>", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("DEVICE_ID >", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_ID >=", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("DEVICE_ID <", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_ID <=", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("DEVICE_ID like", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("DEVICE_ID not like", value, "deviceId");
            return this;
        }

        public Criteria andDeviceIdIn(List values) {
            addCriterion("DEVICE_ID in", values, "deviceId");
            return this;
        }

        public Criteria andDeviceIdNotIn(List values) {
            addCriterion("DEVICE_ID not in", values, "deviceId");
            return this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("DEVICE_ID between", value1, value2, "deviceId");
            return this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("DEVICE_ID not between", value1, value2, "deviceId");
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

        public Criteria andDeviceTypeEqualTo(Short value) {
            addCriterion("DEVICE_TYPE =", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotEqualTo(Short value) {
            addCriterion("DEVICE_TYPE <>", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeGreaterThan(Short value) {
            addCriterion("DEVICE_TYPE >", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("DEVICE_TYPE >=", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeLessThan(Short value) {
            addCriterion("DEVICE_TYPE <", value, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(Short value) {
            addCriterion("DEVICE_TYPE <=", value, "deviceType");
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

        public Criteria andDeviceTypeBetween(Short value1, Short value2) {
            addCriterion("DEVICE_TYPE between", value1, value2, "deviceType");
            return this;
        }

        public Criteria andDeviceTypeNotBetween(Short value1, Short value2) {
            addCriterion("DEVICE_TYPE not between", value1, value2, "deviceType");
            return this;
        }

        public Criteria andCoordinateXIsNull() {
            addCriterion("COORDINATE_X is null");
            return this;
        }

        public Criteria andCoordinateXIsNotNull() {
            addCriterion("COORDINATE_X is not null");
            return this;
        }

        public Criteria andCoordinateXEqualTo(String value) {
            addCriterion("COORDINATE_X =", value, "coordinateX");
            return this;
        }

        public Criteria andCoordinateXNotEqualTo(String value) {
            addCriterion("COORDINATE_X <>", value, "coordinateX");
            return this;
        }

        public Criteria andCoordinateXGreaterThan(String value) {
            addCriterion("COORDINATE_X >", value, "coordinateX");
            return this;
        }

        public Criteria andCoordinateXGreaterThanOrEqualTo(String value) {
            addCriterion("COORDINATE_X >=", value, "coordinateX");
            return this;
        }

        public Criteria andCoordinateXLessThan(String value) {
            addCriterion("COORDINATE_X <", value, "coordinateX");
            return this;
        }

        public Criteria andCoordinateXLessThanOrEqualTo(String value) {
            addCriterion("COORDINATE_X <=", value, "coordinateX");
            return this;
        }

        public Criteria andCoordinateXLike(String value) {
            addCriterion("COORDINATE_X like", value, "coordinateX");
            return this;
        }

        public Criteria andCoordinateXNotLike(String value) {
            addCriterion("COORDINATE_X not like", value, "coordinateX");
            return this;
        }

        public Criteria andCoordinateXIn(List values) {
            addCriterion("COORDINATE_X in", values, "coordinateX");
            return this;
        }

        public Criteria andCoordinateXNotIn(List values) {
            addCriterion("COORDINATE_X not in", values, "coordinateX");
            return this;
        }

        public Criteria andCoordinateXBetween(String value1, String value2) {
            addCriterion("COORDINATE_X between", value1, value2, "coordinateX");
            return this;
        }

        public Criteria andCoordinateXNotBetween(String value1, String value2) {
            addCriterion("COORDINATE_X not between", value1, value2, "coordinateX");
            return this;
        }

        public Criteria andCoordinateYIsNull() {
            addCriterion("COORDINATE_Y is null");
            return this;
        }

        public Criteria andCoordinateYIsNotNull() {
            addCriterion("COORDINATE_Y is not null");
            return this;
        }

        public Criteria andCoordinateYEqualTo(String value) {
            addCriterion("COORDINATE_Y =", value, "coordinateY");
            return this;
        }

        public Criteria andCoordinateYNotEqualTo(String value) {
            addCriterion("COORDINATE_Y <>", value, "coordinateY");
            return this;
        }

        public Criteria andCoordinateYGreaterThan(String value) {
            addCriterion("COORDINATE_Y >", value, "coordinateY");
            return this;
        }

        public Criteria andCoordinateYGreaterThanOrEqualTo(String value) {
            addCriterion("COORDINATE_Y >=", value, "coordinateY");
            return this;
        }

        public Criteria andCoordinateYLessThan(String value) {
            addCriterion("COORDINATE_Y <", value, "coordinateY");
            return this;
        }

        public Criteria andCoordinateYLessThanOrEqualTo(String value) {
            addCriterion("COORDINATE_Y <=", value, "coordinateY");
            return this;
        }

        public Criteria andCoordinateYLike(String value) {
            addCriterion("COORDINATE_Y like", value, "coordinateY");
            return this;
        }

        public Criteria andCoordinateYNotLike(String value) {
            addCriterion("COORDINATE_Y not like", value, "coordinateY");
            return this;
        }

        public Criteria andCoordinateYIn(List values) {
            addCriterion("COORDINATE_Y in", values, "coordinateY");
            return this;
        }

        public Criteria andCoordinateYNotIn(List values) {
            addCriterion("COORDINATE_Y not in", values, "coordinateY");
            return this;
        }

        public Criteria andCoordinateYBetween(String value1, String value2) {
            addCriterion("COORDINATE_Y between", value1, value2, "coordinateY");
            return this;
        }

        public Criteria andCoordinateYNotBetween(String value1, String value2) {
            addCriterion("COORDINATE_Y not between", value1, value2, "coordinateY");
            return this;
        }

        public Criteria andLeftIsNull() {
            addCriterion("LEFT is null");
            return this;
        }

        public Criteria andLeftIsNotNull() {
            addCriterion("LEFT is not null");
            return this;
        }

        public Criteria andLeftEqualTo(String value) {
            addCriterion("LEFT =", value, "left");
            return this;
        }

        public Criteria andLeftNotEqualTo(String value) {
            addCriterion("LEFT <>", value, "left");
            return this;
        }

        public Criteria andLeftGreaterThan(String value) {
            addCriterion("LEFT >", value, "left");
            return this;
        }

        public Criteria andLeftGreaterThanOrEqualTo(String value) {
            addCriterion("LEFT >=", value, "left");
            return this;
        }

        public Criteria andLeftLessThan(String value) {
            addCriterion("LEFT <", value, "left");
            return this;
        }

        public Criteria andLeftLessThanOrEqualTo(String value) {
            addCriterion("LEFT <=", value, "left");
            return this;
        }

        public Criteria andLeftLike(String value) {
            addCriterion("LEFT like", value, "left");
            return this;
        }

        public Criteria andLeftNotLike(String value) {
            addCriterion("LEFT not like", value, "left");
            return this;
        }

        public Criteria andLeftIn(List values) {
            addCriterion("LEFT in", values, "left");
            return this;
        }

        public Criteria andLeftNotIn(List values) {
            addCriterion("LEFT not in", values, "left");
            return this;
        }

        public Criteria andLeftBetween(String value1, String value2) {
            addCriterion("LEFT between", value1, value2, "left");
            return this;
        }

        public Criteria andLeftNotBetween(String value1, String value2) {
            addCriterion("LEFT not between", value1, value2, "left");
            return this;
        }

        public Criteria andRightIsNull() {
            addCriterion("RIGHT is null");
            return this;
        }

        public Criteria andRightIsNotNull() {
            addCriterion("RIGHT is not null");
            return this;
        }

        public Criteria andRightEqualTo(String value) {
            addCriterion("RIGHT =", value, "right");
            return this;
        }

        public Criteria andRightNotEqualTo(String value) {
            addCriterion("RIGHT <>", value, "right");
            return this;
        }

        public Criteria andRightGreaterThan(String value) {
            addCriterion("RIGHT >", value, "right");
            return this;
        }

        public Criteria andRightGreaterThanOrEqualTo(String value) {
            addCriterion("RIGHT >=", value, "right");
            return this;
        }

        public Criteria andRightLessThan(String value) {
            addCriterion("RIGHT <", value, "right");
            return this;
        }

        public Criteria andRightLessThanOrEqualTo(String value) {
            addCriterion("RIGHT <=", value, "right");
            return this;
        }

        public Criteria andRightLike(String value) {
            addCriterion("RIGHT like", value, "right");
            return this;
        }

        public Criteria andRightNotLike(String value) {
            addCriterion("RIGHT not like", value, "right");
            return this;
        }

        public Criteria andRightIn(List values) {
            addCriterion("RIGHT in", values, "right");
            return this;
        }

        public Criteria andRightNotIn(List values) {
            addCriterion("RIGHT not in", values, "right");
            return this;
        }

        public Criteria andRightBetween(String value1, String value2) {
            addCriterion("RIGHT between", value1, value2, "right");
            return this;
        }

        public Criteria andRightNotBetween(String value1, String value2) {
            addCriterion("RIGHT not between", value1, value2, "right");
            return this;
        }

        public Criteria andTopIsNull() {
            addCriterion("TOP is null");
            return this;
        }

        public Criteria andTopIsNotNull() {
            addCriterion("TOP is not null");
            return this;
        }

        public Criteria andTopEqualTo(String value) {
            addCriterion("TOP =", value, "top");
            return this;
        }

        public Criteria andTopNotEqualTo(String value) {
            addCriterion("TOP <>", value, "top");
            return this;
        }

        public Criteria andTopGreaterThan(String value) {
            addCriterion("TOP >", value, "top");
            return this;
        }

        public Criteria andTopGreaterThanOrEqualTo(String value) {
            addCriterion("TOP >=", value, "top");
            return this;
        }

        public Criteria andTopLessThan(String value) {
            addCriterion("TOP <", value, "top");
            return this;
        }

        public Criteria andTopLessThanOrEqualTo(String value) {
            addCriterion("TOP <=", value, "top");
            return this;
        }

        public Criteria andTopLike(String value) {
            addCriterion("TOP like", value, "top");
            return this;
        }

        public Criteria andTopNotLike(String value) {
            addCriterion("TOP not like", value, "top");
            return this;
        }

        public Criteria andTopIn(List values) {
            addCriterion("TOP in", values, "top");
            return this;
        }

        public Criteria andTopNotIn(List values) {
            addCriterion("TOP not in", values, "top");
            return this;
        }

        public Criteria andTopBetween(String value1, String value2) {
            addCriterion("TOP between", value1, value2, "top");
            return this;
        }

        public Criteria andTopNotBetween(String value1, String value2) {
            addCriterion("TOP not between", value1, value2, "top");
            return this;
        }

        public Criteria andBottomIsNull() {
            addCriterion("BOTTOM is null");
            return this;
        }

        public Criteria andBottomIsNotNull() {
            addCriterion("BOTTOM is not null");
            return this;
        }

        public Criteria andBottomEqualTo(String value) {
            addCriterion("BOTTOM =", value, "bottom");
            return this;
        }

        public Criteria andBottomNotEqualTo(String value) {
            addCriterion("BOTTOM <>", value, "bottom");
            return this;
        }

        public Criteria andBottomGreaterThan(String value) {
            addCriterion("BOTTOM >", value, "bottom");
            return this;
        }

        public Criteria andBottomGreaterThanOrEqualTo(String value) {
            addCriterion("BOTTOM >=", value, "bottom");
            return this;
        }

        public Criteria andBottomLessThan(String value) {
            addCriterion("BOTTOM <", value, "bottom");
            return this;
        }

        public Criteria andBottomLessThanOrEqualTo(String value) {
            addCriterion("BOTTOM <=", value, "bottom");
            return this;
        }

        public Criteria andBottomLike(String value) {
            addCriterion("BOTTOM like", value, "bottom");
            return this;
        }

        public Criteria andBottomNotLike(String value) {
            addCriterion("BOTTOM not like", value, "bottom");
            return this;
        }

        public Criteria andBottomIn(List values) {
            addCriterion("BOTTOM in", values, "bottom");
            return this;
        }

        public Criteria andBottomNotIn(List values) {
            addCriterion("BOTTOM not in", values, "bottom");
            return this;
        }

        public Criteria andBottomBetween(String value1, String value2) {
            addCriterion("BOTTOM between", value1, value2, "bottom");
            return this;
        }

        public Criteria andBottomNotBetween(String value1, String value2) {
            addCriterion("BOTTOM not between", value1, value2, "bottom");
            return this;
        }
    }
}