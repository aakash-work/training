package com.miq_bootcamp.springboot_training.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.miq_bootcamp.springboot_training.model.Employee;
import com.miq_bootcamp.springboot_training.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import antlr.collections.List;
// import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping("/employee")
public class EmployeeController{

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json",produces="application/json")
    public ResponseEntity<Employee> addNewEmployee(@Valid @RequestBody Employee employee)
    {
        Employee saveEmployee = employeeRepository.save(employee);

        return new ResponseEntity<Employee>(saveEmployee, HttpStatus.OK);
    }

    @RequestMapping(value="/list", method=RequestMethod.GET,produces="application/json")
    public ResponseEntity<?> returnAllEmployee(){
        List<Employee> e = employeeRepository.findAll();
        if(e.size() > 0 )
            return new ResponseEntity<List<Employee>>(e,HttpStatus.OK);
        return new ResponseEntity<String>("Error: There are no records",HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/get/{employeeId}", method=RequestMethod.GET,produces="application/json")
    public ResponseEntity<?> returnOneEmployee(@PathVariable("employeeId") long employeeId){
        Optional<Employee> e =  employeeRepository.findById(employeeId);
        if (e.isPresent())
            return new ResponseEntity<Employee>(e.get(),HttpStatus.OK); 
        return new ResponseEntity<String>("Error: The employee ID does not exists",HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/getbyemail",method=RequestMethod.GET,produces="application/json")
    public ResponseEntity<?> returnOneEmployeeByEmail(@RequestParam("email") String email)
    {
        Optional<Employee> e = employeeRepository.findByEmail(email);
        if (e.isPresent())
            return new ResponseEntity<Employee>(e.get(),HttpStatus.OK);
        return new ResponseEntity<String>("Error: The employee email does not exists",HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/increment-salary",method=RequestMethod.POST,produces="application/json")
    public ResponseEntity<?> incrementSalary(@RequestParam("employeeId") long employeeId, @RequestParam("percent") double percent)
    {
        Optional<Employee> e =  employeeRepository.findById(employeeId);
        if (e.isPresent())
        {
            Employee emp = e.get();
            double salary = emp.getSalary();
            salary = (salary * percent / 100) + salary;
            if(salary < 0)
                salary = 0;
            emp.setSalary(salary);
            employeeRepository.save(emp);
            return new ResponseEntity<Employee>(emp,HttpStatus.OK);
        }
        return new ResponseEntity<String>("Error: The Employee ID does not exist", HttpStatus.BAD_REQUEST);
    }
    // Check if employee exists otherwise error
    // increment salary post /increment/emploGETyeeid=1&percent=1
}