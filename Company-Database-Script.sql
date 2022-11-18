CREATE DATABASE Company;

USE Company;

CREATE TABLE Employees (
	ID int PRIMARY KEY,
    Full_Name char(50) NOT NULL,
    Phone_Number char(11) NOT NULL
);

insert into Employees(ID,Full_Name,Phone_Number) values 
(1,'Mostafa Mahmoud','01012345678');