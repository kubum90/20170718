--id, password,name,ssn,regdate

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'hong','홍길라임','호나우도요타',0,SYSDATE);

INSERT INTO Member(%s,%s,%s,%s,%s) VALUES(?,?,?,?,SYSDATE)

SELECT * FROM Member;
SELECT COUNT(*) AS count FROM Member;
SELECT * FROM Member WHERE name="김철수";
SELECT * FROM Member WHERE id='hong';

UPDATE Member
SET password='2'
WHERE id='hong';


DELETE 
DELETE FROM Member WHERE id ='hong';
SELECT * FROM Member;
SELECT * FROM Board;