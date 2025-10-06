//  Write a Java program to implement a custom immutable class Employee with fields id, name, and salary.


package main;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class immutableEmp {

    private int id;
    private String name;
    private double salary;

    public immutableEmp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class testImmutable {
    public static void main(String[] args) {
        immutableEmp emp1 = new immutableEmp(101, "Karthik", 15000.0);
        immutableEmp emp2 = new immutableEmp(102, "karthi", 55000.0);
        immutableEmp emp3 = new immutableEmp(103, "Guttha", 22000.0);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);


        System.out.println("Employee ID: " + emp1.getId());
        System.out.println("Employee Name: " + emp1.getName());
        System.out.println("Employee Salary: " + emp2.getSalary());
    }
}
