package com.ironman.marondalgram.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("join-view")
	public String join() {
		return "user/join";
	}
	
	@GetMapping("login-view")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//세션에 저장한 사용자 정보 제거
		// userId, userName을 삭제하면 로그아웃되고, 로그인 화면으로 이동!!
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		return "redirect:/user/login-view";
		
	}
	
}
