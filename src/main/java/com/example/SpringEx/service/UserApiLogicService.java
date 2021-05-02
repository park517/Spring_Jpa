package com.example.SpringEx.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringEx.ifs.CrudInterface;
import com.example.SpringEx.model.entity.User;
import com.example.SpringEx.model.network.Header;
import com.example.SpringEx.model.network.request.UserApiRequest;
import com.example.SpringEx.model.network.response.UserApiResponse;
import com.example.SpringEx.repository.UserRepository;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

	@Autowired
	private UserRepository userRepository;
	
	// 1. request data
	// 2. user 생성
	// 3. 생성된 데이터 -> UserApiResponse return 
	
	
	@Override
	public Header<UserApiResponse> create(Header<UserApiRequest> request) {
		
		UserApiRequest userApiRequest = request.getData();
		
		//2. User 생성
		
		User user = User.builder()
				.account(userApiRequest.getAccount())
				.password(userApiRequest.getPassword())
				.status("REGISTERED")
				.phoneNumber(userApiRequest.getPhoneNumber())
				.email(userApiRequest.getEmail())
				.registeredAt(LocalDateTime.now())
				.build();
		
		User newUser = userRepository.save(user);
		
		// 3. 생성된 데이터  -> userApiResponse return 
		
		return response(newUser);
	}

	@Override
	public Header<UserApiResponse> read(Long id) {
		
		// id -> repository getOne , getById
		Optional<User> optional = userRepository.findById(id);
		
		// user -> userApiResponce return
		return optional
				//optional 를 user로 하여 response 메소드에 user를 넣어서 만약 user가 널값이라면
				// Header에 ERROR 에  데이터 없음을 보낸다.
				.map(user -> response(user)) 
				.orElseGet(
						() -> Header.ERROR("데이터 없음")
				);
		
	}

	@Override
	public Header<UserApiResponse> update(Header<UserApiRequest> request) {

		return null;
	}

	@Override
	public Header<UserApiResponse> delete(Long id) {

		return null;
	}
	
	private Header<UserApiResponse> response(User user) {
		// user -> uiserApiResponse
		
		
		UserApiResponse userApiResponse = UserApiResponse.builder()
				.id(user.getId())
				.account(user.getAccount())
				.password(user.getPassword())
				.email(user.getEmail())
				.phoneNumber(user.getPhoneNumber())
				.status(user.getStatus())
				.registeredAt(user.getRegisteredAt())
				.unregisteredAt(user.getUnregisteredAt())
				.build();
		
		
		// Header + dataa return
		
		return Header.OK(userApiResponse);
		
	}
	
	
}
