package com.example.Common;

//import java.util.concurrent.
public class Practise3 {

	public static void main(String[] args) {
//		new Practise3().findFirstDuplicate();
		int[] arr = new int[] { 2, 3, 1, 4, 5, 6 };
		new Practise3().rotate(arr, 2);
		for (int i : arr) {
			System.out.println(i);
		}

	}

	private void rotate(int[] arr, int d) {
		// TODO Auto-generated mintethod stub
		for (int i = 0; i < d; i++)
			rotateArray(arr);

	}

	private void rotateArray(int[] arr) {
		int temp = arr[0];
		int j = 0;
		for (j = 0; j < arr.length - 1; j++) {
			arr[j] = arr[j + 1];
		}
		arr[j] = temp;
	}

	private void findFirstDuplicate() {
		// TODO Auto-generated method stub
		char[] arr = { 'A', 'B', 'C', 'D', 'B', 'D', 'E', 'A' };

		int position = arr.length + 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				System.out.println(arr[i] + " " + arr[j]);
				if (arr[i] == arr[j])
					if (position > j)
						position = j;
			}
		}
		System.out.println("position:" + position);
		System.out.println("arr.length + 1:" + (arr.length + 1));
		if (position != (arr.length + 1))
			System.out.println("duplicate found:" + arr[position]);
		else
			System.out.println("not duplicate found");
	}

}
