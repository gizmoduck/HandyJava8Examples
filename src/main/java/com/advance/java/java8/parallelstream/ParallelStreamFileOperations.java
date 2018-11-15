package com.advance.java.java8.parallelstream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ParallelStreamFileOperations {

	public static void main(String[] args) throws IOException {
		//long t1 = System.currentTimeMillis();
		long t1 = Instant.now().toEpochMilli();
		ConcurrentHashMap<String, Number> wordCounts = new ConcurrentHashMap<>();
		System.out.println("Reading file from ");
		Path filePath = Paths.get("");
		
		Files.readAllLines(filePath)
		.parallelStream()
		.map(line -> line.split("\\s+")).flatMap(Arrays::stream).parallel()
		.filter(w -> w.matches("\\w+"))
		.map(String::toLowerCase)
		.forEach(word -> {
			if (!wordCounts.containsKey(word)) {
				wordCounts.put(word, new LongAdder());
			}
			((LongAdder) wordCounts.get(word)).increment();
		});

	}

	
}
