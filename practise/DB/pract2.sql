/*
Advanced Practice Questions:
Q21. List all departments along with the number of employees in each. If a department has no employees, show 0.
Q22. Find the employee(s) who are assigned the maximum number of projects.
Q23. Show employees who do not belong to any valid department (i.e., department_id is not found in Department table).
Q24. List the names of employees who are assigned to all the projects (hint: same count as total projects).
Q25. Show department name and average salary, but only for departments with average salary above 60000.
Q26. Find employees who are working exactly one project.
Q27. List all projects that are assigned to employees in the 'Engineering' department.
Q28. For each department, show the highest-paid employee’s name and salary.
Q29. Show names of employees whose project count is more than the average project count across all employees.
Q30. Find departments where all employees earn more than 50000.
*/
use employee;
select d.id, count(e.id) no_of_employees from department d left join employee e on e.department_id=d.id group by d.id;
select e.id, e.name, count(p.id) max_projects from employee e join project p on e.id=p.employee_id group by e.id, e.name order by max_projects desc limit 1;
select * from employee e where not exists (select 1 from department d where d.id= e.department_id);
select e.name from employee e left join project p on e.id=p.employee_id group by e.id, e.name having count(distinct p.id)= (select count(*) from project);
select d.name, avg(e.salary) average_salary from employee e left join department d on e.department_id=d.id group by department_id having average_salary > 60000;
select e.name from employee e left join project p on e.id=p.employee_id group by e.id, e.name having count(e.id)=1;
select p.name from project p join employee e on e.id=p.employee_id join department d on e.department_id=d.id where d.name='Engineering';
select d.name, e.name, e.salary from employee e join department d on e.department_id=d.id where (e.salary, e.department_id) in (select max(salary), department_id from employee group by department_id);
select e.name, count(p.id) from employee e join project p on e.id=p.employee_id group by e.id, e.name having count(p.id) > (select avg(pro) from (select count(p.id) pro from employee e2 left join project p2 on e2.id=p2.employee_id group by e2.id) as sub); 