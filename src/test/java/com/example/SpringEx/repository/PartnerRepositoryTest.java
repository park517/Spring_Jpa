package com.example.SpringEx.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringEx.model.entity.Partner;

@SpringBootTest
public class PartnerRepositoryTest {

	@Autowired
	PartnerRepository partnerRepository;
	
	@Test
	public void create() {
		Partner partner = new Partner();
		String name = "Partner01";
		String status = "REGISTERED";
		String address ="서울시 강남구";
		String callCenter = "070-1111-2222";
		String partnerNumber = "010-1111-2222";
		String businessNumber = "1234567890123";
		String ceoName = "홍길동";
		LocalDateTime registeredAt = LocalDateTime.now();
		LocalDateTime createdAt = LocalDateTime.now();
		String createdBy = "AdminServer";		
		
		partner.setName(name);
		partner.setStatus(status);
		partner.setAddress(address);
		partner.setCallCenter(callCenter);
		partner.setPartnerNumber(partnerNumber);
		partner.setBusinessNumber(businessNumber);
		partner.setCeoName(ceoName);
		partner.setCreatedAt(createdAt);
		partner.setCreatedBy(createdBy);
//		partner.setCategoryId(1L);
		partnerRepository.save(partner);
	}
	
	@Test
	public void read() {
		
	}
	
}
