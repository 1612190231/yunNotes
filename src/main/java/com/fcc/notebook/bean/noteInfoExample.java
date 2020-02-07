package com.fcc.notebook.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class noteInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public noteInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
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
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNoteidIsNull() {
            addCriterion("noteId is null");
            return (Criteria) this;
        }

        public Criteria andNoteidIsNotNull() {
            addCriterion("noteId is not null");
            return (Criteria) this;
        }

        public Criteria andNoteidEqualTo(Integer value) {
            addCriterion("noteId =", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotEqualTo(Integer value) {
            addCriterion("noteId <>", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidGreaterThan(Integer value) {
            addCriterion("noteId >", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidGreaterThanOrEqualTo(Integer value) {
            addCriterion("noteId >=", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidLessThan(Integer value) {
            addCriterion("noteId <", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidLessThanOrEqualTo(Integer value) {
            addCriterion("noteId <=", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidIn(List<Integer> values) {
            addCriterion("noteId in", values, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotIn(List<Integer> values) {
            addCriterion("noteId not in", values, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidBetween(Integer value1, Integer value2) {
            addCriterion("noteId between", value1, value2, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotBetween(Integer value1, Integer value2) {
            addCriterion("noteId not between", value1, value2, "noteid");
            return (Criteria) this;
        }

        public Criteria andNotenameIsNull() {
            addCriterion("noteName is null");
            return (Criteria) this;
        }

        public Criteria andNotenameIsNotNull() {
            addCriterion("noteName is not null");
            return (Criteria) this;
        }

        public Criteria andNotenameEqualTo(String value) {
            addCriterion("noteName =", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotEqualTo(String value) {
            addCriterion("noteName <>", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameGreaterThan(String value) {
            addCriterion("noteName >", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameGreaterThanOrEqualTo(String value) {
            addCriterion("noteName >=", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameLessThan(String value) {
            addCriterion("noteName <", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameLessThanOrEqualTo(String value) {
            addCriterion("noteName <=", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameLike(String value) {
            addCriterion("noteName like", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotLike(String value) {
            addCriterion("noteName not like", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameIn(List<String> values) {
            addCriterion("noteName in", values, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotIn(List<String> values) {
            addCriterion("noteName not in", values, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameBetween(String value1, String value2) {
            addCriterion("noteName between", value1, value2, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotBetween(String value1, String value2) {
            addCriterion("noteName not between", value1, value2, "notename");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUserurlIsNull() {
            addCriterion("userUrl is null");
            return (Criteria) this;
        }

        public Criteria andUserurlIsNotNull() {
            addCriterion("userUrl is not null");
            return (Criteria) this;
        }

        public Criteria andUserurlEqualTo(String value) {
            addCriterion("userUrl =", value, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserurlNotEqualTo(String value) {
            addCriterion("userUrl <>", value, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserurlGreaterThan(String value) {
            addCriterion("userUrl >", value, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserurlGreaterThanOrEqualTo(String value) {
            addCriterion("userUrl >=", value, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserurlLessThan(String value) {
            addCriterion("userUrl <", value, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserurlLessThanOrEqualTo(String value) {
            addCriterion("userUrl <=", value, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserurlLike(String value) {
            addCriterion("userUrl like", value, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserurlNotLike(String value) {
            addCriterion("userUrl not like", value, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserurlIn(List<String> values) {
            addCriterion("userUrl in", values, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserurlNotIn(List<String> values) {
            addCriterion("userUrl not in", values, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserurlBetween(String value1, String value2) {
            addCriterion("userUrl between", value1, value2, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserurlNotBetween(String value1, String value2) {
            addCriterion("userUrl not between", value1, value2, "userurl");
            return (Criteria) this;
        }

        public Criteria andUserrecycleIsNull() {
            addCriterion("userRecycle is null");
            return (Criteria) this;
        }

        public Criteria andUserrecycleIsNotNull() {
            addCriterion("userRecycle is not null");
            return (Criteria) this;
        }

        public Criteria andUserrecycleEqualTo(String value) {
            addCriterion("userRecycle =", value, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andUserrecycleNotEqualTo(String value) {
            addCriterion("userRecycle <>", value, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andUserrecycleGreaterThan(String value) {
            addCriterion("userRecycle >", value, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andUserrecycleGreaterThanOrEqualTo(String value) {
            addCriterion("userRecycle >=", value, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andUserrecycleLessThan(String value) {
            addCriterion("userRecycle <", value, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andUserrecycleLessThanOrEqualTo(String value) {
            addCriterion("userRecycle <=", value, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andUserrecycleLike(String value) {
            addCriterion("userRecycle like", value, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andUserrecycleNotLike(String value) {
            addCriterion("userRecycle not like", value, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andUserrecycleIn(List<String> values) {
            addCriterion("userRecycle in", values, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andUserrecycleNotIn(List<String> values) {
            addCriterion("userRecycle not in", values, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andUserrecycleBetween(String value1, String value2) {
            addCriterion("userRecycle between", value1, value2, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andUserrecycleNotBetween(String value1, String value2) {
            addCriterion("userRecycle not between", value1, value2, "userrecycle");
            return (Criteria) this;
        }

        public Criteria andRecycleurlIsNull() {
            addCriterion("recycleUrl is null");
            return (Criteria) this;
        }

        public Criteria andRecycleurlIsNotNull() {
            addCriterion("recycleUrl is not null");
            return (Criteria) this;
        }

        public Criteria andRecycleurlEqualTo(String value) {
            addCriterion("recycleUrl =", value, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andRecycleurlNotEqualTo(String value) {
            addCriterion("recycleUrl <>", value, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andRecycleurlGreaterThan(String value) {
            addCriterion("recycleUrl >", value, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andRecycleurlGreaterThanOrEqualTo(String value) {
            addCriterion("recycleUrl >=", value, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andRecycleurlLessThan(String value) {
            addCriterion("recycleUrl <", value, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andRecycleurlLessThanOrEqualTo(String value) {
            addCriterion("recycleUrl <=", value, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andRecycleurlLike(String value) {
            addCriterion("recycleUrl like", value, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andRecycleurlNotLike(String value) {
            addCriterion("recycleUrl not like", value, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andRecycleurlIn(List<String> values) {
            addCriterion("recycleUrl in", values, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andRecycleurlNotIn(List<String> values) {
            addCriterion("recycleUrl not in", values, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andRecycleurlBetween(String value1, String value2) {
            addCriterion("recycleUrl between", value1, value2, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andRecycleurlNotBetween(String value1, String value2) {
            addCriterion("recycleUrl not between", value1, value2, "recycleurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlIsNull() {
            addCriterion("storeUrl is null");
            return (Criteria) this;
        }

        public Criteria andStoreurlIsNotNull() {
            addCriterion("storeUrl is not null");
            return (Criteria) this;
        }

        public Criteria andStoreurlEqualTo(String value) {
            addCriterion("storeUrl =", value, "storeurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlNotEqualTo(String value) {
            addCriterion("storeUrl <>", value, "storeurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlGreaterThan(String value) {
            addCriterion("storeUrl >", value, "storeurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlGreaterThanOrEqualTo(String value) {
            addCriterion("storeUrl >=", value, "storeurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlLessThan(String value) {
            addCriterion("storeUrl <", value, "storeurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlLessThanOrEqualTo(String value) {
            addCriterion("storeUrl <=", value, "storeurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlLike(String value) {
            addCriterion("storeUrl like", value, "storeurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlNotLike(String value) {
            addCriterion("storeUrl not like", value, "storeurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlIn(List<String> values) {
            addCriterion("storeUrl in", values, "storeurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlNotIn(List<String> values) {
            addCriterion("storeUrl not in", values, "storeurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlBetween(String value1, String value2) {
            addCriterion("storeUrl between", value1, value2, "storeurl");
            return (Criteria) this;
        }

        public Criteria andStoreurlNotBetween(String value1, String value2) {
            addCriterion("storeUrl not between", value1, value2, "storeurl");
            return (Criteria) this;
        }

        public Criteria andPhotourlIsNull() {
            addCriterion("photoUrl is null");
            return (Criteria) this;
        }

        public Criteria andPhotourlIsNotNull() {
            addCriterion("photoUrl is not null");
            return (Criteria) this;
        }

        public Criteria andPhotourlEqualTo(String value) {
            addCriterion("photoUrl =", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlNotEqualTo(String value) {
            addCriterion("photoUrl <>", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlGreaterThan(String value) {
            addCriterion("photoUrl >", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlGreaterThanOrEqualTo(String value) {
            addCriterion("photoUrl >=", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlLessThan(String value) {
            addCriterion("photoUrl <", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlLessThanOrEqualTo(String value) {
            addCriterion("photoUrl <=", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlLike(String value) {
            addCriterion("photoUrl like", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlNotLike(String value) {
            addCriterion("photoUrl not like", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlIn(List<String> values) {
            addCriterion("photoUrl in", values, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlNotIn(List<String> values) {
            addCriterion("photoUrl not in", values, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlBetween(String value1, String value2) {
            addCriterion("photoUrl between", value1, value2, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlNotBetween(String value1, String value2) {
            addCriterion("photoUrl not between", value1, value2, "photourl");
            return (Criteria) this;
        }

        public Criteria andLengthIsNull() {
            addCriterion("length is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("length is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(Double value) {
            addCriterion("length =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(Double value) {
            addCriterion("length <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(Double value) {
            addCriterion("length >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(Double value) {
            addCriterion("length >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(Double value) {
            addCriterion("length <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(Double value) {
            addCriterion("length <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<Double> values) {
            addCriterion("length in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<Double> values) {
            addCriterion("length not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(Double value1, Double value2) {
            addCriterion("length between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(Double value1, Double value2) {
            addCriterion("length not between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isDelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isDelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isDelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isDelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isDelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isDelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isDelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isDelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isDelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isDelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isDelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}