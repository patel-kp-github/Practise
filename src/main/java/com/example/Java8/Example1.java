package com.example.Java8;

import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class Example1 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int[] evenArr = new int[arr.length / 2 + 1];
		int[] oddArr = new int[arr.length / 2 + 1];// { 1, 2, 3, 4, 5,6 };
		int key = 1;
		calculate(arr, key, WrapLambda((i, k) -> System.out.println(i / k)));

		calculateEven(arr, i -> (i % 2 == 0), evenArr);
		calculateEven(arr, i -> (i % 2 != 0), oddArr);
		System.out.println("evens:");
		for (int j : evenArr) {
			System.out.print(j + " ");
		}
		System.out.println();
		System.out.println("odds:");
		for (int j : oddArr) {
			System.out.print(j + " ");
		}

	}

	private static void calculateEven(int[] arr, Predicate<Integer> predicate, int[] arr1) {
		int index = 0;
		for (int i : arr) {
			if (predicate.test(i))
				arr1[index++] = i;
		}
	}

	private static void calculate(int[] arr, int key, BiConsumer<Integer, Integer> bicon) {
		// TODO Auto-generated method stub
		for (int i : arr) {
			bicon.accept(i, key);
		}
	}

	private static BiConsumer<Integer, Integer> WrapLambda(BiConsumer<Integer, Integer> bicon) {
		return (i, k) -> {
			try {
				bicon.accept(i, k);
			} catch (ArithmeticException e) {
				System.out.println("Arithmetic Exception :");
			}
		};
	}

}
