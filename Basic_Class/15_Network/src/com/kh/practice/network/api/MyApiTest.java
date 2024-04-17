package com.kh.practice.network.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyApiTest {

	public static void main(String[] args) {
		
		// 요청 주소
		String requestURL = "https://openapi.gg.go.kr/gameProvsnIndutype";
		
		// 필수 입력값 확인
		// 인증키?
		final String serviceKey = "1cf3440721b54b47ad783a21c82fef39";
		
		requestURL += "?serviceKey=" + serviceKey;
		
		try {
			URL url = new URL(requestURL);
			URLConnection conn = url.openConnection();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new FileWriter("PC방 정보.xml"));
			
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
				bw.write(line);
			}
			
			br.close();
			bw.close();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
