package com.codingdojo.bike.controllers;

import java.util.List;

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

import com.codingdojo.bike.models.Bike;
import com.codingdojo.bike.models.LoginUser;
import com.codingdojo.bike.models.User;
import com.codingdojo.bike.services.BikeService;
import com.codingdojo.bike.services.UserService;

@Controller
public class MainController {
	@Autowired
    private UserService userServ;
	
	@Autowired
    private BikeService bikeServ;
	
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
		 
		    return "redirect:/dashboard";
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
		 
		    return "redirect:/dashboard";
		}
	   
	   @GetMapping("/logout")
		public String logout(HttpSession session) {
			session.removeAttribute("userId");
		    return "redirect:/";
		}
	   
	   @GetMapping("/dashboard")
		public String welcome(HttpSession session, Model model) {
		 
			if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.findById(userId));
			model.addAttribute("bikes", bikeServ.allBikes());
			
			List<Bike> bikes = bikeServ.unjoinedBuyers(userServ.findById(userId));
			model.addAttribute("bikes", bikes);

			List<Bike> myBikes = bikeServ.joinedBuyers(userServ.findById(userId));
			model.addAttribute("myBikes", myBikes);
		    return "dashboard.jsp";
		    
		}
	   
	   @GetMapping("/bikes/add")
		public String newProject(HttpSession session, Model model, @ModelAttribute("bike") Bike bike) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
		   model.addAttribute("users", userServ.allUsers());
			return "add_bike.jsp";
		}
	   
	   @PostMapping("/bikes/add")
	   public String createProject(@Valid @ModelAttribute("bike") Bike bike, BindingResult result, Model model) {
	       if (result.hasErrors()) {
	           return "add_bike.jsp";
	       } else {
	    	   bikeServ.addBike(bike);
	           return "redirect:/dashboard";
	       }
	   }
	   
	   @RequestMapping("/bikes/delete/{id}")
	   public String delete(HttpSession session, @PathVariable("id") Long id) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
		   
		   bikeServ.deleteBike(id);
	       return "redirect:/dashboard";
	   }
	   
	   @GetMapping("/checkout")
		public String Checkout(HttpSession session, Model model) {
		 
			if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.findById(userId));
			
			List<Bike> bikes = bikeServ.unjoinedBuyers(userServ.findById(userId));
			model.addAttribute("bikes", bikes);

			List<Bike> myBikes = bikeServ.joinedBuyers(userServ.findById(userId));
			model.addAttribute("myBikes", myBikes);
		    return "checkout.jsp";
		    
		}
	   
	   @RequestMapping("/checkout/{buyerID}")
		public String buy(@PathVariable("buyerID") Long buyerID, HttpSession session) {
		   if(session.getAttribute("userId") == null) {
			   return "redirect:/logout";
		   }
		 
			Long userId = (Long) session.getAttribute("userId");
			bikeServ.buyBike(bikeServ.findBike(buyerID), userServ.findById(userId));
			 
			return "redirect:/checkout";
		}
	   
	   @RequestMapping("/checkout/return/{buyerID}")
		public String returnBike(@PathVariable("buyerID") Long buyerID, HttpSession session) {
		 
			if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			bikeServ.sellBike(bikeServ.findBike(buyerID));
			 
			return "redirect:/checkout";
		}
	   
	   @GetMapping("/bikes/edit/{id}")
	   public String edit(HttpSession session, @PathVariable("id") Long id, Model model) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
		   
		   Bike bike = bikeServ.findBike(id);
	       model.addAttribute("bike", bike);
	       return "customize_bike.jsp";
		}
	   
	   @PutMapping("/bikes/edit/{id}")
	   public String update(@Valid @ModelAttribute("bike") Bike bike, BindingResult result) {
	       if (result.hasErrors()) {
	           return "customize_bike.jsp";
	       } else {
	    	   bikeServ.updateBike(bike);
	           return "redirect:/checkout";
	       }
	   }
	   
	   @GetMapping("/bikes/{id}")
		public String view(HttpSession session, @PathVariable("id") Long id, Model model) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.findById(userId));
			model.addAttribute("bike", bikeServ.findBike(id));
	       return "view_bike.jsp";
		}
}
