package com.kh.chap04_sync.part02_consumerAndProducer.thread;

public class Producer extends Thread{
	// 빵을 계속 만드는 스레드
	
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer=buffer;
	}
	
	@Override
	public void run() {
		
		for(int i = 1 ; i <= 10 ; i++) {
			
			buffer.setData(i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
