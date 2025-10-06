//   Write a J ava program to sort a list of employees (id, name, salary) by salary using Comparator.


package main;

import java.util.*;

class employee {
    private final int id;
    private final String name;
    private final double salary;

    public employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}

class SalaryComparator implements Comparator<employee> {
    @Override
    public int compare(employee e1, employee e2) {
        // Sort in ascending order
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}

public class employeeSort {
    public static void main(String[] args) {
        List<employee> employees = new ArrayList<>();
        employees.add(new employee(101, "karthi", 50000));
        employees.add(new employee(102, "guttha", 75000));
        employees.add(new employee(103, "Durga", 60000));
        employees.add(new employee(104, "suhail", 45000));

        System.out.println("Before Sorting:");
        for (employee e : employees) {
            System.out.println(e);
        }

        Collections.sort(employees, new SalaryComparator());

        System.out.println("\nAfter Sorting by Salary (Ascending):");
        for (employee e : employees) {
            System.out.println(e);
        }

        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("\nAfter Sorting by Salary (Descending):");
        employees.forEach(System.out::println);
    }
}
