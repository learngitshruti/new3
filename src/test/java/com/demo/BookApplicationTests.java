package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demo.model.Book;
import com.demo.repository.bookdao;
import com.demo.service.Bookservice;

@SpringBootTest
class BookApplicationTests {

	
	@MockBean
	 Bookservice bookser;
	
	@Autowired
	 private bookdao bkdao;
	 
	@Test
	void contextLoads() {
	}
 
	@Test
	public void getbooktest() {
		Optional<Book> b1=Optional.ofNullable(new Book(1,"fdafd",12.0));
		when(bookser.getbook(1)).thenReturn(b1);
		assertEquals(true, bookser.getbook(1).isPresent());
		
		
	}
}
