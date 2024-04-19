package com.kh.chap02_lamda.part03_FunctionalInterface;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
	
	/*
	 * 함수형 인터페이스
	 * -	람다식을 통해 구현되는 추상 메소드를 가지고 있는 인터페이스로 내부에 오직 1개의 추상메소드만 가지고 있다.
	 * -	람다식을 작성하고 호출 하기 위한 베이스가 되는 함수형 인터페이스들을 자바에서 기본적으로 제공하고 있다.
	 * 
	 * 람다식을 사용하기 위한 작성
	 * 1) 인터페이스 작성 -> 추상메소드 1개 작성
	 * 2) 람다식을 작성 -> 익명 구현 객체 생성
	 * 3) 람다식이 적용된 익명 구현 객체의 메소드 호출
	 * 
	 * 1)번 과정에서 인터페이스를 작성해야하는 번거로움을 줄이기 위해 기본적으로 자바에서 제공하는 함수형 인터페이스들이 있음.
	 * 	-> 제네릭을 사용해서 람다식 작성에 확장성을 높였다.
	 * 
	 * 자바 대표 함수형 인터페이스들
	 * 		인터페이스			|	추상 메소드
	 * -------------------------------------------------
	 * 1.	Runnable		|	run() : void
	 * 2.	Supplier<R>		|	get() : R
	 * 3.	Consumer<T>		|	accept(T) : void
	 * 4.	Function<T,R>	|	apply(T) : R
	 * 5.	Predicate<T>	|	test(T) : boolean
	 * ...
	 */
	
	public static void main(String[] args) {
		// 1. Runnable
		Runnable r = () -> {
			for(int i = 0 ; i < 10 ; i++) {
				System.out.println(new Date());
			}
		};
		
		r.run();
		
		// 2. Supplier : 매개변수 x , 리턴값이 있는 람다식을 구현 할 때 사용함.
		Supplier<Long> supplier = () -> new Date().getTime();
		System.out.println(supplier.get());
		
		// 3. Consumer : 매개변수가 존재하고, 리턴값은 없는 람다식을 구현 시 사용함.
		Consumer<String> consumer = name -> System.out.println("이름 : " + name);
		consumer.accept("경호");
		
		// 4. Function<T,R> : 매개변수 , 리턴 값 존재
		Function<String , Integer> function = str -> str.length();
		System.out.println("안녕하세요의 길이는 ? " + function.apply("안녕하세요"));
		
		// 5. Predicate : 매개변수 가 존재 하고 리턴 타입이 boolean (조건식을 만들때 자주 사용된다)
		Predicate<Integer> predicate = n -> n%3 == 0;
		System.out.println(predicate.test(100));
		
		// 예시
		// 랜덤값을 추출하는 람다식
		Supplier<Integer> random = () -> (int)(Math.random()*100 +1);
		Supplier<Integer> random2 = () -> new Random().nextInt(100) + 1; // 1 ~ 100 사이의 랜덤 값
		
		int randomNo = random.get();
		int randomNo2 = random2.get();
		System.out.println(randomNo + "은 3의 배수 입니까 ? " + predicate.test(randomNo));
		System.out.println(randomNo2 + "은 3의 배수 입니까 ? " + predicate.test(randomNo2));
		
		/*
		 * 실습문제
		 * 위에서 배운 함수형 인터페이스를 활용하여 람다식을 구현해보는 실습
		 * 단 , 불필요한 매개변수나 사용되지 않는 반환값이 없도록 인터페이스를 선택
		 * - 작업 순서 - 
		 * 1) 사용할 인터페이스 선택 (매개 변수 및 반환형 체크하여 선택)
		 * 2) 인터페이스 변수 선언 및 람다식을 통해 익명객체구현
		 * 3) 변수를 통해 추상 메소드 실행
		 */
		
		// 문제 1.현재시각 출력 람다식
		// 출력예시 : 2024-04-19 12:50:00   

		// 문제 2. 오름차순 정렬이 되는 TreeSet객체를 활용하여 6자리 로또번호(1~45)를 생성후 반환해주는 람다식 작성
		//		  생성후 반환받은 로또번호를 출력하시오.
		// 출력예시 : [1, 11, 13, 23, 29, 44]

		// 문제 3.환율계산기 : 원화값(정수)을 입력시 달러값(실수)를 리턴해주는 함수
		// (1달러는 1400원 이라고 가정)
		// 출력예시 : xxxx원은 달러로 xxxx.x$입니다.
		
		// 문제 1번 정답 제시
		Consumer<Date> date1= (date) -> {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println(sdf.format(date));
		};
		date1.accept(Calendar.getInstance().getTime());
		
		/*
		Supplier<String> date2 = () -> {
			Date d1 = Calendar.getInstance().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return sdf.format(d1);
			};
			System.out.println(date.get());
		*/
		
		// 문제 2번 정답 제시
		Supplier<TreeSet> lottery = () -> {
			TreeSet<Integer> s1 = new TreeSet<>();
			while(s1.size() <=6) {
				s1.add((int)(Math.random()*45+1));
			}
			return s1;
			};
		System.out.println(lottery.get());
		
		// 문제 3번 정답 제시
		Function<Integer , Double> function2 = won -> ((double) won / 1400);
		System.out.println(2500 + " 원은 달러로 " + function2.apply(2500) +"$입니다.");
		
	}

}
