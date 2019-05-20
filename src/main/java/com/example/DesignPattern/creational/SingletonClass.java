package com.example.DesignPattern.creational;

public class SingletonClass {
	public static void main(String[] args) {

		MySingle obj1 = MySingle.getInstance();
		MySingle obj2 = MySingle.getInstance();
		System.out.println(obj1);
		System.out.println(obj2);
		if (obj1 == obj2)
			System.out.println("same instance");
	}
}

class MySingle {
	private static MySingle obj;

	private MySingle() {

	}

	public static MySingle getInstance() {
		if (obj == null)
			obj = new MySingle();
		return obj;
	}
}
