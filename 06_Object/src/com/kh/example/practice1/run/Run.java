package com.kh.example.practice1.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {
	public static void main(String[] args) {
		
		Member mm = new Member();
		
		mm.changeName("홍길동");
		mm.printName();
	}
}
