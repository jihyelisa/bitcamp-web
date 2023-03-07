create or replace view v_view1
as select employee_id, last_name, salary, department_id from employees
where department_id=90;

select * from v_view1;
delete from v_view1;

-- [문제1] 사원테이블에서 급여가 5000 이상 10000 이하인 사원들만 v_view2으로 뷰를 만드시오.
-- (사원ID, 사원이름, 급여, 부서ID)
CREATE OR REPLACE VIEW V_VIEW2
AS SELECT EMPLOYEE_ID, LAST_NAME, SALARY, DEPARTMENT_ID FROM EMPLOYEES
WHERE SALARY>=5000 AND SALARY<=10000;

SELECT * FROM V_VIEW2;
UPDATE V_VIEW2 SET SALARY=12000 WHERE EMPLOYEE_ID=103;
SELECT SALARY FROM EMPLOYEES WHERE EMPLOYEE_ID=103;
UPDATE EMPLOYEES SET SALARY=9000 WHERE EMPLOYEE_ID=103;

-- [문제2] 사원테이블과 부서테이블에서 사원번호, 사원명, 부서명을 v_view3로 뷰 테이블을 만드시오
-- 조건1) 부서가 10, 90인 사원만 표시하시오
-- 조건2) 타이틀은 사원번호, 사원명, 부서명으로 출력하시오
-- 조건3) 사원번호로 오름차순 정렬하시오
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;

CREATE OR REPLACE VIEW V_VIEW3
AS SELECT EMPLOYEE_ID AS 사원번호, LAST_NAME AS 사원명, DEPARTMENT_NAME AS 부서명
FROM EMPLOYEES
JOIN DEPARTMENTS USING(DEPARTMENT_ID)
WHERE DEPARTMENT_ID=10 OR DEPARTMENT_ID=90
ORDER BY 1;

SELECT * FROM V_VIEW3;

-- [문제3] 부서ID가 10, 90번 부서인 모든 사원들의 부서위치를 표시하시오
-- 조건1) v_view4로 뷰 테이블을 만드시오
-- 조건2) 타이틀을 사원번호, 사원명, 급여, 입사일, 부서명, 부서위치(city)로 표시하시오
-- 조건3) 사원번호 순으로 오름차순 정렬하시오
-- 조건4) 급여는 백 단위 절삭하고, 3자리 마다 콤마와 '원'을 표시하시오
-- 조건5) 입사일은  '2004년 10월 02일' 형식으로 표시하시오
SELECT * FROM TAB;
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM LOCATIONS;

CREATE OR REPLACE VIEW V_VIEW4
AS SELECT EMPLOYEE_ID AS 사원번호, LAST_NAME AS 사원명,
TO_CHAR(ROUND(SALARY, -2), '999,999')||'원' AS 급여,
TO_CHAR(HIRE_DATE, 'YYYY"년 "MM"월 "DD"일"') AS 입사일,
DEPARTMENT_NAME AS 부서명, CITY AS 부서위치
FROM EMPLOYEES
JOIN DEPARTMENTS USING(DEPARTMENT_ID)
JOIN LOCATIONS USING(LOCATION_ID)
WHERE DEPARTMENT_ID=10 OR DEPARTMENT_ID=90
ORDER BY 1;

SELECT * FROM V_VIEW4;

