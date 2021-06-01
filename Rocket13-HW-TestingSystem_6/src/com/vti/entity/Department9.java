package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Department9 {
	public static int COUNT;
	private int depID;
	private String depName;
	public Department9(String depName) {
		super();
		COUNT++;
		this.depID = COUNT;
		this.depName = depName;
	}
	@Override
	public String toString() {
		return "Department9 [depID=" + depID + ", depName=" + depName + "]";
	}
	public Department9() {
		super();
		COUNT++;
		this.depID = COUNT;
		System.out.println("Nhap ten phong: ");
		this.depName = ScannerUltis.inputString();
	}
	
}
