package com.kh.chap03_stream.part01_basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBasic {
	/*
	 * 스트림의 정의 및 특징
	 * - Stream ?	데이터의 흐름이라는 뜻으로 스트림 내부의 데이터를
	 * 				다른 스트림으로 보내고 , 보내고 , 보내는 무한한 흐름을
	 * 				만들어 낼 수 있는 클래스.
	 * - 반복문과 조건문을 사용하여 처리 했던 작업들을 람다식을 통해 제어 할 수 있도록 다양한 메소드들을 정의해 두었음
	 * ex)	foreach	: 스트림 내부의 데이터를 단순 반복.
	 * 		filter	: 스트림 내부의 데이터를 조건에 따라 추출하고자 할 때
	 * 		count	: 스트림 내부의 데이터의 개수를 세고자 할 때
	 * 		add , min , max	: 스트림 내부의 값을 다 더하거나 , 최소값 , 최대값을 구하고자 할 때
	 * 		collect	: 스트림 내부의 값을 모아서 원하는 자료구조로 반환 하고자 할 때
	 * 		...
	 * 
	 * -	컬렉션의 요소들에 대한 데이터 처리시 가장 많이 사용 되며, 그 외 일반 배열, I/O를 통해 File로 부터 읽어들인 데이터, 기본자료형
	 * 		들로도 스트림을 생성 할 수 있다. 즉, 다양한 자료구조로 부터 스트림을 생성 할 수 있음.
	 * 
	 * -	각종 자료구조들을 통해 스트림을 생성 할 수 있고 , 일관성 있게 제어 할 수 있는 메소드들을 정의 해둔 클래스가 Stream이다.
	 * 		(자료구조를 추상화한 클래스)
	 * 
	 * -	데이터를 다루기 위한 "중간연산" 과정과 "최종 연산" 과정이 존재함.
	 * 			1) 스트림 생성 및 초기화
	 * 			2) 중간 연산 n회 수행 -> 정렬 , 필터링 , 데이터 변환 작업등...
	 * 			3) 최종연산 1회로 결과값 도출
	 * 
	 * I/O 스트림과는 살짝 다른 개념? , 람다식 활용을 위해 생성된 개념?
	 */
	
	public static void main(String[] args) {
		// 스트림 객체 생성방법
		// 1) 배열을 통한 생성 : 배열을 선언 및 할당한 후 Arrays.stream() 메소드 호출
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		IntStream intStream = Arrays.stream(arr); // IntStream, DoubleStream, LongStream || Stream<T>
		
		String[] sArr = {"Java" , "is" , "fun"};
		Stream<String> strStream = Arrays.stream(sArr); // 참조 자료형은 제네릭에 자료형 지정.
		
		// 2) 컬렉션을 통한 생성 : ArrayList가 제일 많이 사용됨
		// 컬렉션의 메서드 stream()을 호출하여 생성.
		ArrayList<Integer> list = new ArrayList<>();
		Stream<Integer> arrayStream = list.stream();
		
		Set<Integer> set = new HashSet<>();
		Stream<Integer> setStream = set.stream();
		
		// 3) Stream 클래스를 통한 생성
		// 1. empty() -> 내부가 빈 스트림 생성
		Stream emptyStream = Stream.empty();
		
		// 2. <T>builder() : T자료형을 요소로가지는 Stream 객체 생성.
		Stream<String> sStream = Stream.<String>builder()
										.add("A").add("B")
										.build();
		
		// 3. of(T ...E) : 매개 변수로 주어진 요소들을 가지고 Stream 생성
		Stream<String> oStream = Stream.of("a","b","c");
		
		// 4. generate(Supplier<T> S) : 람다식을 통해 작성한 리턴값을 요소로 가지는 Stream
		Stream<String> gStream = Stream.generate(() -> "a").limit(5); // stream의 크기를 지정하지 않으면 무한으로 요소가 생성된다.
		
		// 5. iterate(초기값 , UnaryOperator) : 초기값과 그 초기값을 다루는 람다식을 작성하여 스트림에 들어갈 요소를 추가해주는 메소드
		Stream.iterate(1, (i) -> i+1).limit(5); // [1,2,3,4,5]
		
		// 6. 기본자료형의 Stream을 통한 객체 생성
		IntStream.range(1, 5); // [1,2,3,4];
		IntStream.rangeClosed(1, 5); // [1,2,3,4,5];
		
		
		// 4) 파일스트림을 통한 생성
		
		try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
			Stream<String> lines = br.lines(); // 현재 읽어온 문자열값을 가진 스트림 객체 생성.
			// System.out.println(lines);
			// lines.forEach(word -> System.out.println(word));
			lines.forEach(System.out::println);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// 반복문 vs 스트림
		// 1) 배열을 통한 반복문.
		for(String str : sArr) {
			System.out.println(str);
		}
		
		// 2) 스트림을 통한 반복 출력문.
		sStream.forEach(str -> System.out.println(str));
		
		// 3) 반복문으로 배열을 통해 2 와 4의 배수인 값들의 합 구하기.
		int sum = 0;
		for(int i : arr) {
			if(i%2 == 0 && i%4 == 0) {
				sum += i;
			}
		}
		
		System.out.println("arr 배열의 2 와 4의 배수의 총합 : " + sum);
		/*
		// 4) 스트림을 통해 2와 4의 공배수인 값들의 합 구하기
		// [1,2,3,4,5,6,7,8,9,10]
		IntStream nextStream = intStream.filter(i -> i % 2 == 0); // [2,4,6,8,10] // filter의 값이 true라면 다음 스트림으로 넘어감
		IntStream nextStream3 = nextStream.peek(i -> System.out.println("2의 배수입니까? " + i));
		IntStream nextStream2 = nextStream3.filter(i -> i % 4 == 0); // [4,8]
		IntStream nextStream4 = nextStream2.peek(i -> System.out.println("4의 배수입니까? " + i));
		int sSum = nextStream4.sum();
		//int sSum2 = nextStream2.sum(); 내부 자원을 다 소모.
		System.out.println("intStream의 2와 4의 배수 의 총합 : " + sSum);
		*/
		
		int sSum = intStream
				.filter(i -> i%2 == 0)
				.peek(i-> System.out.println("2의 배수 입니까? " + i))
				.filter(i -> i%4 == 0)
				.peek(i-> System.out.println("4의 배수 입니까? " + i))
				.sum();
		
		/*
		 * 스트림의 요소 처리 특징?
		 * - 최종 연산 전까지 중간연산 과정은 실행되지 않는다.(지연 연산)
		 * - 메모리를 효율적으로 관리하기 위함
		 * - 스트림은 재사용이 불가능함. (소모성)
		 * - 배열이나 컬렉션을 통해 생성된 스트림 사용시, 원본 데이터의 값은 변경 되지 않는다.
		 * 	+ 스트림은 원본데이터의 값을 참조만 함.(readonly)
		 */
	}

}
