package com.vti.entity;

public class Account {
	private int projectId;
	private String projectName;
	private int teamSize;
	private String fullName;
	private String email;
	private String password;
	private Staff staff;
	public enum Staff{Manager, Employee}
	public Account(int projectId, String projectName, int teamSize, String fullName, String email, String password,
			Staff staff) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.teamSize = teamSize;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.staff = staff;
	}
	@Override
	public String toString() {
		return "Account [projectId=" + projectId + ", projectName=" + projectName + ", teamSize=" + teamSize
				+ ", fullName=" + fullName + ", email=" + email + ", password=" + password + ", staff=" + staff + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	};
	
}
