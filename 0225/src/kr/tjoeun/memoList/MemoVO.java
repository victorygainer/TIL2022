package kr.tjoeun.memoList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoVO {

	public static int count; // 정적 필드로 만든다.
	private int idx; // 글번호 => count를 이용해서 자동으로 1증가
	private String name; // 작성자 이름
	private String password; // 비밀번호
	private String memo; // 게시글
	private Date writeDate; // 작성일 => 컴퓨터 시스템의 날짜와 시간을 자동으로 저장
	
	public MemoVO() {
		
	}
	public MemoVO(String name, String password, String memo) {
		idx = ++count;
		this.name = name;
		this.password = password;
		this.memo = memo;
		writeDate = new Date();
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
//		return idx + ". " + name + "(" + password + ") 님이 " + sdf.format(writeDate) + 
//				"에 남긴글\n" + memo;
		return String.format("%d. %s(%s) 님이 %s에 남긴글\n%s", 
				idx, name, password, sdf.format(writeDate), memo);
	}
	
}



