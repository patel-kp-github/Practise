package com.practise.concurrentPackage;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureClass {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<String> future = executorService.submit(() -> {
			// ...
//			Thread.sleep(10000l);
			return "Hello world";
		});

		String str = future.get();
		System.out.println(str);

		if (future.isDone() && !future.isCancelled()) {
			try {
				str = future.get();
				System.out.println(str + " done");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		try {
			future.get(10, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
	}

}
