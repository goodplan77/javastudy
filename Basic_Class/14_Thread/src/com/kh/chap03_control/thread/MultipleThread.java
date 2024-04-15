package com.kh.chap03_control.thread;

public class MultipleThread implements Runnable{
	
	private int number;
	
	public MultipleThread(int number) {
		this.number=number;
	}

	@Override
	public void run() {
		int i = 1;
		while(true) {
			if((number * i) > 100) {
				System.out.println("[" + number + "배수 쓰레드 종료]");
				return;
			} 
			System.out.println("[" + number + "배수 쓰레드 - " + (number * i) + "]");
			i++;
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
