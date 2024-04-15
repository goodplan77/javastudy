package com.kh.practice.thread;

public class Provider implements Runnable{
	
	private Data data;
	
	public Provider (Data data) {
		this.data=data;
	}

	@Override
	public void run() {
	}

}
