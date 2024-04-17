package com.kh.practice.network.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ApiTest {

	public static void main(String[] args) {
		
		// 요청 주소
		String requestURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";
		
		// 필수 요청 변수 - 개인 인증키 , 측정소명 , 데이터 기간
		final String serviceKey = "BZSEc7GLbvkPc7MOf2QZv3JC5dNW%2BA5fB69IoeN%2BAYpw%2BDHhiUXXCYoXqhcbjvLQiydBOSFTf9iYRC44Iddrvg%3D%3D";
		String stationName = "종로구";
	
		try {
			
			requestURL += "?serviceKey=" + URLEncoder.encode(serviceKey , "UTF-8");
			requestURL += "&stationName=" + URLEncoder.encode(stationName , "UTF-8");
			requestURL += "&dataTerm=" + "DAILY";

			URL url = new URL(requestURL);
			URLConnection conn = url.openConnection();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
