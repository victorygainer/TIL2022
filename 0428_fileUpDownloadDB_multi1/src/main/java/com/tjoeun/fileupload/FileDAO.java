package com.tjoeun.fileupload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FileDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public FileDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "tjoeunit", "0000");
			// System.out.println("연결성공: " + conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 정보가 올바르지 않습니다.");
		}
	}
	
//	파일을 업로드 할 때 마다 업로드하는 파일 이름과 실제로 디스크에 저장되는 파일 이름을 테이블에
//	저장하는 메소드
	public void upload(String filename, String fileRealname) {
		System.out.println("FileDAO 클래스의 upload() 메소드");
		try {
			String sql = "insert into fileupload (idx, filename, filerealname) " + 
					"values (fileupload_idx_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, filename);
			pstmt.setString(2, fileRealname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	테이블에 저장된 업로드된 전체 파일 목록을 얻어오는 메소드
	public ArrayList<FileVO> getUploadList() {
		System.out.println("FileDAO 클래스의 getUploadList() 메소드");
		ArrayList<FileVO> list = new ArrayList<FileVO>();
		try {
			// 테이블에서 업로드된 파일 목록을 얻어온다.
			String sql = "select * from fileupload order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 얻어온 파일 목록을 FileVO 클래스 객체로 만들어 ArrayList에 넣어준다.
			while (rs.next()) {
				FileVO vo = new FileVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setFilename(rs.getString("filename"));
				vo.setFileRealname(rs.getString("fileRealname"));
				vo.setDownloadCount(rs.getInt("downloadCount"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

//	파일 다운로드가 완료되면 다운로드 횟수를 1증가시키는 메소드
	public void hit(String filename) {
		System.out.println("FileDAO 클래스의 getUploadList() 메소드");
		try {
			String sql = "update fileupload set downloadCount = downloadCount + 1 where fileRealname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, filename);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}









