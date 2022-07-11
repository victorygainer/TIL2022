import java.util.Arrays;
import java.util.Random;

public class LottoNumber3 {

	public static void main(String[] args) {
		
		Random random = new Random();
		int[] lotto = new int[7];
		int index = 0; // lotto 배열의 인덱스
		
//		같은 숫자가 몇번 중복될지 모르기 때문에 무한루프를 돌려서 처리한다.
		while (true) {
			int r = random.nextInt(45) + 1;
//			중복방지 코드
			boolean check = true;
//			for (int i=0; i<lotto.length; i++) { // 배열 전체에서 중복 검사
			for (int i=0; i<index; i++) { // 배열에 저장된 데이터만 중복 검사
				if (lotto[i] == r) { // 중복되는 숫자가 있나?
//					System.out.println(Arrays.toString(lotto));
//					break는 break가 소속된 {} 블록의 break 이후의 문장을 실행하지 않고 {} 블록을 빠져나간다.
//					continue는 continue가 소속된 블록의 continue 이후의 문장을 실행하지 않고 {} 블록의
//					처음으로 이동한다.
//					continue;
					check = false;
					break;
				}
			}
			
			if (check) { // 중복되는 숫자가 발생되었나?
				lotto[index++] = r;
				if (lotto.length == index) {
					break;
				}
			}
			
			
		}
		
		System.out.print("1등 번호: ");
		for (int i=0; i<6; i++) {
			System.out.printf("%02d ", lotto[i]);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.printf("보너스: %02d\n", lotto[6]);
		
	}
	
}
