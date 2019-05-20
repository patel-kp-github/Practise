package com.example.Java8;

public class HelloWorld {

	public static void main(String[] args) {
		Greating anonymousGreeting = new Greating() {
			@Override
			public void print(int a) {
				// TODO Auto-generated method stub
				System.out.println("Hello world  JAVA 7 !");
			}
		};

		Greating lamdaGreeting = (a) -> System.out.println("Hello world JAVA 8 !");

		HelloWorld hello = new HelloWorld();
		hello.greeter(anonymousGreeting);
		hello.greeter(lamdaGreeting);
		hello.greeter((a) -> System.out.println("Hello world JAVA 8 !"+a));
	}

	public void greeter(Greating greeting) {
		greeting.print(10);
	}
}

@FunctionalInterface
interface Greating {
	void print(int a);
}