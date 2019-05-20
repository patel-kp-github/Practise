package com.example.DS.Tree;

import org.springframework.beans.factory.annotation.Value;

class TNode {
	TNode left, right;
	int data;

	TNode(int data) {
		this.data = data;
	}

	public void insert(int value) {
		if (value <= data) {
			if (left == null)
				left = new TNode(value);
			else
				left.insert(value);
		} else {
			if (right == null)
				right = new TNode(value);
			else
				right.insert(value);
		}
	}

	public boolean contains(int value) {
		if (value == data)
			return true;
		else if (value <= data) {
			if (left == null)
				return false;
			else
				left.contains(value);
		} else {
			if (right == null)
				return false;
			else
				right.contains(value);
		}
//		return false;
		return true;
	}

	// increasing order
	public void inOrederTraversal() {
		if (left != null)
			left.inOrederTraversal();
		System.out.print(data + " ");
		if (right != null)
			right.inOrederTraversal();

	}

	// descreasing order
	public void descOrederTraversal() {
		if (right != null)
			right.descOrederTraversal();
		System.out.print(data + " ");
		if (left != null)
			left.descOrederTraversal();

	}

	public void preOrederTraversal() {

		System.out.print(data + " ");
		if (left != null)
			left.preOrederTraversal();

		if (right != null)
			right.preOrederTraversal();
	}

	public void postOrederTraversal() {

		if (left != null)
			left.postOrederTraversal();
		if (right != null)
			right.postOrederTraversal();
		System.out.print(data + " ");
	}
}

public class BinaryTree {
	public static void main(String[] args) {
		TNode node = new TNode(10);
		node.insert(15);
		node.insert(5);

		System.out.println("contains 6:" + node.contains(6));
		System.out.println("in order:");
		node.inOrederTraversal();
		System.out.println();
		System.out.println("pre order:");
		node.preOrederTraversal();
		System.out.println();
		System.out.println("post order:");
		node.postOrederTraversal();
	}
}
