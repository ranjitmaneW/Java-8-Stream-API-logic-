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
}
