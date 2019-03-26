package hh.swd20.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.BookStore.model.Book;
import hh.swd20.BookStore.model.BookRepository;
import hh.swd20.BookStore.model.Category;
import hh.swd20.BookStore.model.CategoryRepository;
import hh.swd20.BookStore.model.User;
import hh.swd20.BookStore.model.UserRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Other"));
			
			brepository.save(new Book("Feast for Crows", "G.R.R Martin", 1991, 123, 15, crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("The Other Book", "James Hopkins", 0, 777, 7, crepository.findByName("Scifi").get(0)));
			
			// user's password: user
			// admin's password: admin
			User user1 = new User("user", "$2a$10$tLy5ngwYvnltoar6SDFExubXzzeawxuY4rr7N/BOREveJf45x08GW", "user@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$1Wx77JGem8GZNZ8g3uxybePFIj.aLMS2Hyxf3o2efFWDHAs3A7CZW", "admin@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
		};
	}
}

