package com.advance.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;

import com.advance.java.Employee;

public class ForEachLambda {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Tom", "Cruize", "Acting", 100.50, 56));
		employees.add(new Employee(2, "Tom", "Hardy", "Acting", 90.40, 41));
		employees.add(new Employee(3, "Christopher", "Nolan", "Production", 150, 48));
		employees.add(new Employee(4, "Steven", "Spielberg", "Production", 200, 71));
		employees.add(new Employee(5, "Tom", "Hanks", "Acting", 140, 62));
		
		System.out.println("Print List of employees using forEach");
		
		employees.forEach(emp -> {
			System.out.println(emp.toString());
			System.out.println("----------------------");
		});
		
		
		
	}

}
