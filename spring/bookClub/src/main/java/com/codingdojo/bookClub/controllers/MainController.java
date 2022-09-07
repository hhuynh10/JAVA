package com.codingdojo.bookClub.controllers;

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

import com.codingdojo.bookClub.models.Book;
import com.codingdojo.bookClub.models.LoginUser;
import com.codingdojo.bookClub.models.User;
import com.codingdojo.bookClub.services.BookService;
import com.codingdojo.bookClub.services.UserService;


@Controller
public class MainController {
	@Autowired
    private UserService userServ;
   
	@Autowired
    private BookService bookServ;
	
   @GetMapping("/")
   public String index(Model model) {
       model.addAttribute("newUser", new User());
       model.addAttribute("newLogin", new LoginUser());
       return "index.jsp";
   }
   
   @PostMapping("/register")
   public String register(@Valid @ModelAttribute("newUser") User newUser, 
           BindingResult result, Model model, HttpSession session) {
       
   	User user = userServ.register(newUser, result);
		
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/books";
	}
   
   @PostMapping("/login")
   public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
           BindingResult result, Model model, HttpSession session) {
       
   		User user = userServ.login(newLogin, result);
  	 
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "index.jsp";
	    }
	     
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/books";
	}
   
   @GetMapping("/books")
	public String welcome(HttpSession session, Model model) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("books", bookServ.allBooks());
	    return "dashboard.jsp";
	    
	}
   
   @GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
	    return "redirect:/";
	}
   
   @GetMapping("/books/new")
	public String newBook(HttpSession session, Model model, @ModelAttribute("book") Book book) {
	   if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		return "new_book.jsp";
	}
   
   @PostMapping("/books/new")
   public String createNinja(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
       if (result.hasErrors()) {
           return "new_book.jsp";
       } else {
    	   bookServ.createBook(book);
           return "redirect:/books";
       }
   }
   
   @GetMapping("/books/{id}")
	public String view(HttpSession session, @PathVariable("id") Long id, Model model) {
	   if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("book", bookServ.findBook(id));
       return "view_book.jsp";
	}
   
   @RequestMapping("/books/delete/{id}")
   public String delete(HttpSession session, @PathVariable("id") Long id) {
	   if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
	   
	   bookServ.deleteBook(id);
       return "redirect:/books";
   }
   
   @GetMapping("/books/edit/{id}")
   public String edit(HttpSession session, @PathVariable("id") Long id, Model model) {
	   if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
	   
	   Book book = bookServ.findBook(id);
       model.addAttribute("book", book);
       return "edit_book.jsp";
	}
	
   @PutMapping("/books/edit/{id}")
   public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
       if (result.hasErrors()) {
           return "edit_book.jsp";
       } else {
    	   bookServ.updateBook(book);
           return "redirect:/books";
       }
   }
   
   @GetMapping("/bookmarket")
	public String bookmarket(HttpSession session, Model model) {
	 
	   if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		
		model.addAttribute("user", userServ.findById(userId));

		List<Book> books = bookServ.unborrowedBooks(userServ.findById(userId));
		model.addAttribute("books", books);

		List<Book> myBooks = bookServ.borrowedBooks(userServ.findById(userId));
		model.addAttribute("myBooks", myBooks);
		 
		return "bookmarket.jsp";
	}
   
   @RequestMapping("/bookmarket/{bookID}")
	public String borrowBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	   if(session.getAttribute("userId") == null) {
		   return "redirect:/logout";
	   }
	 
		Long userId = (Long) session.getAttribute("userId");
		bookServ.addBorrower(bookServ.findBook(bookID), userServ.findById(userId));
		 
		return "redirect:/bookmarket";
	}
	
	@RequestMapping("/bookmarket/return/{bookID}")
	public String returnBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		bookServ.removeBorrower(bookServ.findBook(bookID));
		 
		return "redirect:/bookmarket";
	}
}
