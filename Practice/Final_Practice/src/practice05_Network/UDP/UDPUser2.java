package practice05_Network.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPUser2 {
	
	public static void main(String[] args) {
		int serverPort = 30025;
		try {
			InetAddress serverAddress = InetAddress.getByName("localhost");
			DatagramSocket socket = new DatagramSocket();
			String message = "UDP 클라이언트에서 데이터 요청 보냄";
			byte[] sendData = message.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData , sendData.length , serverAddress , serverPort);
			socket.send(sendPacket);
			
			socket.receive(sendPacket);
			
			String receiveData = new String(sendPacket.getData(), 0 , sendPacket.getLength());
			System.out.println("서버로 부터 수신 받은 데이터 : " + receiveData);
			
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
