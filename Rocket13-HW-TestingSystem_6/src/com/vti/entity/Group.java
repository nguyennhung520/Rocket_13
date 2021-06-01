package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;

import com.vti.ultis.ScannerUltis;

public class Group {
	public static int COUNT = 0;
	private int groupId;
	private String groupName;
	private Account_11 creator;
	private LocalDate createDate;
	private Account_11[] accounts;
	
	public void printInforGroup() {
		System.out.println("INFORMATION GROUP");
		System.out.println("Group [groupId=" + groupId + ", grounpName=" + groupName + ", creator=" + creator + ", createDate="
				+ createDate + ", accounts=" + Arrays.toString(accounts) + "]");
		if(accounts !=null) {
			System.out.println("So luong Account trong group nay la: "+accounts.length);
			for (Account_11 account_11 : accounts) {
				System.out.println(account_11.toString());
			}
		}
	}

	public Group() {
		super();
		System.out.println("Nhap thong tin tao Group: ");
		COUNT++;
		this.groupId = COUNT;
		System.out.println("Nhap ten group");
		this.groupName = ScannerUltis.inputString();
		System.out.println("Nhap ngay tao Group: ");
		this.createDate = ScannerUltis.inputLocalDate();
		System.out.println("Ban co muon add Account vao Group hay khong, 1.Co, 2.Khong");
		while(true) {
			int menuAddAcc = ScannerUltis.inputIntPositive();
			switch (menuAddAcc) {
			case 1:
				System.out.println("Nhap so luong account muon them vao Group nay: ");
				int countAcc = ScannerUltis.inputIntPositive();
				Account_11[] accs = new Account_11[countAcc];
				for (int i = 0; i < countAcc; i++) {
					System.out.println("Nhap vao tu Account thu "+(i+1)+ ": ");
					Account_11 acc_11 = new Account_11();
					accs[i]  = acc_11;
				}
				this.accounts = accs;
				return;
			case 2:
				return; 
			default:
				System.out.println("NAO SAI SAI ROI! Nhap lai: ");
				break;
			}
		}
	}
}
