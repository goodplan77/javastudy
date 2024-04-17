package com.kh.practice.network.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPSearch {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("호스트명 : ");
			String hostname = sc.nextLine();
			InetAddress[] arr = InetAddress.getAllByName(hostname);
			System.out.println(hostname + "는 " + arr.length + "개의 IP주소를 가지고 있습니다.");
			for(int i = 0 ; i <arr.length ; i++) {
				System.out.println((i+1) + "번 IP = " + arr[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

	}

}
