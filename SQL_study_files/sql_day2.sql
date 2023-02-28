select * from employees;

select last_name, department_id, hire_date
from employees order by 2 desc;
select last_name, department_id, hire_date
from employees order by 2 desc, 3 asc;

-- [문제1] 사원들의 연봉을 구한 후 연봉 순으로 내림차순 정렬하시오
SELECT LAST_NAME AS "이 름", SALARY*12 AS "연 봉"
FROM employees ORDER BY 2 DESC;

select employee_id, last_name, department_id
from employees where lower(last_name)='higgins';
select mod(10, 3) from dual; -- 10을 3으로 나눈 나머지
select round(35765.357, 2) from dual;   -- 35765.36
select round(35765.357, -3) from dual;  -- 36000
select concat('Hello', '  World') from dual;

SELECT * FROM TEXT;
create table text (str1  char(20), str2  varchar2(20));
insert into text(str1, str2) values('angel', 'angel');
insert into text(str1, str2) values('사천사', '사천사');
select  lengthb(str1), lengthb(str2) from text;
select  length(str1), length(str2) from text;

-- [문제2] 사원의 레코드를 검색하시오 (concat, length)
SELECT EMPLOYEE_ID,
CONCAT(CONCAT(FIRST_NAME, ' '), LAST_NAME) AS NAME,
LENGTH(CONCAT(CONCAT(FIRST_NAME, ' '), LAST_NAME)) AS LENGTH 
FROM EMPLOYEES
WHERE SUBSTR(LAST_NAME, -1, 1)='n';

select sysdate from dual;
select to_char(sysdate, 'YYYY"년" MM"월" DD"일"') as 오늘날짜 from dual;
select to_char(sysdate, 'HH"시" MI"분" SS"초"') as 오늘날짜 from dual;
select to_char(sysdate, 'HH24"시" MI"분" SS"초"') as 오늘날짜 from dual;
select add_months(sysdate, 7) from dual;
select last_day(sysdate) from dual;
select last_day('2004-02-01') from dual;
select last_day('2005-02-11') from dual;

-- [문제3] 오늘부터 이번 달 말까지 총 남은 날수를 구하시오
select last_day(sysdate)-sysdate from dual;

-- [문제5] 커미션(commission_pct)을 받지 않은 사원의 인원수를 구하시오
SELECT COUNT(*)-COUNT(COMMISSION_PCT) FROM EMPLOYEES;

-- [문제6] 급여가 10000 미만이면 초급, 20000 미만이면 중급 그 외면 고급을 출력하시오
SELECT EMPLOYEE_ID AS 사원번호, LAST_NAME AS 사원명,
CASE WHEN SALARY<10000 THEN '초급'
     WHEN SALARY<20000 THEN '중급'
     ELSE '고급'
END "구분"
FROM EMPLOYEES
ORDER BY 3, 2;

-- [문제7] 사원테이블에서 사원번호, 이름, 급여, 커미션, 연봉을 출력하시오
SELECT EMPLOYEE_ID AS 사원번호, LAST_NAME AS 이름,
SALARY AS 급여, COMMISSION_PCT AS 커미션,
TO_CHAR(SALARY * 12 * (NVL(COMMISSION_PCT, 0)+1),'$9,999,999')
AS 연봉
FROM EMPLOYEES;

-- [문제8] 매니저가 없는 사원의 MANAGER_ID를 1000번으로 표시
SELECT EMPLOYEE_ID AS 사원번호, LAST_NAME AS 이름,
NVL(MANAGER_ID, 1000) AS 매니저ID FROM EMPLOYEES;
