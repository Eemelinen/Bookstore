package hh.swd20.BookStore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.BookStore.model.Book;
import hh.swd20.BookStore.model.BookRepository;
import hh.swd20.BookStore.model.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	// == Testataan search toiminnallisuutta == 
	@Test
	public void findBookFromDatabase() {	
		List<Book> books = bookRepository.findByTitle("Feast for Crows");
		assertThat(books.get(0).getAuthor()).isEqualTo("G.R.R Martin");
	}
	
	
	// == Testataan kirjojen tallentamista tietokantaan ja kategorian luomista.
	@Test
	public void CreateBookToDatabase() {
		
		Category Suomikirjallisuus = new Category();
		
		Book book = new Book("Punainen Viiva", "Joku Jokunen", 1991, 12345, 12, Suomikirjallisuus);
		
		bookRepository.save(book);
		
		assertThat(book.getAuthor()).isEqualTo("Joku Jokunen");
		
		assertThat(book.getCategory()).isEqualTo(Suomikirjallisuus);

	}
	
	// == Testataan kirjojen poistamisen toiminnallisuutta. == 
	@Test
	public void deleteBookFromDatabase() {
				
		Category Suomikirjallisuus = new Category();
		
		Book book = new Book("Punainen armeija", "Ismo Valtonen", 1691, 12245, 2, Suomikirjallisuus);
		
		bookRepository.save(book);
		
		bookRepository.delete(book);
				
		assertThat(bookRepository.findByTitle("Punainen armeija")).isNullOrEmpty();;
			
	}
	
}
