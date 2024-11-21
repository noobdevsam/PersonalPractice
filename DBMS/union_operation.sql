-- Union operation

-- find all department names mentioned in either the Instructor or Course table 
select dept_name from university.Instructor
	union
		select dept_name from university.Course;

-- get a combined list of all Instructor_id and Student_id
select ins.ID as ID from university.Instructor as ins
	union
		select s.ID as ID from university.Student as s;