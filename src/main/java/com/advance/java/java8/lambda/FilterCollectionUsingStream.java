package com.advance.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;

import com.advance.java.Employee;

public class FilterCollectionUsingStream {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Tom", "Cruize", "Acting", 100.50, 56));
		employees.add(new Employee(2, "Tom", "Hardy", "Acting", 90.40, 41));
		employees.add(new Employee(3, "Christopher", "Nolan", "Production", 150, 48));
		employees.add(new Employee(4, "Steven", "Spielberg", "Production", 200, 71));
		employees.add(new Employee(5, "Tom", "Hanks", "Acting", 140, 62));
		
		System.out.println("Filter Collection using Stream API  on department \n");
		employees.stream()
		.filter(emp -> emp.getDepartment().equalsIgnoreCase("Production"))
		.forEach(emp -> {
			System.out.println(emp.toString());
			System.out.println("-------------------");
		});
		
		System.out.println("Filter collection  with And condion");
		employees.stream()
		.filter(emp -> emp.getDepartment().equalsIgnoreCase("Production") 
				&& emp.getSalary() > 150)
		.forEach(e -> {
			System.out.println(e.toString());
			System.out.println("-------------------");
		});
		
		System.out.println("Filter collection using like operator startsWith, endsWith, contains\n");
		employees.stream()
		.filter(emp -> (emp.getFristName().startsWith("T") || emp.getDepartment().endsWith("g"))
				& emp.getLastname().contains("ard"))
		.forEach(emp -> {
			System.out.println(emp.toString());
			System.out.println("-------------------");
		});
	}

}
