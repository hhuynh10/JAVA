package com.codingdojo.human;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HumanController {
	@RequestMapping("/")
	public String hello(@RequestParam(value="name", required=false) String searchQuery, @RequestParam(value="last_name", required=false) String searchQuery1, @RequestParam(value="times", required=false) int searchQuery2) {
		if (searchQuery == null && searchQuery1 == null && searchQuery2 == 0) {
			return "Hello Human";
		} else {
			return ("Hello " + searchQuery + " " + searchQuery1 + " ").repeat(searchQuery2);
		}
	}
}
