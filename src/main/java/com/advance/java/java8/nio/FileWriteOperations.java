package com.advance.java.java8.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriteOperations {

	public static void main(String[] args) throws IOException {
		String path = "/Users/achark/workspace/personal-repo/tempdir/test.txt";
		
		System.out.println("========== Write file Operation using Files.write ========");
		String content = "TEST CONTENT.";
		Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.APPEND);
		Files.lines(Paths.get(path)).forEach(line -> {
			System.out.println(line);
		});
		
		System.out.println("========== Write file Operation using BufferWriter ========");
		String bContent = "Buffer Writer content.";
		BufferedWriter  writer = Files.newBufferedWriter(Paths.get(path), StandardOpenOption.APPEND);
		writer.write(bContent);
		writer.close();
		Files.lines(Paths.get(path)).forEach(line -> {
			System.out.println(line);
		});
	}

}
