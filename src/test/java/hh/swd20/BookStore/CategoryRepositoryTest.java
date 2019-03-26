package hh.swd20.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.BookStore.model.Category;
import hh.swd20.BookStore.model.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void searchCategory() {
		
		List<Category> categories = categoryRepository.findByName("Fantasy");
		
		assertThat(categories).hasSize(1);
		
		assertThat(categories.get(0).getCategoryid()).isNotNull();
		
	}
	
	@Test
	public void createNewCategory() {
		
		Category historia = new Category("historiikit");
		
		categoryRepository.save(historia);
		
		assertThat(categoryRepository.findByName("historiikit")).isNotNull();
		
	}
	
	@Test
	public void deleteCategory() {
					
		Category historia = new Category("historiikit");
		
		categoryRepository.save(historia);
		
		categoryRepository.delete(historia);
		
		assertThat(categoryRepository.findByName("historiikit")).isNullOrEmpty();

	}
	
}