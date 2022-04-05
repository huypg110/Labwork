show databases;
-- create database SchoolManagement;
use SchoolManagement;
show tables;

-- Create table about point list
CREATE TABLE Point_List (
    STT INT NOT NULL,
    PRIMARY KEY(STT),
    ID VARCHAR(10) NOT NULL,
    Math FLOAT,
    Biology FLOAT,
    Informatic FLOAT,
    Chemistry FLOAT,
    Physics FLOAT
);
-- To insert more data, we have:
INSERT INTO point_list VALUES(1,'BI11-110',7,7.9,8,5,9.5);
INSERT INTO point_list VALUES(2,'BI11-286',9,6.5,8,10,9);
INSERT INTO point_list VALUES(3,'BI11-228',4,7.5,7,8.5,9);
INSERT INTO point_list VALUES(4,'BI11-112',8,8.5,8,10,9.5);
INSERT INTO point_list VALUES(5,'BI11-095',7,6.5,9,5,5.5);
INSERT INTO point_list VALUES(6,'BI11-201',6,9,8,7,6.5);
-- If we want to delete 1 data, so we have:
DELETE FROM Point_list WHERE STT = 7;
-- If you want to update data in table, so we have:
UPDATE Point_list SET Math = 8 WHERE STT = 6;
-- Calculate average:
SELECT (Math + Biology + Informatic + Chemistry + Physics)/5 AS Gpa FROM Point_list ORDER BY Gpa DESC;
-- Order the data from the first to the last by:
SELECT *FROM point_list ORDER BY STT ASC;

SELECT *FROM point_list where STT = 1;
-- Combining student table and point list by:
SELECT student.ID, student.full_name, student.Major, student.Mail, point_list.Math, point_list.Biology, point_list.Informatic, point_list.Chemistry, point_list.physics 
FROM student INNER JOIN point_list WHERE point_list.STT = student.STT ;

-- Create table about attendance list
CREATE TABLE Attendance_List (
    STT INT NOT NULL,
    PRIMARY KEY(STT),
    ID VARCHAR(10) NOT NULL,
	Math VARCHAR(10) NOT NULL,
    Biology VARCHAR(10) NOT NULL,
    Informatic VARCHAR(10) NOT NULL,
    Chemistry VARCHAR(10) NOT NULL,
    Physics VARCHAR(10) NOT NULL,
    Note VARCHAR(50) NOT NULL
);
-- To insert more data, we have:
INSERT INTO Attendance_list VALUES(1,'BI11-110','6/6','6/6','6/6','3/6','5/6');
INSERT INTO Attendance_list VALUES(2,'BI11-286','6/6','6/6','6/6','3/6','5/6'); 
INSERT INTO Attendance_list VALUES(3,'BI11-228','6/6','6/6','6/6','3/6','5/6');
INSERT INTO Attendance_list VALUES(4,'BI11-112','6/6','6/6','6/6','3/6','5/6');
INSERT INTO Attendance_list VALUES(5,'BI11-095','6/6','6/6','6/6','3/6','5/6');
INSERT INTO Attendance_list VALUES(6,'BI11-201','6/6','6/6','6/6','3/6','5/6');
-- Each courses has total 6 sessions/30 days
-- If we want to delete 1 data, so we have:
DELETE FROM Attendance_list WHERE STT = 7;
-- If you want to update data in table, so we have:
 UPDATE Attendance_list SET ID = 'BI11-200' WHERE STT = 6;
-- Order the data from the first to the last by:
SELECT *FROM Attendance_list ORDER BY STT ASC;

SELECT *FROM Attendance_list WHERE STT = 1;
-- To check attendance for each courses per month, combining student table and attendance list by:
SELECT student.ID, student.full_name, student.Major, student.Mail, Attendance_list.Physics FROM Attendance_list INNER JOIN student WHERE attendance_list.STT = student.STT;

-- Create table about tuition list
CREATE TABLE Tuition_List (
    STT INT NOT NULL,
    PRIMARY KEY(STT),
    ID VARCHAR(10) NOT NULL,
    Tuition_fee INT NOT NULL,
    Submitted VARCHAR(10)
);
-- To insert more data, we have:
INSERT INTO tuition_list VALUES(1,'BI11-110',20000000,'Yes');
INSERT INTO tuition_list VALUES(2,'BI11-286',20000000,'Yes');
INSERT INTO tuition_list VALUES(3,'BI11-228',20000000,'Yes');
INSERT INTO tuition_list VALUES(4,'BI11-112',20000000,'Yes');
INSERT INTO tuition_list VALUES(5,'BI11-095',20000000,'Yes');
INSERT INTO tuition_list VALUES(6,'BI11-201',20000000,'Yes');

