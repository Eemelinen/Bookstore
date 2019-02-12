package hh.swd20.BookStore.control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hh.swd20.BookStore.model.Book;
import hh.swd20.BookStore.model.BookRepository;

@Controller 
public class BookController {
	@Autowired
	private BookRepository repository;

	@RequestMapping(value="/index")
	public String bookstore(Model model) {
		model.addAttribute("books", repository.findAll());
		return "index";
	}

	@RequestMapping(value="/addBook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:index";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../index";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("departments", repository.findAll());
		return "editBook";
	}
	
}