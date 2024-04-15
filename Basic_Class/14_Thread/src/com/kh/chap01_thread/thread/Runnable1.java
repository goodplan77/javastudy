package com.kh.chap01_thread.thread;

// 1. Runnable 인터페이스 구현
public class Runnable1 implements Runnable{

	// 2. run 메소드 오버라이딩
	@Override
	public void run() {
		
		for(int i = 1 ; i <= 100 ; i++) {
			System.out.println(Thread.currentThread().getName() + "[" + i + "]");
		}
	}

}
