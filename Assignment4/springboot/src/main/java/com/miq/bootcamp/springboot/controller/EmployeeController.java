package com.miq.bootcamp.springboot.controller;

import java.util.Date;

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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.miq.bootcamp.springboot.model.Employee;
import com.miq.bootcamp.springboot.model.ErrorResponse;
import com.miq.bootcamp.springboot.repository.EmployeeRepository;

import antlr.collections.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController extends ResponseEntityExceptionHandler {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(value="/add" , method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Employee> addANewEmployee(@Valid @RequestBody  Employee employee){
	Employee savedEmployee = employeeRepository.save(employee);
	return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<java.util.List<Employee>> returnAllEmployees() {
		if(employeeRepository.count()==0)
			throw new RuntimeException();
        return new ResponseEntity<java.util.List<Employee>>(employeeRepository.findAll(),HttpStatus.OK);
		
    }
    @RequestMapping(value="/get/{employeeId}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<Employee> returnOneEmployee(@PathVariable("employeeId") long employeeId) {
        return new ResponseEntity<Employee>(employeeRepository.findById(employeeId).get(),HttpStatus.OK);
	
	
	}
    
    @RequestMapping(value="/delete/{employeeId}", method=RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<java.util.List<Employee>> deleteOneEmployee(@PathVariable("employeeId") long employeeId){
    	//Employee savedEmployee = employeeRepository.findById(employeeId).get();
    	employeeRepository.deleteById(employeeId);
    	return new ResponseEntity<java.util.List<Employee>>(employeeRepository.findAll(),HttpStatus.OK);
	
	
	}
    
    
    @RequestMapping(value="/getByEmail", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<Employee> returnOneEmployeeByEmail(@RequestParam("email") String email) {
      return new ResponseEntity<Employee>(employeeRepository.findByEmail(email).get(), HttpStatus.OK);
    }
    
    @RequestMapping(value="/updateSalary", method=RequestMethod.POST, produces="application/json")
    public ResponseEntity<Employee> updateEmployeeSalary(@RequestParam("email") String email, @RequestParam("salary1") double increment) {
    	Employee savedEmployee = employeeRepository.findByEmail(email).get();
    	//if(savedEmployee.equals(null))
    		//handleAllExceptions();	
    	savedEmployee.setSalary((savedEmployee.getSalary())+savedEmployee.getSalary()*(increment/100));
      return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> RuntimeExceptionHandler(RuntimeException e) {
     //response.put("message", e.getMessage());
     return new ResponseEntity<String>("ERROR IN REQUEST", HttpStatus.BAD_REQUEST);
    }
    
    
}