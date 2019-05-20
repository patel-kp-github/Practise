package com.example.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FlatMapClass {
	public static void main(String[] args) {
		Map<String, List<String>> people = new HashMap<>();
		people.put("John", Arrays.asList("555-1123", "555-3389"));
		people.put("Mary", Arrays.asList("555-2243", "555-5264"));
		people.put("Steve", Arrays.asList("555-6654", "455-3242"));

		List<String>list=new ArrayList<>();
		list.addAll(Arrays.asList("555-1123", "555-3389"));
		list.addAll(Arrays.asList("444-1123", "555-3389"));
		System.out.println("list:"+list);
//		people.put("John", 1);
//		people.put("Mary", 2);
//		people.put("Steve", 3);

//		List<String> phones = people.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
//		System.out.println(phones);
		
		
		
		
//		List phones2 = (List) people.values().stream().flatMap(mapper).collect(Collectors.toList());
		
//		List<String> list = phones.stream().filter(p->p.startsWith("555")).collect(Collectors.toList());
		
		System.out.println("1"+people.values().stream().map(Collection::stream).collect(Collectors.toList()));
		System.out.println("2"+people.values().stream().flatMap(Collection::stream).collect(Collectors.toList()));
	}

}
