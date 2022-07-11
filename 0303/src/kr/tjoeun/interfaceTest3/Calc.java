package kr.tjoeun.interfaceTest3;

public interface Calc {

	public static final double PI = 3.141592;
	int ERROR = -99999999;
	
//	추상 메소드
	public abstract int add(int num1, int num2);
	int sub(int num1, int num2);
	int mul(int num1, int num2);
	int div(int num1, int num2);
	
//	default 메소드 => JDK 8에서 추가
//	default 메소드는 구현부를 가지는 메소드로 default 예약어를 사용해서 선언한다.
//	인터페이스를 구현받는 클래스들에서 공통으로 사용할 수 있는 메소드로 상속 또는 구현시
//	Override가 가능하다.
	default void description(int number) {
		System.out.println("정수 계산기를 구현합니다.");
		myMethod(number); // private 메소드
	}
	
//	static 메소드 => JDK 8에서 추가
//	static 메소드는 구현부를 가지는 메소드로 static 예약어를 사용해서 선언한다.
//	인터페이스 객체를 생성하지 않고 인터페이스 이름에 "."을 찍어 실행할 수 있다.
	static int total(int[] arr) {
		int total = 0;
		for (int i : arr) {
			total += i;
		}
		myStaticMethod();
		return total;
	}
	
//	private 메소드 => JDK 9에서 추가
//	인터페이스를 구현한 클래스에서 사용하거나 Override 해서 사용할 수 없다.
//	인터페이스의 내부의 default 메소드에서 사용하기 위해 구현되는 메소드
	private void myMethod(int number) {
		for (int i=0; i<number; i++) {
			System.out.println("private method");
		}
	}
	
//	private static 메소드 => JDK 9에서 추가
//	인터페이스를 구현한 클래스에서 사용하거나 Override 해서 사용할 수 없다.
//	인터페이스의 내부의 static 메소드에서 사용하기 위해 구현되는 메소드
	private static void myStaticMethod() {
		System.out.println("private static method");
	}
	
}









