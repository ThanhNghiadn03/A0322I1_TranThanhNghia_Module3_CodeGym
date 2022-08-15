select *
from student;

select *
from class;

select * 
from subject;

select *
from mark;

select *
from student
where studentName like 'h%' ;

select *
from class
where month(startDate) = 12;

select *
from subject
where credit between 3 and 5;

set SQL_SAFE_UPDATES = 0;

update student
set classID = 2
where studentName = 'Hung';

set SQL_SAFE_UPDATES = 1;

select S.studentName,Su.subName,M.mark
from subject Su join mark M 
on Su.subID = M.subID join student S
on M.studentID = S.studentID
order by M.mark desc , S.studentName asc;