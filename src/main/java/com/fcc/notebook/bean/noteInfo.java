package com.fcc.notebook.bean;

import java.util.Date;

public class noteInfo {
    private Integer noteid;

    private String notename;

    private Integer userid;

    private Date updatetime;

    private String userurl;

    private String userrecycle;

    private String recycleurl;

    private String storeurl;

    private String photourl;

    private Double length;

    private Integer isdelete;

    public Integer getNoteid() {
        return noteid;
    }

    public void setNoteid(Integer noteid) {
        this.noteid = noteid;
    }

    public String getNotename() {
        return notename;
    }

    public void setNotename(String notename) {
        this.notename = notename == null ? null : notename.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUserurl() {
        return userurl;
    }

    public void setUserurl(String userurl) {
        this.userurl = userurl == null ? null : userurl.trim();
    }

    public String getUserrecycle() {
        return userrecycle;
    }

    public void setUserrecycle(String userrecycle) {
        this.userrecycle = userrecycle == null ? null : userrecycle.trim();
    }

    public String getRecycleurl() {
        return recycleurl;
    }

    public void setRecycleurl(String recycleurl) {
        this.recycleurl = recycleurl == null ? null : recycleurl.trim();
    }

    public String getStoreurl() {
        return storeurl;
    }

    public void setStoreurl(String storeurl) {
        this.storeurl = storeurl == null ? null : storeurl.trim();
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl == null ? null : photourl.trim();
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}