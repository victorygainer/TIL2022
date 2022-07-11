package kr.tjoeun.abstractClass;

import java.util.ArrayList;

//	다형성(polymorphism)이란 하나의 메소드가 서로 다른 클래스에서 다양하게 실해되는 것을 말한다.
//	다형성을 구현하기 위해서는 다형성을 구현할 메소드가 포함된 모든 클래스가 같은 부모 클래스 또는 
//	인터페이스를 가져야 한다.
//	부모 클래스 또는 인터페이스와 자식 클래스에 같은 이름의 메소드가 있어야 하고 자식 클래스는
//	이 메소드를 반드시 Override 시켜서 사용해야 한다.
//	부모 클래스 타입의 객체에 자식 클래스 타입의 객체를 대입시켜 다형성이 구현된 메소드를 실행한다.

abstract class Animal {
//	public void move() {
//		System.out.println("동물이 움직입니다.");
//	}
//	부모 클래스의 메소드를 상속받아 Override를 하면 어차피 무시되므로 {} 블록을 코딩하지 않는다.
	public abstract void move(); // 추상 메소드 => 자식 클래스에서 반드시 Override를 해야한다.
	public void eating() { // 일반 메소드
		
	}
}

//	Human 클래스는 Animal 클래스를 상속받아 만든다.
class Human extends Animal {
	@Override
	public void move() {
		System.out.println("사람이 두 발로 걷습니다.");
	}
	public void readBooks() {
		System.out.println("사람이 책을 읽습니다.");
	}
}

//	Tiger 클래스는 Animal 클래스를 상속받아 만든다.
class Tiger extends Animal {
	@Override
	public void move() {
		System.out.println("호랭이는 네 발로 걷습니다.");
	}
	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
}

//	Eagle 클래스는 Animal 클래스를 상속받아 만든다.
class Eagle extends Animal {
	@Override
	public void move() {
		System.out.println("독수리는 하늘을 날아갑니다.");
	}
	public void flying() {
		System.out.println("독수리가 날개를 쫘~~~~ㄱ 펴고 멀리 날아갑니다.");
	}
}

public class InstanceofTest {

	public static void main(String[] args) {
		
//		저번 시간에는 이런식으로 실행...
//		Animal[] animals = {new Human(), new Tiger(), new Eagle()};
//		animals[0].move();
//		animals[1].move();
//		animals[2].move();
		
		Animal hAnimal = new Human(); // upcasting, 자식 => 부모
		Animal tAnimal = new Tiger(); // upcasting
		Animal eAnimal = new Eagle(); // upcasting
		
//		main()이라는 static 메소드에서 moveAnimal() 메소드를 실행하기 때문에 
//		moveAnimal() 메소드는 반드시 static으로 선언된 메소드이어야 한다.
//		public static void moveAnimal(Animal animal)
//		moveAnimal(hAnimal);
//		moveAnimal(tAnimal);
//		moveAnimal(eAnimal);
		
//		현재 클래스 자신의 객체를 생성해서 moveAnimal() 메소드를 실행하게 되면
//		static 메소드로 만들지 않고도 실행할 수 있다.
		InstanceofTest test = new InstanceofTest(); // 현재 클래스 자신의 객체
		test.moveAnimal(hAnimal);
		test.moveAnimal(tAnimal);
		test.moveAnimal(eAnimal);
		System.out.println("=============================");
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(hAnimal);
		animals.add(tAnimal);
		animals.add(eAnimal);
		
		for (Animal animal : animals) {
			animal.move();
		}
		System.out.println("=============================");
		
		for (int i=0; i<animals.size(); i++) {
			Animal animal = animals.get(i);
//			downcasting: upcasting된 클래스를 다시 원래의 타입으로 형변환 시킨다.
//			instanceof 연산자를 사용해서 형변환이 가능한지 확인한 후 downcasting을 실행한다.
			if (animal instanceof Human) {
				Human human = (Human) animal; // downcasting, 부모에 저장된 자식 => 자식
				human.readBooks();
			} else if (animal instanceof Tiger) {
				Tiger tiger = (Tiger) animal; // downcasting
				tiger.hunting();
			} else if (animal instanceof Eagle) {
				Eagle eagle = (Eagle) animal; // downcasting
				eagle.flying();
			} else {
				System.out.println("downcasting 불가능");
			}
		}
		
	}
	
	public void moveAnimal(Animal animal) {
		animal.move();
	}
	
}






