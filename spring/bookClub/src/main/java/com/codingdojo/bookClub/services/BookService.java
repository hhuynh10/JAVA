package com.codingdojo.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookClub.models.Book;
import com.codingdojo.bookClub.models.User;
import com.codingdojo.bookClub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
    private BookRepository bookRepo;
	
	public List<Book> allBooks() {
        return bookRepo.findAll();
    }
	
	public List<Book> unborrowedBooks(User user){
		return bookRepo.findByBorrowerIdIsOrUserIdIs(null, user.getId());
	}
	
	public List<Book> borrowedBooks(User user){
		return bookRepo.findByBorrowerIdIs(user.getId());
	}
	
	public List<Book> myBooks(User user){
		return bookRepo.findByUserIdIs(user.getId());
	}
	
	public Book createBook(Book b) {
        return bookRepo.save(b);
    }
	
	public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
    
    public void deleteBook(Long id) {
    	bookRepo.deleteById(id);
    }
    
    public void removeBorrower(Book book) {
		book.setBorrower(null);
		bookRepo.save(book);
	}
	
	public void addBorrower(Book book, User user) {
		book.setBorrower(user);
		bookRepo.save(book);
	}
}
