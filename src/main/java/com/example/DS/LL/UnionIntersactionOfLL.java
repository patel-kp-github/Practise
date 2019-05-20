package com.example.DS.LL;

public class UnionIntersactionOfLL {
	Node head;

	void getUnion(Node head1, Node head2) {
		while (head1 != null) {
			push(head1.data);
			head1 = head1.next;
		}
		while (head2 != null) {
			if (!isPresent(head, head2.data))
				push(head2.data);
			head2 = head2.next;
		}
	}

	void getIntersection(Node head1, Node head2) {
		while (head1 != null) {
			if (isPresent(head2, head1.data))
				push(head1.data);
			head1 = head1.next;
		}
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	void push(int new_data) {
		Node node = new Node(new_data);
		node.next = head;
		head = node;
	}

	boolean isPresent(Node head, int data) {
		while (head != null) {
			if (head.data == data)
				return true;
			head = head.next;
		}
		return false;
	}

	public static void main(String args[]) {
		UnionIntersactionOfLL llist1 = new UnionIntersactionOfLL();
		UnionIntersactionOfLL llist2 = new UnionIntersactionOfLL();
		UnionIntersactionOfLL unin = new UnionIntersactionOfLL();
		UnionIntersactionOfLL intersecn = new UnionIntersactionOfLL();

		/* create a linked lits 10->15->5->20 */
		llist1.push(20);
		llist1.push(4);
		llist1.push(15);
		llist1.push(10);

		/* create a linked lits 8->4->2->10 */
		llist2.push(10);
		llist2.push(2);
		llist2.push(4);
		llist2.push(8);

		intersecn.getIntersection(llist1.head, llist2.head);
		unin.getUnion(llist1.head, llist2.head);

		System.out.println("First List is");
		llist1.printList();

		System.out.println("Second List is");
		llist2.printList();

		System.out.println("Intersection List is");
		intersecn.printList();

		System.out.println("Union List is");
		unin.printList();
	}

}
