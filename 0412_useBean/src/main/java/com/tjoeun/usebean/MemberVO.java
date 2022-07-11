package com.tjoeun.usebean;

//	VO(Value Object) 클래스 => 데이터 1건을 기억하는 클래스, 데이터를 저장해서 전송한다 해서 
//	DTO(Data Transfer Object)라 부르기도 한다.
//	bean => 자바로 처리하는 최소한의 작업 단위로 데이터를 기억하는 필드(멤버 변수)와 필드에 저장된 
//	데이터를 입출력하는 getters & setters 메소드로만 구성된 클래스
public class MemberVO {

//	VO 클래스의 필드 이름은 VO 클래스에 저장될 데이터가 입력되는 form을 구성하는 요소들의 
//	name 속성으로 지정한 속성값과 반드시 같은 이름으로 만들어야 한다.
//	VO 클래스의 필드 이름은 데이터베이스의 테이블을 구성하는 필드 이름과 반드시 같은 이름으로
//	만들어야 한다.
	
	private String id;
	private String name;
	private String password;
	private int age;
	private boolean gender;
	private String ip;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", gender="
				+ gender + ", ip=" + ip + "]";
	}
	
}
