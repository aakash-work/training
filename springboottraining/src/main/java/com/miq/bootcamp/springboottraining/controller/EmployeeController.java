package com.miq.bootcamp.springboottraining.controller;

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

import com.miq.bootcamp.springboottraining.model.Employee;
import com.miq.bootcamp.springboottraining.repository.EmployeeRepository;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value="/add",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public ResponseEntity<Employee> addNewEmployee(@Valid @RequestBody Employee employee){
		
		Employee savedEmployee=employeeRepository.save(employee);
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<?> returnAllEmployees(){
		
		int lsize=employeeRepository.findAll().size();
		if(lsize>0)
		{
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Error-Employee records empty",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/get/{employeeId}",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<?> returnOneEmployee(@PathVariable("employeeId") long employeeId){
		
		if(employeeRepository.findById(employeeId).isPresent()) {
		return new ResponseEntity<Employee>(employeeRepository.findById(employeeId).get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Error-Employee not found",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/getByEmail", method=RequestMethod.GET, produces="application/json")
	  public ResponseEntity<?> returnOneEmployeeByEmail(@RequestParam("email") String email) {
		
		if(employeeRepository.findByEmail(email).isPresent()) {
			
			return new ResponseEntity<Employee>(employeeRepository.findByEmail(email).get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Error-Employee not found",HttpStatus.BAD_REQUEST);
		}
	    
	  }
	
	@RequestMapping(value="/incrementsal",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<?> incrementsal(@RequestParam("empId") long empId,@RequestParam("percent") double percent){
		
		//Employee savedEmployee=employeeRepository.save(employee);
		//return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
		if(employeeRepository.findById(empId).isPresent()) {
			Employee emp=employeeRepository.findById(empId).get();
			double sal=emp.getSalary();
			sal=sal+(percent*sal/100);
			emp.setSalary(sal);
			Employee savedEmployee=employeeRepository.save(emp);
			return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<String>("Error-Employee not found",HttpStatus.BAD_REQUEST);
		}
		  
	}
	  
}
                