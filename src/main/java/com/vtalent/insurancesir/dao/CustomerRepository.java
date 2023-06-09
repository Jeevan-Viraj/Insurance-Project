package com.vtalent.insurancesir.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtalent.insurancesir.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
