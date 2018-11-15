package com.advance.java.java8.defaultstaticfunctions;

public class TestMainClass {

	public static void main(String[] args) {
		TestDefaultInterface1 inter1 = new TestClass();
		inter1.method1("main method call");
		inter1.log("main call");
		
		TestInterface2 inter2 = new TestClass();
		inter2.method2();
		inter2.log("main class inter2");
	}

}
