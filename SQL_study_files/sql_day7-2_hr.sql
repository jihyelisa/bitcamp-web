create or replace view v_view7("부서ID", "부서평균")
as select nvl(department_id, 5000),
          round( avg(salary), -3)
   from employees
   group by department_id
   order by department_id asc;
select * from v_view7;   
----------------------------------------
select 부서ID, 부서평균
from (select nvl(department_id, 5000) "부서ID", 
             round( avg(salary), -3) "부서평균"
      from employees
      group by department_id
      order by department_id asc);
      
-- [문제5] 부서별 최대급여를 받는 사원의 이름, 부서명, 최대급여를 출력하시오
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
-- 내가 헤맨 흔적들...
SELECT LAST_NAME AS 이름, DEPARTMENT_NAME AS 부서명, MAX(SALARY) AS 최대급여
FROM EMPLOYEES
JOIN DEPARTMENTS USING(DEPARTMENT_ID)
GROUP BY DEPARTMENT_NAME, LAST_NAME;
SELECT 이름, 부서명, 최대급여
FROM (SELECT LAST_NAME AS 이름,
             DEPARTMENT_NAME AS 부서명,
             MAX(SALARY) AS 최대급여
      FROM EMPLOYEES
      JOIN DEPARTMENTS USING(DEPARTMENT_ID)
      GROUP BY DEPARTMENT_NAME, LAST_NAME
      HAVING );

SELECT e.LAST_NAME AS 이름, d.DEPARTMENT_NAME AS 부서명, e.SALARY AS 최대급여
FROM EMPLOYEES e
JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE e.SALARY = (
    SELECT MAX(SALARY)
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID = e.DEPARTMENT_ID
);
SELECT LAST_NAME AS 이름, DEPARTMENT_NAME AS 부서명, SALARY AS 최대급여
FROM EMPLOYEES
JOIN DEPARTMENTS USING(DEPARTMENT_ID)
WHERE SALARY = (
    SELECT MAX(SALARY)
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID = DEPARTMENT_ID
);

-- 답
SELECT 이름, 부서명, 최대급여
FROM(SELECT LAST_NAME AS 이름, DEPARTMENT_NAME AS 부서명, SALARY AS 최대급여
     FROM EMPLOYEES
     JOIN DEPARTMENTS USING(DEPARTMENT_ID)
     WHERE (DEPARTMENT_ID, SALARY)
     IN (SELECT DEPARTMENT_ID, MAX(SALARY) AS SALARY
         FROM EMPLOYEES
         GROUP BY DEPARTMENT_ID));

-- [문제6] 사원들의 연봉을 구한 후 최하위 연봉자 5명을 추출하시오
-- 조건1) 연봉 = 급여*12+(급여*12*커미션)
-- 조건2) 타이틀은 사원이름, 부서명, 연봉
-- 조건3) 연봉은 ￦25,000 형식으로 하시오

-- 사원들의 연봉
SELECT LAST_NAME,
       DEPARTMENT_NAME,
       SALARY*12+(SALARY*12*NVL(COMMISSION_PCT, 0)) AS SALARY
FROM EMPLOYEES
JOIN DEPARTMENTS USING(DEPARTMENT_ID)
ORDER BY 3;
-- 최하위 5명
SELECT LAST_NAME AS 사원이름,
       DEPARTMENT_NAME AS 부서명,
       TO_CHAR(SALARY, 'L999,999') AS 연봉
FROM (SELECT LAST_NAME,
             DEPARTMENT_NAME,
             SALARY*12+(SALARY*12*NVL(COMMISSION_PCT, 0)) AS SALARY
      FROM EMPLOYEES
      JOIN DEPARTMENTS USING(DEPARTMENT_ID)
      ORDER BY 3)
WHERE ROWNUM<=5;



grant all on employees to c##java;