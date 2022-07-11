package com.tjoeun.springBoot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tjoeun.springBoot.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommentVO {

	private Long id;
	@JsonProperty("article_id")
	private Long articleId;
	private String nickname;
	private String body;
	
//	Entity를 VO로 변환하는 메소드
	public static CommentVO createCommentVO(Comment comment) {
		return new CommentVO(
			comment.getId(), comment.getArticle().getId(), comment.getNickname(), comment.getBody()
		);
	}
	
}




