package com.miq.bootcamp.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miq.bootcamp.springboot.model.Employee;
import com.miq.bootcamp.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Employee> addNewEmployee(@Valid @RequestBody Employee employee){
		Employee savedEmployee = employeeRepository.save(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Employee>> returnAllEmployees(){
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(),HttpStatus.OK);
		
	}
	@RequestMapping(value="/get/{employeeId}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Employee> returnOneEmployee(@PathVariable("employeeId") long employeeId){
		return new ResponseEntity<Employee>(employeeRepository.findById(employeeId).get(),HttpStatus.OK);
		
	}
	@RequestMapping(value="/getByEmail", method=RequestMethod.GET, produces="application/json")
	  public ResponseEntity<Employee> returnOneEmployeeByEmail(@RequestParam("email") String email) {
	    return new ResponseEntity<Employee>(employeeRepository.findByEmail(email).get(), HttpStatus.OK);
	  }
	
	@RequestMapping(value="/updatesalary", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<Employee> updatedSalary(@RequestParam("email") String email, @RequestParam("percent") double extra){
		
		Employee saveEmp= employeeRepository.findByEmail(email).get();
		saveEmp.setSalary(saveEmp.getSalary()+(saveEmp.getSalary()*(extra/100)));
		return new ResponseEntity<Employee>(saveEmp, HttpStatus.OK);
	}
	
	@ExceptionHandler(RuntimeException.class)
	 public ResponseEntity<String> RuntimeExceptionHandler(RuntimeException e) {
	  return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	 }

}
