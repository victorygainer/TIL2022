import java.util.Scanner;

public class EuclidTest2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자 2개를 입력하세요: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int r = 1; // 한국산업인력관리공단 공식 답변에는 스위치 변수로 사용된다 라고 하더라...
		
		int high, low;
		if (a > b) {
			high = a;
			low = b;
		} else {
			low = a;
			high = b;
		}
		
		while (r > 0) { // 나머지가 0이 아닐때 까지 반복한다.
			r = high % low;
			high = low;
			low = r;
		}
		
//		큰수를 작은수로 나눠 떨어지면 큰수를 기억하는 변수에 작은수가 저장되서 반복이 종료된다.
		int l = a * b / high;
		System.out.println("최대공약수: " + high + ", 최소공배수: " + l);
		
	}
	
}










