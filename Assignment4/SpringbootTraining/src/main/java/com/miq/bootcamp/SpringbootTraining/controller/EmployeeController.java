package com.miq.bootcamp.SpringbootTraining.controller;


import java.util.List;

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

import com.miq.bootcamp.SpringbootTraining.model.Employee;
import com.miq.bootcamp.SpringbootTraining.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST, consumes="application/json",produces="application/json")
	public ResponseEntity addNewEmployee(@Valid @RequestBody Employee employee){
		if(employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
			return new ResponseEntity<String>("Employee already present",HttpStatus.OK);
		}
		Employee savedEmployee=employeeRepository.save(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity returnAllEmployee(){
	if(employeeRepository.count()==0) {
		return new ResponseEntity<String>("No Employees",HttpStatus.OK);
	}
	return new ResponseEntity<List<Employee>>(employeeRepository.findAll(),HttpStatus.OK);
	
	}
	
	@RequestMapping(value="/get/{employeeId}",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<Employee> returnOneEmployee(@PathVariable("employeeId") long employeeId){
		
		return new ResponseEntity<Employee>(employeeRepository.findById(employeeId).get(),HttpStatus.OK);
		}
	
	@RequestMapping(value="/getByEmail", method=RequestMethod.GET, produces="application/json")
	  public ResponseEntity<Employee> returnOneEmployeeByEmail(@RequestParam("email") String email) {
	    return new ResponseEntity<Employee>(employeeRepository.findByEmail(email).get(), HttpStatus.OK);
	  }
	
	@RequestMapping(value="/increment",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity<Employee> IncrementSalary(@RequestParam("employeeId") long employeeId,@RequestParam("percent") double percent){
		
		
		double NewSalary = employeeRepository.findById(employeeId).get().getSalary();
		NewSalary=NewSalary*(1+percent/100);
		employeeRepository.findById(employeeId).get().setSalary(NewSalary);
		employeeRepository.save(employeeRepository.findById(employeeId).get());
		return new ResponseEntity<Employee>(employeeRepository.findById(employeeId).get(),HttpStatus.OK);
	}
}
