package com.kh.chap02_lamda.part04_methodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReference {
	
	/*
	 * 람다식의 메소드 참조 (Method Reference)
	 * -	람다식 구문중 메소드 호출 후 값을 바로 반환하는 구문을 더욱 간결하게 표현 하기 위해 사용한다.
	 * 		예시) (String str) -> str.length();
	 * 
	 * -	람다식을 통해 구현한 기능이 이미 정의 되어있는 클래스의 다른 메소드와 일치하는 경우 ,
	 * 		전체 코드 작성을 직접하지 않고 그 다른 메소드에 이름만 추가시키는 형태로 작성하는 구문.
	 * 		
	 * 		(String str) -> str.length();
	 * 		메소드 참조로 변경시
	 * 		String::length
	 * 
	 * -	메소드 참조 사용방법 및 종류
	 * 		1. static 메소드 참조
	 * 		2. 일반 메소드 참조
	 * 		3. 객체 메소드 참조
	 * 		4. 생성자 참조
	 * 
	 * -	메소드 참조문은 별도의 실행기능이 있는 것은 아니고 컴파일러에 의해
	 * 		class 파일로 저장 될 때 해당 메소드를 참조하여 다시 한번 람다식으로 변환
	 * 		String::length --> (String str) -> str.length();
	 * -	메소드 참조문 사용시 람다식을 더 간결하게 쓸 수있고, 메서드 재사용성을 증가 시킬 수 있음.
	 */
	
	public static void main(String[] args) {
		
		// 사용 예시
		// Consumer<String> printer = s -> System.out.println(s);
		Consumer<String> printer = System.out::println;
		printer.accept("아령하세요");
		
		// 1. static 메소드 참조
		//Function<String , Integer> intParser = (str) -> Integer.parseInt(str);
		Function<String , Integer> intParser = Integer::parseInt;
		System.out.println(intParser.apply("123456789")+1);
		
		// 2. 일반 메소드 참조
		//	1) String length() : 문자열의 길이를 구하는 함수
		// Function<String , Integer> strLength = str -> str.length();
		Function<String , Integer> strLength = String::length;
		String str = "java is fun";
		System.out.println(strLength.apply(str));
		
		//	2) String.equals() : s1.equals(s2);
		// BiFunction<String, String, Boolean> strEquals = (s1,s2) -> s1.equals(s2);
		BiFunction<String, String, Boolean> strEquals = String::equals;
		
		
		// 3. 객체 메소드 참조
		String title = "소나기";
		// Predicate<String> equalsToTitle = s -> title.equals(s);
		// 람다식 외부에서 생성한 객체를 통해 객체내부의 equals 참조
		Predicate<String> equalsToTitle = title::equals;
		System.out.println(equalsToTitle.test("장마"));
		
		// 4. 생성자 메소드 참조
		class Person{
			private String name;
			private int age;
			
			public Person() {
				
			}
			
			public Person(String name) {
				this.name=name;
			}
			
			public Person(String name , int age) {
				this.name=name;
				this.age=age;
			}

			@Override
			public String toString() {
				return "Person [name=" + name + ", age=" + age + "]";
			}
		}
		
		// Supplier<Person> personConstr = () -> new Person();
		Supplier<Person> personConstr = Person::new;
		System.out.println(personConstr.get());
		
		// 매개 변수가 2개 이면서 Person객체를 생성해서 반환 해주는 람다식
		// BiFunction<String , Integer , Person> personConstr2 = (name , age) -> new Person(name,age);
		BiFunction<String , Integer , Person> personConstr2 = Person::new;
		System.out.println(personConstr2.apply("강경호", 30));
		
		/*
		Function<String , Function<Integer , Person>> personConstr3 = (String name) -> {
			return (Integer age) -> {
				return new Person(name , age);
			};
		};
		*/
		
		Function<String , Function<Integer , Person>> personConstr3 = name -> age -> new Person(name,age);
		
		// 컬렉션 내부에 적용된 람다식들
		List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
		System.out.println(list);
		
		// 컬렉션 내부에서 특정 요소를 삭제 해주는 메소드
		list.removeIf(n -> n % 2 == 0);
		System.out.println(list);
		
		// 컬렉션의 특정 요소를 변경
		list.replaceAll(n -> n*100);
		System.out.println(list);
		
		// 컬렉션의 모든 요소 순회
		list.forEach(System.out::println); // 아래와 같은 코드
		// list.forEach(i -> System.out.println(i)); // 위 와 같은 코드
	}

}
