
-- USE DATABASE TestingSystem
USE TestingSystem;

-- Tiếp tục với Database Testing System PART 3

-- Question 2: lấy ra tất cả các phòng ban
SELECT * FROM department;

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT	 	DepartmentID
FROM  		department
WHERE 		DepartmentName = 'Sale';

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT * FROM `account` AS a
WHERE length(Fullname) = (SELECT max(length(Fullname)) FROM `account`);

-- Question 5 : Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT 		*	 FROM `account` 	AS a
WHERE 			length(Fullname) = 	(SELECT max(length(Fullname)) FROM `account`)
ORDER BY		Fullname	 		DESC;

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT 			GroupName
FROM 			`group`
WHERE 			CreateDate < 20/12/2019;

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT 			QuestionID
FROM 			Answer
GROUP BY 		QuestionID
HAVING 			count(QuestionID) >= 4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT 			`code`
FROM			exam
WHERE 			Duration >= 60 AND CreateDate > 20/12/2019;

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT			GroupName
FROM			`group`
ORDER BY 		CreateDate DESC
LIMIT			5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT			COUNT(DepartmentID) AS 'Employees'
FROM			`account`
WHERE			DepartmentID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT			Fullname
FROM			`account`
WHERE			(SUBSTRING_INDEX(FullName, ' ', -1)) LIKE 'D%o'; -- number(-1) kq se dc tra ve tu ben trai cua dau phan cach

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE 
FROM			Exam
WHERE			CreateDate < 2019/12/20;

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE
FROM 			Question
WHERE			(SUBSTRING_INDEX(Content,' ',2)) = 'Câu hỏi';

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE			`account`
SET 			Fullname = N'Nguyễn Bá Lộc' AND Email = 'loc.nguyenba@vti.com.vn'
WHERE			AccountID = 5;

-- Question 15: Update account có id = 5 sẽ thuộc group có id = 4
UPDATE 			`GroupAccount`
SET				AccountID = '5'
WHERE			GroupID   ='4';

-- ======================================================PART 4=====================================================================
-- Tiếp tục với Database Testing System PART 4

-- JOIN

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 			A.Email, A.Username, A.FullName, A.PositionID, A.DepartmentID, D.DepartmentName
FROM 			`account` A
INNER JOIN		Deparetment  D ON	A.DepartmentID = D.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT 			*
FROM			`account`
WHERE			CreateDate > 2010/12/20;	

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT			*
FROM		`	account` A 
INNER JOIN 		Position P ON A.PositionID = P.PositionID
WHERE			P.PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 			D.DepartmentID, D.DepartmentName, COUNT(D.DepartmentID) AS 'SO LUONG'
FROM 			`account` A 
INNER JOIN 		Department  D ON D.DepartmentID = D.DepartmentID
GROUP BY 		A.DepartmentID
HAVING 			COUNT(A.DepartmentID) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều 
SELECT 			Q.QuestionID, Q.Content, Q.CategoryID, Q.TypeID, Q.CreatorID, Q.CreateDate, Count(Q.Content) AS 'SO LUONG'
FROM			Question Q
INNER JOIN 		ExamQuestion EQ ON Q.QuestionID = EQ.QuestionID
GROUP BY		Q.Content
HAVING			COUNT(Q.Content) = (SELECT	MAX(CountQ)
								FROM		
										(SELECT 		COUNT(Q.QuestionID) AS CountQ
										FROM			ExamQuestion EQ
										INNER JOIN 		Question Q ON EQ.QuestionID = Q.QuestionID
										GROUP BY		Q.QuestionID) AS MaxContent);
                                        
-- Question 6: Thống kê mỗi category Question được sử dụng trong bao nhiêu Question
--  Từ khóa LEFT JOIN trả về tất cả các hàng của bảng bên trái (table1), kết hợp với các hàng trong bảng bên phải (table2)
SELECT		CQ.CategoryID, CQ.CategoryName, COUNT(Q.CategoryID) AS 'SO LUONG'
FROM		CategoryQuestion CQ 
LEFT JOIN 	Question Q ON CQ.CategoryID = Q.CategoryID
GROUP BY	CQ.CategoryID
ORDER BY	CQ.CategoryID ASC;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT		Q.Content, COUNT(EQ.QuestionID) AS 'SO LUONG'
FROM		Question Q 
LEFT JOIN 	ExamQuestion EQ ON EQ.QuestionID = Q.QuestionID
GROUP BY	Q.QuestionID
ORDER BY 	EQ.ExamID ASC;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT 		Q.QuestionID, Q.Content, COUNT(A.QuestionID) AS 'SO LUONG'
FROM		Question Q 
INNER JOIN 	Answer A ON	Q.QuestionID = A.QuestionID
GROUP BY	A.QuestionID
HAVING		COUNT(A.QuestionID) =	(SELECT 	MAX(CountQ)
									 FROM		(SELECT 		COUNT(A.QuestionID) AS CountQ
												FROM			Answer A 
												RIGHT JOIN  Question Q ON A.QuestionID = Q.QuestionID 
												GROUP BY		A.QuestionID) AS MaxCountQ);
			
