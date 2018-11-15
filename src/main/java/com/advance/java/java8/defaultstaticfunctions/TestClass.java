package com.advance.java.java8.defaultstaticfunctions;

public class TestClass implements TestInterface2, TestDefaultInterface1 {

	@Override
	public void method1(String s) {
		System.out.println("Method 1 of interface1 from my class" + s);
	}

	@Override
	public void method2() {
		System.out.println("Method2 of interface2 from my class");
	}
	
	public void log(String s) {
		System.out.println("My class logging ::" + s);
		TestInterface2.super.log("abd");
	}

}
