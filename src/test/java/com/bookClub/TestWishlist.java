package com.bookClub;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookClub.model.WishlistItem;
import com.bookClub.service.Impl.MongoWishlistDao;
import com.bookClub.service.dao.WishlistDao;
import com.bookClub.web.WishlistController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWishlist {
	@MockBean
	 MongoWishlistDao dao = new MongoWishlistDao();
	
	
	@Autowired
	private WishlistDao wishlist ;
	

	
	@Test
	public void Testlist() {
	
		
		when(wishlist.list()).thenReturn
		(Stream.of(new WishlistItem("12345","JunitTesting"),new WishlistItem("12345","Jupiter"),
				new WishlistItem("12345","Mockito")).collect(Collectors.toList()));
		assertEquals(3,dao.list().size());
		
	}
	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
