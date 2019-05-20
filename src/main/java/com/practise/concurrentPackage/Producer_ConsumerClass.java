package com.practise.concurrentPackage;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//BlockingQueue is to implement producer consumer program without synchronization code

class App5 {

	// this is bounded Blocking queue
	// unbounded will not have limit size
	BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

	public void produce() throws InterruptedException {
		int count = 0;
		while (true) {
			// add- add element else throw exception if queue is full
			// offer-add element else return false if queue is full
			// put-add element else wait if queue is full
			queue.put(count);
		}

	}

	public void consume() throws InterruptedException {

		while (true) {
			System.out.print("list size:" + queue.size());
			// take the 1 st value
			int val = queue.take();
			System.out.println("; value:" + val);
		}
	}

	public void main() {

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

public class Producer_ConsumerClass {

	public static void main(String[] args) {
		new App5().main();
	}
}