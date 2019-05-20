package com.practise.multiThread;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

class App2 {

	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();

	Random random = new Random();

	Object obj1 = new Object();
	Object obj2 = new Object();

	public void packageA() {
		synchronized (obj1) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(1);
		}
	}

	public void packageB() {
		synchronized (obj2) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(2);
		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			packageA();
			packageB();
		}
	}

	public void main() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(list1.size() + " " + list2.size());
	}
}

class Synchronized2 {

	public static void main(String[] args) {
		new App2().main();
	}
}
