
public class ForTest {

	public static void main(String[] args) {
		
//		for는 {} 블록을 조건이 만족하는 동안 반복해서 실행한다.
//		반복 횟수가 알려져 있는 경우 주로 사용한다.
//		for (자료형 변수명 = 초기치; 조건식; 증감치) {
//			조건이 참인 동안 반복할 문장;
//			...;
//		}
		
		int sum = 0;
//		i를 0으로 초기화하고 조건을 비교해 만족할 경우 반복이 시작된다.
//		조건을 만족하면 {} 블록의 내용을 실행하고 i를 증감치 만큼 변경한 후 조건을 만족하면 {} 블록을
//		실행하고 조건을 만족하지 않으면 반복을 종료한다.
		for (int i=0; i<=10; i++) {
			sum += i;	// sum = sum + i;와 같은 기능이 실행된다.
		}
		System.out.println("1 ~ 100의 합계 = " + sum);
		
//		증감 연산자: ++(1증가), --(1감소) => 단항 연산자
//		a++: 사용 후 1증가, a 변수에 저장된 값을 사용(연산)하고 ";"을 만나 문장이 종료될 때 1증가 한다.
//		++a: 1증가 후 사용, a 변수에 저장된 값을 1증가시키고 사용한다.
//		a--: 사용 후 1감소, a 변수에 저장된 값을 사용(연산)하고 ";"을 만나 문장이 종료될 때 1감소 한다.
//		--a: 1감소 후 사용, a 변수에 저장된 값을 1감소시키고 사용한다.
		
		int a = 1, b, c;
		b = a++;
		c = ++a;
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
		
		int d = 1, e, f;
		e = d++ + d++ + d++ + d++;
		f = ++d + ++d + ++d + ++d;
		System.out.println("d = " + d + ", e = " + e + ", f = " + f);
		
	}
	
}











