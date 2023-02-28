@@D:\Oracle\stExe.sql

select * from emp;



insert into 연산(x, y, z) values(25, 36, 12.34567);
insert into 연산(x, y, z) values(25.34567, 36.34567, 12.34567);
insert into 연산(x, y) values(25.666, 36.88888);
insert into 연산(z, y, x) values(1, 2, 3);

insert into 연산 values(25, 36, 12.34567);

insert into 연산 values(25, 36, 1234567.3456);
insert into 연산 values(25, 36, 12345678.3456);

select * from 연산;

commit;




create table dbtest(
name varchar2(15), -- char(고정형), varchar2(가변형)
age number,  	   
height number(10, 2),   
logtime date);

select * from dbtest;

insert into dbtest(name,age,height,logtime) values('홍길동',25,185.567,sysdate);
insert into dbtest(name,age,height,logtime) values('Hong',30,175.56,sysdate);
insert into dbtest(name,age) values('희동이',3);
insert into dbtest(name, height) values('홍당무', 168.89);
insert into dbtest values('분홍신',5,123.5,sysdate);
insert into dbtest(name) values('진분홍');



select * from tab;
select * from 연산;
select * from recyclebin;
show recyclebin;
flashback table 연산 to before drop;



create sequence test increment by 2 start with 1 maxvalue 9 cycle nocache;
select test.nextval from dual;
select test.currval from dual;
select * from user_sequences;

create SEQUENCE exam nocycle nocache;

drop sequence test;



select * from emp;
select * from emp where ename like '김%';
select * from emp where hdate < '2000-01-01%';

-- 1달러=1234원일 때 번호, 이름, 월급 탐색
select eno, ename, sal*1234 as "sal(won)" from emp; 

-- 커미션을 받지 않은 사람
select * from emp where comm=0 or comm is null;

-- 개발부의 레코드를 월급으로 내림차순
select * from emp where job='개발' order by sal desc;
