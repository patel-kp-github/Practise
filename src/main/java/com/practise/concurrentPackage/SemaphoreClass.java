package com.practise.concurrentPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//Best use of Semaphore ,is to control no of thread access

public class SemaphoreClass {
	public static void main(String[] args) throws InterruptedException {
		new Runner3().main();
	}
}

class Runner3 {
	public void main() throws InterruptedException {

		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 2000; i++) {
			executor.submit(new Runnable() {
				public void run() {

					Connect.getInstance().connect();
				}
			});

		}
		executor.shutdown();

		executor.awaitTermination(1, TimeUnit.DAYS);
	}
}

class Connect {
	private static Connect con = new Connect();

	public static Connect getInstance() {
		return con;
	}

	int connect;
	private Semaphore semaphore = new Semaphore(10);

	public void connect() {
		try {
			semaphore.acquire();
			doconnect();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	public void doconnect() {

		synchronized (this) {
			connect++;
			System.out.println("no of connections:" + connect);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (this) {
			connect--;
		}
	}

}
