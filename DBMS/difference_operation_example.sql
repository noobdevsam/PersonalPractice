-- difference operation(by: not-in)

-- find students who are not enrolled in any course
select s.ID from university.Student as s
	where s.ID not in 
		(select tks.ID from university.Takes as tks);
        
-- list instructors who are not advising any students
select ins.ID from university.Instructor as ins
	where ins.ID not in
		(select avr.i_ID from university.Advisor as avr);