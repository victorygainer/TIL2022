package com.tjoeun.springBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tjoeun.springBoot.dto.CommentVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // JPA를 이용한 Entity
@NoArgsConstructor // 롬복을 이용한 기본 생성자
@AllArgsConstructor // 롬복을 이용한 모든 필드를 초기화시키는 생성자
@Getter
@Setter
@ToString
public class Comment {

	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 시퀀스를 데이터베이스가 자동으로 증가시킨다.
	private Long id;
	@ManyToOne // 댓글 Entity 여러개가 한개의 메인글(Article)에 연관된다. 관계 설정
	@JoinColumn(name = "article_id") // article_id 컬럼에 Article의 대표값(기본키)을 저장한다. 외래키
	private Article article; // 어떤 메인글의 댓글인가를 저장한다. 
	@Column
	private String nickname;
	@Column
	private String body;
	
	/*
	public Comment() { }
	public Comment(Long id, Article article, String nickname, String body) {
		this.id = id;
		this.article = article;
		this.nickname = nickname;
		this.body = body;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", article=" + article + ", nickname=" + nickname + ", body=" + body + "]";
	}
	*/
	
//	CommentVO를 Entity(Comment)로 변환하는 메소드(댓글, 메인글)
	public static Comment createComment(CommentVO vo, Article article) {
//		댓글의 id는 데이터베이스가 자동으로 붙이기 때문에 댓글의 id가 넘어오면 예외를 발생시킨다.
		if (vo.getId() != null) {
			throw new IllegalArgumentException("댓글 저장 실패!! 댓글의 id가 없어야 합니다.");
		}
//		컨트롤러에 요청되는 id({articleId})와 body data의 id(article_id)가 다르면 예외를 발생시킨다.
		if (vo.getArticleId() != article.getId()) {
			throw new IllegalArgumentException("댓글 저장 실패!! 메인글의 id가 잘못되었습니다.");
		}
//		CommentVO를 Entity로 변환
		return new Comment(vo.getId(), article, vo.getNickname(), vo.getBody());
	}

//	댓글을 수정하는 메소드
	public void patch(CommentVO vo) {
//		댓글을 수정하기 위해 요청한 id가 데이터베이스에 저장된 댓글 id와 다를 경우 예외를 발생시킨다.
		if (this.id != vo.getId()) {
			throw new IllegalArgumentException("댓글 수정 실패!! 잘못된 댓글 id 입니다.");
		}
//		댓글을 수정한다. 수정할 내용이 넘어오지 않았으면 기존 내용을 유지한다.
		if (vo.getNickname() != null) {
			this.nickname = vo.getNickname();
		}
		if (vo.getBody() != null) {
			this.body = vo.getBody();
		}
	}
	
}












