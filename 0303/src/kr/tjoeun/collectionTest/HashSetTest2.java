package kr.tjoeun.collectionTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest2 {

	public static void main(String[] args) {
		
		HashSet<String> hset = new HashSet<String>();
		
		hset.add("홍길동");
		System.out.println(hset.size() + ": " + hset);
		hset.add("임꺽정");
		System.out.println(hset.size() + ": " + hset);
		hset.add("장길산");
		System.out.println(hset.size() + ": " + hset);
		hset.add("일지매");
		System.out.println(hset.size() + ": " + hset);
		hset.add("홍길동");
		System.out.println(hset.size() + ": " + hset);
		System.out.println("=======================");
		
		ArrayList<String> list = new ArrayList<String>();
//		향상된 for를 사용해서 HashSet 이나 TreeSet 객체의 데이터를 1개씩 얻어올 수 있다.
		for (String str : hset) {
			list.add(str);
		}
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("=======================");
		
//		Iterator 인터페이스는 HashSet 이나 TreeSet과 같이 입력하는 순서와 저장되는 순서가 달라서
//		get(), set() 메소드를 사용할 수 없는 객체를 분리한다.
//		HashSet, TreeSet 객체에서 iterator() 메소드를 실행하면 데이터 단위로 분리한다.
		Iterator<String> iterator = hset.iterator();
		
//		hasNext() 메소드는 Iterator 인터페이스 객체에 다음에 읽을 데이터가 있으면 true, 없으면
//		false를 리턴한다.
		while (iterator.hasNext()) { // Iterator 객체에 데이터가 있는 동안 반복한다.
//			next() 메소드는 Iterator 인터페이스 객체의 다음 데이터를 얻어온다.
			System.out.println(iterator.next());
		}
		System.out.println("=======================");
		
		hset.remove("장길산");
		System.out.println(hset.size() + ": " + hset);
		hset.clear();
		System.out.println(hset.size() + ": " + hset);
		
	}
	
}










