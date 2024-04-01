package com.kh.hw.member.controller;

import java.util.Arrays;

import com.kh.hw.member.model.vo.Member;

public class MemberController {

	private Member[] m = new Member[SIZE];
	public static final int SIZE = 10;
	
	public MemberController() {
		m[0] = new Member("aaaaa","박신우","aa","aaa@aaa.aaa",'F',33);
		m[1] = new Member("bbbbb","박신우","aa","aaa@aaa.aaa",'F',33);
		m[2] = new Member("ccccc","박신우","aa","aaa@aaa.aaa",'F',33);
		m[3] = new Member("ddddd","박신우","aa","aaa@aaa.aaa",'F',33);
		m[4] = new Member("eeeee","박신우","aa","aaa@aaa.aaa",'F',33);
		m[5] = new Member("fffff","박신우","aa","aaa@aaa.aaa",'F',33);
		m[6] = new Member("ggggg","박신우","aa","aaa@aaa.aaa",'F',33);
		m[7] = new Member("hhhhh","박신우","aa","aaa@aaa.aaa",'F',33);
		m[8] = new Member("iiiii","박신우","aa","aaa@aaa.aaa",'F',33);
		m[9] = new Member("jjjjj","박신우","aa","aaa@aaa.aaa",'F',33);
	}

	public int existMemberNum() {
		int memberCount = 0;
		for (Member temp : m) {
			if (temp != null) {
				memberCount++;
			}
		}
		return memberCount;
	}

	public boolean checkId(String inputId) {
		for (Member temp : m) {
			if (temp != null && (temp.getId()).equals(inputId)) {
				return true;
			}
		}
		return false;
	}

	public void insertMember(String id, String name, String password, String email, String gender, int age) {
		for (int i = 0; i < SIZE; i++) {
			if (m[i] == null) {
				m[i] = new Member(id, name, password, email, gender.charAt(0), age);
				break;
			}
		}
	}

	public String searchId(String id) {
		for (Member temp : m) {
			if (temp != null && temp.getId().equals(id)) {
				return temp.inform();
			}
		}
		return null;
	}

	public Member[] searchName(String name) {
		Member[] tempArray = new Member[SIZE];
		int index = 0;
		for (Member member : m) {
			if (member != null && member.getName().equals(name)) {
				tempArray[index++] = member;
			}
		}
		// 배열 복사를 이용해 초기화된 데이터만 전달
		return Arrays.copyOf(tempArray, index);
	}

	public Member[] searchEmail(String email) {
		Member[] tempArray = new Member[SIZE];
		int index = 0;
		for (Member member : m) {
			if (member != null && member.getEmail().equals(email)) {
				tempArray[index++] = member;
			}
		}
		return Arrays.copyOf(tempArray, index);
	}

	public boolean updatePassword(String id, String password) {
		for (Member temp : m) {
			if (temp != null && temp.getId().equals(id)) {
				temp.setPassword(password);
				return true;
			}
		}
		return false;
	}

	public boolean updateName(String id, String name) {
		for (Member temp : m) {
			if (temp != null && temp.getId().equals(id)) {
				temp.setName(name);
				return true;
			}
		}
		return false;
	}

	public boolean updateEmail(String id, String email) {
		for (Member temp : m) {
			if (temp != null && temp.getId().equals(id)) {
				temp.setEmail(email);
				return true;
			}
		}
		return false;
	}

	public boolean delete(String id) {
		for (int i = 0; i < SIZE; i++) {
			if (m[i] != null && m[i].getId().equals(id)) {
				m[i] = null;
				return true;
			}
		}
		return false;
	}

	public void delete() {
		// 1. 새로운 빈 배열 객체 생성
		m = new Member[SIZE];

		// 2. 반복문으로 모든 인덱스 값 null로 초기화
		/*
		 * for(int i = 0 ; i<SIZE ; i++) { m[i] = null; }
		 */
	}

	public Member[] printAll() {
		return m;
	}

}
