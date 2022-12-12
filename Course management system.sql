create database CourseManagementSystem
use CourseManagementSystem

create table mainInfo
(
UserId int  IDENTITY(1,1),
SSN varchar(14) NOT NULL UNIQUE,
UserName varchar(100) NOT NULL UNIQUE,
Password varchar(100) NOT NULL,
role varchar(100) NOT NULL,
constraint PK_ID PRIMARY KEY(UserId)
);

create table instructor
(
instID int UNIQUE,
instFName varchar(100) NOT NULL,
instLName varchar(100) NOT NULL,
SSN varchar(14) NOT NULL UNIQUE,
DOB Date NOT NULL,
Phone varchar(15) UNIQUE NOT NULL,
Email nvarchar(100) UNIQUE NOT NULL,
Address nvarchar(100) NOT NULL,
Nationality varchar(100) NOT NULL,
CourseID varchar(100) NOT NULL,
  -- NOT WORKING -- CONSTRAINT checkRoleStudent CHECK(exists(select userID from  mainInfo where role =  'student'))

);

create table student
(
studID int PRIMARY KEY,
studFirstName varchar(100) NOT NULL,
studLastName varchar(100) NOT NULL,
SSN varchar(14) NOT NULL UNIQUE,
DOB Date NOT NULL,
Phone varchar(15) UNIQUE NOT NULL,
Email nvarchar(100) UNIQUE  NOT NULL,
Address nvarchar(100) NOT NULL,
Nationality varchar(100) NOT NULL
);

create table courses
(
courseID varchar(100) NOT NULL,
courseName varchar(100) NOT NULL UNIQUE,
parentCourse varchar(100),
startDate Date NOT NULL,
endDate Date NOT NULL,
daysOfCourse int NOT NULL,
price int NOT NULL,
room int NOT NULL,
branch varchar(100) NOT NULL,
instID int NOT NULL,
constraint PK_idd PRIMARY KEY(courseID)
);

create table regesteredCourses
(
studID int FOREIGN KEY REFERENCES student(studID),

);

create table grades
(
studID int FOREIGN KEY REFERENCES student(studID),

);

create table surveyMainTable
(
surveyID int IDENTITY(1,1) PRIMARY KEY,
studID int FOREIGN KEY REFERENCES student(studID),
courseID varchar(100) FOREIGN KEY REFERENCES courses(courseID),
);

create table surveyResponses
(
surveyID int FOREIGN KEY REFERENCES surveyMainTable(surveyID),
resp1 varchar(200) NOT NULL,
resp2 varchar(200) NOT NULL,
resp3 varchar(200) NOT NULL,
resp4 varchar(200) NOT NULL,
resp5 varchar(200) NOT NULL,
);

insert into mainInfo values ('2020212223', 'Ahmed Hatem', 'admin', 'admin')
insert into mainInfo values ('2020212224', 'Omnia Sayed', 'admin', 'admin')
insert into mainInfo values ('2020212225', 'Hala Tag', 'admin', 'admin')
insert into mainInfo values ('2020212226', 'Rewaa Ragab', 'admin', 'admin')
insert into mainInfo values ('2020212227', 'Sara Alaa', 'admin', 'admin')

insert into courses values ('mth1', 'math1', 'null', '2020-10-18', '2021-1-17', '30', '500', '1', 'cairo', '0')
insert into courses values ('cs111', 'intro to CS', 'null', '2020-10-18', '2021-1-17', '30', '1000', '1', 'cairo', '0')

select * from mainInfo
select * from student
select * from instructor
select * from courses
select * from regesteredCourses
SELECT * FROM grades
SELECT * FROM surveyMainTable
SELECT * FROM surveyResponses
SELECT INFORMATION_SCHEMA.COLUMNS.COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME LIKE 'student'
UPDATE courses SET instID = '3' WHERE courseID = 'CS111'