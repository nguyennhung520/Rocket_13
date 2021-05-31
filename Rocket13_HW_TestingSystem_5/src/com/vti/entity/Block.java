package com.vti.entity;


public class Block {
	private int blockID;
	private String blockName;
	private String subjectName;
	private static int COUNT = 0;
	
	public Block(String blockName, String subjectName) {
		super();
		COUNT++;
		this.blockID = COUNT;
		this.blockName = blockName;
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Block [blockID=" + blockID + ", blockName=" + blockName + ", subjectName=" + subjectName + "]";
	}
	
	public String getSubjectOfBlock(){		
		switch (this.blockName) {
		case "A":
			this.blockName = "Toan, Ly, Hoa";
			break;
		case "B":
			this.blockName = "Toan, Hoa, Sinh";
			break;
		case "C":
			this.blockName = "Van, Su, Dia";
			break;
		default:
			System.out.println("Error input database!");
			break;
		}
		return this.blockName;
	}
}
