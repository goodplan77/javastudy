package com.kh.chap01_innerClass.part02_static.model.vo;

/*
 * 빌더 패턴을 통한 객체 생성?
 * -	자바에서 기존 객체 생성 방식의 단점을 보안 해주는 새로운 객체 생성 디자인 패턴
 * -	정적 내부 클래스로 외부 클래스 객체를 반환 해주는 방식으로 객체를 생성하는 객체 설계 패턴
 * -	매개변수 있는 생성자가 많아지면 사용을 고려함.
 * -	롬북에서 제공하는 어노테이션으로 손쉽게 구현 된다.
 * 
 * 기존 객체 생성 방식
 * 1)	생성자를 이용한 객체 생성
 * -	객체를 생성할 때 생성자에 매개변수로 데이터를 넣어줘서 객체를 생성했었음.
 * 		단점 ?
 * 		1)	필드가 많아 질수록 생성자를 많이 만들어야 할 수도 있다.
 * 		2) 	매개변수의 정보를 설명 할 수 없기 때문에 잘못된 위치에 데이터를 추가하게 될 위험이 있다.
 * 
 * 2)	setter함수를 이용한 데이터 초기화시
 * -	매개변수있는 생성자를 이용한 객체 생성 방법 보다 매개 변수에 어떤 데이터가 들어가는지 확인이 가능하기 때문에 가독성이 확보됨.
 * -	코드의 길이가 길어질 수 있다.
 * -	객체의 일관성이 깨질수 있다. (전송되는 데이터가 중간에 값이 바뀔수도 있다)	
 * 
 * 빌더클래스를 통해 객체 생성시의 장점
 * 1. 불필요한 생성자 제거
 * 2. 데이터의 순서와 상관 없이 필드 값 초기화 할 수 있음
 * 3. 명시적으로 선언. 가독성이 좋다.
 * 4. 전달되는 매개변수의 값이 어떤 데이터인지 바로 확인 가능함
 * 5. setter함수를 만들지 않으므로 , 객체의 일관성을 유지.
 * 6. build() 함수를 통해 내부의 값들이 올바르게 전달되었는지 검증 가능.		
 */
public class Member {
	
	private String id; // 필수로 초기화 되어야 하는 정보 (null 값 안됨)
	private String name;
	private int age;
	private int phone;
	
	private Member() {
		
	}
	// 필드 내부에 정적 내부 클래스 생성(Builder)
	public static class Builder {
		private String id;
		private String name;
		private int age;
		private int phone;
		
		public Builder(String id) { //생성자로 값을 넣어줌
			this.id = id;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		public Builder phone(int phone) {
			this.phone = phone;
			return this;
		}
		
		// 빌드 메소드
		// 빌더 클래스 내부에 초기화된 값들을 통해 Member 클래스 객체를 생성해서 반환 해주는 메소드
		// 내부의 값들이 제대로 전달 되었는지 검증 할 수 있다.
		public Member build() {
			Member member = new Member();
			if(id == null) {
				return null;
			}
			
			member.id = this.id;
			member.name = this.name;
			member.age = this.age;
			member.phone = this.phone;
			
			return member;
		}
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
	
	

}
