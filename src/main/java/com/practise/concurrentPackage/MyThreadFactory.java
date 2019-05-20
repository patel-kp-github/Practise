package com.practise.concurrentPackage;

import java.util.concurrent.ThreadFactory;

import org.springframework.context.annotation.Bean;

public class MyThreadFactory implements ThreadFactory {
	int threadId;
	String name;

	public MyThreadFactory(String name) {
		threadId = 1;
		this.name = name;
	}

	@Override
	@Bean
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, name + "-Thread_" + threadId);
		System.out.println("created new thread with id : " + threadId + " and name : " + t.getName());
		threadId++;
		return t;
	}

	public static void main(String[] args) {
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		for (int i = 0; i < 10; i++) {
			Thread t = factory.newThread(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());

				}
			});
			t.start();
		}
	}

}
