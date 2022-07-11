package kr.tjoeun.memoListDB;

import java.util.ArrayList;
import java.util.Scanner;

//	데이터를 테이블에 저장하기 전에 필요한 전처리 작업을 실행한다.
public class MemoService {

//	키보드로 테이블에 저장할 데이터를 입력받아 DAO 클래스로 넘겨주는 메소드
	public static void insert() {
		
//		전처리
//		키보드로 이름, 비밀번호, 메모를 입력받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름: ");
		String name = scanner.nextLine().trim();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine().trim();
		System.out.print("메모: ");
		String memo = scanner.nextLine().trim();

//		키보드로 입력받은 데이터를 MemoVO 클래스 객체를 만들어 저장한다.
		MemoVO vo = new MemoVO();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMemo(memo);
		
//		데이터베이스 사용
//		키보드로 입력받은 데이터를 저장하는 DAO 클래스의 메소드를 호출한다.
		boolean result = MemoDAO.insert(vo);
		
//		후처리
		if (result) {
			System.out.println(name + "님 글 저장완료!!");
		} else {
			System.out.println("저장실패!!");
		}
		
	}

//	테이블에 저장된 글 목록을 글번호(idx)의 내림차순(최신글 순)으로 얻어오는 메소드
	public static void select() {
		
		ArrayList<MemoVO> list = MemoDAO.select();
		
//		데이터베이스 테이블에서 얻어온 글 목록을 출력한다.
//		조건이 2개 이상이고 null과 비교하는 조건이 있을 경우 반드시 null을 먼저 비교한다.
		if (list == null || list.size() == 0) {
			System.out.println("테이블이 없거나 저장된 데이터가 없습니다.");
		} else {
			for (MemoVO vo : list) {
				System.out.println(vo);
			}
		}
		
	}

//	삭제할 글번호를 입력받고 비밀번호를 확인한 다음 글을 삭제하는 메소드
	public static void delete() {
		
//		키보드로 삭제할 글의 글번호를 입력받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 글번호를 입력하세요: ");
		int idx = scanner.nextInt();
		
//		데이터베이스 테이블에서 삭제할 글을 얻어오는 메소드를 실행한다.
		MemoVO original = MemoDAO.selectByIdx(idx);
		
		try {
			System.out.println("삭제할 글 확인하기");
			System.out.println(original);
			
//			삭제할 글을 얻어왔으므로 삭제하기 위한 비밀번호를 입력한다.
			System.out.print("삭제할 글의 비밀번호를 입력하세요: ");
			scanner.nextLine(); // 키보드 버퍼를 비운다.
			String password = scanner.nextLine().trim();
			
//			삭제할 글의 비밀번호(original.getPassword())와 삭제하기 위해 입력한 
//			비밀번호(password)를 비교한다.
			if (original.getPassword().trim().equals(password)) {
				
//				비밀번호가 일치하면 글을 삭제하는 메소드를 실행한다.
				MemoDAO.delete(idx);
				System.out.println(idx + "번 글 삭제완료!!");
				
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
			
		} catch (NullPointerException e) {
			System.out.println(idx + "번 글이 존재하지 않습니다.");
		}
		
	}

//	수정할 글번호를 입력받고 비밀번호를 확인한 다음 글을 수정하는 메소드
	public static void update() {
		
//		키보드로 수정할 글의 글번호를 입력받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 글번호를 입력하세요: ");
		int idx = scanner.nextInt();

//		데이터베이스 테이블에서 수정할 글을 얻어오는 메소드를 실행한다.
		MemoVO original = MemoDAO.selectByIdx(idx);

		try {
			System.out.println("수정할 글 확인하기");
			System.out.println(original);
			
//			수정할 글을 얻어왔으므로 수정하기 위한 비밀번호를 입력한다.
			System.out.print("수정할 글의 비밀번호를 입력하세요: ");
			scanner.nextLine(); // 키보드 버퍼를 비운다.
			String password = scanner.nextLine().trim();

//			수정할 글의 비밀번호(original.getPassword())와 수정하기 위해 입력한 
//			비밀번호(password)를 비교한다.
			if (original.getPassword().trim().equals(password)) {
				
//				비밀번호가 일치하면 글을 수정할 내용을 입력받고 글을 수정하는 메소드를 실행한다.
				System.out.print("수정할 메모를 입력하세요: ");
				String memo = scanner.nextLine().trim();
				
				MemoDAO.update(idx, memo);
				System.out.println(idx + "번 글 수정완료!!");
				
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
			
		}  catch (NullPointerException e) {
			System.out.println(idx + "번 글이 존재하지 않습니다.");
		}
		
	}

}












