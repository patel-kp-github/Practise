package com.example.Common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.cglib.core.GeneratorStrategy;

public class Practise1 {

	public static void main(String[] args) throws InterruptedException {
//		new Practise1().createAnnotation();
		BlockingQueue<Integer>queue=new LinkedBlockingQueue<>(1);
		queue.add(1);
		queue.put(2);
		System.out.println(queue.take());
		System.out.println(queue.size());
		System.out.println(queue.take());
	}

	private void createAnnotation() {
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
//		new Concurrenct
//		Collections.synchronizedList(list)
		ConcurrentHashMap map2 = new ConcurrentHashMap(map);
		Map map3 = Collections.synchronizedMap(map);
		
		map.put("ram", 1);
		map.put("ram", 2);
		map.put(null, 3);
		map.put(null, 6);
		for (Object key : map.keySet()) {
			System.out.println(key+" "+map.get(key));
		}
		System.out.println(map);

	}

	public static void reverseStrinWordByWord() {

		// "i love india"
		// "india love i"
		String str = "i love india";
		char[] arr = str.toCharArray();
		int index = arr.length-1;
		StringBuffer sb = new StringBuffer();
		int end = index;
		while (index >= 0) {
//			System.out.println(index+","+end);
			if (index == 0) {
				sb.append(str.substring(index, end));
			} else if (arr[index - 1] == ' ') {

				sb.append(str.substring(index, end));
				sb.append(" ");
				end = index - 1;
			}
			index--;
		}

		System.out.println(sb);
		System.out.println(new Practise1().reverseString("abcd"));
	}

	String reverse = "";

	public String reverseString(String str) {

		if (str.length() == 1) {
			return str;
		} else {
			reverse += str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
			return reverse;
		}
	}
}
