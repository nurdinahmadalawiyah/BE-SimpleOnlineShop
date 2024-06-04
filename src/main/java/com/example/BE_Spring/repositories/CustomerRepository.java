package com.example.BE_Spring.repositories;

import com.example.BE_Spring.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
