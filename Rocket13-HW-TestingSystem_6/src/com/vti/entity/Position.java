package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Position {
	public static int COUNT = 0;
	public int postID;
	public PositionName postName;
	public enum PositionName{
		DEV, TEST, SCRUM_MASTER,PM 
	}
	@Override
	public String toString() {
		return "Position [postID=" + postID + ", postName=" + postName + "]";
	}
	public Position( PositionName postName) {
		super();
		COUNT++;
		this.postID = COUNT;
		System.out.println("Chon ten vi tri muon nhap 1.DEV, 2.TEST, 3.SCRUM_MASTER, 4.PM: ");
		while (true) {
			int menuPost = ScannerUltis.inputIntPositive();
			switch(menuPost) {
			case 1:
				this.postName = PositionName.DEV;
				break;
			case 2:
				this.postName = PositionName.TEST;
				break;
			case 3:
				this.postName = PositionName.SCRUM_MASTER;
				break;
			case 4:
				this.postName = PositionName.PM;
				break;
				default:
					System.out.println("SAI SAI ROI! Nhap lai: ");
					break;
			}
		}
	}
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
}
