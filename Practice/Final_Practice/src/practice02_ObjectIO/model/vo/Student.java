package practice02_ObjectIO.model.vo;

import java.io.Serializable;

public class Student implements Serializable{
	
	private String name;
	private int age;
	private transient int score;
	
	public Student() {
		
	}
	
	public Student(String name , int age , int score) {
		this.name=name;
		this.age=age;
		this.score=score;
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
		this.age=age;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score=score;
	}
	
	@Override
	public String toString() {
		return name + " " + age + " " + score;
	}

}
