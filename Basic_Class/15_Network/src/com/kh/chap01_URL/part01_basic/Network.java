package com.kh.chap01_URL.part01_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class Network {
	
	/*
	 * InetAddress
	 * IP주소에 대한 정보를 가진 클래스
	 * 
	 * - ip : 10.10.10.10 4바이트로 이루어진 실제 주소
	 * - hostname : naver.com , daum.net , google.com (도메인명)
	 * 
	 * InetAddress 내부 메소드는 모두 static
	 */
	
	public void iNetTest() {
		try {
			InetAddress naver = InetAddress.getByName("naver.com");
			System.out.println(naver.getHostAddress());
			InetAddress[] arr = InetAddress.getAllByName("naver.com");
			for(InetAddress ip : arr) {
				System.out.println(ip.getHostAddress());
			}
			
			// 내 컴퓨터 ip주소 192.168.30.182 == localhost = 127.0.0.1 // 112.221.47.69
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(localhost.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * URL : 	인터넷 상에 존재하는 서버들의 자원(html , jpg , xml, json...) 들에 접근 할 수 있는 주소를 다루는 클래스
	 * 			실제 URL 자원 에 대한 객체를 생성하여 자원에 연결하거나 데이터를 읽어 올 수 있음(I/O 가능)
	 * 			로컬자원에 접근할 때 사용하는 클래스가 File 이었다면
	 * 			원격자원에 접근할 때 사용하는 클래스가 URL 이다.
	 * 
	 * (File : 객체 생성시 로컬상의 디렉토리명 + 파일명 제시)
	 * URL : 객체 생성시 접근하고자 하는 URL 주소값 제시
	 * URL 주소 : protocol + hostname + port + 자원경로(path) + 쿼리스트링(옵션)
	 * https://khedu.co.kr/upload/contents/mainBanner/2023110614155365392.jpg
	 * https:// => protocol
	 * khedu.co.kr => hostname
	 * :443 => port(생략됨)
	 * /upload/contents/mainBanner/2023110614155365392.jpg => 자원경로
	 * \src/com/kh/chap01_URL/part01_basic/Network.java => 자원경로
	 * 
	 * 프로토콜 ?	통신규약 http , https , ftp , smtp , ....
	 * 			네트워크 환경에서 서버와 클라이언트 간에 데이터 송수긴을 어떤식으로 할지 미리 표준화 한 규칙들의 집합.
	 * 
	 * 포트번호 ?	서비스번호 . 컴퓨터(서버)내에 특정 프로그램을 가리키는 논리적인 번호.
	 * 			포트 번호를 통해 각각 다른 프로그램을 제공해 줄 수 있음.
	 * 			--> 프로토콜에 대한 기본 포트는 생략이 가능. https-443 , http-80 , ftp-20
	 * 
	 * 자원경로 ?	도메인상의 서버에서 실제로 자원이 존재하는 경로.
	 */
	
	public void urlTest() {
		
		try {
			URL url = new URL("https://github.com/goodplan77/javastudy");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort() != -1 ? url.getPort() : url.getDefaultPort());
			System.out.println(url.getPath());
			System.out.println(url.getQuery()); // 사용자 입력값
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void urlConnection() {
		String address = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&ssc=tab.nx.all&query=%EC%9D%B4%EC%8A%A4%EB%9D%BC%EC%97%98+%EC%9D%B4%EB%9E%80&oquery=%EC%9D%B4%EC%8A%A4%EB%9D%BC%EC%97%98&tqi=im8h%2BspzLi0ssTrpFbCssssssrw-247062";
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			URL url = new URL(address); // 파일?
			
			/*
			 * URLConnection :	원격 서버와 통신하여 웹서버의 자원을 입력 할 수 있는 스트림을 가진 클래스.
			 * 					URL로 연결할 서버 자원을 기술하고 , URLConnection의 입력스트림을 통해 자원으로부터
			 * 					입출력이 가능함.
			 */
			
			URLConnection conn = url.openConnection(); // 추상클래스 ? address를 받아서? 스트림 통로?
			
			br = new BufferedReader(new InputStreamReader(conn.getInputStream())); // byte 기반 -> 파일 기반 -> 성능 향상을 위해 버퍼 리더 보조 스트림
			// conn.inputStream() 으로 웹서버 자원과 연결. (스트림 생성) - 바이트 기반 스트림
			// InputStreamReader : 바이트 스트림으로 읽어 들인 데이터를 문자로 바꿔주는 역할을 하는 "보조 스트림"
			// BufferedReader : 성능향상(빠른 입력) 을 위한 "보조 스트림"
			
			bw = new BufferedWriter(new FileWriter("search_naver.html"));
			
			String data = "";
			while((data = br.readLine()) != null) {
				bw.write(data);
				bw.newLine();
			}
			
			System.out.println("검색 완료");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
