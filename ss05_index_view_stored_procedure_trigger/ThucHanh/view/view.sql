create view view_customers as
select * from customers;

select * from view_customers;

create or replace view view_customers as
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers;