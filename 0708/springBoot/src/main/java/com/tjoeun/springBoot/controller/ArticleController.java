package com.tjoeun.springBoot.controller;

import java.util.List;

import com.tjoeun.springBoot.dto.CommentVO;
import com.tjoeun.springBoot.repository.CommentRepository;
import com.tjoeun.springBoot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tjoeun.springBoot.dto.ArticleForm;
import com.tjoeun.springBoot.entity.Article;
import com.tjoeun.springBoot.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // 롬복에서 지원하는 로그 출력 어노테이션
public class ArticleController {

//	JPA repository 인터페이스(ArticleRepository) 객체를 선언하고 @Autowired 어노테이션으로 초기화 한다.
	@Autowired // springboot가 미리 생성해놓은 객체(bean)을 가져다 자동으로 연결한다.
	private ArticleRepository articleRepository;

//	댓글 목록을 가져오기 위해 CommentService 클래스의 bean을 가져온다.
	@Autowired
	private CommentService commentService;
	
//	글 입력 폼을 브라우저에 나타낸다.
	@GetMapping("/articles/new")
	public String newArticleForm() {
//		System.out.println("ArticleController의 newArticleForm() 메소드 실행");
//		@Slf4j 어노테이션 로그 레벨, ()안에는 반드시 문자열만 사용할 수 있다.
//		log.trace(): 가장 자세한 로그
//		log.warn(): 경고 로그
//		log.info(): 정보성 로그
//		log.debug(): 디버깅용 로그
//		log.error(): 에러 로그
		log.info("ArticleController의 newArticleForm() 메소드 실행");
		
		return "articles/new";
	}
	
//	폼에 입력한 데이터를 데이터베이스 테이블에 저장한다.
	@PostMapping("/articles/create")
//	form에서 넘어오는 데이터는 커맨드 객체로 받는다.
	public String createArticle(ArticleForm form) {
//		System.out.println("ArticleController의 createArticle() 메소드 실행");
		log.info("ArticleController의 createArticle() 메소드 실행");
//		System.out.println(form);
//		log.info(form.toString());
		
//		form에 입력된 데이터를 받아 데이터베이스에 저장하는 코드를 추가한다.
//		DTO 데이터를 Entity로 변환한다.
		Article articleEntity = form.toEntity();
//		System.out.println(articleEntity);
//		log.info(articleEntity.toString());
//		repository에게 Entity를 데이터베이스에 저장하게 한다.
//		id가 자동으로 생성된다.
		Article saved = articleRepository.save(articleEntity);
//		System.out.println(saved);
//		log.info(saved.toString());
//		log.info(saved.getId().toString());
		
//		입력한 글이 화면에 표시되도록 redirect를 이용해서 show() 메소드를 호출한다.
		return "redirect:/articles/" + saved.getId();
	}
	
//	데이터베이스 테이블에서 글 1건을 얻어와 브라우저에 나타낸다.
//	브라우저에서 "/articles/글번호" 형태의 요청을 받아 처리한다.
//	{}는 변경되는 "/articles/1", "/articles/2", ...와 같이 변화되는 데이터를 받는다는 의미이다.
	@GetMapping("/articles/{id}")
//	{}를 통해서 받는 데이터를 저장할 변수는 @PathVariable 어노테이션을 붙여서 선언한다.
	public String show(@PathVariable Long id, Model model) {
		log.info("ArticleController의 show() 메소드 실행");
//		log.info("id: " + id);
		
//		articleRepository의 findById() 메소드로 id에 해당되는 데이터 1건을 테이블에서 가져온다.
//		findById() 메소드로 얻어온 데이터가 없으면 orElse() 메소드로 null을 리턴시킨다.
		Article articleEntity = articleRepository.findById(id).orElse(null);
//		try {
//			log.info(articleEntity.toString());
//		} catch (NullPointerException e) {
//			log.info("글번호에 해당되는 글이 테이블에 없습니다.");
//		}
//		findById() 메소드로 테이블에서 얻어온 데이터를 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("article", articleEntity);

//		댓글 목록을 가져온다.
		List<CommentVO> commentList = commentService.comments(id);
//		댓글 목록을 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("commentList", commentList);

		return "articles/show"; // viewpage를 지정한다.
	}
	
//	데이터베이스 테이블에서 전체 글 목록을 얻어온다.
	@GetMapping("/articles")
	public String index(Model model) {
		log.info("ArticleController의 index() 메소드 실행");
		
//		articleRepository의 findAll() 메소드로 테이블에 저장된 모든 데이터를 가져온다.
		List<Article> articleEntityList = articleRepository.findAll();
//		log.info(articleEntityList.toString());
//		findAll() 메소드로 테이블에서 얻어온 데이터를 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("articleList", articleEntityList);
		
		return "articles/index";
	}
	
//	글 수정 폼을 브라우저에 나타낸다.
	@GetMapping("/articles/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		log.info("ArticleController의 edit() 메소드 실행");
//		log.info("id: " + id);
		
//		수정할 데이터를 테이블에서 가져온다.
		Article articleEntity = articleRepository.findById(id).orElse(null);
//		가져온 데이터를 Model 객체에 넣어준다.
		model.addAttribute("article", articleEntity);
		
		return "/articles/edit";
	}
	
//	글 1건을 수정한다.
	@PostMapping("/articles/update")
//	form에서 넘어오는 데이터 전체를 받기 위해 커맨드 객체를 사용해서 받는다.
	public String update(ArticleForm form) {
		log.info("ArticleController의 update() 메소드 실행");
//		log.info(form.toString());
		
//		DTO를 Entity로 변환한다.
		Article articleEntity = form.toEntity();
//		log.info(articleEntity.toString());
//		데이터베이스에 저장된 수정할 데이터를 얻어와서 Entity로 수정해서 데이터베이스에 저장한다.
		Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
		if (target != null) {
			articleRepository.save(articleEntity);
		}
		
//		수정 결과를 확인할 수 있는 페이지로 리다이렉트 한다.
		return "redirect:/articles/" + articleEntity.getId();
	}
	
	@GetMapping("/articles/{id}/delete")
//	RedirectAttributes 인터페이스 객체는 뷰 페이지로 1회성 메시지 전달에 사용한다.
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		log.info("ArticleController의 delete() 메소드 실행");
		
//		삭제할 데이터를 가져온다.
		Article target = articleRepository.findById(id).orElse(null);
//		log.info(target.toString());
//		데이터를 삭제한다.
		if (target != null) {
			articleRepository.delete(target);
//			addFlashAttribute(): 1회성으로 1번만 사용할 메시지를 뷰 페이지로 전달한다.
			redirectAttributes.addFlashAttribute("msg", id + "번 글 삭제완료!!!");
		}
		
//		목록보기 페이지로 리다이렉트 한다.
		return "redirect:/articles";
	}
	
}
