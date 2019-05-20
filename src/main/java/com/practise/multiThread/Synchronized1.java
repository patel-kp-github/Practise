package com.practise.multiThread;
/*
 * join is used to completed 1st thread completion then comes to 2nd thread
 * and synchronized is used to force thread access variable 1 by 1 
 */
public class Synchronized1 {

	public static void main(String[] args) {
		Synchronized1 sc = new Synchronized1();
		sc.doWork();
	}

	private int count = 0;

	private synchronized void increaseCount() {
		count++;
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 100; i++) {
					increaseCount();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 100; i++) {
					increaseCount();
				}
			}

		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("count:" + count);

	}
}
