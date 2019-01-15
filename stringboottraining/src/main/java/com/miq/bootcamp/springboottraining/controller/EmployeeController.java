package com.miq.bootcamp.springboottraining.controller;

import java.util.List;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
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
	private EmployeeRepository employeeRespository;
 
	@RequestMapping(value="/add",method=RequestMethod.POST, consumes="application/json" , produces="application/json")
	public ResponseEntity addANewEmployee(@Valid @RequestBody Employee employee){
		ResponseEntity<Employee> res = returnOneEmployeeByEmailId(employee.getEmail());
		if(res==null)
		{				Employee savedEmployee = employeeRespository.save(employee);
			return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Employee already exists",HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<Employee>> returnAllEmployee() {
		try {
		return new ResponseEntity<List<Employee>>(employeeRespository.findAll(),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/get/{employeeId}",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity returnOneEmployee(@PathVariable("employeeId") long employeeId){
			try {
			return new ResponseEntity<Employee>(employeeRespository.findById(employeeId).get(),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Employee doesnot exists with ID = "+employeeId,HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/delete/{employeeId}",method=RequestMethod.DELETE,produces="application/json")
	public ResponseEntity deleteEmployee(@PathVariable("employeeId") long employeeId) {
		try {
			ResponseEntity<Employee> t = new ResponseEntity<Employee>(employeeRespository.findById(employeeId).get(),HttpStatus.OK);
			employeeRespository.deleteById(employeeId);
			return t;
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Employee not found",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/getByEmail",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity returnOneEmployeeByEmailId(@RequestParam("email") String email){
		try {
			return new ResponseEntity<Employee>(employeeRespository.findByEmail(email).get(),HttpStatus.OK);
		}catch(Exception e)
		{ 
			return new ResponseEntity<String>("Employee not found",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/increment",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity returnOneEmployeeByEmailId(@RequestParam("percent") Double percent,@RequestParam("id") Long id){
		try {
			Employee employee = new Employee();
			employee.setEmployeeId(id);
			employee.setName(employeeRespository.findById(id).get().getName());
			employee.setEmail(employeeRespository.findById(id).get().getEmail());
			employee.setSalary(employeeRespository.findById(id).get().getSalary());
			
			Double sal=employeeRespository.findById(id).get().getSalary();
			sal=sal+((percent)/100)*sal;
			employeeRespository.findById(id).get().setSalary(sal);
			sal=employeeRespository.findById(id).get().getSalary();
			
			employee.setSalary(sal);
			employeeRespository.save(employee);
			return new ResponseEntity<Employee>(employeeRespository.findById(id).get(),HttpStatus.OK);	
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Employee not found",HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
