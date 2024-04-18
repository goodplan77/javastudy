package com.kh.chap02_TCP.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * TCP(Transmission Control Protocol)
 *  -	서버와 클라이언트 역할이 있음.
 *  -	연결 지향형 통신을 지원. 서버와 클라이언트 간에 연결이 되어 있어야 데이터를 송수신함.
 *  	(서버가 먼저 실행되면서 클라이언트의 요청을 대기)
 *  -	신뢰성 있고 안전한 데이터 전달이 가능
 *  -	TCP 방식은 클라이언트 와 서버간에 "연결" 이 유지 되고 있으므로 "실시간" 으로 "소켓" 을 통해 데이터를 송수신이 가능.
 *  -	채팅, 이메일전송, 웹브라우징, 그 외에 안정적인 데이터 송수신이 필요한 거의 모든 작업에 사용 되는 프로토콜.
 *  
 *  소켓
 *  -	클라이언트와 서버간 "통신"에 사용되는 객체.
 *  -	소켓이 소유한 IP번호와 포트번호를 통해 특정 호스트의 어떤 프로세스 소켓인지 식별.
 *  -	소켓에 지정된 ip번호와 포트번호를 통해 찾아간 마지막 지점을 끝단(endpoint) 라고 부름.
 *  -	입출력을 위한 Input/OutputStream을 가지고 있음.
 *  
 *  ServerSocket
 *  -	서버에서 생성하는 소켓으로 클라이언트의 연결요청이 들어오기전까지 대기하다가 , 요청이 들어오면 소켓 객체를 생성해줌
 *  	생성된 소켓을 통해 서버 - 클라이언트간의 데이터 송수신(통신)이 가능.
 *  -	사용법 : ServerSocket server = new ServerSocket(int 포트번호);
 *  
 *  (Client)Socket
 *  -	클라이언트에서 서버에 요청을 하거나 , 서버에서 클라이언트의 요청을 받았을때 생성해주는 클래스.
 *  -	IP주소와 포트번호를 통해 ServerSocket 에 연결요청을 보낸다.
 *  -	사용법 : Socket socket = new Socket(String ip주소 , int 포트번호);
 */

public class TCPServer {
	
	/*
	 * 서버의 연결 순서
	 * 1) 서버의 소켓 객체 생성
	 * 2) 클라이언트의 접속 요청을 기다림.
	 * 3) 요청이 오면 수락
	 * 4) 클라이언트의 정보를 저장
	 * 5) 클라이언트의 정보를 통해서 출력 스트림 생성
	 * 6) 클라이언트의 정보를 통해서 입력 스트림 생성
	 * 7) I/O (입출력 처리)
	 * 8) 통신 종료 (사용한 자원 반납)
	 */
	
	public static void main(String[] args) {
		// 1) 서버의 소켓 객체 생성
		ServerSocket server = null;
		int port = 30025; // 1024 ~ 65535 의 범위의 포트를 사용하는 걸 추천.
		
		try {
			server = new ServerSocket(port); // 매개 변수 미 지정시 랜덤으로 포트 번호 지정
			
			System.out.println("서버 소켓 객체 생성 완료");
			
			// 클라이언트의 요청을 처리 한 후 프로세스가 끊기지 않게 무한 반복
			int count = 0;
			while(true) {
				
				// 2) + 3) 클라이언트 접속 요청을 기다리고 요청이 오면 수락
				System.out.println("클라이언트 대기중");
				Socket client = server.accept(); // 클라이언트의 요청이 들어오기전 까지 대기. 요청이 들어오면 소켓 객체를 생성 후 반환
			
				// 4) 클라이언트 정보 저장
				System.out.println((++count) + "번째 클라이언트가 접속됨.");
				System.out.println("연결된 클라이언트의 IP : " + client.getInetAddress().getHostAddress());
				System.out.println("연결된 클라이언트의 PORT : " + client.getPort());
				
				// 5) + 6) 연결된 클라이언트와 입출력 스트림 생성.
				PrintWriter pw = new PrintWriter(client.getOutputStream() , true);
				// 데이터를 print , println함수로 출력 가능.
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				Scanner sc = new Scanner(System.in);
				
				// 7) IO
				while(true) {
					String message = reader.readLine(); // 사용자의 입력이 있을때 까지 block (I/O BLOCK)
					if(message == null || message.equals("exit")) {
						System.out.println("클라이언트 접속 종료");
						break;
					}
					
					System.out.println(client.getInetAddress().getHostAddress() + "가 보낸 메시지 : " + message);
					
					System.out.print("클라이언트에게 보낼 메세지 : ");
					String responseMessage = sc.nextLine();
					
					pw.println(responseMessage); // 한줄 단위로 값을 출력
					//pw.flush();
				}
				
				pw.close();
				reader.close();
				client.close();
			}
			
			// server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
