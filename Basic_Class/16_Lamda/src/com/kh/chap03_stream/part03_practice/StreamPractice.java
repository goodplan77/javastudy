package com.kh.chap03_stream.part03_practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {

	static class Student {
		private String name;
		private int age;
		private int score;

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public int getScore() {
			return score;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public Student() {

		}

		public Student(String name, int age, int score) {
			super();
			this.name = name;
			this.age = age;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
		}

	}

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 6, 2, 3, 3, 4, 4, 11, 9, 10);
		List<String> strlist = Arrays.asList("a", "a", "b", "b", "c", "c", "d", "e", "f", "g");
		List<Student> slist = List.of(
				new Student("홍길동", 15, 100),
				new Student("강감찬", 16, 80),
				new Student("이순신", 25, 80),
				new Student("김말똥", 29, 90),
				new Student("아무개", 23, 70));
		String[] wordArr = { "a b c d", "홍 길동", "h el lo wor ld" };
		IntStream dan = IntStream.range(1, 10);

		// 1. list에서 중복을 제거한 후 짝수만 출력하는 프로그램을 만드시오.(스트림활용)
		// 결과 : 6 2 4 10
		list.stream()
			.distinct()
			.filter(n -> n % 2 == 0)
			.forEach(n -> System.out.printf("%d " , n));
		
		System.out.println();

		// 2. list에서 중복을 제거한 후 값이 5 이상이면서 홀수를 오름차순 출력 하는 프로그램
		// 결과 : 9 11
		list.stream()
			.distinct()
			.filter(n -> n >=5)
			.filter(n -> n % 2 != 0)
			.sorted()
			.forEach(n -> System.out.printf("%d " , n));
		
		System.out.println();

		// 3. list에서 각 요소에 3을 곱한후 오름차순 출력하는 프로그램
		// 3 6 9 9 12 12 18 27 30 33
		list.stream()
			.map(n -> n * 3)
			.sorted()
			.forEach(n -> System.out.printf("%d " , n));
		
		System.out.println();

		// 4. strlist에서 각 문자를 대문자로 변경한 후 List로 반환하는 프로그램
		// [A, A, B, B, C, C, D, E, F, G]
		List<String>temp1 = strlist.stream()
									.map(n -> n.toUpperCase())
									.collect(Collectors.toList());
		System.out.println(temp1);
		
		// 5. strlist에서 중복값을 제거후 각 문자를 하나의 문자열로 합쳐서 반환해주는 프로그램
		// abcdefg
		
		String str = strlist.stream()
				.distinct()
				.reduce((s1 , s2) -> s1.concat(s2))
				.get();
		
		System.out.println(str);

		// 6. slist에서 학생의 이름과 나이를 학생이름기 오름차순 정렬하여 출력.
		// 이름: 나이
		// 강감찬 : 16 김말똥 : 29 아무개 : 23 이순신 : 25 홍길동 : 15
		
		slist.stream()
			.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
			.forEach(n -> System.out.printf("%s : %d " , n.getName() , n.getAge()));
		
		System.out.println();
		
		// 7. slist에서 20살 이상인 학생의 평균점수를 구하는 프로그램
		// 80.0
		// System.out.println(score);
		int score = slist.stream()
			.filter(stu -> stu.getAge() >=20)
			.map(stu -> stu.getScore())
			.reduce(0 , (init , n ) -> {
				return init + n;
			});
		System.out.println(score);

		// 8. wordArr내부요소의 공백을 모두 제거한후 List<String>으로 변환하는 프로그램
		// 출력결과 : [abcd, 홍길동, helloworld]
		
		List<String> temp2 = Arrays.stream(wordArr)
									.map(s -> s.replaceAll(" ", ""))
									.collect(Collectors.toList());
		System.out.println(temp2);

		// 9. dan을 활용하여 구구단 2단~9단까지 출력하는 프로그램을 만드시오
		// ex) 2 * 1 = 2
		// 2 * 2 = 4
		
		dan.filter(n -> n>=2)
			.forEach(n -> {
				IntStream.range(1, 10)
						.forEach(a -> {
							System.out.printf("%d * %d = %d\n",n,a, (n*a));
						});
				System.out.println();
			});
			

		// 10. wordArr내부요소의 공백을 제거한 문자열의 길이가 8이상인 요소가 있는지 검사하는 프로그램
		// 출력결과 : true/false값
		
		boolean bool1 = Arrays.stream(wordArr)
							.map(s -> s.replaceAll(" ", ""))
							.anyMatch(s1 -> s1.length() >=8);
		System.out.println(bool1);
	}

}
