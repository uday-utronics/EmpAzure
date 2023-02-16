package com.azure.empsql.service.impl;

import com.azure.empsql.entity.Employee;
import com.azure.empsql.repository.EmployeeRepository;
import com.azure.empsql.service.EmployeeMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeMainServiceImpl implements EmployeeMainService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findByEmployeeId(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
