CREATE TABLE "AJAX" (
    "IDX" NUMBER(*,0) NOT NULL, 
	"NAME" CHAR(20 BYTE) NOT NULL, 
	"AGE" NUMBER(*,0) NOT NULL, 
	"GENDER" CHAR(4 BYTE) NOT NULL, 
	"EMAIL" VARCHAR2(50 BYTE) NOT NULL, 
	 CONSTRAINT "AJAX_PK" PRIMARY KEY ("IDX")
);

DELETE FROM ajax;
DROP SEQUENCE ajax_idx_seq;
CREATE SEQUENCE ajax_idx_seq;

SELECT * FROM ajax ORDER BY idx DESC;

INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '홍길동', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '임꺽정', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '장길산', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '일지매', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '손오공', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '저팔계', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '사오정', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '브루마', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '베지터', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '무천도사', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '마인부우', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '우마왕', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '손오반', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '크리닝', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '오룡', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '피콜로', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '야무치', 20, '남', 'a@a.com');
INSERT INTO ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, '후리자', 20, '남', 'a@a.com');

COMMIT;