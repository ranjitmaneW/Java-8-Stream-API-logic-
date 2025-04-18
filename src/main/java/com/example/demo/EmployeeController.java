package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
@Autowired
    private  EmployeeService service;

   

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/active-names")
    public List<String> getActiveEmployeeNames() {
        return service.getActiveEmployeeNames();
    }

    @GetMapping("/count-by-department")
    public Map<String, Long> countByDepartment() {
        return service.countEmployeesByDepartment();
    }

    @GetMapping("/highest-paid")
    public Employee getHighestPaidEmployee() {
        return service.getHighestPaidEmployee().orElse(null);
    }
    
    
    

    @GetMapping("/sorted")
    public List<Employee> getSorted() {
        return service.getEmployeesSortedBySalaryDesc();
    }

    @GetMapping("/distinct-names")
    public List<String> getDistinctNames() {
        return service.getDistinctEmployeeNames();
    }

    @GetMapping("/top3")
    public List<Employee> getTop3() {
        return service.getTop3HighestPaid();
    }

    @GetMapping("/active-count")
    public long getActiveCount() {
        return service.countActiveEmployees();
    }
    
    
    
    
    
}
