package kr.tjoeun.memoListDB;

import java.text.SimpleDateFormat;
import java.util.Date;

//	VO(Value Object): 게시글 1건을 기억할 클래스, DTO(Date Transfer Object)
//	bean: 처리할 데이터를 기억할 필드와 필드에 데이터를 입출력하는 getters & setters 메소드로만
//	구성된 클래스
public class MemoVO {

//	클래스의 필드 이름은 테이블에 정의한 필드 이름, html의 form 태그 요소의 name 속성에 정의한
//	이름과 반드시 같은 이름으로 만든다.
	private int idx;
	private String name;
	private String password;
	private String memo;
	private Date writeDate;
	
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
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm"); // 오늘 서식
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd(E)"); // 어제 이전 서식
		Date date = new Date(); // 컴퓨터 시스템의 오늘 날짜
		
//		게시글이 작성된 날짜가 오늘인가 판단한다.
		String str = "";
//		if (date.getYear() == writeDate.getYear() && date.getMonth() == writeDate.getMonth() &&
//				date.getDate() == writeDate.getDate()) { // 오늘인가?
		if (sdf2.format(date).equals(sdf2.format(writeDate))) {
			str = sdf1.format(writeDate);
		} else {
			str = sdf2.format(writeDate);
		}
		return String.format("%d. %s(%s) 님이 %s에 남긴글\n%s", idx, name, password, str, memo);
	}
	
}



