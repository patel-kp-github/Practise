package com.example.Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonListJava7 {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("abhay", "tiwari"), new Person("arjun", "tavan"),
				new Person("raj", "tijori"), new Person("zeeshan", "naqvi"));

		// step 1: sort by lastname
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});

		// step 2: print all
		System.out.println("print all:");
		printAll(list);

		// step 2: print all which lastname start with t
		System.out.println("print all which lastname start with t:");
		printAll(list, new Condition() {
			@Override
			public boolean test(Person p) {
				// TODO Auto-generated method stub
				if (p.getLastName().startsWith("t"))
					return true;
				return false;
			}
		});
	}

	private static void printAll(List<Person> list, Condition condition) {
		for (Person person : list) {
			if (condition.test(person))
				System.out.println(person);
		}

	}

	private static void printAll(List<Person> list) {
		for (Person person : list) {
			System.out.println(person);
		}

	}

}

class Person {
	String firstName;
	String lastName;

	Person(String fname, String lname) {
		firstName = fname;
		lastName = lname;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String toString() {
		return firstName + " " + lastName;
	}
}

interface Condition {
	boolean test(Person p);
}