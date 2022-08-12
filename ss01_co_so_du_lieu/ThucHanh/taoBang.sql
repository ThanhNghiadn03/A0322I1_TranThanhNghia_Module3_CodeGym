create schema `student_management`;

create table `student`(
id int not null primary key,
`name` varchar(50) null,
age int null,
country varchar(50) null
);
