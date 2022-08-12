create database QuanLyDiemThi;
use quanLyDiemThi;
create table `HocSinh`(
	maHS varchar(20) primary key,
    tenHS varchar(50),
    ngaySinh date,
    lop char(7),
    GT varchar(20)
);

create table `GiaoVien`(
	maGV varchar(20) primary key,
    tenGV varchar(20),
    SDT varchar(20)
);

create table `MonHoc`(
	maMH varchar(20) primary key,
    tenMH varchar(20),
    maGV varchar(20) ,
    foreign key(maGV) references GiaoVien(maGV)
);

create table `BangDiem`(
	maHS varchar(20),
    maMH varchar(20),
    diemThi int,
    ngayThi datetime,
    foreign key(mahs) references HocSinh(maHS),
    foreign key(mamh) references MonHoc(maMH),
    primary key(maHS,maMH)
);


