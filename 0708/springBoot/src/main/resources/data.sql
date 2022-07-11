INSERT INTO article(id, title, content) VALUES (1, '홍길동', '천재');
INSERT INTO article(id, title, content) VALUES (2, '임꺽정', '처언재');
INSERT INTO article(id, title, content) VALUES (3, '장길산', '처어언재');
INSERT INTO article(id, title, content) VALUES (4, '일지매', '바보');

-- article 더미 데이터
INSERT INTO article(id, title, content) VALUES (5, '최근에 감상한 영화는?', '재미있게 본 영화 제목을 알려주세요.');
INSERT INTO article(id, title, content) VALUES (6, '좋아하지 않는 취미는?', '하기 싫은것을 알려주세요.');
INSERT INTO article(id, title, content) VALUES (7, '뭐 먹고 싶니?', '먹고 싶은 음식을 적어주세요.');

-- comment 더미 데이터
-- 5번 게시물의 댓글
INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 5, '손오공', '탑건2');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 5, '저팔계', '범죄도시2');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 5, '사오정', '모가디슈');

-- 6번 게시물의 댓글
INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 6, '손오공', '등산');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 6, '저팔계', '바둑');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 6, '사오정', '낚시');

-- 7번 게시물의 댓글
INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 7, '손오공', '라면');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 7, '저팔계', '튀김');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 7, '사오정', '짜장면');