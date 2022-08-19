use quanlysinhvien;
select *
from `subject`;

select *
from mark;

select *
from subject
where credit in(select max(credit) from `subject`);

select S.subID , S.subName , S.credit, M.mark 
from subject S join mark M on S.subID = M.subID
where M.mark in (select max(mark) from mark);

select S.studentID, S.studentName, S.address, S.phone,
avg(M.mark) as 'Điểm trung bình các môn'
from student S join mark M on S.studentID = M.studentID
group by S.studentID , S.studentName
order by avg(M.mark) desc;

