package com.miq.bootcamp.springboottraining.controller;

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

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value="/add",method=RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseEntity addANewEmployee(@Valid @RequestBody Employee employee)
    {
        if(!employeeRepository.findByEmail(employee.getEmail()).isPresent()){
            Employee savedEmployee = employeeRepository.save(employee);
            return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error: Employee already present!",HttpStatus.OK);
        }
    }
    
    @RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json")
    public ResponseEntity returnAllEmployees(){
        if(employeeRepository.count() != 0)
            return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);        
        else
            return new ResponseEntity<String>("Error: No employees found!",HttpStatus.OK);
    }
    
    @RequestMapping(value="/get/{employeeId}",method=RequestMethod.GET,produces="application/json")
    public ResponseEntity returnOneEmployee(@PathVariable("employeeId") long employeeId){
        if(employeeRepository.findById(employeeId).isPresent())
            return new ResponseEntity<Employee>(employeeRepository.findById(employeeId).get(),HttpStatus.OK);
        else
            return new ResponseEntity<String>("Error: Employee ID not found!",HttpStatus.OK);
    }
    
    @RequestMapping(value="/getByEmail", method=RequestMethod.GET, produces="application/json")
      public ResponseEntity returnOneEmployeeByEmail(@RequestParam("email") String email) {
        if(employeeRepository.findByEmail(email).isPresent())
            return new ResponseEntity<Employee>(employeeRepository.findByEmail(email).get(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("Error: Employee E-mail not found!",HttpStatus.OK);
      }
    
    @RequestMapping(value="/increaseSalary",method=RequestMethod.POST,produces="application/json")
    public ResponseEntity<Employee> increaseSalary(@RequestParam("id") long id, @RequestParam("percent") double percent){
        Employee emp = employeeRepository.findById(id).get();
        emp.setSalary(emp.getSalary() * percent / 100 + emp.getSalary());
        employeeRepository.save(emp);
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }
}