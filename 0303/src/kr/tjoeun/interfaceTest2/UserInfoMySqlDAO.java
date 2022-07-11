package kr.tjoeun.interfaceTest2;

public class UserInfoMySqlDAO implements UserInfoDAO {

	@Override
	public void insertUserInfo(UserInfo userInfo) {
		System.out.println("insert into MYSQL DB userId = " + userInfo.getUserId());
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("update into MYSQL DB userId = " + userInfo.getUserId());
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		System.out.println("delete into MYSQL DB userId = " + userInfo.getUserId());
	}

}
