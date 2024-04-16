package com.kh.chap04_sync.part02_consumerAndProducer.run;

import com.kh.chap04_sync.part02_consumerAndProducer.thread.Buffer;
import com.kh.chap04_sync.part02_consumerAndProducer.thread.Consumer;
import com.kh.chap04_sync.part02_consumerAndProducer.thread.Producer;

public class Run {

	public static void main(String[] args) {
		
		Buffer buffer = new Buffer();
		Thread producer = new Producer(buffer);
		Thread consumer = new Consumer(buffer);
		
		producer.start();
		consumer.start();
		
		try {
			producer.join();
			/*
			 * join(mills) : 지정 된 시간이 지나거나 , 스레드의 작업이 완료 되기 전까지 스레드를 실행키기고 , 현재 스레드는 대기
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("메인 스레드 종료");

	}

}
