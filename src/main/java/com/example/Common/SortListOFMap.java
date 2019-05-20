package com.example.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Student {
	int id;
	String name;

	Student(String name, int id) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "id:" + id + " name:" + name;
	}

	public int hashCode() {
		return this.id;
	}

	public boolean equals(Object obj) {
		Student stu = (Student) obj;
		return ((this.id == stu.id) && (this.name.equals(stu.name)));
	}
}

public class SortListOFMap {
	public static void main(String[] args) {
//		new SortListOFMap().SortMap();
//		new SortListOFMap().removeDuplicate();
		new SortListOFMap().MapUniqueValues();
	}

	private void MapUniqueValues() {
		DualMap map = new DualMap();
		map.put("Ram", 200);
		map.put("Aam", 100);
		map.put("Ram", 50);
		map.put("Ram", 100);
		System.out.println(map);

	}

	private void removeDuplicate() {
		// TODO Auto-generated method stub
		Student s1 = new Student("Ram", 200);
		Student s2 = new Student("Ram", 100);
		Student s3 = new Student("Ram", 200);
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		for (Student student : list) {
			System.out.println(student);
		}
		Set set = new HashSet(list);
		list = new ArrayList<>(set);
		System.out.println("after using set");
		for (Student student : list) {
			System.out.println(student);
		}

	}

	public void SortMap() {

		Map<String, Integer> map = new HashMap();

		map.put("Ram", 200);
		map.put("Aam", 100);
		map.put("Zam", 50);
		map.put("Aaam", 150);
		map.put("Raman", 160);
		map.put("Syam", 200);
		map.put("Syama", 300);
		System.out.println(map);

		Set<Entry<String, Integer>> entrySet = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(entrySet);

		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				if (o1.getValue() == o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return (o2.getValue() - o1.getValue());
			}
		});

		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}

class DualMap {

	private ConcurrentHashMap map = new ConcurrentHashMap();

	public void put(Object objA, Object objB) {
		boolean found = false;
		for (Object key : map.keySet()) {
			if (map.get(key) == objB) {
				map.remove(key);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				map.put(objA, objB);
				found = true;
			}
		}
//		if (map.get(objA) != null) {
//			map.put(objA, objB);
//		} else
		if (!found)
			map.put(objA, objB);
//		map.put(objB, objA);
	}

	public Object get(Object key) {
		return map.get(key);
	}

	public void remove(Object key) {
		Object other = map.get(key);
		map.remove(key);
		map.remove(other);
	}

	public String toString() {
		Set set = map.keySet();
		StringBuilder sb = new StringBuilder();
		for (Object key : map.keySet()) {
			sb.append(key + ":" + map.get(key) + "\n");
		}
		return sb.toString();

	}
}