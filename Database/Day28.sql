/*
---------------
Database : univ
---------------

employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    salary INT,
    hire_date DATE
);

projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100),
    department VARCHAR(50)
);

employee_projects (
    employee_id INT,
    project_id INT,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    FOREIGN KEY (project_id) REFERENCES projects(project_id)
);


Sample Output:
--------------
name    department      salary  dept_rank                                       
Diana   Engineering     71000   1                                               
Charlie Engineering     70000   2                                                   


*/
use univ;
-----------------------------------------
/*Write a query to assign a rank to each employee based on their salary within 
their department (higher salary → higher rank). If multiple employees have the 
same salary, they should share the same rank.*/
SELECT name, department, salary, rank() over (partition by department order by salary desc) as dept_rank from employees;
-----------------------------------------
/*Write a query to rank employees in each department based on their hire date, 
such that the earliest hired employee gets the highest rank (1).*/
select name, department, hire_date, rank() over (partition by department order by hire_date asc) as seniority_rank from employees;
-----------------------------------------
/*Write a query that assigns a unique row number to each employee in a department, 
ordered by their hire date.*/
select name, department, hire_date, row_number() over (partition by department order by hire_date asc) as row_num from employees;
-----------------------------------------
/*Write a query that numbers employees across the company based on descending 
salary (highest salary = row number 1).*/
select name, department, salary, row_number() over (order by salary desc) as salary_position from employees;
-----------------------------------------
/*Write a query that displays each employee's name, department, salary, and 
the average salary of employees in the same department.*/
select name, department, salary, avg(salary) over (partition by department) as avg_dept_salary from employees;
-----------------------------------------
/*Write a query to calculate the running total of employee salaries ordered by 
their hire date.*/
select name, hire_date, salary, sum(salary) over (order by hire_date asc) as running_salary_total from employees;
-----------------------------------------
/*Write a query to show each employee and the total number of employees in their 
department.*/
select name, department, count(department) over (partition by department) as dept_count from employees;
-----------------------------------------
/*Write a query to find the maximum salary among employees who were hired after 
January 1, 2020.*/
select name, hire_date, salary, max(salary) over() as max_recent_salary from employees  where hire_date>="2020-01-01";
-----------------------------------------

-----------------------------------------

