package com.yoy.basicwebform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String openProfilePage (
			@RequestParam("name") String reqname ,
			@RequestParam("email") String reqemail ,
			@RequestParam("mobile") String reqmobile,
			Model model
			) {
//		@RequestParam is an alternative for httpsrvltreq.getParameter
//		Model interface allow controller to send data to view page , it act as a container for attribute
//		Model ko explicitly return me likhne ki zarurat nahi wah automatically response me include ho jayega 
		System.out.println(reqname + " , " + reqemail + " , " + reqmobile);
		model.addAttribute("model_name", reqname) ;
		model.addAttribute("model_email", reqemail) ;
		model.addAttribute("model_mobile", reqmobile) ;
		return "profile" ;
	}
	
}
