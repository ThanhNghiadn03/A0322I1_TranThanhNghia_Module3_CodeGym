create database product_management;
use product_management;

create table product(
	id int not null auto_increment,
    productCode char(4) not null,
    productName varchar(45),
    productPrice int,
    productAmount int,
    productDescription text,
    productStatus bit,
    primary key(id)
);

insert into product 
values(1,'SP01','Bánh mì',12000,3,'Bánh mỳ thượng hạng ngon hết sẩy',1),
(2,'SP02','Xà phòng',10000,1,'Xà phòng chất lượng cao',1),
(3,'SP03','Bình đựng nước',14000,10,'Bình đựng nước chất liệu bền',1),
(4,'SP04','Chảo',20000,6,'Chảo chống dính thiết kế đẹp mắt',1),
(5,'SP05','Sữa tươi',16000,4,'Sữa tươi đóng chai thơm ngon bổ dưỡng',1),
(6,'SP06','Hộp nhựa',12000,23,'Hộp nhựa đảm bảo vệ sinh và chất lượng',1),
(7,'SP07','Cafe',10000,0,'',0);

explain select * from product;

create unique index index_productCode on product(productCode);

create index index_composite_product on product(productName,productPrice);

explain select * from product where productName like 'B%';

select * from product where productName like 'B%';

create view product_View as 
select productCode, productName, productPrice, productStatus
from product;

create or replace view product_View as
select id,productName, productPrice, productStatus
from product;

drop view product_View;

delimiter //
create procedure all_of_product()
begin
	select * from product;
end //
delimiter ;

call all_of_product;

delimiter //
create procedure add_new_product(in productCode char(4),in productName varchar(45) , in productPrice int , in productAmount int , in productDescription text , in productStatus bit)
begin
	insert into product (productCode,productName,productPrice,productAmount,productDescription,productStatus)
    values(productCode,productName,productPrice,productAmount,productDescription,productStatus);
end //
delimiter ;

delimiter //
create procedure delete_product_byID(in id_need_delete int)
begin 
	delete from product 
    where id = id_need_delete;
end //
delimiter ;

delimiter //
create procedure update_amount_product_byID(in id_need_update int , in amount int)
begin
	update  product
    set productAmount = amount
    where id = id_need_update;
end //
delimiter ;

call update_amount_product_byID(7,4);
call delete_product_byID(7);