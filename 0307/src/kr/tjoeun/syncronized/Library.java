package kr.tjoeun.syncronized;

import java.util.ArrayList;

public class Library {

	public ArrayList<String> bookList = new ArrayList<String>();
	
	public Library() {
		bookList.add("다빈치 코드");
		bookList.add("천사와 악마");
		bookList.add("디지털 포트리스");
//		bookList.add("라스트 심볼");
//		bookList.add("타나토노트");
//		bookList.add("개미");
	}
	
//	도서 대여 메소드
//	동기화 메소드는 synchronized 예약어를 사용해서 선언한다.
//	메소드가 실행하는 모든 내용이 종료될 때 까지 다른 스레드가 실행되지 않도록 한다.
	public synchronized String lendBook() {
//		currentThread() 메소드로 현재 스레드의 정보를 얻어온다.
		Thread thread = Thread.currentThread();
		
//		대여할 책이 없으면 책이 반납될 때 까지 스레드를 일시적으로 멈춘다.
//		returnBook() 메소드에서 notify() 메소드를 실행해서 스레드를 깨울 때
		if (bookList.size() == 0) {
			try {
				System.out.println(thread.getName() + " 대기 시작");
				wait();
				System.out.println(thread.getName() + " 대기 종료");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
//		여기까지 왔으면 도서관에 대여할 책이 있다는 의미이므로 도서를 대여한다.
		String book = bookList.remove(0);
//		getName() 메소드로 현재 스레드 정보에서 스레드 이름을 얻어올 수 있다.
		System.out.println(thread.getName() + ": " + book + " 대여");
		return book;
	}
	
//	도서 반납 메소드
	public synchronized void returnBook(String book) {
		Thread thread = Thread.currentThread();
//		반납된 도서를 도서관에 넣는다.
		bookList.add(book);
//		도서관에 책이 없어서 일시적으로 멈춰있던 스레드를 깨운다.
//		notify();
		notifyAll();
		System.out.println(thread.getName() + ": " + book + " 반납");
	}
	
}






