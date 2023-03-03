-- [문제1] 최저급여를 받는 사원들의 이름과 급여를 구하시오
SELECT * FROM EMPLOYEES;
-- 내가 쓴 코드
SELECT LAST_NAME, SALARY FROM EMPLOYEES
WHERE SALARY <ANY(SELECT SALARY FROM EMPLOYEES);
-- 답
SELECT LAST_NAME, SALARY FROM EMPLOYEES
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEES);

-- [문제2] 부서별 급여 합계 중 최대급여를 받는 부서의 부서명과 급여합계를 구하시오
SELECT * FROM TAB;
SELECT * FROM DEPARTMENTS;
SELECT * FROM EMPLOYEES;
-- 내가 쓴 코드
SELECT DEPARTMENT_NAME, SUM(SALARY) AS "부서별 급여 합계"
FROM EMPLOYEES
JOIN DEPARTMENTS USING(DEPARTMENT_ID)
WHERE SUM(SALARY) = (SELECT MAX(SUM(SALARY)) FROM EMPLOYEES GROUP BY DEPARTMENT_ID);
-- 답
SELECT DEPARTMENT_NAME AS 부서명, SUM(SALARY) AS "부서별 급여 합계"
FROM EMPLOYEES
JOIN DEPARTMENTS USING(DEPARTMENT_ID)
GROUP BY DEPARTMENT_NAME
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) FROM EMPLOYEES GROUP BY DEPARTMENT_ID);

-- [문제3] 'IT_PROG' 직급 중 가장 많이 받는 사원의 급여보다 더 많은 급여를 받는 'FI_ACCOUNT' 또는 'SA_REP' 직급 직원들을 조회하시오
-- 조건1) 급여 순으로 내림차순 정렬하시오
-- 조건2) 급여는 세 자리마다 콤마(,) 찍고 화폐단위 '원’을 붙이시오 (1달러=1302원)
-- 조건3) 타이틀은 사원명, 업무ID, 급여로 표시하시오
SELECT LAST_NAME AS 사원명, JOB_ID AS 업무ID,
       TO_CHAR(SALARY*1302, '999,999,999')||'원' AS 급여
FROM EMPLOYEES
WHERE JOB_ID IN('FI_ACCOUNT', 'SA_REP')
AND SALARY>ANY(SELECT MAX(SALARY) FROM EMPLOYEES WHERE JOB_ID='IT_PROG')
ORDER BY 3 DESC;

-- [문제4] 자기 업무id(job_id)의 평균급여를 받는 직원들을 조회하시오
-- 조건1) 평균급여는 100단위 이하 절삭하고 급여는 세자리마다 콤마, $표시
-- 조건2) 사원이름(last_name), 업무id(job_id), 직무(job_title), 급여(salary) 로 표시하시오
-- 조건3) 급여순으로 오름차순 정렬하시오
SELECT * FROM EMPLOYEES;
SELECT * FROM JOBS;

-- 왜 USING을 쓰면 오류 날까?
SELECT LAST_NAME AS 사원이름, EMPLOYEES.JOB_ID AS 업무ID,
       JOB_TITLE AS 직무, SALARY AS 급여
FROM EMPLOYEES
JOIN JOBS USING(JOB_ID)
WHERE SALARY=(SELECT AVG(SALARY) FROM EMPLOYEES WHERE JOB_ID=EMPLOYEES.JOB_ID)
ORDER BY 4;
-- ChatGPT가 알려준 방법
SELECT LAST_NAME AS 사원이름, EMPLOYEES.JOB_ID AS 업무ID,
       JOB_TITLE AS 직무, SALARY AS 급여
FROM EMPLOYEES
JOIN JOBS ON EMPLOYEES.JOB_ID = JOBS.JOB_ID
WHERE SALARY=(SELECT AVG(SALARY) FROM EMPLOYEES WHERE JOB_ID=JOBS.JOB_ID)
ORDER BY 4;
-- 선생님 답
SELECT LAST_NAME AS 사원이름, JOB_ID AS 업무ID,
       JOB_TITLE AS 직무, SALARY AS 급여
FROM EMPLOYEES
JOIN JOBS USING(JOB_ID)
WHERE (JOB_ID, SALARY) IN (SELECT JOB_ID, TRUNC(AVG(SALARY), -3)
                           FROM EMPLOYEES GROUP BY JOB_ID)
ORDER BY 4;

SELECT AVG(SALARY) FROM EMPLOYEES GROUP BY JOB_ID;
JOB_ID AS 업무ID, TO_CHAR(ROUND(AVG(SALARY), -2) AS 평균급여, '$999,999');



