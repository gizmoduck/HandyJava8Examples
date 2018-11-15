package com.advance.java.java8.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.advance.java.Employee;

public class ReadCSVFIleInStream {

	public static void main(String[] args) throws IOException {
		String path = "/Users/achark/workspace/personal-repo/tempdir/test.csv";
		List<Employee> employees = new ArrayList<>();
		Stream<String> stream = Files.lines(Paths.get(path));
		employees = stream
				.map(line -> {
					//Arrays.asList(line.s)
					String [] result = line.split(",");
					return new Employee(Integer.parseInt(result[0]), result[1], result[2], 
							result[3], Double.parseDouble(result[4]), Integer.parseInt(result[5]));
				})
				.collect(Collectors.toList());
		
		employees.stream()
		.forEach(emp -> {
			System.out.println(emp.toString());
		});
	}

}
