package com.tjoeun.springBoot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.springBoot.dto.ArticleForm;
import com.tjoeun.springBoot.entity.Article;

//	@SpringBootTest 어노테이션을 붙여 springBoot와 연동한 통합 테스트를 수행한다.
@SpringBootTest
class ArticleServiceTest {

	@Autowired
	private ArticleService articleService;
	
	@Test
	void testIndex() {
//		예상값
		Article article1 = new Article(1L, "홍길동", "천재");
		Article article2 = new Article(2L, "임꺽정", "처언재");
		Article article3 = new Article(3L, "장길산", "처어언재");
		Article article4 = new Article(4L, "일지매", "바보");
		List<Article> expected = new ArrayList<Article>();
		expected.add(article1);
		expected.add(article2);
		expected.add(article3);
		expected.add(article4);
//		실제값
		List<Article> articles = articleService.index();
//		예상값과 실제값을 비교한다.
		assertEquals(expected.toString(), articles.toString());
	}

	@Test
	void testShow_성공_존재하는_id() {
		Long id = 1L;
		Article expected = new Article(id, "홍길동", "천재");
		Article article = articleService.show(id);
		assertEquals(expected.toString(), article.toString());
	}
	
	@Test
	void testShow_실패_존재하지_않는_id() {
		Long id = -1L;
		Article expected = null;
		Article article = articleService.show(id);
		assertEquals(expected, article);
	}

//	테이블이 변경되는 테스트를 실행하는 경우 이전 테스트의 영향을 받아서 하나씩 테스트 할 때는
//	정상적으로 실행되던 테스트가 한꺼번에 실행하면 오류가 발생될 수 있기 때문에 테스트 결과가
//	테이블을 변경시키는 테스트는 @Transactional 어노테이션을 붙여서 테스트가 끝나면 이전 상태로
//	롤백하도록 해줘야 한다.
	
	@Test
//	@Test에 @Transactional를 추가하면 테스트 종료 후 변경된 데이터를 롤백 처리한다.
	@Transactional
	void testCreate_성공_title_content만_있는_form() {
//		저장할 데이터
		String title = "손오공";
		String content = "에네르기 파~~~~~";
		ArticleForm form = new ArticleForm(null, title, content);
//		예상값
		Article expected = new Article(5L, title, content);
//		실제값
		Article article = articleService.create(form);
//		예상값과 실제값을 비교한다.
		assertEquals(expected.toString(), article.toString());
	}
	
	@Test
	@Transactional
	void testCreate_실패_id가_있는_form() {
		ArticleForm form = new ArticleForm(5L, "손오공", "에네르기 파~~~~~");
		Article expected = null;
		Article article = articleService.create(form);
		assertEquals(expected, article);
	}

	@Test
	@Transactional
	void testUpdate_성공_존재하는_id와_title_content가_있을때() {
		Long id = 3L;
		String title = "저팔계";
		String content = "왜 그러셩~~~~~~";
		ArticleForm form = new ArticleForm(id, title, content);
		Article expected = new Article(3L, "저팔계", "왜 그러셩~~~~~~");
		Article article = articleService.update(id, form);
		assertEquals(expected.toString(), article.toString());
	}
	
	@Test
	@Transactional
	void testUpdate_성공_존재하는_id와_title이_있을때() {
		Long id = 3L;
		String title = "저팔계";
		String content = null;
		ArticleForm form = new ArticleForm(id, title, content);
		Article expected = new Article(3L, "저팔계", "처어언재");
		Article article = articleService.update(id, form);
		assertEquals(expected.toString(), article.toString());
	}
	
	@Test
	@Transactional
	void testUpdate_성공_존재하는_id와_content가_있을때() {
		Long id = 3L;
		String title = null;
		String content = "왜 그러셩~~~~~";
		ArticleForm form = new ArticleForm(id, title, content);
		Article expected = new Article(3L, "장길산", "왜 그러셩~~~~~");
		Article article = articleService.update(id, form);
		assertEquals(expected.toString(), article.toString());
	}
	
	@Test
	@Transactional
	void testUpdate_실패_존재하지_않는_id와_title_content가_있을때() {
		Long id = 5L;
		String title = "저팔계";
		String content = "왜 그러셩~~~~~";
		ArticleForm form = new ArticleForm(id, title, content);
		Article expected = null;
		Article article = articleService.update(id, form);
		assertEquals(expected, article);
	}
	
	@Test
	@Transactional
	void testUpdate_실패_id만_있을때() {
		Long id = 4L;
		String title = null;
		String content = null;
		ArticleForm form = new ArticleForm(id, title, content);
		Article expected = null;
		Article article = articleService.update(id, form);
		assertEquals(expected, article);
	}

	@Test
	@Transactional
	void testDelete_성공_존재하는_id() {
		Long id = 4L;
		String title = "일지매";
		String content = "바보";
		ArticleForm form = new ArticleForm(id, title, content);
		Article expected = new Article(id, title, content);
		Article article = articleService.delete(id);
		assertEquals(expected.toString(), article.toString());
	}
	
	@Test
	@Transactional
	void testDelete_실패_존재하지_않는_id() {
		Long id = 5L;
		String title = "일지매";
		String content = "바보";
		ArticleForm form = new ArticleForm(id, title, content);
		Article expected = null;
		Article article = articleService.delete(id);
		assertEquals(expected, article);
	}

}
