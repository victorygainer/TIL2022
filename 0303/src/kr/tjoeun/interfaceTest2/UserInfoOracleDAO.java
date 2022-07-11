package kr.tjoeun.interfaceTest2;

public class UserInfoOracleDAO implements UserInfoDAO {

	@Override
	public void insertUserInfo(UserInfo userInfo) {
		System.out.println("insert into ORACLE DB userId = " + userInfo.getUserId());
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("update into ORACLE DB userId = " + userInfo.getUserId());
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		System.out.println("delete into ORACLE DB userId = " + userInfo.getUserId());
	}

}
