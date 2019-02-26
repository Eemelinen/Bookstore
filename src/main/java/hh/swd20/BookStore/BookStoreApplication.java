package hh.swd20.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.BookStore.model.Book;
import hh.swd20.BookStore.model.BookRepository;
import hh.swd20.BookStore.model.Category;
import hh.swd20.BookStore.model.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
//			log.info("save a couple of students");
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Other"));
			
			brepository.save(new Book("GRR Martin", "Feast for Crows", 1991, 123, 15, crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("God", "The Holy Bible", 0, 777, 7, crepository.findByName("Scifi").get(0)));	
			
//			log.info("fetch all students");
			for (Book book : brepository.findAll()) {
//				log.info(student.toString());
			}

		};
	}
}

