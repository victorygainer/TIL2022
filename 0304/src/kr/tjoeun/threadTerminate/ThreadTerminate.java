package kr.tjoeun.threadTerminate;

public class ThreadTerminate extends Thread {

	private boolean flag = true;
	
	public ThreadTerminate() { }
//	Thread 클래스의 생성자를 호출해서 스레드 이름을 지정한다.
	public ThreadTerminate(String name) {
		super(name);
	}
	
	public boolean isFlag() {
		return flag;
	}
//	setter 메소드를 실행해서 스레드를 종료할 수 있게 flag 변수 값을 변경한다.
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		
		while (flag) {
			try {
//				ThreadTreminate 클래스는 Thread 클래스를 상속받아서 Thread 클래스의 모든 기능을
//				갖추고있으므로 Thread 클래스의 메소드를 실행할 때 앞에 Thread 클래스를 쓰지 않아도
//				사용할 수 있다.
//				Thread.sleep(100); // Thread를 생략해도 된다.
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " end");
		
	}

}











