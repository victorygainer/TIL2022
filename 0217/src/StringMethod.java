import java.util.Scanner;

public class StringMethod {

	public static void main(String[] args) {
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("문자열 입력: ");
//		String str = scanner.nextLine();
//		입력 단계에서 불필요한 공백을 제거하고 입력받으려면 아래와 같이 trim() 메소드를 사용한다.
//		String str = scanner.nextLine().trim();
//		키보드로 1문자만 입력받으려면 아래와 같이 charAt() 메소드를 사용한다.
//		char ch = scanner.nextLine().charAt(0);
		
		String str = "    tjoeunit    ";
//		length(): 문자열을 구성하는 문자의 개수를 얻어온다.
		System.out.println("입력한 문자 개수: " + str.length());
		
		str = "    tjoeunit    ";
//		trim(): 문자열 앞, 뒤의 불필요한 빈칸(공백)을 제거한다.
		System.out.println("불필요한 빈칸을 제거한 문자 개수: " + str.trim().length());
		
		str = "tjoeunit";
//		charAt(index): 문자열에서 지정된 index 번째 위치의 문자를 얻어온다. => index는 0부터 시작한다.
		System.out.println("6번째 문자: " + str.charAt(5));
		
		str = "TjoeunIT";
//		toUpperCase() 메소드는 영문자를 무조건 대문자로 변환하고 toLowerCase() 메소드는 영문자를 무조건
//		소문자로 변환한다.
		System.out.println("무조건 대문자로 변환: " + str.toUpperCase());
		System.out.println("무조건 소문자로 변환: " + str.toLowerCase());
		
		str = "8304221185600";
//		substring(a) 메소드는 문자열의 a번째 index의 문자부터 문자열의 끝까지 얻어온다.
//		substring(a, b) 메소드는 문자열의 a번째 index의 문자부터 b - 1 번째 index의 문자까지 얻어온다.
		System.out.println("주민등록번호 뒷자리: " + str.substring(6));
		System.out.println("생년: " + str.substring(0, 2));
		System.out.println("월: " + str.substring(2, 4));
		System.out.println("일: " + str.substring(4, 6));
		
		str = "itTjoeunit";
//		indexOf() 메소드는 문자열의 왼쪽부터 검색해서 인수로 지정된 문자열이 최초로 나타나는 index를 얻어온다.
//		LastIndexOf() 메소드는 문자열의 오른쪽부터 검색해서 인수로 지정된 문자열이 최초로 나타나는 index를
//		얻어온다.
		System.out.println(str.indexOf("it"));
		System.out.println(str.lastIndexOf("it"));
//		indexOf(), LastIndexOf() 메소드는 인수로 지정한 문자열이 없으면 -1을 리턴한다.
		System.out.println(str.indexOf("IT"));
		System.out.println(str.lastIndexOf("IT"));
//		indexOf(), LastIndexOf() 메소드의 실행 결과가 0이상이면 인수로 지정된 문자열이 포함되어있다는
//		의미로 사용할 수 있다.

		str = "123-4501-12345";
//		System.out.println(str.substring(4, 6));
		System.out.println("앞쪽 '-' 위치: " + str.indexOf("-"));
		System.out.println("뒤쪽 '-' 위치: " + str.lastIndexOf("-"));
		System.out.println(str.substring(str.indexOf("-") + 1, str.lastIndexOf("-")));
		
		str = "itTjoeunit";
//		contains() 메소드는 문자열에 인수로 지정된 문자열이 포함되어있으면 true, 없으면 false를 리턴한다.
		System.out.println(str.contains("it"));
		System.out.println(str.contains("IT"));
		
		str = "abc 123 가나다";
//		split("구분자") 메소드는 구분자를 경계로 문자열을 나눈다.
		for (String s : str.split(" ")) {
			System.out.println(s);
		}
		
	}
	
}





