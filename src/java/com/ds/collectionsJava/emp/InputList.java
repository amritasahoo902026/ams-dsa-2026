package com.ds.collectionsJava.emp;

import java.util.*;
import java.util.stream.Collectors;

public class InputList {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "IT", 70000,
                        Arrays.asList("Java", "Spring", "Kafka")),

                new Employee(2, "Mike", "IT", 80000,
                        Arrays.asList("Java", "Spring")),

                new Employee(3, "David", "HR", 60000,
                        Arrays.asList("Excel")),

                new Employee(4, "Sam", "HR", 65000,
                        Arrays.asList("Excel", "SQL")),

                new Employee(5, "Alex", "IT", 75000,
                        Arrays.asList("Java", "Spring", "Docker"))
        );

        //employees.stream().distinct()
      //  employees.forEach(System.out::println);
        Map<String, List<String>> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));

        Optional<Employee> hihestemp = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));

       // System.out.println("Highest "+hihestemp.get());

        //Print all employee names using forEach().
        //employees.stream().forEach(employee -> System.out.println(employee));
        //Find employees whose salary is greater than ₹75,000.

       // employees.stream().filter(employee -> employee.getSalary()>75000).forEach(System.out::println);

        //Get a list of all employee names using map().
        List<String> empNames=employees.stream().map(e->e.getName()).collect(Collectors.toList());
       // System.out.println(empNames);

        //Find all employees who work in IT

        List<Employee> empOfIT=employees.stream().filter(employee -> employee.getDepartment()=="IT").collect(Collectors.toList());
        //System.out.println(empOfIT);

        //Find employees whose names start with 'S'.

        List<Employee> nameStartsWithS=employees.stream().filter(employee -> employee.getName().charAt(0)=='S').collect(Collectors.toList());

        //System.out.println(nameStartsWithS);

       // List<Employee> sortEmp=employees.stream().collect(Collectors.groupingBy(Employee::getSalary),Comparator.comparingDouble());


    }
}