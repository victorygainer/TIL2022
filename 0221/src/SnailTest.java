
public class SnailTest {

	public static void main(String[] args) {
		
		int[][] a = new int[9][9];
		int n = 0; // 배열에 채워질 숫자를 1씩 증가시킬 변수
		int s = 1; // 행과 열이 1 또는 -1씩 증가 및 감소 처리에 사용할 변수
		int i = 0; // 행
		int j = -1; // 열
		int k = a.length; // 반복문의 반복 횟수 제어에 사용하는 변수
		
		while (true) {
//			행 방향 채우기
			for (int p=1; p<=k; p++) {
				j += s;
				a[i][j] = ++n;
			}
			if (--k == 0) {
				break;
			}
//			열 방향 채우기
			for (int p=1; p<=k; p++) {
				i += s;
				a[i][j] = ++n;
			}
			s *= -1;
		}
		
		for (i=0; i<a.length; i++) {
			for (j=0; j<a[0].length; j++) {
				System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}
		
	}
	
}
