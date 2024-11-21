-- intersection operation (intersect)

-- find students who are also instructor
select s.ID as ID from university.Student as s
	intersect
		select i.ID as ID from university.Instructor as i;
        
-- list departments that have both courses and instructors
select c.dept_name from university.Course as c
	intersect
		select i.dept_name from university.Instructor as i;