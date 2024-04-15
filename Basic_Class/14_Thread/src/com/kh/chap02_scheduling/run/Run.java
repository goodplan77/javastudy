package com.kh.chap02_scheduling.run;

import com.kh.chap02_scheduling.thread.*;

public class Run {
	/*
	 * 스레드 스케쥴링
	 * 스레드의 작업순서를 조절하는 방법
	 * 
	 * 1) 우선순위 기반 스케쥴링
	 * 		- 스레드 마다 우선순위를 부여하는 방식
	 * 		- 우선순위가  더 높은 스레드가 작업시간을 더 많이 할당 받을 수 있음.
	 * 		- 코드로 우선순위 부여가 가능.
	 * 
	 * 2) 순환 할당 방식 스케쥴링 (OS의 기본 스케쥴링 방식) --> Round Robin 방식
	 * 		- 각 스레드에게 시간 할당량을 정하여 스레드를 정해진 시간만큼 실행시키는 방식
	 * 		- 우선순위가 같은 스레드에는 순호나 할당방식이 적용
	 * 		- 코드로 제어 불가능. => os가 관리함
	 * 
	 * 코드로 가능한 것은 스레드 생성 , 실행 , 중지 , 우선순위 설정 정도만 가능함
	 */

	public static void main(String[] args) {
		
		Thread car = new Thread(new Car() , "Car");
		Thread plane = new Thread(new Plane() , "Plane");
		Thread tank = new Thread(new Tank() , "Tank");
		
		// 스레드는 기본적으로 5의 우선순위를 가지고 있다. (1 ~ 10)
		System.out.println("--- 우선 순위 변경 전 ---");
		System.out.println(Thread.currentThread().getName() + "의 우선순위 : " + Thread.currentThread().getPriority());
		System.out.println(car.getName() + "의 우선순위 : " + car.getPriority());
		System.out.println(plane.getName() + "의 우선순위 : " + plane.getPriority());
		System.out.println(tank.getName() + "의 우선순위 : " + tank.getPriority());
		
		System.out.println("--- 우선 순위 변경 후 ---");
		car.setPriority(Thread.MIN_PRIORITY); // 최소 우선 순위
		tank.setPriority(Thread.MAX_PRIORITY); // 최대 우선 순위
		
		System.out.println(car.getName() + "의 우선순위 : " + car.getPriority());
		System.out.println(plane.getName() + "의 우선순위 : " + plane.getPriority());
		System.out.println(tank.getName() + "의 우선순위 : " + tank.getPriority());	
		
		/*
		 * 메인 스레드가 종료되더라도 실행 중인 스레드가 하나라도 있으면 프로세스는 종료되지 않음 (스레드의 독립성)
		 * 
		 * main 스레드가 종료시 다른 스레드도 종료 시키게끔 하기 위해서는 setDaemon 을 통해 주종관계 설정을 해줘야함.
		 * 
		 * 주의점은 스레드중에 하나라도 setDaemon 으로 설정을 하지 않았다면 정상 작동 하지 않음.
		 * 스레드를 start() 시키기 전에 setDaemon 설정을 해줘야함. (우선순위도 마찬가지)
		 */
		
		car.setDaemon(true);
		plane.setDaemon(true);
		tank.setDaemon(true);
		
		car.start();
		plane.start();
		tank.start();
		
		System.out.println("메인 스레드 종료");
	}

}
