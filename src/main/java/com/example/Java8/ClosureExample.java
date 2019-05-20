package com.example.Java8;

public class ClosureExample {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
//we can pass variable in this scope , it is not need to be final neccessaary
		// but it should not be changed
		// this is called closure

		// diff bn anonymous class and Lambda is Lambda not allow this keyword in static
		// scope
		doProcess(() -> System.out.println(a + b));

	}

	public static void doProcess(Process pro) {
		pro.process();
	}
}

interface Process {
	void process();
}
