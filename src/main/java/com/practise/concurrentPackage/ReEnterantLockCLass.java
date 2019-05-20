package com.practise.concurrentPackage;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Reentrant lock is the Lock interface implementaion
 * it gives the same syncronization mechanism
 * but better then Synchronization
 * 1)it has separate lock unlock method
 * 2)A synchronized block doesn’t support the fairness
 * 3)A thread gets blocked if it can’t get an access to the synchronized block.
 *  The Lock API provides tryLock() method
 *  
 *  other Lock implementations
 *  1)ReentrantReadWriteLock
 *  2)StampedLock
 *  
 *  Condition condition = lock.newCondition();
 *  condition.await
 *  condition.singalAll
 * =>  just like synchronization wait , notify signals
 */

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
