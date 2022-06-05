package com.bookClub.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookClub.model.WishlistItem;
import com.bookClub.service.Impl.MongoWishlistDao;
import com.bookClub.service.dao.WishlistDao;

@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins ="*")
public class WishlistRestController {
	
	WishlistDao wishlistDao=new MongoWishlistDao();
	
	  @Autowired
	    private void setWishlistDao(WishlistDao wishlistDao) {
	        this.wishlistDao = wishlistDao;
	    }
	  
	  @GetMapping
	 public List<WishlistItem> showWishlist(){
		 return wishlistDao.list();
	 }
	  
	  @GetMapping("/{id}")
	  public WishlistItem findById(@PathVariable ("id") String id) {
		  return wishlistDao.find(id);
	  }

}
 