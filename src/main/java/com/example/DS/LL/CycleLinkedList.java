package com.example.DS.LL;

public class CycleLinkedList {

	Node head = null;

	public void insert(int i) {

		if (head == null)
			head = new Node(i);
		else {
			Node current = head;
			int count = 0;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(i);
			if (i == 10) {
				System.out.println("creating cycle LL:");
				Node fetchedNode = getNode(5);
				System.out.println("fetchedNode:" + fetchedNode);
				current.next = fetchedNode;
			}
		}
		System.out.println("data inserted:" + i);
	}

	private Node getNode(int i) {
		Node current = head;
		while (current != null) {
			if (current.data == i)
				return current;
			else
				current = current.next;
		}
		return null;
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

	public boolean findCycle() {
		if (head == null)
			return false;

		Node slow = head;
		Node fast = head.next;

		while (slow != null && fast != null && slow.next != null && fast.next != null) {

			if (slow == fast) {
				System.out.println("slow:" + slow.data);
				System.out.println("fats:" + fast.data);
				return true;

			} else {
				slow = slow.next;
				fast = fast.next.next;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		CycleLinkedList ll = new CycleLinkedList();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);
		ll.insert(6);
		ll.insert(7);
		ll.insert(8);
		ll.insert(9);
		ll.insert(10);
//		ll.display();
		System.out.println("find cycle:" + ll.findCycle());

	}

}
