package com.kh.chap03_set.model.vo;

import java.util.HashMap;

public class MyHashSet {
	
	private HashMap<Student, Boolean> map; // 기본 자료형 X
	
	public MyHashSet() {
		map = new HashMap<>();
	}
	
	public void add(Student s) {
		map.put(s, true);
	}
	
	public void remove(Student s) {
		map.remove(s);
	}
	
	public boolean contains(Student s) {
		return map.containsKey(s);
	}
	
	public int size() {
		return map.size();
	}
	
	public void printAll() {
		for(Student s : map.keySet()) {
			System.out.println(s);
		}
		
	}
	
	public static void main(String[] args) {
		MyHashSet mhs = new MyHashSet();
		mhs.add(new Student("홍길동",25,100));
		mhs.add(new Student("홍길동",25,100));
		mhs.add(new Student("김영희",30,85));
		mhs.add(new Student("김철수",40,55));
		
		System.out.println(mhs.map);
		
		mhs.remove(new Student("김영희",30,85));
		System.out.println(mhs.map);
		
		System.out.println("김영희 ? : " + mhs.contains(new Student("김영희",30,85)));
		System.out.println("홍길동 ? : " + mhs.contains(new Student("홍길동",25,100)));
		
		System.out.println("크기 : " + mhs.size());
		
		mhs.printAll();
	}

}
