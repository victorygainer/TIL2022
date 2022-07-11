
public class SnailTest2 {

	public static void main(String[] args) {
		
		int[][] a = new int[9][9];
		int n = 1, s = 1, i = a.length / 2, j = a.length / 2, k = 0;
		a[i][j] = n;
		boolean flag = false;

		while (true) {
			k++;
			for (int p=1; p<=k; p++) {
				n++; // 3시 방향부터 채우기
				j += s;
				if (n > Math.pow(a.length, 2)) {
					flag = true;
					break;
				}
				a[i][j] = n;
			}
			if (flag) {
				break;
			}
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
