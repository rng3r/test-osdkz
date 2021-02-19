select * from Employee own
                  left join Employee chief
                            on own.chief_id = chief.id
where own.salary > chief.salary;
#


select * from Employee e,
              (select department_id, max(salary) as maxSalary from Employee
               group by department_id) as t
where e.department_id = t.department_id and e.salary = t.salary;

#

select deprtment_id from Employee
group by deprtment_id
having count(*) <= 3;

#


select id from Department


                   (select department_id, sum(salary) as salary from Employee group by department_id) as salaryDepartments
;