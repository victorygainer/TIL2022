package kr.tjoeun.generic;

public class ThreeDPrinterTest {

	public static void main(String[] args) {
		
		ThreeDPrinterPowder powderPrinter = new ThreeDPrinterPowder();
		Powder powder = new Powder();
		powderPrinter.setMaterial(powder);
		System.out.println(powderPrinter.getMaterial());
		powder = powderPrinter.getMaterial();
		System.out.println("=======================================");
		
		ThreeDPrinterPlastic plasticPrinter = new ThreeDPrinterPlastic();
		Plastic plastic = new Plastic();
		plasticPrinter.setMaterial(plastic);
		System.out.println(plasticPrinter.getMaterial());
		plastic = plasticPrinter.getMaterial();
		System.out.println("=======================================");
		
		ThreeDPrinter threeDPrinter = new ThreeDPrinter();
		
		threeDPrinter.setMaterial(powder);
		System.out.println(threeDPrinter.getMaterial());
//		자식 객체를 부모 객체에 넣을때(upcasting)는 별다른 문제가 발생되지 않지만
//		부모 객체에 저장된 자식 객체를 자식 객체에 넣을때(downcasting)는 반드시
//		형변환 시켜서 넣어야 한다.
		powder = (Powder) threeDPrinter.getMaterial();
		System.out.println("=======================================");
		
		threeDPrinter.setMaterial(plastic);
		System.out.println(threeDPrinter.getMaterial());
//		반드시 형변환 시켜서 넣어야 한다.
		plastic = (Plastic) threeDPrinter.getMaterial();
		System.out.println("=======================================");
		
		GenericPrinter<Powder> genericPrinter = new GenericPrinter<Powder>();
		genericPrinter.setMaterial(powder);
		System.out.println(genericPrinter.getMaterial());
		powder = genericPrinter.getMaterial();
		System.out.println("=======================================");
		
		GenericPrinter<Plastic> genericPrinter2 = new GenericPrinter<Plastic>();
		genericPrinter2.setMaterial(plastic);
		System.out.println(genericPrinter2.getMaterial());
		plastic = genericPrinter2.getMaterial();
		System.out.println("=======================================");
		
		Water water = new Water();
		
		threeDPrinter.setMaterial(water);
		System.out.println(threeDPrinter.getMaterial());
		water = (Water) threeDPrinter.getMaterial();
		System.out.println("=======================================");
		
		GenericPrinter<Water> genericPrinter3 = new GenericPrinter<Water>();
		genericPrinter3.setMaterial(water);
		System.out.println(genericPrinter3.getMaterial());
		water = genericPrinter3.getMaterial();
		
	}
	
}









