package com.practise.multiThread;

import java.util.Scanner;

/*
 * volatile is to force thread pick variable value from Ram not from Cache
 */
public class VolatileClass {

	public static void main(String[] args) {

		App1 app = new App1();
		app.start();
		System.out.println();
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		app.shutdown();

	}
}

class App1 extends Thread {

	private volatile boolean running = true;

	public void run() {

		while (running) {
			System.out.println("hello");
		}
	}

	public void shutdown() {
		running = false;
	}
}
