package com.practise.concurrentPackage;

import java.util.concurrent.Executor;

/*
 * Executor is an interface that represents an object that executes provided tasks
 * One point to note here is that Executor does not strictly require the task execution to be asynchronous.
 *  In the simplest case, an executor can invoke the submitted task instantly in the invoking thread.
 */
public class ExecutorExample {
	public static void main(String[] args) {
		Executor executer = new MyInvoker();
		executer.execute(new App3());
	}
}

class MyInvoker implements Executor {

	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub
		command.run();
	}

//	public void execute() {
//	    Executor executor = new MyInvoker();
//	    executor.execute(() -> {
//			// task to be performed
//			System.out.println(Thread.currentThread().getName());
//		});
//
//	}
}

class App3 extends Thread {
	int i = 10;

	public void run() {
		// TODO Auto-generated method stub
		i = i + 1;
		System.out.println(Thread.currentThread().getName() + " " + i);
	}

}