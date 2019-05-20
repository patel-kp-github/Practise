package com.example.DS.Tree;

import java.util.Stack;

public class TraverseWithoutRecursion {
	BNode root;


	//inOrder traversal
	void inorderWithoutRecusion() {
		if (root == null)
			return;

		Stack<BNode> s = new Stack<BNode>();
		BNode current = root;

		// traverse the tree
		while (current != null || s.size() > 0) {
			while (current != null) {
				s.push(current);
				current = current.left;
			}
			current = s.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}
	}

	public BNode insert(BNode current, int value) {
		if (current == null) {
			return new BNode(value);
		}

		if (value < current.data) {
			current.left = insert(current.left, value);
		} else if (value > current.data) {
			current.right = insert(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public static void main(String[] args) {

		TraverseWithoutRecursion bst = new TraverseWithoutRecursion();
		bst.add(10);
		bst.add(5);
		bst.add(15);
		bst.add(1);
		bst.add(6);
		bst.add(12);
		bst.add(16);
		System.out.println("inorderWithoutRecusion:");
		bst.inorderWithoutRecusion();
		// 10
		// 5 15
		// 1 6 12 16

	}

	public void add(int value) {
		root = insert(root, value);
	}

}
