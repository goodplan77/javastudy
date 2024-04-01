package com.kh.chap02_abstractAndInterface.part01_basic.model.vo;

public abstract class Sports {

	private int people; // 스포츠를 참여하는 선수

	public Sports() {

	}

	public Sports(int people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "Sports [people=" + people + "]";
	}
	
	/*
	 * 몸통부가 존재하지 않는 미완성 메소드 == 추상 메소드
	 * 몸통부가 없는 미완성 메소드 정의시 abstract 키워드를 써야한다.
	 * 
	 * 그리고, 미완성 메소드가 하나라도 포함된 순간 , 포함된 클래스도 미완성클래스 (추상클래스) 롤 만들어 줘야 한다.
	 */

	public abstract void rule();
	
	public void enterPlayer() {
		System.out.println(people + "명의 선수들이 입장합니다.");
	}
	
	public void startGame() {
		System.out.println("경기 시작");
	}
	
	public void endGame() {
		System.out.println("경기 종료");
	}
	
	// 템플릿 메소드
	// - 추상 클래스로 프레임워크 설계시 자주 사용되는 설계패턴중의 하나 , 전체적인 흐름을 메서드 내부에 기술 한 후,
	// 클래스를 상속받는 자식 클래스마다 다르게 구현되어야 하는 부분은 추상메소드로 구현 하도록함.
	
	public final void start() {
		rule();
		enterPlayer();
		startGame();
		endGame();
	}
}
