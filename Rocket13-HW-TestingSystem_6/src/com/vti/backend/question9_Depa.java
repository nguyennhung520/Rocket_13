package com.vti.backend;

import java.util.ArrayList;

import com.vti.entity.Department;

public class question9_Depa {
	private static void ques9_Dep() {
		Department dep1 = new Department();
		Department dep2 = new Department();
		Department dep3 = new Department();
		Department dep4 = new Department();
		Department dep5 = new Department();
		ArrayList<Department> listDep = new ArrayList<Department>();
		listDep.add(dep1);
		listDep.add(dep2);
		listDep.add(dep3);
		listDep.add(dep4);
		listDep.add(dep5);
		System.out.println("Thong tin departemnt vua nhap: ");
		for (Department department : listDep) {
			System.out.println(department);
		}
	}
}
