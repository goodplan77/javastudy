package practice02_ObjectIO.model.vo;

import java.io.Serializable;

public class Food implements Serializable{
	
	private String name;
	private int kcal;
	
	public Food () {
		
	}
	
	public Food (String name , int kcal) {
		this.name=name;
		this.kcal=kcal;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getKcal() {
		return kcal;
	}
	
	public void setKcal(int kcal) {
		this.kcal=kcal;
	}
	
	@Override
	public String toString() {
		return name + " " + kcal;
	}

}
