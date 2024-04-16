package com.kh.chap04_sync.part02_consumerAndProducer.thread;

public class Consumer extends Thread{
	
	private Buffer buffer;
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		for(int i = 1 ; i <=10 ; i++) {
			buffer.getData();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
