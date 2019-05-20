package com.example.Common;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 11, 10, 9, 5, 3, 4, 2, 1, 7, };
		new QuickSort().quickSort(arr, 0, arr.length-1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private void quickSort(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		if (left >= right)
			return;
		int pivot = arr[(left + right) / 2];
		int index = partition(arr, left, right, pivot);

		quickSort(arr, left, index - 1);
		quickSort(arr, index, right);
	}

	private int partition(int[] arr, int left, int right, int pivot) {
		// TODO Auto-generated method stub
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if(left<=right) {
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		return left;
	}

}
