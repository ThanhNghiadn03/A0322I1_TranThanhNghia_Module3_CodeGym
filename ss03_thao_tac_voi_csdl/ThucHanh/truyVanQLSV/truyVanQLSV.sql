select * from student;

select * from student where status<>0;

select * from `subject` where credit<10;

select S.studentID, S.studentName, C.className
from student S join class C on S.studentID = C.classID
where C.className = 'A1';

select S.studentID , S.studentName , M.mark , Su.subName
from student S join mark M on S.studentID = M.studentID join subject Su on M.subID = Su.subID
where Su.subName = 'CF';