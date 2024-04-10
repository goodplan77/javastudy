package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
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
		Set<String> keySet = map.keySet();
		Iterator<String> itKey = keySet.iterator();
		
		TreeMap<String , Member> temp = new TreeMap<>();
		
		while(itKey.hasNext()) {
			String key = itKey.next();
			if(map.get(key).getName().equals(name)) {
				temp.put(key, map.get(key));
			}
		}
		
		return temp;
	}

}
