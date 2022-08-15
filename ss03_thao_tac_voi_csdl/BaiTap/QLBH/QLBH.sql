use quanlybanhang;

select *
from customer;

select *
from `order`;

select *
from product;

select * 
from orderdetail;

insert into customer
values(1,'Minh Quan',10);

insert into customer
values(2,'Ngoc Oanh',20);

insert into customer
values(3,'Hong Ha',50);

insert into `order`(orderID,customerID,oderdate)
values(1,1,20060321);

insert into `order`(orderID,customerID,oderdate)
values(2,2,20060323);

insert into `order`(orderID,customerID,oderdate)
values(3,1,20060316);

insert into product
values(1,'May Giat',3);

insert into product
values(2,'Tu Lanh',5);

insert into product
values(3,'Dieu Hoa',7);

insert into product
values(4,'Quat',1);

insert into product
values(5,'Bep Dien',2);

insert into orderdetail
values(1,1,3);

insert into orderdetail
values(1,3,7);

insert into orderdetail
values(1,4,2);

insert into orderdetail
values(2,1,1);

insert into orderdetail
values(3,1,8);

insert into orderdetail
values(2,5,4);

insert into orderdetail
values(2,3,3);

select orderID,oderDate,ordertotalprice
from `order`;

select C.customerID,C.customerName,O.oderDate,P.productName,
OD.odQTY
from customer C join `order` O on C.customerID = O.customerID
join orderdetail OD on O.orderID = OD.orderID 
join product P on OD.productID = P.productID;

select customerID , customerName
from customer
where customerID not in (select customerID from `order`);

select O.orderID , O.oderDate,OD.odQTY * P.productPrice 
as 'orderTotalPrice'
from `order` O join orderDetail OD on O.orderID = OD.orderID
join product P on OD.productID = P.productID;
