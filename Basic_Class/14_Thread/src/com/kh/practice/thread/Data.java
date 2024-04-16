package com.kh.practice.thread;

public class Data {

	private int value;
	private boolean isEmpty = true;

	public Data() {
	}

	public synchronized int getValue() {
		int value = 0;
		if (isEmpty) {
			try {
				throw new EmptyException("현재 입력된 값이 없습니다. 기다리십시오.");
			} catch (EmptyException e) {
				System.out.println(e.getMessage());
				try {
					wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}

		value = this.value;
		isEmpty = true;
		System.out.println("get value : " + value);
		System.out.println("값을 꺼냈습니다. value 가 비었습니다.");
		notify();

		return value;

	}

	public synchronized void setValue(int value) {

		try {
			// setValue 메서드 호출 후 반환된 key 값을 또 Provider가 가져 갔을때
			if (!isEmpty) {
				wait();
			}

			this.value = value;
			isEmpty = false;
			System.out.println("값이 입력되었습니다.");
			System.out.println("put value : " + value);
			notify();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
