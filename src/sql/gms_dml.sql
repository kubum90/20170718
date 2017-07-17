--id, password,name,ssn,regdate
SELECT * FROM Member;
SELECT COUNT(*) AS count FROM Member;
SELECT * FROM Member WHERE name="김철수";
INSERT INTO Member(id,name,password,ssn,regdate);
VALUES('','','');

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'pochen','여자친구',
'여자친구 어떻게 만드나요?',0,SYSDATE);

DELETE 
DELETE FROM Board WHERE TITLE ='dkfl4';
SELECT * FROM Member;
SELECT * FROM Board;