package com.codingdojo.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("") 
	public String hello() {
		return "demo.jsp";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "Cool Cool";
	}
}
