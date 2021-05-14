
-- CREATE DATABASE SHOPCAR
DROP DATABASE IF EXISTS ShopCar;
CREATE DATABASE ShopCar;
USE ShopCar;

-- create table customer
DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer
(
	CustomerID	SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`		VARCHAR(50) NOT NULL UNIQUE KEY,
    Phone		VARCHAR(15) NOT NULL UNIQUE KEY,
    Email		VARCHAR(50) NOT NULL UNIQUE KEY,
	Address		VARCHAR(100) NOT NULL UNIQUE KEY,
	Note		VARCHAR(100) NOT NULL UNIQUE KEY
);

-- create table car
DROP TABLE IF EXISTS CAR;
CREATE TABLE CAR
(
	CarID		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Maker	 	ENUM('HONDA', 'TOYOTA', 'NISSAN') NOT NULL UNIQUE KEY,
	Model		VARCHAR(50) NOT NULL UNIQUE KEY,
	`Year`		DATETIME NOT NULL UNIQUE KEY,
	Color		VARCHAR(30) NOT NULL UNIQUE KEY,
	Note		VARCHAR(100) NOT NULL UNIQUE KEY
);

-- create table CAR_ORDER
DROP TABLE IF EXISTS CAR_ORDER;
CREATE TABLE CAR_ORDER
(
	OrderID				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	CustomerID			SMALLINT UNSIGNED NOT NULL,
	CarID				SMALLINT UNSIGNED NOT NULL,
	Amount				INT DEFAULT 1,
	SalePrice			FLOAT NOT NULL,
	OrderDate			DATETIME NOT NULL,
	DeliveryDate		DATETIME NOT NULL,
	DeliveryAddress		VARCHAR(100) NOT NULL,
	Staus				INT DEFAULT 0,
	Note				VARCHAR(100) NOT NULL,
    CONSTRAINT	fk_cus	FOREIGN KEY(CustomerID)	REFERENCES Customer(CustomerID),
    CONSTRAINT 	fk_car	FOREIGN KEY(CarID)		REFERENCES Car(CarID)
);

-- INSERT DATABASE customer
INSERT INTO Customer (CustomerID, `Name`, Phone, Email, Address, Note) VALUES (1, 'Edward', '621-616-8391', 'egavan0@moonfruit.com', '133 Express Point', 'Care One (American Sales Company)');
INSERT INTO Customer (CustomerID, `Name`, Phone, Email, Address, Note) VALUES (2, 'Noach', '854-271-3691', 'ncheavin1@uol.com.br', '1747 Alpine Crossing', 'Dolgencorp, LLC');
INSERT INTO Customer (CustomerID, `Name`, Phone, Email, Address, Note) VALUES (3, 'Montgomery', '479-333-8156', 'mgrundon2@gnu.org', '96994 Schiller Circle', 'OCuSOFT, Inc.');
INSERT INTO Customer (CustomerID, `Name`, Phone, Email, Address, Note) VALUES (4, 'Cost', '293-190-2115', 'ctynemouth3@utexas.edu', '081 3rd Avenue', 'Sujanil Chemo Industries');
INSERT INTO Customer (CustomerID, `Name`, Phone, Email, Address, Note) VALUES (5, 'Faun', '103-716-4775', 'fredgrave4@google.nl', '206 Novick Point', 'WALGREEN CO.');

-- INSERT database Car
INSERT INTO Car (CarID, Maker, Model, `Year`, Color, Note) VALUES (1, 'HONDA', 'Ibrahim', '2021-5-3', 'Khaki', 'Brass');
INSERT INTO Car (CarID, Maker, Model, `Year`, Color, Note) VALUES (2, 'TOYOTA', 'Rhody',  '2021-4-4', 'Pink', 'Aluminum');
INSERT INTO Car (CarID, Maker, Model, `Year`, Color, Note) VALUES (3,  'NISSAN', 'Kitti',  '2020-8-4', 'Red', 'Plastic');


-- INSERT database order-car

INSERT INTO Car_Order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, Staus, Note) 
VALUES				  (1, 1, 1, 93, '3.46', '2021-04-28', '2020-07-31', '8 Clyde Gallagher Trail', '0', 'II');
INSERT INTO Car_Order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, Staus, Note) 
VALUES 				  (2, 2, 2, 73, '7.72', '2020-10-28', '2020-10-17', '579 Westridge Drive', '1', 'IV');
INSERT INTO Car_Order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, Staus, Note) 
VALUES 				  (3, 3, 4, 25, '5.47', '2020-07-18', '2020-06-10', '94 Meadow Vale Crossing', '2', 'Sr');
INSERT INTO Car_Order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, Staus, Note) 
VALUES 				  (4, 4, 4, 66, '7.72', '2020-12-03', '2020-12-21', '28 Nova Drive', '1', 'Jr');
INSERT INTO Car_Order (OrderID, CustomerID, CarID, Amount, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, Staus, Note) 
VALUES 				  (5, 5, 1, 51, '4.86', '2021-01-21', '2021-03-09', '9 Roxbury Circle', '0', 'Jr');


-- 2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã mua và sắp sếp tăng dần theo số lượng oto đã mua.
SELECT 			cus.`Name`, car_or.Amount
FROM 			Customer cus
INNER JOIN 		Car_Order car_or ON car_or.CustomerID = cus.CustomerID
HAVING			car_or.Amount
ORDER BY		car_or.Amount ASC;

-- 3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay
DROP FUNCTION IF EXISTS max_amount_car_of_brand;
DELIMITER $$ 
CREATE FUNCTION max_amount_car_of_brand() RETURNS INT
	BEGIN
			SELECT 			ca.Maker, MAX(car_or.Amount) AS 'amount_max_car'
			FROM			Car ca
			INNER JOIN		Car_Order car_or ON car_or.CarID = ca.CarID
			GROUP BY		car_or.OrderID
			HAVING			MAX(car_or.Amount);
	END$$
DELIMITER ;

-- 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa.
-- INPUT: SUB_STRING(DeliveryDate,'0','1'),YEAR(CURRENT - YEAR(DeliveryDate)) >= 1 -->delete
-- bang tam ..COUNT()

-- 5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn 
-- hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto 
-- và tên hãng sản xuất.
DROP PROCEDURE IF EXISTS sp_order_bill_of_customer;
DELIMITER $$
CREATE PROCEDURE sp_order_bill_of_customer(IN in_customerid SMALLINT)
BEGIN
SELECT cus.`Name` ,car_or.OrderID, car_or.Amount, ca.Maker FROM Car_Order car_or
INNER JOIN	Customer cus ON	cus.CustomerID = car_or.CustomerID
INNER JOIN	Car	ca		ON  ca.CarID = car_or.CarID
WHERE cus.CustomerID = in_customerid;
END$$
DELIMITER 
SET @in_customerid= '';
Call sp_order_bill_of_customer(1);
 SELECT @in_customerid;
 
 -- 6. Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ 
-- vào database (DeliveryDate < OrderDate + 15)
 DROP TRIGGER IF EXISTS Trg_dont_person_input_incorrect_in_data;
DELIMITER $$
CREATE TRIGGER Trg_dont_person_input_incorrect_in_data
 BEFORE INSERT ON Car_Order
 FOR EACH ROW
 BEGIN
		SELECT car_or.DeliveryDate, car_or.OrderDate FROM Car_Order car_or;
		IF (DeliveryDate < OrderDate + 15) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Cant input data';
 END IF;
 END$$
 DELIMITER ;
