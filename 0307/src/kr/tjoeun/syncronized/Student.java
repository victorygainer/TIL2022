package kr.tjoeun.syncronized;

public class Student extends Thread {

//	생성자를 통해서 스레드 이름(도서를 대여할 학생 이름)을 넣어준다.
	public Student(String name) {
		super(name);
	}

	@Override
	public void run() {
		
		try {
			String title = LibraryMain.library.lendBook();
			if (title == null) {
				return;
			}
			sleep(2500);
			LibraryMain.library.returnBook(title);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("책을 빌리지 못했습니다.");
		}
		
	}
	
}
