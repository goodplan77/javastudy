package com.kh.chap04_sync.part02_consumerAndProducer.thread;


// 생산자 / 소비자
public class Buffer {
	
	// 생산 및 소비 되는 상품
	private int bread;
	
	// 플래그 변수 (객체의 상태를 저장하고 흐름을 제어 하기 위한 변수)
	private boolean isEmpty = true;
	
	public void setData(int data) {
		synchronized (this) {	
			// 데이터가 비어 있지 않다면 더 생산하지 않다도 되므로 대기.
			if(!isEmpty) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			this.bread = data;
			isEmpty = false;
			System.out.println("생산자가 " + data + "번째 빵 생산을 완료 했습니다.");
			
			notify(); // 동기화된 블럭 안에서 대기중인 다른 쓰레드를 깨우는 역할
		}
		
	}
	
	public void getData() {
		synchronized (this) {
			// 아직 빵 생산이 완료 되지 않았다면 , 소비자는 대기 상태로 전환.
			if(isEmpty) {
				try {
					wait(); // wait(mills) : 동기화된 블록 안에서 사용하며 , 지정된 시간이 지나거나 다른 스레드에 의해 호출되면 실행 대기 상태로 전환됨.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("소비자 가 " + this.bread + "번째 빵 소비를 완료 했습니다.");
			isEmpty = true;
			notify(); // 생산자에게 빵소비를 완료 했다고 알림.
		}
		
	}

}
