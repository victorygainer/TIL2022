package kr.tjoeun.networkTest1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Socket socket = null; // 통신 소켓
		Scanner scanner = null; // 서버에서 전송되는 데이터를 읽는 Scanner
		PrintWriter printWriter = null; // 서버로 데이터를 전송하는 PrinterWriter

		try {
//			서버에 접속한다.
			System.out.println("192.168.0.71 서버의 10004번 포트로 접속시도");
//			new Socket(host, port): host => 서버의 ip 주소, port => 서버의 포트 번호
			socket = new Socket("192.168.0.71", 10004);
			System.out.println("서버에 접속 성공: " +socket);
			
//			서버에서 전송되는 데이터를 수신하기 위해 수신용 객체를 선언한다.
			scanner = new Scanner(socket.getInputStream());
//			서버에서 전송된 데이터를 읽어 출력한다.
			System.out.println(scanner.nextLine());
			
//			클라이언트에서 서버로 데이터를 전송하기 위해 전송용 객체를 생성한다.
			printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("어련히 알아서 올까봐~~~~~ 기다리고 그러셔~~~~~\n");
			printWriter.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			통신이 종료되면 통신에 사용한 Socket 객체를 닫는다.
			if (socket != null) { try { socket.close(); } catch (IOException e) { e.printStackTrace(); } }
		}
		
		
	}
	
}
