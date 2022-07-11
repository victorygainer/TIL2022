package com.tjoeun.springBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//	JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 어노테이션을 붙여서 선언해야 하고 Entity라 부른다.
//	@Entity 어노테이션이 붙은 클래스 이름으로 springboot가 자동으로 테이블을 만들고 클래스 내부에 선언한
//	필드 이름으로 테이블을 구성하는 컬럼을 만들어준다.

@Entity // 현재 클래스는 Entity로 사용되는 클래스임을 알려준다.
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Article {

//	기본키로 사용할 필드 선언
//	기본키를 자동으로 생성하려면 @Id와 @GeneratedValue 어노테이션을 함께 사용해야 한다.
	@Id // 필드를 기본키로 설정한다.
//	@GeneratedValue // 기본키 값을 자동으로 생성한다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스를 자동으로 증가시켜 기본키 값을 생성한다.
	private Long id; // 기본키 속성을 가지는 필드는 Long 랩퍼 클래스 타입으로 선언한다.
	@Column // 필드를 테이블의 컬럼과 매핑한다.
	private String title;
	@Column
	private String content;
	
//	Entity 클래스에 기본 생성자가 없으면 에러가 발생된다.
//	public Article() { }
//	public Article(Long id, String title, String content) {
//		this.id = id;
//		this.title = title;
//		this.content = content;
//	}
	
//	Entity 클래스는 데이터 입출력에 사용하지 않기 때문에 getters & setters를 만들지 않아도 된다.
	
//	@Override
//	public String toString() {
//		return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
//	}
	
//	수정할 정보가 넘어오지 않은 경우 기존 데이터를 채워주는 메소드
	public void patch(Article article) {
//		수정할 내용 중 title이 있으면 수정할 원본을 수정한다.
		if (article.title != null) {
//			this.title: 수정할 내용, article.title: 수정할 정보
			this.title = article.title;
		}
//		수정할 내용 중 content가 있으면 수정할 원본을 수정한다.
		if (article.content != null) {
			this.content = article.content;
		}
		
	}
	
}
