package com.miq.karthikbhat.SpringBootBasics.Controller;


import com.miq.karthikbhat.SpringBootBasics.Model.Employee;
import com.miq.karthikbhat.SpringBootBasics.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@ControllerAdvice
@RestController
@RequestMapping("/employee")
public class EmployeeController extends ResponseEntityExceptionHandler {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee, MethodArgumentNotValidException ex){

        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
    }
    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public String deleteAll(){
        employeeRepository.deleteAll();

        return "Success";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> returnAll(){
        List<Employee> employeeList = employeeRepository.findAll();
        if(employeeList.isEmpty())
            return new ResponseEntity<String>("There are no employees as of now", HttpStatus.OK);
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> returnOne(@PathVariable ("id") long employeeId){
        try {
            return new ResponseEntity<Employee>(employeeRepository.findById(employeeId).get(), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<String>("No such employee exists", HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/getByEmail", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> returnByEmail(@RequestParam("email") String email){
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(email);

        if(optionalEmployee.isPresent())
            return new ResponseEntity<Employee>(employeeRepository.findByEmail(email).get(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("No employee by that email found", HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/updateSalary", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> updateSalary(@RequestParam("employeeId") long employeeId, @RequestParam ("percent") double percent){
        Optional<Employee>  optionalEmployee= employeeRepository.findById(employeeId);

        if(!optionalEmployee.isPresent()){
            return new ResponseEntity<String>("Employee not found. Use another employeeId.", HttpStatus.BAD_REQUEST);
        }
        else{
            Employee employee = optionalEmployee.get();
            employee.setSalary(employee.getSalary() + employee.getSalary()*percent);

            Employee updatedEmployee = employeeRepository.save(employee);

            return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
        }
    }



}
