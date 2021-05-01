package com.example.SpringEx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringEx.model.entity.AdminUser;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long>{

}
