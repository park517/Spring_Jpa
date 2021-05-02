package com.example.SpringEx.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringEx.ifs.CrudInterface;
import com.example.SpringEx.model.network.Header;
import com.example.SpringEx.model.network.request.UserApiRequest;
import com.example.SpringEx.model.network.response.UserApiResponse;
import com.example.SpringEx.service.UserApiLogicService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {
	
	
	@Autowired
	private UserApiLogicService userApiLogicService;
	
	@Override
	@PostMapping("") //api/user
	public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
		log.info("{}",request);
		return userApiLogicService.create(request);
	}

	@Override
	@GetMapping("{id}") // /api/user/{id} pathvariable
	public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
		log.info("read id : {} ",id);
		return userApiLogicService.read(id);
	}

	@Override
	@PutMapping("") // /api/user
	public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
		
		return null;
	}

	@Override
	@DeleteMapping("{id}") // /api/user/{id}
	public Header<UserApiResponse> delete(@PathVariable Long id) {
	
		return null;
	}


	
	
	

}
