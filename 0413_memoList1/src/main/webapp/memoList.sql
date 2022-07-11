# insert into 테이블이름 (필드명, ...) VALUES (저장할 데이터, ...);
INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('홍길동', '1111', '1등 입니다.', '192.168.100.1');
INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('임꺽정', '2222', '2등 입니다.', '192.168.100.2');
INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('장길산', '3333', '3등 입니다.', '192.168.100.3');
INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('일지매', '4444', '4등 입니다.', '192.168.100.4');

SELECT * FROM memolist ORDER BY idx DESC;
SELECT COUNT(*) FROM memolist;
SELECT * FROM memolist ORDER BY idx DESC LIMIT 20, 10;
SELECT * FROM memolist WHERE idx = 150;

DELETE FROM memolist;
ALTER TABLE memolist AUTO_INCREMENT = 1;




