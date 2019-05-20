package com.example.DS.LL;

public class CircularLL {
	CircularLL(int size) {
		this.size = size;
	}

	int size;
	int elementSize = 0;
	Node head = null;
	int count = 1;
	public void insert(int i) {
		int index = elementSize % size;
		if (head == null) {
			Node newNode = new Node(i);
//			newNode.next = head;
			head = newNode;
			elementSize++;
		} else {
			 
			Node current = head;
			while (current != null) {
				System.out.println(count+" "+index);
				if (count == index) {
					Node newNode = new Node(i);
					current.next = newNode;
//					newNode.next = head;
					elementSize++;
				}
				current = current.next;
				count++;
			}
		}
		System.out.println("data inserted:" + i);
	}

	public void display() {
		if (head == null) {
			System.out.println("LL is empty");
			return;
		} else {
			Node current = head;
			while (current.next != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println(current.data);
		}
	}

	public static void main(String[] args) {
		CircularLL ll = new CircularLL(5);
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);
		ll.insert(6);
		ll.insert(7);
		ll.display();
	}

}
