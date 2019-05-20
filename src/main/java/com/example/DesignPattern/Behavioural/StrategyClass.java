package com.example.DesignPattern.Behavioural;

/*
 * Strategy pattern is used when we have multiple algorithm for a specific task 
 * and client decides the actual implementation to be used at runtime.
 * 
 * ex=> Collections.sort()
 */
public class StrategyClass {
	public static void main(String[] args) {
		Context context = new Context(new OperationAdd());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationSubstract());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

	}
}

interface Strategy {
	public int doOperation(int num1, int num2);
}

class OperationAdd implements Strategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 + num2;
	}
}

class OperationSubstract implements Strategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 - num2;
	}
}

class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2) {
		return strategy.doOperation(num1, num2);
	}
}
