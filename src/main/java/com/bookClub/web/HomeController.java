package com.bookClub.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookClub.model.Book;
import com.bookClub.service.Impl.RestBookDao;

@Controller
@RequestMapping("/")
public class HomeController {

    RestBookDao bookDao = new RestBookDao();
	List<Book> books = bookDao.list();

	@GetMapping
	public String showHome(Model model) {
		model.addAttribute("books", books);
		return "index";

	}
	@GetMapping("/{id}")
	public String  getMonthlyBook(@PathVariable("id") String id,Model model) {
		RestBookDao memBook= new RestBookDao();
		Book bookId=memBook.find(id);
		model.addAttribute("book", bookId);
		return "monthly-books/view";
		
	}

	@GetMapping("/about")
	public String showAboutUs(Model model) {

		return "about";
	}

	@GetMapping("/contact")
	public String showContactUs(Model model) {
		return "contact";
	}

}
