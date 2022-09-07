package com.codingdojo.gameWorkshop.controllers;

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

import com.codingdojo.gameWorkshop.models.Game;
import com.codingdojo.gameWorkshop.models.LoginUser;
import com.codingdojo.gameWorkshop.models.User;
import com.codingdojo.gameWorkshop.services.GameService;
import com.codingdojo.gameWorkshop.services.UserService;

@Controller
public class MainController {
	@Autowired
    private UserService userServ;
	
	@Autowired
    private GameService gameServ;
	
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
			model.addAttribute("games", gameServ.allGames());
			
		    return "home.jsp";
		}
	   
	   @GetMapping("/games/new")
		public String newGame(HttpSession session, Model model, @ModelAttribute("game") Game game) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			return "new_game.jsp";
		}
	   
	   @PostMapping("/games/new")
	   public String createGame(@Valid @ModelAttribute("game") Game game, BindingResult result, Model model) {
	       if (result.hasErrors()) {
	           return "new_game.jsp";
	       } else {
	    	   gameServ.createGame(game);
	           return "redirect:/home";
	       }
	   }
	   
	   @GetMapping("/games/{id}")
		public String view(HttpSession session, @PathVariable("id") Long id, Model model) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.findById(userId));
			model.addAttribute("game", gameServ.findGame(id));
	       return "view_game.jsp";
		}
	   
	   @RequestMapping("/games/delete/{id}")
	   public String delete(HttpSession session, @PathVariable("id") Long id) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
		   
		   gameServ.deleteGame(id);
	       return "redirect:/home";
	   }
	   
	   @GetMapping("/games/edit/{id}")
	   public String edit(HttpSession session, @PathVariable("id") Long id, Model model) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
		   
		   Game game = gameServ.findGame(id);
	       model.addAttribute("game", game);
	       return "edit_game.jsp";
		}
	   
	   @PutMapping("/games/edit/{id}")
	   public String update(@Valid @ModelAttribute("game") Game game, BindingResult result) {
	       if (result.hasErrors()) {
	           return "edit_game.jsp";
	       } else {
	    	   gameServ.updateGame(game);
	           return "redirect:/home";
	       }
	   }
}
