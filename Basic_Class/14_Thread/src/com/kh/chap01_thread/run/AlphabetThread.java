package com.kh.chap01_thread.run;

public class AlphabetThread {
	
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.println("[" + name + " 시작]");
				for(int i = 0 ; i < 26 ; i ++)
				{
					System.out.println("[" + name + " : " + (char)(i + 'A') + "]");
				}
				System.out.println("[" + name + " 종료]");
				
			}});
		
		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.println("[" + name + " 시작]");
				for(int i = 0 ; i < 26 ; i ++)
				{
					System.out.println("[" + name + " : " + (char)(i + 'a') + "]");
				}
				System.out.println("[" + name + " 종료]");
			}});
		
		th1.setName("대문자 쓰레드");
		th2.setName("소문자 쓰레드");
		
		th1.start();
		th2.start();
	}
}
