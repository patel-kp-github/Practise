package com.practise.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolClass {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executor.submit(new App4(i));
		}
		executor.shutdown();
		System.out.println("all tasks submited");
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("all tasks completed");
	}

}

class App4 implements Runnable {
	int id;

	public App4(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("starting: " + id);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("completed: " + id);
	}

}
