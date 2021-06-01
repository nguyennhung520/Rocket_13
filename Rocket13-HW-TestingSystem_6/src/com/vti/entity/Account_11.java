package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Account_11 {
	public static int COUNT ;
	private int accountId;
	private String email;
	private String userName;
	private String fullName;
	
	@Override
	public String toString() {
		return "Account_11 [accountId=" + accountId + ", email=" + email + ", userName=" + userName + ", fullName="
				+ fullName + "]";
	}

	public Account_11() {
		super();
		System.out.println("Nhap thong tin Account: ");
		COUNT++;
		this.accountId = COUNT;
		System.out.println("Nhap email: ");
		this.email = ScannerUltis.inputString();
		System.out.println("Nhap userName: ");
		this.userName = ScannerUltis.inputString();
		System.out.println("Nhap fullname: ");
		this.fullName = ScannerUltis.inputString();
		
	}

	
}
