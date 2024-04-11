package com.kh.chap03_set.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.kh.chap03_set.model.vo.Student;

public class SetRun {
	
	/*
	 * Collection - Set - HashSet
	 * 중복을 허용하지 않는다.
	 * 저장된 순서를 보장하지 않는다.
	 * 
	 * LinkedHashSet : 저장된 순서를 유지. (중복을 허용하지 않음)
	 * TreeSet : 오름차순 정렬지원(중복을 허용하지 않음)
	 */

	public static void main(String[] args) {
		
		HashSet<String> hs1 = new HashSet<>();
		
		// 값 추가 : add(추가할 값)
		hs1.add("반갑습니다");
		hs1.add("반갑습니다");
		hs1.add("여러분들");
		hs1.add("죄송해요");
		
		System.out.println(hs1);
		
		// 크기 구하는 함수 : size()
		System.out.println("hs1의 크기 ? : " + hs1.size());
		
		// 값 삭제 : remove(삭제할 값)
		hs1.remove("반갑습니다");
		System.out.println(hs1);
		
		// clear()
		hs1.clear();
		System.out.println(hs1);
		
		HashSet<Student> hs2 = new HashSet<>();
		
		hs2.add(new Student("홍길동",25,60));
		hs2.add(new Student("김영희",23,80));
		hs2.add(new Student("김철수",24,90));
		hs2.add(new Student("홍길동",25,60));
		
		System.out.println(hs2);
		System.out.println(hs2.size());
		
		/*
		 * 저장 순서 유지 x , 중복 검사 o
		 * 값이 추가 될 때 , equals() 와 hashCode() 를 통해 같은 값인지 비교를 수행하고 , 둘다 결과가 true면 동일 객체로 판단함.
		 * 
		 * HashSet에 객체를 담을 때 내부적으로 equals() 로 비교 수행. + hashCode() 값도 일치하는 지 비교.
		 * 
		 * 만약 equals와 hashCoDE 메소드를 오버라이딩 하지 않았다면, Object의 두 메소드가 실행이 될 것이고,
		 * Object equals() 메소드는 주소값을 가지고 동등비교를 수행하는 메소드이며 , hashCode() 메소드는 주소값을 10진수로
		 * 바꿔주는 함수 이므로 무조건 서로 달느 객체로 인식 해버린다.
		 * 따라서 두 필드값을 가지고 동등비교를 수행 할 수 있도록
		 * equals 와 hashCodㄷ 메소드를 오버라이딩 해줘야 한다.
		 */
		
		// Set 으로 반복문 돌리기
		// 1. 향상된 for문 사용 가능
		for(Student s : hs2) {
			System.out.println(s);
		}
		
		// 2. ArrayList에 담아주기
		// ArrayList로 변환 후 입맛에 맞게 반복문 돌리면 됨.
		ArrayList<Student> list = new ArrayList<>(hs2);
		System.out.println(list);
		
		// list.get(0).setAge(90);
		
		ArrayList<Student> list2 = new ArrayList<>();
		list2.addAll(hs2);
		
		System.out.println(list2);
		System.out.println(hs2);
		
		// 3. Iterator 반복자를 이용한 반복문도 사용 가능.
		// -------------------------------------
		
		// LinkedHashSet
		Set<Integer> set1 = new LinkedHashSet<>(); // 순서 유지가 되는 set
		
		set1.add(34);
		set1.add(11);
		set1.add(4);
		set1.add(100);
		
		System.out.println(set1);
		
		// TreeSet
		// 오름차순 정렬을 지원해주는 Set ->	객체안에 데이터가 추가 될 때 compareTo, compare 함수를 자동으로 호출해야함
		//								정렬기준을 새롭게 추가하려면 Comparator 인터페이스를 통해 새롭게 정렬기준을 구해야함				
		//
		Set<Student> set2 = new TreeSet<>(hs2);
		System.out.println(set2);
		

	}

}
