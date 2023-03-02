-- 2일차 파일
-- [문제4] 2005년 이전에 고용된 사원을 찾으시오
-- 내 코드
SELECT LAST_NAME,
TO_CHAR(HIRE_DATE, 'DD"-"fmMM"월 -"RRRR') AS HIRE_DATE
FROM EMPLOYEES WHERE HIRE_DATE < TO_DATE('2005', 'RRRR');
-- 선생님 코드
SELECT LAST_NAME, 
       TO_CHAR(HIRE_DATE, 'dd-mon-yyyy')
FROM EMPLOYEES WHERE HIRE_DATE < '2005-01-01';

-- 선생님이 주신 번외문제
SELECT SUM(PRICE) AS 판매액 FROM SELLINGS
WHERE CREATED_AT >= '2016-11-01' AND CREATED_AT < '2016-12-01';

SELECT * FROM EMPLOYEES;



-- 3일차 파일
-- [문제1] job_id별 급여의 합계를 구해서 job_id, 급여합계를 출력하시오
SELECT JOB_ID, SUM(SALARY) AS 급여합계
FROM EMPLOYEES GROUP BY JOB_ID;

-- 비효율적인 HAVING절
select department_id, max(salary) as max_salary
from employees group by department_id
having department_id in(10, 20) order by department_id;
-- 좀더 효율적
select department_id, max(salary) as max_salary
from employees where department_id in(10, 20)
group by department_id order by department_id;

-- join
select employee_id, department_id, department_name
from employees join departments using(department_id);
-- [문제2] 부서테이블(DEPARTMENTS d)과 위치테이블(LOCATIONS l)을 연결하여
-- 부서가 위치한 도시를 알아내시오
SELECT * FROM DEPARTMENTS;
SELECT * FROM LOCATIONS;
SELECT DEPARTMENT_ID, CITY FROM DEPARTMENTS D, LOCATIONS L
WHERE D.LOCATION_ID = L.LOCATION_ID;