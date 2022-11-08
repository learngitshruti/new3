package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Book;
import com.demo.repository.bookdao;

@Service
public class Bookservice {

	@Autowired
	private bookdao bookdao;
	
	public Book addBook(Book book) {
		return bookdao.save(book);
		
	}

	public Optional<Book> getbook(int id) {
		return bookdao.findById(id);
		
	}

	
	public void delete(int id) {
		bookdao.deleteById(id);
	}
	
	public void updated(String name , int id) {
		bookdao.updated(name, id);
	}
  
	public List<Book> getal() {
		return bookdao.findAll();
	}
}
