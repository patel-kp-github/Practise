package com.example.DS.LL;

import java.util.HashSet;

public class DetectLoopSLL {
	public static void main(String[] args) {
		DetectLoopSLL ll = new DetectLoopSLL();
		ll.insert(1);
		ll.insert(2);
		Node node1 = ll.insert(3);
		ll.insert(4);
		Node node2 = ll.insert(5);
		node2.next = node1;
		ll.display();
//		System.out.println("loop exists:" + ll.detectLoop1());
		System.out.println("loop exists:" + ll.detectLoop2());
		ll.display();
	}

	Node head = null;

	public Node insert(int i) {
		if (head == null) {
			head = new Node(i);
			System.out.println("data inserted:" + i);
			return head;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(i);
			System.out.println("data inserted:" + i);
			return current.next;
		}

	}

	boolean detectLoop1() {
		Node current = head;
		HashSet<Node> s = new HashSet<Node>();
		while (current != null) {
			// If we have already has this node
			// in hashmap it means their is a cycle
			// (Because you we encountering the
			// node second time).
			if (s.contains(current))
				return true;

			// If we are seeing the node for
			// the first time, insert it in hash
			s.add(current);

			current = current.next;
		}

		return false;
	}

	boolean detectLoop2() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("loop found:" + slow.data + " " + fast.data);
				countLoopSize(slow);
				removeLoop(slow, head);
				return true;
			}
		}

		return false;
	}

	private void countLoopSize(Node slow) {
		// TODO Auto-generated method stub
		Node current = slow;
		int count = 1;
		while (current.next != slow) {
			count++;
			current = current.next;
		}
		System.out.println("size of loop:" + count);
	}

	void removeLoop(Node slow, Node head) {
		Node current = null;
		while (true) {
			current = slow;
			while (current.next != slow && current.next != head) {
				current = current.next;
			}
			if (current.next == head) {
				break;
			}
			head = head.next;
			System.out.println("head->" + head.data);
		}
		current.next = null;
	}

	public void display() {
		int count = 0;
		if (head == null) {
			System.out.println("LL is empty");
			return;
		} else {
			Node current = head;
			while (current.next != null) {
				if (count == 15)
					break;
				System.out.print(current.data + " ");
				current = current.next;
				count++;
			}
			System.out.println(current.data);
		}
	}
}