-- If we want to delete 1 data, so we have:
DELETE FROM Tuition_list WHERE STT = 7;
-- If you want to update data in table, so we have:
 UPDATE Tuition_list SET ID = 'BI11-200' WHERE STT = 6;
-- Order the data from the first to the last by:
SELECT *FROM Tuition_list ORDER BY STT ASC;

SELECT *FROM tuition_list WHERE STT = 1;
-- Combining student table and tuition list by:
SELECT student.ID, student.full_name, student.Major, student.Mail, tuition_list.tuition_fee, tuition_list.submitted FROM tuition_list 
INNER JOIN student WHERE tuition_list.STT = student.STT;

-- Create table about salary list
CREATE TABLE Salary_List (
    STT INT NOT NULL,
    PRIMARY KEY(STT),
    Total_shift INT,
    Rest INT
);
-- To insert more data, we have:
INSERT INTO salary_list VALUES(1,30,0);
INSERT INTO salary_list VALUES(2,27,3);
INSERT INTO salary_list VALUES(3,28,2);
INSERT INTO salary_list VALUES(4,30,0);
INSERT INTO salary_list VALUES(5,25,5);

-- Combining teacher table and salary list by:
SELECT teacher.full_name, teacher.subject, teacher.Mail, salary_list.total_shift, salary_list.rest FROM salary_list
INNER JOIN teacher WHERE salary_list.STT = teacher.STT;
-- Calculate salary:
SELECT total_shift * 500000 AS Salary FROM salary_list ORDER BY STT ASC;
-- If we want to delete 1 data, so we have:
DELETE FROM Salary_list WHERE STT = 6;
-- If you want to update data in table, so we have:
 UPDATE Salary_list SET Subject = 'Law' WHERE STT = 5;
-- Order the data from the first to the last by:
SELECT *FROM Salary_list ORDER BY STT ASC;

SELECT *FROM salary_list WHERE STT = 1;

-- Create table about student list
CREATE TABLE student (
    STT int NOT NULL,
    PRIMARY KEY(STT),
    ID varchar(10) NOT NULL,
    Full_name varchar(20) NOT NULL,
    Major varchar(20) NOT NULL,
    Mail varchar(40) NOT NULL
);
-- To insert more data, we have:
INSERT INTO student VALUES(1,'BI11-110','Phung Gia Huy','ICT','huypg.bi11-110@st.usth.edu.vn');
INSERT INTO student VALUES(2,'BI11-286','Nguyen Xuan Vinh','ICT','vinhxn.bi11-286@st.usth.edu.vn');
INSERT INTO student VALUES(3,'BI11-228','Hoang Minh Quan','MST','quanhm.bi11-228@st.usth.edu.vn');
INSERT INTO student VALUES(4,'BI11-112','Le Duc Huy','CHEM','huyld.bi11-112@st.usth.edu.vn');
INSERT INTO student VALUES(5,'BI11-095','Nguyen Viet Hoang','MET','hoangnv.bi11-095@st.usth.edu.vn');
INSERT INTO student VALUES(7,'BI11-201','Ngo Thi Hoang Nguyen','PMAB','nguyennth.bi11-201@st.usth.edu.vn');
-- If you want to update data in table, so we have:
UPDATE student SET STT = 2 WHERE full_name = 'Nguyen Xuan Vinh';
-- If we want to delete 1 data, so we have:
DELETE FROM student WHERE STT = 7;
-- Order the data from the first to the last by:
SELECT * FROM student;

SELECT * FROM student WHERE ID = 'BI11-286';

-- Create table about teacher list
CREATE TABLE teacher (
    STT int NOT NULL,
    PRIMARY KEY(STT),
    Full_name varchar(20) NOT NULL,
    Subject varchar(20) NOT NULL,
    Mail varchar(40)NOT NULL
);
-- To insert more data, we have:
INSERT INTO teacher VALUES(1,'Dr Le Thanh Huong','Biology','le-thanh-huong@usth.edu.vn');
INSERT INTO teacher VALUES(2,'Dr Phan Thanh Hien','Informatic','phan-thanh-hien@usth.edu.vn');
INSERT INTO teacher VALUES(3,'Dr Le Hai Khoi','Math','le-hai-khoi@usth.edu.vn');
INSERT INTO teacher VALUES(4,'Dr Tran Dinh Phong','Chemistry','tran-dinh-phong@usth.edu.vn');
INSERT INTO teacher VALUES(5,'Dr Nguyen Hong Nam','Physics','nguyen-hong-nam@usth.edu.vn');
-- If you want to update data in table, so we have:
UPDATE teacher SET subject = 'Philosophy' WHERE full_name = 'Dr Nguyen Hong Nam';
-- If we want to delete 1 data, so we have:
DELETE FROM teacher WHERE STT = 1;
-- Order the data from the first to the last by:
SELECT * FROM teacher;

SELECT * FROM teacher WHERE subject = 'Math';