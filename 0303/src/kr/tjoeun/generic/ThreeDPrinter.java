package kr.tjoeun.generic;

//	재료로 Powder와 Plastic을 모두 사용할 수 있는 3D 프린터, 겸용 => Object 클래스 사용
public class ThreeDPrinter {
	
//	겸용 3D 프린터는 Powder와 Plastic을 모두 재료로 받을 수 있어야 하기 때문에
//	Powder와 Plastic의 부모 클래스는 Object 이므로 Object 타입으로 재료 필드를 선언한다.
	private Object material;

	public Object getMaterial() {
		return material;
	}
	public void setMaterial(Object material) {
		this.material = material;
	}

}
