package com.example.Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PersonListJava8 {
	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("abhay", "tiwari"), new Person("arjun", "tavan"),
				new Person("raj", "tijori"), new Person("zeeshan", "naqvi"));

		// step 1: sort by lastname
		Collections.sort(list, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

		// step 2: print all
		System.out.println("print all:");
		printAll(list, p -> true, p -> System.out.println(p));

		// step 2: print all which lastname start with t
		System.out.println();
		System.out.println("print all which lastname start with t:");
		printAll(list, p -> (p.getLastName().startsWith("t")), p -> System.out.println(p));

	}

	/*
	 * private static void printAll(List<Person> list, Condition condition) { for
	 * (Person person : list) { if (condition.test(person))
	 * System.out.println(person); }
	 * 
	 * }
	 */

	// Using Predicate interface given by java 8
	// it has test method for boolen return type
	private static void printAll(List<Person> list, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person person : list) {
			if (predicate.test(person))
				consumer.accept(person);
		}

	}

}