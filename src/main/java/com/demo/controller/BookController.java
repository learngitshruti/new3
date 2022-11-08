package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Book;
import com.demo.service.Bookservice;



@RestController
public class BookController {
	
	@Autowired
	private Bookservice bookservice;

	@PostMapping("/addbook")
	public Book addbook(@RequestBody Book book) {
		System.out.println("controlleri5");
		System.out.println(book.toString());
		return bookservice.addBook(book);
	}
	
	@GetMapping("/book/{id}")
	public Optional<Book> getBook(@PathVariable  int id) {
		return bookservice.getbook(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		Optional<Book> bk= bookservice.getbook(id);
		System.out.println(bk);
		if(bk.isEmpty()) {
			
			System.out.println("not valid");
		}
		else {
			bookservice.delete(id);
			System.out.println("deleted");
			
		}
		 
	}
	
	
	@PutMapping("/update/{id}")
	public void updated(@RequestBody Book book, @PathVariable int id) {
		
		bookservice.updated(book.getName(), id);
	}
	
	@PutMapping("/updateee/{id}")
	public void update(@RequestBody Book book ,@PathVariable int id) {
		Optional<Book> nowbook= bookservice.getbook(id);
		if(nowbook.isPresent()) {
			 Book _bkao= nowbook.get();
			_bkao.setName(book.getName());
			_bkao.setPrice(book.getPrice());
			bookservice.addBook(_bkao);
		}
		else {
			System.out.println("hi");
		}
	}
	
	@GetMapping("/sabbooks")
	public List<Book> getal() {
		return bookservice.getal();
	}
}
