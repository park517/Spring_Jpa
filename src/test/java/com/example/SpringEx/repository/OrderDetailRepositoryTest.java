package com.example.SpringEx.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringEx.model.entity.OrderDetail;

@SpringBootTest
public class OrderDetailRepositoryTest {

	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Test
	public void create() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setStatus("WAITING");
		orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
		orderDetail.setQuantity(1);
		orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
//		orderDetail.setOrderGroupId(1L);
//		orderDetail.setItemId(1L);
		orderDetail.setCreatedAt(LocalDateTime.now());
		orderDetail.setCreatedBy("AdminServer");
		
		orderDetailRepository.save(orderDetail);
	}
}
