create database quanLyBanHang;
use quanLyBanHang;
create table customer(
	customerID int not null auto_increment,
    customerName varchar(50) not null,
    customerAge int ,
    check (customerAge >=18),
    primary key(customerID)
);

create table `Order`(
	orderID int not null auto_increment,
    customerID int not null,
    oderDate datetime,
    orderTotalPrice int default 0,
    primary key(orderID),
    foreign key(customerID) references customer(customerID)
); 

create table `Product`(
	productID int not null auto_increment,
    productName varchar(50) not null,
    productPrice int default 0,
    primary key(productID)
);

create table `OrderDetail`(
	orderID int not null,
    productID int not null,
    odQTY int default 0,
    primary key(orderID,productID),
    foreign key(orderID) references `Order`(orderID),
    foreign key(productID) references `Product`(productID)
);