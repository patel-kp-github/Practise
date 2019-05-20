package com.example.Common;

import java.util.HashMap;
import java.util.Map;

public class UniqueMapValue {
	public static void main(String[] args) {
//		new SortListOFMap().SortMap();
//		new SortListOFMap().removeDuplicate();
//		new UniqueMapValue().MapUniqueValues();h >>> 16
//		System.out.println(1617 >>> 16);
		System.out.println(10>>>4);
		System.out.println(10%4);
	}

	private void MapUniqueValues() {
		Map map = new HashMap();
		map.put(new Key("Ram"), 200);
		map.put(new Key("Aam"), 100);
		map.put(new Key("Ram"), 50);
		map.put(new Key("Ram"), 100);
		System.out.println(map);

	}
}

class Key {
	String key;

	Key(String key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		return (int) key.charAt(0);
	}

	@Override
	public boolean equals(Object obj) {
		Key key=(Key)obj;
		return this.key.equals(key.key);
	}
	public String toString() {
		return key;
	}
}