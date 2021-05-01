package com.example.SpringEx.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringEx.model.entity.Item;
import com.example.SpringEx.model.entity.User;

@SpringBootTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void create() {
		Item item = new Item();
		item.setStatus("UNREGISTERED");
		item.setName("노트북");
		item.setTitle("삼성 노트북 A100");
		item.setContent("2019년형 노트북입니다");
		item.setPrice(900000);
		item.setBrandName("삼성");
		item.setRegisteredAt(LocalDateTime.now());
		item.setCreatedAt(LocalDateTime.now());
		item.setCreatedBy("Partner01");
//		item.setPartnerId(1L);
		Item newItem = itemRepository.save(item);
		
	}
	@Test
	@Transactional
	public void read() {
		
	}
	@Test
	public void update() {

	}
	
	@Test
	@Transactional // 마지막에 롤백해줘서 실제 DB데이터를 손상시키지 않는다.
	public void delete() {

	}
}
