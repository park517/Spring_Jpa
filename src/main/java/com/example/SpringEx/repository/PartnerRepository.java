package com.example.SpringEx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringEx.model.entity.Partner;

@Repository
public interface PartnerRepository  extends JpaRepository<Partner, Long>{

}
