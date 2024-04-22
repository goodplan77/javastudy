package practice03_Collections.run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import practice03_Collections.model.vo.Student;

/*
 * 컬렉션 사용 시나리오
 * 공통적으로 사용할 객체 클래스를 이용하여
 * 1. ArrayList 구현 및 데이터 추가 , 삭제 , 변경 시나리오
 * 2. HashMap 구현 및 데이터 추가 , 삭제 , 변경 시나리오
 */

public class Run {

	public static void main(String[] args) {
		
		List<Student> list1 = new ArrayList<>();
		// 추가
		list1.add(new Student("강경호1" , 30));
		list1.add(new Student("강경호2" , 20));
		list1.add(new Student("강경호3" , 40));
		list1.add(new Student("강경호4" , 25));
		list1.add(new Student("강경호5" , 37));
		list1.add(new Student("강경호6" , 48));
		
		// 삭제
		list1.remove(0);
		System.out.println(list1.get(2).getName());
		
		for(Student s : list1) {
			System.out.println(s.toString());
		}
		
		Iterator<Student> iter = list1.iterator();
		while(iter.hasNext()) {
			int age = iter.next().getAge();
			System.out.println(age);
		}
		
		HashMap<String , Student> hm = new HashMap<>();
		hm.put("강경호", new Student("강경호1" , 30));
		hm.put("강경호", new Student("강경호2" , 40));
		hm.put("남창신", new Student("엄마1" , 50));
		hm.put("남창신", new Student("엄마1" , 60));
		hm.put("강인철", new Student("아빠1" , 30));
		hm.put("강인철", new Student("아빠2" , 50));
		hm.put("강현주", new Student("누나" , 35));
		
		System.out.println(hm.containsKey("강경호"));
		
		Set<String> temp1 = hm.keySet();
		System.out.println(temp1.contains("남창신"));
		System.out.println(temp1.contains("남창싱"));
		
		Set<Entry<String , Student>> temp2 = hm.entrySet();
		Iterator<Entry<String , Student>> iter2 = temp2.iterator();
		while(iter2.hasNext()) {
			System.out.println(iter2.next().getValue().getName());
		}
	}

}
