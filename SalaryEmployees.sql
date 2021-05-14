
-- create database salary_employees
DROP DATABASE IF EXISTS SalaryEmployess;
CREATE DATABASE SalaryEmployees;
USE SalaryEmployees;

-- 1.create table department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department
(	
	Department_ID					SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`				ENUM('Admin', 'HR', 'IT', 'Delivery') NOT NULL UNIQUE KEY,
    `Description`		VARCHAR(100) NOT NULL UNIQUE KEY,
    Created_at			DATETIME	NOT NULL UNIQUE KEY,
    Updated_at			DATETIME	NOT NULL UNIQUE KEY
);

-- 2.create table users
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`
(
	User_ID				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Department_ID		SMALLINT UNSIGNED NOT NULL UNIQUE KEY,
    First_Name			VARCHAR(30) NOT NULL UNIQUE KEY,
    Last_Name			VARCHAR(30) NOT NULL UNIQUE KEY,
    Email				VARCHAR(100) NOT NULL UNIQUE KEY,
    Phone				VARCHAR(20) NOT NULL UNIQUE KEY,
    Avatar				VARCHAR(255) NOT NULL UNIQUE KEY,
    Employee_id			SMALLINT UNSIGNED NOT NULL UNIQUE KEY,
    Gender				ENUM('Male', 'Female') NOT NULL UNIQUE KEY,
    Age					TINYINT NOT NULL UNIQUE KEY,
    Created_at			DATETIME NOT NULL UNIQUE KEY,
    Updated_at			DATETIME NOT NULL UNIQUE KEY,
    CONSTRAINT	fk_user	FOREIGN KEY(Department_ID)	REFERENCES Department(Department_ID)
);

-- 3.create table user_department
DROP TABLE IF EXISTS User_Department;
CREATE TABLE User_Department
(
	User_Department_ID		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    User_Role_ID				SMALLINT UNSIGNED NOT NULL UNIQUE KEY,
    Start_date				DATE NOT NULL UNIQUE KEY,
    End_date				DATE NOT NULL UNIQUE KEY,
    Created_at				DATETIME NOT NULL UNIQUE KEY,
    Updated_at				DATETIME NOT NULL UNIQUE KEY,
    CONSTRAINT	fk_user_dep	FOREIGN KEY(User_rid)		REFERENCES Department(Department_ID),
    CONSTRAINT	fk_user_dep	FOREIGN KEY(User_Role_ID)	REFERENCES User_Role(User_Role_ID)
);

-- 4.create table Role
DROP TABLE IF EXISTS `Role`;
CREATE TABLE `Role`
(
	Role_ID			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`			VARCHAR(30) NOT NULL UNIQUE KEY,
    Created_at		DATETIME NOT NULL UNIQUE KEY,
    Updated_at		DATETIME NOT NULL UNIQUE KEY
);

-- 5.create table user_role
DROP TABLE IF EXISTS User_Role;
CREATE TABLE User_Role
(
	User_Role_ID				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    User_Department_ID		SMALLINT UNSIGNED NOT NULL UNIQUE KEY,
    Role_ID					SMALLINT UNSIGNED NOT NULL UNIQUE KEY,
    Start_date				DATE NOT NULL UNIQUE KEY,
    End_date				DATE NOT NULL UNIQUE KEY,
    Created_at				DATETIME NOT NULL UNIQUE KEY,
    Updated_at				DATETIME NOT NULL UNIQUE KEY,
    CONSTRAINT	fk_user_role	FOREIGN KEY(User_Department_ID)	REFERENCES User_Department(User_Department_ID),
	CONSTRAINT	fk_user_role	FOREIGN KEY(Role_ID)				REFERENCES `Role`(Role_ID)
);

-- 6.create table salary
DROP TABLE IF EXISTS Salary;
CREATE TABLE Salary
(
	Salary_ID				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    User_Role_ID				SMALLINT UNSIGNED NOT NULL UNIQUE KEY,
    Total					DOUBLE NOT NULL UNIQUE KEY,
    `Month`					VARCHAR(2) NOT NULL UNIQUE KEY,
    `Year`					VARCHAR(4) NOT NULL UNIQUE KEY,
    Created_at				DATETIME NOT NULL UNIQUE KEY,
    Updated_at				DATETIME NOT NULL UNIQUE KEY,
    CONSTRAINT	fk_salary	FOREIGN KEY(User_Role_ID)	REFERENCES User_Role(User_Role_ID)
);

-- 7.create table Salary_Detail_Type
DROP TABLE IF EXISTS Salary_Detail_Type;
CREATE TABLE Salary_Detail_Type
(
	Salary_Detail_Type_ID		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`						VARCHAR(30) NOT NULL UNIQUE KEY,
    Created_at					DATETIME NOT NULL UNIQUE KEY,
    Updated_at					DATETIME NOT NULL UNIQUE KEY
);

-- 8.create table salary_detail
DROP TABLE IF EXISTS Salary_Detail;
CREATE TABLE Salary_Detail
(
	Salary_Detail_ID		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Salary_ID				SMALLINT UNSIGNED NOT NULL UNIQUE KEY,
    Amount					DOUBLE NOT NULL UNIQUE KEY,
    Salary_Detail_Type_ID	SMALLINT UNSIGNED NOT NULL UNIQUE KEY,
    Operation				TINYINT(3) NOT NULL UNIQUE KEY,
    CONSTRAINT	fk_salary_detail	FOREIGN KEY(Salary_ID)				REFERENCES Salary(Salary_ID),
    CONSTRAINT	fk_salary_detail	FOREIGN KEY(Salary_Detail_Type_ID)	REFERENCES Salary_Detail_Type(Salary_Detail_Type_ID)
);