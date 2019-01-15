package com.miq.bootcamp.springboottraining.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.miq.bootcamp.springboottraining.model.Employee;
import com.miq.bootcamp.springboottraining.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Employee> addANewEmployee( @Valid @RequestBody Employee employee){
	
		Employee savedEmployee = employeeRepository.save(employee);
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Employee>> returnAllEmployees (){
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	}
	
	  @RequestMapping(value="/get/{employeeId}", method=RequestMethod.GET, produces="application/json")
	  public ResponseEntity<Employee> returnOneEmployee(@PathVariable("employeeId") long employeeId) {
		  
		  Optional<Employee> emp = employeeRepository.findById(employeeId);
		  
		  if ( !emp.isPresent()) throw new EntityNotFoundException(Long.toString(employeeId));
		  
	    return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
		  
	  }
	  
	
	@RequestMapping(value="/getByEmail", method=RequestMethod.GET, produces="application/json")
	  public ResponseEntity<Employee> returnOneEmployeeByEmail(@RequestParam("email") String email) {
		Optional<Employee> emp = employeeRepository.findByEmail(email);
		  
		  if ( !emp.isPresent()) throw new EntityNotFoundException(email);
	    return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
	  }
	
	/* Assignment 
	 * 
	 */
	
	@RequestMapping(value="/incrementSalary", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<Employee> incrementEmployeeSalary( @RequestParam("employeeId") long employeeId, @RequestParam("increment") double increment ){
		Employee newEmployee = employeeRepository.findById(employeeId).get();
		Double currentSalary = newEmployee.getSalary();
		Double newSalary = currentSalary * increment / 100 + currentSalary;
		newEmployee.setSalary(newSalary);
		Employee savedEmployee = employeeRepository.save(newEmployee);
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
	}
}