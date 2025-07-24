package com.yoy.basicwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController1 {

//	@RequestMapping("/hello")
//	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	@GetMapping("/hello")
	public ModelAndView openHelloPage() {
		System.out.println("Handler method for openHelloPage executed");
		ModelAndView mav = new ModelAndView() ;
		mav.setViewName("hello") ;
//		ModelAndView mav = new ModelAndView("hello") ; // will return view name
		return mav ;
	}
	
	@GetMapping("/aboutus")
	public String openAboutusPage() {
//		If we are returning only view name then you can keep the return type as string which will be automatically be considered as view name
		System.out.println("Handler method for openAboutusPage executed");
		return "aboutus" ;
	}
}

// Aap "Package Explorer" view use kar rahe the, jisme kabhi-kabhi Java Resources folder explicitly dikhai nahi deta agar structure Maven ke through set hua ho.
// Solution: Try this: Go to: Window > Show View > Project Explorer
// "Project Explorer" zyada clean structure dikhata hai, aur wahan Java Resources, JavaScript Resources, etc. clearly visible hote hain.