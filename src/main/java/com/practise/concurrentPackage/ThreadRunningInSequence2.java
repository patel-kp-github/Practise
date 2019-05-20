package com.practise.concurrentPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadRunningInSequence2 {
	static boolean odd = true;
	static Object lock = new Object();
	static   int count = 0;

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
						synchronized (lock) {
							while (count < 10) {
							if (odd)
								lock.wait();
							if (count % 2 == 0) {
								System.out.println(count + " " + Thread.currentThread().getName());
								count++;
							}
							odd = false;
							lock.notifyAll();
						}
					}
				} catch (Exception e) {

				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
						synchronized (lock) {
							while (count < 10) {
							if (!odd)
								lock.wait();
							if (count % 2 != 0) {
								System.out.println(count + " " + Thread.currentThread().getName());
								count++;
							}
							odd = true;
							lock.notifyAll();

						}
					}
				} catch (Exception e) {

				}
			}
		});
		t1.setName("even");
		t2.setName("odd");
		t1.start();
		t2.start();
	}

}
