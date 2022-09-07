package com.codingdojo.jstl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "Sara");
		return "index.jsp";
	}
}
