package com.practise.multiThread;

import java.util.LinkedList;

class App5 {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private Object lock = new Object();
	private int LIMIT = 10;

	public void produce() throws InterruptedException {
		int count = 0;
		while (true) {
			synchronized (lock) {

				while (list.size() == 10) {
					lock.wait();
				}
				list.add(count++);
				lock.notify();
			}
		}

	}

	public void consume() throws InterruptedException {

		while (true) {
			synchronized (lock) {
				while (list.size() == 0) {
					lock.wait();
				}
				System.out.print("list size:" + list.size());
				int val = list.removeFirst();
				lock.notify();
				System.out.println("; value:" + val);
			}
		}
	}

	public void main() {

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

	}

}

public class Producer_ConsumerClass {

	public static void main(String[] args) {
		new App5().main();
	}
}