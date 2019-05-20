package com.example.DS.Tree;

import ch.qos.logback.classic.Level;

public class BFS {
	public static void main(String[] args) {

		Node1 node = new Node1();
		node.insert(10);
		node.insert(5);
		node.insert(15);
		node.insert(1);
		node.insert(6);
		node.insert(12);
		node.insert(16);
		// node.inOrderTraversal();
		// 10
		// 5 15
		// 1 6 12 16

		node.BFS();
//		System.out.println();
//		System.out.println("inOrederTraversal:");
//		node.inOrederTraversal();
//		
//		System.out.println();
//		System.out.println("preOrederTraversal:");
//		node.preOrederTraversal();
//		
//		System.out.println();
//		System.out.println("postOrederTraversal:");
//		node.postOrederTraversal();
//		
//		System.out.println();
//		System.out.println("descOrederTraversal:");
//		node.descOrederTraversal();
	}
}

class Node1 {

	Node1 left, right;
	int data;

	Node1(int data) {
		this.data = data;
	}

	Node1() {
	}

	Node1 root;

	public void insert(int value) {
		if (value <= data) {
			if (left == null)
				left = new Node1(value);
			else
				left.insert(value);
		} else {
			if (right == null)
				right = new Node1(value);
			else
				right.insert(value);
		}
	}

	public void BFS() {
		int hight = findHight(root);
		System.out.println("hight:" + hight);
//		for (int i = 0; i <= hight; i++) {
		for (int i = hight; i >= 1; i--) {
			printBFS(root, i);
		}

	}

	private void printBFS(Node1 root2, int level) {
		// TODO Auto-generated method stub
		if (root2 == null)
			return;
		if (level == 1)
			System.out.println(root2.data + " ");
		else if (level > 1) {
			printBFS(root2.left, level - 1);
			printBFS(root2.right, level - 1);
		}

	}

	private int findHight(Node1 root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		else {
			System.out.println("check data:" + root.data);
			int lhight = findHight(root.left);
			int rhight = findHight(root.right);
			System.out.println("lhight:" + lhight + " rhight" + rhight);
			if (lhight > rhight)
				return lhight + 1;
			else
				return rhight + 1;
		}
	}

}
