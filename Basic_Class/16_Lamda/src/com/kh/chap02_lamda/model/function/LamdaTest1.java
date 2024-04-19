package com.kh.chap02_lamda.model.function;

/*
 * @FunctionalInterface
 * -	함수형 인터페이스를 선언 할 때 사용한는 어노테이션
 * -	내부적으로 딱 1개의 추상 메소드만 가질 수 있음.
 * -	람다식에서 사용할 인터페이스가 반드시 FunctionalInterface를 써야 하는 건 아니나 , 
 * 		추가해두면 추후 컴파일 에러를 방지 할 수 있음.
 */
@FunctionalInterface
public interface LamdaTest1 {
	
	int add(int x , int y); // 실제 코드 구현은 람다식으로 구현 될 예정.
	
	// void print(String x);

}
