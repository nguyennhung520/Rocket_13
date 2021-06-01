package com.vti.entity;

public class Department {
	public static int COUNT;
	private int id;
	private String name;
	public Department(String name) {
		super();
		COUNT++;
		this.id = COUNT;
		this.name = name;
	}
	public Department() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	private static void question4() {
		Department dep1 = new Department("Department 1");
		Department dep2 = new Department("Department 2");
		Department dep3 = new Department("Department 3");
		Department dep4 = new Department("Department 4");
		Department dep5 = new Department("Department 5");
		Department[] depArray = { dep1, dep2, dep3, dep4, dep5 };
		try {
			System.out.println(depArray[10]);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("NO FIND DEP IN LIST!!!");
		}

	}
}
