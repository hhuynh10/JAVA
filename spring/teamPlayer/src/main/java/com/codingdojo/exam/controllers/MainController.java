package com.codingdojo.exam.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.exam.models.LoginUser;
import com.codingdojo.exam.models.Player;
import com.codingdojo.exam.models.Team;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.services.PlayerService;
import com.codingdojo.exam.services.TeamService;
import com.codingdojo.exam.services.UserService;

@Controller
public class MainController {
	@Autowired
    private UserService userServ;
	
	@Autowired
    private TeamService teamServ;
	
	@Autowired
    private PlayerService playerServ;
	
	@GetMapping("/")
	   public String index(Model model) {
	       model.addAttribute("newUser", new User());
	       model.addAttribute("newLogin", new LoginUser());
	       return "registration.jsp";
	   }
	   
	   @PostMapping("/register")
	   public String register(@Valid @ModelAttribute("newUser") User newUser, 
	           BindingResult result, Model model, HttpSession session) {
	       
	   	User user = userServ.register(newUser, result);
			
		    if(result.hasErrors()) {
		        model.addAttribute("newLogin", new LoginUser());
		        return "registration.jsp";
		    }
		    
		    session.setAttribute("userId", user.getId());
		 
		    return "redirect:/home";
		}
	   
	   @PostMapping("/login")
	   public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	           BindingResult result, Model model, HttpSession session) {
	       
	   		User user = userServ.login(newLogin, result);
	  	 
		    if(result.hasErrors() || user==null) {
		        model.addAttribute("newUser", new User());
		        return "registration.jsp";
		    }
		     
		    session.setAttribute("userId", user.getId());
		 
		    return "redirect:/home";
		}
	   
	   @GetMapping("/logout")
		public String logout(HttpSession session) {
			session.removeAttribute("userId");
		    return "redirect:/";
		}
	   
	   @GetMapping("/home")
		public String welcome(HttpSession session, Model model) {
		 
			if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.findById(userId));
			model.addAttribute("teams", teamServ.allTeams());
			
		    return "home.jsp";
		    
		}
	   
	   @GetMapping("/teams/new")
		public String newTeam(HttpSession session, Model model, @ModelAttribute("team") Team team) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			return "new_team.jsp";
		}
	   
	   @PostMapping("/teams/new")
	   public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model) {
	       if (result.hasErrors()) {
	           return "new_team.jsp";
	       } else {
	    	   teamServ.createTeam(team);
	           return "redirect:/home";
	       }
	   }
	   
	   @GetMapping("/teams/{id}")
		public String view(HttpSession session, @PathVariable("id") Long id, Model model, @ModelAttribute("player") Player player ) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.findById(userId));
			model.addAttribute("team", teamServ.findTeam(id));
			model.addAttribute("players", playerServ.allPlayers());
	       return "view_team.jsp";
		}
	   
	   @PostMapping("/players/new")
	   public String createPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result, Model model, HttpServletRequest request) {
	       if (result.hasErrors()) {
	           return "add_player.jsp";
	       } else {
	    	   playerServ.createPlayer(player);
	           return "redirect:" + request.getHeader("Referer");
	       }
	   }
	   
	   @RequestMapping("/teams/delete/{id}")
	   public String delete(HttpSession session, @PathVariable("id") Long id) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
		   
		   teamServ.deleteTeam(id);
	       return "redirect:/home";
	   }
	   
	   @GetMapping("/teams/edit/{id}")
	   public String edit(HttpSession session, @PathVariable("id") Long id, Model model) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
		   
		   Team team = teamServ.findTeam(id);
	       model.addAttribute("team", team);
	       return "edit_team.jsp";
		}
	   
	   @PutMapping("/teams/edit/{id}")
	   public String update(@Valid @ModelAttribute("team") Team team, BindingResult result) {
	       if (result.hasErrors()) {
	           return "edit_team.jsp";
	       } else {
	    	   teamServ.updateTeam(team);
	           return "redirect:/home";
	       }
	   }
}
