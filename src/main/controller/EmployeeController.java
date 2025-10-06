package main.controller;


import main.controller.EmployeeController;
import main.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        // Sample in-memory list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "manju", 50000));
        employees.add(new Employee(102, "suhail", 60000));
        employees.add(new Employee(103, "shravani", 55000));

        return employees; // Spring Boot converts to JSON automatically
    }
}
