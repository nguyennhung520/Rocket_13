-- USE DATABASE TestingSystem
USE TestingSystem;
-- USE VIEW

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW 	vwDanh_Sach_Nhan_Vien_Thuoc_Phong_Ban AS
	SELECT 		a.AccountID, a.Email, a.Username, a.Fullname, a.DepartmentID
	FROM 		`Account`a
	JOIN 		Department d ON d.DepartmentID = a.DepartmentID
	WHERE		d.DepartmentID;

SELECT * FROM 	vwDanh_Sach_Nhan_Vien_Thuoc_Phong_Ban;
DROP VIEW 		vwDanh_Sach_Nhan_Vien_Thuoc_Phong_Ban;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE VIEW 	vwAccount_Tham_Gia_Nhieu_Group_Nhat AS
	SELECT  	a.AccountID, a.Username, a.Fullname, COUNT(ga.GroupID) AS number_of_groups 
	FROM 		GroupAccount ga
	INNER JOIN 	`Account` a ON a.AccountID = ga.AccountID
	GROUP BY 	ga.AccountID
	HAVING 		COUNT(ga.AccountID) = (SELECT MAX(number_of_groups) FROM (SELECT COUNT(ga.GroupID) AS number_of_groups 
										FROM 		GroupAccount ga
										JOIN 		`Account` a ON a.AccountID = ga.AccountID
										GROUP BY 	ga.AccountID) AS temp);

SELECT * FROM vwAccount_Tham_Gia_Nhieu_Group_Nhat;
                              
 -- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi       
 CREATE VIEW 	vwQuestion_Content AS
	SELECT  	Q.QuestionID, Q.Content, LENGTH(Q.Content) AS max_content
	FROM 		Question Q
	WHERE 		LENGTH(Q.Content) > 19;
 
 SELECT * FROM 	vwQuestion_Content;
 
 -- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
 CREATE VIEW 	vw_get_department_for_max_employees
 AS
				SELECT 		a.AccountID, a.Username, a.Fullname, d.DepartmentID, COUNT(DepartmentID)
				FROM			Department d
				INNER JOIN 	`Account` a ON 	d.DepartmentID = a.DEpartmentID
				GROUP BY		d.DepartmentID
				HAVING			d.DepartmentID = ( SELECT a.AccountID, a.Username, a.Fullname, d.DepartmentID, COUNT(DepartmentID)
														FROM			Department d
														INNER JOIN 	`Account` a ON 	d.DepartmentID = a.DEpartmentID
														GROUP BY		d.DepartmentID
														HAVING 		COUNT(DepartmentID)
														ORDER BY		COUNT(DepartmentID) DESC
														LIMIT			1
												  );
  
  SELECT * FROM 	vw_get_department_for_max_employees;
  
  -- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
  CREATE VIEW	vw_get_question_user_for_nguyen
  AS
				SELECT 		Q.QuestionID, Q.Content, Q.CreatorID
				FROM 			Question Q
				INNER JOIN	`Account` A ON A.AccountID = Q.CreatorID
				WHERE			substring_index(Fullname,'', '1')='Nguyễn';
                
  SELECT * FROM   vw_get_question_user_for_nguyen;           