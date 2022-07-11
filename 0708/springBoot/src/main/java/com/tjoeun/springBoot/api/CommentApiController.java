package com.tjoeun.springBoot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tjoeun.springBoot.dto.CommentVO;
import com.tjoeun.springBoot.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CommentApiController {

//	CommentService 클래스의 메소드를 사용하기 위해 CommentService 클래스의 bean을 가져온다.
	@Autowired
	private CommentService commentService;
	
//	댓글 목록 조회
//	Talend API Tester(GET) => http://localhost:9090/api/comments/5/comments
	@GetMapping("/api/comments/{articleId}/comments")
	public ResponseEntity<List<CommentVO>> comments(@PathVariable Long articleId) {
		log.info("CommentApiController의 comments() 메소드 실행");
//		댓글 목록을 얻어오는 service 클래스의 메소드 실행한다.
		List<CommentVO> comments = commentService.comments(articleId);
//		댓글 목록을 json으로 리턴한다.
		return ResponseEntity.status(HttpStatus.OK).body(comments);
	}
	
//	댓글 저장
//	Talend API Tester(POST) => http://localhost:9090/api/comments/5/comments
//	Talend API body data
//	json에서 사용한 key와 json 데이터를 넘겨받을 java 클래스의 필드 이름이 다를 경우
//	java 클래스에서 @JsonProperty("json key") 어노테이션을 지정해서 받으면 된다.
//	{
//		"nickname": "무천도사",
//		"body": "드래곤볼",
//		"article_id": 5
//	}
//	컨트롤러에 요청되는 id({articleId})와 body data의 id(article_id)가 다르면 예외가 발생된다.
//	컨트롤러에 요청되는 id와 body data의 id가 같더라도 없는 메인글일 경우 예외가 발생된다.
	@PostMapping("/api/comments/{articleId}/comments")
	public ResponseEntity<CommentVO> create(@PathVariable Long articleId, @RequestBody CommentVO vo) {
		log.info("CommentApiController의 create() 메소드 실행");
//		log.info("articleId: {}, vo: {}", articleId, vo);
//		댓글을 저장하는 service 클래스의 메소드 실행한다.
		CommentVO created = commentService.create(articleId, vo);
//		저장된 댓글을 json으로 리턴한다.
		return ResponseEntity.status(HttpStatus.OK).body(created);
	}
	
//	댓글 수정
//	Talend API Tester(PATCH) => http://localhost:9090/api/comments/1
//	Talend API body data
//	{
//		"id": 1,
//		"nickname": "탐크루즈",
//		"body": "미션임파서블",
//		"article_id": 5
//	}
	@PatchMapping("/api/comments/{id}")
	public ResponseEntity<CommentVO> update(@PathVariable Long id, @RequestBody CommentVO vo) {
		log.info("CommentApiController의 update() 메소드 실행");
//		log.info("id: {}, vo: {}", id, vo);
//		댓글을 수정하는 service 클래스의 메소드 실행한다.
		CommentVO updated = commentService.update(id, vo);
//		수정된 댓글을 json으로 리턴한다.
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}
	
//	댓글 삭제
//	Talend API Tester(DELETE) => http://localhost:9090/api/comments/1
	@DeleteMapping("/api/comments/{id}")
	public ResponseEntity<CommentVO> delete(@PathVariable Long id) {
		log.info("CommentApiController의 delete() 메소드 실행");
		log.info("id: {}", id);
//		댓글을 삭제하는 service 클래스의 메소드 실행한다.
		CommentVO deleted = commentService.delete(id);
//		삭제된 댓글을 json으로 리턴한다.
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	}
	
}














