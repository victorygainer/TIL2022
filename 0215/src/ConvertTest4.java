import java.util.Scanner;

public class ConvertTest4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("10진수를 입력하세요: ");
		int dec = scanner.nextInt();
		System.out.print("변환할 진법을 입력하세요: ");
		int n = scanner.nextInt();
		int number = dec;
		
		int[] hex = new int[8];
		int index = 0;
		while (true) {
			int m = dec / n;
			int r = dec % n;
			hex[index++] = r;
			if (m == 0) {
				break;
			}
			dec = m;
		}
		
		System.out.print(number + "(을)를 " + n + "진수로 변환하면 ");
		for (int i=index - 1; i>=0; i--) {
			if (hex[i] < 10) {
//				hex 배열에 저장된 값이 10 미만이면 저장된 값을 그대로 출력하면 된다.
				System.out.print(hex[i]);
			} else {
//				hex 배열에 저장된 값이 10 미만이면 영문자로 변환해서 출력하면 된다.
//				System.out.print((char) (hex[i] + 55));
				System.out.printf("%c", hex[i] + 55);
			}
		}
		System.out.println(" 입니다.");
		
	}
	
}



