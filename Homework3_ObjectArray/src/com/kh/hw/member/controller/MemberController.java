package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {

	private Member[] m = new Member[SIZE];
	public static final int SIZE = 10;

	public int existMemberNum() {
		return 0;
	}

	public boolean checkId(String inputId) {
		return false;
	}

	public void insertMember(String id, String name, String password, String email, String gender, int age) {
	}

	public String searchId(String id) {
		return "";
	}

	public Member[] searchName(String name) {
		return null;
	}
	
	public Member[] searchEmail(String email) {
		return null;
	}

	public boolean updatePassword(String id, String password) {
		return false;
	}

	public boolean updateName(String id, String name) {
		return false;
	}

	public boolean updateEmail(String id, String email) {
		return false;
	}

	public boolean delete(String id) {
		return false;
	}

	public void delete() {
	}

	public Member[] printAll() {
		return null;
	}

}
