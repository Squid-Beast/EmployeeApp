package com.us.employee_app_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.us.employee_app_service.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
