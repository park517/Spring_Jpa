package com.example.SpringEx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringEx.model.entity.OrderGroup;

@Repository
public interface OrderGroupRepository  extends JpaRepository<OrderGroup, Long>{

}
