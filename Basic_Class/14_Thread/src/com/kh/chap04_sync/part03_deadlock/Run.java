package com.kh.chap04_sync.part03_deadlock;

import com.kh.chap04_sync.part02_consumerAndProducer.thread.Buffer;

public class Run {
	
	/*
	 * 교착 상태 ? 각각의 스레드가 서로 임계영역에 접근 할 수 있는 key를 얻지 못하고 , key를 얻기 위해 무한 대기에 돌입하는것.
	 * 
	 */
	
	// 공유자원1
	private static Buffer buffer1 = new Buffer();
	
	// 공유자원2
	private static Buffer buffer2 = new Buffer();
	
	public static void main(String[] args) {
		
		// 첫번째 스레드 : buffer1을 가지고 작업을 한 후 , buffer2를 가지고 이어서 작업
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (buffer1) {
					System.out.println("Th1이 buffer1 에 대한 key를 획득");
					
					System.out.println("thread1 : th2번이 buffer2에 대한 key를 반납하기 전까지 대기중");
					
					synchronized (buffer2) {
						System.out.println("Th1이 buffer2 에 대한 key를 획득");
					}
				}
			}
			
		});
		
		// 두번째 스레드 : buffer2을 가지고 작업을 한 후 , buffer1를 가지고 이어서 작업
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (buffer2) {
					System.out.println("Th2이 buffer2 에 대한 key를 획득");
					
					System.out.println("thread2 : th1번이 buffer1에 대한 key를 반납하기 전까지 대기중");
				
					synchronized (buffer1) {
						System.out.println("Th2이 buffer1 에 대한 key를 획득");
					}
				}
			}
			
		});
		
		// 교착 상태 해결 방법
		// 1. key 획득 순서 변경하기.
		//	=> synchronized 블럭 순서를 동일하게 맞춰주기
		// 2. threadControl : notify , wait 등을 통해 동기화 블럭안에서 스레드의 흐름을 제어하기.
		
		th1.start();
		th2.start();
	}

}
