package kr.tjoeun.genericTest2;

//	재료 - Powder
public class Powder extends Material {

	@Override
	public String toString() {
		return "Powder";
	}

	@Override
	void doPrinting() {
		System.out.println("Powder 재료로 출력합니다.");
	}

}
