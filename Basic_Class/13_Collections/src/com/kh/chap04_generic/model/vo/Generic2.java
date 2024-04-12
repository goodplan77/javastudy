package com.kh.chap04_generic.model.vo;

// 제네릭의 extends 클래스간의 상속의 개념이 아니라 , 저장할 자료형을 "제한" 시키는데 사용한다.

// <T extends Parent> : Parent 본인이나 , Parent 클래스를 상속 받은 자료형만 올 수 있다는 뜻.
public class Generic2<T /*extends Parent*/> {

	private T generic; // new T(); 제네릭 타입 변수로는 객체 생성 불가

	public void printing() {
		// generic.doPrinting(); // Parent 에 존재하는 doPrinting() 호출 가능
	}

	public T gerGeneric() {
		return generic;
	}

	public void setGeneric(T generic) {
		this.generic = generic;
	}

	public static void main(String[] args) {
		Generic2<Parent> parent = new Generic2<>();
		Generic2<Parent> child1 = new Generic2<>();
		Generic2<Parent> child2 = new Generic2<>();
		// Generic2<String> etc = new Generic2<>(); // 타입 오류
		// Generic2<Object> etc = new Generic2<>(); // 객체 생성 불가. T가 가질수 있는 최고 클래스가 Parent임.
		
		parent.setGeneric(new Parent());
		parent.printing();
		
		child1.setGeneric(new Child1());
		child1.printing();
		
		/*
		 * 와일드 카드 사용하기
		 * Generic2에 들어가야할 자료형을 모르는 경우 ?로 대체가 가능
		 * 단 ?(와일드카드) 의 경우 들어가야할 자료형을 모르는 타입으로 지정되기 때문에 여러가지 문제점이 있음.
		 */
		Generic2<?> unknown = new Generic2<>();
		// unknown.setGeneric(new Parent());
		// ?는 자료형의 범위가 정해져 있지 않은 상태임. 따라서 올바른 값이 들어갔는지 논리적으로 검사가 불가능함.
		// ?의 값의 범위가 무한 하기 때문. 따라서 ?의 범위를 제한 함으로써 추가적인 사용이 가능하다.
		
		// 1. extends를 통한 와일드 카드 범위제한. (상한 경계 설정)
		// ? : Parent or Child1 or Child2 or.....?
		Generic2<? extends Parent> unknown2 = new Generic2<>();
		// unknown2.setGeneric(new Parent()); 오류 발생
		// unknown2.setGeneric(new Child1()); 오류 발생
		// 즉 , ? 사용시 제네릭에 값을 대입하기 위한 용도로 extends를 통해 제한 하는 것은 좋은 방법이 아님 (안됨)
		Parent p = unknown2.gerGeneric(); // 값을 추출하는데 있어서는 문제 없음.
		
		// 2. super를 활용한 와일드 카드 범위 제한 (최소 클래스 지정)
		// ?의 범위는 Parent , Parent의 조상들로 제한
		// ? : Parent 의 조상클래스 , Object
		Generic2<? super Parent> unknown3 = new Generic2<>();
		unknown3.setGeneric(new Parent());
		unknown3.setGeneric(new Child1());
		// ?가 Parent든 , Parent의 조상이든, Object든 다형성이 발생 즉, 다형성의 특징 (업캐스팅)을 이용해서
		// 자료형이 가지는 최소 클래스를 부모 클래스로 설정 한것.
		// Parent p2 = unknown3.gerGeneric(); // Parent 보다 상위클래스도 ? 의 범위에 들어가므로 문제 발생
		
		
	}

}

class Parent {

	public void doPrinting() {
		System.out.println("부모 클래스 함수");
	}

	public String toString() {
		return "부모 클래스";
	}

}

class Child1 extends Parent {
	public void doPrinting() {
		System.out.println("자식1 함수");
	}

	public String toString() {
		return "자식1";
	}
}

class Child2 extends Parent {
	public void doPrinting() {
		System.out.println("자식2 함수");
	}

	public String toString() {
		return "자식2";
	}
}
