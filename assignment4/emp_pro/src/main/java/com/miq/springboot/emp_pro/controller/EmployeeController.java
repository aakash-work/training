package com.miq.springboot.emp_pro.controller;
import java.util.List;

import javax.validation.Valid;

import com.miq.springboot.emp_pro.model.Employee;
import com.miq.springboot.emp_pro.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired 
	private EmployeeRepository employeeRepository;
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	  public ResponseEntity<Employee> addANewEmployee(@Valid @RequestBody com.miq.springboot.emp_pro.model.Employee employee) {
	    Employee savedEmployee = employeeRepository.save(employee);
	    return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
	  }
	  
	  @RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
	  public ResponseEntity<List<Employee>> returnAllEmployees() {
	    return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	  }
	  
	  @RequestMapping(value="/get/{employeeId}", method=RequestMethod.GET, produces="application/json")
	  public ResponseEntity<Employee> returnOneEmployee(@PathVariable("employeeId") long employeeId) {
	    return new ResponseEntity<Employee>(employeeRepository.findByemployeeId(employeeId).get(), HttpStatus.OK);
	  }
	  
	  @RequestMapping(value="/getByEmail", method=RequestMethod.GET, produces="application/json")
	  public ResponseEntity<Employee> returnOneEmployeeByEmail(@RequestParam("employeeMail") String employeeMail) {
	    return new ResponseEntity<Employee>(employeeRepository.findByemployeeMail(employeeMail).get(), HttpStatus.OK);
	  }
	  @RequestMapping(value="/increment", method=RequestMethod.POST, produces="application/json")
	  public ResponseEntity<Employee> updateEmployee(@RequestParam("employeeId") long employeeId, @RequestParam("percent") int percent ){
		  Employee foundEmployee= employeeRepository.findByemployeeId(employeeId).get();
		  long newsal=foundEmployee.getEmployeeSalary();
		  System.out.println("/n SALARY"+newsal);
		  newsal=newsal+newsal*5/100;
		  foundEmployee.setEmployeeSalary(newsal);
		  employeeRepository.save(foundEmployee);
		  return new ResponseEntity<Employee> (employeeRepository.findByemployeeId(employeeId).get(),HttpStatus.OK);
	  }
	  
	  
}
	

