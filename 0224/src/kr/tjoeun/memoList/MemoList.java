package kr.tjoeun.memoList;

import java.util.ArrayList;

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
		if (memoList.size() == 0) { // 저장된 글이 있는가?
//			게시글이 없으면 게시글이 없다는 메시지를 넘겨준다.
			str += "저장된 메모가 없습니다.\n";
		} else {
//			게시글이 있으면 마지막에 입력한 글(최신글) 부터 출력한다.
//			for (int i=0; i<memoList.size(); i++) { // 처음부터 마지막까지
			for (int i=memoList.size()-1; i>=0; i--) { // 마지막부터 처음까지
				str += memoList.get(i) + "\n";
			}
		}
		return str;
	}
	
//	MemoProjectMain 클래스에서 호출되는 memoList라는 ArrayList에 저장할 데이터가 저장된 MemoVO
//	클래스 객체를 넘겨받아 memoList라는 ArrayList에 저장하는 메소드
	public void addMemo(MemoVO vo) {
		memoList.add(vo);
	}
	
//	MemoProjectMain 클래스에서 호출되는 수정 또는 삭제할 글번호를 넘겨받고 memoList라는 ArrayList에
//	저장된 글 중에서 수정 또는 삭제할 글번호에 해당되는 글 1건을 얻어와서 리턴하는 메소드 
	public MemoVO selectMemo(int idx) {
		try {
			return memoList.get(idx - 1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
//	MemoProjectMain 클래스에서 호출되는 삭제할 글번호를 넘겨받고 memoList라는 ArrayList에 저장된
//	글 1건을 삭제하는 메소드
	public void deleteMemo(int idx) {
		memoList.remove(idx - 1);
		
//		글 삭제 후 인덱스가 변경되므로 인덱스에 맞춰서 글번호를 다시 붙여준다. => 이 현상은
//		데이터베이스를 사용하지 않고 ArrayList를 사용하기 때문에 발생된다.
//		ArrayList는 앞의 데이터가 지워지면 뒤의 데이터가 앞으로 인덱스가 당겨지는 특징이 있다.
		
//		글 삭제 후 글번호를 다시 붙여준다.
		for (int i=0; i<memoList.size(); i++) {
			memoList.get(i).setIdx(i + 1);
		}
		
//		글이 삭제된 후 새 글이 입력될 때 idx가 기존 idx 값에 이어서 1씩 증가할 수 있도록 count의
//		값을 수정한다.
		MemoVO.count = memoList.size();
	}
	
//	MemoProjectMain 클래스에서 호출되는 수정할 글번호와 수정할 메모를 넘겨받고 memoList라는 ArrayList에
//	저장된 글 1건을 수정하는 메소드
	public void updateMemo(int idx, String memo) {
		memoList.get(idx - 1).setMemo(memo);
	}
	
	
}






