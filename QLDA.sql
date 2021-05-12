-- CREATE DATABASE Quản lý đồ án ĐHBKHN
DROP DATABASE IF EXISTS quanlydoan;
CREATE DATABASE QuanLyDoAn;
USE QuanLyDoAn;

-- create table GiangVien
DROP TABLE IF EXISTS GiangVien;
CREATE TABLE GiangVien
(
	Id_GV 	SMALLINT UNSIGNED  AUTO_INCREMENT PRIMARY KEY,
    Ten_GV 	VARCHAR(50) NOT NULL UNIQUE KEY,
    Tuoi	SMALLINT NOT NULL UNIQUE KEY,
    HocVi	VARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table sinhvien
DROP TABLE IF EXISTS SinhVien;
CREATE TABLE SinhVien
(
	Id_SV	SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Ten_SV	VARCHAR(50) NOT NULL UNIQUE KEY,
    NamSinh	INT NOT NULL UNIQUE KEY,
    QueQuan	VARCHAR(100)  NOT NULL UNIQUE KEY   
);

-- Create table detai
DROP TABLE IF EXISTS DeTai;
CREATE TABLE DeTai
(
	Id_DeTai	SMALLINT UNSIGNED  AUTO_INCREMENT PRIMARY KEY,
    Ten_DeTai	VARCHAR(50) NOT NULL UNIQUE KEY
);

-- create table HuongDan
DROP TABLE IF EXISTS HuongDan;
CREATE TABLE HuongDan
(
	Id	 		SMALLINT UNSIGNED   AUTO_INCREMENT PRIMARY KEY,
    Id_SV		SMALLINT UNSIGNED NOT NULL,
    Id_DeTai	SMALLINT UNSIGNED NOT NULL,
    Id_GV 		SMALLINT UNSIGNED NOT NULL,
    Diem		FLOAT,
    FOREIGN KEY(Id_SV) REFERENCES SinhVien(Id_SV),
    FOREIGN KEY(Id_DeTai) REFERENCES DeTai(Id_DeTai),
	FOREIGN KEY(Id_GV) REFERENCES GiangVien(Id_GV)
);

-- INSERT DATA
INSERT INTO GiangVien(Id_GV,	Ten_GV,			Tuoi,		HocVi)
VALUES				(null,		'GiangVien1',	'25', 		'HocVi1'),
					(null,		'GiangVien2',	'30', 		'HocVi2'),
					(null,		'GiangVien3',	'32', 		'HocVi3'),
					(null,		'GiangVien4',	'56',		'HocVi4'),
					(null,		'GiangVien5',	'31',		'HocVi5'),
					(null,		'GiangVien6',	'33', 		'HocVi6'),
					(null,		'GiangVien7',	'26',		'HocVi7'),
					(null,		'GiangVien8',	'37', 		'HocVi8'),
					(null,		'GiangVien9',	'27', 		'HocVi9'),
					(null,		'GiangVien10',	'29', 		'HocVi10');


INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan) VALUES('SinhVien1', '1999', 'HaNoi');
INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan) VALUES('SinhVien2', '1998', 'HaiPhong');
INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan) VALUES('SinhVien3', '2000', 'QueQuan3');
INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan) VALUES('SinhVien4', '1997', 'QueQuan4');
INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan) VALUES('SinhVien5', '1996', 'QueQuan5');
INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan) VALUES('SinhVien6', '1995', 'QueQuan6');
INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan) VALUES('SinhVien7', '1994', 'QueQuan7');
INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan) VALUES('SinhVien8', '1993', 'QueQuan8');
INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan) VALUES('SinhVien9', '2001', 'QueQuan9');
INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan) VALUES('SinhVien10', '2002', 'QueQuan10');

INSERT INTO DeTai(Ten_DeTai) VALUE('DeTai1');
INSERT INTO DeTai(Ten_DeTai) VALUE('DeTai2');
INSERT INTO DeTai(Ten_DeTai) VALUE('DeTai3');
INSERT INTO DeTai(Ten_DeTai) VALUE('DeTai4');
INSERT INTO DeTai(Ten_DeTai) VALUE('DeTai5');
INSERT INTO DeTai(Ten_DeTai) VALUE('DeTai6');
INSERT INTO DeTai(Ten_DeTai) VALUE('DeTai7');
INSERT INTO DeTai(Ten_DeTai) VALUE('DeTai8');
INSERT INTO DeTai(Ten_DeTai) VALUE('DeTai9');
INSERT INTO DeTai(Ten_DeTai) VALUE('DeTai10');

