package kr.tjoeun.inheritance;

import java.util.Calendar;

//	자바는 일반적으로 파일 하나에 1개의 클래스를 만들어 사용하지만 필요에 따라서 하나의 파일에 여러개의
//	클래스를 만들어 사용할 수 있다.
//	하나의 파일에 여러개의 클래스를 만들어도 컴파일된 *.class 파일은 bin 폴더에 각각 독립적으로 생성된다.
//	현재 java 파일의 이름과 같은 이름의 클래스에만 public을 붙일 수 있다.

//	기본 생성자가 실행되면 현재 날짜로 필드를 초기화하고 년, 월, 일을 넘겨받는 생성자가 실행되면
//	넘겨받은 년, 월, 일로 필드를 초기화시키는 클래스를 만든다.
class Date { // 날짜 클래스
	
	private int year;
	private int month;
	private int day;
	
	public Date() {
		java.util.Date date = new java.util.Date();
		year = date.getYear() + 1900;
		month = date.getMonth() + 1;
		day = date.getDate();
	}
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	@Override
	public String toString() {
		return String.format("%04d년 %02d월 %02d일", year, month, day);
	}
	
}

//	기본 생성자가 실행되면 현재 시간으로 필드를 초기화하고 시, 분, 초를 넘겨받는 생성자가 실행되면
//	넘겨받은 시, 분, 초로 필드를 초기화시키는 클래스를 만든다.
class Time { // 시간 클래스
	
	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		minute = calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND);
	}
	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
}

//	자바는 다중 상속을 허용하지 않기 때문에 아래와 같이 코딩하면 에러가 발생한다.
//	class Now extends Date, Time { } // 에러
//	다중 상속의 효과를 내기 위해서 클래스 포함 또는 인터페이스를 사용한다.

class Now {
	
//	클래스 포함이란 클래스의 멤버로 다른 클래스 객체를 선언해 사용하는 것을 말한다.
	private Date date;
	private Time time;
	
//	기본 생성자가 실행되면 현재 날짜와 시간으로 초기화시킨다.
	public Now() {
		date = new Date();
		time = new Time();
	}

//	날짜와 시간 데이터를 넘겨받아 초기화시키는 생성자
	public Now(Date date, Time time) {
		this.date = date;
		this.time = time;
	}
	
//	년, 월, 일, 시, 분, 초를 넘겨받아 초기화시키는 생성자
	public Now(int year, int month, int day, int hour, int minute, int second) {
		date = new Date(year, month, day);
		time = new Time(hour, minute, second);
	}
	
	@Override
	public String toString() {
		return "Now [date=" + date + ", time=" + time + "]";
	}



	
}

public class ClassIncludeTest {

	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		Date date2 = new Date(2022, 7, 14);
		System.out.println(date2);
		
		Time time = new Time();
		System.out.println(time);
		Time time2 = new Time(18, 20, 1);
		System.out.println(time2);
		
		Now now = new Now();
		System.out.println(now);
		Now now2 = new Now(date2, time2);
		System.out.println(now2);
		Now now3 = new Now(2022, 3, 9, 6, 30, 0);
		System.out.println(now3);
		
	}
	
}













