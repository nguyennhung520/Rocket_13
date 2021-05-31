package com.vti.entity;

public interface ITuyenSinh {
//	a. Thêm mới thí sinh.
//	b. Hiện thị thông tin của thí sinh và khối thi của thí sinh.
//	c. Tìm kiếm theo số báo danh.
//	d. Thoát khỏi chương trình.
	public void addStudent();
	public void printInformationStudentandBlock();
	public void	searchStudentID(int studentID);
	public void exitprogram();
}
