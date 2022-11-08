package com.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.demo.model.Book;
@Repository
public interface bookdao extends JpaRepository<Book, Integer> {

	
    @Modifying
    @Transactional
    @Query("update Book b set b.name=?1 where b.id=?2")
	void updated(String name, int id);
}
