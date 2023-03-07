create table guestbook(
seq   number primary key, -- 시퀀스 객체로부터 값을 얻어온다
name  varchar2(30),
email  varchar2(30),
homepage  varchar2(35),
subject  varchar2(500) not null,
content  varchar2(4000) not null,
logtime  date);

create sequence seq_guestbook nocycle nocache;

select * from guestbook;

commit;

SELECT NAME,EMAIL,HOMEPAGE,SUBJECT,CONTENT,TO_CHAR(LOGTIME,'YYYY.MM.DD') AS LOGTIME FROM GUESTBOOK WHERE SEQ=1;

SELECT * FROM (
SELECT ROWNUM RN, -- hidden column rownum: 번호 생성해줌
AA.*
FROM (SELECT SEQ,NAME,EMAIL,HOMEPAGE,SUBJECT,
      CONTENT,TO_CHAR(LOGTIME,'YYYY.MM.DD') AS LOGTIME
      FROM GUESTBOOK ORDER BY SEQ DESC) AA
      ) WHERE RN>=? AND RN<=?;
      
SELECT COUNT(*) FROM GUESTBOOK;

select * from member;