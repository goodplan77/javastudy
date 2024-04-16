package com.kh.chap05_threadPool.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
	
	/*
	 * 스레드풀 ?
	 * 고정된 크기의 스레드를 미리 만들어서 저장 시켜두는 공간.
	 * 사용자의 "요청"이 들어 왔을때 만들어둔 스레드를 제공 하며 , 사용 완료된 스레드는 다시 스레드 풀로 돌아가서 자원을 반납 시켜
	 * 항상 일정 크기의 스레드를 유지 시키는 구조. 즉 시스템 자원을 효율적으로 사용 할 수 있다.
	 * 
	 * 스레드풀의 구성 요소
	 * 
	 * 1) 스레드풀 : 정해진 개수의 스레드를 보관 하는 저장 공간
	 * 
	 * 2) 작업 큐 : 작업을 보관 하는 저장공간. 스레드풀에 요청이 들어오면 작업 큐에 작업내용이 추가됨
	 * 			// stack(LIFO) , Queue(FIFO) , 작업 => 사용자의 요청
	 * 
	 * 3) 작업처리기 : 작업을 스레드에 할당 하고 실행 하는 역할의 객체 
	 */
	
	private final WorkerThread[] workers; // 스레드풀
	private final int poolSize; // 생성할 스레드풀의 사이즈
	private final BlockingQueue<Runnable> taskQueue; // 작업큐(고정된 크기를 가짐)
	// BlockingQueue ? 성능 향상을 위한 Block 기능이 추가된 Queue
	
	public ThreadPool(int poolSize) {
		this.poolSize = poolSize;
		workers = new WorkerThread[poolSize]; // 워커 스레드 객체 배열 생성 및 할당
		taskQueue = new ArrayBlockingQueue<>(poolSize); // 스레드풀 만큼의 크기를 가진 작업큐 생성. (고정크기)

		for(int i = 0 ; i < poolSize ; i++) {
			workers[i] = new WorkerThread();
			workers[i].start();
		}
	}
	
	public void submit(Runnable task) {
		try {
			// queue에 데이터가 가득 찬 경우 block 했다가 추가됨.
			taskQueue.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private class WorkerThread extends Thread {
		
		// 작업 처리기 (run)
		
		public void run() {
			
			while(true) {
				Runnable task;
				try {
					// take? 작업큐에서 작업을 빼오는 메소드 + 작업큐에 데이터가 없다면 추가되기 전까지 block되는 메소드
					task = taskQueue.take(); // 내가 처리 해야할 "작업"
					task.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}
	}

}
