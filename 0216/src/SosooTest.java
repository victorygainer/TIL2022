import java.util.Scanner;

public class SosooTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("소수인가 판단할 숫자를 입력하세요: ");
		int number = scanner.nextInt();
		
//		모든 수는 1로 나눠 떨어지기 때문에 2부터 떨어질 때 까지 나눠본다.
		int i;
		for (i=2; i<=number; i++) {
			if (number % i == 0) {
//				나눠서 떨어지면 소수인가 판단하기 위해서 반복을 탈출한다.
				break;
			}
		}
		
//		소수인가 판단한다.
		if (i == number) {
			System.out.println(number + "는 소수입니다.");
		} else {
			System.out.println(number + "는 소수가 아닙니다.");
		}
		
//		조건식 ? 참일때 할 일 : 거짓일때 할 일
		System.out.println(number + "는 소수" + (i == number ? "입니다." : "가 아닙니다."));
		
	}
	
}
