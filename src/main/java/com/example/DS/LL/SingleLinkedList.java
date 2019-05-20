package com.example.DS.LL;

class Node {
	Node next;
	int data;

	public Node(int i) {
		data = i;
	}
}

public class SingleLinkedList {
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

	 
	public void deleteByData(int i) {
		if (head == null) {
			System.out.println("LL is empty");
			return;
		}
		if (head.data == i) {
			head = head.next;
			System.out.println("data found:" + i);
			return;
		} else {
			Node current = head;
			while (current.next != null) {
				if (current.next.data == i) {
					current.next = current.next.next;
					System.out.println("data found:" + i);
					return;
				}
			}
		}
		System.out.println("data not found:" + i);
	}

	private void deleteByReverseIndex(int n) {
		System.out.println("data deleted:" + n + "th index ");
		if (head == null)
			return;

		Node fast = head;
		Node slow = head;

		for (int i = 0; i < n; i++) {
			System.out.println(fast.data);
			fast = fast.next;
		}

		// if remove the first node
		if (fast == null) {
			head = head.next;
			return;
		}

		while (fast.next != null) {
			System.out.println(fast.data + " " + slow.data);
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return;
	}

	private void findMiddle1() {
		// TODO Auto-generated method stub
		if (head == null)
			return;
		else {
			Node current = head;
			Node middle = head;
			int count = 0;
			while (current.next != null) {
				if (count % 2 == 0) {
					middle = middle.next;
				}
				current = current.next;
				count++;
			}
			System.out.println("middle element:" + middle.data);
		}
	}

	private void findMiddle2() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println("middle element:" + slow.data);
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

	public void reverse() {
		if (head == null) {
			System.out.println("LL is empty");
			return;
		}
		Node current = head;
		Node next = null, prev = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public static void main(String[] args) {
		SingleLinkedList ll = new SingleLinkedList();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);
		ll.display();
		ll.findMiddle1();
		ll.findMiddle2();

//		ll.deleteByData(1);
		ll.display();

		ll.deleteByReverseIndex(1);
		ll.display();
	}

}
