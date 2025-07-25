package com.yoy.basicwebform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yoy.basicwebform.entity.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController 
{
//	@Autowired
//	private User user ; // for 3rd way
	
	@GetMapping("/aboutus")
	public String openAboutUs() {
		return "aboutus" ;
	}
	
	@GetMapping("/basicform")
	public String openBasicForm() {
		return "basicform" ;
	}
	
//	----- 1. HTTP SERVLET REQUEST -----
//	@PostMapping("/profile")
//	public String openProfilePage(HttpServletRequest request) { 
//		String name = request.getParameter("name") ;
//		String email = request.getParameter("email") ;
//		String mobile = request.getParameter("mobile") ;
//		System.out.println(name + " , " + email + " , " + mobile);
//		request.setAttribute("name", name);
//	    request.setAttribute("email", email);
//	    request.setAttribute("mobile", mobile);
//		return "profile" ;
//	}
	
//	----- 2. MODEL INTERFACE -----
//	@PostMapping("/profile")
//	public String openProfilePage (
//			@RequestParam("name") String reqname ,
//			@RequestParam("email") String reqemail ,
//			@RequestParam("mobile") String reqmobile,
//			Model model
//			) {
//		System.out.println(reqname + " , " + reqemail + " , " + reqmobile);
//		model.addAttribute("model_name", reqname) ;
//		model.addAttribute("model_email", reqemail) ;
//		model.addAttribute("model_mobile", reqmobile) ;
//		return "profile" ;
//	}
	
//	----- 3. MODEL INTERFACE + ENTITY OBJECT -----
//	@PostMapping("/profile")
//	public String openProfilePage (
//			@RequestParam("name") String reqname ,
//			@RequestParam("email") String reqemail ,
//			@RequestParam("mobile") String reqmobile,
//			Model model
//			) {
//		System.out.println(reqname + " , " + reqemail + " , " + reqmobile);
//		user.setName(reqname) ; user.setEmail(reqemail) ; user.setMobile(reqmobile) ;
//		model.addAttribute("model_user", user) ;
//		return "profile" ;
//	}
	
//	----- 4. MODEL ATTRIBUTE -----
	@PostMapping("/profile")
	public String openProfilePage (
			@ModelAttribute User user 
			) {
		System.out.println(user.getName() + " , " + user.getMobile() + " , " + user.getEmail());
		return "profile" ;
	}
	
}
