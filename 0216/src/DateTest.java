import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
//		현재 컴퓨터 시스템의 날짜와 시간을 얻어온다.
		Date date = new Date();
		System.out.println(date);
		
//		날짜, 시간 서식 지정하기
//		SimpleDateFormat sdf = new SimpleDateFormat("날짜 서식");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분 ss초");
		System.out.println(sdf.format(date));
		SimpleDateFormat sdf2 = new SimpleDateFormat("yy.MM.dd(E) a h:mm:ss.SSS");
		System.out.println(sdf2.format(date));
		
//		Date 클래스는 1900년을 기준으로 날짜를 처리하므로 년도는 1900을 더해서 얻어와야 한다.
		System.out.println("년: " + (date.getYear() + 1900)); // 년
//		Date 클래스는 0 ~ 11월로 월을 처리하므로 월은 1을 더해서 얻어와야 한다.
		System.out.println("월: " + (date.getMonth() + 1)); // 월
		System.out.println("일: " + date.getDate()); // 일
		System.out.println("시: " + date.getHours()); // 시
		System.out.println("분: " + date.getMinutes()); // 분
		System.out.println("초: " + date.getSeconds()); // 초
		System.out.println("요일: " + date.getDay()); // 요일(숫자)
		
//		======================================================================================
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		
//		getTime() 메소드는 Calendar 클래스의 객체를 출력했을 때 time=1644996922540 형태로 출력되는
//		정보를 얻어온다. => 13자리의 숫자 => 1970년 1월 1일 자정부터 Calendar 클래스 객체가 생성되는
//		순간까지 지난 시간을 1/1000초 단위로 표시한다.
		System.out.println(calendar.getTime());
//		Calendar 클래스 객체를 이용해서 출력할 날짜에 서식을 지정하려면 Calendar 클래스 객체에서
//		getTime() 메소드를 실행해서 날짜, 시간 정보만 얻어온 후 서식을 지정해야 한다.
//		System.out.println(sdf2.format(calendar)); // 에러
		System.out.println(sdf2.format(calendar.getTime()));
		
		System.out.println("년: " + calendar.get(Calendar.YEAR));
		System.out.println("월: " + (calendar.get(Calendar.MONTH) + 1));
		System.out.println("일: " + calendar.get(Calendar.DATE));
		System.out.println("시: " + calendar.get(Calendar.HOUR)); // 12시각
		System.out.println("시: " + calendar.get(Calendar.HOUR_OF_DAY)); // 24시각
		System.out.println("분: " + calendar.get(Calendar.MINUTE));
		System.out.println("초: " + calendar.get(Calendar.SECOND));
		System.out.println("밀리초: " + calendar.get(Calendar.MILLISECOND));
		System.out.println("요일: " + calendar.get(Calendar.DAY_OF_WEEK)); // 일(1), 월(2), ..., 토(7)
		
//		currentTimeMillis(): 1970년 1월 1일 자정부터 currentTimeMillis() 메소드가 실행되는 순간까지 
//		지난 시간을 1/1000초 단위로 표시한다.
		System.out.println(System.currentTimeMillis());
//		currentTimeMillis() 메소드의 실행 결과는 13자리의 정수이므로 int 타입의 변수에는 저장시킬 수 없고
//		long 타입의 변수에 저장해서 사용해야 한다.
//		int time = System.currentTimeMillis(); // 에러
		long start = System.currentTimeMillis();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("실행시간: " + (end - start) / 1000. + "초");
		SimpleDateFormat sdf3 = new SimpleDateFormat("실행시간: HH:mm:ss.SSS초");
//		currentTimeMillis() 메소드를 이용해서 얻어온 시간 데이터를 연산할 경우 일반적인 사칙연산을
//		실행할 경우 문제가 발생되지 않지만 연산 결과를 SimpleDateFormat 클래스 객체를 사용해 서식을
//		지정하면 offset 값이 포함된 시간으로 서식이 적용된다. => 연산 결과에서 offset 값을 빼면된다.
		System.out.println(sdf3.format(end - start - 32400000));
		
	}
	
}




