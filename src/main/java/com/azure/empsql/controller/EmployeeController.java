package com.azure.empsql.controller;

import com.azure.empsql.entity.Employee;
import com.azure.empsql.service.EmployeeMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeMainService employeeMainService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeMainService.saveEmployee(employee);
    }

    @GetMapping("/findByID/{id}")
    public Optional<Employee> findById(@PathVariable Integer id){
        return employeeMainService.findById(id);
    }
    @GetMapping("/findAll")
    public List<Employee> findAllEmployees(){
        return employeeMainService.findAllEmployees();
    }
}
