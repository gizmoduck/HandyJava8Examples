package com.advance.java.java8.defaultstaticfunctions;

public interface TestDefaultInterface1 {
	
	void method1(String s);
	default void log (String s) {
		System.out.println("Interface1 log :: " + s);
	}

}
