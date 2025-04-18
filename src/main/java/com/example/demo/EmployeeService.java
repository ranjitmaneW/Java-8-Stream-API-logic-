package com.example.demo;


import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private  List<Employee> employees = Arrays.asList(
        new Employee(1L, "John", "IT", 60000, true),
        new Employee(2L, "Alice", "HR", 45000, true),
        new Employee(3L, "Bob", "IT", 70000, false),
        new Employee(4L, "David", "Sales", 55000, true),
        new Employee(5L, "Emma", "HR", 48000, true)
    );

    public List<String> getActiveEmployeeNames() {
        return employees.stream()
                .filter(Employee::isActive)
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public Map<String, Long> countEmployeesByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    public Optional<Employee> getHighestPaidEmployee() {
        return employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
    
    
    

    // sorted()
    public List<Employee> getEmployeesSortedBySalaryDesc() {
        return employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }

    // distinct() with names
    public List<String> getDistinctEmployeeNames() {
        return employees.stream()
                .map(Employee::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    // limit()
    public List<Employee> getTop3HighestPaid() {
        return employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .limit(3)
                .collect(Collectors.toList());
    }

    // count()
    public long countActiveEmployees() {
        return employees.stream()
                .filter(Employee::isActive)
                .count();
    }
    
    
    
}
