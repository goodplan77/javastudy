package com.kh.practice.thread;

public class Customer extends Thread{

	private Data data;

	public Customer(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			data.getValue();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
