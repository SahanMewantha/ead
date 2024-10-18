package com.EAD2.EadCW.repositories;

import com.EAD2.EadCW.entities.Customer;
import com.EAD2.EadCW.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}