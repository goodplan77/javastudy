package practice05_Network.TCP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 1. 연결 요청 
 * 2. accept
 * 3. 일반 소켓 활성화
 * 4. 클라이언트로 부터 받은 메시지 출력
 */

public class TCPServer {

	public static void main(String[] args) {
		int port = 30025;
		ServerSocket server = null;

		try {
			server = new ServerSocket(port);
			System.out.println("서버 소켓 생성 완료");
			while(true) {
				System.out.println("서버 대기중");
				Socket client = server.accept();
				System.out.println("연결된 클라이언트 IP : " + client.getInetAddress().getHostAddress());
				System.out.println("연결된 클라이언트 PORT : " + client.getPort());
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String message = reader.readLine();
				System.out.println(client.getInetAddress().getHostAddress() + " 가 보낸 메세지 : " + message);
				
				reader.close();
				client.close();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
