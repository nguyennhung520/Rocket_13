package com.vti.entity;

public class HCN {
	private float a;
	private float b;
	
	public float chuVi() {
		return 2 *(a+b);
	}
	public float dienTich() {
		return a * b;
	}
	public HCN(float a, float b) {
		super();
		this.a = a;
		this.b = b;
	}
}
