package com.kh.chap02_abstractAndInterface.part02_family.model.vo;

public class Mother extends Person implements Basic{

	private String babyBirth; // 출산 , 입양 , 없음;

	public Mother() {
		super();
	}

	public Mother(String name, double weight, int health, String babyBirth) {
		super(name, weight, health);
		this.babyBirth = babyBirth;
		Basic.humanism(); // 정적메소드 호출방법 : 클래스명.메서드명();
	}

	public String getBabyBirth() {
		return babyBirth;
	}

	public void setBabyBirth(String babyBirth) {
		this.babyBirth = babyBirth;
	}

	public String toString() {
		return super.toString() + ", babyBirth : " + babyBirth;
	}

	@Override
	public void eat() {
		setWeight(getWeight() + 10);
		setHealth(getHealth() + 5);
	}

	@Override
	public void sleep() {
		setHealth(getHealth() + 10);
		setWeight(getWeight() - 5);
	}

	public void run() {
		setHealth(getHealth() + 20);
		setWeight(getWeight() - 10);
	}
	
	@Override
	public void breathing() {
		System.out.println("엄마 숨쉬기");
	}
}
