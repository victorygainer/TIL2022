package com.tjoeun.springBoot.dto;

import com.tjoeun.springBoot.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//	@NoArgsConstructor: 기본 생성자 자동완성
//	@AllArgsConstructor: 모든 필드를 사용하는 생성자 자동완성
//	@Getter: getter 메소드 자동완성
//	@Setter: setter 메소드 자동완성
//	@Getter, @Setter 어노테이션을 클래스 이름 위에 사용하면 모든 필드의 getter와 setter 메소드를
//	자동으로 완성하고 특정 필드 이름 위에 사용하면 특정 필드에만 적용된다.
//	@ToString: toString() 메소드 자동완성
//	@EqualsAndHashCode: equals() 메소드와 hashcode() 메소드 자동완성
//	@Data: @Getter, @Setter, @ToString, @EqualsAndHashCode 자동완성

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ArticleForm {

	private Long id; // id 필드 추가
	private String title;
	private String content;
	
//	public ArticleForm() { }
//	public ArticleForm(String title, String content) {
//		this.title = title;
//		this.content = content;
//	}
	
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
	
//	@Override
//	public String toString() {
//		return "ArticleForm [title=" + title + ", content=" + content + "]";
//	}
	
//	DTO 데이터를 Entity(테이블과 매핑되는 클래스)로 변환하는 메소드
	public Article toEntity() {
//		return new Article(null, title, content);
//		추가된 id 필드로 Entity를 초기화 할 수 있다록 수정한다.
		return new Article(id, title, content);
	}
	
}
