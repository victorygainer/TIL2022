package com.tjoeun.springBoot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tjoeun.springBoot.dto.ArticleForm;
import com.tjoeun.springBoot.entity.Article;
import com.tjoeun.springBoot.repository.ArticleRepository;
import com.tjoeun.springBoot.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

//	@RestController 어노테이션은 REST api용 컨트롤러로 사용됨을 의미한다.
//	뷰 템플릿 형식이 아닌 json 형식의 데이터를 반환한다.
@RestController
@Slf4j
public class ArticleApiController {

//	ArticleApiController에서 만들어 사용하던 ArticleRepository는 Service 클래스로 넘기고
//	ArticleRepository는 Service 클래스 객체를 만들어 사용한다.
	@Autowired
	private ArticleRepository articleRepository;
//	springBoot가 자동으로 생성한 ArticleService 클래스의 bean을 자동으로 주입받는다.
	@Autowired
	private ArticleService articleService;
	
//	전체 목록 조회
	@GetMapping("/api/articles")
	public List<Article> index() {
		log.info("ArticleApiController의 index() 메소드 실행");
//		return articleRepository.findAll();
		return articleService.index();
	}
	
//	단건 조회
	@GetMapping("/api/articles/{id}")
	public Article show(@PathVariable Long id) {
		log.info("ArticleApiController의 show() 메소드 실행");
//		return articleRepository.findById(id).orElse(null);
		return articleService.show(id);
	}
	
//	글 저장
	@PostMapping("/api/articles")
//	form에서 데이터를 받아올 때는 커맨드 객체로 그냥 받으면 되지만 REST api에서 json으로 던지는
//	데이터를 받을 때는 body 부분에 담겨오는 데이터를 받아야 하므로 커맨드 객체에서 @RequestBody
//	어노테이션을 붙여서 받아야 한다.
//	상태 코드를 담아서 리턴하려면 ResponseEntity 객체를 사용한다.
//	ResponseEntity<Article>를 리턴 타입으로 사용하려면 ResponseEntity 객체에 Article 객체를 
//	담아서 리턴한다.
	public ResponseEntity<Article> create(@RequestBody ArticleForm form) {
		log.info("ArticleApiController의 create() 메소드 실행");
		log.info(form.toString());
		
//		Article saved = articleRepository.save(form.toEntity());
		Article saved = articleService.create(form);
		
//		HttpStatus.CREATED: 201, HttpStatus.BAD_REQUEST: 400
//		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
//		body() 메소드는 body에 데이터를 담아서 넘기고 build() 메소드는 body 없이 넘겨준다.
		return saved != null ?
				ResponseEntity.status(HttpStatus.CREATED).body(saved) :
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
//	글 수정
	@PatchMapping("/api/articles/{id}")
	public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm form) {
		log.info("ArticleApiController의 update() 메소드 실행");
		/*
//		수정용 Entity를 생성한다.
		Article article = form.toEntity(); // 수정할 정보
		log.info("id: {}, article: {}", id, article.toString());
		
//		수정할 Entity를 조회한다.
		Article target = articleRepository.findById(id).orElse(null); // 수정할 원본
//		잘못된 요청(수정할 대상이 없거나 id가 다른 경우)을 처리한다.
		if (target == null || id != article.getId()) {
//			400, 잘못된 요청 응답
			log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
//			ResponseEntity 객체에 400 상태 코드를 저정하고 body에는 아무것도 저장하지 않는다.
//			HttpStatus.BAD_REQUEST: 400
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
//		수정 후 정상 응답을 보낸다.
//		RequestBody를 통해 ArticleForm으로 넘어오는 수정할 데이터의 일부가 넘어오지 않을 경우 넘어오지
//		않은 데이터는 null로 수정되는 문제가 발생된다. 이 현상을 방지하기 위해서 조회된 수정할 Entity를
//		RequestBody를 통해 넘어온 데이터가 있는 경우만 수정한다.
		target.patch(article); // 수정할 원본을 수정할 정보로 수정한다.
		log.info("id: {}, article: {}", id, target.toString());
		Article updated = articleRepository.save(target);
		*/
		Article updated = articleService.update(id, form);
		
//		ResponseEntity 객체에 200 상태 코드를 저정하고 body에는 수정된 데이터를 저장한다.
//		HttpStatus.OK: 200, HttpStatus.BAD_REQUEST: 400
//		return ResponseEntity.status(HttpStatus.OK).body(updated);
		return updated != null ?
				ResponseEntity.status(HttpStatus.OK).body(updated) :
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
//	글 삭제
	@DeleteMapping("/api/articles/{id}")
	public ResponseEntity<Article> delete(@PathVariable Long id) {
		log.info("ArticleApiController의 delete() 메소드 실행");
		/*
		log.info("id: {}", id);
//		삭제할 Entity를 조회한다.
		Article target = articleRepository.findById(id).orElse(null);
//		잘못된 요청(수정할 대상이 없을 경우)을 처리한다.
		if (target == null) {
//			400, 잘못된 요청 응답
			log.info("잘못된 요청! id가 {}인 데이터가 없습니다.", id);
//			ResponseEntity 객체에 400 상태 코드를 저정하고 body에는 아무것도 저장하지 않는다.
//			HttpStatus.BAD_REQUEST: 400
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
//		삭제 후 정상 응답을 보낸다.
		log.info("id가 {}인 데이터 삭제 완료!!", id);
		articleRepository.delete(target);
		*/
		Article deleted = articleService.delete(id);

//		ResponseEntity 객체에 204 상태 코드를 저정하고 body에는 수정된 데이터를 저장한다.
//		HttpStatus.NO_CONTENT: 204, HttpStatus.BAD_REQUEST: 400
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		return deleted != null ?
				ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
//	트랜잭션은 데이터베이스의 상태를 변화시키는 하나의 논리적인 기능을 수행하기 위한 작업의 단위
//	또는 한꺼번에 모두 수행되어야 할 일련의 연산들을 의미한다.
//	1. 트랜잭션은 데이터베이스 시스템에서 병행 제어 및 회복 작업시 처리되는 작업의 논리적 단위
//	2. 사용자가 시스템에 대한 서비스 요구 시 시스템이 응답하기 위한 상태 변환 과정의 작업 단위
//	3. 하나의 트랜잭션은 commit(성공) 되거나 rollback(실패) 된다.
	
//	트랜잭션의 성질
//	1. Atomicity(원자성)
//	   트랜잭션의 연산은 데이터베이스에 모두 반영되든지 아니면 전혀 반영되지 않아야 한다.
//	   트랜잭션 내의 모든 명령은 반드시 완벽히 수행되어야 하며, 모두가 완벽히 수행되지 않고 
//	   어느 하나라도 오류가 발생하면 트랜잭션 전부가 취소되어야 한다.
//	2. Consistency(일관성)
//	   트랜잭션이 그 실행을 성공적으로 완료하면 언제나 일관성 있는 데이터베이스 상태로 변환한다.
//	   시스템이 가지고 있는 고정요소는 트랜잭션 수행 전과 트랜잭션 수행 완료 후의 상태가 같아야
//	   한다.
//	3. Isolation(독립성, 격리성)
//	   둘 이상의 트랜잭션이 동시에 병행 실행되는 경우 어느 하나의 트랜잭션이 실행중에 다른 
//	   트랜잭션의 연산이 끼어들 수 없다.
//	   수행중인 트랜잭션은 완전히 완료될 때까지 다른 트랜잭션에서 수행 결과를 참조할 수 없다.
//	4. Durablility(영속성, 지속성)
//	   성공적으로 완료된 트랜잭션의 결과는 시스템이 고장나더라도 영구적으로 반영되어야 한다.	
	
//	트랜잭션 연산
//	1. Commit 연산
//	   Commit 연산은 한개의 논리적 단위(트랜잭션)에 대한 작업이 성공적으로 끝났고 데이터베이스가
//	   다시 일관된 상태에 있을 때, 이 트랜잭션이 행한 갱신 연산이 완료된 것을 트랜잭션 관리자에게
//	   알려주는 연산이다.
//	2. Rollback 연산
//	   Rollback 연산은 하나의 트랜잭션 처리가 비정상적으로 종료되어 데이터베이스의 일관성을 
//	   깨뜨렸을 때, 이 트랜잭션의 일부가 정상적으로 처리되었더라도 트랜잭션의 원자성을 구현하기
//	   위해 이 트랜잭션이 행한 모든 연산을 취소(Undo)하는 연산이다.
//	   Rollback시에는 해당 트랜잭션을 재시작하거나 폐기한다.
	
//	트랜잭션의 상태
//	1. 활동(Active): 트랜잭션이 실행중인 상태
//	2. 실패(Failed): 트랜잭션 실행에 오류가 발생하여 중단된 상태
//	3. 철회(Aborted): 트랜잭션이 비정상적으로 종료되어 Rollback 연산을 수행한 상태
//	4. 부분 완료(Partially Committed): 트랜잭션의 마지막 연산까지 실행했고 Commit 연산이 실행되기
//	   직전의 상태
//	5. 완료(Committed): 트랜잭션이 성공적으로 종료되어 Commit 연산을 실행한 후의 상태
	
//	트랜잭션 => 실패 => 롤백
	@PostMapping("/api/transaction-test")
	public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> forms) {
		log.info("ArticleApiController의 transactionTest() 메소드 실행");
		List<Article> createList = articleService.createArticles(forms);
//		HttpStatus.OK: 200, HttpStatus.BAD_REQUEST: 400
		return createList != null ?
				ResponseEntity.status(HttpStatus.OK).body(createList) :
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}










