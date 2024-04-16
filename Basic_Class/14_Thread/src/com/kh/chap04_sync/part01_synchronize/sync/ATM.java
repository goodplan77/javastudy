package com.kh.chap04_sync.part01_synchronize.sync;

public class ATM implements Runnable{
	
	private Account acc;
	
	public ATM(Account acc) {
		this.acc=acc;
	}

	@Override
	public void run() {
		// 계좌의 잔고가 0원 보다 많을때,
		// 100원 or 200원 or 300원 씩 출금
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random()*3+1)*100;
			acc.withdraw(money);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName() + "종료");
	}

}
