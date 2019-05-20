package com.example.Common;

public class DiagonalMatrix {

	static int MAX = 100;

	// Function to print the resultant matrix
	static void print(int mat[][], int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Function to change the values of all
	// non-diagonal elements to 0
	static void makenondiagonalzero(int mat[][], int n, int m) {
		// Traverse all non-diagonal elements
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i != j && (i + j + 1) != n) {

					// Change all non-diagonal
					// elements to zero
					System.out.println(i + " " + j);
					mat[i][j] = 0;
				}
			}
		}

		// print resultant matrix
		print(mat, n, m);
	}

	// Driver Code
	public static void main(String[] args) {
		int mat[][] = { { 2, 1, 7 }, { 3, 7, 2 }, { 5, 4, 9 } };

		makenondiagonalzero(mat, 3, 3);
	}
}
