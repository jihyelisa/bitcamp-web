select * from tab;
PURGE RECYCLEBIN;
select * from 연산;
select * from dbtest;
select * from student2;

insert into dbtest values('홍길동', 25, 185.3, sysdate);
update dbtest set age=30 where name='홍길동';
update dbtest set height=185.3 where name='홍길동';
delete dbtest where height=185.3;
flashback table dbtest to before update;
commit;

create table student2(
name  varchar2(15)  not  null, -- 이름
value   varchar2(15), -- 학번 or 과목 or 부서
code   number   -- 1이면 학생, 2이면 교수, 3이면 관리자
);

select * from student2;