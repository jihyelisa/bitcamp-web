SELECT * FROM EMPLOYEES;
select employee_id, last_name, salary from employees;
select employee_id as 사원번호, last_name AS "이 름", SALARY AS "급 여" FROM employees;
SELECT EMPLOYEE_ID AS 사원번호, LAST_NAME AS "이 름", SALARY*12 AS "연 봉" FROM EMPLOYEES;

-- ||이 문자열 결합해줌
SELECT FIRST_NAME||' '||LAST_NAME AS "이 름" FROM EMPLOYEES;

-- 4_1일차.HWP 파일
-- [문제1]
SELECT EMPLOYEE_ID AS 사원번호,
FIRST_NAME || ' ' || LAST_NAME AS "이 름",
SALARY*12||'달러' AS "연 봉" FROM employees;
-- [문제2]
SELECT LAST_NAME || ' is a ' || JOB_ID AS "Employee Detail" FROM EMPLOYEES;

-- 중복 없이 출력
select department_id from employees;
select distinct department_id from employees;

-- 10, 90번 부서 사원 정보
select last_name, hire_date, department_id from employees
where department_id=10  or  department_id=90;

-- [문제3]
SELECT FIRST_NAME||' '||LAST_NAME AS 사원명,
'$'||SALARY AS "월 급", DEPARTMENT_ID AS 부서코드 FROM EMPLOYEES
WHERE (SALARY <= 2500 OR SALARY >= 3000) AND DEPARTMENT_ID=90;
-- [문제4]
SELECT LAST_NAME AS 이름, JOB_ID AS 업무ID, SALARY||'원' AS "급 여"
FROM EMPLOYEES
WHERE JOB_ID IN('SA_REP', 'AD_PRES') AND SALARY > 10000;