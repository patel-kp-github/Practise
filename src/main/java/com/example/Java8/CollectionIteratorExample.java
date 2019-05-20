package com.example.Java8;

import java.util.Arrays;
import java.util.List;

public class CollectionIteratorExample {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("abhay", "tiwari"), new Person("arjun", "tavan"),
				new Person("raj", "tijori"), new Person("zeeshan", "naqvi"));

		System.out.println("print all in for in loop");
		for (Person person : list) {
			System.out.println(person);
		}

		System.out.println();
		System.out.println("print all in for in loop1");
		list.forEach(p -> System.out.println(p));
		
		System.out.println();
		System.out.println("print all in for in loop2");
		list.forEach(System.out::println);//<= method reference operator

	}

}
