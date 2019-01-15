package com.miq.karthikbhat.SpringBootBasics.Repositories;

import com.miq.karthikbhat.SpringBootBasics.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Optional <Employee> findByEmail(String email);
}
