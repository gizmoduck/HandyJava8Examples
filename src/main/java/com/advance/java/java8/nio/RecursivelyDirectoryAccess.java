package com.advance.java.java8.nio;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class RecursivelyDirectoryAccess {

	public static void main(String[] args) throws IOException {
		String path = "/Users/achark/workspace/personal-repo";
		Path startDir = Paths.get(path);
		String fileTypePattern = "*.{java,txt,xml}";
		
		FileSystem fileSystem = FileSystems.getDefault();
		// syntax:pattern
		//where ':' stands for itself.
		//A FileSystem implementation supports the "glob" and "regex" syntaxes, and may support others. The value of the syntax component is compared without regard to case.
		//When the syntax is "glob" then the String representation of the path is matched using a limited pattern language that resembles regular expressions but with a simpler syntax. For example:
		//*.java	Matches a path that represents a file name ending in .java 
		
		PathMatcher pathMatcher = fileSystem.getPathMatcher("glob:" + fileTypePattern);
		FileVisitor fileVisitor = new SimpleFileVisitor() {
			@Override
			public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
				Path name = ((Path) file).getFileName();
				if (pathMatcher.matches(name)) {
					System.out.println("Found Matched File : "+ name);
				}
				return FileVisitResult.CONTINUE;
			}
		};
		Files.walkFileTree(startDir, fileVisitor);
	}

}
