package com.kh.chap04_sync.part01_synchronize.sync;

// 공유자원 (계좌)
// 2개의 ATM기가 하나의 Account에서 출금을 시도 하려는 상황
public class Account {
	
	private int balance = 3000; // 잔고
	
	public int getBalance() {
		return balance;
	}
	
	// 출금 메소드.
	/*
	 * 동기화 처리
	 * 객체 단위로 동기화처리 : account 객체를 임계영역으로 설정하게된다.
	 * 객체를 임계영역으로 지정하기 위한 방법으로는
	 * 1. 메소드를 synchronized로 만들기 ->	메소드 전체에 락을 걸고 , 메소드 종료시 락이 풀림.
	 * 2. synchronized block 사용하기 ->	동기화가 필요한 메소드의 일부에만 락을건다.
	 * 									임계영역이 아닌 지역까지는 모든 스레드에서 접근 가능 하기 때문에 좀 더 효율이 좋다.
	 */
	public /*synchronized*/ void withdraw(int money) {
		String threadName = Thread.currentThread().getName();
		System.out.println("[" + threadName + "]" +"현재 잔액은? : " + balance);
		synchronized (this) {
			if(money <= balance) {
				balance -= money; // 잔고 - 출금금액
				System.out.printf("[%s] %d원 출금 >> 잔고 : %d원\n" , threadName , money , balance);
			} else {
				System.out.printf("[%s] %d원 출금시도 >> 잔고가 다 떨어졌습니다.\n" , threadName , money);
			}
		}
	}

}
