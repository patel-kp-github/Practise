package com.example.DS.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Practise3 {
	Map map = new TreeMap();

//	List list=new ArrayList<>();

//	list.add

	static class TreeCompare implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		/*
		 * Compares keys based on the last word's natural ordering
		 */
//		public int compare(String a, String b) {

	}

	public static void main(String[] args) {

		TreeMap map = new TreeMap<>();
		String[] inputs = new String[] { "D", "D", "A", "A", "B" };
		for (String string : inputs) {
			if (!map.containsKey(string))
				map.put(string, 1);
			else
				map.put(string, ((Integer) map.get(string) + 1));
		}

		System.out.println(map);

		Set set = map.entrySet();
		List list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return (o2.getValue().compareTo(o1.getValue()));
			}
		});
		
		System.out.println(list);
	}

}
