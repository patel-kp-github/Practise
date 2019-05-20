package com.example.DS;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	/*
	 * Our internal definition of a doubly linked list node, put in this class for
	 * convenience since this is submitted in one file on Leetcode
	 */
	private class DNode {
		int key;
		int value;
		DNode prev;
		DNode next;
	}

	private Map<Integer, DNode> hashtable = new HashMap<Integer, DNode>();
	private DNode head, tail;
	private int totalItemsInCache;
	private int maxCapacity;

	public LRUCache(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		// Initialize the dummy head of the cache
		head = new DNode();
		// Init the dummy tail of the cache
		tail = new DNode();
		// Wire the head and tail together
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {

		DNode node = hashtable.get(key);
		boolean itemFoundInCache = node != null;

		// Empty state check. Should raise exception here.
		if (!itemFoundInCache) {
			return -1;
		}

		// Item has been accessed. Move to the front of the list.
		moveToHead(node);
		return node.value;
	}

	public int getLRU() {
		DNode node = head.next;
		return node.value;
	}

	public void put(int key, int value) {
		DNode node = hashtable.get(key);
		boolean itemFoundInCache = node != null;
		if (!itemFoundInCache) {
			// Create a new node
			DNode newNode = new DNode();
			newNode.key = key;
			newNode.value = value;
			// Add to the hashtable and the doubly linked list
			hashtable.put(key, newNode);
			addNode(newNode);
			// We just added an item to the cache
			totalItemsInCache++;
			// If over capacity evict an item with LRU cache eviction policy
			if (totalItemsInCache > maxCapacity) {
				removeLRUEntryFromStructure();
			}
		} else {
			// If item is in cache just update and move it to the head
			node.value = value;
			moveToHead(node);
		}

	}

	/*
	 * Remove the least used entry from the doubly linked list as well as the
	 * hashtable. Hence it is evicted from the whole LRUCache structure
	 */
	private void removeLRUEntryFromStructure() {
		DNode tail = popTail();
		hashtable.remove(tail.key);
		--totalItemsInCache;
	}

	/*
	 * Insertions to the doubly linked list will always be right after the dummy
	 * head
	 */
	private void addNode(DNode node) {

		// Wire the node being inserted
		node.prev = head;
		node.next = head.next;

		// Re-wire the head's old next
		head.next.prev = node;

		// Re-wire the head to point to the inserted node
		head.next = node;
	}

	/*
	 * Remove the given node from the doubly linked list
	 */
	private void removeNode(DNode node) {

		// Grab reference to the prev and next of the node
		DNode savedPrev = node.prev;
		DNode savedNext = node.next;

		// Cut out going forwards
		savedPrev.next = savedNext;

		// Cut out going backards
		savedNext.prev = savedPrev;

	}

	/*
	 * Move a node to the head of the doubly linked lsit
	 */
	private void moveToHead(DNode node) {
		removeNode(node);
		addNode(node);
	}

	/*
	 * Pop the last item from the structure
	 */
	private DNode popTail() {
		DNode temp = tail;
		tail = tail.prev;
		tail.next = null;
		return temp;
	}

	public static void main(String[] args) {

		LRUCache obj = new LRUCache(5);
//		int param_1 = obj.get(key);
		obj.put(1, 101);
		obj.put(2, 102);
		obj.put(3, 103);
		obj.put(4, 104);
		obj.put(5, 105);
		obj.put(6, 106);
//		int param_1 = obj.get(2);
		int param_1 = obj.getLRU();

		System.out.println("param_1:" + param_1);
	}

}

/**
 * The LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(maxCapacity); int param_1 = obj.get(key); obj.put(key,value);
 */
