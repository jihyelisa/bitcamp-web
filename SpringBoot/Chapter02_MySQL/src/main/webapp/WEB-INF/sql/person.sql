use mydb;
create table usertable (
name varchar(30) not null,
id varchar(30) primary key,
pwd varchar(30) not null);

show tables;
select * from usertable;

create table person (
seq int primary key auto_increment,
name varchar(30) not null,
age numeric not null,
photo varchar(30) not null);

select * from person;

drop table person;

update person set photo='rivers.webp' where seq=2;

rollback;
commit;

delete from person where seq<3;