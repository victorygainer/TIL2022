package kr.tjoeun.textFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileReadTest2 {

	public static void main(String[] args) {
		
		Scanner scanner = null;
		String filePath = "./src/kr/tjoeun/textFileIO/input.txt";
		
		try {
			scanner = new Scanner(new File(filePath));
			while (scanner.hasNextLine()) {
				
				String str = scanner.nextLine().trim();
				System.out.println(str);
				
//				읽어들인 데이터를 공백을 경계로 분리해서 변수에 저장한다.
				int i = 0;
				boolean b = false;
				double d = 0;
				String s = "";
				
//				String 변수에 저장된 문자열을 읽어들이는 스캐너
//				Scanner 스캐너의 객체를 만들 때 생성자로 String 변수를 넘기면 String 변수에
//				저장된 데이터를 읽어들인다.
				Scanner scan = new Scanner(str);
//				hasNext() 메소드는 스캐너에 지정된 String 변수에 저장된 공백으로 구분되는
//				읽어들일 데이터가 있으면 true, 없으면 false를 리턴한다.
				while (scan.hasNext()) {
					if (scan.hasNextInt()) { // 스캐너로 읽을 데이터가 int면 true, 아니면 false
						i = scan.nextInt();
					} else if (scan.hasNextBoolean()) { // 스캐너로 읽을 데이터가 boolean이면 true, 아니면 false
						b = scan.nextBoolean();
					} else if (scan.hasNextDouble()) { // 스캐너로 읽을 데이터가 double이면 true, 아니면 false
						d = scan.nextDouble();
					} else {
						s = scan.next();
					}
				}
				
				System.out.println("i: " + i);
				System.out.println("b: " + b);
				System.out.println("d: " + d);
				System.out.println("s: " + s);
			}
			System.out.println("텍스트 파일에서 읽기완료!!!");			
		} catch (FileNotFoundException e) {
			System.out.println("디스크에 파일이 존재하지 않습니다.");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		
	}
	
}






