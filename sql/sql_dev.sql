--create database dev_SRD
CREATE DATABASE dev_SRD;
go

use dev_SRD;
go

--create table tbstudent
CREATE TABLE    tbstudent (id int primary key identity (1,1), firstname varchar(20),lastname varchar(20),gender varchar(7), email varchar(40), phone varchar(15), address varchar (200), despartment varchar(20), price varchar(100), class varchar(20), time varchar(15),startdate Date, status varchar(10), photo image);
go

--create table tbteacher
CREATE TABLE    tbteacher (id int primary key identity (1,1), firstname varchar(20),lastname varchar(20),gender varchar(7), email varchar(40), phone varchar(15), address varchar (200), despartment varchar(20),time varchar(15) , salary varchar(100), startdate Date, status varchar(10), photo image);
go

--create table tbdepartments
CREATE TABLE tbdepartments (id int primary key identity(1,1), department varchar(30),price varchar(100));
go

--create table tbclass
CREATE TABLE tbclass (id int primary key identity(1,1),department_name varchar(20) ,classname varchar(10),status varchar(20));
go

--create table tbstaff
CREATE TABLE tbstaff (id int primary key identity(1,1),staffname varchar(30),gender varchar(7),phone varchar(15),address varchar(200),status varchar(20),usernamelogin varchar(20),password varchar(100),photo image)
go

--insert
insert into tbstaff (staffname,gender,phone,address,status,usernamelogin,password,photo) values ('admin','M','09932843','Phnom penh','working','admin','admin','sdlkfj2039r0jsljf');
go