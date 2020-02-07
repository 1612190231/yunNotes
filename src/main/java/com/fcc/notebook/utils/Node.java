package com.fcc.notebook.utils;

import java.util.LinkedList;
import java.util.List;

public class Node {
	private int id;
	
	private int parentid;
	
	private String index;
	
	private String name;
	
	private List<Node> children;
	
	public Node() {
    }

    public Node(int id, String name, int parentId, String index) {
        this.id = id;
        this.name = name;
        this.parentid = parentId;
        this.index = index;
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentid;
	}

	public void setParentId(int parentid) {
		this.parentid = parentid;
	}

	public String getIndex() {
		return index;
	}
	
	public void setIndex(String index) {
		this.index = index;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getChildren() {
		return children;
	}
    
	//添加子节点
	public void addChild(Node node) {
        if(this.children == null)
            this.children = new LinkedList<>();
        this.children.add(node);
    }
}
