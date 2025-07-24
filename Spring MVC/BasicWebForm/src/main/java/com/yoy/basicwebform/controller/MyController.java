package com.yoy.basicwebform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController 
{
	@GetMapping("/aboutus")
	public String openAboutUs() {
		return "aboutus" ;
	}
}
