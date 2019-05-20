package com.example.Java8;

public class RunableExample {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("running Thread...");
			}
		});

		t1.start();

		// this is the way of doing things in Lamda
		// it is possible bcoz runnable have only 1 method
		Thread t2 = new Thread(() -> System.out.println("running Lambda Thread..."));

		t2.start();
	}

}
