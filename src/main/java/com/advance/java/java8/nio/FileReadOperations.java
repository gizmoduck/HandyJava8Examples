package com.advance.java.java8.nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileReadOperations {

	public static void main(String[] args) throws IOException {
		String path = "/Users/achark/workspace/personal-repo/tempdir/test.txt";
		System.out.println("============Read file line by line=========");
		List<String> lines = Files.readAllLines(Paths.get(path));
		for (String line : lines) {
			System.out.println(line);
		}
		
		System.out.println("============Read file to a stream =========");
		Stream<String> streamOfLine = Files.lines(Paths.get(path), StandardCharsets.UTF_8);
		streamOfLine.forEach(line -> {
			System.out.println(line);
		});
		streamOfLine.close();
		
		
		System.out.println("============Read file to a String =========");
		
		String fileAsString = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		System.out.println(fileAsString);
	}
	
	

}
