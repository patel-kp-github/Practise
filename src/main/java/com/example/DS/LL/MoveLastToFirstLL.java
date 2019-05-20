package com.example.DS.LL;

public class MoveLastToFirstLL {

	Node head = null;

	public void insert(int i) {
		if (head == null)
			head = new Node(i);
		else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(i);
		}
		System.out.println("data inserted:" + i);
	}

	private void moveLastToHead() {
		// TODO Auto-generated method stub
		Node current = head;
		if (head == null)
			return;
		else {
			Node prev = head;
			while (current.next != null) {
				prev = current;
				current = current.next;
			}
			prev.next = null;
			current.next = head;
			head = current;
		}

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
		MoveLastToFirstLL ll = new MoveLastToFirstLL();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);
		ll.display();
		ll.moveLastToHead();
		ll.display();
	}
}
