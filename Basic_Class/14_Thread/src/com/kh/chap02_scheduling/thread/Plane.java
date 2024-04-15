package com.kh.chap02_scheduling.thread;

public class Plane implements Runnable{
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
		for(int i = 0 ; i < 20 ; i++) {
			System.out.println("Plane flight...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // 현재 작동중인 스레드를 ms 시간 만큰 지연 시키는 메소드
		} 
	}

}
