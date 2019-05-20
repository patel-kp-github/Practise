package com.example.DS.LL;

public class RemoveDuplicatesFromSortedLL {
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

	void removeDuplicates() {
		Node current = head;
		if (head == null)
			return;
		while (current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else
				current = current.next;
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

		RemoveDuplicatesFromSortedLL ll = new RemoveDuplicatesFromSortedLL();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(4);
		ll.insert(5);
		ll.display();
		ll.removeDuplicates();
		ll.display();
	}

}
