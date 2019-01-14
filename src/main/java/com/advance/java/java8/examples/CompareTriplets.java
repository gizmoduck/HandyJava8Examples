package com.advance.java.java8.examples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.print.attribute.standard.JobOriginatingUserName;


public class CompareTriplets {

	public static void main(String[] args) throws IOException {
		String path = "/Users/achark/workspace/personal-repo/tempdir/compareTriplets.txt";

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path), StandardOpenOption.CREATE);
		
		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		//List<Integer> result = compareTripletsNew(a,b);
		List<Integer> result = compareTripletOldWay(a,b);
		
		System.out.println(result.toString());
		bufferedWriter.write(result.stream()
				.map(Object::toString)
				.collect(Collectors.joining(" "))+"\n");
		
		bufferedReader.close();
		bufferedWriter.close();
	}

	private static List<Integer> compareTripletsNew(List<Integer> a, List<Integer> b) {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(0);
        resultList.add(0);
        a.stream()
        .forEach(val -> {
        	if (val > b.get(a.indexOf(val))) {
        		resultList.set(0, resultList.get(0)+1);
        	} else if (val < b.get(a.indexOf(val))) {
        		resultList.set(1, resultList.get(1)+1);
        	}
        });
		return resultList;
	}
	
	private static List<Integer> compareTripletOldWay(List<Integer> a, List<Integer> b) {
		List<Integer> resultList = new ArrayList<>();
        int scoreA = 0;
        int scoreB = 0;
        for (int i = 0; i < 3; i ++) {
            if (a.get(i) == b.get(i)) {
                scoreA = scoreA;
                scoreB = scoreB;
            } else if (a.get(i) > b.get(i)) {
                scoreA++;
            } else {
                scoreB++;
            }
        }
        resultList.add(scoreA);
        resultList.add(scoreB);
        return resultList;
	}

}
