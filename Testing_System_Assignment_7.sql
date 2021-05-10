USE TestingSystem;

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước

DROP TRIGGER IF EXISTS Trg_dont_input_group_1_year;
DELIMITER $$
	CREATE TRIGGER 	Trg_dont_input_group_1_year
    BEFORE 	INSERT 		ON		`group`
    FOR EACH ROW
    BEGIN
		DECLARE CreateDate DATETIME;
        SELECT g.`Group` INTO `Group` FROM `group` g ;
        IF NEW.CreateDate < DATEDIIF(yyyy,1,Now()) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Can not insert data';
		END IF;
    END$$
DELIMITER ;

INSERT INTO `group` (GroupID, GroupName, CreateDate) VALUES('1', 'TestingSystem', '2020/12/12');
SELECT * FROM `group`;


-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
  -- "Sale" cannot add more user
  
  DROP TRIGGER IF EXISTS Trg_dont_input_user_departmentname;
DELIMITER $$
	CREATE TRIGGER 	Trg_dont_input_user_departmentname
    BEFORE 	INSERT 		ON		Department
    FOR EACH ROW
    BEGIN
		IF(NEW.DepartmentName = 'Sale') THEN
        SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = '"Department" Sale" cannot add more user';
		END IF;
    END$$
DELIMITER ;
INSERT INTO Department(DepartmentName) VALUES('Sale');
SELECT * FROM Department;
        
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS Trg_layout_max_5_user;
DELIMITER $$
	CREATE TRIGGER 	Trg_layout_max_5_user
    BEFORE 	INSERT 		ON		groundaccount
    FOR EACH ROW
    BEGIN
        IF (SELECT * FROM groupaccount GROUP BY GroupID HAVING COUNT(AccountID)>=5) THEN
        SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Account username max';
		END IF;
    END$$
DELIMITER ;
INSERT INTO GroupAccount (GroupID, AccountID) VALUES( '1', '1');

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS Trg_layout_exam_max_5_question;
DELIMITER $$
	CREATE TRIGGER		Trg_layout_exam_max_5_question
    BEFORE		INSERT  ON 	ExamQuestion
    FOR EACH ROW
    BEGIN
		IF(SELECT * FROM ExamQuestion GROUP BY QuestionID HAVING COUNT(QuestionID)>=10) THEN
        SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Exam question max';
		END IF;
    END $$
DELIMITER ;
INSERT INTO ExamQuestion(ExamID, QuestionID) VALUES('2','2');

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), 
 -- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó
 DROP TRIGGER IF EXISTS Trg_dont_account_have_email_admin;
DELIMITER $$
	CREATE TRIGGER		Trg_dont_account_have_email_admin
    BEFORE		INSERT  ON 	`account`
    FOR EACH ROW
    BEGIN
		IF OLD.Email = 'admin@gmail.com' THEN 
        SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Dont not delete account email admin';
		ELSEIF OLD.Email != 'admin@gmail.com' THEN
			SIGNAL SQLSTATE '12345'
				SET MESSAGE_TEXT = 'You can delete account email admin';
        END IF;
	END $$
DELIMITER ;
INSERT INTO `Account`(AccountID, Email, UserName, Fullname, DepartmentID, PositionID, CreateDate)
VALUE 				 ('1', 'admin@gmail.com', 'kilig', 'kiliga','2','3','2021-3-3');

DELETE FROM `Account` WHERE Email = 'admin@gmail.com';

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table 
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền 
 -- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
 DROP TRIGGER IF EXISTS Trg_not_input_departmentId_of_wating_deparment;
 DELIMITER $$
	CREATE TRIGGER		Trg_not_input_departmentId_of_wating_deparment
    BEFORE		INSERT  ON 	`account`
    FOR EACH ROW
    BEGIN
		DECLARE waiting_departmentID TINYINT UNSIGNED;
        SELECT d.DepartmentID  INTO waiting_departmentID 
        FROM  Department d;
        IF NEW.DepartmentID IS NULL THEN
			 SET NEW.DepartmentID = waiting_departmentID;
				SIGNAL SQLSTATE '12345'
					SET MESSAGE_TEXT = 'insert data for deparment';
		END IF;
    END
$$DELIMITER ;

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS Trg_user_insert_max_4_question;
DELIMITER $$
	CREATE TRIGGER Trg_user_insert_max_4_question
    BEFORE	INSERT	ON Answer
    FOR EACH ROW 
    BEGIN
		DECLARE numberAnswer TINYINT UNSIGNED;
        DECLARE numberCorrectAnswer TINYINT UNSIGNED;
        SELECT a.answerID INTO numberAnswer
        FROM answer a 
        WHERE NEW.AnswerID = numberAnswer
        UNION
        SELECT a.answerID, COUNT(AnswerID) INTO numberCorrectAnswer
        FROM answer a
        WHERE NEW.AnswerID = numberCorrectAnswer AND isCorrect = 'Yes';
        IF numberAnswer > 4 OR numberCorrectAnswer = 2 THEN
			SIGNAL SQLSTATE '12345'
					SET MESSAGE_TEXT = 'insert data for answer';
		END IF;
	END $$
