package com.example.DS;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDemo {
	class DNode {
		int key;
		int value;
		DNode next;
		DNode prev;
	}

	Map<Integer, DNode> hashtable = new HashMap<>();
	int maxCapacity;
	int totalNoOfElements;
	DNode head;
	DNode tail;

	LRUCacheDemo(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		head = new DNode();
		tail = new DNode();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {

		DNode node = hashtable.get(key);
		if (node == null)
			return -1;
		else {
			// move to first
			moveToFirst(node);
			return node.value;
		}
	}

	public void put(int key, int value) {
		DNode node = hashtable.get(key);
		if (node == null) {
			node = new DNode();
			node.key = key;
			node.value = value;

			// add element to first
			addNode(node);

			hashtable.put(key, node);
			totalNoOfElements++;
			if (totalNoOfElements > maxCapacity)
				removeElement();

		} else {
			// move to first
			moveToFirst(node);

		}
	}

	private void addNode(DNode node) {
		// TODO Auto-generated method stub
		node.next = head;
		head.prev = node;
		head = node;
	}

	private void moveToFirst(DNode node) {
		DNode prevSaved = node.prev;
		DNode nextSaved = node.next;
		prevSaved.next = nextSaved;
		nextSaved.prev = prevSaved;

		node.next = head;
		head.prev = node;
		head = node;
	}

	private void removeElement() {
		// TODO Auto-generated method stub
		//check this code
		DNode node = tail.prev.prev;
		hashtable.remove(node.key);
		node.next = null;
	}

	public void display() {
		System.out.println("display elements:");
		DNode current = head;
		if (current == null)
			return;
		else {
			while (current.next != null) {
				System.out.print(current.value + " ");
				current = current.next;
			}
		}
	}

	public static void main(String[] args) {

		LRUCacheDemo obj = new LRUCacheDemo(5);
//		int param_1 = obj.get(key);
		obj.put(1, 101);
		obj.put(2, 102);
		obj.put(3, 103);
		obj.put(4, 104);
		obj.put(5, 105);
		obj.put(6, 106);
		obj.display();
		int param_1 = obj.get(2);

		System.out.println("param_1:" + param_1);

		obj.display();

	}

}
