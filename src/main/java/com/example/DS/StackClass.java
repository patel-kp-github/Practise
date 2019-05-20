package com.example.DS;

public class StackClass {

	int top = -1, size = 0, len = 0;
	private int arr[];

	public StackClass(int n) {
		arr = new int[n];
		len = n;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == (len - 1);
	}

	public void push(int i) {
		if (isFull()) {
			System.out.println("stack is full");
			return;
		}
		System.out.println(i + " is pushed");
		arr[++top] = i;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		}
		int i = arr[top--];
		System.out.println(i + " is poped");
		return i;
	}

	public static void main(String[] args) {
		StackClassLL stackLL = new StackClassLL();

		stackLL.push(1);
		stackLL.push(2);
		stackLL.push(3);
		stackLL.push(4);
		stackLL.push(5);
		stackLL.push(6);

		stackLL.display();

		stackLL.pop();
		stackLL.display();

//		stackLL.pop();
//		stackLL.pop();
//		stackLL.pop();
//		stackLL.pop();
//		stackLL.pop();
	}
}

class StackClassLL {
	Node head;

	public void push(int i) {
		// TODO Auto-generated method stub
		if (head == null)
			head = new Node(i);
		else {
			Node current = new Node(i);
			current.next = head;
			head = current;
		}
		System.out.println("pushed:" + i);
	}

	public void pop() {
		// TODO Auto-generated method stub
		if (head == null) {
			System.out.println("not found");
			return;
		} else {
			Node current = head;
			System.out.println("poped:" + current.data);
			head = head.next;
		}
	}

	public void display() {
		System.out.println("display elements:");
		if (head == null) {
			System.out.println("not found");
			return;
		} else {
			Node current = head;
			while (current != null) {
				System.out.println(current.data);
				current = current.next;
			}
		}
	}

}

class Node {
	Node next;
	int data;

	public Node(int i) {
		data = i;
	}
}