import java.util.Scanner;

public class ConvertTest2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("8진수로 변환할 10진수를 입력하세요: ");
		int dec = scanner.nextInt();
		int number = dec;
		
		int[] oct = new int[8];
		int index = 0;
		while (true) {
			int m = dec / 8;
			int r = dec % 8;
			oct[index++] = r;
			if (m == 0) {
				break;
			}
			dec = m;
		}
		
		System.out.print(number + "(을)를 8진수로 변환하면 ");
		for (int i=index - 1; i>=0; i--) {
			System.out.print(oct[i]);
		}
		System.out.println(" 입니다.");
		
	}
	
}



