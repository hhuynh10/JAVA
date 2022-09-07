package com.codingdojo.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/login")
	public String login(
			@RequestParam(value="number") String number,
			@RequestParam(value="city") String city,
			@RequestParam(value="name") String name,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="type") String type,
			@RequestParam(value="nice") String nice,
			HttpSession session
			){
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("type", type);
		session.setAttribute("nice", nice);
		return "redirect:/view";
	}
	
	@RequestMapping("/view")
	public String view() {
		return "view.jsp";
	}
}
