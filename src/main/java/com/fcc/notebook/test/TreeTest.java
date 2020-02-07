package com.fcc.notebook.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fcc.notebook.utils.TbEnterpriseDepartment;

public class TreeTest {
	public static void main(String[] args) throws Exception  {
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
		//结果 
		//{"childDepartments":[{"childDepartments":[{"id":3,"name":"root-1-1-1","parentId":2},{"id":4,"name":"root-1-1-2","parentId":2}],"id":2,"name":"root-1-1","parentId":1},{"childDepartments":[{"id":6,"name":"root-1-2-1","parentId":5}],"id":5,"name":"root-1-2","parentId":1}],"id":1,"name":"root-1","parentId":-1}	
	}
}
