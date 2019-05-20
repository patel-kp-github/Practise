package com.practise.multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockClass {

	public static void main(String[] args) {
		new LockClass().main();
	}

	private void main() {
		// TODO Auto-generated method stub
		Sample sample = new Sample();
		Sample sample2 = new Sample();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				sample.m1();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				sample.m2();
//				sample2.m2();
			}
		});

		t1.start();
		t2.start();
	}
}

class Sample {
	Lock lock = new ReentrantLock();

	public void m1() {
//		synchronized (this) {
//		synchronized (Sample.class) {
		lock.lock();
		System.out.println("inside m1:");
		try {
			Thread.sleep(1000);
//				obj.wait(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("leaving m1:");
//		}
		lock.unlock();
	}

	public void m2() {
//		synchronized (this) {
//		synchronized (Sample.class) {
		lock.lock();
		System.out.println("inside m2:");
		try {
			Thread.sleep(1000);
//				obj.wait(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("leaving m2:");
//	}
		lock.unlock();
	}

	public static void m3() {
		System.out.println("inside m3:");
		try {
			Thread.sleep(1000);
//				obj.wait(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("leaving m3:");
	}
}
