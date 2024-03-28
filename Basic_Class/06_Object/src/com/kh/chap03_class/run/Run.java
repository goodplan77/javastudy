package com.kh.chap03_class.run;

import com.kh.chap03_class.model.vo.Person;

public class Run {

	public static void main(String[] args) {
		
		//Person 클래스 == 나만의 자료형(여러개의 자료형에 여러개의 값들을 보관)
		Person p = new Person();			//객체 생성 ==인스턴스화
		System.out.println(p.toString());	//기본값이 들어가 있음. (jvm이 자동으로 추가해줌.)
		
		//값 대입
		
		p.setId("user01");
		p.setPwd("pass01");
		p.setName("김갑생");
		
		System.out.println(p.toString());
		p.setAge(26);
		p.setGender('남');
		p.setPhone("010-2322-4564");
		p.setEmail("slkdjf@naver.com");
		
		System.out.println(p);
	}

}
