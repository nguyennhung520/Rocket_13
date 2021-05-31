package com.vti.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {
	private String personName;
	private Gender gender;
	private LocalDate brithDay;
	private String address;
	public enum Gender {
		MALE, FEMALE, UNKNOW;
	}
	public Person(String personName, Gender gender, LocalDate brithDay, String address) {
		super();
		this.personName = personName;
		this.gender = gender;
		this.brithDay = brithDay;
		this.address = address;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("THONG TIN PERSON");
		System.out.println("Person name: ");
		this.personName = sc.nextLine();
		System.out.println("GENDER 1.Male, 2.Female, 3.Unknow: ");
		int menuchoose = sc.nextInt();
		switch (menuchoose) {
		case 1:
			this.gender = Gender.MALE;
			break;
		case 2:
			this.gender = Gender.FEMALE;
			break;
		case 3:
			this.gender = Gender.UNKNOW;
			break;
		default:
			System.out.println("CHU Y!!!!");
			break;
		}
		System.out.println("Nhap ngay sinh theo dinh dang yyyy-mm-dd: ");
		this.brithDay = LocalDate.parse(sc.nextLine());
		System.out.println("Dia chi: ");
		this.address = sc.nextLine();
	}
	public String showInfo() {
		return "Person [personName=" + personName + ", gender=" + gender + ", brithDay=" + brithDay + ", address="
				+ address + "]";
	}
}
