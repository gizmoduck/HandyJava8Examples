package com.advance.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;

import com.advance.java.Employee;

public class SortingAndMore {
	
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Tom", "Cruize", "Acting", 100.50, 56));
		employees.add(new Employee(2, "Tom", "Hardy", "Acting", 90.40, 41));
		employees.add(new Employee(3, "Christopher", "Nolan", "Production", 150, 48));
		employees.add(new Employee(4, "Steven", "Spielberg", "Production", 200, 71));
		employees.add(new Employee(5, "Tom", "Hanks", "Acting", 140, 62));
		
		System.out.println("==================== SORT ===================");
		System.out.println("Sorting list using stream API");
		System.out.println("Ascending order of Age ");
		employees.stream()
		.sorted((e1, e2) ->  (e1.getAge() - e2.getAge()))
		.forEach(emp -> {
			System.out.println(emp.toString());
		});
		
		System.out.println("=======================================");
		
		System.out.println("Dscending order of Age ");
		employees.stream()
		.sorted((e1, e2) ->  (e2.getAge() - e1.getAge()))
		.forEach(emp -> {
			System.out.println(emp.toString());
		});
		
		System.out.println("=================== LIMIT ====================");
	
		System.out.println("Dscending order sort on Age limit 3");
		employees.stream()
		.sorted((e1, e2) ->  (e2.getAge() - e1.getAge()))
		.limit(3)
		.forEach(emp -> {
			System.out.println(emp.toString());
		});
		
		System.out.println("=================== FIND FIRST ====================");
		
		System.out.println("Dscending order sort on Age limit 3");
		Employee e = employees.stream()
		.sorted((e1, e2) ->  (e2.getAge() - e1.getAge()))
		.findFirst()
		.get();
		System.out.println(e.toString());
	
		
	}
	
	

}
