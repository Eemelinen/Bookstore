package hh.swd20.BookStore.control;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.BookStore.model.Book;

@Controller 
public class BookController {

	@GetMapping("/index")
	public String bookstore(Model model) {
		
		Book book1 = new Book("Fire and Blood", "George Martin", 2019, 12345, 28);
		Book book2 = new Book("Feast for crows", "George Martin", 2007, 12476, 26);
		Book book3 = new Book("War of five kings", "George Martin", 1991, 12356, 25);

		ArrayList<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		// model.addAttribute("books", book1);
		
		model.addAttribute("booklist", books);
		
		return "index";
	}
	
//	@PostMapping(value="/index")
//	public String bookstore(@RequestParam(value="name")String name, Model model) {
//		
//		model.addAttribute("name", name);
//		
//		return "index";
//	}
}
