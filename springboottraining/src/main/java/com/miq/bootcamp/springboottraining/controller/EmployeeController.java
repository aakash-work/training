package com.miq.bootcamp.springboottraining.controller;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

import java.util.List;
import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	@RequestMapping(value="/add",method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity addNewEmployee(@Valid @RequestBody Employee employee) {
		if((EmployeeRepository.findByEmail(employee.getEmail()).isPresent()))
		{
			return new ResponseEntity<String>("user already exists",HttpStatus.BAD_REQUEST);
			
		}
		Employee savedEmployee= EmployeeRepository.save(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
		
	}
	@RequestMapping(value="/increment",method=RequestMethod.GET,produces="application/json")
    public ResponseEntity<Employee> returnOneEmployeeByEmailId(@RequestParam("percent") Double percent,@RequestParam("id") Long id){
        Double sal=EmployeeRepository.findById(id).get().getSalary();
        Double newsal=sal+((percent)/100)*sal;
       EmployeeRepository.findById(id).get().setSalary(newsal);
        return new ResponseEntity<Employee>(EmployeeRepository.findById(id).get(),HttpStatus.OK);
    }
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json")
    public ResponseEntity returnAllEmployee(){
		
		
		if(EmployeeRepository.findAll().isEmpty())
		{
			return new ResponseEntity<String>("list is empty",HttpStatus.BAD_REQUEST);
			
		}
		
    return new ResponseEntity<List<Employee>>(EmployeeRepository.findAll(),HttpStatus.OK);
    }
	
	
	
	
	
    @RequestMapping(value="/get/{employeeId}",method=RequestMethod.GET,produces="application/json")
    public ResponseEntity returnOneEmployee(@PathVariable("employeeId") long employeeId){
    	
    	
    	if(!(EmployeeRepository.findById(employeeId).isPresent()))
		{
			return new ResponseEntity<String>("no such user exists",HttpStatus.BAD_REQUEST);
			
		}
    	
        return new ResponseEntity<Employee>(EmployeeRepository.findById(employeeId).get(),HttpStatus.OK);
        }
	
    @RequestMapping(value="/getByEmail", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity returnOneEmployeeByEmail(@RequestParam("email") String email) {
    	
    	
    	if(!(EmployeeRepository.findByEmail(email).isPresent()))
		{
			return new ResponseEntity<String>("no such user exists",HttpStatus.BAD_REQUEST);
			
		}
      return new ResponseEntity<Employee>(EmployeeRepository.findByEmail(email).get(), HttpStatus.OK);
    }
    
    
    @RequestMapping(value="/delete/{employeeId}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("employeeId") long employeeId) {

        if(!(EmployeeRepository.findById(employeeId).isPresent()))
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        EmployeeRepository.deleteById(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
