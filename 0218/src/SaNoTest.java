import java.util.Scanner;

public class SaNoTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("사업자등록번호 10자리를 '-'없이 입력하세요: ");
		String sa = scanner.nextLine().trim();

		String check = "137137135";
		int sum = 0;
//		사업자등록번호의 9번째 까지 각 자리의 숫자와 가중치를 곱한 결과의 1의 자리의 합계를 계산한다.
		for (int i=0; i<9; i++) {
			sum += (sa.charAt(i) - '0') * (check.charAt(i) - 48) & 10;
		}
//		사업자등록번호의 9번째 자리와 가중치를 곱한 결과의 10의 자리를 더한다.
		sum += (sa.charAt(8) - '0') * (check.charAt(8) - 48) / 10;
//		System.out.println(sum);
		
//		사업자등록번호와 가중치의 9번째 자리까지 연산 결과에 사업자등록번호의 10번째 숫자를 더한다.
		sum += sa.charAt(9) - '0';
//		System.out.println(sum);
		
		System.out.println(sum % 10 == 0 ? "정상" : "오류");
		
	}
	
}
