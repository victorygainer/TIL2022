package com.tjoeun.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 이 클래스는 컨트롤러로 사용되는 클래스임을 springBoot에게 알려준다.
public class FirstController {

//	브라우저에 "/hi"라는 요청이 들어오면 niceToMeetYou() 메소드가 실행된다.
	@GetMapping("/hi")
//	viewpage로 데이터를 넘길 때 사용할 Model 인터페이스 객체를 메소드의 인수로 넣어준다.
	public String niceToMeetYou(Model model) {
		System.out.println("컨트롤러의 niceToMeetYou() 메소드 실행");
//		Model 인터페이스 객체에 addAttribute() 메소드로 viewpage로 넘겨줄 데이터를 넣어준다.
		model.addAttribute("username", "홍길동");
		return "greetings"; // viewpage 이름
	}
	
	@GetMapping("/bye")
	public String byebye(Model model) {
		System.out.println("컨트롤러의 byebye() 메소드 실행");
		model.addAttribute("nickname", "도적넘");
		return "goodbye";
	}
	
}
