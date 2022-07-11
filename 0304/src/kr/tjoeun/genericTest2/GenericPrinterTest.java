package kr.tjoeun.genericTest2;

public class GenericPrinterTest {

	public static void main(String[] args) {
		
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();
		powderPrinter.setMaterial(new Powder());
		System.out.println(powderPrinter.getMaterial());
		powderPrinter.getMaterial().doPrinting();
		Powder powder = powderPrinter.getMaterial();
		System.out.println("=============================================");
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
		plasticPrinter.setMaterial(new Plastic());
		System.out.println(plasticPrinter.getMaterial());
		plasticPrinter.getMaterial().doPrinting();
		Plastic plastic = plasticPrinter.getMaterial();
		System.out.println("=============================================");
		
//		Water 클래스는 Material 클래스를 상속받지 않았으므로 GenericPrinter 클래스의
//		제네릭으로 넘길 수 없다.
//		GenericPrinter<Water> waterPrinter = new GenericPrinter<Water>();
		
	}
	
}
