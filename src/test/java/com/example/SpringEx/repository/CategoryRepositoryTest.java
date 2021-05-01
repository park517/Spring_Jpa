package com.example.SpringEx.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringEx.model.entity.Category;

@SpringBootTest
public class CategoryRepositoryTest {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	
	public void create() {
		String type = "COMPUTER";
		String title = "컴퓨터";
		LocalDateTime createdAt = LocalDateTime.now();
		String createdBy = "AdminServer";
		
		Category category = new Category();
		category.setType(type);
		category.setTitle(title);
		category.setCreatedAt(createdAt);
		category.setCreatedBy(createdBy);
		
		Category newCategory =categoryRepository.save(category);
		
	}
	@Test
	public void read() {
		Long id = 1L;
		
		Optional<Category> category = categoryRepository.findByType("COMPUTER");
		// select * from category where type = 'COMPUTER'
		category.ifPresent(getCategory -> {
			System.out.println(getCategory.getId());
			System.out.println(getCategory.getType());
			System.out.println(getCategory.getTitle());
		});
		
		
	}
}
