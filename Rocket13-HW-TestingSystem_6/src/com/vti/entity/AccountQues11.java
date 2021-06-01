package com.vti.entity;

import com.vti.backend.InvalidAgeInputingException;
import com.vti.ultis.ScannerUltis;

public class AccountQues11 {
	public static int COUNT = 0;
	private int accountId;
	private String email;
	private String userName;
	private int age;
	@Override
	public String toString() {
		return "AccountQues11 [accountId=" + accountId + ", email=" + email + ", userName=" + userName + ", age=" + age
				+ "]";
	}
	public AccountQues11() throws InvalidAgeInputingException {
		super();
		System.out.println("Moi ban nhap thong tin account can tao moi");
		this.accountId = COUNT++;
		System.out.println("Email: ");
		this.email = ScannerUltis.inputString();
		System.out.println("UserName: ");
		this.userName = ScannerUltis.inputString();
		this.age = inputAccountAge();
	}
	private int inputAccountAge() throws InvalidAgeInputingException {
		System.out.println("Age: ");
		while(true) {
			int ageInput = ScannerUltis.inputInt();
			if(ageInput <= 0) {
				throw new InvalidAgeInputingException("The age must be greater than 0, please input again");
			}else {
				return ageInput;
			}
		}
	}
}
