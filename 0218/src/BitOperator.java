
public class BitOperator {

	public static void main(String[] args) {
		
//		자세한 설명은 2022-02-18 2교시 동영상과 엑셀 파일을 참조
		int a = 10, b = 12;
		
		System.out.println(a & b); // 00001010 & 00001100 => 00001000 => 8
		System.out.println(a | b); // 00001010 & 00001100 => 00001110 => 14
		System.out.println(a ^ b); // 00001010 & 00001100 => 00000110 => 6
//		~00001010 => 11110101 => 부호 비트가 1이므로 음수이고 다시 2의 보수로 변환하면 => 00001011 => -11
		System.out.println(~a);
		
	}
	
}
