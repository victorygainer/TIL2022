import java.util.Random;
import java.util.Scanner;

public class MukJiiBba {

	public static void main(String[] args) {
		
//		가위(1), 바위(2), 보(3)
		Random random = new Random();
		int cpu = random.nextInt(3) + 1;
		System.out.println("cpu: " + cpu);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(1), 바위(2), 보(3)? ");
		int user = scanner.nextInt();
		
//		이기는 경우: cpu == 1 이고 user == 2 또는 cpu == 2 이고 user == 3 또는 cpu == 3 이고 user == 1
//		지는 경우: cpu == 1 이고 user == 3 또는 cpu == 2 이고 user == 1 또는 cpu == 3 이고 user == 2
//		비기는 경우: 이기는 경우와 지는 경우를 제외한 나머지, cpu == user
		
		if (cpu == 1 && user == 2 || cpu == 2 && user == 3 || cpu == 3 && user == 1) {
			System.out.println("이겼다.");
		} else if (cpu == 1 && user == 3 || cpu == 2 && user == 1 || cpu == 3 && user == 2) {
			System.out.println("졌다.");
		} else {
			System.out.println("비겼다.");
		}
		
		if (cpu == user) {
			System.out.println("비겼다.");
		} else if (cpu == 1 && user == 3 || cpu == 2 && user == 1 || cpu == 3 && user == 2) {
			System.out.println("졌다.");
		} else {
			System.out.println("이겼다.");
		}
		
	}
	
}




