package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/loginForm")
	public String getLogin() {
		return "loginForm";
	}

	//	@GetMapping("/loginFrom")
	//	public String getLogin(Model model, @AuthenticationPrincipal LoginUser loginUser) {
	//		model.addAttribute("users",loginUser.getUser());
	//		return "loginForm";
	//	}

}
