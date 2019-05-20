package com.example.DS.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Practise2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("entrt no of cases:");
		int noOftest = Integer.parseInt(sc.nextLine());
		System.out.println("entrt no of queries:");
		int noOfqueries = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < noOftest; i++) {
			String[] inputs = new String[noOfqueries];
			for (int j = 0; j < noOfqueries; j++) {

				inputs[j] = sc.nextLine();
			}
			new Practise2().process(inputs);

		}
//		String[] inputs = new String[] { "D", "D", "A", "A", "c", "B", "A", "top 3" };
//		new Practise2().process(inputs);
	}

	private void process(String[] inputs) {
		// TODO Auto-generated method stub
		for (String input : inputs) {
			if (input.startsWith("top ")) {
				fetchTopElement(Integer.parseInt(input.split(" ")[1]));
			} else {
				addToSearchEngine(input);
			}
		}
	}

	TreeMap map = new TreeMap<>();
	List<Entry<String, Integer>> list = new ArrayList<>();

	private void addToSearchEngine(String input) {
		if (!map.containsKey(input))
			map.put(input, 1);
		else
			map.put(input, ((Integer) map.get(input) + 1));

		Set set = map.entrySet();
		list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				// map:{A=2, B=1, D=2}
				if (o1.getValue() == o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return (o2.getValue() - (o1.getValue()));
			}
		});

	}

	private void fetchTopElement(int i) {
		int count = 0;
		System.out.println("total:" + list + " " + i);
		for (Entry<String, Integer> entry : list) {
			if (count == i)
				return;
			System.out.print(entry.getKey() + " ");
			count++;
		}
	}

}
