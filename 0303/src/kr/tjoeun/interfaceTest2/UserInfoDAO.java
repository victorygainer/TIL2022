package kr.tjoeun.interfaceTest2;

//	DAO(Data Access Object): 데이터베이스에 접근해서 sql 명령을 실행하는 클래스
public interface UserInfoDAO {

//	메소드 명세
	void insertUserInfo(UserInfo userInfo); // 사용자 정보 저장 메소드
	void updateUserInfo(UserInfo userInfo); // 사용자 정보 수정 메소드
	void deleteUserInfo(UserInfo userInfo); // 사용자 정보 삭제 메소드
	
}
