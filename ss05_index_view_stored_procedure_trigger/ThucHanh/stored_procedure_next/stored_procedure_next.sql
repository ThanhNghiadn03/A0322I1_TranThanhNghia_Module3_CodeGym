use classicmodels;

delimiter //
create procedure getcusbyID(in id_custom int) 
begin
select * from customers where customerNumber = id_custom;
end //
delimiter ;

call getcusbyID(175);

delimiter //
create procedure getCustomerCountByID( in city_name varchar(45) , out total int)
begin 
	select count(1) into total
    from customers
    where city = city_name;
end //
delimiter ;

call getCustomerCountByID('San Rafael' , @total);

select @total;

delimiter //
create procedure setCounter(inout counter int , in inc int)
begin
	set counter = counter + inc;
end //
delimiter ;

set @counter = 1;

call setCounter(@counter , 1);

call setCounter(@counter , 6);

select @counter;
