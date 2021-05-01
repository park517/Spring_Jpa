package com.example.SpringEx.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringEx.model.entity.Item;
import com.example.SpringEx.model.entity.User;

@SpringBootTest
public class UserRepositoryTest{
	
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void create() {
		
		String account = "Test03";
		String password = "Test03";
		String status = "REGISTERED";
		String email = "Test01@gmail.com";
		String phoneNumber = "010-1111-3333";
		LocalDateTime registeredAt = LocalDateTime.now();
		
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setStatus(status);
		user.setPhoneNumber(phoneNumber);
		user.setRegisteredAt(registeredAt);
		
		
		User newUser = userRepository.save(user);
		
	}
	@Test
	@Transactional
	public void read() {
		
		User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
		
		user.getOrderGroupList().stream().forEach(orderGroup -> {
			System.out.println("----------------주문 묶음--------------");
			System.out.println("수령인 : " +orderGroup.getRevName());
			System.out.println("총 가격 : "+orderGroup.getTotalPrice());			
			System.out.println("배송지 주소 : "+orderGroup.getRevAddress());
			System.out.println("총 수량 " +orderGroup.getTotalQuantity());
			
			System.out.println("------------------주문상세-------------------");
			orderGroup.getOrderDetailList().forEach(orderDetail -> {
				System.out.println("파트너사 이름 : "+orderDetail.getItem().getPartner().getName());
				System.out.println("파트너사 카테고리 : "+orderDetail.getItem().getPartner().getCategory().getTitle());
				System.out.println("주문 상품 : "+orderDetail.getItem().getName());
				System.out.println("고객센터 번호 : "+orderDetail.getItem().getPartner().getCallCenter());
				System.out.println("주문의 상태 : "+orderDetail.getStatus() );
				System.out.println("도착예상일자 : "+orderDetail.getArrivalDate());
			});
		});
 
	}
	@Test
	public void update() {
		Optional<User> user = userRepository.findById(2L);
		user.ifPresent(selectUser -> {
			selectUser.setAccount("PPPP");
			selectUser.setUpdatedAt(LocalDateTime.now());
			selectUser.setUpdatedBy("update method()");
			
			userRepository.save(selectUser);
		});
	}
	
	@Test
	@Transactional // 마지막에 롤백해줘서 실제 DB데이터를 손상시키지 않는다.
	public void delete() {
		Optional<User> user = userRepository.findById(2L);
		
		user.ifPresent(selectUser -> {
			userRepository.delete(selectUser );
		});
	}
}