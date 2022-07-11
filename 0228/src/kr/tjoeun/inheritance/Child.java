package kr.tjoeun.inheritance;

//	자식(하위, 서브, 파생) 클래스
//	Child 클래스는 Parent 클래스를 상속받아 만든다.
//	상속이란 부모 클래스에서 정의한 모든 필드와 메소드를 자식 클래스가 물려받는 것을 말한다.
//	자식 클래스에서 별도의 선언없이 부모 클래스의 모든 기능을 사용할 수 있다.
//	public class 자식클래스이름 extends 부모클래스이름
public class Child extends Parent {

//	Child 클래스에는 Parent 클래스의 모든 필드와 메소드를 사용할 수 있다.
//	Child 클래스에서 필요한 기능을 정의한다.
	
	private int age;
	private String nickname;
	
	public Child() {
//		this는 현재 클래스를 의미하고 뒤에 ()가 나오면 현재 클래스의 생성자를 의미한다.
//		super는 부모 클래스를 의미하고 뒤에 ()가 나오면 부모 클래스의 생성자를 의미한다.
//		super()는 코딩하지 않아도 자바 컴파일러가 자동으로 만들어준다.
//		this()와 super()는 반드시 생성자의 첫 문장으로 써야한다. => 가장 먼저 실행된다.
//		부모 클래스의 기본 생성자를 정의하지 않으면 자식 클래스에서 super()가 실행될 때
//		에러가 발생된다.
//		부모 클래스의 생성자가 자식 클래스의 생성자 보다 먼저 실행된다.
//		super(); // 부모 클래스의 기본 생성자를 호출한다.
		System.out.println("자식 클래스의 기본 생성자가 실행됩니다.");
	}

//	이클립스가 지원하는 생성자 자동 완성 기능을 사용할 때 현재 클래스에 물리적으로 정의하지
//	않은 필드(상속받은 필드)는 생성자를 만드는 대화상자에 표시되지 않는다.
//	부모 클래스에서 상속받은 멤버를 초기화하기 위한 데이터를 받는 변수를 직접 코딩해야 한다.
	
//	부모 클래스에서 상속받은 private 권한의 필드를 초기화하는 1번째 방법
//	부모 클래스에서 상속받은 필드의 접근 권한이 private일 경우 자식 클래스에서도 접근할 수
//	없으므로 부모 클래스의 생성자를 호출해서 초기화시킨다.
	/*
	public Child(String name, boolean gender, int age, String nickname) {
//		this.name = name; // 에러, 부모 클래스에서 private으로 설정된 필드는 접근할 수 없다.
		super(name, gender); // Parent(String name, boolean gender)가 실행된다.
		this.age = age;
		this.nickname = nickname;
	}
	*/
	
//	부모 클래스에서 상속받은 private 권한의 필드를 초기화하는 2번째 방법
//	부모 클래스에서 상속받은 필드의 접근 권한이 private일 경우 자식 클래스에서도 접근할 수
//	없으므로 부모 클래스에서 상속받은 setters 메소드를 호출해서 초기화시킨다.
	/*
	public Child(String name, boolean gender, int age, String nickname) {
		setName(name); // 부모 클래스에서 상속받은 setter 메소드를 실행한다.
		setGender(gender); // 부모 클래스에서 상속받은 setter 메소드를 실행한다.
		this.age = age;
		this.nickname = nickname;
	}
	*/
	
//	부모 클래스에서 상속받은 protected 권한의 필드를 초기화하는 방법
//	부모 클래스에서 상속받은 필드의 접근 권한이 protected일 경우 자식 클래스에서도 접근할 수
//	있으므로 this를 사용하는 초기화가 가능하다.
	public Child(String name, boolean gender, int age, String nickname) {
		this.name = name; // protected 권한을 가지는 멤버는 자식 클래스에서 접근할 수 있다.
		this.gender = gender; // protected 권한을 가지는 멤버는 자식 클래스에서 접근할 수 있다.
		this.age = age;
		this.nickname = nickname;
	}
	
//	성춘향(여) - 16, 이쁜이
//	Override(재정의): 부모 클래스로 부터 상속받은 메소드의 기능을 무시하고 다시 만들어 사용한다.
	@Override
	public String toString() {
//		부모 클래스에서 상속받은 private 권한을 가지는 필드는 자식에서도 접근할 수 없으므로 
//		부모 클래스에 상속받은 private 권한을 가지는 필드에 저장된 데이터는 getters 메소드를
//		사용해서 데이터를 얻어와야 한다.
//		리턴 타입이 boolean인 메소드는 "is"로 메소드 이름을 시작하는게 관행이다.
//		return getName() + "(" + (isGender() ? "남" : "여") + ") - " + age + ", " + nickname;
		
//		자식 클래스에서 부모 클래스에서 상속받은 메소드에 기능을 추가할 수 있다.
//		부모 클래스에서 상속받은 메소드를 실행할 수 있다.
//		부모 클래스에서 상속받은 메소드를 실행하려면 부모 클래스를 의미하는 super 뒤에 "."을 찍고
//		실행할 부모 클래스의 메소드 이름을 쓰면 된다.
//		super.toString(): 부모 클래스에서 상속받은 toString() 메소드를 실행한다.
//		return super.toString() + " - " + age + ", " + nickname; // 기능 추가
		
//		부모 클래스에서 상속받은 필드의 접근 권한이 protected일 경우 자식 클래스에서 접근할 수
//		있으므로 getters 메소드를 사용하지 않아도 필드의 내용을 얻어올 수 있다.
		return name + "(" + (gender ? "남" : "여") + ") - " + age + ", " + nickname;
	}
	
}













