use fs;
-- select * from transactions;
-- ------------------------------------------------------------------- 1
select customer_id, date(transaction_date) as transaction_day, 
sum(
	case 
		when transaction_type='deposit' then amount
        when transaction_type='withdrawal' then -amount
        else 0
	end
) as net_amount
from transactions group by customer_id, date(transaction_date) 
order by customer_id, transaction_day;
-- ------------------------------------------------------------------- 2
select customer_id, 
DATE_FORMAT(transaction_date, '%Y-%m') as month_label,
count(*) as high_value_deposit_count
from transactions
where transaction_type='deposit' and amount>5000
group by customer_id, month_label
having count(*)>=3;
-- ------------------------------------------------------------------- 3
select customer_id, transaction_date, amount, 
sum(amount) over (
	partition by customer_id
    order by transaction_date
    rows between unbounded preceding and current row
) running_total
from transactions
where transaction_type='deposit'
order by customer_id, transaction_date;
-- ------------------------------------------------------------------- 4
select student_id, student_name from student_marks sm
where marks > (select avg(marks) from student_marks where subject=sm.subject)
order by subject, marks desc;
-- ------------------------------------------------------------------- 5
select student_id, student_name, subject, marks, 
rank() over (
	partition by subject
    order by marks desc
) as subject_rank
from student_marks
order by marks desc, subject_rank asc;
-- ------------------------------------------------------------------- 6
select student_id, student_name from student_marks
group by student_id, student_name having min(marks)>=85;
-- ------------------------------------------------------------------- 7 CTE
with total_students as (
	select class, section, name, roll_no, sum(marks) as total_marks,
rank() over (
	partition by class, section 
    order by sum(marks) desc 
) as rank_in_class
 from students 
group by class, section, name, roll_no
) select * from total_students where rank_in_class=1;
-- ------------------------------------------------------------------- 8
select class,subject, avg(marks) average_marks from students group by class,subject order by average_marks;