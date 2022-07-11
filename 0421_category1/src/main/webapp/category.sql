CREATE TABLE "CATEGORY" (
	"IDX" NUMBER(*,0), 
	"CATEGORY" VARCHAR2(300) NOT NULL ENABLE, 
	"GUP" NUMBER(*,0), 
	"LEV" NUMBER(*,0), 
	"SEQ" NUMBER(*,0), 
	"DELETECHECK" CHAR(3) DEFAULT 'NO', 
	"DELETEREPORT" NUMBER(38,0) DEFAULT 0, 
	CONSTRAINT "CATEGORY_PK" PRIMARY KEY ("IDX")
);

SELECT * FROM CATEGORY;
select * from category order by gup desc, seq ASC;
SELECT * FROM category WHERE gup = 1 AND lev > 1 AND seq > 6 OR idx = 2 order by gup desc, seq ASC;

-- ���̺��� ��� �����͸� �����ϰ� �������� �ٽ� 1���� �����Ѵ�.
DELETE FROM CATEGORY;
DROP SEQUENCE category_idx_seq;
CREATE SEQUENCE category_idx_seq;




