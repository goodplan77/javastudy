package com.kh.chap02_map.part01_hashMap.model.vo;

import java.util.Objects;

public class Snack {
	
	private String flavor;
	private int calory;
	
	public Snack() {
		
	}

	public Snack(String flavor, int calory) {
		super();
		this.flavor = flavor;
		this.calory = calory;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getCalory() {
		return calory;
	}

	public void setCalory(int calory) {
		this.calory = calory;
	}
	
	/*
	 * equals() ?
	 * Object의 equals() 메소드는 주소값과 주소값 간의 동등 비교
	 * 
	 * 주소값 == 주소값 이 아닌 , 실제 참조 하고 있는 주소값은 다르더라도 , 두 객체간의 필드 값이 동일한 경우
	 * 동일한 객체로 취급 하고 싶다면 equals() 메소드를 오버라이딩 해줘야 함.
	 * 
	 * 즉 , 객체간의 필드값이 동일하다면 true가 나올 수 있도록 작성할것.
	 */
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 같은 객체를 참조 한 경우
			return true;
		if (obj == null) // 매개변수로 받아온 객체가 null 인 경우
			return false;
		if (getClass() != obj.getClass()) // Snack.class != ??.class 비교
			// 객체 정보를 서로 비교. 현재 객체가 참조 하고 있는 객체 와 받아온 객체가 참조 하고 있는 정보 비교
			return false; // obj instanceof Snack
		Snack other = (Snack) obj;
		return calory == other.calory && Objects.equals(flavor, other.flavor);
	}
	
	/*
	@Override
	public boolean equals(Object o) {
		// 만약 매개변수로 넘어온 객체가 Snack이 아닌경우 ClassCastException 가 발생 할 수 있음.
		if(!(o instanceof Snack)) {
			return false; // 다른 객체 참조한 경우. ClassCastException 도 예외 처리 가능함?
		}
		
		Snack other = (Snack) o;
		if(!this.flavor.equals(other.flavor)) {
			return false;
		}
		
		if(this.calory != other.calory) {
			return false;
		}
		
		return true;
	}
	*/
	
	/*
	 * hashCode() ? 
	 * 오브젝트에서는 객체가 저장된 주소값을 10진수로 변환해주는 함수.
	 * 메모리 내에서 고유한 값을 가져야 하는게 hashCode함수. hashCode로 반환된 값이 같다면 같은 객체.
	 * 
	 * 객체를 식별하는데 사용하는 고유한 값이 hashCode.
	 * 
	 * 이 함수를 오버라이딩 할때도 hashCode 값이 같은 두 객체는 논리적으로 동일하다는 의미를 가지게 만들어야함.
	 * 두 객체간의 필드값이 동일하다면 같은 hashCode 값이 반환되도록 오버라이딩 해야 함.
	 * ==> 필드 값을 통해 hashCode 값을 만든다.
	 */
	
	@Override
	public int hashCode() {
		
		final int PRIME = 31; // 소수 -> 11111 연산속도가 빠른 소수중에 하나.
		
		int result = 1; // 결과값 반환해줄 변수
		
		result = result * PRIME * calory;
		
		result = result * PRIME * (flavor == null ? 0 : flavor.hashCode());
		
		// 필드의 갯수 만큼 추가로 작업.
		// result = result * .....
		
		return result;
		
		// hash 자바 7버전에서 만들어짐
		// return Objects.hash(calory, flavor);
	}
	
	/*
	 * equals & hashcode는 동시에 오버라이딩 해야함.
	 * equals 함수는 객체와 객체간의 동등성을 비교하는 메소드.
	 * hashCode 함수는 hash 기반 자료구조인 hash table에서 객체를 "저장"하거나 "검색"시 사용하는 함수.
	 * 
	 * hash 테이블 ?
	 * 배열을 기반으로 하는 자료구조로 배열에 저장시킬 각 요소들에 대해서 hashCode() 함수를 호출하여 배열내부에
	 * 저장시킬 "인덱스" 값을 구한다. => 일반적인 계산공식 [hashCode() 반환값 % 배열의 길이]
	 * 
	 * 따라서 두 객체간의 hashCode 값이 같다면 같은 저장공간을 할당 받음. 데이터 중복을 피할 수 있음.
	 * 		두 객체간의 hashCode 값이 같다면 같은 자료 이므로 , equals 메서드도 true 여야 하고,
	 * 		두 객체간의 equals 결과 값이 true 라면 hashcode 값도 같아야한다.
	 */
	

	@Override
	public String toString() {
		return "Snack [flavor=" + flavor + ", calory=" + calory + "]";
	}

}
