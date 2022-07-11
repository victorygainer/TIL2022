package kr.tjoeun.collectionTest;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		
//		HashMap은 사전식으로 데이터를 저장한다. Key(K)에 Value(V)를 할당하는 방식으로 저장된다.
//		Key는 일반적으로 String 타입으로 하고 Value는 저장할 데이터 타입으로 만든다.
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		
//		put(key, value) 메소드는 HashMap의 key에 value를 할당해서 저장한다.
		hmap.put("apple", 1000);
//		size() 메소드는 HashMap에 저장된 데이터의 개수를 얻어온다.
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("banana", 3500);
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("orange", 2000);
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("melon", 20000);
		System.out.println(hmap.size() + ": " + hmap);
		hmap.put("water melon", 15000);
		System.out.println(hmap.size() + ": " + hmap);
		
//		HashMap에 저장된 데이터를 수정하려면 put(key, value)를 사용해서 수정한다.
//		put() 메소드를 없는 key에 값을 할당하면 데이터가 저장되고 있는 key에 값을 할당하면
//		그 key에 해당되는 데이터가 수정된다.
		hmap.put("orange", 4000);
		System.out.println(hmap.size() + ": " + hmap);
		
//		get(key) 메소드는 HashMap에 저장된 데이터 중에서 key에 해당되는 value를 얻어온다.
		System.out.println(hmap.get("melon"));
		
//		remove(key) 메소드는 HashMap에 저장된 데이터 중에서 key에 해당되는 값을 제거한다.
		hmap.remove("banana");
		System.out.println(hmap.size() + ": " + hmap);
		
//		clear() 메소드는 HashMap에 저장된 모든 데이터를 제거한다.
		hmap.clear();
		System.out.println(hmap.size() + ": " + hmap);
		
	}
	
}







