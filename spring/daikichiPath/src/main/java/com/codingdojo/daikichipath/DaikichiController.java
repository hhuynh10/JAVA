package com.codingdojo.daikichipath;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("/travel/{city}")
	public String showCity(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city;
	}
	
	@RequestMapping("/lotto/{num}")
	public String showLotto(@PathVariable("num") int num) {
		if (num % 2 == 0) {
			return "You will take a grand journey in the future, but be wary of tempting offers";
		}
		if (num % 2 != 0) {
			return "You have enjoyed the fruits of your labor, now it's time to spend time with your family and friends";
		}
		return null;
	}
}
