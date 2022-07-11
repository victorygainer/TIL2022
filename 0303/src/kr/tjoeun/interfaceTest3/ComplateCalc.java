package kr.tjoeun.interfaceTest3;

public class ComplateCalc extends Calculator  {

	@Override
	public int mul(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int div(int num1, int num2) {
		if (num2 == 0) {
			return ERROR;
		} else {
			return num1 / num2;
		}
	}

//	@Override
//	public void description(int number) {
//		System.out.println(
//			"Calc 인터페이스서 작성된 default 메소드가 Calculator 클래스로 구현되고 \n" +
//			"Calculator 클래스에서 ComplateCalc 클래스로 상속된 default 메소드 Override"
//		);
//	}

}
