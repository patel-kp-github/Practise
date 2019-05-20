package com.practise.multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner {

	private Lock lock = new ReentrantLock();
	private Condition con = lock.newCondition();
	int count = 0;

	public void increment() {
		for (int i = 0; i < 1000; i++) {
			count++;
		}
	}

	public void firstThread() {
		lock.lock();
		try {
			con.await();
			increment();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() {
		lock.lock();
		con.signal();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void main() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				firstThread();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				secondThread();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {

		}
		System.out.println("count is:" + count);
	}
}

public class ReEnterantLockCLass {

	public static void main(String[] args) {
		new Runner().main();
	}
}
