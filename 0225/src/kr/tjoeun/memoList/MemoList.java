package kr.tjoeun.memoList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MemoList {

	private ArrayList<MemoVO> memoList = new ArrayList<MemoVO>();

	public ArrayList<MemoVO> getMemoList() {
		return memoList;
	}
	public void setMemoList(ArrayList<MemoVO> memoList) {
		this.memoList = memoList;
	}
	
	@Override
	public String toString() {
		String str = "";
		if (memoList.size() == 0) {
			str += "저장된 메모가 없습니다.\n";
		} else {
			for (int i=memoList.size()-1; i>=0; i--) {
				str += memoList.get(i) + "\n";
			}
		}
		return str;
	}
	
	public void addMemo(MemoVO vo) {
		memoList.add(vo);
	}
	
	public MemoVO selectMemo(int idx) {
		try {
			return memoList.get(idx - 1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public void deleteMemo(int idx) {
		memoList.remove(idx - 1);
		for (int i=0; i<memoList.size(); i++) {
			memoList.get(i).setIdx(i + 1);
		}
		MemoVO.count = memoList.size();
	}
	
	public void updateMemo(int idx, String memo) {
		memoList.get(idx - 1).setMemo(memo);
	}
	
//	MemoProjectMain 클래스에서 호출되는 텍스트 파일 이름을 넘겨받아 memoList ArrayList에 저장된
//	데이터를 텍스트 파일로 출력하는 메소드
	public void writeMemo(String filename) {
		
		PrintWriter printWriter = null;
		
		try {
//			String filepath = "./src/kr/tjoeun/memoList/" + filename + ".txt";
			String filepath = String.format("./src/kr/tjoeun/memoList/%s.txt", filename);
//			System.out.println(filepath);
			printWriter = new PrintWriter(filepath);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
//			memoList라는 ArrayList에 저장된 데이터의 개수만큼 반복하며 텍스트 파일로 출력한다.
//			memoList에 저장된 데이터를 공백으로 구분해서 1줄로 연결해 출력한다.
//			replace(a, b) 메소드는 문자열의 모든 a를 b로 변경한다.
			/*
			for (int i=0; i<memoList.size(); i++) { // 일반 for
				MemoVO vo = memoList.get(i);
//				String str = "";
//				str += vo.getIdx() + " ";
//				str += vo.getName().replace(" ", "_") + " ";
//				str += vo.getPassword() + " ";
//				str += vo.getMemo().replace(" ", "_") + " ";
//				str += sdf.format(vo.getWriteDate());
				String str = String.format("%s %s %s %s %s", 
						vo.getIdx(), vo.getName().replace(" ", "_"), vo.getPassword(), 
						vo.getMemo().replace(" ", "_"), sdf.format(vo.getWriteDate()));
				System.out.println(str);
			}
			*/
			
			for (MemoVO vo : memoList) { // 향상된 for
//				String str = "";
//				str += vo.getIdx() + " ";
//				str += vo.getName().replace(" ", "_") + " ";
//				str += vo.getPassword() + " ";
//				str += vo.getMemo().replace(" ", "_") + " ";
//				str += sdf.format(vo.getWriteDate());
				String str = String.format("%s %s %s %s %s", 
						vo.getIdx(), vo.getName().replace(" ", "_"), vo.getPassword(), 
						vo.getMemo().replace(" ", "_"), sdf.format(vo.getWriteDate()));
//				System.out.println(str);
				printWriter.write(str + "\r\n");
			}
			System.out.println(filename + ".txt 파일에 쓰기완료!!!");
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("파일의 경로 또는 이름이 올바르지 않습니다.");
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
		
	}

//	MemoProjectMain 클래스에서 호출되는 텍스트 파일 이름을 넘겨받아 텍스트 파일의 데이터를 읽어
//	memoList ArrayList에 저장하는 메소드
	public void readMemo(String filename) {
		
		Scanner scanner = null;
		
		try {
			String filepath = String.format("./src/kr/tjoeun/memoList/%s.txt", filename);
			scanner = new Scanner(new File(filepath));
			
//			텍스트 파일에 저장된 데이터를 마지막 줄 까지 읽어서 memoList ArrayList에 저장한다.
			while (scanner.hasNextLine()) {
//				텍스트 파일의 데이터를 1줄을 읽는다.
				String str = scanner.nextLine().trim();
//				System.out.println(str);
				
//				읽어들인 데이터 1줄을 공백을 경계로 읽어서 각각의 변수에 저장한다.
				Scanner scan = new Scanner(str);
				int idx = scan.nextInt();
				String name = scan.next().replace("_", " ");
				String password = scan.next();
				String memo = scan.next().replace("_", " ");
				String temp = scan.nextLine().trim();
				
//				텍스트 파일에서 읽어들인 문자열로 변환되서 저장된 날짜 데이터를 Date 클래스 객체를
//				사용해서 날짜 데이터로 변환한다.
//				작성일은 Date 클래스 타입이므로 String 변수 temp에서 문자열을 substring() 메소드를
//				사용해서 년, 월, 일, 시, 분, 초로 분리한 후 날짜 데이터로 만들어 저장시켜야 한다.
//				System.out.println(temp.substring(0, 4));
//				int year = Integer.parseInt(temp.substring(0, 4)) - 1900;
//				int month = Integer.parseInt(temp.substring(5, 7)) - 1;
//				int day = Integer.parseInt(temp.substring(8, 10));
//				int hour = Integer.parseInt(temp.substring(11, 13));
//				int minute = Integer.parseInt(temp.substring(14, 16));
//				int second = Integer.parseInt(temp.substring(17));
				
//				split() 메소드의 구분자를 "."으로 지정하면 동작이 제대로 되지 않는다.
//				split() 메소드에서 "."을 구분자로 사용하려면 "\\." 또는 "[.]" 형태로 지정한다.
				String[] date = temp.split("\\.");
//				System.out.println("split() 메소드 실행 결과: " + Arrays.toString(date));
				int year = Integer.parseInt(date[0]) - 1900;
				int month = Integer.parseInt(date[1]) - 1;
				int day = Integer.parseInt(date[2]);
				int hour = Integer.parseInt(date[3]);
				int minute = Integer.parseInt(date[4]);
				int second = Integer.parseInt(date[5]);
				Date writeDate = new Date(year, month, day, hour, minute, second);
				
//				각각의 변수에 저장된 데이터를 MemoVO 클래스 객체를 만들어 넣어준다.
				MemoVO vo = new MemoVO();
				vo.setIdx(idx);
				vo.setName(name);
				vo.setPassword(password);
				vo.setMemo(memo);
				vo.setWriteDate(writeDate);
//				System.out.println(vo);
				
//				MemoVO 클래스 객체에 저장된 데이터를 memoList ArrayList에 저장한다.
				memoList.add(vo);
			}
			
			System.out.println(filename + ".txt 파일에서 읽기완료!!!");
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("파일의 경로 또는 이름이 올바르지 않습니다.");
		}
		
	}
	
}














