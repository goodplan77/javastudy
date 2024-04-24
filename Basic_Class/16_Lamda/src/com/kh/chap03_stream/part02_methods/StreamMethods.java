package com.kh.chap03_stream.part02_methods;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethods {
	
	/*
	 * 스트림은 중간 연산 메서드 , 최종연산 메서드들.
	 * 
	 * 자주 사용되는 중간 연산 메서드들. 매개변수로 람다식을 받은 후 메서드 내부에서 연산 처리시 사용됨.
	 * 1) distinct	: 중복값 제거
	 * 2) filter	: 내부 요소 필터링
	 * 3) map		: A값을 매개변수로 받아서 B값을 반환 (데이터 변환 작업)
	 * 4) peek		: 중간 확인 메서드. 현재요소를 가져와서 원하는 작업 처리 가능
	 * 5) sort		: 정렬 메서드
	 * ...
	 * 
	 * 최종연산 메서드들
	 * 1) Iterating		: forEach -> 요소를 단순 반복
	 * 2) Collecting	: collect(Collectors.?) -> 스트림내부 요소를 List,set,array 계열 등으로 반환
	 * 3) Calculating	: min , max , sum , average ... -> 최소 최대 값들 산술연산시 사용하는 최종연산 메서드
	 * 4) Matching		: anyMatch , noneMatch , allMatch .. -> 스트림 내부 요소들에 특정 조건을 만족하는지 검사하는 메서드들
	 * 5) Reduction		: reduce 라는 메서드를 사용해서 요소 내부의 값을 다양한 방법으로 연산 후 결과값을 반환.
	 * 					  Calculating 메서드가 아닌 개발자가 직접 연산과 관련된 코드를 쓸 때 사용함.
	 */
	
	public static void main(String[] args) {
		StreamMethods sm = new StreamMethods();
		//sm.test1();
		//sm.test2();
		//sm.test3();
		//sm.test4();
		sm.test5();
	}
	
	public void test1() {
		// 중간 처리 메서드들 + forEach
		// 1) distinct , filter
		List<Integer> list = List.of(1,2,2,6,7,8,8,4,4);
		list.stream()
			.distinct()
			.filter(num -> num%2 !=0)
			.forEach(System.out::println);
		
		String[] names = {"강감찬","강원래","홍길동","강형욱","초난강"};
		Arrays.stream(names)
				.filter(name -> name.startsWith("강"))
				.forEach(System.out::println);
		
		// 2) map : 데이터 변환 시 사용. 현재 요소(T)를 받아서 다른 요소(R) 로 바꿔주는 메소드
		List<Integer> list2 = Arrays.asList(1,2,3,4,5);
		list2.stream()
			.map(n -> n*10) // 1->10 . 2->20 , 3->30
			.map(n -> n*3) // 1->10 . 2->20 , 3->30
			.forEach(System.out::println);
		
		List<Integer> another = list.stream()
									.map(n -> n*3)
									.collect(Collectors.toList());
		System.out.println(another); // 원본 데이터 확인시 그대로. 스트림은 원본 데이터 참조만 하고 실제 변경은 하지 않음.
		System.out.println(list);
		
		// 문자열 -> 정수형 mapToInt , map
		Stream.of("홍길동" , "강감찬" , "이순신") // Stream<String>
				// .map(str -> str.length()) // Stream<Integer>
				.mapToInt(str -> str.length()) // IntStream -> 기본연산 메서드 사용 가능? (sum , average)
				.forEach(System.out::println);
	}
	
	public void test2() {
		// 최종연산 메서드
		// Collecting 계열
		
		// 1) collect(Collectors.toList()) -> 스트림 내부 요소를 List로 변환
		List<Integer> list4 = Arrays.asList(1,2,3,4,5,4,3,2,1);
		List<Double> result1 = list4.stream()
									.map(n -> Math.pow(n, 2))
									.collect(Collectors.toList());
		System.out.println(result1);
		
		// 2) collect(Collectors.toSet()) -> 스트림 내부 요소를 Set로 변환
		Set<Integer> result2 = list4.stream()
									.filter(n -> n % 2 == 0)
									.collect(Collectors.toSet());
		System.out.println(result2);
		
		// 3) collect(Collectors.toMap(Function,Function)) : 스트림의 결과 값을 Map으로 변환시 사용
		Map<Integer , String> result3 = list4.stream()
												.distinct()
												.collect(Collectors.toMap(n -> n, n -> n + "" + n + n)); // 1 : 111 , 2 : 222 , 3 : 333 ...
		System.out.println(result3);
	}
	
	public void test3() {
		// Calculating 계열 -> 산술 연산
		
		// 1) sum
		int sum = IntStream.range(1, 10) // 1 ~ 9
				.sum();
		System.out.println(sum);
		
		// 2) average
		double age = IntStream.rangeClosed(1, 100) // 1 ~ 100
				.filter(n -> n % 2 == 1 /* && n % 2 == 0 */)
				.average()
				// 반환형 OptionalDouble
				// OptionalDouble 은 값이 있을수도 있고 없을 수도 있는 객체를 반환해줌
				// OptionalDouble 내부에 값이 없다면 NoSuchElements 에러 발생
				
				.orElse(0); // 값이 존재하면 그대로. 아니면 매개변수의 값 반환
				// .getAsDouble(); // 무조건 반환
				
		System.out.println(age);
		
		// 3) summaryStatistics :	스트림요소에 대한 통계값을 가진 객체를 반환
		//							(통계값: 총개수 , 합 , 최소 , 최대 , 평균값)
		IntSummaryStatistics summary =  IntStream.of(32,50,88,77,100,27,33)
					.summaryStatistics();
		System.out.println(summary);
		System.out.println(summary.getAverage());
	}
	
	public void test4() {
		// Reduction
		// reduce (초기값 , 각 요소를 처리하는 연산 로직)
		// BinaryOperator : 매개 변수 2개와 리턴 값이 있는 FUNCTION 자료형이 모두 같음. (T,T) -> T
		
		int result1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10)
				.stream()
				.reduce(0 /*초기값*/ , (init , n) -> {
					System.out.println("현재 init값 : " + init + ", 현재 n 값 : " + n);
					return init + n;
				});
		/*
		 * init + n = return
		 * 0 + 1 = 1
		 * 1 + 2 = 3
		 * 3 + 3 = 6
		 * 6 + 4 = 10
		 * ...
		 */
		
		System.out.println("최종 result값 : " + result1);
		
		// 기존 반복문으로 표현
		/*
		int init = 0;
		for(int i = 1 ; i <=10 ; i++) {
			init += i;
		}
		System.out.println(init);
		*/
		
		// 기존 향상된 반복문으로 표현
		/*
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		int init = 0;
		for(int i : list) {
			init += i;
		}
		System.out.println(init);
		*/
		
		result1 = Arrays
				.asList(1,2,30,4,15,67,7,8,9,10)
				.stream()
				.reduce(0, (max , n) -> max > n ? max : n);
		System.out.println("최대 값 ?" + result1);
		
		class Member {
			String name;
			int age;
			
			public Member() {
				
			}
				
			public Member(String name, int age) {
				super();
				this.name = name;
				this.age = age;
			}

			public String getName() {
				return name;
			}
			public int getAge() {
				return age;
			}
			public void setName(String name) {
				this.name = name;
			}
			public void setAge(int age) {
				this.age = age;
			}

			@Override
			public String toString() {
				return "Member [name=" + name + ", age=" + age + "]";
			}
			
		}
		
		List<Member> arr = Arrays.asList(
				new Member("홍길동",33),
				new Member("신사임당",40),
				new Member("임꺽정",45),
				new Member("이순신",80),
				new Member("세종대왕",23)
				);
		
		// Member 객체에서 최고령자 구하기.
		// reduce 함수에 초기값 지정을 안해주면 , 스트림의 첫번째 요소가 초기값으로 지정됨.
		Member maxAgePerson = arr.stream()
								.reduce(/*new Member() , */(m1 , m2) -> {
							System.out.println("m1 ? " + m1 + " , m2 ? " + m2);
							
							return m1.age > m2.age ? m1 : m2;
						}).get();
					
		System.out.println(maxAgePerson);
		
		// Member 객체에서 나이값의 총 합 구하기
		int sumAge = arr.stream()
			.map(m -> m.age)
			.reduce(0 , (init , age) -> {
				return init + age;
			});
		
		System.out.println(sumAge);
	}
		
	public void test5() {
		// Matching 계열
		
		// 1) anyMatch ? 스트림의 요소중 Predicate 결과가 하나라도 true 면 true 리턴
		boolean bool = Arrays
							.asList("1" , "b2" , "c" , "d4" , "5")
							.stream()
							.anyMatch(str -> {
								System.out.println(str);
								return str.startsWith("b");
							}); // and 연산의 특징 -> 중간에 참 값이 나오면 다음 연산 중지 하고 종료
							
		System.out.println("anyMatch=" + bool);
		
		// 2) noneMatch 스트림의 요소 모두가 Predicate에 만족하지 않으면 true 리턴
		bool = Arrays
					.asList("홍길동!!" , "가나다" , "123")
					.stream()
					.noneMatch(str -> {
						System.out.println(str);
						return str.length() > 3;
					}); // and 연산의 특징 반영
					
		System.out.println("noneMatch=" +bool);
		
		// 3) allMatch 스트림의 요소가 모둔 조건식에 만족하면 true 리턴.
		bool = Arrays
				.asList("홍길동" , "가나다" , "123")
				.stream()
				.allMatch(str -> {
					System.out.println(str);
					return str.length() == 3;
				});

		System.out.println("allMatch=" +bool);
		
		// 4) findFirst : 스트림 요소에서 첫번째 요소를 찾으면 스트림 종료.
		String str = Arrays
						.asList("홍길동" , "123" , "간다")
						.stream()
						//.sorted()
						.findFirst() // Optional : 값이 없을 수도 있음
						.get(); // 값이 존재하면 반환. 아니면 에러 반환
		System.out.println(str);
		
		// 5) findAny : 스트림 요소를 하나라도 찾는 다면 해당 요소를 즉시 반환 후 종료
		str = Arrays
					.asList("홍길동" , "123" , "123")
					.stream()
					.filter(s -> s.equals("123"))
					.findAny()
					.get();
		System.out.println(str);
	}
}
