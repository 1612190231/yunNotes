package com.fcc.notebook.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class shareInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public shareInfoExample() {
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

        public Criteria andShareidIsNull() {
            addCriterion("shareId is null");
            return (Criteria) this;
        }

        public Criteria andShareidIsNotNull() {
            addCriterion("shareId is not null");
            return (Criteria) this;
        }

        public Criteria andShareidEqualTo(Integer value) {
            addCriterion("shareId =", value, "shareid");
            return (Criteria) this;
        }

        public Criteria andShareidNotEqualTo(Integer value) {
            addCriterion("shareId <>", value, "shareid");
            return (Criteria) this;
        }

        public Criteria andShareidGreaterThan(Integer value) {
            addCriterion("shareId >", value, "shareid");
            return (Criteria) this;
        }

        public Criteria andShareidGreaterThanOrEqualTo(Integer value) {
            addCriterion("shareId >=", value, "shareid");
            return (Criteria) this;
        }

        public Criteria andShareidLessThan(Integer value) {
            addCriterion("shareId <", value, "shareid");
            return (Criteria) this;
        }

        public Criteria andShareidLessThanOrEqualTo(Integer value) {
            addCriterion("shareId <=", value, "shareid");
            return (Criteria) this;
        }

        public Criteria andShareidIn(List<Integer> values) {
            addCriterion("shareId in", values, "shareid");
            return (Criteria) this;
        }

        public Criteria andShareidNotIn(List<Integer> values) {
            addCriterion("shareId not in", values, "shareid");
            return (Criteria) this;
        }

        public Criteria andShareidBetween(Integer value1, Integer value2) {
            addCriterion("shareId between", value1, value2, "shareid");
            return (Criteria) this;
        }

        public Criteria andShareidNotBetween(Integer value1, Integer value2) {
            addCriterion("shareId not between", value1, value2, "shareid");
            return (Criteria) this;
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

        public Criteria andIseditIsNull() {
            addCriterion("isEdit is null");
            return (Criteria) this;
        }

        public Criteria andIseditIsNotNull() {
            addCriterion("isEdit is not null");
            return (Criteria) this;
        }

        public Criteria andIseditEqualTo(Boolean value) {
            addCriterion("isEdit =", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditNotEqualTo(Boolean value) {
            addCriterion("isEdit <>", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditGreaterThan(Boolean value) {
            addCriterion("isEdit >", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isEdit >=", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditLessThan(Boolean value) {
            addCriterion("isEdit <", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditLessThanOrEqualTo(Boolean value) {
            addCriterion("isEdit <=", value, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditIn(List<Boolean> values) {
            addCriterion("isEdit in", values, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditNotIn(List<Boolean> values) {
            addCriterion("isEdit not in", values, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditBetween(Boolean value1, Boolean value2) {
            addCriterion("isEdit between", value1, value2, "isedit");
            return (Criteria) this;
        }

        public Criteria andIseditNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isEdit not between", value1, value2, "isedit");
            return (Criteria) this;
        }

        public Criteria andIscommentIsNull() {
            addCriterion("isComment is null");
            return (Criteria) this;
        }

        public Criteria andIscommentIsNotNull() {
            addCriterion("isComment is not null");
            return (Criteria) this;
        }

        public Criteria andIscommentEqualTo(Boolean value) {
            addCriterion("isComment =", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotEqualTo(Boolean value) {
            addCriterion("isComment <>", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentGreaterThan(Boolean value) {
            addCriterion("isComment >", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isComment >=", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentLessThan(Boolean value) {
            addCriterion("isComment <", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentLessThanOrEqualTo(Boolean value) {
            addCriterion("isComment <=", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentIn(List<Boolean> values) {
            addCriterion("isComment in", values, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotIn(List<Boolean> values) {
            addCriterion("isComment not in", values, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentBetween(Boolean value1, Boolean value2) {
            addCriterion("isComment between", value1, value2, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isComment not between", value1, value2, "iscomment");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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

        public Criteria andSharetimeIsNull() {
            addCriterion("shareTime is null");
            return (Criteria) this;
        }

        public Criteria andSharetimeIsNotNull() {
            addCriterion("shareTime is not null");
            return (Criteria) this;
        }

        public Criteria andSharetimeEqualTo(Date value) {
            addCriterion("shareTime =", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeNotEqualTo(Date value) {
            addCriterion("shareTime <>", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeGreaterThan(Date value) {
            addCriterion("shareTime >", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shareTime >=", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeLessThan(Date value) {
            addCriterion("shareTime <", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeLessThanOrEqualTo(Date value) {
            addCriterion("shareTime <=", value, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeIn(List<Date> values) {
            addCriterion("shareTime in", values, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeNotIn(List<Date> values) {
            addCriterion("shareTime not in", values, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeBetween(Date value1, Date value2) {
            addCriterion("shareTime between", value1, value2, "sharetime");
            return (Criteria) this;
        }

        public Criteria andSharetimeNotBetween(Date value1, Date value2) {
            addCriterion("shareTime not between", value1, value2, "sharetime");
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