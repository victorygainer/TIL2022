package com.tjoeun.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.tjoeun.dao.CategoryDAO;
import com.tjoeun.mybatis.MySession;
import com.tjoeun.vo.CategoryList;
import com.tjoeun.vo.CategoryVO;

public class CategoryService {
	
	private static CategoryService instance = new CategoryService();
	private CategoryService() { }
	public static CategoryService getInstance() {
		return instance;
	}
	
//	insert.jsp에서 호출되는 테이블에 저장할 메인 카테고리 정보가 저장된 객체를 넘겨받고 mapper를 얻어온 후
//	DAO 클래스의 메인 카테고리를 저장하는 명령을 실행하는 메소드를 호출하는 메소드
	public void insert(CategoryVO vo) {
		System.out.println("CategoryService 클래스의 insert() 메소드");
		// mapper를 얻어온다.
		SqlSession mapper = MySession.getSession();
		// System.out.println("연결성공: " + mapper);
		
		// DAO 클래스의 insert sql 명령을 실행하는 메소드를 호출한다.
		CategoryDAO.getInstance().insert(mapper, vo);
		
		// 실행한 sql 명령이 테이블을 변경하는 insert, delete, update sql 명령일 경우 작업 결과를 테이블에
		// 반영시키기 위해 작업이 완료되면 반드시 commit() 메소드를 실행해야 한다.
		// 테이블이 변경되지 않는 select sql 명령은 commit() 메소드를 실행하지 않아도 상관없다.
		mapper.commit();
		// 필수, mapper를 사용한 데이터베이스 작업이 완료되면 반드시 mapper를 닫아야 한다.
		mapper.close();
	}

//	list.jsp에서 호출되는 mapper를 얻어온 후 DAO 클래스의 테이블에 저장된 전체 카테고리 목록을 얻어오는
//	명령을 실행하는 메소드를 호출하는 메소드
	public CategoryList selectList() {
		System.out.println("CategoryService 클래스의 selectList() 메소드");
		SqlSession mapper = MySession.getSession();
		// 전체 카테고리 목록을 저장할 객체를 선언한다.
		CategoryList categoryList = new CategoryList();
		// 테이블에서 얻어온 전체 카테고리 목록 CategoryList 클래스 객체의 ArrayList에 저장한다.
		categoryList.setList(CategoryDAO.getInstance().selectList(mapper));
		mapper.close();
		// 전체 카테고리 목록을 리턴시킨다.
		return categoryList;
	}
	
//	insert.jsp에서 호출되는 테이블에 저장할 서브 카테고리 정보가 저장된 객체를 넘겨받고 mapper를 얻어온 후
//	DAO 클래스의 서브 카테고리를 저장하는 명령을 실행하는 메소드를 호출하는 메소드
	public void reply(CategoryVO vo) {
		System.out.println("CategoryService 클래스의 reply() 메소드");
		SqlSession mapper = MySession.getSession();
		CategoryDAO dao = CategoryDAO.getInstance();
		
		// 서브 카테고리가 삽입될 위치를 결정하기 위해서 lev과 seq를 1씩 증가시킨다.
		// 서브 카테고리 레벨은 부모 카테고리 레벨보다 1크다.
		vo.setLev(vo.getLev() + 1);
		// 서브 카테고리가 부모 카테고리 바로 아래 나오야 하므로 출력 순서가 부모 카테고리 보다 1크다.
		vo.setSeq(vo.getSeq() + 1);
		
		// 서브 카테고리를 위치에 맞게 삽입하기 위해서 같은 카테고리 그룹(gup)의 카테고리 출력 순서(seq)를 조정한다.
		// 카테고리 출력 순서를 조정하는 메소드를 실행한다.
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("gup", vo.getGup());
		hmap.put("seq", vo.getSeq());
		dao.increment(mapper, hmap); // update
		// 서브 카테고리를 테이블에 저장하는 메소드를 실행한다.
		dao.reply(mapper, vo); // insert
		
		mapper.commit();
		mapper.close();
	}
	
//	delete.jsp에서 호출되는 삭제할 카테고리 번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 
//	카테고리 1건을 얻어오는 select sql 명령을 실행하는 메소드를 호출하는 메소드
	public CategoryVO selectByIdx(int idx) {
		System.out.println("CategoryService 클래스의 selectByIdx() 메소드");
		SqlSession mapper = MySession.getSession();
		CategoryVO vo = CategoryDAO.getInstance().selectByIdx(mapper, idx);
		mapper.close();
		return vo;
	}
	
//	delete.jsp에서 호출되는 삭제할 카테고리 번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 
//	카테고리 1건을 삭제하는 delete sql 명령을 실행하는 메소드를 호출하는 메소드
	public void delete(int idx) {
		System.out.println("CategoryService 클래스의 delete() 메소드");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().delete(mapper, idx);
		mapper.commit();
		mapper.close();
	}
	
//	delete.jsp에서 호출되는 삭제할 카테고리 번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 
//	카테고리 1건을 "삭제된 카테고리 입니다."로 수정하는 update sql 명령을 실행하는 메소드를 
//	호출하는 메소드
	public void deleteCategory(int idx) {
		System.out.println("CategoryService 클래스의 deleteCategory() 메소드");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().deleteCategory(mapper, idx);
		mapper.commit();
		mapper.close();
	}
	
//	delete.jsp에서 호출되는 삭제할 카테고리 번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 
//	카테고리 1건의 deleteCheck 필드의 값을 "YES"로 수정하는 update sql 명령을 실행하는 메소드를 
//	호출하는 메소드
	public void deleteCheck(int idx) {
		System.out.println("CategoryService 클래스의 deleteCheck() 메소드");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().deleteCheck(mapper, idx);
		mapper.commit();
		mapper.close();
	}
	
//	deleteRestore.jsp에서 호출되는 복구할 카테고리 번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 
//	카테고리 1건의 deleteCheck 필드의 값을 "NO"로 수정하는 update sql 명령을 실행하는 메소드를 
//	호출하는 메소드
	public void deleteRestore(int idx) {
		System.out.println("CategoryService 클래스의 deleteRestore() 메소드");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().deleteRestore(mapper, idx);
		mapper.commit();
		mapper.close();
	}
	
//	deleteReport.jsp에서 호출되는 신고할 카테고리 번호를 넘겨받고 mapper를 얻어온 후 DAO 클래스의 
//	카테고리 1건의 deleteReport 필드의 값을 1증가 시키는 update sql 명령을 실행하는 메소드를 
//	호출하는 메소드
	public void deleteReport(int idx) {
		System.out.println("CategoryService 클래스의 deleteReport() 메소드");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().deleteReport(mapper, idx);
		mapper.commit();
		mapper.close();
	}
	
//	update.jsp에서 호출되는 수정할 카테고리 정보가 저장된 객체를 넘겨받고 mapper를 얻어온 후
//	DAO 클래스의 카테고리 1건을 수정하는 update sql 명령을 실행하는 메소드를 호출하는 메소드
	public void update(CategoryVO vo) {
		System.out.println("CategoryService 클래스의 update() 메소드");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().update(mapper, vo);
		mapper.commit();
		mapper.close();
	}
	
//	delete.jsp에서 호출되는 삭제할 카테고리 정보가 저장된 객체를 넘겨받고 mapper를 얻어온 후
//	DAO 클래스의 삭제할 카테고리 목록을 얻어오는 select sql 명령을 실행하는 메소드를 호출하는 메소드
	public ArrayList<CategoryVO> deleteList(CategoryVO vo) {
		System.out.println("CategoryService 클래스의 deleteList() 메소드");
		SqlSession mapper = MySession.getSession();
		ArrayList<CategoryVO> deleteList = CategoryDAO.getInstance().deleteList(mapper, vo);
		mapper.close();
		return deleteList;
	}
	
//	delete.jsp에서 호출되는 seq를 다시 부여할 카테고리 그룹(gup)을 넘겨받고 mapper를 얻어온 후
//	DAO 클래스의 삭제할 카테고리 그룹에 seq를 0부터 1씩 증가하게 다시 부여하는 update sql 명령을
//	실행하는 메소드를 호출하는 메소드
	public void reSeq(int gup) {
		System.out.println("CategoryService 클래스의 reSeq() 메소드");
		SqlSession mapper = MySession.getSession();
		CategoryDAO dao = CategoryDAO.getInstance();
		
		// seq를 다시 부여할 카테고리 그룹만 얻어와서 ArrayList에 저장한다.
		ArrayList<CategoryVO> gupList = dao.selectGup(mapper, gup);
		
		// ArrayList로 얻어온 카테고리 그룹의 카테고리 개수만큼 반복하며 seq를 0부터 다시 부여한다.
		for (int i=0; i<gupList.size(); i++) {
			// seq를 수정할 카테고리 일련번호(idx)와 seq를 수정할 데이터(i)를 HashMap 객체에 저장한다.
			HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			hmap.put("idx", gupList.get(i).getIdx());
			hmap.put("seq", i);
			dao.reSeq(mapper, hmap);
		}
		mapper.commit();
		mapper.close();
	}
	
}









