package com.practise.concurrentPackage;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockClass {
	public static void main(String[] args) {
		new Runner2().main();
	}
}

class Runner2 {

	Account acc1 = new Account(10000);
	Account acc2 = new Account(10000);
	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();

	private void acquireLock(Lock lock12, Lock lock22) {
		// TODO Auto-generated method stub
		while (true) {
			boolean getLock1 = lock12.tryLock();
			boolean getLock2 = lock22.tryLock();

			if (getLock1 && getLock2)
				return;
			if (getLock1)
				lock12.unlock();
			if (getLock2)
				lock22.unlock();
			try {
				Thread.sleep(1);
			} catch (Exception e) {

			}
		}

	}

	public void firstThread() {
		for (int i = 0; i < 1000; i++) {
			acquireLock(lock1, lock2);
//			lock1.lock();
//			lock2.lock();
			Account.transfer(acc1, acc2, new Random().nextInt(100));
			lock1.unlock();
			lock2.unlock();
		}
	}

	public void secondThread() {
		for (int i = 0; i < 1000; i++) {
			acquireLock(lock2, lock1);
//			lock2.lock();
//			lock1.lock();
			Account.transfer(acc2, acc1, new Random().nextInt(100));
			lock2.unlock();
			lock1.unlock();
		}
	}

	public void finalBalance() {
		System.out.println("acc1 :" + acc1.getBalance());
		System.out.println("acc2 :" + acc2.getBalance());
		System.out.println("Total :" + (acc1.getBalance() + acc2.getBalance()));
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
		finalBalance();
	}

}

class Account {
	int balance;

	Account(int bal) {
		balance = bal;
	}

	public void withdraw(int amt) {
		balance -= amt;
	}

	public void deposit(int amt) {
		balance += amt;
	}

	public int getBalance() {
		return balance;
	}

	public static void transfer(Account acc1, Account acc2, int balance) {
		acc1.withdraw(balance);
		acc2.deposit(balance);
	}
}
