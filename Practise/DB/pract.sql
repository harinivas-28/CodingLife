/*
Basic SELECT & WHERE
List all employees with salary greater than 50000.
Show names of employees whose name starts with 'A'.
Select the name and salary of employees in department ID 2.
Find the employee with the highest salary.
Return all unique department IDs from the Employee table.

ORDER BY, LIMIT
List the top 3 highest-paid employees.
Show all employees ordered by salary in ascending order.

Aggregate Functions
Find the total salary paid to all employees.
Find the average salary in each department.
Count how many employees are in each department.

GROUP BY and HAVING
List departments having more than 3 employees.
Show department ID and max salary in each department.

Subqueries
Find employees who earn more than the average salary.
Return the second highest salary (return NULL if not exists).
Show employees who are not assigned to any project.

JOINS (INNER, LEFT, RIGHT)
Show employee names along with their department names.
List all employees and their project names (if any).
Show departments with no employees.
List employees working on more than one project.
Display each employee's name along with the number of projects they are working on.
*/
-- SELECT & WHERE
select * from employee where salary > 50000;
select name from employee where name like 'A%';
select e.name, e.salary from employee e left join department d on e.department_id=d.id where d.id=2; 
select * from employee where salary = (select max(salary) from employee);
select distinct department_id from employee;
-- ORDER BY & LIMIT
select * from employee order by salary desc limit 3;
select * from employee order by salary asc;
-- AGGREGATE
select sum(salary) total_salary from employee;
select department_id, avg(salary) from employee group by department_id;
select department_id, count(department_id) from employee group by department_id;
-- GROUP BY AND HAVING
select department_id, count(department_id) from employee group by department_id having count(department_id)>3;
select department_id, max(salary) from employee group by department_id;
-- SUB QUERIES
select * from employee where salary > (select avg(salary) from employee);
select (select distinct salary from employee order by salary desc limit 1 offset 1) as second_highest_salary;
select * from employee where id not in (select distinct employee_id from project);
-- JOINS
select e.name, d.name from employee e left join department d on e.department_id=d.id;
select e.name, p.name from employee e left join project p on e.id=p.employee_id;
select d.id, d.name from department d left join employee e on e.department_id=d.id where e.id is null;
select e.id, e.name, count(p.id) as project_count from employee e left join project p on p.employee_id=e.id group by e.id, e.name;