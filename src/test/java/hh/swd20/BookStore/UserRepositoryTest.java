package hh.swd20.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.BookStore.model.User;
import hh.swd20.BookStore.model.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void createNewUser() {
		
		User user = new User("Matti", "1234", "as@hotmail.com", "user");
		
		userRepository.save(user);
		
		assertThat(userRepository.findByUsername("Matti").equals(user));
		
	}
	
	@Test
	public void deleteUser () {
		
		User user = new User("Matti", "1234", "as@hotmail.com", "user");
		
		userRepository.save(user);
		
		userRepository.delete(user);
		
		assertThat(userRepository.findByUsername("Matti")).isNull();
		
	}
	
	@Test
	public void searchForUser() {
		
		User user = userRepository.findByUsername("admin");
		
		assertThat(user.getEmail()).isEqualTo("admin@gmail.com");

	}

}
