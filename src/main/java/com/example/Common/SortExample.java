package com.example.Common;

public class SortExample {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 4, 6, 2, 8, 1 };
		// select 1st value and iterate to list and swap if min found
		new SortExample().selectionSort(arr);

		// take 2 adjcent values and iterate to list and swap if min found
		new SortExample().bubbleSort(arr);

		// take 2 adjcent values and iterate to list and swap if min found
		new SortExample().InsertionSort(arr);
	}

	private void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("Insertion Sort:");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println();
		System.out.println("Bubble Sort:");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
//j i
//3,2,,4,4,4,
	private void InsertionSort(int[] arr) {
		for (int i = 1; i < arr.length - 1; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		System.out.println();
		System.out.println("Insertion Sort:");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
