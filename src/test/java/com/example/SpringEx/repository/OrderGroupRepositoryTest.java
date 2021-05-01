package com.example.SpringEx.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringEx.model.entity.OrderGroup;

@SpringBootTest
public class OrderGroupRepositoryTest {

	@Autowired
	OrderGroupRepository orderGroupRepository;
	
	@Test
	public void create() {
		OrderGroup orderGroup = new OrderGroup();
		orderGroup.setStatus("COMPLETE");
		orderGroup.setOrderType("ALL");
		orderGroup.setRevAddress("서울시 강남구");
		orderGroup.setRevName("홍길동");
		orderGroup.setPaymentType("CARD");
		orderGroup.setTotalPrice(BigDecimal.valueOf(9000000));
		orderGroup.setTotalQuantity(1);
		orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
		orderGroup.setArrivalDate(LocalDateTime.now());
		orderGroup.setCreatedAt(LocalDateTime.now());
		orderGroup.setCreatedBy("adminServer");
//		orderGroup.setUserId(1L);
		orderGroupRepository.save(orderGroup);
		
	}
}
