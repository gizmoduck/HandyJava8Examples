package com.advance.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.advance.java.Employee;

public class OperationUsingStream {
	
	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Tom", "Cruize", "Acting", 100.50, 56));
		employees.add(new Employee(2, "Tom", "Hardy", "Acting", 90.40, 41));
		employees.add(new Employee(3, "Christopher", "Nolan", "Production", 150, 48));
		employees.add(new Employee(4, "Steven", "Spielberg", "Production", 200, 71));
		employees.add(new Employee(5, "Tom", "Hanks", "Acting", 140, 62));

		System.out.println("==================== COUNT ===================");
		int count = (int) employees.stream().count();
		System.out.println(count);

		System.out.println("==================== MIN & MAX Age ===================");
		Employee minAgeEmployee =  employees.stream()
				.min((e1,e2) -> (int)(e1.getAge() - e2.getAge()))
						.get();

		System.out.println("Min Age Emp : " + minAgeEmployee.toString());
		System.out.println("--------------------------");
		Employee maxAgeEmployee =  employees.stream()
				.max((e1,e2) -> (int)(e1.getAge() - e2.getAge()))
						.get();

		System.out.println("Max Age Emp : " + maxAgeEmployee.toString());

		System.out.println("==================== Sum Salary ===================");

		double sumSalaryOfAllEmployee = employees.stream()
				.mapToDouble(emp -> emp.getSalary())
				.sum();
		System.out.println(" Salary Sum : " + sumSalaryOfAllEmployee);
		
		System.out.println("==================== Group By department ===================");
		Map<String, Long> empGroupCount = employees.stream()
		.collect(Collectors.groupingBy(Employee ::getDepartment, Collectors.counting()));
		
		for(String department : empGroupCount.keySet()) {
			System.out.println("Department : " + department);
			System.out.println("Number of Emp : " + empGroupCount.get(department));
		}
		
		System.out.println("==================== Group By : Total salary by department ===================");
		Map<String, Double> empGroup = employees.stream()
		.collect(Collectors.groupingBy(Employee ::getDepartment, Collectors.summingDouble(Employee::getSalary)));
		
		for(String department : empGroup.keySet()) {
			System.out.println("Department : " + department);
			System.out.println("total Salary of department : " + empGroup.get(department));
		}
	}
	
	


}
