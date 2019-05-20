package com.practise.concurrentPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserClass {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Phaser ph = new Phaser(1);

//		ph.getPhase();

		executorService.submit(new LongRunningAction("thread-1", ph));
		executorService.submit(new LongRunningAction("thread-2", ph));
		executorService.submit(new LongRunningAction("thread-3", ph));

		ph.arriveAndAwaitAdvance();

		ph.getPhase();

		executorService.submit(new LongRunningAction("thread-4", ph));
		executorService.submit(new LongRunningAction("thread-5", ph));
		ph.arriveAndAwaitAdvance();

		ph.getPhase();

		ph.arriveAndDeregister();
	}
}

class LongRunningAction implements Runnable {
	private String threadName;
	private Phaser ph;

	LongRunningAction(String threadName, Phaser ph) {
		this.threadName = threadName;
		this.ph = ph;
		ph.register();
	}

	@Override
	public void run() {
		ph.arriveAndAwaitAdvance();
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ph.arriveAndDeregister();
	}
}
