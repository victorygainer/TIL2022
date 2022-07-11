package kr.tjoeun.interfaceTest3;

public class InterfaceTest3 {

	public static void main(String[] args) {
		
		Calc calc = new ComplateCalc();
		int num1 = 10;
		int num2 = 2;
		
		System.out.println(num1 + " + " + num2 + " = " + calc.add(num1, num2));
		System.out.println(num1 + " - " + num2 + " = " + calc.sub(num1, num2));
		System.out.println(num1 + " * " + num2 + " = " + calc.mul(num1, num2));
		System.out.println(num1 + " / " + num2 + " = " + calc.div(num1, num2));
		
//		Calc 인터페이스에서 정의한 default 메소드를 실행한다.
		calc.description(5);
		
//		Calc 인터페이스에서 정의한 default 메소드를 실행한다.
		int[] arr = {1, 2, 3, 4, 5};
		int sum = Calc.total(arr);
		System.out.println("sum: " + sum);
		
	}
	
}
