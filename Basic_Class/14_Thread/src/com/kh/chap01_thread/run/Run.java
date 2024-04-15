package com.kh.chap01_thread.run;

import com.kh.chap01_thread.thread.Runnable1;
import com.kh.chap01_thread.thread.Thread1;

public class Run {
	/*
	 * 프로그램
	 * - 어떤 프로세스(작업)를 실행 할 수 있는 파일 (cpu를 할당 받지 않은 상태)
	 * 
	 * 프로세스
	 * - 현재 동작하고 있는 프로그램(작업을 위한 cpu를 할당 받음)
	 * 
	 * 스레드
	 * - 한 개의 프로세스 내에서 실제로 작업을 수행하는 소 단위
	 * - 모든 프로세스에는 한 개 이상의 스레드가 존재하여 작업을 수행함.
	 * - 스레드는 메인 스레드와 n개의 일반 스레드가 존재함. (기존 수행 코드는 메인 스레드 1개로만 작업함)
	 * 
	 * 싱글 스레드
	 * - 메인 스레드 1개를 가지고 작업을 처리함. 한 작업씩 순차적으로 처리
	 * 
	 * 멀티 스레드
	 * - 메인 스레드 외 추가적인 스레드를 이용하여 동시에 여러 작업을 처리
	 * 
	 * 멀티 스레드의 장점
	 * 1)	자원을 보다 효율적으로 사용 가능
	 * 2)	사용자 입장에서 일처리가 빠르게 보인다 (응답성 향상)
	 * 3)	작업이 분리되어 코드가 간결해진다.
	 * 		쓰레드 별로 다른 작업을 구현시켜 코드를 분리 할 수 있음.
	 * 4)	CPU를 효율적으로 사용 가능.
	 * 		싱글 스레드 환경에서는 작업 완료시 까지 CPU가 대기해야 하는데 ,  멀티스레드 환경에서는 여러작업이 동시에
	 * 		수행 되므로 CPU 대기 시간이 줄어듦.
	 * 
	 * + 멀티코어 환경? 에서는 조금 더 빠름? (싱글 코어에서는 스레드를 나눠도 총 작업시간은 똑같음?)
	 * 
	 * 멀티 스레드의 단점
	 * 1)	스레드간에 공유자원이 존재 할 경우 "동기화"를 신경 써줘야함
	 * 2)	동기화 처리시 "교착상태" (데드락) 가 발생하지 않게 끔 주의 해줘야함
	 * 3)	프로그램이 복잡해짐
	 * 
	 */

