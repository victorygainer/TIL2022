import java.util.Date;
import java.util.Scanner;

public class CalendarTest2 {

	public static void main(String[] args) {
		
//		달력 작업에 사용할 메소드가 정의된 클래스의 객체를 만든다.
//		MyCalendar myCalendar = new MyCalendar();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("이번달(1), 특정달(2): ");
		int confirm = scanner.nextInt();
		
		int year, month;
		if (confirm == 1) {
			Date date = new Date();
			year = date.getYear() + 1900;
			month = date.getMonth() + 1;
		} else {
			System.out.print("달력을 출력할 년, 월을 입력하세요: ");
			year = scanner.nextInt();
			month = scanner.nextInt();
		}
		
		System.out.println("=============================");
		System.out.printf("         %4d년%2d월\n", year, month);
		System.out.println("=============================");
		System.out.println(" 일  월  화  수  목  금  토 ");
		System.out.println("=============================");
		
		int week = MyCalendar.weekDay(year, month, 1);
		int start = 0;
		if (month == 1) {
			start = 31 - week;
		} else {
			start = MyCalendar.lastDay(year, month - 1) - week;
		}
		for (int i=1; i<=week; i++) {
			System.out.printf(" %2d ", ++start);
		}
		
		for (int i=1; i<=MyCalendar.lastDay(year, month); i++) {
			System.out.printf(" %2d ", i);
			if (MyCalendar.weekDay(year, month, i) == 6 && i != MyCalendar.lastDay(year, month)) {
				System.out.println();
			}
		}
		
		if (month == 12) {
			week = MyCalendar.weekDay(year + 1, 1, 1);
		} else {
			week = MyCalendar.weekDay(year, month + 1, 1);
		}
		if (week != 0) {
			start = 0;
			for (int i=week; i<=6; i++) {
				System.out.printf(" %2d ", ++start);
			}
		}
		System.out.println("\n=============================");
		
	}
	
}






