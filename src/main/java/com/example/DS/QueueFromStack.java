package com.example.DS;

import java.util.Stack;

public class QueueFromStack {

	Stack s1 = new Stack<Integer>();
	Stack s2 = new Stack<Integer>();

	public static void main(String[] args) {
		QueueFromStack s = new QueueFromStack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

	public void push(int value) {

		while (!s1.empty()) {
			s2.push(s1.pop());
		}
		s1.push(value);
		while (!s2.empty()) {
			s1.push(s2.pop());
		}
	}

	public int pop() {
		return (int) s1.pop();
	}

}
