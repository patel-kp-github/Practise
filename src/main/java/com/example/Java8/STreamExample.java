package com.example.Java8;

import java.util.Arrays;
import java.util.List;

public class STreamExample {
	
	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("abhay", "tiwari"), new Person("arjun", "tavan"),
				new Person("raj", "tijori"), new Person("zeeshan", "naqvi"));

		System.out.println("print all in for in loop");
		for (Person person : list) {
			System.out.println(person);
		}

		System.out.println();
		System.out.println("print all in Lambda:");
		list.stream()
		.forEach(System.out::println);

		System.out.println();
		System.out.println("print all in Lambda:");
		list.stream().filter(p -> p.getLastName().startsWith("t"))
		.forEach(System.out::println);
		
		System.out.println();
		System.out.println("print count:");
		long count=list.stream().filter(p -> p.getLastName().startsWith("t"))
		.count();
		System.out.println("count:"+count);
		
		list.stream().forEach(System.out::println);
	}

}
