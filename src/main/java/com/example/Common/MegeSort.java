package com.example.Common;

public class MegeSort {
	public static void main(String[] args) {
		int[] arr = { 11, 10, 9, 5, 3, 4, 2, 1, 7, };
		new MegeSort().mergeSort(arr, arr.length);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void mergeSort(int[] arr, int size) {
		if (size < 2) {
			return;
		}
		int mid = size / 2;
		int[] arr1 = new int[mid];
		int[] arr2 = new int[size - mid];

		for (int i = 0; i < mid; i++) {
			arr1[i] = arr[i];
		}
		for (int j = mid; j < size; j++) {
			arr2[j - mid] = arr[j];
		}
		mergeSort(arr1, mid);
		mergeSort(arr2, size - mid);

		merge(arr, arr1, arr2, mid, size - mid);
	}

	public static void merge(int[] arr, int[] arr1, int[] arr2, int left, int right) {
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (arr1[i] <= arr2[j]) {
				arr[k++] = arr1[i++];
			} else {
				arr[k++] = arr2[j++];
			}
		}
		while (i < left) {
			arr[k++] = arr1[i++];
		}
		while (j < right) {
			arr[k++] = arr2[j++];
		}
	}

}
