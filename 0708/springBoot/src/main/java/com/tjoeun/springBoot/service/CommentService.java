package com.tjoeun.springBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.springBoot.dto.CommentVO;
import com.tjoeun.springBoot.entity.Article;
import com.tjoeun.springBoot.entity.Comment;
import com.tjoeun.springBoot.repository.ArticleRepository;
import com.tjoeun.springBoot.repository.CommentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommentService {

//	ArticleRepository와 CommentRepository 클래스의 메소드를 사용하기 위해 ArticleRepository 클래스와
//	CommentRepository 클래스의 bean을 가져온다.
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CommentRepository commentRepository;
	
//	댓글 목록 조회
	public List<CommentVO> comments(Long articleId) {
		log.info("CommentService의 comments() 메소드 실행");
		
		/*
//		댓글 목록을 얻어온다.
		List<Comment> comments = commentRepository.findByArticleId(articleId);
//		댓글 목록 Entity 들을 VO로 변환한다.
		List<CommentVO> list = new ArrayList<CommentVO>();
//		for (int i=0; i < comments.size(); i++) {
//			Comment comment = comments.get(i);
//			// Entity를 VO로 변환하는 메소드를 호출한다.
//			CommentVO vo = CommentVO.createCommentVO(comment);
//			list.add(vo);
//		}
		for (Comment comment : comments) {
			CommentVO vo = CommentVO.createCommentVO(comment);
			list.add(vo);
		}
		
//		댓글 목록을 리턴한다.
		return list;
		*/
		
//		stream 활용
		return commentRepository.findByArticleId(articleId)
				.stream()
				.map(comment -> CommentVO.createCommentVO(comment))
				.collect(Collectors.toList());
	}

//	댓글 저장
//	댓글 저장에 실패하면 실행 전 상태로 되돌려야 하므로 트랜잭션 처리를 한다.
	@Transactional
	public CommentVO create(Long articleId, CommentVO vo) {
		log.info("CommentService의 create() 메소드 실행");
		log.info("articleId: {}, vo: {}", articleId, vo);
		
//		댓글을 저장하려는 메인글이 있나 확인해서 없으면 예외를 발생시킨다.
		Article article = articleRepository.findById(articleId).orElseThrow(
			() -> new IllegalArgumentException("댓글 저장 실패!! 대상 댓글이 없습니다.")	
		);
		
//		댓글 Entity를 만든다.
//		CommentVO를 Entity(Comment)로 변환하는 메소드를 호출한다.
		Comment comment = Comment.createComment(vo, article);
//		댓글 Entity를 데이터베이스에 저장한다.
		Comment created = commentRepository.save(comment);
		
//		Entity를 CommentVO로 변경해서 리턴한다.
		CommentVO commentVO = CommentVO.createCommentVO(created);
		log.info("articleId: {}, vo: {}", articleId, commentVO);
		return commentVO;
	}

//	댓글 수정
	@Transactional
	public CommentVO update(Long id, CommentVO vo) {
		log.info("CommentService의 update() 메소드 실행");
		
//		수정할 댓글이 없으면 예외를 발생시킨다.
		Comment comment = commentRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("댓글 수정 실패!! 대상 댓글이 없습니다.")	
		);
		
//		댓글을 수정하는 메소드를 호출한다.
		comment.patch(vo);
//		수정된 댓글로 데이터베이스를 갱신한다.
		Comment updated = commentRepository.save(comment);
		
//		수정된 댓글 Entity를 CommentVO로 변환해서 반환한다.
		return CommentVO.createCommentVO(updated);
	}

//	댓글 삭제
	@Transactional
	public CommentVO delete(Long id) {
		log.info("CommentService의 delete() 메소드 실행");
		
//		삭제할 댓글이 없으면 예외를 발생시킨다.
		Comment comment = commentRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("댓글 삭제 실패!! 대상 댓글이 없습니다.")	
		);
		
//		댓글을 삭제하고 삭제된 댓글을 CommentVO로 변환해서 리턴시킨다.
		commentRepository.delete(comment);
		return CommentVO.createCommentVO(comment);
	}

	
}














