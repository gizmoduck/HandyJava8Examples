package com.advance.java.java8.parallelstream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.advance.java.Employee;

public class ParallelSequentialComparision {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			employees.add(new Employee(1, "Tom", "Cruize", "Acting", 100.50, 56));
			employees.add(new Employee(2, "Tom", "Hardy", "Acting", 90.40, 41));
			employees.add(new Employee(3, "Christopher", "Nolan", "Production", 150, 48));
			employees.add(new Employee(4, "Steven", "Spielberg", "Production", 200, 71));
			employees.add(new Employee(5, "Tom", "Hanks", "Acting", 140, 62));
		}
		
		long t1 = System.currentTimeMillis();
		System.out.println("Sequential Stream count : "+ employees.stream().filter(emp -> emp.getSalary() > 100).count());
		long t2 = System.currentTimeMillis();
		System.out.println("sequential Time taken :" + (t2-t1));
		
		long t3 = System.currentTimeMillis();
		
		System.out.println("Parallel Stram count : "+ employees.parallelStream().filter(emp -> emp.getSalary() > 100).count());
		long t4 = System.currentTimeMillis();
		System.out.println("Parallel Time taken :"+ (t4-t3) );
		
		System.out.println("========== Map Reduce using Parallel & Sequential stream ===============");
		testMapReduce();
	}

	private static void testMapReduce() {
		long parallelTime = 0;
		long sequentialTime = 0;
		long time;
		BigDecimal sum;
		
		for (int i = 0; i <= 5; i++) {
			time = System.currentTimeMillis();
			sum = Stream.generate(() -> new BigDecimal(Math.random() * 10000)).limit(1000000).parallel()
					.map(b -> b.multiply(BigDecimal.TEN))
					.reduce(BigDecimal.ZERO, (a,b) -> a.add(b));
			if (i > 0) {
				parallelTime += (System.currentTimeMillis() - time);
			}
			time = System.currentTimeMillis();
			sum = Stream.generate(() -> new BigDecimal(Math.random() * 10000)).limit(1000000).sequential()
					.map(b -> b.multiply(BigDecimal.TEN))
					.reduce(BigDecimal.ZERO, (a,b) -> a.add(b));
			if (i > 0) {
				sequentialTime += (System.currentTimeMillis() - time);
			}
		}
		System.out.println("Average Time for parallel Calculation : " + parallelTime/5);
		System.out.println("Average Time for sequential Calculation : " + sequentialTime/5);
		
	}
	

}
