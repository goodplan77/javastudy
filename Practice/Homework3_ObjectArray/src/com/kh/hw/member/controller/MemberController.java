package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {

	private Member[] m = new Member[SIZE];
	public static int SIZE = 10;

	public int existMemberNum() {
		return 10 - SIZE;
	}

	public boolean checkId(String inputId) {
		for (Member temp : m) {
			if (temp == null) {
				continue;
			}
			if ((temp.getId()).equals(inputId)) {
				return true;
			}

		}

		return false;
	}

	public void insertMember(String id, String name, String password, String email, String gender, int age) {
		for (int i = 0; i <= existMemberNum(); i++) {
			if (m[i] != null) {
				continue;
			} else {
				m[i] = new Member(id, name, password, email, gender.charAt(0), age);
				break;
			}
		}
		SIZE--;
	}

	public String searchId(String id) {
		for (Member temp : m) {
			if (temp == null) {
				continue;
			}
			if (temp.getId().equals(id)) {
				return temp.inform();
			}
		}

		return null;
	}

	public Member[] searchName(String name) {
		Member[] tempArray = new Member[10];
		int count = 0;
		for (Member temp : m) {
			if (temp == null) {
				continue;
			}
			if (temp.getName().equals(name)) {
				tempArray[count++] = temp;
			}
		}

		if (count == 0) {
			return null;
		} else {
			Member[] outputArray = new Member[count];
			for (int i = 0; i < count; i++) {
				outputArray[i] = tempArray[i];
			}
			return outputArray;
		}
	}

	public Member[] searchEmail(String email) {
		Member[] tempArray = new Member[10];
		int count = 0;
		for (Member temp : m) {
			if (temp == null) {
				continue;
			}
			if (temp.getEmail().equals(email)) {
				tempArray[count++] = temp;
			}
		}

		if (count == 0) {
			return null;
		} else {
			Member[] outputArray = new Member[count];
			for (int i = 0; i < count; i++) {
				outputArray[i] = tempArray[i];
			}
			return outputArray;
		}
	}

	public boolean updatePassword(String id, String password) {
		for (Member temp : m) {
			if (temp == null) {
				continue;
			}
			if (temp.getId().equals(id)) {
				temp.setPassword(password);
				return true;
			}
		}

		return false;
	}

	public boolean updateName(String id, String name) {
		for (Member temp : m) {
			if (temp == null) {
				continue;
			}
			if (temp.getId().equals(id)) {
				temp.setName(name);
				return true;
			}
		}

		return false;
	}

	public boolean updateEmail(String id, String email) {
		for (Member temp : m) {
			if (temp == null) {
				continue;
			}
			if (temp.getId().equals(id)) {
				temp.setEmail(email);
				return true;
			}
		}

		return false;
	}

	public boolean delete(String id) {

		for (int i = 0; i < 10; i++) {
			if (m[i] == null) {
				continue;
			}

			if (m[i].getId().equals(id)) {
				m[i] = null;
				SIZE++;
				return true;
			}
		}

		return false;
	}

	public void delete() {
		SIZE = 10;
		m = new Member[SIZE];
	}

	public Member[] printAll() {
		return m;
	}

}
