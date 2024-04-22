package practice05_Network.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPUser1 {
	
	public static void main(String[] args) {
		int port = 30025;
		try {
			DatagramSocket socket = new DatagramSocket(port);
			byte[] receiveData = new byte[1024];
			DatagramPacket clientPacket = new DatagramPacket(receiveData ,receiveData.length);
			
			socket.receive(clientPacket);
			
			System.out.println("클라이언트의 ip 주소 ? : " + clientPacket.getAddress().getHostAddress());
			System.out.println("클라이언트의 port 번호 ? : " + clientPacket.getPort());
			System.out.println("클라이언트에서 전달한 데이터 : " + receiveData);
			
			InetAddress clientAddress = clientPacket.getAddress();
			int clientPort = clientPacket.getPort();
			String str = "UDP 서버에서 보내는 데이터";
			
			byte[] data = str.getBytes();
			
			DatagramPacket packet = new DatagramPacket(data , data.length , clientAddress , clientPort);
			socket.send(packet);
			
			socket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
