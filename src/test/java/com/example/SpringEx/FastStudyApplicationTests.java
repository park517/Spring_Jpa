package com.example.SpringEx;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringEx.model.entity.User;
import com.example.SpringEx.repository.UserRepository;

@SpringBootTest
class FastStudyApplicationTests {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	void contextLoads() {
	}
	

	@Test
	public void create() {
		User user = new User();
		user.setAccount("TestUser01");
		user.setEmail("TestUser01@gamail.com");
		user.setPhoneNumber("010-1111-1111");
		user.setCreatedAt(LocalDateTime.now());
		user.setCreatedBy("admin");
		User newUser = userRepository.save(user); //save시 db에 저장된 칼럼들이 다시 반환된다.
		System.out.println("newUser:"+newUser);
		
	}

}
