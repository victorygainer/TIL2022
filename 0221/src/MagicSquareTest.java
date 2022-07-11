
public class MagicSquareTest {

	public static void main(String[] args) {
		
		int[][] a = new int[5][5];
//		마방진을 구현할 배열이 5행 5열일 경우 최초의 "1"이 채워질 위치를 지정한다.
		int i = 0, j = 2;

//		마방진에 채워질 숫자의 개수만큼 반복하며 마방진을 완성한다.
		for (int k=1; k<=Math.pow(5, 2); k++) {
//			마방진에 숫자를 채운다.
			a[i][j] = k;
//			마방진에 채운 숫자가 5의 배수인가 판단한다.
			if (k % 5 == 0) {
//				마방진에 채운 숫자가 5의 배수면 다음 숫자는 아래줄에 채운다.
				i++;
			} else {
//				마방진에 채운 숫자가 5의 배수가 아니면 다음 숫자는 오른쪽 위 방향으로 채운다.
				if (--i == -1) {
					i = 4;
				}
				if (++j == 5) {
					j = 0;
				}
			}
		}
		
		for (i=0; i<a.length; i++) {
			for (j=0; j<a[0].length; j++) {
				System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}

	}
	
}