INSERT INTO HuongDan(Id_SV, Id_DeTai,Id_GV,Diem) VALUES('1','1','1','1');
INSERT INTO HuongDan(Id_SV, Id_DeTai,Id_GV,Diem) VALUES('6','2','2','2');
INSERT INTO HuongDan(Id_SV, Id_DeTai,Id_GV,Diem) VALUES('3','3','3','3');
INSERT INTO HuongDan(Id_SV, Id_DeTai,Id_GV,Diem) VALUES('11','4','11','4');
INSERT INTO HuongDan(Id_SV, Id_DeTai,Id_GV,Diem) VALUES('12','5','12','5');
INSERT INTO HuongDan(Id_SV, Id_DeTai,Id_GV,Diem) VALUES('6','6','6','6');
INSERT INTO HuongDan(Id_SV, Id_DeTai,Id_GV,Diem) VALUES('7','7','7','7');
INSERT INTO HuongDan(Id_SV, Id_DeTai,Id_GV,Diem) VALUES('8','8','13','8');
INSERT INTO HuongDan(Id_SV, Id_DeTai,Id_GV,Diem) VALUES('9','9','9','9');
INSERT INTO HuongDan(Id_SV, Id_DeTai,Id_GV,Diem) VALUES('10','10','10','10');

-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
-- b) Lấy ra số sinh viên làm đề tài ‘DeTai 6’
SELECT * FROM SinhVien sv
LEFT JOIN HuongDan hd ON sv.Id_SV = hd.Id_SV
WHERE hd.Id_SV IS NULL;

SELECT * FROM  HuongDan
INNER JOIN	SinhVien sv ON sv.Id_Sv = hd.Id_SV
INNER JOIN	DeTai  dt ON	dt.Id_DeTai = hd.Id
WHERE  		dt.Ten_DeTai = '6';

-- 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
-- mã số, họ tên và tên đề tài
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")
CREATE VIEW 	vw_SinhVienInfo AS 
SELECT 			hd.Id_SV, sv.Ten_SV, dt.Ten_DeTai
FROM 			HuongDan hd
INNER JOIN		SinhVien sv ON sv.Id_SV = hd.Id_SV
INNER JOIN		DeTai 	 dt ON dt.Id_DeTai = hd.Id_DeTai
WHERE			dt.Ten_DeTai IS NULL = (SELECT dt.Ten_DeTai FROM DeTai dt WHERE dt.Ten_DeTai = 'Chưa có');

-- 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1950
-- thì hiện ra thông báo "Moi ban kiem tra lai nam sinh"

SELECT * FROM SinhVien;
SELECT 		sv.NamSinh, CASE
			WHEN sv.NamSinh <= 1950 THEN 'Moi ban kiem tra lai nam sinh'
            END AS 'student_have_born_<=_1950_year'
FROM 		SinhVien sv;

-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
-- tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi

DROP TABLE IF EXISTS HuongDan;
CREATE TABLE HuongDan
(
	Id	 		SMALLINT UNSIGNED   AUTO_INCREMENT PRIMARY KEY,
    Id_SV		SMALLINT UNSIGNED NOT NULL,
    Id_DeTai	SMALLINT UNSIGNED NOT NULL,
    Id_GV 		SMALLINT UNSIGNED NOT NULL,
    Diem		FLOAT,
    FOREIGN KEY(Id_SV) REFERENCES SinhVien(Id_SV) ON DELETE SET NULL,
    FOREIGN KEY(Id_DeTai) REFERENCES DeTai(Id_DeTai),
	FOREIGN KEY(Id_GV) REFERENCES GiangVien(Id_GV)
);

-- 6. Viết 1 Procedure để khi nhập vào tên của sinh viên thì sẽ thực hiện xóa toàn bộ thông tin 
-- liên quan của sinh viên trên hệ thống
DROP PROCEDURE IF EXISTS sp_get_input_name_student_delete;
DELIMITER $$
	CREATE PROCEDURE sp_get_input_name_student_delete(IN name_student VARCHAR(50))
	BEGIN
		SELECT sv.Ten_SV INTO name_student FROM SinhVien WHERE sv.Ten_SV = name_student;
    END$$
DELIMITER ;
SET @name_student = '';
DELETE FROM SinhVien WHERE a.Ten_SV = @name_student;