package com.kh.chap03_class.model.vo;


//클래스에 사용 가능한 접근제한자 : public, default(생략시)
public class Person {

	//필드부
	private String id;
	private String pwd;
	private String name;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	// getter, setter 메소드 자동생성 >> alt+shift+'s' >>generate
	
	// 각 필드에 대입시키고자 하는 값을 전달받아 각 필드에 대입시켜주는 setter 메서드
	// setter 표기법 : set + 필드명(낙타등표기법)
	//				매개변수명은 관례상 필드명과 동일하게 간다.
	
	// 각 필드값을 돌려주는 getter 메소드 생성
	// getter 표기법 : get + 필드명(낙타등 표기법) + 반환형은 반환시키고자 하는 값의 자료형에 맞추어 작성할 것.
	
	// 모든 필드값을 하나의 문자열로 합쳐서 반환해주는 메소드 작성
	// 문자열 형태 : id + ", "+pwd+ ", "+name+ ", "+.....; 
	
		
	
//	public void setId(String id) {
//		this.id = id;
//	}
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public void setGender(char gender) {
//		this.gender = gender;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
//	
//	public String getId() {
//		return id;
//	}
//	
//	public String getPwd() {
//		return pwd;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	
//	public int getAge() {
//		return age;
//	}
//	
//	public char getGender() {
//		return gender;
//	}
//	
//	public String getPhone() {
//		return phone;
//	}
//	
//	public String getEmail() {
//		return email;
//	}
//	
	public String toString() {
		return id + ", "+pwd+ ", "+name+ ", "+age+ ", "+gender+ ", "+phone+ ", "+email;
	}
	
}
