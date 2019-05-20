package com.example.DS.LL;

class DNode {
	DNode next;
	DNode prev;
	int data;

	public DNode(int i) {
		data = i;
	}

	public String toString() {
		return data + " ";
	}
}

public class DoublyLL {
	DNode head = null;
	DNode tail = null;

	public boolean isEmpty() {
		return tail == null;
	}

	public void insertFirst(int i) {
		DNode node = new DNode(i);
		if (isEmpty()) {
			tail = node;
		} else {
			head.prev = node;
		}
		node.next = head;
		head = node;
		System.out.println("data inserted:" + i);
	}

	public void delete(int i) {
		System.out.println("deleting:" + i + " ");
		if (head == null) {
			System.out.println("LL is empty");
			return;
		} else if (head.data == i) {// delete first
			head.next.prev = null;
			head = head.next;

			return;
		} else if (tail.data == i) {// delete last
			tail.prev.next = null;
			tail = tail.prev;// = tail.prev.prev;// head.next;

			return;
		} else {// delete middle
			DNode current = head;
//			DNode prev = null;
			while (current != null) {
				System.out.print(current.data + " ");
				if (current.data == i) {
					current.next.prev = current.prev;
					current.prev.next = current.next;
					System.out.println("data found:" + i);
					return;
				}
				current = current.next;
			}
		}
		System.out.println("data not found:" + i);
	}

	public void displayForward() {
		if (head == null) {
			System.out.println("LL is empty");
			return;
		} else {
			DNode current = head;
			while (current.next != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println(current.data);
		}
	}

	public void displayBackword() {
		if (tail == null) {
			System.out.println("LL is empty");
			return;
		} else {
			DNode current = tail;
			while (current.prev != null) {
				System.out.print(current.data + " ");
				current = current.prev;
			}
			System.out.println(current.data);
		}
	}

	public static void main(String[] args) {
		DoublyLL ll = new DoublyLL();
		ll.insertFirst(1);
		ll.insertFirst(2);
		ll.insertFirst(3);
		ll.insertFirst(4);
		ll.insertFirst(5);
//		ll.displayForward();
		ll.displayBackword();
		ll.displayForward();
		ll.delete(3);
		ll.displayForward();
		ll.displayBackword();
//		ll.findMiddle();
//
//		ll.delete(1);
//		ll.display();
//		ll.delete(3);
//		ll.display();
//		ll.delete(4);
//		ll.display();
//		ll.delete(2);
//		ll.display();
//		ll.delete(5);
//		ll.display();
	}
}
