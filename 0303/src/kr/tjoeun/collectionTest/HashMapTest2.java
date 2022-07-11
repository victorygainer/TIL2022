package kr.tjoeun.collectionTest;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTest2 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		
		hmap.put("apple", 1000);
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("banana", 3500);
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("orange", 2000);
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("melon", 20000);
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("water melon", 15000);
		System.out.println(hmap.size() + ": " + hmap);
		
//		values() 메소드는 HashMap에 저장된 데이터의 value만 얻어온다.
		System.out.println(hmap.values());
//		keySet() 메소드는 HashMap에 저장된 데이터의 key만 얻어온다.
		System.out.println(hmap.keySet());
		
//		HashMap에 저장된 데이터의 value만 얻어와서 ArrayList에 저장하기
		ArrayList<Integer> valueList = new ArrayList<Integer>();
		for (Integer value : hmap.values()) {
			valueList.add(value);
		}
		System.out.println(valueList);
		
//		HashMap에 저장된 데이터의 key만 얻어와서 ArrayList에 저장하기
		ArrayList<String> keyList = new ArrayList<String>();
		for (String str : hmap.keySet()) {
			keyList.add(str);
		}
		System.out.println(keyList);
		
		for (String key : hmap.keySet()) {
			System.out.println(key + ": " + hmap.get(key));
		}
				
	}
	
}







