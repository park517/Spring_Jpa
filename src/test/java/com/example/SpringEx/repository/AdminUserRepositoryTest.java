package com.example.SpringEx.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringEx.model.entity.AdminUser;

@SpringBootTest
public class AdminUserRepositoryTest {

	@Autowired
	AdminUserRepository adminUserRepository;
	
	@Test
	public void create() {
		AdminUser adminUser = new AdminUser();
		adminUser.setAccount("AdminUser01");
		adminUser.setPassword("AdminUser01");
		adminUser.setStatus("REGISTERED");
		adminUser.setRole("PARTNER");
//		adminUser.setCreatedAt(LocalDateTime.now());
//		adminUser.setCreatedBy("AdminSever");
		
		AdminUser newAdminUser = adminUserRepository.save(adminUser);
		
		newAdminUser.setAccount("CHANGE");
		adminUserRepository.save(newAdminUser);
	}
	
}
