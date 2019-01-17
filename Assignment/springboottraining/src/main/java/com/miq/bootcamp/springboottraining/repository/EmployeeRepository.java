package com.miq.bootcamp.springboottraining.repository;

import java.util.Optional;

import com.miq.bootcamp.springboottraining.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Optional<Employee> findByEmail(String email);
    
}