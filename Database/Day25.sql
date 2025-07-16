/*
---------------
Database Schema
---------------

Students (
    student_id INT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100),
    enrollment_year INT
);

Courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100),
    instructor VARCHAR(50)
);

Enrollments (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    grade CHAR(1),
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);


Sample Output:
--------------
student_id  name    email               enrollment_year                                 
1           Alice   alice@example.com   2023                                    
2           Bob     bob@example.com     2022 


*/
------------- 1
-- Write a query to display all records from the Students table.
use univ;
SELECT * from Students;

----------------- 2
-- Write a query to display all records from the Students table, ordered by name in ascending order.

SELECT * from Students ORDER BY name;

----------------- 3
-- Write a query to display all records from the Students table where the enrollment_year is 2023.

SELECT * from Students where enrollment_year = 2023;

----------------- 4
-- Write a query to display all records from the Students table where the email ends with "kmec.com".

SELECT * from Students where email LIKE "%kmec.com";

-------------------- 5
-- Write a query to display the student_id, name, email, and enrollment_year of students enrolled in the course with course_id 101.

SELECT s.student_id, s.name, s.email, s.enrollment_year from Students s
JOIN Enrollments e ON s.student_id = e.student_id
JOIN Courses c ON c.course_id = e.course_id
where c.course_id=101;

--------------------- 6
-- Write a query to display the course_name and the total number of students enrolled in each course.

select c.course_name, count(e.course_id) as total_students from Courses c 
join Enrollments e on e.course_id = c.course_id
group by c.course_name;

---------------------- 7
-- Write a query to display the name of students and the number of courses they are enrolled in.

SELECT s.name, count(e.student_id) as courses_enrolled from Students s
join Enrollments e on s.student_id = e.student_id
group by s.name;

-------------------- 8
-- Write a query to display the enrollment_year and the total number of students enrolled in that year.

SELECT s.enrollment_year, count(s.enrollment_year) as student_count from Students s group by s.enrollment_year;

--------------------- 9
-- Write a query to display the student_id and the number of courses they are enrolled in, but only for students enrolled in more than 2 courses.

SELECT s.student_id, count(e.student_id) as course_count from Students s
join Enrollments e on s.student_id = e.student_id
group by s.student_id having course_count>2;

----------------------- 10
-- Write a query to display the course_id and the number of students enrolled in that course, but only for courses with more than 10 students.

SELECT c.course_id, count(e.course_id) as student_count from Courses c
join Enrollments e on c.course_id = e.course_id
group by c.course_id having student_count>=10;

------------------------



