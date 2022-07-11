import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class LottoNumber2 {

	public static void main(String[] args) {
		
		Random random = new Random();
		int[] lotto = new int[45];
		for (int i=0; i<lotto.length; i++) {
			lotto[i] = i + 1;
		}
		
//		복권 구매금액을 입력받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.print("복권 구매금액을 입력하세요: ");
		int money = scanner.nextInt();
		
//		입력한 금액만큼 반복하며 자동 로또 번호를 생성한다.
		for (int j=0; j<money/1000; j++) {
			
			for (int i=0; i<1000000; i++) {
				int r = random.nextInt(44) + 1;
				int temp = lotto[0];
				lotto[0] = lotto[r];
				lotto[r] = temp;
			}
			
//			복권 번호를 오름차순으로 정렬한다.
			int[] lottoNumber = new int[6];
//			Integer[] lottoNumber = new Integer[6]; // 내림차순 정렬은 Integer 배열을 사용해야 한다.
			for (int i=0; i<6; i++) {
				lottoNumber[i] = lotto[i];
			}
			
			for (int i=0; i<lottoNumber.length-1; i++) {
				for (int k=i+1; k<lottoNumber.length; k++) {
					if (lottoNumber[i] > lottoNumber[k]) {
						int temp = lottoNumber[i];
						lottoNumber[i] = lottoNumber[k];
						lottoNumber[k] = temp;
					}
				}
			}
//			Arrays.sort(lottoNumber); // 오름차순
//			Arrays.sort(lottoNumber, Collections.reverseOrder()); // 내림차순
			
			System.out.printf("%2d game: ", j + 1);
			for (int i=0; i<6; i++) {
				System.out.printf("%02d ", lottoNumber[i]);
			}
			System.out.println();
			
		}
		
	}

}




