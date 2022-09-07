package com.codingdojo.projectManager.controllers;

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

import com.codingdojo.projectManager.models.LoginUser;
import com.codingdojo.projectManager.models.Project;
import com.codingdojo.projectManager.models.User;
import com.codingdojo.projectManager.services.ProjectService;
import com.codingdojo.projectManager.services.UserService;



@Controller
public class MainController {
	@Autowired
    private UserService userServ;
	
	@Autowired
    private ProjectService projectServ;
	
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
			model.addAttribute("projects", projectServ.allProjects());
			
			List<Project> projects = projectServ.unjoinedTeams(userServ.findById(userId));
			model.addAttribute("projects", projects);

			List<Project> myProjects = projectServ.joinedTeams(userServ.findById(userId));
			model.addAttribute("myProjects", myProjects);
		    return "dashboard.jsp";
		    
		}
	   
	   @RequestMapping("/dashboard/{teamID}")
		public String joinTeams(@PathVariable("teamID") Long teamID, HttpSession session) {
		   if(session.getAttribute("userId") == null) {
			   return "redirect:/logout";
		   }
		 
			Long userId = (Long) session.getAttribute("userId");
			projectServ.joinTeam(projectServ.findProject(teamID), userServ.findById(userId));
			 
			return "redirect:/dashboard";
		}
	   
	   @RequestMapping("/dashboard/leave/{teamID}")
		public String leaveTeams(@PathVariable("teamID") Long teamID, HttpSession session) {
		 
			if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			projectServ.leaveTeam(projectServ.findProject(teamID));
			 
			return "redirect:/dashboard";
		}
	   
	   @GetMapping("/projects/new")
		public String newProject(HttpSession session, Model model, @ModelAttribute("project") Project project) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			return "new_project.jsp";
		}
	   
	   @PostMapping("/projects/new")
	   public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model) {
	       if (result.hasErrors()) {
	           return "new_project.jsp";
	       } else {
	    	   projectServ.createProject(project);
	           return "redirect:/dashboard";
	       }
	   }
	   
	   @GetMapping("/projects/{id}")
		public String view(HttpSession session, @PathVariable("id") Long id, Model model) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
			
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.findById(userId));
			model.addAttribute("project", projectServ.findProject(id));
	       return "view_project.jsp";
		}
	   
	   @RequestMapping("/projects/delete/{id}")
	   public String delete(HttpSession session, @PathVariable("id") Long id) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
		   
		   projectServ.deleteProject(id);
	       return "redirect:/dashboard";
	   }
	   
	   @GetMapping("/projects/edit/{id}")
	   public String edit(HttpSession session, @PathVariable("id") Long id, Model model) {
		   if(session.getAttribute("userId") == null) {
				return "redirect:/logout";
			}
		   
		   Project project = projectServ.findProject(id);
	       model.addAttribute("project", project);
	       return "edit_project.jsp";
		}
	   
	   @PutMapping("/projects/edit/{id}")
	   public String update(@Valid @ModelAttribute("project") Project project, BindingResult result) {
	       if (result.hasErrors()) {
	           return "edit_project.jsp";
	       } else {
	    	   projectServ.updateProject(project);
	           return "redirect:/dashboard";
	       }
	   }
}
