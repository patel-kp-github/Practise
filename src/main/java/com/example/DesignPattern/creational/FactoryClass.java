package com.example.DesignPattern.creational;

public class FactoryClass {

	public static void main(String[] args) {

		CalculateFactory factory = new CalculateFactory();
		Calculate calculate = factory.getCalculate("add");
		System.out.println(calculate.calculate(10, 5));
	}
}

class CalculateFactory {
	Calculate obj = null;

	public Calculate getCalculate(String type) {

		if ("add".equalsIgnoreCase(type)) {
			obj = new Add();
		} else if ("sub".equalsIgnoreCase(type)) {
			obj = new Subtract();
		} else if ("div".equalsIgnoreCase(type)) {
			obj = new Divide();
		}
		return obj;
	}
}

interface Calculate {
	int calculate(int a, int b);
}

class Add implements Calculate {

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

}

class Subtract implements Calculate {

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

}

class Divide implements Calculate {

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a / b;
	}
}
