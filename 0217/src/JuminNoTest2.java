import java.util.Date;
import java.util.Scanner;

public class JuminNoTest2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민등록번호 13자리를 '-'없이 입력하세요: ");
		String jumin = scanner.nextLine().trim();

//		8304221185600 => 둘리 주민등록번호
//		System.out.println(jumin.substring(0, 2) + 1900); // 831900
//		System.out.println(jumin.substring(0, 2).charAt(0) - '0');
//		int a = jumin.substring(0, 2).charAt(0) - '0'; // 8
//		int b = jumin.substring(0, 2).charAt(1) - 48; // 3
//		int year = 1900 + a * 10 + b;
//		System.out.println(year); // 1983
		
//		Integer.parseInt() 메소드는 인수로 지정된 문자열을 정수로 변환한다.
//		Double.parseDouble() 메소드는 인수로 지정된 문자열을 실수로 변환한다.
//		int year = 1900 + Integer.parseInt(jumin.substring(0, 2));
//		System.out.println(year); // 1983
		
		int year = Integer.parseInt(jumin.substring(0, 2));
//		if (jumin.charAt(6) <= '2') {
//			year += 1900;
//		} else {
//			year += 2000;
//		}
		year += jumin.charAt(6) <= '2' ? 1900 : 2000;
//		System.out.println(year); // 출생년도
		
		Date date = new Date();
//		System.out.println(date.getYear() + 1900); // 올해
		
		System.out.println(date.getYear() + 1900 - year); // 만 나이
		
	}
	
}





