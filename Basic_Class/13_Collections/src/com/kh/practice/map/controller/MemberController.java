package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.TreeMap;
import com.kh.practice.map.model.vo.Member;

public class MemberController {

	private HashMap<String, Member> map = new HashMap<>();

	public boolean joinMembership(String id, Member m) {
		if (map.get(id) != null) {
			return false;
		} else {
			map.put(id, m);
			return true;
		}
	}

	public String logIn(String id, String password) {
		Member temp = map.get(id);
		if (temp != null && temp.getPassword().equals(password)) {
			return temp.getName();
		}
		return null;
	}

	public boolean changePassword(String id, String oldPw, String newPw) {
			Member temp = map.get(id);
		if (temp != null && temp.getPassword().equals(oldPw)) {
			temp.setPassword(newPw);;
			map.replace(id, temp);
			return true;
		}

		return false;
	}

	public void changeName(String id, String newName) {
		Member temp = map.get(id);
		if (temp != null) {
			temp.setName(newName);
			map.replace(id, temp);
		}

	}

	public TreeMap sameName(String name) {
		return null;
	}

}
