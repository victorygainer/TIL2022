 CREATE TABLE "GUESTBOOK" (
    "IDX" NUMBER(*,0) NOT NULL ENABLE, 
	"NAME" CHAR(20 BYTE) NOT NULL ENABLE, 
	"PASSWORD" CHAR(20 BYTE) NOT NULL ENABLE, 
	"MEMO" VARCHAR2(3000 BYTE) NOT NULL ENABLE, 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	"IP" CHAR(15 BYTE), 
	CONSTRAINT "GUESTBOOK_PK" PRIMARY KEY ("IDX")
);

select * from guestbook order by idx desc;
select count(*) from guestbook;

select count(*) from guestbook where memo like '%1등%';
select count(*) from guestbook where name like '%길%';
select count(*) from guestbook where memo like '%고길%' or name like '%고길%';

select * from guestbook where memo like '%1등%' order by idx desc; -- 내용
select * from guestbook where name like '%길%' order by idx desc; -- 이름
select * from guestbook where name like '%매%' or memo like '%1등%' order by idx desc; -- 내용+이름

delete from guestbook;
drop SEQUENCE guestbook_idx_seq;
create SEQUENCE guestbook_idx_seq;

insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '홍길동', '1111', '1등 입니다.', '192.168.100.101');
insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '임꺽정', '2222', '2등 입니다.', '192.168.100.102');
insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '장길산', '3333', '3등 입니다.', '192.168.100.103');
insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '일지매', '4444', '4등 입니다.', '192.168.100.104');

-- 트랜잭션은 한번에 모두 실행되야 할 명령의 집합
-- commit: 트랜잭션이 모두 정상적으로 처리되서 결과를 데이터베이스에 반영한다.
-- rollback: 트랜잭션이 모두 정상적으로 처리되지 않았을 경우 최초 실행상태 이전으로 되돌린다.
-- 오라클 디벨로퍼는 auto commit이 지원되지 않기 때문에 디벨로퍼에서 진행한 작업이 jsp에 적용되게 하려면
-- 반드시 commit 명령을 실행해야 한다.
commit;




