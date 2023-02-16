package com.azure.empsql.repository;

import com.azure.empsql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("SELECT e FROM Employee e WHERE e.id = :id")
    Optional<Employee> findByEmployeeId(@Param("id") Integer id);
}
