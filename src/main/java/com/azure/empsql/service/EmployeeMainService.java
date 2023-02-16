package com.azure.empsql.service;

import com.azure.empsql.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeMainService {

    Employee saveEmployee(Employee employee);

    Optional<Employee> findById(Integer id);

    List<Employee> findAllEmployees();
}
