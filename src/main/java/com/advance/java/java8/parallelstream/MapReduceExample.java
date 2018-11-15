package com.advance.java.java8.parallelstream;

import java.util.ArrayList;
import java.util.List;

import com.advance.java.Employee;

public class MapReduceExample {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < 10000000; i++) {
			employees.add(new Employee(i + 1, "Tom", "Cruize", "Acting", 100.50, 56));
			employees.add(new Employee(i + 2, "Tom", "Hardy", "Acting", 90.40, 41));
			employees.add(new Employee(i + 3, "Christopher", "Nolan", "Production", 150, 48));
			employees.add(new Employee(i + 4, "Steven", "Spielberg", "Production", 200, 71));
			employees.add(new Employee(i + 5, "Tom", "Hanks", "Acting", 140, 62));
		}

		System.out.println("========== MAP REDUCE =================");
		System.out.println(
				"===Essentially we map a set of values then we reduce it with a function such as average or sum into a single number.====");

		mapReduceOldImpl(employees);
		mapReduceJava8StreamImpl(employees);
		mapReduceJava8ParallelStreamImpl(employees);
	}

	private static void mapReduceJava8ParallelStreamImpl(List<Employee> employees) {
		long t1 = System.currentTimeMillis();
		System.out.println("Average Salary MapReduce Java 8 : "
				+ employees.parallelStream().mapToDouble(emp -> emp.getSalary()).average().getAsDouble());
		System.out.println("Time taken for operation Parallel Stream Java 8 : " + (System.currentTimeMillis() - t1));
	}

	private static void mapReduceJava8StreamImpl(List<Employee> employees) {
		long t2 = System.currentTimeMillis();
		System.out.println("Average Salary MapReduce Java 8 : "
				+ employees.stream().mapToDouble(emp -> emp.getSalary()).average().getAsDouble());
		System.out.println("Time taken for operation normal Stream Java 8 : " + (System.currentTimeMillis() - t2));
	}

	private static void mapReduceOldImpl(List<Employee> employees) {
		long t1 = System.currentTimeMillis();
		double total = 0;
		for (Employee emp : employees) {
			total += emp.getSalary();
		}
		System.out.println("Average Salary Old implementation : " + total / employees.size());
		System.out.println("Time taken for operation Old way : " + (System.currentTimeMillis() - t1));
	}

}
