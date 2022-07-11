import java.util.Scanner;

public class Ranking2 {

	public static void main(String[] args) {
		
//		int[] score = {80, 100, 70, 100, 90};
//		int[] rank = {1, 1, 1, 1, 1};
		
		Scanner scanner = new Scanner(System.in);
		
//		석차를 계산할 점수의 개수와 점수를 입력받아 석차를 계산한다.
		System.out.print("석차를 계산할 점수의 개수를 입력하세요: ");
		int n = scanner.nextInt();
		
//		입력받은 점수의 개수만큼 배열을 만든다.
		int[] score = new int[n];
		int[] rank = new int[n];
		
//		점수 데이터를 입력받아 score 배열을 초기화 시키고 rank 배열은 1로 초기화 시킨다.
//		for (int i=0; i<score.length; i++) {
//			System.out.print(i + 1 + "번째 학생의 점수를 입력하세요: ");
//			score[i] = scanner.nextInt();
//			rank[i] = 1;
//		}
		
		System.out.print("공백으로 구분해서 점수를 입력하세요: ");
		for (int i=0; i<score.length; i++) {
			score[i] = scanner.nextInt();
			rank[i] = 1;
		}
		
		
		for (int i=0; i<score.length-1; i++) {
			for (int j=i+1; j<score.length; j++) {

//				i번째 점수가 크면 j번째 석차를 증가시키고 j번째 점수가 크면 i번째 석차를 증가시킨다.
//				부등호 방향을 모두 반대로 수정하면 오름차순 석차가 계산된다.
				if (score[i] > score[j]) {
					rank[j]++;
				} else if (score[i] < score[j]) {
					rank[i]++;
				}
				
			}
		}
		
		for (int i=0; i<score.length; i++) {
			System.out.printf("%3d점은 %d등 입니다.\n", score[i], rank[i]);
		}

		
	}
	
}
