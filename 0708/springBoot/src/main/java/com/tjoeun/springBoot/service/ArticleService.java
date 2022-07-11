package com.tjoeun.springBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.springBoot.dto.ArticleForm;
import com.tjoeun.springBoot.entity.Article;
import com.tjoeun.springBoot.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//	@Service 어노테이션을 붙여준 클래스는 springBoot가 서비스로 인식해서 자동으로 bean을 생성해 등록한다.
@Service
public class ArticleService {

//	springBoot가 자동으로 생성한 ArticleRepository 인터페이스의 bean을 자동으로 주입받는다.
	@Autowired
	private ArticleRepository articleRepository;

//	전체 목록 조회
	public List<Article> index() {
		log.info("ArticleService의 index() 메소드 실행");
		return articleRepository.findAll();
	}

//	단건 조회	
	public Article show(Long id) {
		log.info("ArticleService의 show() 메소드 실행");
		return articleRepository.findById(id).orElse(null);
	}

//	글 저장
	public Article create(ArticleForm form) {
		log.info("ArticleService의 create() 메소드 실행");
		Article article = form.toEntity();
//		id는 JPA가 자동으로 1씩 증가하므로 id가 넘어오는 데이터는 저장하면 안된다.
		if (article.getId() != null) {
			return null;
		}
		return articleRepository.save(article);
	}

//	글 수정
	public Article update(Long id, ArticleForm form) {
		log.info("ArticleService의 update() 메소드 실행");
		Article article = form.toEntity();
		log.info("id: {}, article: {}", id, article.toString());
		Article target = articleRepository.findById(id).orElse(null);
		if (target == null || id != article.getId()) {
			log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
			return null;
		}
		
//		id만 입력되면 null을 리턴하는 코드를 추가한다.
		if (article.getTitle() == null && article.getContent() == null) {
			log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
			return null;
		}
		
		target.patch(article);
		log.info("id: {}, article: {}", id, target.toString());
		Article updated = articleRepository.save(target);
		return updated;
	}

//	글 삭제
	public Article delete(Long id) {
		log.info("ArticleService의 delete() 메소드 실행");
		log.info("id: {}", id);
		Article target = articleRepository.findById(id).orElse(null);
		if (target == null) {
			log.info("잘못된 요청! id가 {}인 데이터가 없습니다.", id);
			return null;
		}
		log.info("id가 {}인 데이터 삭제 완료!!", id);
		articleRepository.delete(target);
		return target;
	}

//	트랜잭션 처리
//	@Transactional 어노테이션은 해당 메소드를 트랜잭션으로 묶는다.
//	@Transactional 어노테이션을 붙여준 메소드는 정상적인 실행이 완료되지 않으면 오류가 발생되기
//	이전에 실행되었던 모든 sql 명령을 rollback 시켜 메소드가 실행되기 이전 상태로 되돌린다.
	@Transactional
	public List<Article> createArticles(List<ArticleForm> forms) {
		log.info("ArticleService의 createArticles() 메소드 실행");
		
//		컨트롤러에서 넘어온 DTO(VO) 묶음을 Entity 묶음으로 변환한다.
		/*
		List<Article> articleList = new ArrayList<Article>();
//		for (int i=0; i < forms.size(); i++) {
//			Article entity = forms.get(i).toEntity();
//			articleList.add(entity);
//		}
		for (ArticleForm form : forms) {
			articleList.add(form.toEntity());
		}
		*/
		
		List<Article> articleList = forms.stream()
				.map(form -> form.toEntity())
				.collect(Collectors.toList());
		log.info(articleList.toString());
		
//		Entity 묶음을 데이터베이스에 저장한다.
		/*
//		for (int i=0; i < articleList.size(); i++) {
//			articleRepository.save(articleList.get(i));
//		}
		for (Article article : articleList) {
			articleRepository.save(article);
		}
		*/
		
		articleList.stream()
			.forEach(article -> articleRepository.save(article));
		
//		강제로 예외를 발생시킨다.
		articleRepository.findById(-1L).orElseThrow(
			() -> new IllegalArgumentException("저장 실패")
		);
		
//		강제로 예외를 발생시켰으므로 500 에러가 발생되지만 예외가 발생되기 전에 실행된 insert 명령에
//		의해 테이블에 데이터가 저장되는 문제가 발생된다.
//		데이터베이스 작업이 정상적으로 종료되지 않은 경우 테이블에 데이터가 저장되지 않도록 rollback
//		처리가 되도록 트랜잭션 처리를 해야 한다.
//		트랜잭션을 처리하는 방법은 트랜잭션 처리가 되야하는 메소드에 @Transactional 어노테이션을
//		지정하면 된다.
		
//		데이터베이스에 저장된 결과값 리턴
		return articleList;
	}
	
}














