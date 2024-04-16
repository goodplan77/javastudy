package com.kh.chap04_sync.part01_synchronize.run;

import com.kh.chap04_sync.part01_synchronize.sync.ATM;
import com.kh.chap04_sync.part01_synchronize.sync.Account;

public class Run {
	
	/*
	 * 동기화 ?
	 * 멀티 쓰레드 프로그램에서 스레드 간에 "경쟁상태"에 있는 "공유자원"에 대한 "임계영역"을 지정 해주는 것
	 * 
	 * 멀티 스레드 프로그램에서 여러 스레드가 "동시에" 하나의 "공유자원" 에 접근 하는 것을 "경쟁상태"라고 부름.
	 * 이를 방지하기 위해 하나의 공유자원에 접근 할 때는 하나의 스레드만 접근 할 수 있도록 통제해야 하는데 통제 하기 위해 해당
	 * 자원을 임계영역(통제영역) 으로 지정을 하고 이 통제를 하기 위해서는 "동기화" 가 필요함.
	 * 
	 * 동기화시 프로세스가 느려 질 수 있다.
	 */

	public static void main(String[] args) {
		
		Account acc = new Account();
		Runnable atm1 = new ATM(acc);
		Runnable atm2 = new ATM(acc);
		Runnable atm3 = new ATM(acc);
		Runnable atm4 = new ATM(acc);
		
		Thread th1 = new Thread(atm1, "ATM 1");
		Thread th2 = new Thread(atm2, "ATM 2");
		Thread th3 = new Thread(atm3, "ATM 3");
		Thread th4 = new Thread(atm4, "ATM 4");
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		
		/*
		 * 단순 동기화 처리시에는 synchronized 만으로 충분함.
		 * 단 , 스레드가 많은 환경에서는 스레드 컨트롤을 통해 직접 스레드를 제어 해줘야함.
		 * 
		 * 약 100개의 스레드가 공유자원에 접근 하려고 할때 100개의 스레드의 상태는 실행대기.
		 * 실행 상태에서는 공유자원에 대한 key를 획들 할 때 까지 계속 접근을 할 것임.
		 * 
		 * 이 문제점을 스레드 컨트롤을 통해 하나의 스레드가 공유 자원을 사용중인 동안에는 , 다른 스레드가 접근하지 못하게
		 * 다른 스레드들을 일시 정지시켜서 성능 저하를 막을 수 있음.
		 */
		
	}

}
