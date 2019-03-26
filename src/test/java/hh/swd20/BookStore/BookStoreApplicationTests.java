package hh.swd20.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import hh.swd20.BookStore.control.BookController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreApplicationTests {
	
	@Autowired
	private BookController bookController;

	@Test
	public void contextLoads() throws Exception {
		
		assertThat(bookController).isNotNull();
		
	}
}

