package com.tjoeun.vo;

import java.util.ArrayList;

public class CategoryList {

	private ArrayList<CategoryVO> list = new ArrayList<CategoryVO>();

	public ArrayList<CategoryVO> getList() {
		return list;
	}
	public void setList(ArrayList<CategoryVO> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "CategoryList [list=" + list + "]";
	}
	
}
