package com.miq.bootcamp.springboottraining.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miq.bootcamp.springboottraining.model.Employee;


//WHich class you want to map and the ID type

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

		public Optional<Employee> findByEmail(String email);
}