DELIMITER ;
-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định 
 -- Thì sẽ đổi lại thành M, F, U cho giống vs cấu hình
 
 DROP TRIGGER IF EXISTS Trg_change_character_gender;
 DELIMITER $$
	CREATE TRIGGER Trg_change_character_gender
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		IF NEW.Gender = 'Nam'
        THEN
        SET NEW.Gender = 'M';
        ELSEIF NEW.Gender = 'Nu'
        THEN
        SET NEW.Gender = 'F';
        ELSEIF NEW.Gender ='Unable'
        THEN 
        SET New.Gender = 'U';
        END IF;
    END $$
DELIMITER ;
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS Trg_dont_delete_createdate_after_2day;
DELIMITER $$
	CREATE TRIGGER Trg_dont_delete_createdate_after_2day
    BEFORE DELETE ON Exam
    FOR EACH ROW
    BEGIN
		IF NEW.CreateDate <= DATEDIFF(day,'2',NOW()) THEN
			SIGNAL SQLSTATE '12345'
					SET MESSAGE_TEXT = 'Delete dont data for exam';
		END IF;
    END $$
DELIMITER ;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào
-- UPDATE
DROP TRIGGER IF EXISTS Trg_update_question_on_exam;
DELIMITER $$
	CREATE TRIGGER Trg_update_question_on_exam
    BEFORE UPDATE ON Question
    FOR EACH ROW
    BEGIN
		DECLARE 	no_question_one_exam TINYINT;
        SELECT 		q.QuestionID INTO no_question_one_exam
        FROM 		Question q
        LEFT JOIN 	ExamQuestion eq ON q.QuestionID = eq.QuestionID;
        IF 			NEW.QuestionID = OLD.QuestionID
        THEN
					SIGNAL SQLSTATE '12345'
					SET MESSAGE_TEXT = 'Dont update question, question existing on exam!';
		ELSEIF		NEW.QuestionID != OLD.QuestionID
        THEN
					SIGNAL SQLSTATE '12345'
					SET MESSAGE_TEXT = 'Update question on exam!';
		END IF;
    END $$
DELIMITER ;

-- DELETE
DROP TRIGGER IF EXISTS Trg_update_question_on_exam;
DELIMITER $$
	CREATE TRIGGER Trg_update_question_on_exam
    BEFORE DELETE ON Question
    FOR EACH ROW
    BEGIN
		DELETE	FROM	Question q
		WHERE			NEW.QuestionID != OLD.QuestionID;
    END $$
DELIMITER ;

-- Question 12: Lấy ra thông tin exam trong đó: Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time". Duration > 60 thì sẽ đổi thành giá trị "Long time"

DROP TRIGGER IF	EXISTS Trg_get_question_value_duration;
DELIMITER $$
	CREATE	TRIGGER Trg_get_question_value_duration
    ALTER	INSERT	ON	Exam
    FOR EACH ROW
    BEGIN
		IF	Duration <= 30	
        THEN
			SIGNAL SQLSTATE '12345'
            SET	MESSAGE_TEXT	=	'Short time';
		ELSEIF	Duration <= 60 AND Duration < 30	
        THEN
			SIGNAL SQLSTATE '12345'
            SET	MESSAGE_TEXT	=	'Medium time';
		ELSEIF	Duration > 60 
        THEN
			SIGNAL SQLSTATE '12345'
            SET	MESSAGE_TEXT	=	'Long time';
		END IF;
    END
DELIMITER ;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên 
 -- là the_number_user_amount và mang giá trị được quy định như sau:2
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher

DROP TRIGGER IF EXISTS Trg_statistical_account_every_group;
DELIMITER $$
	CREATE TRIGGER Trg_statistical_account_every_group
    AFTER INSERT ON GroupAccount
    FOR EACH ROW
    BEGIN
		SELECT		ga.GroupID, COUNT(AccountID) AS  'the_number_user_amount'
        FROM		GroupAccount ga
        GROUP BY	GroupID;
        IF			COUNT(AccountID) <= 5
        THEN		
					SIGNAL SQLSTATE '12345'
                    SET	MESSAGE_TEXT	=	'Few';
		ELSEIF		COUNT(AccountID) <= 20 AND COUNT(AccountID) > 5
        THEN
					SIGNAL SQLSTATE '12345'
					SET MESSAGE_TEXT = 'Normal';
		ELSEIF		COUNT(AccountID) > 20
        THEN
					SIGNAL SQLSTATE '12345'
					SET MESSAGE_TEXT = 'Higher';
		END IF;
    END $$
DELIMITER ;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào 
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
 
 DROP TRIGGER IF EXISTS Trg_statistical_department__user;
 DELIMITER $$
	CREATE TRIGGER Trg_statistical_department__user
	AFTER  INSERT ON Department
    FOR EACH ROW
    BEGIN
		SELECT			d.DepartmentName, COUNT(AccountID) AS 'number_user_on_department'
        FROM			Department d
        INNER JOIN		`Account` a ON d.DepartmentID = a.DepartmentID
        GROUP BY		DepartmentName;
        IF				COUNT(AccountID) = 0
        THEN
						SIGNAL SQLSTATE '12345'
                        SET MESSAGE_TEXT = 'No User';
		ELSEIF			COUNT(AccocuntID)
        THEN			
						SIGNAL SQLSTATE '12345'
                        SET MESSAGE_TEXT = 'Statistical user on department';
		END IF;
    END $$
	DELIMITER ;
    