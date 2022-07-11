package kt.tjoeun.scoreList;

public class ScoreListMain {

	public static void main(String[] args) {
		
		/*
		ScoreVO score1 = new ScoreVO();
		System.out.println(score1);
		ScoreVO score2 = new ScoreVO("홍길동", 100, 100, 99);
		System.out.println(score2);
		ScoreVO score3 = new ScoreVO("임꺽정", 45, 71, 59);
		System.out.println(score3);
		
		System.out.println("score1.count: " + score1.count); // 0
		score2.count = 100; // static 변수를 수정한다.
		System.out.println("score2.count: " + score2.count); // 100
//		static 변수는 모든 객체가 공유하므로 score3의 count도 수정된다.
		System.out.println("score3.count: " + score3.count); // 100
		System.out.println(ScoreVO.count);
		*/
		
		ScoreVO score1 = new ScoreVO("홍길동", 100, 100, 99);
		ScoreVO score2 = new ScoreVO("임꺽정", 45, 71, 59);
		ScoreVO score3 = new ScoreVO("장길산", 88, 85, 80);
		ScoreVO score4 = new ScoreVO("일지매", 88, 80, 85);
		ScoreVO score5 = new ScoreVO("손오공", 95, 83, 84);
		
		ScoreList scoreList = new ScoreList();
		
		scoreList.addScore(score1);
		scoreList.addScore(score2);
		scoreList.addScore(score3);
		scoreList.addScore(score4);
		scoreList.addScore(score5);
		
		System.out.println(scoreList);
		
	}
	
}