	public static void main(String[] args) {
		// 싱글 스레드
		// 항상 앞 라인의 명령문이 다 끝나고 나서 다음 코드가 실행.
		
		
		for(int i = 1 ; i <= 100 ; i++) {
			System.out.println("메인 스레드 1[" + i + "]");
		}
		
		for(int i = 1 ; i <= 100 ; i++) {
			System.out.println("메인 스레드 2[" + i + "]");
		}
		
		
		// 현재 작업으로 멀티스레드 환경을 만드려면 필요한 스레드 개수 ? 메인 스레드 + 1
		
		// 스레드 생성 방법
		// 1) Thread 클래스 상속
		Thread th1 = new Thread1();
		
		// 스레드의 이름을 지정
		th1.setName("스레드 1");
		
		// 스레드 시작
		// th1.run(); // 메인 스레드의 Stack에 run()메서드 추가된것. 스레드는 아직 메인 스레드 1 개임.
		th1.start(); // 스레드 추가. 현재 스레드 2개 존재. Stack에 저장공간 할당 받고 , run 메소드 호출.
	
		// 2) Runnable 인터페이스 구현.
		Thread th2 = new Thread(new Runnable1()); // 스레드 생성시 매개변수로 받아온 객체로 생성함?
		
		th2.setName("스레드 2");
		th2.start();
		
		// 1) vs 2) 차이
		// 1 : Thread 클래스를 상속 받는 Thread1 자식 클래스
		// -> Thread에 있는 run()을 오버라이딩한 Thread1 의 run() 메소드 실행. 해당 내부 코드 실행
		// -> super() 통한 부모 객체 접근 이 가능함?
		// 2 : Runnable 인터페이스를 구현 하는 Runnable1 클래스
		// -> Runnable1 에 있는 run() 메소드 오버라이딩
		// -> Thread.currentThread -> 정적 메소드 접근을 통한 현재 스레드 접근
		// new Thread(new Runnable1())
		// -> 스레드 생성시 매개변수로 받아온 객체를 통해 스레드를 생성함
		// ? -> 만약 new Thread(); 로 실행하면? 상위 Thread 객체의 경우 run() 부분이 아무것도 구현이 안되어 있음
		// -> 인터페이스 구현을 통해 생성시 전부다 상속을 받을 필요 없이 특정 부분만 받아오는식으로?
		
		// 3) 	Runnable 인터페이스 구현 (내부 클래스를 통한 구현)
		//		클래스는 메서드 내부든 , 클래스 내부든 어디서든 생성 가능함. 이때 메서드 내부에 존재하는 클래스는
		//		내부 클래스라고 부름
		class Runnable2 implements Runnable {

			@Override
			public void run() {
				for(int i = 1 ; i <= 100 ; i++) 
					System.out.println(Thread.currentThread().getName() + "[" + i + "]");
			}
			
		}
		
		Thread th3 = new Thread(new Runnable2());
		th3.setName("스레드 3");
		th3.start();
		
		// 4)	익명 내부 클래스를 통한 생성
		/*
		 * 익명 클래스 ?
		 * 내부클래스를 작성 할 때 클래스 정의 없이 곧바로 객체를 생성하는 방식.
		 * 즉 , 지역 내부클래스의 코드를 간결하게 표현 한것이 익명 내부 클래스
		 * 
		 * [표현법]
		 * new 상위 클래스 생성자 () {
		 * 		상위 클래스 메소드 오버라이딩
		 * }
		 */
		// class 클래스명 implements Runnable + new 클래스명() => new Runnable() {코드 구현}
		Thread th4 = new Thread(new Runnable() {
			// 익명 클래스 내부.
			int a; // 익명 클래스의 필드.
			@Override
			public void run() {
				for(int i = 1 ; i <= 100 ; i++) {
					System.out.println(Thread.currentThread().getName() + "[" + i + "]");
				}
				throw new RuntimeException();
			}
		});
		th4.setName("스레드 4");
		th4.start();
		
		// 5)	람다식 활용
		Thread th5 = new Thread(() -> {
			for(int i = 1 ; i <= 100 ; i++) {
				System.out.println(Thread.currentThread().getName() + "[" + i + "]");
			}
		});
		// 람다식?
		// Runnable 내에 구현해야할 메소드가 하나 밖에 없음 -> 메소드명 생략 해도됨?
		
		th5.setName("스레드 5");
		th5.start();
		
		/*
		 * 알아 볼 수 있는 스레드의 특징들
		 * 1.	스레드는 여러개 동시에 실행 가능하다. ==> 스레드는 동시성의 특징을 가지고 있음. ==> 더 빠른 반응성을 가져다 준다.
		 * 2.	메인스레드가 종료되더라도 실행중인 스레드가 존재하는 경우 프로세스는 종료되지 않는다.
		 * 3.	매번 결과가 다르게 보인다. => 각 스레드의 실행시점을 결정해주는 스케쥴러가 따로 존재 하기 때문.
		 * 4.	하나의 스레드에서 예외가 발생하더라도 다른 스레드에 영향을 끼치지 않는다. (독립성)
		 * 		=> 개별적인 실행 흐름을 보장하기 위해서 스레드별로 Stack 저장공간을 할당 받음.
		 */
		
		System.out.println("메인 스레드 종료 지점.");
	}

}
