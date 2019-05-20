package com.practise.concurrentPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier barrier=new CyclicBarrier(3, () -> {
	        // ...
	        System.out.println("All previous tasks are completed");
	    });
		
		Thread t1 = new Thread(new Process1(barrier), "T1"); 
	    Thread t2 = new Thread(new Process1(barrier), "T2"); 
	    Thread t3 = new Thread(new Process1(barrier), "T3");
	    Thread t4 = new Thread(new Process1(barrier), "T4");
	 
	    if (!barrier.isBroken()) { 
	        t1.start(); 
	        t2.start(); 
	        t3.start(); 
	        t4.start(); 
	    }
	    /*
		ExecutorService executor = Executors.newFixedThreadPool(3);
//		List<String> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			executor.submit(new Process1(barrier));
		}

		// This will wait all thread execution then further code executes
//		list.add("completed");
		System.out.println("completed");
		executor.shutdown();
//		list.stream().forEach(System.out::println);
 * 
 */
	}


}

class Process1 implements Runnable {

	CyclicBarrier barrier;

	Process1(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("started:" + Thread.currentThread().getName());
		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("completed:" + Thread.currentThread().getName());
	}

}
