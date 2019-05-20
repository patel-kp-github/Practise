package com.example.DS.LL;

public class RemoveDuplicatesFromUNSortedLL {
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
		while (current != null && current.next != null) {
			Node node = current;
			while (node != null && node.next != null) {
				if (current.data == node.next.data) {
					node.next = node.next.next;
				} else
					node = node.next;
			}
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

		RemoveDuplicatesFromUNSortedLL ll = new RemoveDuplicatesFromUNSortedLL();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);

		ll.insert(5);
		ll.insert(4);
		ll.insert(4);
		ll.display();
		ll.removeDuplicates();
		ll.display();
	}

}
