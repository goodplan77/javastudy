package practice05_Network.TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		int port = 30025;
		String serverIP = null;
		Socket socket = null;

		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			socket = new Socket(serverIP, port);
			if (socket != null) {
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				Scanner sc = new Scanner(System.in);
				
				while(true) {
					System.out.println("서버에 보낼 내용 : ");
					String str = sc.nextLine();
					
					pw.println(str);
					
					if(str.equals("exit")) {
						System.out.println("연결 종료");
						break;
					}
				}
				
				pw.close();
				socket.close();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
