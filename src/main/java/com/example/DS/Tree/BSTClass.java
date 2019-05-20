package com.example.DS.Tree;

class BNode {

	BNode left, right;
	int data;

	BNode(int data) {
		this.data = data;
	}

	BNode() {
	}
}

public class BSTClass {
	BNode root;

	public static void main(String[] args) {

		BSTClass bst = new BSTClass();
		bst.add(10);
		bst.add(5);
		bst.add(15);
		bst.add(1);
		bst.add(6);
		bst.add(12);
		bst.add(16);
		System.out.println("inOrderTraversal or ascending order");
		bst.inOrderTraversal();
		System.out.println("descending order");
		bst.descOrderTraversal();
		//    10
		//  5    15
		// 1 6  12 16

		bst.BFS();
	}

	public void add(int value) {
		root = insert(root, value);
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	public void descOrderTraversal() {
		descOrderTraversal(root);
	}

	// ascending order
	public void inOrderTraversal(BNode root) {
		if (root.left != null)
			inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		if (root.right != null)
			inOrderTraversal(root.right);

	}

	// descending order
	public void descOrderTraversal(BNode root) {
		if (root.right != null)
			inOrderTraversal(root.right);
		System.out.print(root.data + " ");
		if (root.left != null)
			inOrderTraversal(root.left);

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

	public void BFS() {
		int hight = findHight(root);
		System.out.println("hight:" + hight);
		boolean flag = false;// 10 15 5 1 6 12 16 spiral traversal
		for (int i = 0; i <= hight; i++) {// top to bottom : 10 5 15 1 6 12 16
			// for (int i = hight; i >= 1; i--) {//bottom to top : 1 6 12 16 5 15 10
			printBFS(root, i, flag);
			flag = !flag;
		}

	}

	private void printBFS(BNode root, int level, boolean flag) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			if (flag != false) {
				printBFS(root.left, level - 1, flag);
				printBFS(root.right, level - 1, flag);
			} else {
				printBFS(root.right, level - 1, flag);
				printBFS(root.left, level - 1, flag);
			}
		}

	}

	private int findHight(BNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		else {
			int lhight = findHight(root.left);
			int rhight = findHight(root.right);
			if (lhight > rhight)
				return lhight + 1;
			else
				return rhight + 1;
		}
	}

}
