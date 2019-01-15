package com.miq.bootcamp.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.miq.rati.SpringBoot.model.Employee;
import com.miq.rati.SpringBoot.repository.EmployeeRepository;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Employee> addANewEmployee(@Valid @RequestBody Employee employee){
		Employee savedEmployee = employeeRepository.save(employee);
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Employee>> returnAllEmployees (){
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/get/{employeeId}",method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> returnOneEmployee(@PathVariable("employeeId") long employeeId){
		Optional <Employee> Emp = employeeRepository.findById(employeeId);
		if(!Emp.isPresent()) {
			throw new EntityNotFoundException();
		}
		return new ResponseEntity<Employee>(Emp.get(),HttpStatus.OK);
		}
	
	
	 @RequestMapping(value="/getByEmail", method=RequestMethod.GET, produces="application/json")
	  public ResponseEntity<?> returnOneEmployeeByEmail(@RequestParam("email") String email) {
		 
		 Optional <Employee> Emp = employeeRepository.findByEmail(email);
			if(!Emp.isPresent()) {
				throw new EntityNotFoundException();
			}
			return new ResponseEntity<Employee>(Emp.get(),HttpStatus.OK); 
		 
	 }
	 
	@RequestMapping(value="/increment-salary",method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<Object>returnUpdatedEmployee(@RequestParam("percent") double percent,@RequestParam("id") long id){
		try {
		Employee UpdateEmp = employeeRepository.findById(id).get();
		/*if (UpdateEmp == null) {
			String s = "Error:Employee Id not found";
			return new ResponseEntity<Object>(s,HttpStatus.BAD_REQUEST);
		}*/
		double salary = UpdateEmp.getSalary();
		UpdateEmp.setSalary(salary+salary*percent/100);
		UpdateEmp  = employeeRepository.save(UpdateEmp);
		return new ResponseEntity<Object>(UpdateEmp,HttpStatus.OK);
		}catch(Exception e) {
			throw new EntityNotFoundException();
		
		}
		
	}
	
}


	

