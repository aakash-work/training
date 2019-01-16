package com.miq.bootcamp.springboottraining.model;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miq.bootcamp.springboottraining.repository.EmployeeRepository;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	public EmployeeRepository employeeRepository;
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Employee> addANewEmployee(@Valid @RequestBody Employee employee){
		Employee savedEmployee = employeeRepository.save(employee);
		//to set headers etc.
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
	}
	


	@RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<?> returnAllEmployees() {
		if(employeeRepository.findAll().isEmpty())
			return new ResponseEntity<String>("Error: No Employee Found!", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/get/{employeeId}", method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<?> returnOneEmployee(@PathVariable("employeeId") long employeeId){
	    Optional<Employee> emp = employeeRepository.findById(employeeId);
	    if (!emp.isPresent())
	    	return new ResponseEntity<String>("Error: Employee of id = "+employeeId+" Not Found!", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getByEmail", method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<?> returnOneEmployeeByEmail(@RequestParam("email") String email){
		Optional<Employee> emp = employeeRepository.findByEmail(email);
	    if (!emp.isPresent())
			return new ResponseEntity<String>("Error: Employee of email = "+ email+" Not Found!", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/increment-salary", method=RequestMethod.POST, produces="application/json" )
	public ResponseEntity<?> incrementSalary(@RequestParam("employeeId") long employeeId,@RequestParam("percent") double percent){
		Optional<Employee> emp = employeeRepository.findById(employeeId);
	    if (!emp.isPresent())
			return new ResponseEntity<String>("Error: Employee of id = "+ employeeId +" Not Found!", HttpStatus.BAD_REQUEST);
		Employee e = emp.get();
		if(e.getSalary()+e.getSalary()*percent<0)
			e.setSalary(0);
		else
			e.setSalary(e.getSalary()+e.getSalary()*percent);
	    Employee savedEmployee = employeeRepository.save(e);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
	}
	
}

//Check if employee exists otherwise proper error
//Salary, api to increment the salary: post call take in emp id and percent (increment-salary
