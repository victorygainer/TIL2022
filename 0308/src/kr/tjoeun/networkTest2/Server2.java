package kr.tjoeun.networkTest2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		PrintWriter printWriter = null;
		Scanner scanner = null; // 클라이언트에서 전송되는 메시지를 읽는 스캐너
		Scanner scan = null; // 키보드로 클라이언트로 전송할 데이터를 입력받는 스캐너
		
		try {
			server = new ServerSocket(10004);
			System.out.println("서버 시작: " + server);
			System.out.println("클라이언트의 접속을 기다립니다.");
			socket = server.accept();
			
//			송수신에 사용할 객체들을 선언한다.
			printWriter = new PrintWriter(socket.getOutputStream());
			scanner = new Scanner(socket.getInputStream());
			scan = new Scanner(System.in);
			
//			클라이언트에게 접속 메시지를 전송한다.
			printWriter.write("어서와 클라이언트\n");
			printWriter.flush();
			
//			키보드로 입력한 메시지 또는 클라이언트에서 전송받은 메시지가 "BYE"면 통신을 끝낸다.
			String msg = "";
			do {
//				클라이언트에서 전송받은 메시지를 출력한다.
				msg = scanner.nextLine().trim();
				System.out.println("client >>> " + msg);
//				클라이언트에서 전송받은 메시지가 "BYE"면 통신을 끝낸다. => do ~ while 반복을 탈출한다.
				if (msg.toUpperCase().equals("BYE")) {
					break;
				}
//				=============================================================================
//				클라이언트로 전송할 메시지를 입력받는다.
				System.out.print("server >>> ");
				msg = scan.nextLine().trim();
//				키보드로 입력받은 메시지를 클라이언트로 전송한다. 
				printWriter.write(msg + "\n");
				printWriter.flush();
			} while(!msg.toUpperCase().equals("BYE"));
			System.out.println("클라이언트와의 채팅을 종료합니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) { try { server.close(); } catch (IOException e) { e.printStackTrace(); } }
			if (socket != null) { try { socket.close(); } catch (IOException e) { e.printStackTrace(); } }
		}
		
	}
	
}







