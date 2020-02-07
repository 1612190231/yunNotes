package com.fcc.notebook.utils;

import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class TbEnterpriseDepartment {
    private int id;
    private String name;
    private int number;
    private int parentId;
    private List<TbEnterpriseDepartment> childDeparents;
	private boolean isRoot;
    public TbEnterpriseDepartment() {
    }

    public TbEnterpriseDepartment(int id, String name, int parentId, boolean isRoot) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.isRoot = isRoot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public List<TbEnterpriseDepartment> getChildDeparents() {
        return childDeparents;
    }

    public void setChildDeparents(List<TbEnterpriseDepartment> childDeparents) {
        this.childDeparents = childDeparents;
    }
 //添加子部门
    public void addChildDepartment(TbEnterpriseDepartment department) {
        if(this.childDeparents == null)
            this.childDeparents = new LinkedList<>();
        this.childDeparents.add(department);
    }
}