create database quanLySinhVien;
use quanLySinhVien;
create table Class(
	classID int not null auto_increment,
    className varchar(60) not null,
    startDate datetime not null,
    `status` bit,
    primary key(classID)
);

create table Student (
	studentID int not null auto_increment,
    studentName varchar(30) not null,
    address varchar(50),
    phone varchar(20),
    `status` bit,
    classID int not null,
    primary key(studentID),
    foreign key(classID) references Class(classID)
);

create table `Subject`(
	subID int not null auto_increment,
    subName varchar(30) not null,
    credit tinyint not null default 1,
    check (credit >=1),
    `status` bit default 1,
    primary key(subID)
);

CREATE TABLE Mark (
    markID INT NOT NULL AUTO_INCREMENT,
    subID INT NOT NULL UNIQUE,
    studentID INT NOT NULL UNIQUE,
    mark FLOAT DEFAULT 0,
    CHECK (mark BETWEEN 0 AND 100),
    examTimes TINYINT DEFAULT 1,
    PRIMARY KEY (markID),
    FOREIGN KEY (subID)
        REFERENCES `Subject` (subID),
    FOREIGN KEY (studentID)
        REFERENCES Student (studentID)
);