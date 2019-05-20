package com.practise.multiThread;

public class Test1 {

	public static void main(String[] args) {

		new Test1().m1((long) 1);
		new Test1().secondLargest();
	}

	private void secondLargest() {
		// TODO Auto-generated method stub
		int[] arr = { 0, 2, 1, 5, 4 ,6};

		int first = 0;
		int second = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			}
		}
		System.out.println(first+" "+second);
	}

	public void m1(int a) {
		System.out.println("int");
	}

	public void m1(Long a) {
		System.out.println("long");
	}

	public void m1(Object a) {
		System.out.println("Object");
	}

	public int main() {
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				System.out.println(i + " " + j);
//				return;
//			}
//		}

		try {
			return 0;
		} catch (Exception e) {
			return 1;
		} finally {
			return 2;
		}
//		return 3;
	}

}
