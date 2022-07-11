import java.util.Scanner;

public class ConvertTest3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("16진수로 변환할 10진수를 입력하세요: ");
		int dec = scanner.nextInt();
		int number = dec;
		
		int[] hex = new int[8];
		int index = 0;
		while (true) {
			int m = dec / 16;
			int r = dec % 16;
			hex[index++] = r;
			if (m == 0) {
				break;
			}
			dec = m;
		}
		
		char[] h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		System.out.print(number + "(을)를 16진수로 변환하면 ");
		for (int i=index - 1; i>=0; i--) {
//			System.out.print(h[hex[i]]);
			System.out.printf("%c", h[hex[i]]);
		}
		System.out.println(" 입니다.");
		
	}
	
}



