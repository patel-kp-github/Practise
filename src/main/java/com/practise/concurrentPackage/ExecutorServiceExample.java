package com.practise.concurrentPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * ExecutorService is a complete solution for asynchronous processing. 
 * It manages an in-memory queue and schedules submitted tasks based on thread availability.
 */
public class ExecutorServiceExample {

	public static void main(String[] args) {
//		ExecutorService executor=Executors.newCachedThreadPool();
		ExecutorService executor = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 10; i++) {

			executor.submit(new App4());
		}
		executor.shutdown();

		executor.shutdownNow();

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class App4 extends Thread {
	private volatile int i = 10;

	public void run() {
		increment();
		System.out.println(Thread.currentThread().getName() + " " + i);
	}

	private synchronized void increment() {
		// TODO Auto-generated method stub
		i = i + 1;
	}

}