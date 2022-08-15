create database quanLyBanHang;
use quanLyBanHang;
CREATE TABLE customer (
    customerID INT NOT NULL AUTO_INCREMENT,
    customerName VARCHAR(50) NOT NULL,
    customerAge INT,
    PRIMARY KEY (customerID)
);

CREATE TABLE `Order` (
    orderID INT NOT NULL AUTO_INCREMENT,
    customerID INT NOT NULL,
    oderDate DATETIME,
    orderTotalPrice INT,
    PRIMARY KEY (orderID),
    FOREIGN KEY (customerID)
	REFERENCES customer (customerID)
); 

create table `Product`(
	productID int not null auto_increment,
    productName varchar(50) not null,
    productPrice int default 0,
    primary key(productID)
);

CREATE TABLE `OrderDetail` (
    orderID INT NOT NULL,
    productID INT NOT NULL,
    odQTY INT DEFAULT 0,
    PRIMARY KEY (orderID , productID),
    FOREIGN KEY (orderID)
        REFERENCES `Order` (orderID),
    FOREIGN KEY (productID)
        REFERENCES `Product` (productID)
);