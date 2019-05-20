package com.example.DesignPattern.creational;

public class PrototypeClass {
	public static void main(String[] args) {
		MyPro obj = new MyPro();
		obj.getValue();
	}
}

class MyPro implements Cloneable {
	int a = 10;

	public void getValue() {
		System.out.println("value:" + a);
	}
}