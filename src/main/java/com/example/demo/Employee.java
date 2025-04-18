package com.example.demo;

public class Employee {
    private Long id;
    private String name;
    private String department;
    private double salary;
    private boolean active;

    public Employee(Long id, String name, String department, double salary, boolean active) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }

    // Getters only (for JSON response)
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public boolean isActive() { return active; }
}