-- Question 9: Thống kê số lượng account trong mỗi group
-- Từ khóa RIGHT JOIN trả về tất cả các hàng của bảng bên phải (table2), kết hợp với các hàng trong bảng bên trái (table1)
SELECT		G.GroupID, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		GroupAccount GA 
RIGHT JOIN 	`Group` G ON	GA.GroupID = G.GroupID
GROUP BY	G.GroupID
ORDER BY	G.GroupID ASC;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT 		P.PositionID, P.PositionName, COUNT(A.PositionID) AS 'SO LUONG'
FROM		Position P 
INNER JOIN 	`Account` A ON P.PositionID = A.PositionID
GROUP BY 	P.PositionID
HAVING		COUNT(A.PositionID)	=	(SELECT 	MIN(CountP)
									 FROM		(SELECT 	COUNT(P.PositionID) AS CountP
												FROM		Position P 
												INNER JOIN 	`Account` A ON P.PositionID = A.PositionID		
												GROUP BY	P.PositionID) AS MinCountP);

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT 		T.TypeName AS 'LOAI CAU HOI', Q.CreatorID AS 'ID NGUOI TAO', Q.Content AS 'CAU HOI', A.Content AS 'CAU TRA LOI', Q.CreateDate AS 'NGAY TAO'
FROM		Question Q 
INNER JOIN 	Answer A ON	Q.QuestionID = A.QuestionID
INNER JOIN	TypeQuestion T ON Q.TypeID = T.TypeID;

-- Question 13: lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT		T.TypeName AS 'LOAI CAU HOI', COUNT(Q.TypeID) AS 'SO LUONG'
FROM		Question Q 
INNER JOIN 	TypeQuestion T ON Q.TypeID = T.TypeID
GROUP BY	Q.TypeID;

-- Question 14: lấy ra group không có account nào
SELECT 		DISTINCT G.GroupName
FROM 		`Group` G
LEFT JOIN 	GroupAccount GA ON G.GroupID = GA.GroupID
WHERE 		GA.AccountID IS NULL;

-- Question 15: lấy ra group không có account nào
SELECT		*
FROM		`Group` 
WHERE		GroupID  NOT IN	(SELECT		GroupID
							 FROM		GroupAccount);
                    
-- Question 16: lấy ra question không có answer nào 
SELECT		*
FROM		Question
WHERE		QuestionID NOT IN (SELECT	QuestionID
							   From		Answer);
                        
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT 		A.FullName
FROM 		`Account` A
JOIN 		GroupAccount GA ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 1;

-- b) Lấy các account thuộc nhóm thứ 3
SELECT 		A.FullName
FROM 		`Account` A
JOIN 		GroupAccount GA ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 3;

-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT 		A.FullName
FROM 		`Account` A
JOIN 		GroupAccount GA ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 1
UNION
SELECT 		A.FullName
FROM 		`Account` A
JOIN 		GroupAccount GA ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 3;

-- Question 18: 
-- a) Lấy các group có lớn hơn bằng 3 thành viên 
SELECT 		G.GroupName, COUNT(1) AS so_luong
FROM 		`Group` G
JOIN 		GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY	GA.GroupID
HAVING 		so_luong >= 3;

-- b) Lấy các group có nhỏ hơn 7 thành viên 
SELECT 		G.GroupName, COUNT(1) AS so_luong
FROM 		`Group` G
JOIN 		GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY	GA.GroupID
HAVING 		so_luong <= 7;

-- c) Ghép 2 kết quả từ câu a) và câu b) 
SELECT 		G.GroupName, COUNT(1) AS so_luong
FROM 		`Group` G
JOIN 		GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY	GA.GroupID
HAVING 		so_luong >= 3
UNION
SELECT 		G.GroupName, COUNT(1) AS so_luong
FROM 		`Group` G
JOIN 		GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY	GA.GroupID
HAVING 		so_luong <= 7;