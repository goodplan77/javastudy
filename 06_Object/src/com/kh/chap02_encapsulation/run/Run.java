package com.kh.chap02_encapsulation.run;

import com.kh.chap02_encapsulation.model.vo.Student;

public class Run {
	
	/*
	 * 6. 캡슐화 과정을 통해 완벽한 클래스의 형태를 갖추게 하기.
	 * 	* 캡슐화란? 추상화를 통해 정의된 속성들과 기능들을 하나로 묶어 관리하는 기법 중 하나로 
	 *    클래스에서의 가장 중요한 목적인 "데이터 접근제한"을 원칙으로 외부로부터 "데이터의 접근"을 막고
	 *    대신에 '데이터를 간접적으로나마 처리'할 메소드를 클래스 내부에 작성하는 방식
	 * 
	 * 	  캡슐화를 하지 않으면 외부로부터의 직접적인 접근이 가능하기 때문에 쉽게 변질될 수 있다. 
	 * 
	 * 	  1) 정보은닉 private
	 *       필드들을 외부로부터 직접 접근을 막기 위해 public 대신에 private 접근 제한자를 사용함.
	 *       ex) 학생들이 본인의 성적을 조작할 수 없게, 혹은 다른 학생 성적을 볼 수 없게
	 * 
	 * 	  2) setter / getter 메소드
	 * 		 간접적으로나마 필드에 접근하여 값을 담거나, 그 값을 가져올 수 있게 하는 메소드가 
	 *       setter / getter 메소드
	 *       ex) 선생님은 모든 학생의 성적을 기록하거나 조회해야하기 때문임.

	 */
	
	public static void main(String[] args) {

		Student hong = new Student();
		
		//hong.name = "홍길동";
		//hong.age = 13; // 필드에 대한 직접적인 접근 차단
		//직접 접근을 막았다면 간접적으로나마 필드에 접근하여 값을 조회/수정 가능하게 하는 방법

		//간접적으로 수정이 가능한 setter 함수 호출
		hong.setName("홍길동");
		hong.setAge(20);
		hong.setHeight(180.1);
		
		//
		System.out.printf("%s님의 나이는 %d이고, 키는 %.1fcm 입니다.\n\n"
				,hong.getName(), hong.getAge(), hong.getHeight());
		
		Student kim = new Student();
		
		kim.setName("김영희");
		kim.setAge(20);
		kim.setHeight(180.3);
		
		System.out.printf("%s님의 나이는 %d이고, 키는 %.1fcm 입니다.\n\n"
				,kim.getName(), kim.getAge(), kim.getHeight());
		
		System.out.println(kim.toString());
	}

}





















