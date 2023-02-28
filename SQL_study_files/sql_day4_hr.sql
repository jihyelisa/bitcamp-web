-- 테이블 복사
create table locations2 as select * from locations;
select * from locations;
select * from locations2;
alter table locations2 rename column location_id to loc_id;
select * from locations2; -- 컬럼명이 바뀌었다

select last_name, department_id, department_name from employees 
join departments using(department_id); --NULL값 출력 안 됨
select last_name, department_id, department_name from employees 
left join departments using(department_id); --NULL값 출력됨

select last_name, department_id, department_name from employees 
right join departments using(department_id);

select last_name, department_id, department_name from employees
full join departments using(department_id);

select last_name, department_id, manager_id from employees
inner join departments using(department_id, manager_id);

-- [문제3] 위치ID, 부서ID을 연결해서 사원이름, 도시, 부서이름을 출력하시오
-- 관련 테이블 : EMPLOYEES, LOCATIONS2, DEPARTMENTS
SELECT * FROM EMPLOYEES;
SELECT * FROM LOCATIONS;
SELECT * FROM DEPARTMENTS;
SELECT LAST_NAME, CITY, DEPARTMENT_NAME
FROM EMPLOYEES, LOCATIONS2, DEPARTMENTS
LEFT JOIN EMPLOYEES USING(LOCATIONS, DEPARTMENTS);
-- 선생님 답
SELECT LAST_NAME AS 사원이름,
       CITY AS "도 시",
       DEPARTMENT_NAME AS 부서이름
FROM EMPLOYEES
JOIN DEPARTMENTS USING(DEPARTMENT_ID)
JOIN LOCATIONS2 ON(LOCATION_ID = LOC_ID)
WHERE CITY IN ('Seattle', 'Oxford')
ORDER BY 2, 1;

-- [문제4]
SELECT EMPLOYEE_ID AS 사원번호,
       LAST_NAME AS 사원이름,
       DEPARTMENT_NAME AS 부서이름,
       CITY AS "도 시",
       STREET_ADDRESS AS 도시주소,
       COUNTRY_NAME AS 나라이름
FROM EMPLOYEES
LEFT JOIN DEPARTMENTS USING(DEPARTMENT_ID)
JOIN LOCATIONS2 ON(LOCATION_ID = LOC_ID) --컬럼명이 달라서 ON 사용
JOIN COUNTRIES USING(COUNTRY_ID)
WHERE STREET_ADDRESS LIKE '%Ch%'
      OR STREET_ADDRESS LIKE '%Sh%'
      OR STREET_ADDRESS LIKE '%Rd%'
ORDER BY 6, 4;
