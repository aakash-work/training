package com.miq.bootcamp.springboottraining.controller;

import java.util.List;

import javax.validation.Valid;

import com.miq.bootcamp.springboottraining.model.Employee;
import com.miq.bootcamp.springboottraining.model.ErrorDetails;
import com.miq.bootcamp.springboottraining.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ErrorHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * EmployeeController
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Add already added validation
    @RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json", produces="application/json")
    public ResponseEntity addNewEmployee(@Valid @RequestBody Employee employee){

        if(employeeRepository.findByEmail(employee.getEmail()).isPresent())
        {
            ErrorDetails error = new ErrorDetails("User already exists","The user is already present in the database");
            return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
            
        }

        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
    }

    //Handle empty table
    @RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity returnAllEmployees() {

        if(employeeRepository.findAll().isEmpty())
        {
            ErrorDetails error = new ErrorDetails("Empty list", "The database does not contain any employee entries");
            return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST); 
        }

        return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
        
    }

    //Add employee not exists
    @RequestMapping(value="/get/{employeeId}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity returnOneEmployee(@PathVariable("employeeId") long employeeId) {
        //Employee emp = employeeRepository.findById(employeeId).get();

        try{
            return new ResponseEntity<Employee>(employeeRepository.findById(employeeId).get(), HttpStatus.OK);
        }

        catch(Exception e){
            ErrorDetails error = new ErrorDetails("User Not Found", "The user does not exists in the database");
            throw e;
        }
        
        
    }

    @RequestMapping(value="/delete/{employeeId}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("employeeId") long employeeId) {
        
        if(!(employeeRepository.findById(employeeId).isPresent()))
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        employeeRepository.deleteById(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);    
    }

}