-- LESSTION PROCEDURE
-- USE TestingSystem
USE TestingSystem;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó 
DROP PROCEDURE IF EXISTS sp_get_list_account_by_deptmame;
DELIMITER $$
CREATE PROCEDURE sp_get_list_account_by_deptmame(IN in_depname VARCHAR(30))
BEGIN
	SELECT a.Email, a.Username, a.FullName 
	FROM Department d 
	INNER JOIN `account` a  ON d.DepartmentID = a.DepartmentID
	WHERE d.DepartmentName = in_depname;
END$$
DELIMITER ;

CALL sp_get_list_account_by_deptmame('Sale');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS sp_get_number_account_in_groups;
DELIMITER $$
CREATE PROCEDURE sp_get_number_account_in_groups()
BEGIN
	SELECT g.GroupName, COUNT(ga.AccountID) AS number_of_accounts
	FROM `Group` g 
	LEFT JOIN groupaccount ga ON g.GroupID = ga.GroupID
	GROUP BY ga.GroupID;
END$$
DELIMITER ;

CALL sp_get_number_account_in_groups();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại

DROP PROCEDURE IF EXISTS sp_get_sum_questions_of_month;
DELIMITER $$
CREATE PROCEDURE sp_get_sum_questions_of_month()
BEGIN
	SELECT  Q.QuestionID, Q.CreatorID, SUM(CreatorID) AS sum_questions_of_month
	FROM 	Question Q
    WHERE	MONTH(CreateDate) = MONTH(NOW);
END$$
DELIMITER ;
CALL sp_get_number_account_in_groups();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS sp_get_TypeID_MaxQuestion;
DELIMITER $$
CREATE PROCEDURE sp_get_TypeID_MaxQuestion()
BEGIN

	WITH MAX_Count_TypeID AS(
		SELECT		COUNT(TypeID)
		FROM		Question 
		GROUP BY	TypeID
        ORDER BY	COUNT(TypeID) DESC
		LIMIT 		1
    )
    SELECT 		TypeID
    FROM		Question
    GROUP BY 	TypeID
    HAVING		COUNT(TypeID) = (SELECT * FROM MAX_Count_TypeID);	
	
END$$
DELIMITER ;

call sp_get_TypeID_MaxQuestion();

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS sp_get_Name_TypeQuestion;
DELIMITER $$
CREATE PROCEDURE sp_get_Name_TypeQuestion()
BEGIN

	WITH MAX_Count_TypeID AS(
		SELECT		COUNT(TypeID)
		FROM		Question 
		GROUP BY	TypeID
        ORDER BY	COUNT(TypeID) DESC
		LIMIT 		1
    )
    SELECT 		TypeName
    FROM		Question
    GROUP BY 	TypeID
    HAVING		COUNT(TypeID) = (SELECT * FROM MAX_Count_TypeID);	
	
END$$
DELIMITER ;
call sp_get_Name_TypeQuestion();
-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên 
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa 
 -- chuỗi của người dùng nhập vào

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và 
 -- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
 -- Sau đó in ra kết quả tạo thành côn


-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice 
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
-- INPUT: Typequestion(Typename): Essay or Multiple-Choice
-- OUTPUT: MAX(LENGTH(Content)) MAX(LENGTH(20)=1, MAX(LENGTH(19)=2

DROP PROCEDURE IF EXISTS sp_input_typename_output_max_content;
DELIMITER $$
CREATE PROCEDURE sp_input_typename_output_max_content(IN in_typename ENUM('Essay','Multiple-Choice'))
BEGIN
		IF( in_typename = 'Essay') 						THEN
			SELECT 			MAX(LENGTH(q.Content))
			FROM			Question q
			WHERE			q.TypeID = 1;
		ELSEIF(in_typename = 'Multiple-Choice')			THEN
			SELECT			MAX(LENGTH(q.Content))
			FROM			Question q
			WHERE			q.TypeID = 2;
		END IF;
END
$$
DELIMITER ;
CALL sp_input_typename_output_max_content();

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
-- INPUT: Nhap ExamID
-- OUTPUT: Neu ExamID(Nhap) = ExamID(Bang) -->Thi --> Xoa

DROP PROCEDURE IF EXISTS sp_delete_table_of_exmaid;
DELIMITER $$
CREATE PROCEDURE sp_delete_table_of_exmaid(IN in_examID TINYINT UNSIGNED)
BEGIN
		DELETE 
		FROM 		Exam
		WHERE		ExamID = in_examId;
END$$
DELIMITER ;
CALL sp_delete_table_of_exmaid();

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing		
-- INPUT: CreateDate >= 3 
-- OUTPUT: (Year(Now())-Year(CreateDate))>=3)-->delete
