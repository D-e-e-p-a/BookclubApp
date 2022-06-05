package com.bookClub.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookClub.model.WishlistItem;
import com.bookClub.service.Impl.MongoWishlistDao;
import com.bookClub.service.dao.WishlistDao;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

	WishlistDao wishlistDao = new MongoWishlistDao();

	@Autowired
	private void setWishlistDao(WishlistDao wishlistDao) {
		this.wishlistDao = wishlistDao;
	}

	// showWishlist
	@GetMapping
	public String showWishlist(Model model) {

		List<WishlistItem> wishlist = wishlistDao.list();
		model.addAttribute("wishlist", wishlist);

		return "wishlist/list";

	}

	// wishlistForm
	@GetMapping("/new")
	public String wishlistForm(Model model) {
		model.addAttribute("wishlistItem", new WishlistItem());
		return "wishlist/new";
	}

	// addWishlistItem
	@PostMapping
	public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult) {

		System.out.println(bindingResult.getAllErrors());

		if (bindingResult.hasErrors()) {
			return "wishlist/new";
		}
		wishlistDao.add(wishlistItem); // add the record to MongoDB

		return "redirect:/wishlist";
	}

	// show item
	@GetMapping("/{id}")
	public String showWishlistItem(@PathVariable String id, Model model) {

		WishlistItem wishlistItem = wishlistDao.find(id);
		model.addAttribute("wishlistItem", wishlistItem);

		return "wishlist/view";
	}

	// updateItem
	@PostMapping("/update")
	public String updateWishListItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "wishlist/new";
		}
		wishlistDao.update(wishlistItem);

		return "redirect:/wishlist";
	}

	// remove Items
	@GetMapping("/remove/{id}")
	public String removeWishlistItem(@PathVariable String id, Model model) {

		wishlistDao.remove(id);

		return "redirect:/wishlist";
	}

}
