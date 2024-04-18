package com.kh.chap02_TCP.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
	
	/*
	 *  클라이언트용 TCP 소켓 프로그래밍 순서
	 *  
	 *  1) 서버의 IP주소와 서버가 정한 포트 번호를 매개변수로 하는 소켓 객체 생성. ==> 서버로 연결요청 보내는 코드
	 *  
	 *  2) 서버와의 입출력 스트림 오픈
	 *  
	 *  3) 보조스트림을 통해 성능 개선
	 *  
	 *  4) 입출력 코드 작성 (I/O)
	 *  
	 *  5) 통신 종료(스트림 및 소켓 close)
	 */
	
	public static void main(String[] args) {
		
		int serverPort = 30025; // 서버의 포트 번호
		String str = ""; // 요청을 보낼 문자열
		String serverIp = null; // "192.168.30.182"; // 서버 IP
		Socket socket = null;
		
		try {
			serverIp = InetAddress.getLocalHost().getHostAddress(); // "192.168.30.182";
			
			// 서버에 연결 요청 보내기 == Socket 객체 생성
			socket = new Socket(serverIp , serverPort); // 서버의 ip 주소와 서버의 포트 번호 제시 해야함.
			// 서버는 accept() 함수가 호출 되면서 대기 상태가 종료. accept()의 반환 값으로 클라이언트의 정보가 담긴 소켓객체 반환.
		
			// 서버와 연결 실패시 null값 반환.
			if(socket != null) {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream() , true);
				
				Scanner sc = new Scanner(System.in);
				
				while(true) {
					System.out.print("서버에 보낼 내용 : ");
					str = sc.nextLine();
					
					pw.println(str);
	
					if(str.equals("exit")) {
						System.out.println("연결 종료");
						break;
					}
					
					String responseMessage = br.readLine();
					System.out.println("응답 받은 메시지 : " + responseMessage);
				}
				

				// 5) 통신 종료
				pw.close();
				br.close();
				socket.close();
				
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
