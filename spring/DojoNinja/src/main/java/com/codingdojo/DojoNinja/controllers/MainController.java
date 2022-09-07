package com.codingdojo.DojoNinja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.DojoNinja.models.Dojo;
import com.codingdojo.DojoNinja.models.Ninja;
import com.codingdojo.DojoNinja.services.DojoService;
import com.codingdojo.DojoNinja.services.NinjaService;


@Controller
public class MainController {
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String dashboard() {
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos")
	public String allExpenses(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "dashboard.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "new_dojo.jsp";
	}
	
	@PostMapping("/dojos/new")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new_dojo.jsp";
        } else {
        	dojoService.createDojo(dojo);
            return "redirect:/dojos";
        }
    }
	
	@GetMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "new_ninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("dojos", dojoService.allDojos());
            return "new_ninja.jsp";
        } else {
        	ninjaService.createNinja(ninja);
            return "redirect:/dojos";
        }
    }
	
	@GetMapping("/dojos/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "view_dojo.jsp";
	}
	
	@GetMapping("/dojos/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
		dojoService.deleteDojo(id);
        return "redirect:/";
	}
}
