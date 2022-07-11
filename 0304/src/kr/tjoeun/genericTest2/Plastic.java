package kr.tjoeun.genericTest2;

//	재료 - Plastic
public class Plastic extends Material {

	@Override
	public String toString() {
		return "Plastic";
	}

	@Override
	void doPrinting() {
		System.out.println("Plastic 재료로 출력합니다.");
	}

}
