package com.tjoeun.springBoot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tjoeun.springBoot.entity.Article;
import com.tjoeun.springBoot.entity.Comment;

import lombok.extern.slf4j.Slf4j;

//	@SpringBootTest 어노테이션을 붙여주면 springBoot와 연통한 통합 테스트를 수행할 수 있고
//	@DataJpaTest 어노테이션을 붙여주면 JPA와 연동한 테스트를 수행한다.
@DataJpaTest
@Slf4j
class CommentRepositoryTest {

	@Autowired
	private CommentRepository commentRepository;
	
	@Test
//	@DisplayName 어노테이션으로 테스트 결과에 보여줄 이름을 지정할 수 있다.
	@DisplayName("특정 게시글의 모든 댓글을 조회한다.")
	void testFindByArticleId() {
//		5번 게시글의 모든 댓글 조회
		{
//			입력 데이터 준비한다.
			Long articleId = 5L;
//			실제 sql 명령을 실행한다.
			List<Comment> comments = commentRepository.findByArticleId(articleId);
//			log.info(comments.toString());
//			예상 결과 데이터를 만든다.
			Article article = new Article(5L, "최근에 감상한 영화는?", "재미있게 본 영화 제목을 알려주세요.");
			Comment comment1 = new Comment(1L, article, "손오공", "탑건2");
			Comment comment2 = new Comment(2L, article, "저팔계", "범죄도시2");
			Comment comment3 = new Comment(3L, article, "사오정", "모가디슈");
//			List<Comment> expected = new ArrayList<Comment>();
//			expected.add(comment1);
//			expected.add(comment2);
//			expected.add(comment3);
			List<Comment> expected = Arrays.asList(comment1, comment2, comment3);
//			실제값과 예상값을 검증한다.
//			assertEquals() 메소드의 3번째 인수로 테스트 실패시 JUnit 결과창에 출력할 메시지를 지정할 수 있다.
//			assertEquals(expected.toString(), comments.toString(), "5번 글의 모든 댓글을 출력한다.");
			assertEquals(expected.toString(), comments.toString());
		}
		
//		1번 게시글의 모든 댓글 조회
		{
			Long articleId = 1L;
			List<Comment> comments = commentRepository.findByArticleId(articleId);
//			List<Comment> expected = new ArrayList<Comment>();
			List<Comment> expected = Arrays.asList();
			assertEquals(expected.toString(), comments.toString());
		}
	}

	@Test
	@DisplayName("특정 닉네임의 모든 댓글을 조회한다.")
	void testFindByNickname() {
//		nickname이 저팔계인 모든 댓글 조회
		{
			String nickname = "저팔계";
			List<Comment> comments = commentRepository.findByNickname(nickname);
//			log.info(comments.toString());
			Comment comment1 = 
					new Comment(2L, new Article(5L, "최근에 감상한 영화는?", 
							"재미있게 본 영화 제목을 알려주세요."), nickname, "범죄도시2");
			Comment comment2 = new Comment(5L, new Article(6L, "좋아하지 않는 취미는?", 
					"하기 싫은것을 알려주세요."), nickname, "바둑");
			Comment comment3 = new Comment(8L, new Article(7L, "뭐 먹고 싶니?", 
					"먹고 싶은 음식을 적어주세요."), nickname, "튀김");
			List<Comment> expected = Arrays.asList(comment1, comment2, comment3);
			assertEquals(expected.toString(), comments.toString(), "저팔계의 모든 댓글을 출력한다.");
		}
		
//		nickname이 사오정인 모든 댓글 조회
		{
			String nickname = "사오정";
			List<Comment> comments = commentRepository.findByNickname(nickname);
//			log.info(comments.toString());
			Comment comment1 = 
					new Comment(3L, new Article(5L, "최근에 감상한 영화는?", 
							"재미있게 본 영화 제목을 알려주세요."), nickname, "모가디슈");
			Comment comment2 = new Comment(6L, new Article(6L, "좋아하지 않는 취미는?", 
					"하기 싫은것을 알려주세요."), nickname, "낚시");
			Comment comment3 = new Comment(9L, new Article(7L, "뭐 먹고 싶니?", 
					"먹고 싶은 음식을 적어주세요."), nickname, "짜장면");
			List<Comment> expected = Arrays.asList(comment1, comment2, comment3);
			assertEquals(expected.toString(), comments.toString(), "사오정의 모든 댓글을 출력한다.");
		}
		
//		nickname이 null인 모든 댓글 조회
		{
			String nickname = null;
			List<Comment> comments = commentRepository.findByNickname(nickname);
			List<Comment> expected = Arrays.asList();
			assertEquals(expected.toString(), comments.toString(), "nickname이 null인 모든 댓글을 출력한다.");
		}
	}

}








