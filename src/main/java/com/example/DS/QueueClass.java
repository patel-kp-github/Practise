package com.example.DS;


public class QueueClass {

	int front = -1, rear = -1, len;
	private int arr[];

	public QueueClass(int n) {
		arr = new int[n];
		len = n;
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
//		System.out.println(rear+" "+len);
		return rear == (len - 1);
	}

	public void enqueue(int i) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		System.out.println(i + " is added");
		if (front == -1 && rear == -1) {
			arr[++rear] = i;
			front++;
		} else {
			arr[++rear] = i;
		}
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Quweue is empty");
			return -1;
		}
		int i = -1;
		if (front == rear) {
			i = arr[front++];
			front = -1;
			rear = -1;

		} else {
			i = arr[front++];
		}
		System.out.println(i + " is removed");
		return i;
	}

	public static void main(String[] args) {
		QueueClassLL QueueClassLL = new QueueClassLL();

		QueueClassLL.enqueue(1);
		QueueClassLL.enqueue(2);
		QueueClassLL.enqueue(3);
		QueueClassLL.enqueue(4);
		QueueClassLL.enqueue(5);
		QueueClassLL.enqueue(6);

		QueueClassLL.display();

		QueueClassLL.dequeue();
		QueueClassLL.dequeue();
		QueueClassLL.dequeue();

		QueueClassLL.display();

		QueueClassLL.dequeue();
		QueueClassLL.dequeue();
		QueueClassLL.dequeue();
	}

}

class QueueClassLL {

	Node head;

	public void enqueue(int i) {
		// TODO Auto-generated method stub
		if (head == null)
			head = new Node(i);
		else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(i);
		}
		System.out.println("enqueued:" + i);
	}

	public void dequeue() {
		// TODO Auto-generated method stub
		if (head == null) {
			System.out.println("not found");
		} else {
			Node current = head;
			Node pre = head;
			while (current.next != null) {
				pre = current;
				current = current.next;
			}
			System.out.println("dequeued:" + current.data);
			pre.next = null;
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
