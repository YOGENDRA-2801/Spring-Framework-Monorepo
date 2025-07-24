package com.yoy.basicwebform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController 
{
	@GetMapping("/aboutus")
	public String openAboutUs() {
		return "aboutus" ;
	}
	
	@GetMapping("/basicform")
	public String openBasicForm() {
		return "basicform" ;
	}
	
	@PostMapping("/profile")
	public String openProfilePage(HttpServletRequest request) {
		
		String name = request.getParameter("name") ;
		String email = request.getParameter("email") ;
		String mobile = request.getParameter("mobile") ;
		
		System.out.println(name + " , " + email + " , " + mobile);
		
		return "profile" ;
	}
}
