package kr.tjoeun.memoListDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//	Service 클래스에서 전처리 작업이 완료되서 넘어온 데이터를 가지고 sql 명령을 실행한다.
public class MemoDAO {

//	테이블에 저장할 데이터가 저장된 MemoVO 클래스 객체를 넘겨받아 테이블에 데이터를 저장하는 메소드
	public static boolean insert(MemoVO vo) {
		
		boolean result = true;
		
//		데이터베이스 작업에 사용할 객체를 선언한다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			데이터베이스에 연결한다.
			conn = DBUtil.getMySQLConnection();
//			sql 명령을 만든다.
			String sql = "insert into memo(name, password, memo) values (?, ?, ?)";
//			sql 명령을 임시로 실행한다.
			pstmt = conn.prepareStatement(sql);
//			"?"를 채운다.
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMemo());
//			sql 명령을 실행한다.
			pstmt.executeUpdate();
//			System.out.println(vo.getName() + "님 글 저장완료");
		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("sql 명령이 올바로 실행되지 않았습니다.");
//			JOptionPane.showMessageDialog(null, "sql 명령이 올바로 실행되지 않았습니다.");
			result = false;
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return result;
		
	}

//	데이터베이스 테이블에 저장된 전체 글 목록을 최신글 순으로 얻어오는 메소드
	public static ArrayList<MemoVO> select() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemoVO> list = null; // 결과를 저장해서 리턴시킬 ArrayList
		
		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "select * from memo order by idx desc";
			pstmt = conn.prepareStatement(sql);
//			select sql 명령의 실행 결과를 ResultSet 객체에 저장한다.
			rs = pstmt.executeQuery();
//			데이터베이스 테이블에서 성공적으로 데이터를 얻어왔으므로 결과를 저장해서 리턴시킬 ArrayList
//			객체를 만든다.
			list = new ArrayList<MemoVO>();
			
//			ResultSet 객체에 데이터가 있는동안 반복하며 ResultSet 객체에 저장된 데이터를 MemoVO 클래스
//			객체로 만들어 ArrayList에 저장한다.
//			next() 메소드는 ResultSet 객체에 저장된 다음 데이터로 접근한다.
//			next() 메소드는 ResultSet 객체에 저장된 다음 데이터로 접근 성공하면(데이터가 있으면) true를
//			리턴하고 다음 데이터로 접근 실패하면(데이터가 없으면) false를 리턴한다.
			while (rs.next()) {
//				ResultSet의 데이터를 읽어 MemoVO 클래스 객체에 저장한다.
				MemoVO vo = new MemoVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
//				System.out.println(vo);
//				MemoVO 클래스 객체를 ArrayList에 저장한다.
				list.add(vo);
			}
		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return list;
		
	}

//	데이터베이서 테이블에서 글 1건을 얻어오는 메소드
	public static MemoVO selectByIdx(int idx) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemoVO vo = null; // 글 1건을 저장해서 리턴시킬 객체를 선언한다.

		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "select * from memo where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
//			데이터베이스 테이블에서 성공적으로 데이터를 얻어왔으므로 결과를 저장해서 리턴시킬 MemoVO
//			객체를 만든다.
			vo = new MemoVO();
			
//			ResultSet 객체에 데이터 있으면 ResultSet 객체에 저장된 데이터를 MemoVO 클래스 객체에 
//			저장한다.
			if (rs.next()) {
//				ResultSet의 데이터를 읽어 MemoVO 클래스 객체에 저장한다.
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
//				System.out.println(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return vo;
		
	}

//	데이터베이스 테이블에 글 1건을 삭제하는 메소드
	public static void delete(int idx) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "delete from memo where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}

//	데이터베이스 테이블에 글 1건을 수정하는 메소드
	public static void update(int idx, String memo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "update memo set memo = ? where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memo);
			pstmt.setInt(2, idx);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}
	
}






