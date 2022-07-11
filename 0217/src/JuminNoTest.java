import java.util.Scanner;

public class JuminNoTest {

	public static void main(String[] args) {
		
//		주민등록번호 13자리를 '-'없이 입력받아 성별 판단하기
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민등록번호 13자리를 '-'없이 입력하세요: ");
		String jumin = scanner.nextLine().trim();
		
//		8304221185600 => 둘리 주민등록번호
//		System.out.println(jumin.charAt(6));
		
//		숫자와 문자는 표현 방법이 다르다. 따라서 '1'(문자, 0110001)와 1(숫자, 0000001)는 다른 데이터로
//		취급된다.
		if (jumin.charAt(6) == '1' || jumin.charAt(6) == '3') {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
		
		if (jumin.charAt(6) - '0' == 1 || jumin.charAt(6) - 48 == 3) {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
		
		if (jumin.charAt(6) % 2 == 0) {
			System.out.println("여자");
		} else {
			System.out.println("남자");
		}
		
	}
	
}








