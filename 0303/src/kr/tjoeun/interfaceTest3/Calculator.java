package kr.tjoeun.interfaceTest3;

public abstract class Calculator implements Calc {

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int sub(int num1, int num2) {
		return num1 - num2;
	}

//	@Override
//	public void description(int number) {
//		System.out.println(
//			"Calc 인터페이스서 작성된 default 메소드가 Calculator 클래스로 구현된 \n" +
//			"default 메소드 Override"
//		);
//	}
	
}
