package com.kh.chap05_constructor.model.vo;

public class User {

	// 필드부
	private String userID;
	private String userPwd;
	private String userName;
	private int age;
	private char gender;

	/*
	 * 생성자 [표현법] 접근제한자 클래스명([매개변수]) { // 생성자를 통해서 객체 생성시 실현하조가 하는 코드. }
	 * 
	 * 생성자를 작성하는 목적 1. 객체를 생성해주기 위한 목적 2. 객체 생성 + 매개변수로 전달 받은 값을 필드에 초기화 할 목적으로 사용
	 * 
	 * 주의 사항 1. 반드시 클래스명과 동일 해야함(대/소문자 완벽히 동일하게) 2. 반환형이 존재하지 않음. 메서드가 아님 3. 여러개의
	 * 생성자를 작성할수 있지만 , 매개변수가 중복되면 안된다. (메서드 오버로딩) 4. 매개변수 생성자를 명시적으로 작성하게 되면 ,
	 * 기본생성자를 JVM이 자동으로 만들어 주지 않는다.
	 */

	public User() {
		// 객체 생성만을 목적으로 할때 기본생성자 사용
		// 생략 하는 경우 JVM이 자동으로 생성해줌 (만약 명시한 생성자가 없다면 -> 매개변수 있는 생성자?)
		System.out.println("User 기본 생성자");
	}

	public User(String userID, String userPwd, String userName) {
		this.userID = userID;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	
	public User(String userID, String userPwd, String userName , int age , char gender) {
		/*
		 * 중복되는 동일한 초기화 코드가 다른생성자에 존재하는 경우
		 * this()를 이용해 호출가능
		 * 단 , 반드시 생성자 내부 첫줄에 기술
		 */
		this(userID,userPwd,userName);
		this.age = age;
		this.gender = gender;
	}

	// 메서드부
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String toString() {
		return userID + " , " + userPwd + " , " + userName + " , " + age + " , " + gender;
	}

}
