package com.tjoeun.springBoot.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//	REST api용 컨트롤러 @Controller 어노테이션이 아닌 @RestController 어노테이션으로 선언한다.
//	@Controller 어노테이션을 붙여서 선언한 컨트롤러는 뷰 페이지를 반환하지만 @RestController를
//	붙여서 선언한 컨트롤러는 JSON을 반환한다.
@RestController
public class ApiController {

	@GetMapping("/api/hello")
	public String hello() {
		return "hello world";
	}
	
}
