-- 테이블 구조만 복사
create table employees_role as select * from employees where 1=0;

insert into employees_role values(101, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);
insert into employees_role values(101, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);
insert into employees_role values(101, 'Nee', 'Ko', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);
insert into employees_role values(200, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);
insert into employees_role values(200, 'Nee', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);
insert into employees_role values(300, 'GilDong', 'Hong', 'NKOCHHAR', '010-123-4567', '2009-03-01', 'IT_PROG', 23000.00, NULL, 100, 90);

commit;

select employee_id, last_name from employees
union
select employee_id, last_name from employees_role;

select employee_id, last_name from employees
union all
select employee_id, last_name from employees_role;

select salary  from employees where department_id=10
union all
select salary  from employees where department_id=30 order by 1;

-- [문제1] employees와 employees_role에서 레코드의 사원명단을 구하시오
-- 조건1) 사원이름, 업무ID, 부서ID을 표시하시오
-- 조건2) employees 에서는 부서ID가 10인 사원만 검색
--       employees_role에서는 업무ID가 IT_PROG만 검색
-- 조건3) 중복되는 레코드는 제거
select * from employees;
select * from employees_role;
SELECT LAST_NAME, JOB_ID, DEPARTMENT_ID FROM EMPLOYEES
WHERE DEPARTMENT_ID=10
UNION
SELECT LAST_NAME, JOB_ID, DEPARTMENT_ID FROM EMPLOYEES_ROLE
WHERE JOB_ID='IT_PROG';

