package com.miq_bootcamp.springboot_training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.miq_bootcamp.springboot_training.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    public Optional<Employee> findByEmail(String email);

}