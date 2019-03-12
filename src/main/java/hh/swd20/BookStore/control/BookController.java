package hh.swd20.BookStore.control;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.BookStore.model.Book;
import hh.swd20.BookStore.model.BookRepository;
import hh.swd20.BookStore.model.CategoryRepository;

@Controller 
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	@RequestMapping(value="/index")
	public String bookstore(Model model) {
		model.addAttribute("books", repository.findAll());
		return "index";
	}
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	// == Restful service to show all books in json.
    @RequestMapping(value="/showBooksJson", method = RequestMethod.GET)
    public @ResponseBody List<Book> BookListRest() {	
        return (List<Book>) repository.findAll();
    }
    
    @RequestMapping(value="/showBookJson/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }

	@RequestMapping(value="/addBook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addBook";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:index";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	// @PreAuthorize("hasAuthority('Admin')")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../index";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editBook";
	}
	
}