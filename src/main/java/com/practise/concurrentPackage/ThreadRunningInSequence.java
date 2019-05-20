package com.practise.concurrentPackage;

public class ThreadRunningInSequence {

	static String value = "A";

	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
					synchronized (lock) {
						 
							while (!value.equals("A"))
								lock.wait();

							System.out.println(value);
//							Thread.sleep(1000);
							value = "B";
							lock.notifyAll();
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

			}

		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
						for (int i = 0; i < 10; i++) {
							synchronized (lock) {
							while (!value.equals("B"))
								lock.wait();

							System.out.println(value);
//							Thread.sleep(1000);
							value = "A";
							lock.notifyAll();
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		t1.start();
		t2.start();
//		t1.join();
//		t2.join();

	}

}