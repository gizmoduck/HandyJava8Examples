package com.advance.java.java8.defaultstaticfunctions;

public interface TestInterface2 {
	
	void method2();
	default void log(String s) {
		System.out.println("Interface 2 log :"+ s);
	}

}
