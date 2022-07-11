import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		
//		배열: 같은 이름으로 여러개의 기억장소를 만든다. 기억장소 구분은 인덱스를 이용한다.
//		자료형[] 배열명 = new 자료형[첨자]; // 첨자로 지정한 크기만큼 배열을 만든다. 
//		자료형 배열명[] = new 자료형[첨자];
		
//		배열을 선언만 하면 기본 초기화가 실행된다.
//		숫자는 0, 문자는 공백, boolean은 false, 기본 자료형을 제외한 나머지(클래스로 만든 객체)는 null
//		String[] data = new String[5];
//		System.out.println(Arrays.toString(data));
		
//		자료형[] 배열명 = {초기치}; // 초기치로 지정된 데이터의 개수만큼 배열을 선언하고 초기화 시킨다. 
//		자료형 배열명[] = {초기치};
		String[] data = {"홍길동", "임꺽정", "장길산", "일지매", "손오공", "저팔계"};
//		System.out.println(Arrays.toString(data));
		
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		System.out.println(data[3]);
		System.out.println(data[4]);
		System.out.println("==================");
		
		for (int i=0; i<5; i++) {
			System.out.println(data[i]);
		}
		System.out.println("==================");
		
//		배열명.length: 배열의 크기를 얻어온다.
		System.out.println("배열의 크기: " + data.length);
		for (int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
		System.out.println("==================");
		
//		향상된 for: 배열 전체를 대상으로 작업할 경우 사용하면 편리하다.
//		for (배열의자료형 변수명 : 배열명) {
//			반복할 문장;
//			...
//		}
		
//		data 배열의 0번째 인덱스에 저장된 데이터가 str에 저장된 후 반복을 시작하고 data 배열의 마지막 인덱스에
//		저장된 데이터를 str 변수에 저장한 후 처리하고 반복이 종료된다.
		for (String str : data) {
			System.out.println(str);
		}
		
		
	}
	
}










