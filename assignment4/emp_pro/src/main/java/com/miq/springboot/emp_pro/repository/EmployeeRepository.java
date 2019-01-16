package com.miq.springboot.emp_pro.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miq.springboot.emp_pro.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  public Optional<Employee> findByemployeeMail(String employeeMail);
  public Optional<Employee> findByemployeeId(long employeeId);
 
}

