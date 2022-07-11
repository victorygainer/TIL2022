
public class Ranking {

	public static void main(String[] args) {
		
		int[] score = {80, 100, 70, 100, 90};
//		석차를 기억하는 기억장소는 1로 초기화 시킨다.
		int[] rank = {1, 1, 1, 1, 1}; // 석차를 기억하는 배열
		
		for (int i=0; i<score.length; i++) {
			for (int j=0; j<score.length; j++) {
//				System.out.printf("[i = %d, j = %d]", i, j);
				
//				내림차순 석차(큰 점수가 1등)
//				부등호를 ">"로 수정하면 오름차순 석차(작은 점수가 1등)이 계산된다.
				if (score[i] < score[j]) {
					rank[i]++;
				}
				
			}
//			System.out.println();
		}
		
		for (int i=0; i<score.length; i++) {
			System.out.printf("%3d점은 %d등 입니다.\n", score[i], rank[i]);
		}
		
	}
	
}
