package com.example.DS.Tree;

import java.util.HashMap;
import java.util.Map.Entry;

import java.util.Vector;

public class DiagonalTraversalBTree {
	static void diagonalPrintUtil(TNode root, int d, HashMap<Integer, Vector<Integer>> map) {
		if (root == null)
			return;
		Vector<Integer> k = map.get(d);

		if (k == null) {
			k = new Vector<>();
			k.add(root.data);
		}

		else {
			k.add(root.data);
		}
		map.put(d, k);
		diagonalPrintUtil(root.left, d + 1, map);
		diagonalPrintUtil(root.right, d, map);
	}

	static void diagonalPrint(TNode root) {
		HashMap<Integer, Vector<Integer>> map = new HashMap<>();
		diagonalPrintUtil(root, 0, map);

		System.out.println("Diagonal Traversal of Binnary Tree");
		for (Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	// Driver program
	public static void main(String[] args) {

		TNode root = new TNode(8);
		root.left = new TNode(3);
		root.right = new TNode(10);
		root.left.left = new TNode(1);
		root.left.right = new TNode(6);
		root.right.right = new TNode(14);
		root.right.right.left = new TNode(13);
		root.left.right.left = new TNode(4);
		root.left.right.right = new TNode(7);

		diagonalPrint(root);
	}
}
