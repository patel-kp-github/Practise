package com.example.DS.questions;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Practise5 {

	void Practise5() {

	}

	public static void main(String[] args) {
//		System.out.println(new Practise5());
		Map m = new HashMap();
		System.out.println(1 << 50);
		System.out.println(100>>5);
//		System.out.println(m.put("a, "bgg"));
//		System.out.println(m.put("a", bk"));

//		Demo demo = () -> System.out.println("check demo");
//		
//		demo.print();
//		demo.checkDefault();
////		demo.
//		new Demo.in().checkIn();

	}
}

@FunctionalInterface
interface Demo {
	public void print();
	default void checkDefault() {
		System.out.println("check default");
	}

	class in {
		void checkIn() {
			System.out.println("inner class");
		}
	}
}