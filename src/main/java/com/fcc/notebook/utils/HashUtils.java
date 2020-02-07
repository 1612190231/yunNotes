package com.fcc.notebook.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HashUtils {
	/*public static List<Node> getTreeByNodes(List<Node> nodes) {
		Map<Object, List<Node>> nodeMap = new HashMap<Object, List<Node>>();
		for (Node node : nodes) {
			Object parentId = node.getParentId();
			List<Node> childrenNodes;
			if (nodeMap.containsKey(parentId)) {
				childrenNodes = nodeMap.get(parentId);
			} else {
				childrenNodes = new ArrayList<Node>();
				nodeMap.put(parentId, childrenNodes);
			}
			childrenNodes.add(node);
		}
		return getTreeNodeByNodeMap(nodeMap, null);
	}

	private static List<Node> getTreeNodeByNodeMap(Map<Object, List<Node>> nodeMap, Object parentId) {
		List<Node> childrens = nodeMap.get(parentId);
		if (childrens == null) {
			return null;
		}
		for (Node node : childrens) {
			node.setChildrens(getTreeNodeByNodeMap(nodeMap, node.getId()));
		}
		return childrens;
	}*/
	
	public void getTree(List<Node> nodeList) {
		List<TbEnterpriseDepartment> departments = new ArrayList<>(); 
		TbEnterpriseDepartment rootDepartment = new TbEnterpriseDepartment(1,"root-1",-1,true); 
		departments.add(new TbEnterpriseDepartment(2,"root-1-1",1,false)); 
		departments.add(new TbEnterpriseDepartment(3,"root-1-1-1",2,false)); 
		departments.add(new TbEnterpriseDepartment(4,"root-1-1-2",2,false)); 
		departments.add(new TbEnterpriseDepartment(5,"root-1-2",1,false)); 
		departments.add(new TbEnterpriseDepartment(6,"root-1-2-1",5,false)); 
		departments.add(rootDepartment); 
		HashMap<Integer,TbEnterpriseDepartment>departmentMap = new HashMap<>(); 
		//初始化HashMap 
		for (TbEnterpriseDepartment department : departments) { 
			departmentMap.put(department.getId(),department); 
		} 
		//遍历添加 
		for (TbEnterpriseDepartment department : departments) { 
			//如果确定parentId一定存在去除此条件            
			if(departmentMap.containsKey(department.getParentId())){ 
				departmentMap.get(department.getParentId()).addChildDepartment(department); 
			} 
		} 
		System.out.println(rootDepartment); 
	}
}
