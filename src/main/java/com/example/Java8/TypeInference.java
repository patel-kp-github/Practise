package com.example.Java8;

public class TypeInference {

	public static void main(String[] args) {
		// 1st way
		StringLength slength = (String str) -> str.length();
		System.out.println(slength.getLength("Hello"));

		//2nd way , we can remove variable type and if 1 input then paranthisis
		StringLength slength2 = str -> str.length();
		System.out.println(slength.getLength("Hello"));
		slength.m1();
	}
}

@FunctionalInterface
interface StringLength {
	int getLength(String str);
	default void m1() {
		System.out.println("hello m1");
	}
}
