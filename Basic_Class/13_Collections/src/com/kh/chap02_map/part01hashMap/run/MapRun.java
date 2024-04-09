package com.kh.chap02_map.part01hashMap.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap02_map.part01hashMap.model.vo.Snack;

public class MapRun {

	public static void main(String[] args) {
		
		HashMap<String , Snack> hm = new HashMap<>();
		
		/*
		 * HashMap ?
		 * 많은 양의 데이터를 빠르게 저장 하고, 검색하기 위하여 key , value 값을 함께 묶어서 관리하는
		 * Hash Table 알고리즘을 사용한 자료구조
		 * 
		 * 계층 구조를 보면 List나 Set 계열은 Collection을 구현한 클래스. => 데이터 추가시에는 add 메서드 사용.
		 * 단 Map은 => 데이터 추가시 put 메서드 사용 (key value 동시에 저장)
		 * 
		 * Map 특징
		 * 1. key , value 한쌍으로 요소를 구성한다.
		 * 2. key 값을 통해 value에 접근한다.
		 * 3. key 는 중복을 허용하지 않는다. 단 , value는 중복되어도 좋다. 
		 * 4. 동일한 key값으로 데이터를 저장하면 , 마지막으로 추가한 value 로 치환 한다.
		 * 5. 동일한 key값 여부는 hashCode()함수로 판단한다.
		 */
		
		/*
		Snack s1 = new Snack("초코맛",100);
		Snack s2 = new Snack("초코맛",200);
		System.out.println(s1.equals(s2)); // false
		
		Snack s3 = new Snack("초코맛",200);
		System.out.println(s2.equals(s3)); // true
		*/
		
		// 1. put(K key , V value) => map공간에 key + value를 세트로 추가해주는 메소드
		// arr["다이제".hashCode() % length] = new Snack("초코맛",1200);
		
		hm.put("다이제", new Snack("초코맛" , 1200));
		hm.put("칸초" , new Snack("초코맛", 600));
		
		hm.put("새우깡" , new Snack("짠맛" , 500));
		hm.put("포테토칩" , new Snack("짠맛" , 500));
		
		
		System.out.println(hm); // System.out.println(hm.toString()); 오버라이딩
		// 저장 순서 유지 x. value 값은 중복되어도 상관 없음.
		
		hm.put("새우깡" , new Snack("매운맛",700)); // key 값이 중복된 경우 마지막의 value 값으로 치환.
		System.out.println(hm);
		
		// 2. get(Object key) : V => Map 에서 Key값에 저장된 value값을 돌려주는 메소드.
		System.out.println(hm.get("새우깡"));
		
		// 3. size() => 컬렉션에 담겨 있는 갯수
		System.out.println("size : " + hm.size()); // key 값이 중복된 경우 counting 안함.
		
		// 4. replace(K key , V value) => 컬렉션에 해당 key 값을 찾아서 새로 전달된 value로 변경 시켜주는 메소드
		hm.replace("포테토칩", new Snack("겁나짠맛",1000)); // put 과의 차이? 값이 없으면 변경하지 않음
		System.out.println(hm);
		
		// 5. remove(Object key) => 컬력션에 해당 key값을 찾아서 key 값과 value값을 동시에 지워주는 메소드
		hm.remove("포테토칩");
		System.out.println(hm);
		
		System.out.println("-----------------");
		/*
		 * HashMap 을 통한 반복문
		 * 1. keySet : key값만 set에 담기
		 * 
		 * 2. entrySet : key , value 한 쌍을 set에 담기
		 * 
		 * -> keySet , entrySet을 통해 반복문을 사용해야함.
		 * -> for문 사용불가.
		 */
		
		// 1. keySet()
		// 1) keySet을 통해 HashMap에 저장된 key 값들만 Set에 담아서 얻어오기
		// hm.keySet() : Set
		Set<String> keySet = hm.keySet();
		
		// 2) 1번 과정에서 작업된 set을 Iterator에 담기
		Iterator<String> itKey = keySet.iterator();
		
		// 3) Iterator 반복문을 통해 내부 값 추출
		while(itKey.hasNext()) {
			String key = itKey.next(); // "새우깡" , "칸초" , "포테토칩"...
			Snack value = hm.get(key);
			System.out.println(key + " : " + value);
		}
		
		System.out.println("===========");
		
		// 2.entrySet()
		// 1) hm.entrySet() 호출하여 set으로 반환
		Set<Entry<String,Snack>> entrySet = hm.entrySet();
		
		// +) Set은 향상된 반복문 사용가능.
		for(Entry<String , Snack> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// 2) entrySet에 담긴 데이터 Iterator로 담기
		Iterator<Entry<String,Snack>> itEntry = entrySet.iterator();
		
		// 3) 반복문을 활용하여 순차적으로 뽑기
		while(itEntry.hasNext()) {
			Entry<String , Snack> entry = itEntry.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
