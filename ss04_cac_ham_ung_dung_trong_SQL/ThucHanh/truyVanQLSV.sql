use quanlysinhvien;

select *
from student;

select *
from mark;

select * 
from `subject`;

select address , count(studentID) as so_luong_SV 
from student
group by address;

select S.studentID , S.studentName ,
 avg(M.mark) as 'Điểm trung bình các môn'
from student S join mark M on S.studentID = M.studentID
group by S.studentID, S.studentName;

select S.studentID, S.studentName , 
avg(mark) as 'Điểm trung bình các môn'
from student S join mark M on S.studentID = M.studentID
group by S.studentID , S.studentName
having avg(mark) > 15;

select S.studentID , S.studentName , 
avg(M.mark)
from student S join mark M on S.studentID = M.studentID
group by S.studentID , S.studentName
having avg(mark) >= All(select avg(mark) from mark group by mark.studentID);
