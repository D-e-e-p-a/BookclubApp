package com.bookClub;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookClub.model.Book;
import com.bookClub.service.Impl.RestBookDao;

 class TestRestBookDao {
	
	@Autowired
	RestBookDao rb=new RestBookDao();

	@Test
	void testFind() {
		Book  book =rb.find("9780593099322");
		assertEquals("9780593099322",book.getIsbn());
	}
	
	


}
