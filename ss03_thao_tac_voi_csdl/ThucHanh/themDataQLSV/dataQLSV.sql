insert into class 
values(1,'A1',20081220,1);

insert into class(`classname`, `startdate` , `status`)
values('A2',20081222,1);

insert into class(`classname`,`startdate`,`status`)
values('B3',now(),0);

select *
from class;

insert into student
values(1,'Hung','Ha Noi', '0912113113',1,1);

select *
from student;

insert into student
values(2,'Hoa','Hai Phong','', 1,1);

insert into student
values(3,'Manh','HCM','0123123123',0,2);

insert into `subject`
values(1,'CF',5,1);

insert into `subject`
values(2,'C', 6,1);

insert into `subject`
values(3,'HDJ',5,1);

insert into `subject`
values(4,'RDBMS',10,1);

drop table mark;

insert into mark
values(1,1,1,8,1);

insert into mark
values(2,1,2,10,2);

insert into mark
values(3,2,1,12,1);

delete from student
where studentID=3;

select *
from mark;