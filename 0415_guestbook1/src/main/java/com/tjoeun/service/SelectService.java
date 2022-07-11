package com.tjoeun.service;

import java.sql.SQLException;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.tjoeun.dao.GuestbookDAO;
import com.tjoeun.ibatis.MyAppSqlConfig;
import com.tjoeun.vo.GuestbookList;
import com.tjoeun.vo.GuestbookVO;
import com.tjoeun.vo.Param;

public class SelectService {

	private static SelectService instance = new SelectService();
	private SelectService() { }
	public static SelectService getInstance() {
		return instance;
	}
	
//	list.jsp에서 호출되는 화면에 표시할 페이지 번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 1페이지
//	분량의 글 목록을 얻어오는 select sql 명령을 실행하는 메소드를 호출하는 메소드
	public GuestbookList selectList(int currentPage) {
		System.out.println("SelectService 클래스의 selectList() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		
		// 1페이지 분량의 글 목록과 페이징 작업에 사용할 8개의 변수를 저장해서 리턴시킬 객체를 선언한다.
		GuestbookList guestbookList = null;
		// DAO 클래스에 2번 접근해서 sql 명령을 실행해야 하므로 DAO 클래스의 객체를 미리 얻어둔다.
		GuestbookDAO dao = GuestbookDAO.getInstance();
		
		try {
			// 1페이지당 표시할 글의 개수를 정한다
			int pageSize = 5;
			// 테이블에 저장된 전체 글의 개수를 얻어온다.
			int totalCount = dao.selectCount(mapper);
			// System.out.println(totalCount);
			
			// pageSize, totalCount, currentPage를 GuestbookList 클래스의 생성자로 넘겨서 1페이지 분량의
			// 글 목록을 저장하고 페이징 작업에 사용할 변수를 초기화하는 GuestbookList 클래스 객체를 생성한다.
			guestbookList = new GuestbookList(pageSize, totalCount, currentPage);
			
			// parameterClass, resultClass는 데이터 타입을 반드시 1개만 적어야 한다.
			HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			hmap.put("startNo", guestbookList.getStartNo());
			hmap.put("endNo", guestbookList.getEndNo());
			// mysql은 아래와 같이 endNo 대신 pageSize를 저장해서 넘겨주면 된다.
			// hmap.put("pageSize", guestbookList.getPageSize());
			
			// 1페이지 분량의 글을 얻어와서 GuestbookList 클래스의 ArrayList에 저장한다.
			guestbookList.setList(dao.selectList(mapper, hmap));
			// System.out.println(guestbookList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 1페이지 분량의 글과 페이징 작업에 사용할 8개의 변수가 저장된 객체를 리턴시킨다.
		return guestbookList;
	}
	
//	list.jsp에서 호출되는 화면에 표시할 페이지 번호와 검색어(내용)를 넘겨받고 mapper를 얻어온 후 DAO 클래스의
//	1페이지 분량의 검색어를 포함하는 글 목록을 얻어오는 select sql 명령을 실행하는 메소드를 호출하는 메소드
	public GuestbookList selectListMemo(int currentPage, String item) {
		System.out.println("SelectService 클래스의 selectListMemo() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		GuestbookList guestbookList = null;
		GuestbookDAO dao = GuestbookDAO.getInstance();
		
		try {
			int pageSize = 5;
			// 내용에 검색어를 포함하는 글의 개수를 얻어온다.
			int totalCount = dao.selectCountMemo(mapper, item);
			// System.out.println(totalCount);
			
			guestbookList = new GuestbookList(pageSize, totalCount, currentPage);
			
			// startNo, endNo만 sql 명령으로 넘겨줄 때는 데이터 타입이 같기 때문에 HashMap을 이용했지만
			// category와 item를 같이 넘겨야 하므로 데이터 타입이 다르기 때문에 별도의 클래스를 만들고
			// 클래스 객체에 데이터를 담아서 넘겨줘야 한다.
			Param param = new Param();
			param.setStartNo(guestbookList.getStartNo());
			param.setEndNo(guestbookList.getEndNo());
			param.setItem(item);
			
			// 내용에 검색어를 포함하는 1페이지 분량의 글을 얻어와서 GuestbookList 클래스의 ArrayList에
			// 저장한다.
			guestbookList.setList(dao.selectListMemo(mapper, param));
			// System.out.println(guestbookList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return guestbookList;
	}
	
//	list.jsp에서 호출되는 화면에 표시할 페이지 번호와 검색어(이름)를 넘겨받고 mapper를 얻어온 후 DAO 클래스의
//	1페이지 분량의 검색어를 포함하는 글 목록을 얻어오는 select sql 명령을 실행하는 메소드를 호출하는 메소드
	public GuestbookList selectListName(int currentPage, String item) {
		System.out.println("SelectService 클래스의 selectListName() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		GuestbookList guestbookList = null;
		GuestbookDAO dao = GuestbookDAO.getInstance();
		
		try {
			int pageSize = 5;
			// 이름에 검색어를 포함하는 글의 개수를 얻어온다.
			int totalCount = dao.selectCountName(mapper, item);
			// System.out.println(totalCount);
			guestbookList = new GuestbookList(pageSize, totalCount, currentPage);
			Param param = new Param();
			param.setStartNo(guestbookList.getStartNo());
			param.setEndNo(guestbookList.getEndNo());
			param.setItem(item);
			guestbookList.setList(dao.selectListName(mapper, param));
			// System.out.println(guestbookList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return guestbookList;
	}
	
//	list.jsp에서 호출되는 화면에 표시할 페이지 번호와 검색어(내용+이름)를 넘겨받고 mapper를 얻어온 후 DAO 클래스의
//	1페이지 분량의 검색어를 포함하는 글 목록을 얻어오는 select sql 명령을 실행하는 메소드를 호출하는 메소드
	public GuestbookList selectListMemoName(int currentPage, String item) {
		System.out.println("SelectService 클래스의 selectListMemoName() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		GuestbookList guestbookList = null;
		GuestbookDAO dao = GuestbookDAO.getInstance();
		
		try {
			int pageSize = 5;
			// 내용과 이름에 검색어를 포함하는 글의 개수를 얻어온다.
			int totalCount = dao.selectCountMemoName(mapper, item);
			// System.out.println(totalCount);
			guestbookList = new GuestbookList(pageSize, totalCount, currentPage);
			Param param = new Param();
			param.setStartNo(guestbookList.getStartNo());
			param.setEndNo(guestbookList.getEndNo());
			param.setItem(item);
			guestbookList.setList(dao.selectListMemoName(mapper, param));
			// System.out.println(guestbookList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return guestbookList;
	}
	
//	list.jsp에서 호출되는 화면에 표시할 페이지 번호와 카테고리 및 검색어를 넘겨받고 mapper를 얻어온 후 DAO 클래스의
//	1페이지 분량의 카테고리별 검색어를 포함하는 글 목록을 얻어오는 select sql 명령을 실행하는 메소드를 호출하는 메소드
	public GuestbookList selectListMulti(int currentPage, String category, String item) {
		System.out.println("SelectService 클래스의 selectListMulti() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
		GuestbookList guestbookList = null;
		GuestbookDAO dao = GuestbookDAO.getInstance();
		
		try {
			int pageSize = 5;
			// 카테고리에 따른 검색어가 포함된 글의 개수를 얻어온다.
			// 카테고리에 따른 검색어가 포함되었나 조건을 세워야 하기 때문에 Param 클래스 객체를 사용한다.
			Param param = new Param();
			param.setCategory(category);
			param.setItem(item);
			int totalCount = dao.selectCountMulti(mapper, param);
			System.out.println(totalCount);
			
			guestbookList = new GuestbookList(pageSize, totalCount, currentPage);
			param.setStartNo(guestbookList.getStartNo());
			param.setEndNo(guestbookList.getEndNo());
			guestbookList.setList(dao.selectListMulti(mapper, param));
			// System.out.println(guestbookList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return guestbookList;
	}
	
//	selectByIdx.jsp에서 호출되는 수정 또는 삭제할 글번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의
//	글 1건을 얻어오는 select sql 명령을 실행하는 메소드를 호출하는 메소드
	public GuestbookVO selectByIdx(int idx) {
		System.out.println("SelectService 클래스의 selectByIdx() 메소드");
		SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
//		글 1건을 얻어와서 저장한 후 리턴시킬 객체를 선언한다.
		GuestbookVO vo = null;
		
		try {
			vo = GuestbookDAO.getInstance().selectByIdx(mapper, idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		얻어온 글 1건을 리턴시킨다.
		return vo;
	}
	
}










