
DROP DATABASE IF EXISTS Facebook_DB;
-- create database Facebook_DB
CREATE DATABASE Facebook_DB;
-- use data
USE Facebook_DB;

-- create table national
DROP TABLE IF EXISTS `National`;
CREATE TABLE `National`
(
	National_id				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    National_Name			VARCHAR(50)	NOT NULL UNIQUE KEY,
    Language_Main			VARCHAR(50) NOT NULL UNIQUE KEY
);

-- create table office
DROP TABLE IF EXISTS Office;
CREATE TABLE Office
(
	Office_id				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Street_Address			VARCHAR(100) NOT NULL UNIQUE KEY,
    National_id				SMALLINT UNSIGNED,
    FOREIGN KEY				(National_id)	REFERENCES `National`(National_id)	
);

-- create table staff
DROP TABLE IF EXISTS Staff;
CREATE TABLE Staff
(
	Staff_id				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    First_Name				VARCHAR(30) NOT NULL UNIQUE KEY, 
    Last_Name				VARCHAR(30) NOT NULL UNIQUE KEY, 
    Email					VARCHAR(100) NOT NULL UNIQUE KEY, 
    Office_id				SMALLINT UNSIGNED,
    FOREIGN KEY				(Office_id)		REFERENCES Office(Office_id)
);

-- Ques2: Thêm 10 bản ghi vào các table.

-- insert table national
INSERT INTO `National` 			(National_Name, Language_Main)	
VALUES							('NationalName1','LanguageMain1'),
								('NationalName2','LanguageMain2'),
                                ('NationalName3','LanguageMain3'),
                                ('NationalName4','LanguageMain4'),
                                ('NationalName5','LanguageMain5'),
                                ('NationalName6','LanguageMain6'),
                                ('NationalName7','LanguageMain7'),
                                ('NationalName8','LanguageMain8'),
                                ('NationalName9','LanguageMain9'),
                                ('NationalName10','LanguageMain10');

-- insert table office
INSERT INTO Office 				 (Street_Address, National_id)
VALUES							('Street_Address1'),
								('Street_Address2'),
                                ('Street_Address3'),
                                ('Street_Address4'),
                                ('Street_Address5'),
                                ('Street_Address6'),
								('Street_Address7'),
                                ('Street_Address8'),
                                ('Street_Address9'),
                                ('Street_Address10');
                                
-- insert table staff
INSERT INTO Staff 				(First_Name, 		Last_Name, 			Email)	
VALUES							('First_Name1', 	'Last_Name1', 		'Email1'),
								('First_Name2', 	'Last_Name2', 		'Email2'),
                                ('First_Name3', 	'Last_Name3', 		'Email3'),
                                ('First_Name4', 	'Last_Name4', 		'Email4'),
                                ('First_Name5', 	'Last_Name5', 		'Email5'),
                                ('First_Name6', 	'Last_Name6', 		'Email6'),
                                ('First_Name7', 	'Last_Name7', 		'Email7'),
                                ('First_Name8', 	'Last_Name8', 		'Email8'),
                                ('First_Name9', 	'Last_Name9', 		'Email9'),
                                ('First_Name10', 	'Last_Name10', 		'Email10');


-- Ques3: Bạn hãy lấy dữ liệu của tất cả nhân viên đang làm việc tại Vietnam
SELECT 		na.National_Name, s.First_Name, s.Last_Name, s.Email
FROM 	 	Staff s 
INNER JOIN 	Office o ON s.Office_id = s.Office_id
INNER JOIN `National` na ON na.National_id = o.National_id
WHERE 		na.National_Name = 'Vietnam';

-- Ques4: Lấy ra ID, FullName, Email, National của mỗi nhân viên
SELECT 		na.National_Name, s.Staff_id, s.First_Name, s.Last_Name
FROM 		Staff s, `National` na;

-- Ques5: Lấy ra tên nước mà nhân viên có Email: "daonq@viettel.com.vn" đang làm việc.
SELECT		na.National_Name, s.Email
FROM		Staff s
INNER JOIN 	Office o ON s.Office_id = s.Office_id
INNER JOIN `National` na ON na.National_id = o.National_id
WHERE		s.Email = 'daonq@viettel.com.vn';

-- Ques6: Bạn hãy tìm xem trên hệ thống có quốc gia nào có thông tin trên hệ thống nhưng 
-- không có nhân viên nào đang làm việc.

-- Ques7: Thống kê xem trên thế giới có bao nhiêu quốc gia mà FB đang hoạt động sử dụng 
	-- tiếng Anh làm ngôn ngữ chính

SELECT na.Language_Main, COUNT(na.National_id) AS 'number_national_use_language_English'
FROM	`National` na
WHERE	na.Language_Main = 'English';

-- Ques8: Viết lệnh để lấy ra thông tin nhân viên có tên (First_Name) có 10 ký tự, bắt đầu bằng 
-- chữ N và kết thúc bằng chữ C
SELECT	s.First_Name, LENGTH(s.First_Name)
FROM	Staff s
WHERE 	LENGTH(s.First_Name)= 10 	AND SUBSTRING_INDEX(First_Name, ' ', -1) LIKE 'N%C' ;

-- Ques10: Nhân viên có mã ID =9 hiện tại đã nghỉ việc, bạn hãy xóa thông tin của nhân viên này trên hệ thống
DELETE	FROM 	Staff s
WHERE			Staff_id = '9';

-- Ques11: FB vì 1 lý do nào đó không còn muốn hoạt động tại Australia nữa, và Mark Zuckerberg 
-- muốn bạn xóa tất cả các thông tin trên hệ thống liên quan đến quốc gia này. Hãy 
-- tạo 1 Procedure có đầu vào là tên quốc gia cần xóa thông tin để làm việc này và gửi lại cho anh ấy.

DROP PROCEDURE IF EXISTS sp_delete_national_in_australia;
DELIMITER $$
CREATE PROCEDURE sp_delete_national_in_australia(IN national_name VARCHAR(50))
	BEGIN
		DELETE na.National_id FROM `National` na WHERE na.National_Name = national_name;
    END
$$ DELIMITER ;