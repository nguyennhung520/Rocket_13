package com.vti.entity;

public class Manager extends Account{
	private int ExpInYear;
	private ProSkill proSkill;
	private enum ProSkill{DEV, TEST, JAVA, SQL};
	
	public Manager(int projectId, String projectName, int teamSize, String fullName, String email, String password,
			Staff staff, int expInYear, ProSkill proSkill) {
		super(projectId, projectName, teamSize, fullName, email, password, staff);
		ExpInYear = expInYear;
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return super.toString()+ "Manager [ExpInYear=" + ExpInYear + ", proSkill=" + proSkill + "]";
	}
}
