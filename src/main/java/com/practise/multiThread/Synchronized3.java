package com.practise.multiThread;

/*
 * All thread gets variable initail value if var is clread inside Thread Obj
 * 
 */
class App3 extends Thread {
	int i = 10;

	public void run() {
		// TODO Auto-generated method stub
		i = i + 1;
		System.out.println(Thread.currentThread().getName() + " " + i);
	}

	public void main() {
		App3 t1 = new App3();
		App3 t2 = new App3();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}
	}
}

public class Synchronized3 {
	public static void main(String[] args) {
		new App3().main();
	}
}