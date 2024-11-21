-- Find the names of students along with the courses they are enrolled in
select s.name, c.title from university.Student as s
	join university.Takes as t
		on s.ID = t.ID
	join university.Course as c
		on t.course_id = c.course_id;
        
-- Get a list of instructors and the courses they are teaching
select ins.name, c.title from university.Instructor as ins
	join university.Teaches as tch
		on ins.ID = tch.ID
	join university.Course as c
		on  tch.course_id = c.course_id;