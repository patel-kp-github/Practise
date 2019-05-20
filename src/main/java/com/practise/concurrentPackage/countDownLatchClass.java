package com.practise.concurrentPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* ContDownLatch block the thread untill other threads finished the job.
 * countDown will decrement everytime, once it is 0 then await is notified and it releases
 * other thread lock .it is similar to join method but join we can not use in excecutor service
 */
public class countDownLatchClass {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countdownlatch = new CountDownLatch(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			executor.submit(new Process(countdownlatch, list));
		}

		// This will wait all thread execution then further code executes
		countdownlatch.await();
		list.add("completed");
//		System.out.println("completed");
		executor.shutdown();
		list.stream().forEach(System.out::println);
	}
}

class Process implements Runnable {
	CountDownLatch countdownlatch;
	List<String> list;

	Process(CountDownLatch latch, List<String> list) {
		countdownlatch = latch;
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		list.add("started");
//		System.out.println("started " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("finished " + Thread.currentThread().getName());
		countdownlatch.countDown();
	}

}
