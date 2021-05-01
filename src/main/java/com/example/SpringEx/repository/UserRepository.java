package com.example.SpringEx.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringEx.model.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	//FirstBy 가장 최근꺼 
	User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
}

